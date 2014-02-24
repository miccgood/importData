/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_AC;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "AC_DONATE_MEMBER_REQUEST")
@TableGenerator(
	name="counter_ac_donate_member_request", 
	table="AC_COUNTER", 
	pkColumnName="name", 
	valueColumnName="value", 
	pkColumnValue="AC_DONATE_MEMBER_REQUEST", 
	initialValue=1, 
	allocationSize=10)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcDonateMemberRequest.findAll", query = "SELECT a FROM AcDonateMemberRequest a"),
    @NamedQuery(name = "AcDonateMemberRequest.findByDonateMemberRequestId", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.donateMemberRequestId = :donateMemberRequestId"),
    @NamedQuery(name = "AcDonateMemberRequest.findByDonateMemberRequestNo", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.donateMemberRequestNo = :donateMemberRequestNo"),
    @NamedQuery(name = "AcDonateMemberRequest.findByDepartmentId", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.departmentId = :departmentId"),
    @NamedQuery(name = "AcDonateMemberRequest.findByBudgetYear", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.budgetYear = :budgetYear"),
    @NamedQuery(name = "AcDonateMemberRequest.findByRequestDate", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.requestDate = :requestDate"),
    @NamedQuery(name = "AcDonateMemberRequest.findByPersonId", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.personId = :personId"),
    @NamedQuery(name = "AcDonateMemberRequest.findByPurpose", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.purpose = :purpose"),
    @NamedQuery(name = "AcDonateMemberRequest.findByCapitalId", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.capitalId = :capitalId"),
    @NamedQuery(name = "AcDonateMemberRequest.findByReceiveType", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.receiveType = :receiveType"),
    @NamedQuery(name = "AcDonateMemberRequest.findByCreditCardOwner", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.creditCardOwner = :creditCardOwner"),
    @NamedQuery(name = "AcDonateMemberRequest.findByCreditCardType", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.creditCardType = :creditCardType"),
    @NamedQuery(name = "AcDonateMemberRequest.findByCreditCardNo", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.creditCardNo = :creditCardNo"),
    @NamedQuery(name = "AcDonateMemberRequest.findByCreditCardExpYear", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.creditCardExpYear = :creditCardExpYear"),
    @NamedQuery(name = "AcDonateMemberRequest.findByCreditCardExpMonth", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.creditCardExpMonth = :creditCardExpMonth"),
    @NamedQuery(name = "AcDonateMemberRequest.findByBankId", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.bankId = :bankId"),
    @NamedQuery(name = "AcDonateMemberRequest.findByBankBranchId", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.bankBranchId = :bankBranchId"),
    @NamedQuery(name = "AcDonateMemberRequest.findByBankAccount", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.bankAccount = :bankAccount"),
    @NamedQuery(name = "AcDonateMemberRequest.findByBankAccountName", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.bankAccountName = :bankAccountName"),
    @NamedQuery(name = "AcDonateMemberRequest.findByAmount", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.amount = :amount"),
    @NamedQuery(name = "AcDonateMemberRequest.findByOffDate", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.offDate = :offDate"),
    @NamedQuery(name = "AcDonateMemberRequest.findByStatus", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.status = :status"),
    @NamedQuery(name = "AcDonateMemberRequest.findByIsCancel", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.isCancel = :isCancel"),
    @NamedQuery(name = "AcDonateMemberRequest.findByCancelDate", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.cancelDate = :cancelDate"),
    @NamedQuery(name = "AcDonateMemberRequest.findByCancelPerId", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.cancelPerId = :cancelPerId"),
    @NamedQuery(name = "AcDonateMemberRequest.findByIsLockUpdate", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.isLockUpdate = :isLockUpdate"),
    @NamedQuery(name = "AcDonateMemberRequest.findByCreateTime", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.createTime = :createTime"),
    @NamedQuery(name = "AcDonateMemberRequest.findByCreateUserId", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.createUserId = :createUserId"),
    @NamedQuery(name = "AcDonateMemberRequest.findByCreateProg", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.createProg = :createProg"),
    @NamedQuery(name = "AcDonateMemberRequest.findByLastUpdTime", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.lastUpdTime = :lastUpdTime"),
    @NamedQuery(name = "AcDonateMemberRequest.findByLastUpdUserId", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.lastUpdUserId = :lastUpdUserId"),
    @NamedQuery(name = "AcDonateMemberRequest.findByLastUpdProg", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.lastUpdProg = :lastUpdProg"),
    @NamedQuery(name = "AcDonateMemberRequest.findByLastUpdVersion", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.lastUpdVersion = :lastUpdVersion"),
    @NamedQuery(name = "AcDonateMemberRequest.findByBusinessUnitId", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.businessUnitId = :businessUnitId"),
    @NamedQuery(name = "AcDonateMemberRequest.findByCreditCardName", query = "SELECT a FROM AcDonateMemberRequest a WHERE a.creditCardName = :creditCardName")})
public class AcDonateMemberRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="counter_ac_donate_member_request")
    @Basic(optional = false)
    @Column(name = "DONATE_MEMBER_REQUEST_ID")
    private Integer donateMemberRequestId;
    @Column(name = "DONATE_MEMBER_REQUEST_NO")
    private String donateMemberRequestNo;
    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
    @Column(name = "BUDGET_YEAR")
    private String budgetYear;
    @Column(name = "REQUEST_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    @Column(name = "PERSON_ID")
    private Integer personId;
    @Column(name = "PURPOSE")
    private String purpose;
    @Column(name = "CAPITAL_ID")
    private Integer capitalId;
    @Column(name = "RECEIVE_TYPE")
    private String receiveType;
    @Column(name = "CREDIT_CARD_OWNER")
    private Integer creditCardOwner;
    @Column(name = "CREDIT_CARD_TYPE")
    private Integer creditCardType;
    @Column(name = "CREDIT_CARD_NO")
    private String creditCardNo;
    @Column(name = "CREDIT_CARD_EXP_YEAR")
    private String creditCardExpYear;
    @Column(name = "CREDIT_CARD_EXP_MONTH")
    private String creditCardExpMonth;
    @Column(name = "BANK_ID")
    private Integer bankId;
    @Column(name = "BANK_BRANCH_ID")
    private Integer bankBranchId;
    @Column(name = "BANK_ACCOUNT")
    private String bankAccount;
    @Column(name = "BANK_ACCOUNT_NAME")
    private String bankAccountName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "OFF_DATE")
    private Integer offDate;
    @Column(name = "STATUS")
    private String status;
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
    @Column(name = "CREDIT_CARD_NAME")
    private String creditCardName;

    public AcDonateMemberRequest() {
    }

    public AcDonateMemberRequest(Integer donateMemberRequestId) {
        this.donateMemberRequestId = donateMemberRequestId;
    }

    public AcDonateMemberRequest(Integer donateMemberRequestId, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.donateMemberRequestId = donateMemberRequestId;
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

    public Integer getDonateMemberRequestId() {
        return donateMemberRequestId;
    }

    public void setDonateMemberRequestId(Integer donateMemberRequestId) {
        this.donateMemberRequestId = donateMemberRequestId;
    }

    public String getDonateMemberRequestNo() {
        return donateMemberRequestNo;
    }

    public void setDonateMemberRequestNo(String donateMemberRequestNo) {
        this.donateMemberRequestNo = donateMemberRequestNo;
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

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
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
        this.creditCardNo = creditCardNo;
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
        this.bankAccount = bankAccount;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donateMemberRequestId != null ? donateMemberRequestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcDonateMemberRequest)) {
            return false;
        }
        AcDonateMemberRequest other = (AcDonateMemberRequest) object;
        if ((this.donateMemberRequestId == null && other.donateMemberRequestId != null) || (this.donateMemberRequestId != null && !this.donateMemberRequestId.equals(other.donateMemberRequestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_AC.AcDonateMemberRequest[ donateMemberRequestId=" + donateMemberRequestId + " ]";
    }
    
}
