/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Import;

import Entity.ERP_FI.FiCapital;
import Entity.ERP_FI.FiFund;
import Entity.ERP_SH.ShPerson;
import GUI.TestGUI;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;


/**
 *
 * @author tanet-t
 */
public class ImportCapital extends ImportData{
   
    protected static final int START_ROW_CAPITAL = 5; 
    private static final String INTERREST_STRING = "ดอกผลกองทุน";
    static {
        mapStringValidation.put(0, "");
        mapStringValidation.put(1, "รหัสหน่วยงาน ");
        mapStringValidation.put(2, "รหัสกองทุน ");
        mapStringValidation.put(3, "รหัสทุน ");
        mapStringValidation.put(4, "ชื่อทุน ");
        mapStringValidation.put(5, "ประเภทดอกผลทุน ");
        mapStringValidation.put(6, "วัตถุประสงค์ ");
        mapStringValidation.put(7, "วันที่จัดตั้ง ");
        mapStringValidation.put(8, "หมายเหตุ ");
        mapStringValidation.put(9, "รหัสบัญชี ");
        mapStringValidation.put(10, "รหัสแหล่งเงิน ");
        mapStringValidation.put(11, "รหัสแผนงาน ");
        mapStringValidation.put(12, "ยอดทุนคงเหลือ ");
        mapStringValidation.put(13, "ชื่อผู้ก่อตั้ง ");
        mapStringValidation.put(14, "ที่อยู่ผู้ก่อตั้ง ");
    }

    public ImportCapital() {
        super(START_ROW_CAPITAL);
        cacheDao.initCapital();
        super.businessUnitId12 = cacheDao.findDepartIdmentByFullCodeCache("12");
    }

