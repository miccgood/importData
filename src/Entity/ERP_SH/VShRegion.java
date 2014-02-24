/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_SH;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "V_SH_REGION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VShRegion.findAll", query = "SELECT v FROM VShRegion v"),
    @NamedQuery(name = "VShRegion.findByRegionId", query = "SELECT v FROM VShRegion v WHERE v.regionId = :regionId"),
    @NamedQuery(name = "VShRegion.findByCodeLevel", query = "SELECT v FROM VShRegion v WHERE v.codeLevel = :codeLevel"),
    @NamedQuery(name = "VShRegion.findByL1Code", query = "SELECT v FROM VShRegion v WHERE v.l1Code = :l1Code"),
    @NamedQuery(name = "VShRegion.findByL2Code", query = "SELECT v FROM VShRegion v WHERE v.l2Code = :l2Code"),
    @NamedQuery(name = "VShRegion.findByL3Code", query = "SELECT v FROM VShRegion v WHERE v.l3Code = :l3Code"),
    @NamedQuery(name = "VShRegion.findByL1Name", query = "SELECT v FROM VShRegion v WHERE v.l1Name = :l1Name"),
    @NamedQuery(name = "VShRegion.findByL2Name", query = "SELECT v FROM VShRegion v WHERE v.l2Name = :l2Name"),
    @NamedQuery(name = "VShRegion.findByL3Name", query = "SELECT v FROM VShRegion v WHERE v.l3Name = :l3Name"),
    @NamedQuery(name = "VShRegion.findByFullCode", query = "SELECT v FROM VShRegion v WHERE v.fullCode = :fullCode"),
    @NamedQuery(name = "VShRegion.findByFullCodePad", query = "SELECT v FROM VShRegion v WHERE v.fullCodePad = :fullCodePad"),
    @NamedQuery(name = "VShRegion.findByFullName", query = "SELECT v FROM VShRegion v WHERE v.fullName = :fullName"),
    @NamedQuery(name = "VShRegion.findByIsCancel", query = "SELECT v FROM VShRegion v WHERE v.isCancel = :isCancel")})
public class VShRegion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "REGION_ID")
    @Id
    private int regionId;
    @Basic(optional = false)
    @Column(name = "CODE_LEVEL")
    private int codeLevel;
    @Basic(optional = false)
    @Column(name = "L1_CODE")
    private String l1Code;
    @Basic(optional = false)
    @Column(name = "L2_CODE")
    private String l2Code;
    @Basic(optional = false)
    @Column(name = "L3_CODE")
    private String l3Code;
    @Basic(optional = false)
    @Column(name = "L1_NAME")
    private String l1Name;
    @Basic(optional = false)
    @Column(name = "L2_NAME")
    private String l2Name;
    @Basic(optional = false)
    @Column(name = "L3_NAME")
    private String l3Name;
    @Basic(optional = false)
    @Column(name = "FULL_CODE")
    private String fullCode;
    @Basic(optional = false)
    @Column(name = "FULL_CODE_PAD")
    private String fullCodePad;
    @Basic(optional = false)
    @Column(name = "FULL_NAME")
    private String fullName;
    @Basic(optional = false)
    @Column(name = "IS_CANCEL")
    private String isCancel;

    public VShRegion() {
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(int codeLevel) {
        this.codeLevel = codeLevel;
    }

    public String getL1Code() {
        return l1Code;
    }

    public void setL1Code(String l1Code) {
        this.l1Code = l1Code;
    }

    public String getL2Code() {
        return l2Code;
    }

    public void setL2Code(String l2Code) {
        this.l2Code = l2Code;
    }

    public String getL3Code() {
        return l3Code;
    }

    public void setL3Code(String l3Code) {
        this.l3Code = l3Code;
    }

    public String getL1Name() {
        return l1Name;
    }

    public void setL1Name(String l1Name) {
        this.l1Name = l1Name;
    }

    public String getL2Name() {
        return l2Name;
    }

    public void setL2Name(String l2Name) {
        this.l2Name = l2Name;
    }

    public String getL3Name() {
        return l3Name;
    }

    public void setL3Name(String l3Name) {
        this.l3Name = l3Name;
    }

    public String getFullCode() {
        return fullCode;
    }

    public void setFullCode(String fullCode) {
        this.fullCode = fullCode;
    }

    public String getFullCodePad() {
        return fullCodePad;
    }

    public void setFullCodePad(String fullCodePad) {
        this.fullCodePad = fullCodePad;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel;
    }
    
}
