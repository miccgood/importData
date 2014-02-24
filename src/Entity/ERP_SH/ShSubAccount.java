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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "SH_SUB_ACCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShSubAccount.findAll", query = "SELECT s FROM ShSubAccount s"),
    @NamedQuery(name = "ShSubAccount.findBySubAccountId", query = "SELECT s FROM ShSubAccount s WHERE s.subAccountId = :subAccountId"),
    @NamedQuery(name = "ShSubAccount.findByDepartmentId", query = "SELECT s FROM ShSubAccount s WHERE s.departmentId = :departmentId"),
    @NamedQuery(name = "ShSubAccount.findBySubAccountCode", query = "SELECT s FROM ShSubAccount s WHERE s.subAccountCode = :subAccountCode"),
    @NamedQuery(name = "ShSubAccount.findBySubAccountName", query = "SELECT s FROM ShSubAccount s WHERE s.subAccountName = :subAccountName"),
    @NamedQuery(name = "ShSubAccount.findBySubAccountDesc", query = "SELECT s FROM ShSubAccount s WHERE s.subAccountDesc = :subAccountDesc"),
    @NamedQuery(name = "ShSubAccount.findByIsCancel", query = "SELECT s FROM ShSubAccount s WHERE s.isCancel = :isCancel"),
    @NamedQuery(name = "ShSubAccount.findByCancelDate", query = "SELECT s FROM ShSubAccount s WHERE s.cancelDate = :cancelDate"),
    @NamedQuery(name = "ShSubAccount.findByCancelPerId", query = "SELECT s FROM ShSubAccount s WHERE s.cancelPerId = :cancelPerId"),
    @NamedQuery(name = "ShSubAccount.findByIsLockUpdate", query = "SELECT s FROM ShSubAccount s WHERE s.isLockUpdate = :isLockUpdate"),
    @NamedQuery(name = "ShSubAccount.findByCreateTime", query = "SELECT s FROM ShSubAccount s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "ShSubAccount.findByCreateUserId", query = "SELECT s FROM ShSubAccount s WHERE s.createUserId = :createUserId"),
    @NamedQuery(name = "ShSubAccount.findByCreateProg", query = "SELECT s FROM ShSubAccount s WHERE s.createProg = :createProg"),
    @NamedQuery(name = "ShSubAccount.findByLastUpdTime", query = "SELECT s FROM ShSubAccount s WHERE s.lastUpdTime = :lastUpdTime"),
    @NamedQuery(name = "ShSubAccount.findByLastUpdUserId", query = "SELECT s FROM ShSubAccount s WHERE s.lastUpdUserId = :lastUpdUserId"),
    @NamedQuery(name = "ShSubAccount.findByLastUpdProg", query = "SELECT s FROM ShSubAccount s WHERE s.lastUpdProg = :lastUpdProg"),
    @NamedQuery(name = "ShSubAccount.findByLastUpdVersion", query = "SELECT s FROM ShSubAccount s WHERE s.lastUpdVersion = :lastUpdVersion"),
    @NamedQuery(name = "ShSubAccount.findByBusinessUnitId", query = "SELECT s FROM ShSubAccount s WHERE s.businessUnitId = :businessUnitId"),
    @NamedQuery(name = "ShSubAccount.findBySourceId", query = "SELECT s FROM ShSubAccount s WHERE s.sourceId = :sourceId")})
public class ShSubAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SUB_ACCOUNT_ID")
    private Integer subAccountId;
    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
    @Column(name = "SUB_ACCOUNT_CODE")
    private String subAccountCode;
    @Column(name = "SUB_ACCOUNT_NAME")
    private String subAccountName;
    @Column(name = "SUB_ACCOUNT_DESC")
    private String subAccountDesc;
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
    @Column(name = "SOURCE_ID")
    private Integer sourceId;

    public ShSubAccount() {
    }

    public ShSubAccount(Integer subAccountId) {
        this.subAccountId = subAccountId;
    }

    public ShSubAccount(Integer subAccountId, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.subAccountId = subAccountId;
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

    public Integer getSubAccountId() {
        return subAccountId;
    }

    public void setSubAccountId(Integer subAccountId) {
        this.subAccountId = subAccountId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getSubAccountCode() {
        return subAccountCode;
    }

    public void setSubAccountCode(String subAccountCode) {
        this.subAccountCode = subAccountCode;
    }

    public String getSubAccountName() {
        return subAccountName;
    }

    public void setSubAccountName(String subAccountName) {
        this.subAccountName = subAccountName;
    }

    public String getSubAccountDesc() {
        return subAccountDesc;
    }

    public void setSubAccountDesc(String subAccountDesc) {
        this.subAccountDesc = subAccountDesc;
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

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subAccountId != null ? subAccountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShSubAccount)) {
            return false;
        }
        ShSubAccount other = (ShSubAccount) object;
        if ((this.subAccountId == null && other.subAccountId != null) || (this.subAccountId != null && !this.subAccountId.equals(other.subAccountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_SH.ShSubAccount[ subAccountId=" + subAccountId + " ]";
    }
    
}
