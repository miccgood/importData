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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SH_MEMBER_CARD")
@TableGenerator(
	name="counter_sh_member_card", 
	table="AC_COUNTER", 
	pkColumnName="name", 
	valueColumnName="value", 
	pkColumnValue="SH_MEMBER_CARD", 
	initialValue=1, 
	allocationSize=10)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShMemberCard.findAll", query = "SELECT s FROM ShMemberCard s"),
    @NamedQuery(name = "ShMemberCard.findByMemberCardId", query = "SELECT s FROM ShMemberCard s WHERE s.memberCardId = :memberCardId"),
    @NamedQuery(name = "ShMemberCard.findByMemberCardNo", query = "SELECT s FROM ShMemberCard s WHERE s.memberCardNo = :memberCardNo"),
    @NamedQuery(name = "ShMemberCard.findByMemberCardStartDate", query = "SELECT s FROM ShMemberCard s WHERE s.memberCardStartDate = :memberCardStartDate"),
    @NamedQuery(name = "ShMemberCard.findByMemberCardExpiryDate", query = "SELECT s FROM ShMemberCard s WHERE s.memberCardExpiryDate = :memberCardExpiryDate"),
    @NamedQuery(name = "ShMemberCard.findByIsCancel", query = "SELECT s FROM ShMemberCard s WHERE s.isCancel = :isCancel"),
    @NamedQuery(name = "ShMemberCard.findByCancelDate", query = "SELECT s FROM ShMemberCard s WHERE s.cancelDate = :cancelDate"),
    @NamedQuery(name = "ShMemberCard.findByCancelPerId", query = "SELECT s FROM ShMemberCard s WHERE s.cancelPerId = :cancelPerId"),
    @NamedQuery(name = "ShMemberCard.findByIsLockUpdate", query = "SELECT s FROM ShMemberCard s WHERE s.isLockUpdate = :isLockUpdate"),
    @NamedQuery(name = "ShMemberCard.findByCreateTime", query = "SELECT s FROM ShMemberCard s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "ShMemberCard.findByCreateUserId", query = "SELECT s FROM ShMemberCard s WHERE s.createUserId = :createUserId"),
    @NamedQuery(name = "ShMemberCard.findByCreateProg", query = "SELECT s FROM ShMemberCard s WHERE s.createProg = :createProg"),
    @NamedQuery(name = "ShMemberCard.findByLastUpdTime", query = "SELECT s FROM ShMemberCard s WHERE s.lastUpdTime = :lastUpdTime"),
    @NamedQuery(name = "ShMemberCard.findByLastUpdUserId", query = "SELECT s FROM ShMemberCard s WHERE s.lastUpdUserId = :lastUpdUserId"),
    @NamedQuery(name = "ShMemberCard.findByLastUpdProg", query = "SELECT s FROM ShMemberCard s WHERE s.lastUpdProg = :lastUpdProg"),
    @NamedQuery(name = "ShMemberCard.findByLastUpdVersion", query = "SELECT s FROM ShMemberCard s WHERE s.lastUpdVersion = :lastUpdVersion"),
    @NamedQuery(name = "ShMemberCard.findByBusinessUnitId", query = "SELECT s FROM ShMemberCard s WHERE s.businessUnitId = :businessUnitId")})
public class ShMemberCard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="counter_sh_member_card")
    @Basic(optional = false)
    @Column(name = "MEMBER_CARD_ID")
    private Integer memberCardId;
    @Column(name = "MEMBER_CARD_NO")
    private String memberCardNo;
    @Column(name = "MEMBER_CARD_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date memberCardStartDate;
    @Column(name = "MEMBER_CARD_EXPIRY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date memberCardExpiryDate;
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
    @JoinColumn(name = "MEMBER_CARD_TYPE_ID", referencedColumnName = "MEMBER_CARD_TYPE_ID")
    @ManyToOne
    private ShMemberCardType memberCardTypeId;
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID")
    @ManyToOne
    private ShMember memberId;

    public ShMemberCard() {
    }

    public ShMemberCard(Integer memberCardId) {
        this.memberCardId = memberCardId;
    }

    public ShMemberCard(Integer memberCardId, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.memberCardId = memberCardId;
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

    public Integer getMemberCardId() {
        return memberCardId;
    }

    public void setMemberCardId(Integer memberCardId) {
        this.memberCardId = memberCardId;
    }

    public String getMemberCardNo() {
        return memberCardNo;
    }

    public void setMemberCardNo(String memberCardNo) {
        this.memberCardNo = memberCardNo;
    }

    public Date getMemberCardStartDate() {
        return memberCardStartDate;
    }

    public void setMemberCardStartDate(Date memberCardStartDate) {
        this.memberCardStartDate = memberCardStartDate;
    }

    public Date getMemberCardExpiryDate() {
        return memberCardExpiryDate;
    }

    public void setMemberCardExpiryDate(Date memberCardExpiryDate) {
        this.memberCardExpiryDate = memberCardExpiryDate;
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

    public ShMemberCardType getMemberCardTypeId() {
        return memberCardTypeId;
    }

    public void setMemberCardTypeId(ShMemberCardType memberCardTypeId) {
        this.memberCardTypeId = memberCardTypeId;
    }

    public ShMember getMemberId() {
        return memberId;
    }

    public void setMemberId(ShMember memberId) {
        this.memberId = memberId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberCardId != null ? memberCardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShMemberCard)) {
            return false;
        }
        ShMemberCard other = (ShMemberCard) object;
        if ((this.memberCardId == null && other.memberCardId != null) || (this.memberCardId != null && !this.memberCardId.equals(other.memberCardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_SH.ShMemberCard[ memberCardId=" + memberCardId + " ]";
    }
    
}
