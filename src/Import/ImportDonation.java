/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Import;

import Entity.ERP_AC.AcCounter;
import Entity.ERP_AC.AcCreditCardType;
import Entity.ERP_AC.AcDonateMember;
import Entity.ERP_AC.AcDonateMemberAccount;
import Entity.ERP_SH.ShAddress;
import Entity.ERP_SH.ShBank;
import Entity.ERP_SH.ShBankBranch;
import Entity.ERP_SH.ShFormType;
import Entity.ERP_SH.ShMember;
import Entity.ERP_SH.ShMemberCard;
import Entity.ERP_SH.ShMemberType;
import Entity.ERP_SH.ShPerson;
import Entity.ERP_SH.ShPersonDoc;
import Entity.ERP_SH.ShTitle;
import Entity.ERP_SH.VShRegion;
import Entity.Enum.DocType;
import Entity.Enum.ReceiveType;
import Entity.Enum.SexType;
import GUI.TestGUI;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author tanet-t
 */
public class ImportDonation extends ImportData{

    private static final int START_ROW_DONAION = 5;
    private String DEPARTMENT_CODE = null;
    private int rowCount = 0;
    private String mode ; 
    private static final String FORM_TYPE_CODE_DONATOR = "FI140"; 
    private static final String FORM_TYPE_CODE_MEMBER = "FI130"; 
//    private static final String DEPARTMENT_CODE = "09"; 
    private static final String COMBINE2 = "00"; 
    private static final String[] prefixAddition = {"ใบเสร็จ ", "/", " วันที่ ", "", " ผู้บริจาคร่วม "};
    private final String PREFIX_LETTER_DONATOR ;
    
    private static final Map<String, String> mapTableId = new HashMap<>();
    private String subBudgetYear;
    static {
        mapStringValidation.put(0, "ประเภททะเบียน "); 
        mapStringValidation.put(1, "ประเภทสมาชิก "); 
        mapStringValidation.put(2, "คำนำหน้า "); 
        mapStringValidation.put(3, "ชื่อตัว (ไทย) "); 
        mapStringValidation.put(4, "ชื่อกลาง "); 
        mapStringValidation.put(5, "นามสกุล "); 
        mapStringValidation.put(6, "ชื่อตัว (อังกฤษ) "); 
        mapStringValidation.put(7, "ชื่อกลาง (อังกฤษ) "); 
        mapStringValidation.put(8, "นามสกุล (อังกฤษ) "); 
        mapStringValidation.put(9, "ชื่อเล่น "); 
        mapStringValidation.put(10, "เบอร์โทร "); 
        mapStringValidation.put(11, "เบอร์แฟกซ์ "); 
        mapStringValidation.put(12, "เอกสารราชการ "); 
        mapStringValidation.put(13, "ออกโดย "); 
        mapStringValidation.put(14, "เลขที่ "); 
        mapStringValidation.put(15, "วันที่หมดอายุ "); 
        mapStringValidation.put(16, "เพศ "); 
        mapStringValidation.put(17, "วันเดือนปีเกิด "); 
        mapStringValidation.put(18, "ชื่อที่ตั้ง/อาคาร/สถานที่  "); 
        mapStringValidation.put(19, "ชั้นที่/ห้องที่ "); 
        mapStringValidation.put(20, "บ้านเลขที่ "); 
        mapStringValidation.put(21, "หมู่ที่ "); 
        mapStringValidation.put(22, "รหัสจังหวัด/อำเภอ/ตำบล "); 
        mapStringValidation.put(23, "ถนน "); 
        mapStringValidation.put(24, "/ซอย "); 
        mapStringValidation.put(25, "จังหวัด "); 
        mapStringValidation.put(26, "อำเภอ "); 
        mapStringValidation.put(27, "ตำบล "); 
        mapStringValidation.put(28, "รหัสไปรษณีย์ "); 
        mapStringValidation.put(29, "ประเทศ "); 
        mapStringValidation.put(30, "เบอร์โทรสถานที่ "); 
        mapStringValidation.put(31, "ตามที่อยู่ทางการ "); 
        mapStringValidation.put(32, "ชื่อที่ตั้ง/อาคาร/สถานที่ "); 
        mapStringValidation.put(33, "ชั้นที่/ห้องที่ "); 
        mapStringValidation.put(34, "บ้านเลขที่ "); 
        mapStringValidation.put(35, "หมู่ที่ "); 
        mapStringValidation.put(36, "รหัสจังหวัด/อำเภอ/ตำบล "); 
        mapStringValidation.put(37, "ถนน "); 
        mapStringValidation.put(38, "/ซอย "); 
        mapStringValidation.put(39, "จังหวัด "); 
        mapStringValidation.put(40, "อำเภอ "); 
        mapStringValidation.put(41, "ตำบล "); 
        mapStringValidation.put(42, "รหัสไปรษณีย์ "); 
        mapStringValidation.put(43, "ประเทศ "); 
        mapStringValidation.put(44, "เบอร์โทรสถานที่ "); 
        mapStringValidation.put(45, "นำมาจากที่อยู่ทางการ "); 
        mapStringValidation.put(46, "ชื่อผู้รับเอกสาร "); 
        mapStringValidation.put(47, "นำมาจากชื่อบุคคล "); 
        mapStringValidation.put(48, "ชื่อที่ตั้ง/อาคาร/สถานที่  "); 
        mapStringValidation.put(49, "ชั้นที่/ห้องที่ "); 
        mapStringValidation.put(50, "บ้าน "); 
        mapStringValidation.put(51, "null "); 
        mapStringValidation.put(52, "รหัสจังหวัด/อำเภอ/ตำบล "); 
        mapStringValidation.put(53, "ถนน "); 
        mapStringValidation.put(54, "ตรอก/ซอย "); 
        mapStringValidation.put(55, "จังหวัด "); 
        mapStringValidation.put(56, "อำเภอ "); 
        mapStringValidation.put(57, "ตำบล "); 
        mapStringValidation.put(55, "จังหวัด "); 
        mapStringValidation.put(56, "อำเภอ "); 
        mapStringValidation.put(575655, "ตำบล/อำเภอ/จังหวัด ");
        mapStringValidation.put(58, "รหัสไปรษณีย์ "); 
        mapStringValidation.put(59, "ประเทศ "); 
        mapStringValidation.put(60, "เบอร์โทรสถานที่ "); 
        mapStringValidation.put(61, "ที่อยู่ "); 
        mapStringValidation.put(62, "จำวนเงินที่ใช้สิทธิ "); 
        mapStringValidation.put(63, "ใบเสร็จรับเงินลงวันที่ "); 
        mapStringValidation.put(64, "ใบเสร็จรับเงินเล่มที่ "); 
        mapStringValidation.put(65, "ใบเสร็จรับเงินเลขที่ "); 
        mapStringValidation.put(66, "วัตถุประสงค์การบริจาค "); 
        mapStringValidation.put(67, "รหัสสมาชิก "); 
        mapStringValidation.put(68, "วันขึ้นทะเบียน "); 
        mapStringValidation.put(69, "ธนาคารผู้ออกบัตร "); 
        mapStringValidation.put(70, "ประเภทบัตรเครดิต "); 
        mapStringValidation.put(71, "เลขที่บัตรเครดิต "); 
        mapStringValidation.put(72, "ชื่อผู้ถือบัตรเครดิต "); 
        mapStringValidation.put(73, "ปีที่บัตรหมดอายุ "); 
        mapStringValidation.put(74, "เดือนที่บัตรหมดอายุ "); 
        mapStringValidation.put(75, "ธนาคารผู้จ่ายเงิน "); 
        mapStringValidation.put(76, "สาขาผู้จ่ายเงิน "); 
        mapStringValidation.put(77, "เลขที่บัญชีเงินฝาก "); 
        mapStringValidation.put(78, "ชื่อบัญชีเงินฝาก "); 
        mapStringValidation.put(79, "จำนวนเงินหักแต่ละเดือน "); 
        mapStringValidation.put(80, "ตัดยอดทุกวันที่ (ของเดือน) "); 
        mapStringValidation.put(81, "รหัสบัญชี  "); 
        mapStringValidation.put(82, "รหัสหน่วยงาน "); 
        mapStringValidation.put(83, "รหัสแผนงาน/โครงการ/กิจกรรม "); 
        mapStringValidation.put(84, "รหัสแหล่งเงิน  "); 
        mapStringValidation.put(85, "รหัสบัญชีย่อย  "); 
        mapStringValidation.put(86, "รหัสหน่วยงาน  "); 
        
        mapTableId.put("SH_PERSON", "PERSON_ID");
        mapTableId.put("SH_ADDRESS", "ADDRESS_ID");
        mapTableId.put("AC_DONATE_MEMBER", "DONATE_MEMBER_ID");
    }
    private final String PREFIX_LETTER_MEMBER;
    
