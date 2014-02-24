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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "SH_BANK_BRANCH")
@NamedQueries({
    @NamedQuery(name = "ShBankBranch.findAll", query = "SELECT s FROM ShBankBranch s"),
    @NamedQuery(name = "ShBankBranch.findByBankBranchName", query = "SELECT s FROM ShBankBranch s WHERE s.bankBranchName = :bankBranchName AND s.bankId = :bankId")})
public class ShBankBranch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BANK_BRANCH_ID")
    private Integer bankBranchId;
    @Basic(optional = false)
    @Column(name = "BANK_BRANCH_CODE")
    private String bankBranchCode;
    @Basic(optional = false)
    @Column(name = "BANK_BRANCH_NAME")
    private String bankBranchName;
    @Column(name = "BANK_BRANCH_DESC")
    private String bankBranchDesc;
    @Basic(optional = false)
    @Column(name = "IS_CANCEL")
    private String isCancel;
    @Column(name = "CANCEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelDate;
    @Column(name = "CANCEL_PER_ID")
    private Integer cancelPerId;
    @Basic(optional = false)
    @Column(name = "IS_LOCK_UPDATE")
    private String isLockUpdate;
    @Basic(optional = false)
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Basic(optional = false)
    @Column(name = "CREATE_USER_ID")
    private String createUserId;
    @Basic(optional = false)
    @Column(name = "CREATE_PROG")
    private String createProg;
    @Basic(optional = false)
    @Column(name = "LAST_UPD_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdTime;
    @Basic(optional = false)
    @Column(name = "LAST_UPD_USER_ID")
    private String lastUpdUserId;
    @Basic(optional = false)
    @Column(name = "LAST_UPD_PROG")
    private String lastUpdProg;
    @Basic(optional = false)
    @Column(name = "LAST_UPD_VERSION")
    private int lastUpdVersion;
    @Column(name = "BUSINESS_UNIT_ID")
    private Integer businessUnitId;
    @Column(name = "BANK_BRANCH_NO")
    private String bankBranchNo;
    @JoinColumn(name = "BANK_ID", referencedColumnName = "BANK_ID")
    @ManyToOne
    private ShBank bankId;

    public ShBankBranch() {
    }

    public ShBankBranch(Integer bankBranchId) {
        this.bankBranchId = bankBranchId;
    }

    public ShBankBranch(Integer bankBranchId, String bankBranchCode, String bankBranchName, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.bankBranchId = bankBranchId;
        this.bankBranchCode = bankBranchCode;
        this.bankBranchName = bankBranchName;
        this.isCancel = isCancel;
        this.isLockUpdate = isLockUpdate;
        this.createTime = createTime;
        this.createUserId = createUserId;
        this.createProg = createProg;
        this.lastUpdTime = lastUpdTime;
        this.lastUpdUserId = lastUpdUserId;
        this.lastUpdProg = lastUpdProg;
        this.lastUpdVersion = lastUpdVersion;
    }

    public Integer getBankBranchId() {
        return bankBranchId;
    }

    public void setBankBranchId(Integer bankBranchId) {
        this.bankBranchId = bankBranchId;
    }

    public String getBankBranchCode() {
        return bankBranchCode;
    }

    public void setBankBranchCode(String bankBranchCode) {
        this.bankBranchCode = bankBranchCode;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public String getBankBranchDesc() {
        return bankBranchDesc;
    }

    public void setBankBranchDesc(String bankBranchDesc) {
        this.bankBranchDesc = bankBranchDesc;
    }

    public String getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public Integer getCancelPerId() {
        return cancelPerId;
    }

    public void setCancelPerId(Integer cancelPerId) {
        this.cancelPerId = cancelPerId;
    }

    public String getIsLockUpdate() {
        return isLockUpdate;
    }

    public void setIsLockUpdate(String isLockUpdate) {
        this.isLockUpdate = isLockUpdate;
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

    public int getLastUpdVersion() {
        return lastUpdVersion;
    }

    public void setLastUpdVersion(int lastUpdVersion) {
        this.lastUpdVersion = lastUpdVersion;
    }

    public Integer getBusinessUnitId() {
        return businessUnitId;
    }

    public void setBusinessUnitId(Integer businessUnitId) {
        this.businessUnitId = businessUnitId;
    }

    public String getBankBranchNo() {
        return bankBranchNo;
    }

    public void setBankBranchNo(String bankBranchNo) {
        this.bankBranchNo = bankBranchNo;
    }

    public ShBank getBankId() {
        return bankId;
    }

    public void setBankId(ShBank bankId) {
        this.bankId = bankId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankBranchId != null ? bankBranchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShBankBranch)) {
            return false;
        }
        ShBankBranch other = (ShBankBranch) object;
        if ((this.bankBranchId == null && other.bankBranchId != null) || (this.bankBranchId != null && !this.bankBranchId.equals(other.bankBranchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_SH.ShBankBranch[ bankBranchId=" + bankBranchId + " ]";
    }
    
}
