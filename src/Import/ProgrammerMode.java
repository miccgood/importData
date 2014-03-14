/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Import;

import Entity.ERP_AC.AcCounter;
import Entity.ERP_AC.AcDonateMember;
import Entity.ERP_AC.AcDonateMemberAccount;
import Entity.ERP_AC.AcDonateMemberRequest;
import Entity.ERP_SH.FwSequenceGenerator;
import Entity.ERP_SH.ShMember;
import Entity.ERP_SH.ShAddress;
import Entity.ERP_SH.ShMemberType;
import Entity.ERP_SH.ShPerson;
import GUI.TestGUI;
import java.math.BigDecimal;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author tanet-t
 */
public class ProgrammerMode extends ImportData{
    

    public ProgrammerMode() {
        super(5);
    }

    
//    public ProgrammerMode() {
//        super(5);
//    }
    @Override
    public List<StringBuffer> processData(XSSFWorkbook workbook, String selected){
        XSSFSheet sheet = workbook.getSheet(selected);
//        int lastRowNum = sheet.getLastRowNum();

        logClear();
        dao.startTransaction();
        cacheDao.startTransaction();
        
        loadMaxAcCounter(true);
        loadMaxFwSequenceGenerator(true);
        
        dao.commitTransaction(this.commit);
        cacheDao.commitTransaction(this.commit);
        dao.closeConnection();
        cacheDao.closeConnection();
        return null;
    }
    
    private void calBudgetYear(){
        
    }

    private void getHeader(XSSFSheet sheet){
        XSSFRow row = sheet.getRow(1);
        int lastCellNum = row.getLastCellNum();
        for (int index = 0; index < lastCellNum; index++) {
            validationError = new StringBuffer();
            XSSFCell cell = row.getCell(index);
            log.append("mapStringValidation.put(" + index + ", \"" + getStringCellValueNoSetError(cell) + "\"); \n");
//            Date value = getDateCellValueSetError(cell, index);
//            String value = getStringCellValueNoSetError(cell);
//            Integer value = getIntegerCellValueSetError(cell, index);
            
//            BigDecimal value = getBigDecimalCellValueSetError(cell, index);
            
            
//            logln(index + " : " + value);
//            log.append("XSSFCell cell" + index + " = row.getCell(" + index + ");\n");
//            log.append("String regisNo = getStringCellValueSetError(cell" + index + ", " + index + "); // " + getStringCellValueNoSetError(cell) + "\n\n");
//            ShPerson person = createShPerson();
//            dao.createShPerson(person);
//            ShAddress address = createShAddress(person);
//            dao.addEntity(address);
//            AcDonateMember donateMember = createAcDonateMember(person);
//            dao.addEntity(donateMember);

//            logln(person.getPersonId() + " : " + address.getAddressId() + " : " + donateMember.getDonateMemberId());
            TestGUI.refresh();
        }
    } 
    @Override
    protected int getSheetRowCount(XSSFSheet sheet) {
        return 0;
    }

    @Override
    protected void threadProcess(XSSFSheet sheet, int index, int lastRowNum) {
        
        this.loadMaxFwSequenceGenerator(true);
    }
    
    
    private ShMember AddMember(XSSFRow row, ShPerson person) {
        ShMember member = new ShMember();
        member.setBusinessUnitId(person.getBusinessUnitId());
        member.setPersonId(person.getPersonId());
        ShMemberType memberType = new ShMemberType();
        memberType.setMemberTypeId(110);
        memberType = (ShMemberType)dao.findEntity(memberType);
        member.setMemberTypeId(memberType);
        member.setMemberRequestId(160);
        member.setMemberSource(STRING_A);
        member.setDonatorId(null);
        member.setDonatorRelate(null);
        member.setRegisterDate(NOW);
//        member.setRequestRelationId(null);
        member.setDepartmentId(person.getBusinessUnitId());
        member.setOldRegisterDate(NOW);
        member.setOldTotalAmount(BigDecimal.ONE);
        member.setOldPaidAmount(BigDecimal.ONE);
        member.setOldPaidDate(null);
        member.setOldPaidYear(null);
        member.setOldPaidTerm(null);
        member.setOldMemberNo("124");
        member.setAmount(BigDecimal.ONE);
        member.setIsCancel(STRING_N);
        member.setIsLockUpdate(STRING_N);
        member.setCreateTime(NOW);
        member.setCreateProg(CREATE_PROG);
        member.setCreateUserId(CREATE_USER_ID);

        return member;
    }