    public ImportDonation() {
        super(START_ROW_DONAION);
        cacheDao.init();
        
        ShFormType formType = cacheDao.findShFormTypeByFormTypeCode(FORM_TYPE_CODE_DONATOR);
        if(formType != null){
            PREFIX_LETTER_DONATOR = formType.getPrefixLetter();
        }else{
            PREFIX_LETTER_DONATOR = "RD";
        }
        
        formType = dao.findShFormTypeByFormTypeCode(FORM_TYPE_CODE_MEMBER);
        if(formType != null){
            PREFIX_LETTER_MEMBER = formType.getPrefixLetter();
        }else{
            PREFIX_LETTER_MEMBER = "RM";
        }
    }

    @Override
    protected void threadProcess(XSSFSheet sheet, int index, int lastRowNum) {
        validationError = new StringBuffer();
        validationWarn = new StringBuffer();
//        List<Object> itemList = new ArrayList<>();
        XSSFRow row = sheet.getRow(index);

        this.rowCount = index+1;

        XSSFCell cell0 = row.getCell(0);
        logln("ตรวจสอบแถวที่ " + rowCount);
        try {
            ReceiveType receiveType = ReceiveType.valueOf(getStringCellValueNoSetError(cell0));
            mode = receiveType.getType();
            if(isBlankOrNull(mode)){
                throw new NullPointerException();
            }
        } catch (NullPointerException iEx){
            validationError.append(" ไม่พบ [ประเภททะเบียน] (ข้ามไปทำบรรทัดถัดไป)");
            setError();
            return;
        } catch (IllegalArgumentException iEx){
            validationError.append(" [ประเภททะเบียน] ผิด (ข้ามไปทำบรรทัดถัดไป)");
            setError();
            return;
        }
        
        XSSFCell cell86 = row.getCell(86);
        DEPARTMENT_CODE = getStringFormatNoSetError(cell86, "##");
        try{
            if(DEPARTMENT_CODE.length()>2){
                validationError.append(" รหัสหน่วยงานต้องไม่เกิน 2 หลัก ");
                throw new NullPointerException();
            }
        } catch (NullPointerException nullEx){
            setError(86);
//            setError();
//            return;
        }
        
        
        ShPerson person = addPerson(row);
        
        addPersonDoc(row, person);
        addAddress(row, person);
        switch(mode){
            case STRING_D :{
                AddDoanteMember(row, person);
                break;
            } 
            case STRING_C :;
            case STRING_B :{
                AcDonateMember donateMember = AddDoanteMember(row, person);
                AddDoanteMemberAccount(row, person, donateMember);
                break;
            }
            case STRING_M :{
                ShMember member = AddMember(row, person);
                AddMemberCard(row, person, member);
                break;
            }
            default:;
        }
        this.setError();
    }
    private void setError(){
        
        StringBuilder logBuffer = new StringBuilder();
        StringBuffer error = new StringBuffer();
        StringBuffer warning = new StringBuffer();

        if(validationWarn.length() > 0){
            warning.append("\r   Warning : ").append(validationWarn.toString()).append("\n");
//            log.append(warning.toString());
            logBuffer.append(warning.toString());
        }

        if(validationError.length() > 0){
            error.append("\r   Error : ").append(validationError.toString()).append("\n");
            //ถ้ามี error แค่ row เดียวก็ไม่ให้ commit
            this.commit = false;
//            log.append(error.toString());
            logBuffer.append(error.toString());
        }else{
//            log.append("   สำเร็จ\n");
            logBuffer.append("   สำเร็จ\n");
        }

        //ถ้ามี Error หรือ Warning 
        if(error.length() > 0 || warning.length() > 0){
            StringBuffer validation = new StringBuffer();
            validation.append("ROW ").append(rowCount);
            validationErrorList.add(validation);
            if(error.length() > 0){
                validationErrorList.add(error);
                IS_SUCCESS = false;
            }
            if(warning.length() > 0){
                validationErrorList.add(warning);
            }
        }
        
        if(TestGUI.IsEnableLog()){
            log.append(logBuffer.toString());
        }
        
    }
    @Override
    protected int getSheetRowCount(XSSFSheet sheet) {
        int lastRowNum = sheet.getLastRowNum();
        lastRowNum++;
        int count = 0;
        for (int i = START_ROW_DONAION; i < lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            XSSFCell cell0 = row.getCell(0);
            XSSFCell cell3 = row.getCell(3);
            if( (cell0 == null || getStringCellValueNoSetError(cell0) == null )
                    && (cell3 == null || getStringCellValueNoSetError(cell3) == null) ){
                return count;
            }
            count++;
        }
        return lastRowNum - START_ROW_DONAION;    
    }

