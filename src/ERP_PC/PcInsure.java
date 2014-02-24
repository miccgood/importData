/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ERP_PC;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "PC_INSURE")
@TableGenerator(
	name="counter_pc_insure", 
	table="FW_SEQUENCE_GENERATOR", 
	pkColumnName="name", 
	valueColumnName="value", 
	pkColumnValue="PC_INSURE", 
	initialValue=1, 
	allocationSize=10)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcInsure.findAll", query = "SELECT p FROM PcInsure p"),
    @NamedQuery(name = "PcInsure.findByBusinessUnitId", query = "SELECT p FROM PcInsure p WHERE p.businessUnitId = :businessUnitId"),
    @NamedQuery(name = "PcInsure.findByFormTypeCode", query = "SELECT p FROM PcInsure p WHERE p.formTypeCode = :formTypeCode"),
    @NamedQuery(name = "PcInsure.findByInsureId", query = "SELECT p FROM PcInsure p WHERE p.insureId = :insureId"),
    @NamedQuery(name = "PcInsure.findByInsureNo", query = "SELECT p FROM PcInsure p WHERE p.insureNo = :insureNo"),
    @NamedQuery(name = "PcInsure.findBySeqRunning", query = "SELECT p FROM PcInsure p WHERE p.seqRunning = :seqRunning"),
    @NamedQuery(name = "PcInsure.findByInsureDate", query = "SELECT p FROM PcInsure p WHERE p.insureDate = :insureDate"),
    @NamedQuery(name = "PcInsure.findByAuctionId", query = "SELECT p FROM PcInsure p WHERE p.auctionId = :auctionId"),
    @NamedQuery(name = "PcInsure.findByOrderId", query = "SELECT p FROM PcInsure p WHERE p.orderId = :orderId"),
    @NamedQuery(name = "PcInsure.findByExamineId", query = "SELECT p FROM PcInsure p WHERE p.examineId = :examineId"),
    @NamedQuery(name = "PcInsure.findBySupplierId", query = "SELECT p FROM PcInsure p WHERE p.supplierId = :supplierId"),
    @NamedQuery(name = "PcInsure.findByInsureAmount", query = "SELECT p FROM PcInsure p WHERE p.insureAmount = :insureAmount"),
    @NamedQuery(name = "PcInsure.findByDueDate", query = "SELECT p FROM PcInsure p WHERE p.dueDate = :dueDate"),
    @NamedQuery(name = "PcInsure.findByReceiptNo", query = "SELECT p FROM PcInsure p WHERE p.receiptNo = :receiptNo"),
    @NamedQuery(name = "PcInsure.findByReceiptDate", query = "SELECT p FROM PcInsure p WHERE p.receiptDate = :receiptDate"),
    @NamedQuery(name = "PcInsure.findByGuaranteeNo", query = "SELECT p FROM PcInsure p WHERE p.guaranteeNo = :guaranteeNo"),
    @NamedQuery(name = "PcInsure.findByGuaranteeDate", query = "SELECT p FROM PcInsure p WHERE p.guaranteeDate = :guaranteeDate"),
    @NamedQuery(name = "PcInsure.findByBankId", query = "SELECT p FROM PcInsure p WHERE p.bankId = :bankId"),
    @NamedQuery(name = "PcInsure.findByBankBranch", query = "SELECT p FROM PcInsure p WHERE p.bankBranch = :bankBranch"),
    @NamedQuery(name = "PcInsure.findByAddition", query = "SELECT p FROM PcInsure p WHERE p.addition = :addition"),
    @NamedQuery(name = "PcInsure.findByReceivePerId", query = "SELECT p FROM PcInsure p WHERE p.receivePerId = :receivePerId"),
    @NamedQuery(name = "PcInsure.findByReceivePositionId", query = "SELECT p FROM PcInsure p WHERE p.receivePositionId = :receivePositionId"),
    @NamedQuery(name = "PcInsure.findByCreateTime", query = "SELECT p FROM PcInsure p WHERE p.createTime = :createTime"),
    @NamedQuery(name = "PcInsure.findByCreateUserId", query = "SELECT p FROM PcInsure p WHERE p.createUserId = :createUserId"),
    @NamedQuery(name = "PcInsure.findByCreateProg", query = "SELECT p FROM PcInsure p WHERE p.createProg = :createProg"),
    @NamedQuery(name = "PcInsure.findByLastUpdTime", query = "SELECT p FROM PcInsure p WHERE p.lastUpdTime = :lastUpdTime"),
    @NamedQuery(name = "PcInsure.findByLastUpdUserId", query = "SELECT p FROM PcInsure p WHERE p.lastUpdUserId = :lastUpdUserId"),
    @NamedQuery(name = "PcInsure.findByLastUpdProg", query = "SELECT p FROM PcInsure p WHERE p.lastUpdProg = :lastUpdProg"),
    @NamedQuery(name = "PcInsure.findByLastUpdVersion", query = "SELECT p FROM PcInsure p WHERE p.lastUpdVersion = :lastUpdVersion")})
