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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "AC_DONATE_MEMBER_ACCOUNT")
@TableGenerator(
	name="counter_ac_donate_member_account", 
	table="AC_COUNTER", 
	pkColumnName="name", 
	valueColumnName="value", 
	pkColumnValue="AC_DONATE_MEMBER_ACCOUNT", 
	initialValue=1, 
	allocationSize=10)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcDonateMemberAccount.findAll", query = "SELECT a FROM AcDonateMemberAccount a"),
    @NamedQuery(name = "AcDonateMemberAccount.findByDonateMemberAccountId", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.donateMemberAccountId = :donateMemberAccountId"),
    @NamedQuery(name = "AcDonateMemberAccount.findByDonateMemberId", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.donateMemberId = :donateMemberId"),
    @NamedQuery(name = "AcDonateMemberAccount.findByAccountId", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.accountId = :accountId"),
    @NamedQuery(name = "AcDonateMemberAccount.findByDepartmentId", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.departmentId = :departmentId"),
    @NamedQuery(name = "AcDonateMemberAccount.findByPlanId", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.planId = :planId"),
    @NamedQuery(name = "AcDonateMemberAccount.findBySourceId", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.sourceId = :sourceId"),
    @NamedQuery(name = "AcDonateMemberAccount.findBySubAccountId", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.subAccountId = :subAccountId"),
    @NamedQuery(name = "AcDonateMemberAccount.findByServiceId", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.serviceId = :serviceId"),
    @NamedQuery(name = "AcDonateMemberAccount.findByRegionId", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.regionId = :regionId"),
    @NamedQuery(name = "AcDonateMemberAccount.findByAreaId", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.areaId = :areaId"),
    @NamedQuery(name = "AcDonateMemberAccount.findByPlaceId", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.placeId = :placeId"),
    @NamedQuery(name = "AcDonateMemberAccount.findByIsCancel", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.isCancel = :isCancel"),
    @NamedQuery(name = "AcDonateMemberAccount.findByCancelDate", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.cancelDate = :cancelDate"),
    @NamedQuery(name = "AcDonateMemberAccount.findByCancelPerId", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.cancelPerId = :cancelPerId"),
    @NamedQuery(name = "AcDonateMemberAccount.findByIsLockUpdate", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.isLockUpdate = :isLockUpdate"),
    @NamedQuery(name = "AcDonateMemberAccount.findByCreateTime", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.createTime = :createTime"),
    @NamedQuery(name = "AcDonateMemberAccount.findByCreateUserId", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.createUserId = :createUserId"),
    @NamedQuery(name = "AcDonateMemberAccount.findByCreateProg", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.createProg = :createProg"),
    @NamedQuery(name = "AcDonateMemberAccount.findByLastUpdTime", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.lastUpdTime = :lastUpdTime"),
    @NamedQuery(name = "AcDonateMemberAccount.findByLastUpdUserId", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.lastUpdUserId = :lastUpdUserId"),
    @NamedQuery(name = "AcDonateMemberAccount.findByLastUpdProg", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.lastUpdProg = :lastUpdProg"),
    @NamedQuery(name = "AcDonateMemberAccount.findByLastUpdVersion", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.lastUpdVersion = :lastUpdVersion"),
    @NamedQuery(name = "AcDonateMemberAccount.findByBusinessUnitId", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.businessUnitId = :businessUnitId"),
    @NamedQuery(name = "AcDonateMemberAccount.findByBankAccount", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.bankAccount = :bankAccount"),
    @NamedQuery(name = "AcDonateMemberAccount.findByBankName", query = "SELECT a FROM AcDonateMemberAccount a WHERE a.bankName = :bankName")})
public class AcDonateMemberAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="counter_ac_donate_member_account")
    @Basic(optional = false)
    @Column(name = "DONATE_MEMBER_ACCOUNT_ID")
    private Integer donateMemberAccountId;
    @Column(name = "DONATE_MEMBER_ID")
    private Integer donateMemberId;
    @Column(name = "ACCOUNT_ID")
    private Integer accountId;
    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
    @Column(name = "PLAN_ID")
    private Integer planId;
    @Column(name = "SOURCE_ID")
    private Integer sourceId;
    @Column(name = "SUB_ACCOUNT_ID")
    private Integer subAccountId;
    @Column(name = "SERVICE_ID")
    private Integer serviceId;
    @Column(name = "REGION_ID")
    private Integer regionId;
    @Column(name = "AREA_ID")
    private Integer areaId;
    @Column(name = "PLACE_ID")
    private Integer placeId;
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
    @Column(name = "BANK_ACCOUNT")
    private String bankAccount;
    @Column(name = "BANK_NAME")
    private String bankName;

    public AcDonateMemberAccount() {
    }

    public AcDonateMemberAccount(Integer donateMemberAccountId) {
        this.donateMemberAccountId = donateMemberAccountId;
    }

    public AcDonateMemberAccount(Integer donateMemberAccountId, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.donateMemberAccountId = donateMemberAccountId;
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

    public Integer getDonateMemberAccountId() {
        return donateMemberAccountId;
    }

    public void setDonateMemberAccountId(Integer donateMemberAccountId) {
        this.donateMemberAccountId = donateMemberAccountId;
    }

    public Integer getDonateMemberId() {
        return donateMemberId;
    }

    public void setDonateMemberId(Integer donateMemberId) {
        this.donateMemberId = donateMemberId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getSubAccountId() {
        return subAccountId;
    }

    public void setSubAccountId(Integer subAccountId) {
        this.subAccountId = subAccountId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
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

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donateMemberAccountId != null ? donateMemberAccountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcDonateMemberAccount)) {
            return false;
        }
        AcDonateMemberAccount other = (AcDonateMemberAccount) object;
        if ((this.donateMemberAccountId == null && other.donateMemberAccountId != null) || (this.donateMemberAccountId != null && !this.donateMemberAccountId.equals(other.donateMemberAccountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_AC.AcDonateMemberAccount[ donateMemberAccountId=" + donateMemberAccountId + " ]";
    }
    
}
