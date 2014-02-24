/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_SH;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SH_MEMBER_TYPE")
@NamedQueries({
    @NamedQuery(name = "ShMemberType.findAll", query = "SELECT s FROM ShMemberType s"),
@NamedQuery(name = "ShMemberType.findByName", query = "SELECT s FROM ShMemberType s WHERE s.memberTypeName = :memberTypeName")})
public class ShMemberType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MEMBER_TYPE_ID", nullable = false)
    private Integer memberTypeId;
    @Column(name = "MEMBER_TYPE_CODE", length = 50)
    private String memberTypeCode;
    @Column(name = "MEMBER_TYPE_NAME", length = 200)
    private String memberTypeName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "THRESHOLD_AMOUNT", precision = 24, scale = 4)
    private BigDecimal thresholdAmount;
    @Column(name = "MEMBER_TYPE_DESC", length = 2000)
    private String memberTypeDesc;
    @Column(name = "ACTIVATE_WITHIN")
    private Short activateWithin;
    @Column(name = "FEE_YEAR_NUM")
    private Short feeYearNum;
    @Column(name = "FEE_YEAR_AMOUNT", precision = 24, scale = 4)
    private BigDecimal feeYearAmount;
    @Column(name = "FEE_RETAIN_AMOUNT", precision = 24, scale = 4)
    private BigDecimal feeRetainAmount;
    @Column(name = "EFFECTIVE_AFTER")
    private Short effectiveAfter;
    @Column(name = "MUST_USE_WITHIN_DAY")
    private Short mustUseWithinDay;
    @Column(name = "MUST_USE_WITHIN_MONTH")
    private Short mustUseWithinMonth;
    @Column(name = "SHORTFALL_DURATION")
    private Short shortfallDuration;
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
    @Column(name = "ACCOUNT_ID")
    private Integer accountId;
    @OneToMany(mappedBy = "memberTypeId")
    private Collection<ShMember> shMemberCollection;

    public ShMemberType() {
    }

    public ShMemberType(Integer memberTypeId) {
        this.memberTypeId = memberTypeId;
    }

    public ShMemberType(Integer memberTypeId, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.memberTypeId = memberTypeId;
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

    public Integer getMemberTypeId() {
        return memberTypeId;
    }

    public void setMemberTypeId(Integer memberTypeId) {
        this.memberTypeId = memberTypeId;
    }

    public String getMemberTypeCode() {
        return memberTypeCode;
    }

    public void setMemberTypeCode(String memberTypeCode) {
        this.memberTypeCode = memberTypeCode;
    }

    public String getMemberTypeName() {
        return memberTypeName;
    }

    public void setMemberTypeName(String memberTypeName) {
        this.memberTypeName = memberTypeName;
    }

    public BigDecimal getThresholdAmount() {
        return thresholdAmount;
    }

    public void setThresholdAmount(BigDecimal thresholdAmount) {
        this.thresholdAmount = thresholdAmount;
    }

    public String getMemberTypeDesc() {
        return memberTypeDesc;
    }

    public void setMemberTypeDesc(String memberTypeDesc) {
        this.memberTypeDesc = memberTypeDesc;
    }

    public Short getActivateWithin() {
        return activateWithin;
    }

    public void setActivateWithin(Short activateWithin) {
        this.activateWithin = activateWithin;
    }

    public Short getFeeYearNum() {
        return feeYearNum;
    }

    public void setFeeYearNum(Short feeYearNum) {
        this.feeYearNum = feeYearNum;
    }

    public BigDecimal getFeeYearAmount() {
        return feeYearAmount;
    }

    public void setFeeYearAmount(BigDecimal feeYearAmount) {
        this.feeYearAmount = feeYearAmount;
    }

    public BigDecimal getFeeRetainAmount() {
        return feeRetainAmount;
    }

    public void setFeeRetainAmount(BigDecimal feeRetainAmount) {
        this.feeRetainAmount = feeRetainAmount;
    }

    public Short getEffectiveAfter() {
        return effectiveAfter;
    }

    public void setEffectiveAfter(Short effectiveAfter) {
        this.effectiveAfter = effectiveAfter;
    }

    public Short getMustUseWithinDay() {
        return mustUseWithinDay;
    }

    public void setMustUseWithinDay(Short mustUseWithinDay) {
        this.mustUseWithinDay = mustUseWithinDay;
    }

    public Short getMustUseWithinMonth() {
        return mustUseWithinMonth;
    }

    public void setMustUseWithinMonth(Short mustUseWithinMonth) {
        this.mustUseWithinMonth = mustUseWithinMonth;
    }

    public Short getShortfallDuration() {
        return shortfallDuration;
    }

    public void setShortfallDuration(Short shortfallDuration) {
        this.shortfallDuration = shortfallDuration;
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

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Collection<ShMember> getShMemberCollection() {
        return shMemberCollection;
    }

    public void setShMemberCollection(Collection<ShMember> shMemberCollection) {
        this.shMemberCollection = shMemberCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberTypeId != null ? memberTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShMemberType)) {
            return false;
        }
        ShMemberType other = (ShMemberType) object;
        if ((this.memberTypeId == null && other.memberTypeId != null) || (this.memberTypeId != null && !this.memberTypeId.equals(other.memberTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_SH.ShMemberType[ memberTypeId=" + memberTypeId + " ]";
    }
    
}
