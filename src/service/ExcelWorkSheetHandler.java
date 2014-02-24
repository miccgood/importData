/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

/**
 *
 * @author tanet-t
 */
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;

/**
 * Generic Excel WorkSheet handler
 * 
 * @author <a href="mailto:jeeva@myjeeva.com">Jeevanandam M.</a>
 */
public class ExcelWorkSheetHandler<T> implements SheetContentsHandler {

	private static final Log LOG = LogFactory.getLog(ExcelWorkSheetHandler.class);

	private final static String HEADER_KEY = "HEADER";
	private boolean verifiyHeader = true;
	private int skipRows = 0;
	private int HEADER_ROW = 0;
	private int currentRow = 0;
	private List<T> valueList;
	private Class<T> type;
	private Map<String, String> cellMapping = null;
	private T objCurrentRow = null;
	private T objHeader = null;

	/**
	 * Constructor
	 * 
	 * <br><br><strong>For Example:</strong> Reading rows (zero based) starting from Zero<br>
	 * <code>ExcelWorkSheetHandler&lt;PersonVO> workSheetHandler = new ExcelWorkSheetHandler&lt;PersonVO>(PersonVO.class, cellMapping);</code>
	 * 
	 * @param type
	 *            a {@link Class} object
	 * @param cellMapping
	 *            a {@link Map} object
	 */
	public ExcelWorkSheetHandler(Class<T> type,Map<String, String> cellMapping) {
		this.type = type;
		this.cellMapping = cellMapping;
		this.valueList = new ArrayList<T>();
	}

	/**
	 * Constructor
	 * 
	 * <br><br><strong>For Example:</strong> Reading rows (zero based) starting from Row 11<br>
	 * <code>ExcelWorkSheetHandler&lt;PersonVO> workSheetHandler = new ExcelWorkSheetHandler&lt;PersonVO>(PersonVO.class, cellMapping, 10);</code>
	 *  
	 * @param type
	 *            a {@link Class} object
	 * @param cellMapping
	 *            a {@link Map} object
	 * @param skipRows
	 *            a <code>int</code> object - Number rows to skip (zero based).
	 *            default is 0	 
	 */
	public ExcelWorkSheetHandler(Class<T> type, Map<String, String> cellMapping, int skipRows) {
		this.type = type;
		this.cellMapping = cellMapping;
		this.valueList = new ArrayList<T>();
		this.skipRows = skipRows;
	}

	/**
	 * Returns Value List (List&lt;T>) read from Excel Workbook, Row represents one Object in a List.
	 * 
	 * <br><br><strong>For Example:</strong><br>
	 * <code>List&lt;PersonVO> persons = workSheetHandler.getValueList();</code>
	 * 
	 * @return List&lt;T>
	 */
	public List<T> getValueList() {
		return valueList;
	}

	/**
	 * Returns Excel Header check state, default it is enabled
	 * 
	 * @return boolean
	 */
	public boolean isVerifiyHeader() {
		return verifiyHeader;
	}

	/**
	 * To set the Excel Header check state, default it is enabled
	 * 
	 * @param verifiyHeader a boolean 
	 */
	public void setVerifiyHeader(boolean verifiyHeader) {
		this.verifiyHeader = verifiyHeader;
	}

	/**
	 * @see org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler#startRow(int)
	 */
	@Override
	public void startRow(int rowNum) {
		this.currentRow = rowNum;

		if (verifiyHeader) {
			objHeader = this.getInstance();
		}

		if (rowNum > HEADER_ROW && rowNum >= skipRows) {
			objCurrentRow = this.getInstance();
		}
	}