public class PcInsure implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "BUSINESS_UNIT_ID")
    private int businessUnitId;
    
    @Column(name = "FORM_TYPE_CODE")
    private String formTypeCode;
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="counter_pc_insure")
    
    @Column(name = "INSURE_ID")
    private Integer insureId;
    @Column(name = "INSURE_NO")
    private String insureNo;
    @Column(name = "SEQ_RUNNING")
    private Integer seqRunning;
    @Column(name = "INSURE_DATE")
    @Temporal(TemporalType.DATE)
    private Date insureDate;
    @Column(name = "AUCTION_ID")
    private Integer auctionId;
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Column(name = "EXAMINE_ID")
    private Integer examineId;
    @Column(name = "SUPPLIER_ID")
    private Integer supplierId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "INSURE_AMOUNT")
    private BigDecimal insureAmount;
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Column(name = "RECEIPT_NO")
    private String receiptNo;
    @Column(name = "RECEIPT_DATE")
    @Temporal(TemporalType.DATE)
    private Date receiptDate;
    @Column(name = "GUARANTEE_NO")
    private String guaranteeNo;
    @Column(name = "GUARANTEE_DATE")
    @Temporal(TemporalType.DATE)
    private Date guaranteeDate;
    @Column(name = "BANK_ID")
    private Integer bankId;
    @Column(name = "BANK_BRANCH")
    private String bankBranch;
    @Column(name = "ADDITION")
    private String addition;
    @Column(name = "RECEIVE_PER_ID")
    private Integer receivePerId;
    @Column(name = "RECEIVE_POSITION_ID")
    private Integer receivePositionId;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "CREATE_USER_ID")
    private String createUserId;
    @Column(name = "CREATE_PROG")
    private String createProg;
    @Column(name = "LAST_UPD_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdTime;
    @Column(name = "LAST_UPD_USER_ID")
    private String lastUpdUserId;
    @Column(name = "LAST_UPD_PROG")
    private String lastUpdProg;
    @Column(name = "LAST_UPD_VERSION")
    private Integer lastUpdVersion;
    @JoinColumn(name = "INSURE_TYPE_ID", referencedColumnName = "INSURE_TYPE_ID")
    @ManyToOne
    private PcInsureType insureTypeId;
    @JoinColumn(name = "INSURE_KIND_ID", referencedColumnName = "INSURE_KIND_ID")
    @ManyToOne
    private PcInsureKind insureKindId;

    public PcInsure() {
    }

    public PcInsure(Integer insureId) {
        this.insureId = insureId;
    }

    public PcInsure(Integer insureId, int businessUnitId, String formTypeCode) {
        this.insureId = insureId;
        this.businessUnitId = businessUnitId;
        this.formTypeCode = formTypeCode;
    }

    public int getBusinessUnitId() {
        return businessUnitId;
    }

    public void setBusinessUnitId(int businessUnitId) {
        this.businessUnitId = businessUnitId;
    }

    public String getFormTypeCode() {
        return formTypeCode;
    }

    public void setFormTypeCode(String formTypeCode) {
        this.formTypeCode = formTypeCode;
    }

    public Integer getInsureId() {
        return insureId;
    }

    public void setInsureId(Integer insureId) {
        this.insureId = insureId;
    }

    public String getInsureNo() {
        return insureNo;
    }

    public void setInsureNo(String insureNo) {
        this.insureNo = insureNo;
    }

    public Integer getSeqRunning() {
        return seqRunning;
    }

    public void setSeqRunning(Integer seqRunning) {
        this.seqRunning = seqRunning;
    }

    public Date getInsureDate() {
        return insureDate;
    }

    public void setInsureDate(Date insureDate) {
        this.insureDate = insureDate;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getExamineId() {
        return examineId;
    }

    public void setExamineId(Integer examineId) {
        this.examineId = examineId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public BigDecimal getInsureAmount() {
        return insureAmount;
    }

    public void setInsureAmount(BigDecimal insureAmount) {
        this.insureAmount = insureAmount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getGuaranteeNo() {
        return guaranteeNo;
    }

    public void setGuaranteeNo(String guaranteeNo) {
        this.guaranteeNo = guaranteeNo;
    }

    public Date getGuaranteeDate() {
        return guaranteeDate;
    }

    public void setGuaranteeDate(Date guaranteeDate) {
        this.guaranteeDate = guaranteeDate;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public Integer getReceivePerId() {
        return receivePerId;
    }

    public void setReceivePerId(Integer receivePerId) {
        this.receivePerId = receivePerId;
    }

    public Integer getReceivePositionId() {
        return receivePositionId;
    }

    public void setReceivePositionId(Integer receivePositionId) {
        this.receivePositionId = receivePositionId;
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

    public Integer getLastUpdVersion() {
        return lastUpdVersion;
    }

    public void setLastUpdVersion(Integer lastUpdVersion) {
        this.lastUpdVersion = lastUpdVersion;
    }

    public PcInsureType getInsureTypeId() {
        return insureTypeId;
    }

    public void setInsureTypeId(PcInsureType insureTypeId) {
        this.insureTypeId = insureTypeId;
    }

    public PcInsureKind getInsureKindId() {
        return insureKindId;
    }

    public void setInsureKindId(PcInsureKind insureKindId) {
        this.insureKindId = insureKindId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insureId != null ? insureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PcInsure)) {
            return false;
        }
        PcInsure other = (PcInsure) object;
        if ((this.insureId == null && other.insureId != null) || (this.insureId != null && !this.insureId.equals(other.insureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ERP_PC.PcInsure[ insureId=" + insureId + " ]";
    }
    
}
