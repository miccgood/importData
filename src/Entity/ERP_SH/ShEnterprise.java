/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_SH;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "SH_ENTERPRISE")
public class ShEnterprise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "ENTERPRISE_ID")
    private Integer enterpriseId;
    
    @Column(name = "ENTERPRISE_NAME")
    private String enterpriseName;
    @Column(name = "ENTERPRISE_NAME_ENG")
    private String enterpriseNameEng;
    @Column(name = "MERCHANT_NO")
    private String merchantNo;
    @Column(name = "MERCHANT_ADDRESS")
    private String merchantAddress;
    @Column(name = "BILLING_ADDRESS")
    private String billingAddress;
    @Column(name = "SHIPING_ADDRESS")
    private String shipingAddress;
    
    @Column(name = "IS_CANCEL")
    private String isCancel;
    @Column(name = "CANCEL_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cancelDate;
    @Column(name = "CANCEL_PER_ID")
    private Integer cancelPerId;
    
    @Column(name = "IS_LOCK_UPDATE")
    private String isLockUpdate;
    
    @Column(name = "CREATE_TIME")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createTime;
    
    @Column(name = "CREATE_USER_ID")
    private String createUserId;
    
    @Column(name = "CREATE_PROG")
    private String createProg;
    
    @Column(name = "LAST_UPD_TIME")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastUpdTime;
    
    @Column(name = "LAST_UPD_USER_ID")
    private String lastUpdUserId;
    
    @Column(name = "LAST_UPD_PROG")
    private String lastUpdProg;
    
    @Column(name = "LAST_UPD_VERSION")
    private int lastUpdVersion;
    @Column(name = "BUSINESS_UNIT_ID")
    private Integer businessUnitId;
    @OneToMany(mappedBy = "enterpriseId")
    private Collection<ShSourceChart> shSourceChartCollection;

    public ShEnterprise() {
    }

    public ShEnterprise(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public ShEnterprise(Integer enterpriseId, String enterpriseName, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.enterpriseId = enterpriseId;
        this.enterpriseName = enterpriseName;
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

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseNameEng() {
        return enterpriseNameEng;
    }

    public void setEnterpriseNameEng(String enterpriseNameEng) {
        this.enterpriseNameEng = enterpriseNameEng;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getShipingAddress() {
        return shipingAddress;
    }

    public void setShipingAddress(String shipingAddress) {
        this.shipingAddress = shipingAddress;
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

    @XmlTransient
    public Collection<ShSourceChart> getShSourceChartCollection() {
        return shSourceChartCollection;
    }

    public void setShSourceChartCollection(Collection<ShSourceChart> shSourceChartCollection) {
        this.shSourceChartCollection = shSourceChartCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enterpriseId != null ? enterpriseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShEnterprise)) {
            return false;
        }
        ShEnterprise other = (ShEnterprise) object;
        if ((this.enterpriseId == null && other.enterpriseId != null) || (this.enterpriseId != null && !this.enterpriseId.equals(other.enterpriseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_SH.ShEnterprise[ enterpriseId=" + enterpriseId + " ]";
    }
    
}