    private ShPerson addPerson(XSSFRow row) {
        ShPerson person = new ShPerson();
        
//        Integer departmentId = getDepartmentId(DEPARTMENT_CODE) ;
        Integer departmentId = getDepartmentIdCache(DEPARTMENT_CODE) ;
        if(departmentId == null || departmentId == 0){
//            setErrorValue(86, DEPARTMENT_CODE);
        }
        person.setBusinessUnitId(departmentId);
        
        XSSFCell cell2 = row.getCell(2);
        String titleName = getStringCellValueNoSetError(cell2);// คำนำหน้า
        person.setTitleName(titleName);
        
        person.setPersonType(STRING_P);
        if(!isBlankOrNull(titleName)){
            ShTitle title = cacheDao.findTitleByTitleNameCache(titleName);
            try {
                person.setTitleId(title.getTitleId());
            } catch (NullPointerException nullEx) {}
        }
        
        XSSFCell cell3 = row.getCell(3);
        String firstNameThai = getStringCellValueSetError(cell3, 3);// ชื่อตัว (ไทย)
        person.setFirstName(firstNameThai);
       
        XSSFCell cell4 = row.getCell(4);
        String middleNameThai = getStringCellValueNoSetError(cell4); // ชื่อกลาง
        person.setMiddleName(middleNameThai);
        
        XSSFCell cell5 = row.getCell(5);
        String lastNameThai = getStringCellValueNoSetError(cell5);// นามสกุล
        person.setLastName(lastNameThai);
        
        XSSFCell cell6 = row.getCell(6);
        String firstNameEng = getStringCellValueNoSetError(cell6); // ชื่อตัว (อังกฤษ)
        person.setFirstNameEng(firstNameEng);
        
        XSSFCell cell7 = row.getCell(7);
        String middleNameEng = getStringCellValueNoSetError(cell7); // ชื่อกลาง (อังกฤษ)
        person.setMiddleNameEng(middleNameEng);
        
        XSSFCell cell8 = row.getCell(8);
        String lastNameEng = getStringCellValueNoSetError(cell8); // นามสกุล (อังกฤษ)
        person.setLastNameEng(lastNameEng);
        
        XSSFCell cell9 = row.getCell(9);
        String nickName = getStringCellValueNoSetError(cell9); // ชื่อเล่น
        person.setNickName(nickName);
        
        XSSFCell cell10 = row.getCell(10);
        String Phone = getStringCellValueNoSetError(cell10); // เบอร์โทร
        person.setPhone(Phone);
       
        XSSFCell cell11 = row.getCell(11);
        String fax = getStringCellValueNoSetError(cell11); // เบอร์แฟกซ์
        person.setFax(fax);

        XSSFCell cell16 = row.getCell(16);
        String sex = getStringCellValueNoSetError(cell16); // เพศ
        try {
            SexType sexType = SexType.valueOf(sex);
            person.setSex(sexType.getDescription());
        } catch (NullPointerException e) {
            person.setSex(STRING_N);
        }
        
        XSSFCell cell17 = row.getCell(17);
        Date birthDate = getDateCellValueIsNotEmptySetError(cell17, 17); // วันเดือนปีเกิด
        person.setBirthDate(birthDate);
        
        person.setResidentAddressSource(STRING_N);

        person.setShipAddressSource(STRING_N);
        person.setIsShipRecipientAuto(STRING_N);
        String shipRecipient = getShipRecipient(titleName, firstNameThai, middleNameThai, lastNameThai);
        person.setShipRecipient(shipRecipient);

        XSSFCell cell48 = row.getCell(48);
        String addressName = getStringFormatNoSetError(cell48, "##"); // ชื่อที่ตั้ง/อาคาร/สถานที่ @AW

        XSSFCell cell49 = row.getCell(49);
        String addressLocation = getStringFormatNoSetError(cell49, "##"); // ชั้นที่/ห้องที่ @AX

        XSSFCell cell50 = row.getCell(50);
        String addressNo = getStringFormatNoSetError(cell50, "##"); // บ้านเลขที่ @AY

        XSSFCell cell51 = row.getCell(51);
        String addressMoo = getStringFormatNoSetError(cell51, "##"); // หมู่ @AZ


        XSSFCell cell53 = row.getCell(53);
        String addressStreet = getStringCellValueNoSetError(cell53); // ถนน

        XSSFCell cell54 = row.getCell(54);
        String addressSoi = getStringFormatNoSetError(cell54, "##"); // ตรอก/ซอย

        String address1 = getShipAddress(addressName, addressLocation, addressNo, addressMoo, addressStreet, addressSoi);
        
        person.setShipAddressLine1(address1);
        
        XSSFCell cell55 = row.getCell(55);
        String province = getStringCellValueNoSetError(cell55); // จังหวัด

        XSSFCell cell56 = row.getCell(56);
        String amphoe = getStringCellValueNoSetError(cell56); // อำเภอ

        XSSFCell cell57 = row.getCell(57);
        String tumbon = getStringCellValueNoSetError(cell57); // ตำบล
        
        String address2 = getShipAddress(tumbon, amphoe, province, null, null, null);
        person.setShipAddressLine2(address2);
        
        XSSFCell cell58 = row.getCell(58);
        String postCode = getStringFormatNoSetError(cell58, "##"); // รหัสไปรษณีย์

        XSSFCell cell59 = row.getCell(59);
        String country = getStringCellValueNoSetError(cell59); // ประเทศ

        String address3 = getShipAddress(postCode, country, null, null, null, null);
        person.setShipAddressLine3(address3);
        
        person.setIsCancel(STRING_N);
        person.setIsLockUpdate(STRING_N);
        person.setCreateTime(NOW);
        person.setCreateProg(CREATE_PROG);
        person.setCreateUserId(CREATE_USER_ID);
        
        person.setLastUpdTime(NOW);
        person.setLastUpdProg(CREATE_PROG);
        person.setLastUpdUserId(CREATE_USER_ID);
        
        person.setLastUpdVersion(1);
        cacheDao.addEntity(person);
        return person;
    }
    
