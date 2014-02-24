/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.Enum;

/**
 *
 * @author tanet-t
 */
public enum DocType {
    
    บัตรประจำตัวประชาชน("C"),
    Citizen("C"),
    C("C"),
    
    เลขที่หนังสือเดินทาง("P"),
    Passport("P"),
    P("P"),
    
    ใบขับขี่("D"),
    Driver("D"),
    D("D"),
    
    //คือเลขที่ทะเบียนนิติบุคคล บนหน้าจอ FiDnS001_02
    เลขที่ผู้ประกอบการ("J"),
    Operator("J"),
    O("J");
    
    private final String type;

    private DocType(String type) {
       this.type = type;
    }

    public String getType() {
       return type;
    }
}
