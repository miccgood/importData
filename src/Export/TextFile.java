/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Export;

import GUI.TestGUI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Calendar;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author tanet-t
 */
public class TextFile {
    private static JTextArea log;
    static {
        log = TestGUI.getInstance();
    }
    public static String write(File file, List<StringBuffer> validationErrorList) {
        
        String fileName = TextFile.getFileName(file);
        
        createFile(fileName, validationErrorList);

        TestGUI.refresh();
        
        return fileName;
        
    }
    
    private static void createFile(String fileName, List<StringBuffer> validationErrorList){
        
//        try {
//            File f = new File(fileName);
//            f.createNewFile();
//            try (BufferedWriter outWriter = new BufferedWriter(new FileWriter(f))) {
//                log.append("กำลังเขียนไฟล์ ");
//                if(validationErrorList != null && !validationErrorList.isEmpty()){
//                    for (int i = 0; i < validationErrorList.size(); i++) {
//                        StringBuffer errorRow = validationErrorList.get(i);
//                        outWriter.write(errorRow.toString());
//                        outWriter.newLine();
//                    }
//                } else {
//                    outWriter.write("ไม่พบข้อผิดพลาด");
//                }
//                log.append(fileName + " สำเร็จ");
//                outWriter.close();
//            }
//        } catch (IOException e) {
//            log.append(e.getMessage());
//            log.append(fileName + " ไม่สำเร็จ");
//        }
        try {
            File f = new File(fileName);
            f.createNewFile();
            try (BufferedWriter outWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"))) {
                log.append("กำลังเขียนไฟล์ ");
                if(validationErrorList != null && !validationErrorList.isEmpty()){
                    for (int i = 0; i < validationErrorList.size(); i++) {
                        StringBuffer errorRow = validationErrorList.get(i);
                        outWriter.write(errorRow.toString());
                        outWriter.newLine();
                    }
                } else {
                    outWriter.write("ไม่พบข้อผิดพลาด");
                }
                log.append(fileName + " สำเร็จ");
                outWriter.close();
            }
        }   catch (IOException ex) {
            log.append(ex.getMessage());
            log.append(fileName + " ไม่สำเร็จ");
        }
       
    }
    
    private static String getFileName(File file){
        String fileName = file.getName();
        String pathFile = file.getAbsolutePath().replace(fileName, "");
        fileName = fileName.substring(0, fileName.lastIndexOf("."));
        Calendar c = Calendar.getInstance();

        StringBuilder newFileName = new StringBuilder(pathFile+fileName);
        newFileName.append("_");
        int minInt = c.get(Calendar.MINUTE);
        String minString = "00";
        if(minInt < 10){
            minString = "0" + String.valueOf(minInt);
        }else{
            minString = String.valueOf(minInt);
        }
        return newFileName.append(c.get(Calendar.DAY_OF_MONTH)).append("-").append(c.get(Calendar.MONTH) + 1).append("-").append(c.get(Calendar.YEAR))
        .append("(").append(c.get(Calendar.HOUR_OF_DAY)).append(".").append(minString).append(".").append(c.get(Calendar.MILLISECOND)).append(")-out.txt").toString();

    }
}