    private String getShipAddress(String addressName, String addressLocation, String addressNo
            , String addressMoo, String addressStreet, String addressSoi){
        List<String> stringList = new ArrayList<>();
        stringList.add(addressName);
        stringList.add(addressLocation);
        stringList.add(addressNo);
        stringList.add(addressMoo);     
        stringList.add(addressStreet);
        stringList.add(addressSoi);
        return convertListToString(stringList, STRING_SPACE);
    }
    private String getShipRecipient(String titleName, String firstName, String middleName, String lastName){
        List<String> stringList = new ArrayList<>();
        stringList.add(titleName);
        stringList.add(firstName);
        stringList.add(middleName);
        stringList.add(lastName);                
        return convertListToString(stringList, STRING_SPACE);
    }
    private String getAddition(String bookNo, String receipt, String oldDonateDate, String objective, String donateName){
        StringBuilder addition = new StringBuilder();
        //ถ้า @BM มีค่า
        //     str=''||@BM
        if(!isBlankOrNull(bookNo)){
            addition.append(prefixAddition[0]).append(bookNo);
        }
        //ถ้า @BN มีค่า
        //     str=str||'/'||@BN
        if(!isBlankOrNull(receipt)){
            addition.append(prefixAddition[1]).append(receipt);
        }
        //ถ้า @BL มีค่า วันที่ 
        //     str=str||' วันที่ '||@BL
        if(!isBlankOrNull(oldDonateDate)){
            addition.append(prefixAddition[2]).append(oldDonateDate);
        }
        //ถ้า @BO มีค่า วันที่ 
        //     str=str||@BO
        if(!isBlankOrNull(objective)){
            addition.append(STRING_SPACE).append(prefixAddition[3]).append(objective);
        }
        //ถ้า @BJ มีค่า วันที่ 
        //     str=str||''||@BJ"
        if(!isBlankOrNull(donateName)){
            addition.append(prefixAddition[4]).append(donateName);
        }
        return addition.toString().trim();
    }
    
