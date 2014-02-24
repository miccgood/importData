/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.Enum;

import Import.ImportData;

/**
 *
 * @author tanet-t
 */
public enum ReceiveType {

    ผู้บริจาคทั่วไป(ImportData.STRING_D),
    ผู้บริจาคผ่านบัตรเครดิต(ImportData.STRING_C),
    ผู้บริจาคผ่านบัญชีธนาคาร(ImportData.STRING_B),
    สมาชิก(ImportData.STRING_M),
    D(ImportData.STRING_D),
    C(ImportData.STRING_C),
    B(ImportData.STRING_B),
    M(ImportData.STRING_M);

    private final String type;

    private ReceiveType(String type) {
       this.type = type;
    }

    public String getType() {
       return type;
    }
}
