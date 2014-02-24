/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Import;

import Entity.ERP_AC.AcAccount;
import Entity.ERP_AC.AcCounter;
import Entity.ERP_FI.FiCapital;
import Entity.ERP_FI.FiCapitalFounder;
import Entity.ERP_FI.FiFund;
import Entity.ERP_SH.FwSequenceGenerator;
import Entity.ERP_SH.ShDepartment;
import Entity.ERP_SH.ShEnterprise;
import Entity.ERP_SH.ShFormRunning;
import Entity.ERP_SH.ShPerson;
import Entity.ERP_SH.ShPlan;
import Entity.ERP_SH.ShSource;
import Entity.ERP_SH.ShSubAccount;
import GUI.TestGUI;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JTextArea;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.DAO;
import service.CacheDao;

/**
 *
 * @author tanet-t
 */
public abstract class ImportData {
    protected DAO dao ; 
    protected CacheDao cacheDao ; 
    protected StringBuffer validationError ; 
    protected StringBuffer validationWarn ; 
    protected final List<StringBuffer> validationErrorList = new ArrayList<>();
//    public static final String STRING_PIPE = "|";
//    public static final String STRING_DOUBLE_PIPE = "||";
    public static final String STRING_ERROR = "ERROR";
    public static final String STRING_SPACE = " ";
    public static final String STRING_A = "A";
    public static final String STRING_B = "B";
    public static final String STRING_C = "C";
    public static final String STRING_D = "D";
    public static final String STRING_F = "F";
    public static final String STRING_I = "I";
    public static final String STRING_N = "N";
    public static final String STRING_M = "M";
    public static final String STRING_P = "P";
    public static final String STRING_R = "R";
    public static final String CREATE_USER_ID = "CONVERT-JAVA";
    public static final String CREATE_PROG = TestGUI.getFileName();
    protected final JTextArea log;
    protected boolean commit = true;
    protected static final String FILE_NAME = TestGUI.getFileName();
    protected static final Date NOW;
    protected static final Map<Integer, String> mapStringValidation = new HashMap<>();
    protected final Integer enterpriseId;
    protected final int START_ROW;
    protected boolean IS_SUCCESS = true;
    protected static final Map<String, Locale> mapPattern = new HashMap<>();
    protected static final Locale loacaleThai = new Locale("th","th");  
    private static boolean stop;
    protected Integer businessUnitId12 ;
    static {
        Calendar c = Calendar.getInstance();
        NOW = c.getTime();
        
        mapPattern.put("dd/MM/yyyy", loacaleThai);
        mapPattern.put("dd/MMMM/yyyy", loacaleThai);
        mapPattern.put("yyyy-MM-dd", loacaleThai);
        mapPattern.put("yyyy-MMMM-dd", loacaleThai);
        mapPattern.put("dd MMM yy", loacaleThai);
        
//        2556-07-02
    }
    public ImportData(int startRow) {
        dao = new DAO();
        cacheDao = new CacheDao();
        log = TestGUI.getInstance();
        enterpriseId = getEnterpriseId();
        START_ROW = startRow;
        this.businessUnitId12 = cacheDao.findDepartIdmentByFullCodeCache("12");
    }
    