    private ShAddress addAddress(XSSFRow row, ShPerson person) {
        if(validatAddAddress(row)) return null;
        ShAddress address = new ShAddress();
        
        XSSFCell cell48 = row.getCell(48);
        String addressName1 = getStringFormatNoSetError(cell48, "##"); // ชื่อที่ตั้ง/อาคาร/สถานที่ 

        XSSFCell cell49 = row.getCell(49);
        String addressLocation1 = getStringFormatNoSetError(cell49, "##"); // ชั้นที่/ห้องที่

        XSSFCell cell50 = row.getCell(50);
        String addressNo1 = getStringFormatNoSetError(cell50, "##"); // บ้านเลขที่

        XSSFCell cell51 = row.getCell(51);
        String moo1 = getStringFormatNoSetError(cell51, "##"); // หมู่ที่

        XSSFCell cell53 = row.getCell(53);
        String street1 = getStringFormatNoSetError(cell53, "##"); // ถนน

        XSSFCell cell54 = row.getCell(54);
        String soi1 = getStringFormatNoSetError(cell54, "##"); // /ซอย


        XSSFCell cell58 = row.getCell(58);
        String postCode1 = getStringFormatNoSetError(cell58, "##"); // รหัสไปรษณีย์


        XSSFCell cell60 = row.getCell(60);
        String phone1 = getStringFormatNoSetError(cell60, "##"); // เบอร์โทรสถานที่

        //ADDRESS_ID	ID Running
        //BUSINESS_UNIT_ID	SH_PERSON.BUSINESS_UNIT_ID
        address.setBusinessUnitId(person.getBusinessUnitId());
        //PERSON_ID	SH_PERSON.PERSON_ID
        address.setPersonId(person.getPersonId());
        //ADDRESS_TYPE	R
        address.setAddressType(STRING_R);
        //ADDRESS_NAME	@AW
        address.setAddressName(addressName1);
        //ADDRESS_LOCATION	@AX
        address.setAddressLocation(addressLocation1);
        //ADDRESS_NO	@AY
        address.setAddressNo(addressNo1);
        //ADDRESS_MOO	@AZ
        address.setAddressMoo(moo1);
        //ADDRESS_AREA_ID	"หาจาก V_SH_REGION.REGION_ID
        //V_SH_REGION.FULL_NAME =@BF||' '||@BE||' '||@BD"
        
        XSSFCell cell55 = row.getCell(55);
        String province = getStringCellValueNoSetError(cell55); // จังหวัด

        XSSFCell cell56 = row.getCell(56);
        String amphoe = getStringCellValueNoSetError(cell56); // อำเภอ

        XSSFCell cell57 = row.getCell(57);
        String tumbon = getStringCellValueNoSetError(cell57); // ตำบล
        
        String regionFullName = getShipAddress(tumbon, amphoe, province, null, null, null);
        
        if(!isBlankOrNull(regionFullName)){
            VShRegion region = cacheDao.findRegionByFullNameCache(regionFullName);
            try {
                address.setAddressAreaId(region.getRegionId());
            } catch (NullPointerException nullEx) {
                validationWarn.append(" [ไม่มี ").append(mapStringValidation.get(575655)).append(regionFullName).append(" ในฐานข้อมูล").append(" ] ");
            }
        }
        //ADDRESS_AREA_NAME	@BF||' '||@BE||' '||@BD
        address.setAddressAreaName(regionFullName);
        //ADDRESS_STREET	@BB
        address.setAddressStreet(street1);
        //ADDRESS_SOI	@BC
        address.setAddressSoi(soi1);
        //ADDRESS_POSTAL	@BG
        address.setAddressPostal(postCode1);
        //ADDRESS_PHONE	@BI
        address.setAddressPhone(phone1);
        //IS_CANCEL	N
        address.setIsCancel(STRING_N);
        //IS_LOCK_UPDATE	N
        address.setIsLockUpdate(STRING_N);
        //CREATE_TIME	วันที่ Convert
        address.setCreateTime(NOW);
        //CREATE_USER_ID	CONVERT
        address.setCreateUserId(CREATE_USER_ID);
        //CREATE_PROG	ใส่ชื่อไฟล์ Excel ที่นำเข้า
        address.setCreateProg(CREATE_PROG);
        
        address.setLastUpdTime(NOW);
        address.setLastUpdUserId(CREATE_USER_ID);
        address.setLastUpdProg(CREATE_PROG);
        address.setLastUpdVersion(1);

        cacheDao.addEntity(address);
        return address;
    }

