/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_SH;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "SH_MEMBER_CARD_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShMemberCardType.findAll", query = "SELECT s FROM ShMemberCardType s"),
    @NamedQuery(name = "ShMemberCardType.findByMemberCardTypeId", query = "SELECT s FROM ShMemberCardType s WHERE s.memberCardTypeId = :memberCardTypeId"),
    @NamedQuery(name = "ShMemberCardType.findByMemberCardTypeCode", query = "SELECT s FROM ShMemberCardType s WHERE s.memberCardTypeCode = :memberCardTypeCode"),
    @NamedQuery(name = "ShMemberCardType.findByMemberCardTypeName", query = "SELECT s FROM ShMemberCardType s WHERE s.memberCardTypeName = :memberCardTypeName"),
    @NamedQuery(name = "ShMemberCardType.findByMemberCardTypeDesc", query = "SELECT s FROM ShMemberCardType s WHERE s.memberCardTypeDesc = :memberCardTypeDesc"),
    @NamedQuery(name = "ShMemberCardType.findByIsCancel", query = "SELECT s FROM ShMemberCardType s WHERE s.isCancel = :isCancel"),
    @NamedQuery(name = "ShMemberCardType.findByCancelDate", query = "SELECT s FROM ShMemberCardType s WHERE s.cancelDate = :cancelDate"),
    @NamedQuery(name = "ShMemberCardType.findByCancelPerId", query = "SELECT s FROM ShMemberCardType s WHERE s.cancelPerId = :cancelPerId"),
    @NamedQuery(name = "ShMemberCardType.findByIsLockUpdate", query = "SELECT s FROM ShMemberCardType s WHERE s.isLockUpdate = :isLockUpdate"),
    @NamedQuery(name = "ShMemberCardType.findByCreateTime", query = "SELECT s FROM ShMemberCardType s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "ShMemberCardType.findByCreateUserId", query = "SELECT s FROM ShMemberCardType s WHERE s.createUserId = :createUserId"),
    @NamedQuery(name = "ShMemberCardType.findByCreateProg", query = "SELECT s FROM ShMemberCardType s WHERE s.createProg = :createProg"),
    @NamedQuery(name = "ShMemberCardType.findByLastUpdTime", query = "SELECT s FROM ShMemberCardType s WHERE s.lastUpdTime = :lastUpdTime"),
    @NamedQuery(name = "ShMemberCardType.findByLastUpdUserId", query = "SELECT s FROM ShMemberCardType s WHERE s.lastUpdUserId = :lastUpdUserId"),
    @NamedQuery(name = "ShMemberCardType.findByLastUpdProg", query = "SELECT s FROM ShMemberCardType s WHERE s.lastUpdProg = :lastUpdProg"),
    @NamedQuery(name = "ShMemberCardType.findByLastUpdVersion", query = "SELECT s FROM ShMemberCardType s WHERE s.lastUpdVersion = :lastUpdVersion"),
    @NamedQuery(name = "ShMemberCardType.findByBusinessUnitId", query = "SELECT s FROM ShMemberCardType s WHERE s.businessUnitId = :businessUnitId")})
public class ShMemberCardType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MEMBER_CARD_TYPE_ID")
    private Integer memberCardTypeId;
    @Column(name = "MEMBER_CARD_TYPE_CODE")
    private String memberCardTypeCode;
    @Column(name = "MEMBER_CARD_TYPE_NAME")
    private String memberCardTypeName;
    @Column(name = "MEMBER_CARD_TYPE_DESC")
    private String memberCardTypeDesc;
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
    @OneToMany(mappedBy = "memberCardTypeId")
    private Collection<ShMemberCard> shMemberCardCollection;

    public ShMemberCardType() {
    }

    public ShMemberCardType(Integer memberCardTypeId) {
        this.memberCardTypeId = memberCardTypeId;
    }

    public ShMemberCardType(Integer memberCardTypeId, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.memberCardTypeId = memberCardTypeId;
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

    public Integer getMemberCardTypeId() {
        return memberCardTypeId;
    }

    public void setMemberCardTypeId(Integer memberCardTypeId) {
        this.memberCardTypeId = memberCardTypeId;
    }

    public String getMemberCardTypeCode() {
        return memberCardTypeCode;
    }

    public void setMemberCardTypeCode(String memberCardTypeCode) {
        this.memberCardTypeCode = memberCardTypeCode;
    }

    public String getMemberCardTypeName() {
        return memberCardTypeName;
    }

    public void setMemberCardTypeName(String memberCardTypeName) {
        this.memberCardTypeName = memberCardTypeName;
    }

    public String getMemberCardTypeDesc() {
        return memberCardTypeDesc;
    }

    public void setMemberCardTypeDesc(String memberCardTypeDesc) {
        this.memberCardTypeDesc = memberCardTypeDesc;
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
    public Collection<ShMemberCard> getShMemberCardCollection() {
        return shMemberCardCollection;
    }

    public void setShMemberCardCollection(Collection<ShMemberCard> shMemberCardCollection) {
        this.shMemberCardCollection = shMemberCardCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberCardTypeId != null ? memberCardTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShMemberCardType)) {
            return false;
        }
        ShMemberCardType other = (ShMemberCardType) object;
        if ((this.memberCardTypeId == null && other.memberCardTypeId != null) || (this.memberCardTypeId != null && !this.memberCardTypeId.equals(other.memberCardTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_SH.ShMemberCardType[ memberCardTypeId=" + memberCardTypeId + " ]";
    }
    
}
