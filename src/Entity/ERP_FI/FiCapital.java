/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_FI;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "FI_CAPITAL")
@TableGenerator(
        name = "counter_fi_capital",
        table = "AC_COUNTER",
        pkColumnName = "name",
        valueColumnName = "value",
        pkColumnValue = "FI_CAPITAL",
        initialValue = 1,
        allocationSize = 10) 
public class FiCapital implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="counter_fi_capital")
    @Basic(optional = false)
    @Column(name = "CAPITAL_ID", nullable = false)
    private Integer capitalId;
    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
    @Basic(optional = false)
    @Column(name = "CAPITAL_CODE", nullable = false, length = 50)
    private String capitalCode;
    @Basic(optional = false)
    @Column(name = "CAPITAL_NAME", nullable = false, length = 400)
    private String capitalName;
    @Column(name = "CAPITAL_DESC", length = 2000)
    private String capitalDesc;
    @Column(name = "INTEREST_TYPE", length = 1)
    private String interestType;
    @Basic(optional = false)
    @Column(name = "SOURCE_ID", nullable = false)
    private int sourceId;
    @Basic(optional = false)
    @Column(name = "ACCOUNT_ID", nullable = false)
    private int accountId;
    @Column(name = "PLAN_ID")
    private Integer planId;
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
    @Column(name = "RECEIVE_ID")
    private Integer receiveId;
    @Column(name = "SETUP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date setupDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SETUP_BALANCE", precision = 24, scale = 4)
    private BigDecimal setupBalance;
    @Column(name = "BALANCE", precision = 24, scale = 4)
    private BigDecimal balance;
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
    @Column(name = "OLD_BALANCE", precision = 24, scale = 4)
    private BigDecimal oldBalance;
    @JoinColumn(name = "FUND_ID", referencedColumnName = "FUND_ID")
    @ManyToOne
    private FiFund fundId;

    public FiCapital() {
    }

    public FiCapital(Integer capitalId) {
        this.capitalId = capitalId;
    }

    public FiCapital(Integer capitalId, String capitalCode, String capitalName, int sourceId, int accountId, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.capitalId = capitalId;
        this.capitalCode = capitalCode;
        this.capitalName = capitalName;
        this.sourceId = sourceId;
        this.accountId = accountId;
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

    public Integer getCapitalId() {
        return capitalId;
    }

    public void setCapitalId(Integer capitalId) {
        this.capitalId = capitalId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getCapitalCode() {
        return capitalCode;
    }

    public void setCapitalCode(String capitalCode) {
        this.capitalCode = capitalCode;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public String getCapitalDesc() {
        return capitalDesc;
    }

    public void setCapitalDesc(String capitalDesc) {
        this.capitalDesc = capitalDesc;
    }

    public String getInterestType() {
        return interestType;
    }

    public void setInterestType(String interestType) {
        this.interestType = interestType;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
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

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    public Date getSetupDate() {
        return setupDate;
    }

    public void setSetupDate(Date setupDate) {
        this.setupDate = setupDate;
    }

    public BigDecimal getSetupBalance() {
        return setupBalance;
    }

    public void setSetupBalance(BigDecimal setupBalance) {
        this.setupBalance = setupBalance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    public BigDecimal getOldBalance() {
        return oldBalance;
    }

    public void setOldBalance(BigDecimal oldBalance) {
        this.oldBalance = oldBalance;
    }

    public FiFund getFundId() {
        return fundId;
    }

    public void setFundId(FiFund fundId) {
        this.fundId = fundId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capitalId != null ? capitalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FiCapital)) {
            return false;
        }
        FiCapital other = (FiCapital) object;
        if ((this.capitalId == null && other.capitalId != null) || (this.capitalId != null && !this.capitalId.equals(other.capitalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_FI.FiCapital[ capitalId=" + capitalId + " ]";
    }
    
}