    private AcDonateMember AddDoanteMember(XSSFRow row, ShPerson person) {
        AcDonateMember donateMember = new AcDonateMember();
        
        donateMember.setBusinessUnitId(person.getBusinessUnitId());
        
        donateMember.setDepartmentId(person.getBusinessUnitId());
        
        XSSFCell cell63 = row.getCell(63);
        Date oldDonateDate = getDateCellValueIsNotEmptySetError(cell63, 63);
        if(oldDonateDate == null){
            oldDonateDate = new Date();
        }
        String budgetYear = dateToBudgetYear(oldDonateDate);
        try{
            subBudgetYear = budgetYear.substring(2);
        }catch(NullPointerException nullEx){
            validationError.append(" ไม่มี ").append("ปีงบประมาณ [").append(budgetYear).append(" ] ");
        }
        
        donateMember.setBudgetYear(budgetYear);
        
//        XSSFCell cell68 = row.getCell(68);
//        Date actorData = getDateCellValueIsNotEmptySetError(cell68);
        donateMember.setActorDate(oldDonateDate);
        
        donateMember.setPersonId(person.getPersonId());
        
        XSSFCell cell66 = row.getCell(66);
        String purPose = getStringCellValueNoSetError(cell66);
        try{
            donateMember.setPurpose(purPose.substring(0, 999));
        }catch(Exception e){
            donateMember.setPurpose(purPose);
        }
        donateMember.setReceiveType(mode);
        
        XSSFCell cell62 = row.getCell(62);
        BigDecimal oldAmount = getBigDecimalCellValueNoSetError(cell62);
        donateMember.setOldAmount(oldAmount);
        
        
        //ถ้า ผู้บริจาคผ่านบัตรเครดิต
        switch (mode) {
            case STRING_C:
                {
                    XSSFCell cell69 = row.getCell(69);
                    String bankName = getStringCellValueSetError(cell69, 69);
                    if(!isBlankOrNull(bankName)){
                        ShBank bank = cacheDao.findShBankByBankNameCache(bankName);
                        try {
                            donateMember.setCreditCardOwner(bank.getBankId());
                        } catch (NullPointerException nullEx) {
                        }
                    }
                    
                    XSSFCell cell70 = row.getCell(70);
                    String creditCardType = getStringCellValueSetError(cell70, 70);
                    if(!isBlankOrNull(creditCardType)){
                        AcCreditCardType CreditCardType = cacheDao.findAcCreditCardTypeByNameCache(creditCardType);
                        try {
                            donateMember.setCreditCardType(CreditCardType.getCreditCardTypeId());
                        } catch (NullPointerException nullEx) {
                            setErrorValueInDB(70, creditCardType);
                        }
                    }
                    
                    
                    XSSFCell cell71 = row.getCell(71);
                    String creditCardNo = getStringCellValueSetError(cell71, 71);
                    
                    if(!isBlankOrNull(creditCardNo) ){
                        //return null คือผิด lenght
                        String creditCardNoCheck = ImportUtils.replaceCreditCardNo(creditCardNo, 16);
                        if(creditCardNoCheck == null){
                            setErrorCustom("[ " + mapStringValidation.get(71) + "ผิดพลาด " + creditCardNo + " ]");
                        }else{
                            creditCardNo = creditCardNoCheck;
                        }
                    }
                    
                    donateMember.setCreditCardNo(creditCardNo);

                    XSSFCell cell72 = row.getCell(72);
                    String creditCardName = getStringCellValueNoSetError(cell72);
                    
                    donateMember.setCreditCardName(creditCardName);
                    XSSFCell cell73 = row.getCell(73);
                    String creditCardExpYear = getStringCellValueNoSetError(cell73);
                    donateMember.setCreditCardExpYear(creditCardExpYear);
                    XSSFCell cell74 = row.getCell(74);
                    String creditCardExpMonth = getStringCellValueNoSetError(cell74);
                    donateMember.setCreditCardExpMonth(creditCardExpMonth);
                    XSSFCell cell79 = row.getCell(79);
                    BigDecimal amount = getBigDecimalCellValueSetError(cell79, 79);
                    donateMember.setAmount(amount);
                    
                    XSSFCell cell80 = row.getCell(80);
                    Integer offDate = getIntegerCellValueSetError(cell80, 80);
                    donateMember.setOffDate(offDate);
                    break;
                }
            case STRING_B:
                {
                    XSSFCell cell75 = row.getCell(75);
                    String bankName = getStringCellValueSetError(cell75, 75);
                    Integer bankId = null;
                    if(!isBlankOrNull(bankName)){
                        ShBank bankDao = cacheDao.findShBankByBankNameCache(bankName);
                        try {
                            bankId = bankDao.getBankId();
                            donateMember.setBankId(bankId);
                        } catch (NullPointerException nullEx) {
                            validationError.append(" [ไม่มี ").append(mapStringValidation.get(75)).append(bankName).append(" ในฐานข้อมูล").append(" ] ");
                        }
                    }
                    XSSFCell cell76 = row.getCell(76);
                    String bankBranchName = getStringCellValueNoSetError(cell76);
                    if(!isBlankOrNull(bankBranchName)){
                        ShBankBranch bankBranch = cacheDao.findShBankBranchByBankBranchNameAndBankIdCache(bankBranchName, bankId);
                        try {
                            donateMember.setBankBranchId(bankBranch.getBankBranchId());
                        } catch (NullPointerException nullEx) {
                        }
                    }
                    
                    XSSFCell cell77 = row.getCell(77);
                    String bankAccount = getStringCellValueSetError(cell77, 77);
                    if(!isBlankOrNull(bankAccount) ){
                        //return null คือผิด lenght
                        String bankAccountCheck = ImportUtils.replaceDash(bankAccount,10);
                        if(bankAccountCheck == null){
                            setErrorCustom("[ " + mapStringValidation.get(77) + "ผิดพลาด " + bankAccount + " ]");
                        }else{
                            bankAccount = bankAccountCheck;
                        }
                    }
                    donateMember.setBankAccount(bankAccount);
                    XSSFCell cell78 = row.getCell(78);
                    String bankAccountName = getStringCellValueSetError(cell78, 78);
                    donateMember.setBankAccountName(bankAccountName);
                    XSSFCell cell79 = row.getCell(79);
                    BigDecimal amount = getBigDecimalCellValueSetError(cell79, 79);
                    donateMember.setAmount(amount);
                    
                    XSSFCell cell80 = row.getCell(80);
                    Integer offDate = getIntegerCellValueSetError(cell80, 80);
                    donateMember.setOffDate(offDate);
                    break;
                }
            case STRING_D:
                {
                    donateMember.setAmount(oldAmount);
                    break;
                }
        }
        

        donateMember.setOldDonateDate(oldDonateDate);
        donateMember.setIsCancel(STRING_N);
        donateMember.setIsLockUpdate(STRING_N);
        XSSFCell cell64 = row.getCell(64);
        String bookNo = getStringFormatNoSetError(cell64, "##");

        XSSFCell cell65 = row.getCell(65);
        String receipt = getStringFormatNoSetError(cell65, "##");
        
//        XSSFCell cell66 = row.getCell(66);
//        String objective = getStringCellValueNoSetError(cell66); // วัตถุประสงค์
        XSSFCell cell61 = row.getCell(61);
        String donateName = getStringCellValueNoSetError(cell61); // ผู้บริจาคร่วม
        
        String addition = getAddition(bookNo, receipt, dateToshortDate(oldDonateDate), purPose, donateName);
        donateMember.setAddition(addition);
        
        donateMember.setCreateTime(NOW);
        donateMember.setCreateUserId(CREATE_USER_ID);
        donateMember.setCreateProg(CREATE_PROG);
        
        donateMember.setLastUpdTime(NOW);
        donateMember.setLastUpdUserId(CREATE_USER_ID);
        donateMember.setLastUpdProg(CREATE_PROG);
        donateMember.setLastUpdVersion(1);
        
        //DONATE_MEMBER_NO	Gen ตามหลักการโปรแกรม
        try {
            String donateMemberNo = getFormDonatorNo(person.getBusinessUnitId(), budgetYear.substring(2));
            donateMember.setDonateMemberNo(donateMemberNo);
        } catch (NullPointerException e) {
             validationError.append(" [Gen DonateMemberNo ผิดพลาด] ");
        }
        cacheDao.addEntity(donateMember);
        return donateMember;
    }