    private AcDonateMemberAccount AddDoanteMemberAccount(XSSFRow row, ShPerson person, AcDonateMember donateMember) {
        AcDonateMemberAccount donateMemberAccount = new AcDonateMemberAccount();
        
        donateMemberAccount.setBusinessUnitId(person.getBusinessUnitId());
        donateMemberAccount.setDonateMemberId(donateMember.getDonateMemberId());
        donateMemberAccount.setAccountId(enterpriseId);
        donateMemberAccount.setDepartmentId(enterpriseId);
        donateMemberAccount.setPlanId(enterpriseId);
        donateMemberAccount.setSourceId(enterpriseId);
        donateMemberAccount.setSubAccountId(enterpriseId);
        donateMemberAccount.setIsCancel(STRING_N);
        donateMemberAccount.setIsLockUpdate(STRING_N);
        donateMemberAccount.setCreateTime(NOW);
        donateMemberAccount.setCreateTime(NOW);
        donateMemberAccount.setCreateProg(CREATE_PROG);
        donateMemberAccount.setCreateUserId(CREATE_USER_ID);
        return donateMemberAccount;
    }

    
    private AcDonateMember createAcDonateMember(ShPerson person){
        AcDonateMember donateMember = new AcDonateMember();
        donateMember.setActorDate(NOW);
        donateMember.setAddition("addition");
        donateMember.setAmount(BigDecimal.ONE);
        donateMember.setBankAccount("bankAccount");
        donateMember.setBankAccountName("bankAccountName");
        donateMember.setBankBranchId(enterpriseId);
        donateMember.setCancelDate(NOW);
        donateMember.setCancelPerId(enterpriseId);
        donateMember.setCapitalId(enterpriseId);
        donateMember.setConfigDonationId(enterpriseId);
        donateMember.setCreateProg("import");
        donateMember.setCreateTime(NOW);
        donateMember.setCreateUserId(STRING_I);
        donateMember.setCreditCardExpMonth(STRING_ERROR);
        donateMember.setCreditCardExpYear("year");
        donateMember.setCreditCardName("CrName");
        donateMember.setCreditCardNo("CrCardNo");
        donateMember.setCreditCardOwner(123);
        donateMember.setCreditCardType(1);
        donateMember.setDepartmentId(person.getBusinessUnitId());
        donateMember.setDonateMemberId(null);
        donateMember.setDonateMemberNo("1245");
        AcDonateMemberRequest donateMemberRequest = new AcDonateMemberRequest();
        donateMemberRequest.setDonateMemberRequestId(1);
        donateMember.setDonateMemberRequestId(donateMemberRequest);
        donateMember.setIsCancel(STRING_N);
        donateMember.setIsLockUpdate(STRING_N);
        donateMember.setLastUpdProg("import");
        donateMember.setLastUpdTime(NOW);
        donateMember.setLastUpdUserId("1");
        donateMember.setLastUpdVersion(1);
        donateMember.setOffDate(5);
        donateMember.setOldAmount(BigDecimal.ONE);
        donateMember.setOldDonateDate(NOW);
        donateMember.setPersonId(person.getPersonId());
        donateMember.setPurpose("p");
        donateMember.setReceiveType(STRING_C);
        return donateMember;
    }
    private ShAddress createShAddress(ShPerson person){
        ShAddress address = new ShAddress();
        address.setAddressAreaId(enterpriseId);
        address.setAddressAreaName("areaName");
        address.setAddressId(null);
        address.setAddressLocation("location");
        address.setAddressMoo("Moo");
        address.setAddressName("addressName");
        address.setAddressNo("addressNo");
        address.setAddressPhone("addressPhone");
        address.setAddressPostal("addressPostal");
        address.setAddressSoi("soi");
        address.setAddressStreet("street");
        address.setAddressType("addressType");
        address.setBusinessUnitId(person.getBusinessUnitId());
        address.setCancelDate(NOW);
        address.setCancelPerId(1);
        address.setCreateProg("Import");
        address.setCreateTime(NOW);
        address.setCreateUserId("1");
        address.setIsCancel(STRING_N);
        address.setIsLockUpdate(STRING_N);
        address.setLastUpdProg("import");
        address.setLastUpdTime(NOW);
        address.setLastUpdUserId("1");
        address.setLastUpdVersion(1);
        address.setPersonId(person.getPersonId());
        return address;
    }
    private ShPerson createShPerson(){
        ShPerson person = new ShPerson();
        person.setBirthDate(NOW);
        person.setBusinessUnitId(408);
        person.setCancelDate(NOW);
        person.setCancelPerId(enterpriseId);
        person.setCreateProg(CREATE_PROG);
        person.setCreateTime(NOW);
        person.setCreateUserId(CREATE_USER_ID);
        person.setEmail("Email");
        person.setFax("fax");
        person.setFirstName("firstName");
        person.setFirstNameEng("firstNameEng");
        person.setIsCancel(STRING_N);
        person.setIsLockUpdate(STRING_N);
        person.setIsShipRecipientAuto("IsShipRecipientAuto");
        person.setLastName("lastName");
        person.setLastNameEng("lastNameEng");
        person.setLastUpdProg(CREATE_PROG);
        person.setLastUpdTime(NOW);
        person.setLastUpdUserId(CREATE_USER_ID);
        person.setLastUpdVersion(1);
        person.setMiddleName("middleName");
        person.setMiddleNameEng("middleNameEng");
        person.setNickName("nickName");
        person.setPersonId(null);
        person.setPersonType("P");
        person.setPhone("phone");
        person.setResidentAddressSource("residentAddressSource");
        person.setSex("sex");
        person.setShipAddressLine1("shipAddressLine1");
        person.setShipAddressLine2("shipAddressLine2");
        person.setShipAddressLine3("shipAddressLine3");
        person.setShipAddressSource("shipAddressSource");
        person.setShipRecipient("shipRecipient");
        person.setTitleId(1);
        person.setTitleName("นาย");
        return person;
    }
//    protected void loadMaxAcCounter() {
//        dao.startTransaction();
//        List<AcCounter> counter = dao.getAcCounter();
//        for (AcCounter acCounter : counter) {
//            String tableName = acCounter.getName();
//            String primaryKey = dao.getPrimaryKey(tableName);
//            if(primaryKey == null){
//                continue;
//            }
//            Integer maxId = dao.getMaxByTable(tableName, primaryKey);
//            acCounter.setValue(++maxId);
//            logln(tableName + " : " + acCounter.getValue());
//            dao.updateEntity(acCounter);
//            TestGUI.refresh();
//        }
//        dao.flush();
//        dao.commitTransaction(true);
//    }
//    
//    protected void loadMaxFwSequenceGenerator() {
//        dao.startTransaction();
//        List<FwSequenceGenerator> sequenceGeneratorList = dao.getFwSequenceGenerator();
//        for (FwSequenceGenerator sequenceGenerator : sequenceGeneratorList) {
//            String tableName = sequenceGenerator.getName();
//            String primaryKey = dao.getPrimaryKey(tableName);
//            if(primaryKey == null){
//                continue;
//            }
//            Integer maxId = dao.getMaxByTable(tableName, primaryKey);
//            sequenceGenerator.setValue(++maxId);
//            logln(tableName + " : " + sequenceGenerator.getValue());
//            dao.updateEntity(sequenceGenerator);
//            TestGUI.refresh();
//        }
//        dao.flush();
//        dao.commitTransaction(true);
//    }
    
    
    private String getPrimaryKey(String tableName){
        Integer indexOf = tableName.indexOf("_") + 1;
        return tableName.substring(indexOf)+"_ID";
    }
}
