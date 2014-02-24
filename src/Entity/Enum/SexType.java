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
public enum SexType {
    M(ImportData.STRING_M),
    F(ImportData.STRING_F),
    N(ImportData.STRING_N),
    ชาย(ImportData.STRING_M),
    หญิง(ImportData.STRING_F);

    private final String description;

    private SexType(String description) {
       this.description = description;
    }

    public String getDescription() {
       return description;
    }
}
