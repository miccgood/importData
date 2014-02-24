/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Import;

import ERP_PC.PcAuction;
import ERP_PC.PcAuctionType;
import ERP_PC.PcInsure;
import ERP_PC.PcInsureKind;
import ERP_PC.PcInsureType;
import ERP_PC.PcOrder;
import ERP_PS.VPsPerson;
import Entity.ERP_SH.ShBank;
import Entity.ERP_SH.ShFormType;
import Entity.ERP_SH.VShSupplier;
import Entity.Enum.GuaranteeType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author tanet-t
 */
public class ImportGuarantee extends ImportData{

    private static final int START_ROW_GUARANTEE = 3;
    private int rowCount = 0;
    private String mode ; 
    private static final String FORM_TYPE_CODE_AUCTION = "PC022"; 
    private static final String FORM_TYPE_CODE_ORDER = "PC130"; 
    private static final String FORM_TYPE_CODE_INSURE = "PC040"; 
    private String combine1;
    private String combine3;
    private static final String COMBINE2 = "00"; 
    private final String PREFIX_LETTER_AUCTION ;
    private final String PREFIX_LETTER_ORDER;
    private final PcAuctionType auctionType;
    /* ตัวแปรที่ถูดเปลี่ยนค่าทุก Row */
    private Date auctionAndOrderDate;
    private String budgetYear;
    private String docSubject;
    private VPsPerson person;
    private Integer businessUnitId;
    private String insureTypeName;
    private String insureNo;
    private VShSupplier supplier;
    private String insureKindName;
    private String suppierFullName;
    
    
    static {
        mapStringValidation.put(0, "หน่วยงาน"); 
        mapStringValidation.put(1, "ผู้นำข้อมูลเข้า"); 
        mapStringValidation.put(2, "ประเภทหลักประกัน"); 
        mapStringValidation.put(3, "ชนิดหลักประกัน"); 
        mapStringValidation.put(4, "วันที่รับหลักประกัน"); 
        mapStringValidation.put(5, "มูลค่าหลักประกัน"); 
        mapStringValidation.put(6, "วันที่ครบกำหนด"); 
        mapStringValidation.put(7, "ใบเสร็จรับเงินเล่มที่/เลขที่"); 
        mapStringValidation.put(8, "ใบเสร็จรับเงินลงวันที่"); 
        mapStringValidation.put(9, "เลขที่หนังสือหลักประกัน "); 
        mapStringValidation.put(10, "วันที่หนังสือหลักประกัน "); 
        mapStringValidation.put(11, "ธนาคาร"); 
        mapStringValidation.put(12, "สาขา ธนาคาร"); 
        mapStringValidation.put(13, "ผู้ประกอบการ"); 
        mapStringValidation.put(14, "หมายเหตุ"); 
    }
    
    
    
    public ImportGuarantee() {
        super(START_ROW_GUARANTEE);
        ShFormType formType = dao.findShFormTypeByFormTypeCode(FORM_TYPE_CODE_AUCTION);
        if(formType != null){
            PREFIX_LETTER_AUCTION = formType.getPrefixLetter();
        }else{
            PREFIX_LETTER_AUCTION = "AN";
        }
        
        formType = dao.findShFormTypeByFormTypeCode(FORM_TYPE_CODE_ORDER);
        if(formType != null){
            PREFIX_LETTER_ORDER = formType.getPrefixLetter();
        }else{
            PREFIX_LETTER_ORDER = "CN";
        }
        
        auctionType = dao.findPcAuctionTypeByAuctionTypeId(1);
    }

    @Override
    protected void threadProcess(XSSFSheet sheet, int index, int lastRowNum) {
        validationError = new StringBuffer();
        List<Object> itemList = new ArrayList<>();
        XSSFRow row = sheet.getRow(index);
        this.rowCount = index+1;

        logln("ตรวจสอบแถวที่ " + rowCount);
        
        loadDefault(row);
        
        switch(mode){
            //ค้ำประกันซอง
            case STRING_A :{
                PcAuction auction = addPcAuction(row);
                itemList.add(auction);
                break;
            } 
            //ค้ำประกันสัญญา
            case STRING_B :{
                PcOrder order = addPcOrder(row);
                itemList.add(order);
                break;
            }
            default:;
        }
        
        PcInsure insure = addPcInsure(row);
        itemList.add(insure);        
        if(validationError.length() > 0){
            //ถ้ามี error แค่ row เดียวก็ไม่ให้ commit
            this.commit = false;
            log.append("   Error : ");
            log.append(validationError.toString());
            log.append("\n");
            validationError.insert(0,rowCount).insert(0, "ROW ");
            validationErrorList.add(validationError);
        }else{
            log.append("   สำเร็จ\n");
            if(this.commit){
                addItemListDao(itemList);
            }
        }
    }

