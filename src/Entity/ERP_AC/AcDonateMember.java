/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_AC;

import Import.ImportUtils;
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
@Table(name = "AC_DONATE_MEMBER")
@TableGenerator(
	name="counter_ac_donate_member", 
	table="AC_COUNTER", 
	pkColumnName="name", 
	valueColumnName="value", 
	pkColumnValue="AC_DONATE_MEMBER", 
	initialValue=1, 
	allocationSize=10)
@NamedQueries({
    @NamedQuery(name = "AcDonateMember.findAll", query = "SELECT a FROM AcDonateMember a")})
public class AcDonateMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="counter_ac_donate_member")
    @Basic(optional = false)
    @Column(name = "DONATE_MEMBER_ID", nullable = false)
    private Integer donateMemberId;
    @Column(name = "DONATE_MEMBER_NO", length = 15)
    private String donateMemberNo;
    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
    @Column(name = "BUDGET_YEAR", length = 4)
    private String budgetYear;
    @Column(name = "ACTOR_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actorDate;
    @Column(name = "PERSON_ID")
    private Integer personId;
    @Column(name = "PURPOSE", length = 1000)
    private String purpose;
    @Column(name = "CAPITAL_ID")
    private Integer capitalId;
    @Column(name = "RECEIVE_TYPE", length = 1)
    private String receiveType;
    @Column(name = "CREDIT_CARD_OWNER")
    private Integer creditCardOwner;
    @Column(name = "CREDIT_CARD_TYPE")
    private Integer creditCardType;
    @Column(name = "CREDIT_CARD_NO", length = 20)
    private String creditCardNo;
    @Column(name = "CREDIT_CARD_EXP_YEAR", length = 4)
    private String creditCardExpYear;
    @Column(name = "CREDIT_CARD_EXP_MONTH", length = 2)
    private String creditCardExpMonth;
    @Column(name = "BANK_ID")
    private Integer bankId;
    @Column(name = "BANK_BRANCH_ID")
    private Integer bankBranchId;
    @Column(name = "BANK_ACCOUNT", length = 20)
    private String bankAccount;
    @Column(name = "BANK_ACCOUNT_NAME", length = 400)
    private String bankAccountName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT", precision = 24, scale = 4)
    private BigDecimal amount;
    @Column(name = "OFF_DATE")
    private Integer offDate;
    @Column(name = "OLD_AMOUNT", precision = 24, scale = 4)
    private BigDecimal oldAmount;
    @Column(name = "OLD_DONATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oldDonateDate;
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
    @Column(name = "CONFIG_DONATION_ID")
    private Integer configDonationId;
    @Column(name = "ADDITION", length = 1000)
    private String addition;
    @Column(name = "CREDIT_CARD_NAME", length = 100)
    private String creditCardName;
    @JoinColumn(name = "DONATE_MEMBER_REQUEST_ID", referencedColumnName = "DONATE_MEMBER_REQUEST_ID")
    @ManyToOne
    private AcDonateMemberRequest donateMemberRequestId;

    public AcDonateMember() {
    }

    public AcDonateMember(Integer donateMemberId) {
        this.donateMemberId = donateMemberId;
    }

    public AcDonateMember(Integer donateMemberId, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.donateMemberId = donateMemberId;
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

    public Integer getDonateMemberId() {
        return donateMemberId;
    }

    public void setDonateMemberId(Integer donateMemberId) {
        this.donateMemberId = donateMemberId;
    }

    public String getDonateMemberNo() {
        return donateMemberNo;
    }

    public void setDonateMemberNo(String donateMemberNo) {
        this.donateMemberNo = donateMemberNo;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getBudgetYear() {
        return budgetYear;
    }

    public void setBudgetYear(String budgetYear) {
        this.budgetYear = budgetYear;
    }

    public Date getActorDate() {
        return actorDate;
    }

    public void setActorDate(Date actorDate) {
        this.actorDate = actorDate;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getCapitalId() {
        return capitalId;
    }

    public void setCapitalId(Integer capitalId) {
        this.capitalId = capitalId;
    }

    public String getReceiveType() {
        return receiveType;
    }

    public void setReceiveType(String receiveType) {
        this.receiveType = receiveType;
    }

    public Integer getCreditCardOwner() {
        return creditCardOwner;
    }

    public void setCreditCardOwner(Integer creditCardOwner) {
        this.creditCardOwner = creditCardOwner;
    }

    public Integer getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(Integer creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = ImportUtils.replaceCreditCardNo(creditCardNo, 16);
    }

    public String getCreditCardExpYear() {
        return creditCardExpYear;
    }

    public void setCreditCardExpYear(String creditCardExpYear) {
        this.creditCardExpYear = creditCardExpYear;
    }

    public String getCreditCardExpMonth() {
        return creditCardExpMonth;
    }

    public void setCreditCardExpMonth(String creditCardExpMonth) {
        this.creditCardExpMonth = creditCardExpMonth;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public Integer getBankBranchId() {
        return bankBranchId;
    }

    public void setBankBranchId(Integer bankBranchId) {
        this.bankBranchId = bankBranchId;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = ImportUtils.replaceCreditCardNo(bankAccount,10);
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getOffDate() {
        return offDate;
    }

    public void setOffDate(Integer offDate) {
        this.offDate = offDate;
    }

    public BigDecimal getOldAmount() {
        return oldAmount;
    }

    public void setOldAmount(BigDecimal oldAmount) {
        this.oldAmount = oldAmount;
    }

    public Date getOldDonateDate() {
        return oldDonateDate;
    }

    public void setOldDonateDate(Date oldDonateDate) {
        this.oldDonateDate = oldDonateDate;
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

    public Integer getConfigDonationId() {
        return configDonationId;
    }

    public void setConfigDonationId(Integer configDonationId) {
        this.configDonationId = configDonationId;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public AcDonateMemberRequest getDonateMemberRequestId() {
        return donateMemberRequestId;
    }

    public void setDonateMemberRequestId(AcDonateMemberRequest donateMemberRequestId) {
        this.donateMemberRequestId = donateMemberRequestId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donateMemberId != null ? donateMemberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcDonateMember)) {
            return false;
        }
        AcDonateMember other = (AcDonateMember) object;
        if ((this.donateMemberId == null && other.donateMemberId != null) || (this.donateMemberId != null && !this.donateMemberId.equals(other.donateMemberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_AC.AcDonateMember[ donateMemberId=" + donateMemberId + " ]";
    }
    
}