    private AcDonateMemberAccount AddDoanteMemberAccount(XSSFRow row, ShPerson person, AcDonateMember donateMember) {
        AcDonateMemberAccount donateMemberAccount = new AcDonateMemberAccount();
//        
        donateMemberAccount.setBusinessUnitId(person.getBusinessUnitId());
        donateMemberAccount.setDonateMemberId(donateMember.getDonateMemberId());
        XSSFCell cell81 = row.getCell(81);
        String accountFullCode = getStringCellValueSetError(cell81, 81);
        Integer accountId = null;
        if(!isBlankOrNull(accountFullCode)){
            accountId = getAccountId(accountFullCode);
        }
        donateMemberAccount.setAccountId(accountId);
        
        XSSFCell cell82 = row.getCell(82);
        String departmentFullCode = getStringCellValueSetError(cell82, 82);
        Integer departmentId = null;
        if(!isBlankOrNull(departmentFullCode)){
            departmentId = getDepartmentId(departmentFullCode);
        }
        donateMemberAccount.setDepartmentId(departmentId);
        
        
        XSSFCell cell83 = row.getCell(83);
        String planFullCode = getStringCellValueSetError(cell83, 83);
        Integer planId = null;
        if(!isBlankOrNull(planFullCode)){
            planId = getPlanId(planFullCode);
        }
        donateMemberAccount.setPlanId(planId);
        
        
        XSSFCell cell84 = row.getCell(84);
        String sourceFullCode = getStringCellValueSetError(cell84, 84);
        Integer sourceId = null;
         if(!isBlankOrNull(sourceFullCode)){
            sourceId = getSourceId(sourceFullCode);
        }
        donateMemberAccount.setSourceId(sourceId);
        
        
        XSSFCell cell85 = row.getCell(85);
        String subAccountFullCode = getStringCellValueNoSetError(cell85);
        Integer subAccountId = null;
         if(!isBlankOrNull(subAccountFullCode)){
            subAccountId = getSubAccountId(subAccountFullCode, departmentId, sourceId);
        }
        donateMemberAccount.setSubAccountId(subAccountId);
        
        
        donateMemberAccount.setIsCancel(STRING_N);
        donateMemberAccount.setIsLockUpdate(STRING_N);
        donateMemberAccount.setCreateTime(NOW);
        donateMemberAccount.setCreateTime(NOW);
        donateMemberAccount.setCreateProg(CREATE_PROG);
        donateMemberAccount.setCreateUserId(CREATE_USER_ID);
        donateMemberAccount.setLastUpdTime(NOW);
        donateMemberAccount.setLastUpdUserId(CREATE_USER_ID);
        donateMemberAccount.setLastUpdProg(CREATE_PROG);
        donateMemberAccount.setLastUpdVersion(1);
        cacheDao.addEntity(donateMemberAccount);
        return donateMemberAccount;
    }

    private ShMember AddMember(XSSFRow row, ShPerson person) {
        ShMember member = new ShMember();
        member.setBusinessUnitId(person.getBusinessUnitId());
        member.setPersonId(person.getPersonId());
        XSSFCell cell63 = row.getCell(63);
        Date oldDonateDate = getDateCellValueIsNotEmptySetError(cell63, 63);
        String budgetYear = dateToBudgetYear(oldDonateDate);
        
        try{
            subBudgetYear = budgetYear.substring(2);
        }catch(NullPointerException nullEx){
            validationError.append(" ไม่มี ").append("ปีงบประมาณ [").append(budgetYear).append(" ] ");
        }
         
        try {
            String memberNo = getFormMemberNo(person.getBusinessUnitId(), subBudgetYear);
            member.setMemberNo(memberNo);
        } catch (NullPointerException e) {
            validationError.append(" [Gen MemberNo ผิดพลาด] ");
        }
        XSSFCell cell1 = row.getCell(1);
        String memberTypeName = getStringCellValueSetError(cell1, 1);
        ShMemberType findShMemberTypeByName = cacheDao.findShMemberTypeByNameCache(memberTypeName);
        if(findShMemberTypeByName == null){
            setError(1);
        }
        member.setMemberTypeId(findShMemberTypeByName);
        member.setMemberRequestId(null);
        
        member.setMemberSource(STRING_A);
        member.setDonatorId(null);
        member.setDonatorRelate(null);
        XSSFCell cell68 = row.getCell(68);
        Date actorData = getDateCellValueSetError(cell68, 68);
        member.setRegisterDate(actorData);
        member.setMemberRequestRelationId(null);
        member.setDepartmentId(person.getBusinessUnitId());
        member.setOldRegisterDate(actorData);
        member.setOldTotalAmount(BigDecimal.ZERO);
        member.setOldPaidAmount(BigDecimal.ZERO);
        member.setOldPaidDate(null);
        member.setOldPaidYear(null);
        member.setOldPaidTerm(null);
        XSSFCell cell67 = row.getCell(67);
        String pruPose = getStringCellValueNoSetError(cell67);
        member.setOldMemberNo(pruPose);
        XSSFCell cell62 = row.getCell(62);
        BigDecimal amount = getBigDecimalCellValueSetError(cell62, 62);
        member.setAmount(amount);
        member.setIsCancel(STRING_N);
        member.setIsLockUpdate(STRING_N);
        member.setCreateTime(NOW);
        member.setCreateProg(CREATE_PROG);
        member.setCreateUserId(CREATE_USER_ID);
        member.setLastUpdTime(NOW);
        member.setLastUpdUserId(CREATE_USER_ID);
        member.setLastUpdProg(CREATE_PROG);
        member.setLastUpdVersion(1);
        
        
        //-- เตรียมค่าเพื่อนำไปสร้าง Addition --//
        XSSFCell cell64 = row.getCell(64);
        String bookNo = getStringFormatNoSetError(cell64, "##");

        XSSFCell cell65 = row.getCell(65);
        String receipt = getStringFormatNoSetError(cell65, "##");
        
        
        XSSFCell cell66 = row.getCell(66);
        String purPose = getStringCellValueNoSetError(cell66);
        
        XSSFCell cell61 = row.getCell(61);
        String donateName = getStringCellValueNoSetError(cell61); // ผู้บริจาคร่วม
        
        
        String addition = getAddition(bookNo, receipt, dateToshortDate(oldDonateDate), purPose, donateName);
        member.setAddition(addition);
        
        
        cacheDao.addEntity(member);
        return member;
    }