    @Override
    protected int getSheetRowCount(XSSFSheet sheet) {
        int lastRowNum = sheet.getLastRowNum();
        lastRowNum++;
        int count = 0;
        for (int i = START_ROW_GUARANTEE; i < lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            XSSFCell cell = row.getCell(0);
            if(cell == null || getStringCellValueNoSetError(cell) == null){
                return count - START_ROW_GUARANTEE;
            }
            count++;
        }
        return lastRowNum - START_ROW_GUARANTEE;    
    }

    private void addItemListDao(List<Object> itemList) {
        Integer orderId = null ;
        Integer auctionId = null;
        for (Object entity : itemList) {
            switch(entity.getClass().getName()){
                case "ERP_PC.PcAuction" : {
                    dao.addPcAuction((PcAuction)entity);
                    auctionId = ((PcAuction)entity).getAuctionId();
                    break;
                }
                case "ERP_PC.PcOrder" : {
                    dao.addPcOrder((PcOrder)entity);
                    orderId = ((PcOrder)entity).getOrderId();
                    break;
                }
                case "ERP_PC.PcInsure" : {
                    if(!isNullOrZero(orderId)){
                        ((PcInsure)entity).setOrderId(orderId);
                    }else if(!isNullOrZero(auctionId)){
                        ((PcInsure)entity).setAuctionId(auctionId);
                    }
                    dao.addEntity(entity);
                    break;
                }
            }
            
	}
    }
    
    private PcAuction addPcAuction(XSSFRow row) {
        PcAuction auction = new PcAuction();
        auction.setBusinessUnitId(businessUnitId);
        auction.setFormTypeCode(FORM_TYPE_CODE_AUCTION);
        
        auction.setAuctionTypeId(auctionType);
        auction.setBudgetYear(budgetYear);
        try {
            String auctionNo = getFormAuctionNo(businessUnitId);
            auction.setAuctionNo(auctionNo);
            insureNo = auctionNo + "-001";
        } catch (NullPointerException nullEx) {
            validationError.append(" [Gen AuctionNo ผิดพลาด] ");
        }
        
        auction.setAuctionDate(auctionAndOrderDate);
        auction.setFormStatusCode("S10");
        auction.setWorkStatusCode("300");
        auction.setDocSubject(docSubject);
        auction.setAddition(docSubject);
        
        try {
            auction.setOwnerPerId(person.getPersonId());
        } catch (NullPointerException nullEx) {
        }
        
        
        auction.setCreateTime(NOW);
        auction.setCreateProg(CREATE_PROG);
        auction.setCreateUserId(CREATE_USER_ID);
        auction.setLastUpdTime(NOW);
        auction.setLastUpdUserId(CREATE_USER_ID);
        auction.setLastUpdProg(CREATE_PROG);
        auction.setLastUpdVersion(1);

        return auction;
    }
    
