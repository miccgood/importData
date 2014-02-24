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
public enum GuaranteeType {
    ค้ำประกันซอง(ImportData.STRING_A),
    ค้ำประกันสัญญา(ImportData.STRING_B),
    A("ค้ำประกันซอง"),
    B("ค้ำประกันสัญญา");

    private final String type;

    private GuaranteeType(String type) {
       this.type = type;
    }

    public String getType() {
       return type;
    }
}