    @Override
    public int getSheetRowCount(XSSFSheet sheet){
        int lastRowNum = sheet.getLastRowNum();
        lastRowNum++;
        for (int i = START_ROW_CAPITAL; i < lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            XSSFCell cell1 = row.getCell(1);
            XSSFCell cell2 = row.getCell(2);
            XSSFCell cell3 = row.getCell(3);
            XSSFCell cell4 = row.getCell(4);
            
            if( ( cell1 == null || getStringCellValueNoSetError(cell1) == null )
                && ( cell2 == null || getStringCellValueNoSetError(cell2) == null )
                && ( cell3 == null || getStringCellValueNoSetError(cell3) == null )
                && ( cell4 == null || getStringCellValueNoSetError(cell4) == null )){
                return i - START_ROW_CAPITAL;
            }
        }
        return lastRowNum - START_ROW_CAPITAL;
    }
    
    
    @Override
    protected void threadProcess(XSSFSheet sheet, int index, int lastRowNum){
        validationError = new StringBuffer();

        XSSFRow row = sheet.getRow(index);

        int rowCount = index+1;
        //ไม่ได้ใช้ A
        //XSSFCell cell0 = row.getCell(0);

        //รหัสหน่วยงาน B					 			
        XSSFCell cell1 = row.getCell(1);
        String depaertmentCode = this.getStringCellValueSetError(cell1, 1);

        Integer departmentId ;
        Integer businessUnitId ;
        if(!isBlankOrNull(depaertmentCode)){
            if(TestGUI.IsEnableLog()){
                logln("ตรวจสอบแถวที่ " + rowCount);
            }
            departmentId = cacheDao.findDepartIdmentByFullCodeCache(depaertmentCode);
            businessUnitId = departmentId;
        }else{
            departmentId = 0;
            businessUnitId = 0;
//            validationError.append(" ไม่มี ").append(mapStringValidation.get(1)).append(" [ ").append(depaertmentCode).append(" ] ");
//            if(index == START_ROW_CAPITAL){
//                validationErrorList.add(new StringBuffer("ไม่พบข้อมูล"));
//                logln("ไม่พบข้อมูล");
//            }
//            logln("จบการทำงาน " + (index-5) + " รายการ");
//            return;
        }

        //รหัสกองทุน C
        XSSFCell cell2 = row.getCell(2);
        String fundCode = this.getStringCellValueSetError(cell2, 2);
        FiFund fundDao = null; 
        if(!isBlankOrNull(fundCode) ){
            fundDao = cacheDao.findFundByFundCode(fundCode, departmentId);
            if(fundDao == null || isNullOrZero(fundDao.getFundId())){
                validationError.append(" [ไม่มี ").append(mapStringValidation.get(2)).append(fundCode).append(" ในหน่วยงาน ").append(depaertmentCode).append(" ] ");
            }
        }

        //รหัสทุน D
        XSSFCell cell3 = row.getCell(3);
        String capitalCode = this.getStringCellValueSetError(cell3, 3);

        //ชื่อทุน E
        XSSFCell cell4 = row.getCell(4);
        String capitalName = this.getStringCellValueSetError(cell4, 4);

        //ประเภทดอกผลทุน F
        XSSFCell cell5 = row.getCell(5);
        String interestType = this.getStringCellValueNoSetError(cell5);
        interestType = (!isBlankOrNull(interestType) && INTERREST_STRING.equals(interestType)) ? STRING_C : STRING_I;

        //วัตถุประสงค์ G
        XSSFCell cell6 = row.getCell(6);
        String capitalDesc = this.getStringCellValueNoSetError(cell6);

        //วันที่จัดตั้ง H
        XSSFCell cell7 = row.getCell(7);
        Date setupDate = this.getDateCellValueNoSetError(cell7);

        //หมายเหตุ I
        XSSFCell cell8 = row.getCell(8);
        String note = this.getStringCellValueNoSetError(cell8);

        //รหัสบัญชี J				
        XSSFCell cell9 = row.getCell(9);
        String accountCode = this.getStringCellValueSetError(cell9, 9);
        Integer accountId = null ;
        if(!isBlankOrNull(accountCode)){
            accountId = cacheDao.getAccountIdByFullCodeCache(accountCode);
            if(isNullOrZero(accountId)){
                validationError.append(" [ไม่มี ").append(mapStringValidation.get(9)).append(accountCode).append(" ในฐานข้อมูล").append(" ] ");
            }
        }

        //รหัสแหล่งเงิน K
        XSSFCell cell10 = row.getCell(10);
        String sourceCode = this.getStringCellValueSetError(cell10, 10);
        Integer sourceId = null;
        if(!isBlankOrNull(sourceCode)){
            sourceId = cacheDao.getSourceIdByFullCodeCache(sourceCode);
            if(isNullOrZero(sourceId)){
                validationError.append(" [ไม่มี ").append(mapStringValidation.get(10)).append(sourceCode).append(" ในฐานข้อมูล").append(" ] ");
            }
        }

        //รหัสแผนงาน L
        XSSFCell cell11 = row.getCell(11);
        String planCode = this.getStringCellValueSetError(cell11, 11);
        Integer planId = null ;
        if(!isBlankOrNull(planCode)){
            planId = cacheDao.findPlanIdmentByFullCodeCache(planCode);
            if(isNullOrZero(planId)){
                 validationError.append(" [ไม่มี ").append(mapStringValidation.get(11)).append(planCode).append(" ในฐานข้อมูล").append(" ] ");
            }
        }

        //ยอดทุนคงเหลือ M
        XSSFCell cell12 = row.getCell(12);
        BigDecimal balance = this.getBigDecimalCellValueNoSetError(cell12);

        //ชื่อผู้ก่อตั้ง N
        XSSFCell cell13 = row.getCell(13);
        String firstName = this.getStringCellValueNoSetError(cell13);

        //ที่อยู่ผู้ก่อตั้ง O
        XSSFCell cell14 = row.getCell(14);
        String address = this.getStringCellValueNoSetError(cell14);

        if(validationError.length() > 0){
            //ถ้ามี error แค่ row เดียวก็ไม่ให้ commit
            this.commit = false;
            if(TestGUI.IsEnableLogError()){
                if(!TestGUI.IsEnableLog()){
                    logln("ตรวจสอบแถวที่ " + rowCount);
                }
                log.append("   Error : ");
                log.append(validationError.toString());
                log.append("\n");
            }
           
            validationError.insert(0," ").insert(0,rowCount).insert(0, "ROW ");
            validationErrorList.add(validationError);

        }else{
            //ถ้ายังไม่มีตัวผิดให้บันทึกข้อมูลลงไปเรื่อยๆ
            if(this.commit){

                FiCapital capital = createFiCapital(departmentId, fundDao, capitalCode, capitalName, interestType, capitalDesc, setupDate, note, accountId, sourceId, planId, balance);

                //ตาม spec ต้องมี @N ถึงจะเพิ่ม person และ capitalFounder
                if(!isBlankOrNull(firstName)){
                    ShPerson person = createShPerson(firstName, address, businessUnitId);

                    createFiCapitalFounder(capital.getCapitalId(), person.getPersonId());
                }
            }
            if(TestGUI.IsEnableLog()){
                log.append("      สำเร็จ");
                log.append("\n");
            }
            
        }
    }   
   
}