	/**
	 * @see org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler#cell(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void cell(String cellReference, String formattedValue) {

		if (currentRow >= skipRows) {
			if (StringUtils.isBlank(formattedValue)) {
				return;
			}

			if (HEADER_ROW == currentRow && verifiyHeader) {
				this.assignValue(objHeader, getCellReference(cellReference),
						formattedValue);
			}

			this.assignValue(objCurrentRow, getCellReference(cellReference),
					formattedValue);
		}
	}

	/**
	 * @see org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler#endRow()
	 */
	@Override
	public void endRow() {
		if (HEADER_ROW == currentRow && verifiyHeader && null != objHeader) {
			if (!checkHeaderValues(objHeader)) {
				throw new RuntimeException(
						"Header values doesn't match, so invalid Excel file!");
			}
		}

		if (currentRow >= skipRows) {
			if (null != objCurrentRow && isObjectHasValue(objCurrentRow)) {
				// Current row data is populated in the object, so add it to
				// list
				this.valueList.add(objCurrentRow);
			}

			// Row object is added, so reset it to null
			objCurrentRow = null;
		}
	}

	/**
	 * Currently not considered for implementation
	 * 
	 * @see org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler#headerFooter(java.lang.String,
	 *      boolean, java.lang.String)
	 */
	@Override
	public void headerFooter(String text, boolean isHeader, String tagName) {
		// currently not consider for implementation
	}

	private String getCellReference(String cellReference) {
		if (StringUtils.isBlank(cellReference)) {
			return "";
		}

		return cellReference.split("[0-9]*$")[0];
	}

	private void assignValue(Object targetObj, String cellReference,
			String value) {
		if (null == targetObj || StringUtils.isEmpty(cellReference)
				|| StringUtils.isEmpty(value)) {
			return;
		}
                String propertyName = this.cellMapping.get(cellReference);
            if (null == propertyName) {
                LOG.error("Cell mapping doesn't exists!");
            } else {
                    try {
                        PropertyUtils.setSimpleProperty(targetObj, propertyName, value);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(ExcelWorkSheetHandler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(ExcelWorkSheetHandler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchMethodException ex) {
                        Logger.getLogger(ExcelWorkSheetHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
	}

	private T getInstance() {
            try {
                return type.newInstance();
            } catch (InstantiationException ie) {
                LOG.error(ie.getMessage());
            } catch (IllegalAccessException iae) {
                LOG.error(iae.getMessage());
            } catch (Exception ex){
                return null;
            }
            return null;
	}

	/**
	 * To check generic object of T has a minimum one value assigned or not
	 */
	private boolean isObjectHasValue(Object targetObj) {
		for (Map.Entry<String, String> entry : cellMapping.entrySet()) {
			if (!StringUtils.equalsIgnoreCase(HEADER_KEY, entry.getKey())) {
				if (StringUtils.isNotBlank(getPropertyValue(targetObj,
						entry.getValue()))) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkHeaderValues(Object targetObj) {
		boolean compareSuccess = true;
		if (cellMapping.containsKey(HEADER_KEY)) {
			List<String> valueToCheck = Arrays.asList(cellMapping.get(
					HEADER_KEY).split(","));

			for (Map.Entry<String, String> entry : cellMapping.entrySet()) {
				if (!StringUtils.equalsIgnoreCase(HEADER_KEY, entry.getKey())) {
					String value = getPropertyValue(targetObj, entry.getValue());
					LOG.debug("Comparing header value from excel file: "
							+ value);
					if (!valueToCheck.contains(value)) {
						compareSuccess = false;
						break;
					}
				}
			}
		} else {
			LOG.warn("HEADER_KEY doesn't exists");
		}
		return compareSuccess;
	}

	private String getPropertyValue(Object targetObj, String propertyName) {
		String value = "";
		if (null == targetObj || StringUtils.isBlank(propertyName)) {
			LOG.error("targetObj or propertyName is null, both require to retrieve a value");
			return value;
		}
                if (PropertyUtils.isReadable(targetObj, propertyName)) {
                    Object v = null;
                    try {
                        v = PropertyUtils.getSimpleProperty(targetObj,
                                propertyName);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(ExcelWorkSheetHandler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(ExcelWorkSheetHandler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchMethodException ex) {
                        Logger.getLogger(ExcelWorkSheetHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (null != v && StringUtils.isNotBlank(v.toString())) {
                        value = v.toString();
                    }
                } else {
                    LOG.error("Given property (" + propertyName
                            + ") is not readable!");
                }
		return value;
	}
}