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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "SH_MEMBER")
@TableGenerator(
	name="counter_sh_member", 
	table="AC_COUNTER", 
	pkColumnName="name", 
	valueColumnName="value", 
	pkColumnValue="SH_MEMBER", 
	initialValue=1, 
	allocationSize=10)
@NamedQueries({
    @NamedQuery(name = "ShMember.findAll", query = "SELECT s FROM ShMember s")})
public class ShMember implements Serializable {
    @Column(name = "ADDITION")
    private String addition;
    @OneToMany(mappedBy = "memberId")
    private Collection<ShMemberCard> shMemberCardCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="counter_sh_member")
    @Basic(optional = false)
    @Column(name = "MEMBER_ID", nullable = false)
    private Integer memberId;
    @Column(name = "PERSON_ID")
    private Integer personId;
    @Column(name = "MEMBER_NO", length = 15)
    private String memberNo;
    @Column(name = "MEMBER_REQUEST_ID")
    private Integer memberRequestId;
    @Column(name = "MEMBER_SOURCE", length = 1)
    private String memberSource;
    @Column(name = "DONATOR_ID")
    private Integer donatorId;
    @Column(name = "DONATOR_RELATE", length = 50)
    private String donatorRelate;
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
    @Column(name = "REGISTER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    @Column(name = "MEMBER_REQUEST_RELATION_ID")
    private Integer memberRequestRelationId;
    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
    @Column(name = "OLD_REGISTER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oldRegisterDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "OLD_TOTAL_AMOUNT", precision = 24, scale = 4)
    private BigDecimal oldTotalAmount;
    @Column(name = "OLD_PAID_AMOUNT", precision = 24, scale = 4)
    private BigDecimal oldPaidAmount;
    @Column(name = "OLD_PAID_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oldPaidDate;
    @Column(name = "OLD_PAID_YEAR")
    private Integer oldPaidYear;
    @Column(name = "OLD_PAID_TERM")
    private Integer oldPaidTerm;
    @Column(name = "OLD_MEMBER_NO", length = 20)
    private String oldMemberNo;
    @Column(name = "AMOUNT", precision = 24, scale = 4)
    private BigDecimal amount;
    @JoinColumn(name = "MEMBER_TYPE_ID", referencedColumnName = "MEMBER_TYPE_ID")
    @ManyToOne
    private ShMemberType memberTypeId;

    public ShMember() {
    }

    public ShMember(Integer memberId) {
        this.memberId = memberId;
    }

    public ShMember(Integer memberId, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.memberId = memberId;
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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public Integer getMemberRequestId() {
        return memberRequestId;
    }

    public void setMemberRequestId(Integer memberRequestId) {
        this.memberRequestId = memberRequestId;
    }

    public String getMemberSource() {
        return memberSource;
    }

    public void setMemberSource(String memberSource) {
        this.memberSource = memberSource;
    }

    public Integer getDonatorId() {
        return donatorId;
    }

    public void setDonatorId(Integer donatorId) {
        this.donatorId = donatorId;
    }

    public String getDonatorRelate() {
        return donatorRelate;
    }

    public void setDonatorRelate(String donatorRelate) {
        this.donatorRelate = donatorRelate;
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

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getMemberRequestRelationId() {
        return memberRequestRelationId;
    }

    public void setMemberRequestRelationId(Integer memberRequestRelationId) {
        this.memberRequestRelationId = memberRequestRelationId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Date getOldRegisterDate() {
        return oldRegisterDate;
    }

    public void setOldRegisterDate(Date oldRegisterDate) {
        this.oldRegisterDate = oldRegisterDate;
    }

    public BigDecimal getOldTotalAmount() {
        return oldTotalAmount;
    }

    public void setOldTotalAmount(BigDecimal oldTotalAmount) {
        this.oldTotalAmount = oldTotalAmount;
    }

    public BigDecimal getOldPaidAmount() {
        return oldPaidAmount;
    }

    public void setOldPaidAmount(BigDecimal oldPaidAmount) {
        this.oldPaidAmount = oldPaidAmount;
    }

    public Date getOldPaidDate() {
        return oldPaidDate;
    }

    public void setOldPaidDate(Date oldPaidDate) {
        this.oldPaidDate = oldPaidDate;
    }

    public Integer getOldPaidYear() {
        return oldPaidYear;
    }

    public void setOldPaidYear(Integer oldPaidYear) {
        this.oldPaidYear = oldPaidYear;
    }

    public Integer getOldPaidTerm() {
        return oldPaidTerm;
    }

    public void setOldPaidTerm(Integer oldPaidTerm) {
        this.oldPaidTerm = oldPaidTerm;
    }

    public String getOldMemberNo() {
        return oldMemberNo;
    }

    public void setOldMemberNo(String oldMemberNo) {
        this.oldMemberNo = oldMemberNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ShMemberType getMemberTypeId() {
        return memberTypeId;
    }

    public void setMemberTypeId(ShMemberType memberTypeId) {
        this.memberTypeId = memberTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberId != null ? memberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShMember)) {
            return false;
        }
        ShMember other = (ShMember) object;
        if ((this.memberId == null && other.memberId != null) || (this.memberId != null && !this.memberId.equals(other.memberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_SH.ShMember[ memberId=" + memberId + " ]";
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    @XmlTransient
    public Collection<ShMemberCard> getShMemberCardCollection() {
        return shMemberCardCollection;
    }

    public void setShMemberCardCollection(Collection<ShMemberCard> shMemberCardCollection) {
        this.shMemberCardCollection = shMemberCardCollection;
    }
    
}