    private PcOrder addPcOrder(XSSFRow row) {
        PcOrder order = new PcOrder();
        order.setBusinessUnitId(businessUnitId);
        order.setFormTypeCode(FORM_TYPE_CODE_ORDER);
        order.setOrderTypeCode("30");
        order.setBudgetYear(budgetYear);
        String orderNo = null;
        try {
            orderNo = getFormOrderNo(businessUnitId);
            order.setOrderNo(orderNo);
            insureNo = orderNo + "-001";
        } catch (NullPointerException nullEx) {
            validationError.append(" [Gen OrderNo ผิดพลาด] ");
        }
        
        order.setOrderDate(auctionAndOrderDate);
        order.setContractTypeId(1);
        order.setContractNo(orderNo);
        order.setFormStatusCode("S10");
        order.setWorkStatusCode("300");
        order.setJobType("01");
        order.setReferType("1");
        order.setPayType("CR");
        order.setDocSubject(docSubject);
        
        try {
            order.setSupplierId(supplier.getSupplierId());
        } catch (NullPointerException e) {
            setErrorValue(13, suppierFullName);
        }
        
        try {
            order.setOwnerPerId(person.getPersonId());
        } catch (NullPointerException nullEx) {
        }
        
        order.setCreateTime(NOW);
        order.setCreateProg(CREATE_PROG);
        order.setCreateUserId(CREATE_USER_ID);
        order.setLastUpdTime(NOW);
        order.setLastUpdUserId(CREATE_USER_ID);
        order.setLastUpdProg(CREATE_PROG);
        order.setLastUpdVersion(1);
       

        return order;
    }

    private String subDepartmentCode(String department){
        return department.substring(0, 2);
    }
    
    private String getDocSubject(String docSubject){
        return (docSubject != null ? docSubject : "") + "(ยกมาจากระบบเดิม)";
    }
    
    private String getFormAuctionNo(Integer departmentId) throws NullPointerException{
        try {
            if(!isNullOrZero(departmentId) && !isBlankOrNull(combine3)){
                String newSeqNo = getNewSeqNo(departmentId, combine1, COMBINE2, combine3, FORM_TYPE_CODE_AUCTION, PREFIX_LETTER_AUCTION);
                StringBuilder formRunning = new StringBuilder();
                return formRunning.append(PREFIX_LETTER_AUCTION).append(combine1).append(COMBINE2).append(combine3).append(newSeqNo).toString();
            }
        } catch (NullPointerException e) {
            
        }
        throw new NullPointerException();
        
    }
    private String getFormOrderNo(Integer departmentId) throws NullPointerException{
        try {
            if(!isNullOrZero(departmentId) && !isBlankOrNull(combine3)){
                String newSeqNo = getNewSeqNo(departmentId, combine1, COMBINE2, combine3, FORM_TYPE_CODE_ORDER, PREFIX_LETTER_ORDER);
                StringBuilder formRunning = new StringBuilder();
                return formRunning.append(PREFIX_LETTER_ORDER).append(combine1).append(COMBINE2).append(combine3).append(newSeqNo).toString();
            }
        } catch (NullPointerException e) {
            
        }
        throw new NullPointerException();
        
    }