    public void setStop(boolean stop){
        ImportData.stop = stop;
    } 
    public boolean getStop(){
        return ImportData.stop;
    } 
    public List<StringBuffer> processData(XSSFWorkbook workbook, String selected){
        XSSFSheet sheet = workbook.getSheet(selected);
//        int lastRowNum = sheet.getLastRowNum();

        logClear();
        int lastRowNum = getSheetRowCount(sheet);
        Long start = Calendar.getInstance().getTimeInMillis()/1000;
        logln(selected + " ประมวลข้อมูล " + lastRowNum + " แถว ");
        try{
            dao.startTransaction();
            cacheDao.startTransaction();
            logln("กำลังเชื่อมต่อฐานข้อมูล และ กำหนดค่าเริ่มต้นโปรแกรม");
//            loadMaxAcCounter(false);
//            loadMaxFwSequenceGenerator(false);
            logln("เริ่ม " + this.getClass().toString() + " ที่ ROW " + (START_ROW + 1));
            ImportData.stop = false;
            for (int index = START_ROW; index < (START_ROW + lastRowNum); index++) {
                if(ImportData.stop){
                    this.commit = false;
                    break;
                }
                threadProcess(sheet, index, lastRowNum);

                TestGUI.refresh();
                BigDecimal lastRowNumBig = new BigDecimal(lastRowNum - START_ROW);
                BigDecimal indexBig = new BigDecimal(index - START_ROW + 1);
                BigDecimal res = indexBig.divide(lastRowNumBig, MathContext.DECIMAL64);
                TestGUI.setProcessBar(res.multiply(new BigDecimal(100)).intValue());
            }
        
            if(IS_SUCCESS){
                validationErrorList.add(new StringBuffer("ไม่พบข้อผิดพลาด"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
//            if(this.commit){
//                loadMaxAcCounter(true);
//                loadMaxFwSequenceGenerator(true);
//            }
            if(this.commit){
                logln(validationErrorList.toString()).logln("กำลัง COMMIT ข้อมูล " + lastRowNum + "Row ลงฐานข้อมูล ");
            }else{
                logln( "ROLLBACK" );
            }
            
            dao.commitTransaction(this.commit);
            cacheDao.commitTransaction(this.commit);
            dao.closeConnection();
            cacheDao.closeConnection();
        }
        Long stop = Calendar.getInstance().getTimeInMillis()/1000;
        logln(this.commit ? "COMMIT" : "ROLLBACK" );
        logln("ใช้เวลาทั้งหมด " + ((stop - start) / 60) + " นาที " + ((stop - start) % 60) + " วินาที" );
        return validationErrorList;
    }
    
    abstract protected int getSheetRowCount(XSSFSheet sheet);
    abstract protected void threadProcess(XSSFSheet sheet, int index, int lastRowNum);
    
    private Integer getEnterpriseId(){
        List<ShEnterprise> list = dao.getEnterprises();
        if (list != null && !list.isEmpty()) {
            ShEnterprise enterpriseDao = list.get(0);
            return enterpriseDao.getEnterpriseId();
        }
        return null;
    }
    protected FiCapital createFiCapital(Integer departmentId, FiFund fundDao, String capitalCode, String capitalName, String interestType, String capitalDesc, Date setupDate, String note, int accountId, int sourceId, Integer planId, BigDecimal balance){
        FiCapital capital = new FiCapital() ;

        capital.setBusinessUnitId(this.businessUnitId12);
        capital.setDepartmentId(departmentId);
        capital.setFundId(fundDao);
        capital.setCapitalCode(capitalCode);
        capital.setCapitalName(capitalName);
        capital.setInterestType(interestType);
        capital.setCapitalDesc(capitalDesc);
        capital.setSetupDate(setupDate);
        capital.setNote(note);
        capital.setAccountId(accountId);
        capital.setSourceId(sourceId);
        capital.setPlanId(planId);
        capital.setSetupBalance(balance);
        capital.setBalance(balance);
        capital.setIsCancel(STRING_N);
        capital.setIsLockUpdate(STRING_N);
        capital.setLastUpdProg(CREATE_PROG);	
        capital.setLastUpdTime(NOW);	
        capital.setLastUpdUserId(CREATE_USER_ID);	
        capital.setCreateProg(CREATE_PROG);	
        capital.setCreateTime(NOW); 
        capital.setCreateUserId(CREATE_USER_ID);
        capital.setLastUpdVersion(1);
        dao.createFiCapital(capital);
        return capital;
    }
    protected ShPerson createShPerson(String firstName, String address, Integer businessUnitId){
        ShPerson person = new ShPerson();
        person.setPersonType("P");
        person.setFirstName(firstName);
        person.setResidentAddressSource(STRING_N);
        person.setShipAddressSource(STRING_N);
        person.setIsShipRecipientAuto(STRING_N);
        person.setShipRecipient(firstName);
        person.setShipAddressLine1(address);
        person.setIsCancel(STRING_N);
        person.setIsLockUpdate(STRING_N);
        person.setBusinessUnitId(this.businessUnitId12);
        person.setLastUpdProg(CREATE_PROG);	
        person.setLastUpdTime(NOW);	
        person.setLastUpdUserId(CREATE_USER_ID);	
        person.setCreateProg(CREATE_PROG);	
        person.setCreateTime(NOW); 
        person.setCreateUserId(CREATE_USER_ID);	
        person.setLastUpdVersion(1);
        dao.createShPerson(person);
        return person;
    }
    
    protected FiCapitalFounder createFiCapitalFounder(Integer capitalId, Integer personId){
        FiCapitalFounder capitalFounder = new FiCapitalFounder();
        capitalFounder.setCapitalId(capitalId);
        capitalFounder.setPersonId(personId);
        capitalFounder.setIsCancel(STRING_N);
        capitalFounder.setIsLockUpdate(STRING_N);
        capitalFounder.setLastUpdProg(CREATE_PROG);	
        capitalFounder.setLastUpdTime(NOW);	
        capitalFounder.setLastUpdUserId(CREATE_USER_ID);	
        capitalFounder.setCreateProg(CREATE_PROG);	
        capitalFounder.setCreateTime(NOW); 
        capitalFounder.setCreateUserId(CREATE_USER_ID);	
        capitalFounder.setLastUpdVersion(1);
        dao.createFiCapitalFounder(capitalFounder);
        return capitalFounder;
    }
    
    protected BigDecimal getBigDecimalCellValueSetError(XSSFCell cell, Integer rowCount) {
        try {
            return getBigDecimalCellValue(cell);
        } catch (NullPointerException nullEx) {
            setError(rowCount);
            return null;
        }
    }

    protected BigDecimal getBigDecimalCellValueNoSetError(XSSFCell cell) {
        try {
            return getBigDecimalCellValue(cell);
        } catch (NullPointerException nullEx) {
            return null;
        }
    }
    
    protected String getBigDecimalFormatNoSetError(XSSFCell cell, String format){
        try {
            DecimalFormat f = new DecimalFormat(format);//"##");
            return f.format(getBigDecimalCellValue(cell));
        } catch (NullPointerException nullEx) {
            return null;
        }
    }
    
    protected BigDecimal getBigDecimalFormatSetError(XSSFCell cell, Integer rowCount, int scale){
        try {
            return getBigDecimalCellValue(cell).setScale(scale);
        } catch (NullPointerException nullEx) {
            setError(rowCount);
            return null;
        }
    }
    
    protected BigDecimal getBigDecimalCellValue(XSSFCell cell) throws NullPointerException{
        try {
            switch(cell.getCellType()){
                case XSSFCell.CELL_TYPE_NUMERIC : {
                    return new BigDecimal(cell.getNumericCellValue());
                }
                case XSSFCell.CELL_TYPE_STRING : {
                    String stringDouble = cell.getStringCellValue();
                    return new BigDecimal(stringDouble);
                }
                default: throw new NullPointerException();
            }
        } catch (NumberFormatException e) {
            throw new NullPointerException();
        }
    }
    
    protected Integer getIntegerCellValueSetError(XSSFCell cell, int rowCount){
        try {
            return getIntegerCellValue(cell);
        } catch (NullPointerException nullEx) {
            setError(rowCount);
            return null;
        }
    }
    
    protected Integer getIntegerCellValueNoSetError(XSSFCell cell){
        try {
            return getIntegerCellValue(cell);
        } catch (NullPointerException nullEx) {
            return null;
        }
        
    }
    
    protected Integer getIntegerCellValue(XSSFCell cell) throws NullPointerException{
        try {
            return Integer.valueOf((String)getCellValue(cell));
        } catch (ClassCastException classCastEx){
            return Integer.valueOf((Integer)getCellValue(cell));
        }
    }

    protected Date getDateCellValueSetError(XSSFCell cell, int rowCount){
        try {
            return getDateCellValue(cell);
        } catch (NullPointerException nullEx) {
            setError(rowCount);
            return null;
        }
    }
    
    protected Date getDateCellValueNoSetError(XSSFCell cell){
        try {
            return getDateCellValue(cell);
        } catch (NullPointerException nullEx) {
            return null;
        }
    }
    
    protected Date getDateCellValueIsNotEmptySetError(XSSFCell cell, int rowCount){
        try {
            Date ret = getDateCellValue(cell);
            //ถ้าค่าที่ return มาเป็น null แต่ค่ามีใน cell แปลว่าข้อมูลในเ cell ผิด format
            if(ret == null && !cellIsEmpty(cell)){
                setErrorValue(rowCount, " รูปแบบวันที่ผิดพลาด ");
            }
            return ret;
        } catch (NullPointerException nullEx) {
            return null;
        }
    }
    
    protected Date getDateCellValue(XSSFCell cell) throws NullPointerException{
        switch(cell.getCellType()){
            case XSSFCell.CELL_TYPE_NUMERIC : {
                return cell.getDateCellValue();
            }
            case XSSFCell.CELL_TYPE_STRING : {
                String stringDate = cell.getStringCellValue();
                return stringToDate(stringDate);
            }
            default: throw new NullPointerException();
        }
    }
    
    protected boolean cellIsEmpty(XSSFCell cell){
        return cell == null || cell.getCellType() == XSSFCell.CELL_TYPE_BLANK;
    }
    
    protected void setError(Object rowCount){
        validationError.append(" [ไม่มี ").append(mapStringValidation.get(rowCount)).append(" ] ");
    }
    
    protected void setErrorValue(Object rowCount, String value){
        validationError.append(" ไม่มี ").append(mapStringValidation.get(rowCount)).append(" [ ").append(value).append(" ] ในฐานข้อมูล ");
    }
    
    protected void setErrorValue(Integer rowCount, String value){
        validationError.append(" ไม่มี ").append(mapStringValidation.get(rowCount)).append(" [ ").append(value).append(" ] ");
    }
     
//    private void setErrorTemp(Object rowCount, Object cell, boolean setError){
//        if(setError){
//            this.validationError.append(mapStringValidation.get(rowCount)).append(" [").append(cell).append("] ");
//        }
//    }
    
    protected Object getCellValue(XSSFCell cell) throws NullPointerException{
        switch(cell.getCellType()){
            case XSSFCell.CELL_TYPE_NUMERIC : {
                return cell.getNumericCellValue();
            }
            case XSSFCell.CELL_TYPE_STRING : {
                String value = cell.getStringCellValue();
                if("".equals(value)) throw new NullPointerException();
                return value;
            }
            default: throw new NullPointerException();
        }
    }
    protected String getStringFormatSetError(XSSFCell cell, Integer rowCount, String format){
        try {
            DecimalFormat f = new DecimalFormat(format);//"##");
            return f.format(getCellValue(cell));
        } catch (NullPointerException nullEx) {
            setError(rowCount);
            return null;
        } catch (IllegalArgumentException e){
            return getStringCellValue(cell);
        }
    }
    protected String getStringFormatNoSetError(XSSFCell cell, String format){
        try{
            DecimalFormat f = new DecimalFormat(format);//"##");
            return f.format(getCellValue(cell));
        } catch (NullPointerException nullEx) {
            return null;
        } catch (IllegalArgumentException e){
            return getStringCellValue(cell);
        }
    }
    
    protected String getStringCellValueSetError(XSSFCell cell, Integer rowCount){
        try {
            return getStringCellValue(cell);
        } catch (NullPointerException nullEx) {
            setError(rowCount);
            return null;
        }
    }
    
    protected String getStringCellValueNoSetError(XSSFCell cell){
        try {
            return getStringCellValue(cell);
        } catch (NullPointerException nullEx) {
            return null;
        }
        
    }
            
    protected String getStringCellValue(XSSFCell cell) throws NullPointerException{
        switch(cell.getCellType()){
            case XSSFCell.CELL_TYPE_NUMERIC : {
                DecimalFormat f = new DecimalFormat("##");//"##");
                return f.format(cell.getNumericCellValue());
            }
            case XSSFCell.CELL_TYPE_STRING : {
                String value = cell.getStringCellValue();
                if("".equals(value)) throw new NullPointerException();
                return value;
            }
            default: throw new NullPointerException();
        }
    }
    
    protected Integer getAccountId(String accountFullCode) {
        List<AcAccount> accountList = dao.getAccountByFullCode(enterpriseId, accountFullCode);
        if(isNullOrEmpty(accountList)){
            validationError.append(" [ไม่มี ").append("รหัสบัญชี ").append(accountFullCode).append(" ในฐานข้อมูล").append(" ] ");
            return null;
        }
        return accountList.get(0).getAccountId();
    }
    protected Integer getSourceId(String SourceFullCode) {
        List<ShSource> sourceList = dao.getSourceByFullCode(enterpriseId, SourceFullCode);
        if(isNullOrEmpty(sourceList)){
            validationError.append(" [ไม่มี ").append("รหัสแหล่งเงิน ").append(SourceFullCode).append(" ในฐานข้อมูล").append(" ] ");
            return null;
        }
        return sourceList.get(0).getSourceId();
    }
    
    protected Integer getSubAccountId(String SubAccountFullCode, Integer departmentrId, Integer sourceId) {
        List<ShSubAccount> subAccountList = dao.getSubAccountByFullCode(SubAccountFullCode, departmentrId, sourceId);
        if(isNullOrEmpty(subAccountList)){
            validationError.append(" [ไม่มี ").append("รหัสแหล่งเงิน ").append(SubAccountFullCode).append(" ในฐานข้อมูล").append(" ] ");
            return null;
        }
        return subAccountList.get(0).getSubAccountId();
    }
    protected Integer getPlanId(String planFullCode) {
        List<ShPlan> planList = dao.getPlanByFullCode(enterpriseId, planFullCode);
        if(isNullOrEmpty(planList)){
            validationError.append(" [ไม่มี ").append("รหัสแผนงาน ").append(planFullCode).append(" ในฐานข้อมูล").append(" ] ");
            return null;
        }
        return planList.get(0).getPlanId();
    }
    
    protected Integer getDepartmentId(String departmentCode){
        if(!isBlankOrNull(departmentCode)){
            ShDepartment departmentDao = dao.findDepartmentByFullCode(enterpriseId, departmentCode);
            try {
                return departmentDao.getDepartmentId();
            } catch (NullPointerException e) {
                validationError.append(" [ไม่มี ").append("รหัสหน่วยงาน ").append(departmentCode).append(" ในฐานข้อมูล").append(" ] ");
            } 
        }
        return null;
    }
    
    protected Integer getDepartmentIdCache(String departmentCode){
        if(!isBlankOrNull(departmentCode)){
            ShDepartment departmentDao = cacheDao.findDepartmentByFullCodeCache(departmentCode);
            try {
                return departmentDao.getDepartmentId();
            } catch (NullPointerException e) {
                validationError.append(" [ไม่มี ").append("รหัสหน่วยงาน ").append(departmentCode).append(" ในฐานข้อมูล").append(" ] ");
            } 
        }
        return null;
    }
    
    protected void logClear(){
         log.setText(null);
    }
    
    protected ImportData logln(String output){
        log.append(output);
        log.append("\n");
        return this;
    }
    protected boolean isBlankOrNull(String input){
        boolean retValue;
        try {
            retValue = input.isEmpty();
        } catch (NullPointerException nulEx){
            retValue = true;
        }
        return retValue;
    }
    protected boolean isNullOrZero(Integer input){
        return !(input != null && input != 0);
    }
    protected boolean isNullOrEmpty(List inputList){
        return !(inputList != null && !inputList.isEmpty());
    }
    
    protected Date stringToDate(String stringDate){
        Date retDate = null;
        if(!isBlankOrNull(stringDate)){ 
            SimpleDateFormat sdf;
            for (Map.Entry<String, Locale> entry : mapPattern.entrySet()) {
                String pattern = entry.getKey();
                Locale locale = entry.getValue();
                sdf =  new SimpleDateFormat(pattern, locale);
                try {
                    retDate = sdf.parse(stringDate);
                    break;
                } catch (ParseException parseEx) {}
            }
        }
        return retDate;
    }
    
    protected String dateToshortDate(Date date){
        if(date == null) return null;
        Calendar c = Calendar.getInstance() ;
        c.setTime(date);        
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        
        return new StringBuilder().append(day).append("/").append(month).append("/").append(year).toString();
    }
    
    protected String dateToBudgetYear(Date budgetDate) {
        Calendar c = Calendar.getInstance() ;
        c.setTime(budgetDate);
        int mount = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        //ถ้ามากกว่าเดือน 9 เดือนกันยายน year + 1
        if(mount > 8){
            year++;
        }
        return String.valueOf(year);
    }
    
    
    protected String convertListToString(List<String> stringList, String Reg){
        StringBuilder StringB = new StringBuilder();
        Iterator<String> list = stringList.iterator();
        String firstString = list.next();
        if(!isBlankOrNull(firstString)){
            StringB.append(firstString);
        }
        list.hasNext();
        return listToString(list, Reg, StringB);
    }
    
    protected String listToString(Iterator<String> stringIterator, String Reg, StringBuilder stringB){
        String stringNext = stringIterator.next();

        if(!isBlankOrNull(stringNext)){
            stringB.append(Reg).append(stringNext);
        }
        if(stringIterator.hasNext()){
            listToString(stringIterator, Reg, stringB);
        }
        return stringB.toString();
    }
    
    protected String getNewSeqNo(Integer departmentId, String combine1, String combine2, String combine3, String formTypeCode, String perfixLetterDonator){
        ShFormRunning shFormRunning = dao.getNewSeqNoFormRunningNo(departmentId, formTypeCode, perfixLetterDonator, combine1, combine2, combine3);
        Integer newSeqNo = Integer.valueOf(1);
        try {
            newSeqNo = shFormRunning.getLastSeqNo();
            shFormRunning.setLastSeqNo(++newSeqNo);
            shFormRunning.setLastUpdProg(CREATE_PROG);
            shFormRunning.setLastUpdTime(NOW);
            shFormRunning.setLastUpdUserId(CREATE_USER_ID);
            shFormRunning.setLastUpdVersion(shFormRunning.getLastUpdVersion() + 1);
            dao.updateEntity(shFormRunning);
        } catch (NullPointerException nullEx) {
            shFormRunning = new ShFormRunning();
            shFormRunning.setFormRunningId(null);
            shFormRunning.setBusinessUnitId(departmentId);
            shFormRunning.setFormTypeCode(formTypeCode);
            shFormRunning.setPrefixLetter(perfixLetterDonator);
            shFormRunning.setCharCombine1(combine1);
            shFormRunning.setCharCombine2(combine2);
            shFormRunning.setCharCombine3(combine3);
            shFormRunning.setLastSeqNo(newSeqNo.intValue());
            
            shFormRunning.setCreateProg(CREATE_PROG);
            shFormRunning.setCreateTime(NOW);
            shFormRunning.setCreateUserId(CREATE_USER_ID);
            shFormRunning.setLastUpdProg(CREATE_PROG);
            shFormRunning.setLastUpdTime(NOW);
            shFormRunning.setLastUpdUserId(CREATE_USER_ID);
            shFormRunning.setLastUpdVersion(1);
            dao.addShFormRunning(shFormRunning);
        }
        return String.format("%05d", newSeqNo);
    }
    
    protected void loadMaxAcCounter(boolean plus) {
        if(plus){
            logln("กำลังเข้าสู้กระบวนการ Update AC_COUNTER");
        }
//        dao.flush();
        List<AcCounter> counterList = dao.getAcCounter();
        BigDecimal size = new BigDecimal(counterList.size());
        BigDecimal count = BigDecimal.ZERO;
        
        for (AcCounter acCounter : counterList) {
            String tableName = acCounter.getName();
            String primaryKey = dao.getPrimaryKeyCache(tableName);
            if(primaryKey == null){
                continue;
            }
            Integer maxId = dao.getMaxByTable(tableName, primaryKey);
            if(plus){
                ++maxId;
            }
            acCounter.setValue(maxId);
            dao.updateEntity(acCounter);
//                logln(tableName + " : " + acCounter.getValue());
            
            count = count.add(BigDecimal.ONE);

            if(plus){
                BigDecimal res = count.divide(size, MathContext.DECIMAL64);
                TestGUI.setProcessBar(res.multiply(new BigDecimal(100)).intValue());
                TestGUI.refresh();
            }
        }
        if(plus){
            TestGUI.setProcessBar(100);
            TestGUI.refresh();
        }
    }   
     
    protected void loadMaxFwSequenceGenerator(boolean plus) {
        if(plus){
            logln("กำลังเข้าสู้กระบวนการ Update Fw_Sequence_Generator");
        }
//        dao.flush();
        List<FwSequenceGenerator> sequenceGeneratorList = dao.getFwSequenceGenerator();
        BigDecimal size = new BigDecimal(sequenceGeneratorList.size());
        BigDecimal count = BigDecimal.ZERO;
        for (FwSequenceGenerator sequenceGenerator : sequenceGeneratorList) {
            String tableName = sequenceGenerator.getName();
            String primaryKey = dao.getPrimaryKeyCache(tableName);
            if(primaryKey == null){
                continue;
            }
            Integer maxId = dao.getMaxByTable(tableName, primaryKey);
            if(plus){
                ++maxId;
            }
            sequenceGenerator.setValue(maxId);
//            logln(tableName + " : " + sequenceGenerator.getValue());
            dao.updateEntity(sequenceGenerator);
            if(plus){
                count = count.add(BigDecimal.ONE);

                BigDecimal res = count.divide(size, MathContext.DECIMAL64);
                TestGUI.setProcessBar(res.multiply(new BigDecimal(100)).intValue());
                TestGUI.refresh();
            }
        }
        if(plus){
            TestGUI.setProcessBar(100);
            TestGUI.refresh();
        }
        
        
        dao.flush();
    }
    
}