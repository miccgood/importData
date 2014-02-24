/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_FI;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "FI_FUND")
@NamedQueries({
    @NamedQuery(name = "FiFund.findAll", query = "SELECT f FROM FiFund f")})
public class FiFund implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FUND_ID", nullable = false)
    private Integer fundId;
    @Basic(optional = false)
    @Column(name = "FUND_CODE", nullable = false, length = 50)
    private String fundCode;
    @Basic(optional = false)
    @Column(name = "FUND_NAME", nullable = false, length = 400)
    private String fundName;
    @Column(name = "FUND_DESC", length = 2000)
    private String fundDesc;
    @Basic(optional = false)
    @Column(name = "DEPARTMENT_ID", nullable = false)
    private int departmentId;
    @Basic(optional = false)
    @Column(name = "SETUP_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date setupDate;
    @Column(name = "NOTE", length = 2000)
    private String note;
    @Basic(optional = false)
    @Column(name = "IS_CANCEL", nullable = false, length = 1)
    private String isCancel;
    @Column(name = "CANCEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelDate;
    @Column(name = "CANCEL_PER_ID")
    private Integer cancelPerId;
    @Basic(optional = false)
    @Column(name = "IS_LOCK_UPDATE", nullable = false, length = 1)
    private String isLockUpdate;
    @Basic(optional = false)
    @Column(name = "CREATE_TIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Basic(optional = false)
    @Column(name = "CREATE_USER_ID", nullable = false, length = 20)
    private String createUserId;
    @Basic(optional = false)
    @Column(name = "CREATE_PROG", nullable = false, length = 30)
    private String createProg;
    @Basic(optional = false)
    @Column(name = "LAST_UPD_TIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdTime;
    @Basic(optional = false)
    @Column(name = "LAST_UPD_USER_ID", nullable = false, length = 20)
    private String lastUpdUserId;
    @Basic(optional = false)
    @Column(name = "LAST_UPD_PROG", nullable = false, length = 30)
    private String lastUpdProg;
    @Basic(optional = false)
    @Column(name = "LAST_UPD_VERSION", nullable = false)
    private int lastUpdVersion;
    @Column(name = "BUSINESS_UNIT_ID")
    private Integer businessUnitId;
    @OneToMany(mappedBy = "fundId")
    private Collection<FiCapital> fiCapitalCollection;

    public FiFund() {
    }

    public FiFund(Integer fundId) {
        this.fundId = fundId;
    }

    public FiFund(Integer fundId, String fundCode, String fundName, int departmentId, Date setupDate, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.fundId = fundId;
        this.fundCode = fundCode;
        this.fundName = fundName;
        this.departmentId = departmentId;
        this.setupDate = setupDate;
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

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundDesc() {
        return fundDesc;
    }

    public void setFundDesc(String fundDesc) {
        this.fundDesc = fundDesc;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public Date getSetupDate() {
        return setupDate;
    }

    public void setSetupDate(Date setupDate) {
        this.setupDate = setupDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public Collection<FiCapital> getFiCapitalCollection() {
        return fiCapitalCollection;
    }

    public void setFiCapitalCollection(Collection<FiCapital> fiCapitalCollection) {
        this.fiCapitalCollection = fiCapitalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fundId != null ? fundId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FiFund)) {
            return false;
        }
        FiFund other = (FiFund) object;
        if ((this.fundId == null && other.fundId != null) || (this.fundId != null && !this.fundId.equals(other.fundId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_FI.FiFund[ fundId=" + fundId + " ]";
    }
    
}
