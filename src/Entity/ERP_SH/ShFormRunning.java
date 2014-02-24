/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_SH;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "SH_FORM_RUNNING")
@TableGenerator(
	name="counter_sh_form_running", 
	table="FW_SEQUENCE_GENERATOR", 
	pkColumnName="name", 
	valueColumnName="value", 
	pkColumnValue="SH_FORM_RUNNING", 
	initialValue=1, 
	allocationSize=10)
public class ShFormRunning implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "BUSINESS_UNIT_ID")
    private int businessUnitId;
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="counter_sh_form_running")
    @Basic(optional = false)
    @Column(name = "FORM_RUNNING_ID")
    private Integer formRunningId;
    @Column(name = "FORM_TYPE_CODE")
    private String formTypeCode;
    @Basic(optional = false)
    @Column(name = "PREFIX_LETTER")
    private String prefixLetter;
    @Basic(optional = false)
    @Column(name = "CHAR_COMBINE_1")
    private String charCombine1;
    @Basic(optional = false)
    @Column(name = "CHAR_COMBINE_2")
    private String charCombine2;
    @Basic(optional = false)
    @Column(name = "CHAR_COMBINE_3")
    private String charCombine3;
    @Basic(optional = false)
    @Column(name = "LAST_SEQ_NO")
    private int lastSeqNo;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "CREATE_USER_ID")
    private String createUserId;
    @Column(name = "CREATE_PROG")
    private String createProg;
    @Column(name = "LAST_UPD_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdTime;
    @Column(name = "LAST_UPD_USER_ID")
    private String lastUpdUserId;
    @Column(name = "LAST_UPD_PROG")
    private String lastUpdProg;
    @Column(name = "LAST_UPD_VERSION")
    private Integer lastUpdVersion;

    public ShFormRunning() {
    }

    public ShFormRunning(Integer formRunningId) {
        this.formRunningId = formRunningId;
    }

    public ShFormRunning(Integer formRunningId, int businessUnitId, String prefixLetter, String charCombine1, String charCombine2, String charCombine3, int lastSeqNo) {
        this.formRunningId = formRunningId;
        this.businessUnitId = businessUnitId;
        this.prefixLetter = prefixLetter;
        this.charCombine1 = charCombine1;
        this.charCombine2 = charCombine2;
        this.charCombine3 = charCombine3;
        this.lastSeqNo = lastSeqNo;
    }

    public int getBusinessUnitId() {
        return businessUnitId;
    }

    public void setBusinessUnitId(int businessUnitId) {
        this.businessUnitId = businessUnitId;
    }

    public Integer getFormRunningId() {
        return formRunningId;
    }

    public void setFormRunningId(Integer formRunningId) {
        this.formRunningId = formRunningId;
    }

    public String getFormTypeCode() {
        return formTypeCode;
    }

    public void setFormTypeCode(String formTypeCode) {
        this.formTypeCode = formTypeCode;
    }

    public String getPrefixLetter() {
        return prefixLetter;
    }

    public void setPrefixLetter(String prefixLetter) {
        this.prefixLetter = prefixLetter;
    }

    public String getCharCombine1() {
        return charCombine1;
    }

    public void setCharCombine1(String charCombine1) {
        this.charCombine1 = charCombine1;
    }

    public String getCharCombine2() {
        return charCombine2;
    }

    public void setCharCombine2(String charCombine2) {
        this.charCombine2 = charCombine2;
    }

    public String getCharCombine3() {
        return charCombine3;
    }

    public void setCharCombine3(String charCombine3) {
        this.charCombine3 = charCombine3;
    }

    public int getLastSeqNo() {
        return lastSeqNo;
    }

    public void setLastSeqNo(int lastSeqNo) {
        this.lastSeqNo = lastSeqNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateProg() {
        return createProg;
    }

    public void setCreateProg(String createProg) {
        this.createProg = createProg;
    }

    public Date getLastUpdTime() {
        return lastUpdTime;
    }

    public void setLastUpdTime(Date lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    public String getLastUpdUserId() {
        return lastUpdUserId;
    }

    public void setLastUpdUserId(String lastUpdUserId) {
        this.lastUpdUserId = lastUpdUserId;
    }

    public String getLastUpdProg() {
        return lastUpdProg;
    }

    public void setLastUpdProg(String lastUpdProg) {
        this.lastUpdProg = lastUpdProg;
    }

    public Integer getLastUpdVersion() {
        return lastUpdVersion;
    }

    public void setLastUpdVersion(Integer lastUpdVersion) {
        this.lastUpdVersion = lastUpdVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formRunningId != null ? formRunningId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShFormRunning)) {
            return false;
        }
        ShFormRunning other = (ShFormRunning) object;
        if ((this.formRunningId == null && other.formRunningId != null) || (this.formRunningId != null && !this.formRunningId.equals(other.formRunningId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_SH.ShFormRunning[ formRunningId=" + formRunningId + " ]";
    }
    
}