    private String getFormDonatorNo(Integer departmentId, String combine3) throws NullPointerException{
        try {
            if(!isNullOrZero(departmentId) && !isBlankOrNull(combine3)){
                String newSeqNo = getNewSeqNo(departmentId, DEPARTMENT_CODE, COMBINE2, combine3, FORM_TYPE_CODE_DONATOR, PREFIX_LETTER_DONATOR);
                StringBuilder formRunning = new StringBuilder();
                return formRunning.append(PREFIX_LETTER_DONATOR).append(DEPARTMENT_CODE).append(COMBINE2).append(combine3).append(newSeqNo).toString();
            }
         } catch (NullPointerException e) {
            
        }
        throw new NullPointerException();
    }
    
    private String getFormMemberNo(Integer departmentId, String combine3) throws NullPointerException{
        try {
            if(!isNullOrZero(departmentId) && !isBlankOrNull(combine3)){
                String newSeqNo = getNewSeqNo(departmentId, DEPARTMENT_CODE, COMBINE2, combine3, FORM_TYPE_CODE_MEMBER, PREFIX_LETTER_MEMBER);
                StringBuilder formRunning = new StringBuilder();
                return formRunning.append(PREFIX_LETTER_MEMBER).append(DEPARTMENT_CODE).append(COMBINE2).append(combine3).append(newSeqNo).toString();
            }
        } catch (NullPointerException e) {
            
        }
        throw new NullPointerException();
        
    }
    
    private boolean validatAddAddress(XSSFRow row) {
        int start = 48;
        int end = 59;
        for (int i = start; i < end; i++) {
            try {
                getCellValue(row.getCell(i));
            } catch (NullPointerException e) {
                return false;
            }
        }
        return true;
    }

    private ShMemberCard AddMemberCard(XSSFRow row, ShPerson person, ShMember member) {
        ShMemberCard memberCard = new ShMemberCard();
        memberCard.setBusinessUnitId(person.getBusinessUnitId());
        
        XSSFCell cell67 = row.getCell(67);
        String memberCardNo = getStringCellValueNoSetError(cell67);
        memberCard.setMemberCardNo(memberCardNo);
        
        memberCard.setMemberId(member);
        memberCard.setIsCancel(STRING_N);
        memberCard.setIsLockUpdate(STRING_N);
        memberCard.setCreateTime(NOW);
        memberCard.setCreateProg(CREATE_PROG);
        memberCard.setCreateUserId(CREATE_USER_ID);
        memberCard.setLastUpdTime(NOW);
        memberCard.setLastUpdUserId(CREATE_USER_ID);
        memberCard.setLastUpdProg(CREATE_PROG);
        memberCard.setLastUpdVersion(1);
        cacheDao.addEntity(memberCard);
        return memberCard;
    }

    private void addPersonDoc(XSSFRow row, ShPerson person) {
        XSSFCell cell14 = row.getCell(14);
        String docNo ;
        try {
            docNo = getStringCellValue(cell14);
        } catch (NullPointerException nullEx) {
            return;
        }
        ShPersonDoc personDoc = new ShPersonDoc();
        personDoc.setBusinessUnitId(person.getBusinessUnitId());
        personDoc.setPersonId(person);
        personDoc.setSeqOrder(1);
        XSSFCell cell12 = row.getCell(12);
        String docName = getStringCellValueNoSetError(cell12);
        try {
            DocType docType = DocType.valueOf(docName);
            personDoc.setDocType(docType.getType());
        } catch (NullPointerException e) {
            personDoc.setDocType(STRING_C);
        }
        XSSFCell cell13 = row.getCell(13);
        String issuer = getStringCellValueNoSetError(cell13);
        personDoc.setIssuer(issuer);
        personDoc.setDocNo(docNo);
        XSSFCell cell15 = row.getCell(15);
        Date expireDate = getDateCellValueIsNotEmptySetError(cell15, 15);
        personDoc.setExpireDate(expireDate);
        personDoc.setIsCancel(STRING_N);
        personDoc.setIsLockUpdate(STRING_N);
        personDoc.setCreateTime(NOW);
        personDoc.setCreateUserId(CREATE_USER_ID);
        personDoc.setCreateProg(CREATE_PROG);
        personDoc.setLastUpdTime(NOW);
        personDoc.setLastUpdUserId(CREATE_USER_ID);
        personDoc.setLastUpdProg(CREATE_PROG);
        personDoc.setLastUpdVersion(1);
        cacheDao.addEntity(personDoc);
    }
    
}
