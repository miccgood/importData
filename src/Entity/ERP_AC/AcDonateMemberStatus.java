/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_AC;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tanet-t
 */

@Entity
@Table(name = "AC_DONATE_MEMBER_STATUS")
@TableGenerator(
	name="counter_ac_donate_member_status", 
	table="AC_COUNTER", 
	pkColumnName="name", 
	valueColumnName="value", 
	pkColumnValue="AC_DONATE_MEMBER_STATUS", 
	initialValue=1, 
	allocationSize=10)
@NamedQueries({
    @NamedQuery(name = "AcDonateMemberStatus.findAll", query = "SELECT a FROM AcDonateMemberStatus a"),
    @NamedQuery(name = "AcDonateMemberStatus.findByDonateMemberStatusId", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.donateMemberStatusId = :donateMemberStatusId"),
    @NamedQuery(name = "AcDonateMemberStatus.findByDonateMemberId", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.donateMemberId = :donateMemberId"),
    @NamedQuery(name = "AcDonateMemberStatus.findByCheckResult", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.checkResult = :checkResult"),
    @NamedQuery(name = "AcDonateMemberStatus.findByLastCheckDate", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.lastCheckDate = :lastCheckDate"),
    @NamedQuery(name = "AcDonateMemberStatus.findByStatus", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.status = :status"),
    @NamedQuery(name = "AcDonateMemberStatus.findByApproveCancelDate", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.approveCancelDate = :approveCancelDate"),
    @NamedQuery(name = "AcDonateMemberStatus.findByCancelCause", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.cancelCause = :cancelCause"),
    @NamedQuery(name = "AcDonateMemberStatus.findByIsCancel", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.isCancel = :isCancel"),
    @NamedQuery(name = "AcDonateMemberStatus.findByCancelDate", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.cancelDate = :cancelDate"),
    @NamedQuery(name = "AcDonateMemberStatus.findByCancelPerId", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.cancelPerId = :cancelPerId"),
    @NamedQuery(name = "AcDonateMemberStatus.findByIsLockUpdate", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.isLockUpdate = :isLockUpdate"),
    @NamedQuery(name = "AcDonateMemberStatus.findByCreateTime", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.createTime = :createTime"),
    @NamedQuery(name = "AcDonateMemberStatus.findByCreateUserId", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.createUserId = :createUserId"),
    @NamedQuery(name = "AcDonateMemberStatus.findByCreateProg", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.createProg = :createProg"),
    @NamedQuery(name = "AcDonateMemberStatus.findByLastUpdTime", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.lastUpdTime = :lastUpdTime"),
    @NamedQuery(name = "AcDonateMemberStatus.findByLastUpdUserId", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.lastUpdUserId = :lastUpdUserId"),
    @NamedQuery(name = "AcDonateMemberStatus.findByLastUpdProg", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.lastUpdProg = :lastUpdProg"),
    @NamedQuery(name = "AcDonateMemberStatus.findByLastUpdVersion", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.lastUpdVersion = :lastUpdVersion"),
    @NamedQuery(name = "AcDonateMemberStatus.findByBusinessUnitId", query = "SELECT a FROM AcDonateMemberStatus a WHERE a.businessUnitId = :businessUnitId")})
public class AcDonateMemberStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="counter_ac_donate_member_status")
    @Basic(optional = false)
    @Column(name = "DONATE_MEMBER_STATUS_ID")
    private Integer donateMemberStatusId;
    @Column(name = "DONATE_MEMBER_ID")
    private Integer donateMemberId;
    @Column(name = "CHECK_RESULT")
    private String checkResult;
    @Column(name = "LAST_CHECK_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastCheckDate;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "APPROVE_CANCEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approveCancelDate;
    @Column(name = "CANCEL_CAUSE")
    private String cancelCause;
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

    public AcDonateMemberStatus() {
    }

    public AcDonateMemberStatus(Integer donateMemberStatusId) {
        this.donateMemberStatusId = donateMemberStatusId;
    }

    public AcDonateMemberStatus(Integer donateMemberStatusId, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.donateMemberStatusId = donateMemberStatusId;
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

    public Integer getDonateMemberStatusId() {
        return donateMemberStatusId;
    }

    public void setDonateMemberStatusId(Integer donateMemberStatusId) {
        this.donateMemberStatusId = donateMemberStatusId;
    }

    public Integer getDonateMemberId() {
        return donateMemberId;
    }

    public void setDonateMemberId(Integer donateMemberId) {
        this.donateMemberId = donateMemberId;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public Date getLastCheckDate() {
        return lastCheckDate;
    }

    public void setLastCheckDate(Date lastCheckDate) {
        this.lastCheckDate = lastCheckDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getApproveCancelDate() {
        return approveCancelDate;
    }

    public void setApproveCancelDate(Date approveCancelDate) {
        this.approveCancelDate = approveCancelDate;
    }

    public String getCancelCause() {
        return cancelCause;
    }

    public void setCancelCause(String cancelCause) {
        this.cancelCause = cancelCause;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donateMemberStatusId != null ? donateMemberStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcDonateMemberStatus)) {
            return false;
        }
        AcDonateMemberStatus other = (AcDonateMemberStatus) object;
        if ((this.donateMemberStatusId == null && other.donateMemberStatusId != null) || (this.donateMemberStatusId != null && !this.donateMemberStatusId.equals(other.donateMemberStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_AC.AcDonateMemberStatus[ donateMemberStatusId=" + donateMemberStatusId + " ]";
    }
    
}
