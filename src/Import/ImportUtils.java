/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Import;

/**
 *
 * @author tanet-t
 */
public class ImportUtils {
    
    public static String replaceCreditCardNo(String creditCardNo){
        return replaceString(creditCardNo, "-", "", 16);
    }
    
    public static String replaceCreditCardNo(String creditCardNo, String oldString){
        return replaceString(creditCardNo, oldString, "", 16);
    }
    
    public static String replaceCreditCardNo(String creditCardNo, int length){
        return replaceString(creditCardNo, "-", "", length);
    }
    
    public static String replaceDash(String creditCardNo, int length){
        return replaceString(creditCardNo, "-", "", length);
    }
    
    public static String replaceString(String inputString, String oldString, String newString, int lengthInput){
        try{
            inputString = inputString.replace(oldString, newString);
            int length = inputString.length();
            
            //ถ้าความยาวข้อมูลหลัง replace ไม่เท่ากับที่ต้องการ lengthInput 
            if(length != lengthInput){
                return null;
            }else{
//                int endIndex = (length < lengthInput ? length : lengthInput );
                return inputString.substring(0, lengthInput);
            }
            
        } catch (NullPointerException nullEx){
            return "";
        }
        
    }
    
    
    public static String subString(String inputString, int lengthInput, boolean returnNull){
        try{
            int length = inputString.length();
            
            //ถ้าความยาวตัวอักษรInputยาวกว่า ที่ต้อง ให้ตัดทิ้ง
            if(length > lengthInput){
                return (returnNull ? null : inputString.substring(0, lengthInput));
            } else {
                //ถ้าความยาวตัวอักษรInput น้อยกว่า = ที่ต้องการให้ใช้  ความยาว input
                return inputString.substring(0, length);
            }
        } catch (NullPointerException nullEx){
            return "";
        }
        
    }
    
    
}