    private void loadDefault(XSSFRow row){
        
        auctionAndOrderDate = null;
        budgetYear = null;
        docSubject = null;
        person = null;
        businessUnitId = null;
        insureTypeName = null;
        insureNo = null;
        supplier = null;
        insureKindName = null;
        suppierFullName = null;
    
    
        XSSFCell cell2 = row.getCell(2);
        try {
            insureTypeName = getStringCellValueNoSetError(cell2);
            GuaranteeType guaranteeType = GuaranteeType.valueOf(insureTypeName);
            mode = guaranteeType.getType();
            if(isBlankOrNull(mode)){
                throw new NullPointerException();
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            validationError.append(" ไม่พบ [ประเภทหลักประกัน]");
        }
        
        XSSFCell cell0 = row.getCell(0);
        String department = getStringCellValueSetError(cell0, 0);
        try {
            combine1 = subDepartmentCode(department);
            businessUnitId = getDepartmentId(combine1);
        } catch (ArrayIndexOutOfBoundsException e) {
            validationError.append(mapStringValidation.get(0)).append(" [ ").append(department).append(" ] ").append("ไม่ถูกค้อง");
        }
        
        XSSFCell cell4 = row.getCell(4);
        auctionAndOrderDate = getDateCellValueSetError(cell4, 4);
        try{
            budgetYear = dateToBudgetYear(auctionAndOrderDate);
            combine3 = budgetYear.substring(2);
        }catch(NullPointerException nullEx){
           setError(4);
        }
        
        XSSFCell cell14 = row.getCell(14);
        docSubject = getDocSubject(getStringCellValueNoSetError(cell14));
        
        XSSFCell cell1 = row.getCell(1);
        String personString = getStringCellValueSetError(cell1, 1);
        try {
            String personCode = getPersonCode(personString);
            person = dao.findVPsPersonByPersonCode(personCode);
        } catch (NullPointerException nullEx) {
            setError(1);
        }
        
        
        
        XSSFCell cell13 = row.getCell(13);
        suppierFullName = getStringCellValueSetError(cell13, 13);
        supplier = dao.findVShSupplierByFullName(suppierFullName);
    }

    private PcInsure addPcInsure(XSSFRow row) {
        PcInsure insure = new PcInsure();
        insure.setBusinessUnitId(businessUnitId);
        insure.setFormTypeCode(FORM_TYPE_CODE_INSURE);
        PcInsureType insureType = dao.findPcInsureTypeByName(insureTypeName);
        insure.setInsureTypeId(insureType);
        insure.setInsureNo(insureNo);
        insure.setSeqRunning(1);
        insure.setInsureDate(auctionAndOrderDate);
        try {
            insure.setSupplierId(supplier.getSupplierId());
        } catch (NullPointerException e) {
            setErrorValue(13, suppierFullName);
        }
        
        XSSFCell cell3 = row.getCell(3);
        insureKindName = getStringCellValueSetError(cell3, 3);
        PcInsureKind insureKind = dao.findPcInsureKindByName(insureKindName);
        insure .setInsureKindId(insureKind);
        XSSFCell cell5 = row.getCell(5);
        BigDecimal insureAmount = getBigDecimalFormatSetError(cell5, 5, 2);
        insure.setInsureAmount(insureAmount);
        XSSFCell cell6 = row.getCell(6);
        Date dueDate = getDateCellValueNoSetError(cell6);
        insure.setDueDate(dueDate);
        
        if(isCashOrCheque()){
            XSSFCell cell7 = row.getCell(7);
            String receiptNo = getStringCellValueSetError(cell7, 7);
            insure.setReceiptNo(receiptNo);

            XSSFCell cell8 = row.getCell(8);
            Date receiptDate = getDateCellValueSetError(cell8, 8);
            insure.setReceiptDate(receiptDate);
            
        }else{
            XSSFCell cell9 = row.getCell(9);
            String guaranteeNo = getStringCellValueSetError(cell9, 9);
            insure.setGuaranteeNo(guaranteeNo);

            XSSFCell cell10 = row.getCell(10);
            Date guaranteeDate = getDateCellValueSetError(cell10, 10);
            insure.setGuaranteeDate(guaranteeDate);
            
        }
        
        XSSFCell cell11 = row.getCell(11);
        String bankName = getStringCellValueNoSetError(cell11);
        if(!isBlankOrNull(bankName)){
            ShBank bank = dao.findShBankByBankName(bankName);
            try {
                insure.setBankId(bank.getBankId());
            } catch (NullPointerException e) {
                setError(11);
            }
        }
        
        XSSFCell cell12 = row.getCell(12);
        String bankBranchName = getStringCellValueNoSetError(cell12);
        insure.setBankBranch(bankBranchName);

        XSSFCell cell14 = row.getCell(14);
        String addition = getStringCellValueNoSetError(cell14);
        if(supplier == null || isBlankOrNull(addition)){
            insure.setAddition(suppierFullName);
        }else{
            insure.setAddition(addition);
        }
        try {
            insure.setReceivePerId(person.getPersonId());
        } catch (NullPointerException nullEx) {
            setError(1);
        }
        
        
        insure.setCreateTime(NOW);
        insure.setCreateProg(CREATE_PROG);
        insure.setCreateUserId(CREATE_USER_ID);
        insure.setLastUpdTime(NOW);
        insure.setLastUpdUserId(CREATE_USER_ID);
        insure.setLastUpdProg(CREATE_PROG);
        insure.setLastUpdVersion(1);
        return insure;

    }
    
    private boolean isCashOrCheque(){
        return "แคชเชียร์เช็ค".equals(insureKindName) || "เงินสด".equals(insureKindName);
    }

    private String getPersonCode(String personString) throws NullPointerException{
        try {
            return personString.split("-")[0];
        } catch (NullPointerException | ArrayIndexOutOfBoundsException ex){}
        throw new NullPointerException();
        
    }
}
