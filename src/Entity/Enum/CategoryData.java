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
public enum CategoryData {
    กองทุน("Capital"),
    ผู้บริจาค("Donation"),
    ผู้บริจาค2("Donation2"),
    Capital("Capital"),
    Donation("Donation"),
    หลักประกัน("Guarantee"),
    Guarantee("Guarantee"),
    ProgrammerMode("ProgrammerMode");
    
    private final String type;

    private CategoryData(String type) {
       this.type = type;
    }

    public String getType() {
       return type;
    }
}
