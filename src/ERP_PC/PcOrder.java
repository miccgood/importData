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
@Table(name = "PC_ORDER")
@TableGenerator(
	name="counter_pc_order", 
	table="FW_SEQUENCE_GENERATOR", 
	pkColumnName="name", 
	valueColumnName="value", 
	pkColumnValue="PC_ORDER", 
	initialValue=1, 
	allocationSize=10)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcOrder.findAll", query = "SELECT p FROM PcOrder p"),
    @NamedQuery(name = "PcOrder.findByBusinessUnitId", query = "SELECT p FROM PcOrder p WHERE p.businessUnitId = :businessUnitId"),
    @NamedQuery(name = "PcOrder.findByFormTypeCode", query = "SELECT p FROM PcOrder p WHERE p.formTypeCode = :formTypeCode"),
    @NamedQuery(name = "PcOrder.findByOrderId", query = "SELECT p FROM PcOrder p WHERE p.orderId = :orderId"),
    @NamedQuery(name = "PcOrder.findByOrderTypeCode", query = "SELECT p FROM PcOrder p WHERE p.orderTypeCode = :orderTypeCode"),
    @NamedQuery(name = "PcOrder.findByOrderNo", query = "SELECT p FROM PcOrder p WHERE p.orderNo = :orderNo"),
    @NamedQuery(name = "PcOrder.findByBudgetYear", query = "SELECT p FROM PcOrder p WHERE p.budgetYear = :budgetYear"),
    @NamedQuery(name = "PcOrder.findByOrderDate", query = "SELECT p FROM PcOrder p WHERE p.orderDate = :orderDate"),
    @NamedQuery(name = "PcOrder.findByContractTypeId", query = "SELECT p FROM PcOrder p WHERE p.contractTypeId = :contractTypeId"),
    @NamedQuery(name = "PcOrder.findByContractNo", query = "SELECT p FROM PcOrder p WHERE p.contractNo = :contractNo"),
    @NamedQuery(name = "PcOrder.findByContractStartDate", query = "SELECT p FROM PcOrder p WHERE p.contractStartDate = :contractStartDate"),
    @NamedQuery(name = "PcOrder.findByContractEndDate", query = "SELECT p FROM PcOrder p WHERE p.contractEndDate = :contractEndDate"),
    @NamedQuery(name = "PcOrder.findByFormStatusCode", query = "SELECT p FROM PcOrder p WHERE p.formStatusCode = :formStatusCode"),
    @NamedQuery(name = "PcOrder.findByWorkStatusCode", query = "SELECT p FROM PcOrder p WHERE p.workStatusCode = :workStatusCode"),
    @NamedQuery(name = "PcOrder.findByJobType", query = "SELECT p FROM PcOrder p WHERE p.jobType = :jobType"),
    @NamedQuery(name = "PcOrder.findByReferType", query = "SELECT p FROM PcOrder p WHERE p.referType = :referType"),
    @NamedQuery(name = "PcOrder.findByReferPrId", query = "SELECT p FROM PcOrder p WHERE p.referPrId = :referPrId"),
    @NamedQuery(name = "PcOrder.findByReferPaId", query = "SELECT p FROM PcOrder p WHERE p.referPaId = :referPaId"),
    @NamedQuery(name = "PcOrder.findByReferMemoId", query = "SELECT p FROM PcOrder p WHERE p.referMemoId = :referMemoId"),
    @NamedQuery(name = "PcOrder.findByReferOrderId", query = "SELECT p FROM PcOrder p WHERE p.referOrderId = :referOrderId"),
    @NamedQuery(name = "PcOrder.findByReferDocDate", query = "SELECT p FROM PcOrder p WHERE p.referDocDate = :referDocDate"),
    @NamedQuery(name = "PcOrder.findByReferBudgetYear", query = "SELECT p FROM PcOrder p WHERE p.referBudgetYear = :referBudgetYear"),
    @NamedQuery(name = "PcOrder.findByRequestDeptId", query = "SELECT p FROM PcOrder p WHERE p.requestDeptId = :requestDeptId"),
    @NamedQuery(name = "PcOrder.findByPcTypeId", query = "SELECT p FROM PcOrder p WHERE p.pcTypeId = :pcTypeId"),
    @NamedQuery(name = "PcOrder.findByPcMethodId", query = "SELECT p FROM PcOrder p WHERE p.pcMethodId = :pcMethodId"),
    @NamedQuery(name = "PcOrder.findByDocSubject", query = "SELECT p FROM PcOrder p WHERE p.docSubject = :docSubject"),
    @NamedQuery(name = "PcOrder.findBySupplierId", query = "SELECT p FROM PcOrder p WHERE p.supplierId = :supplierId"),
    @NamedQuery(name = "PcOrder.findBySendDate", query = "SELECT p FROM PcOrder p WHERE p.sendDate = :sendDate"),
    @NamedQuery(name = "PcOrder.findByAttachNumber", query = "SELECT p FROM PcOrder p WHERE p.attachNumber = :attachNumber"),
    @NamedQuery(name = "PcOrder.findByTotalNoVat", query = "SELECT p FROM PcOrder p WHERE p.totalNoVat = :totalNoVat"),
    @NamedQuery(name = "PcOrder.findByVatRate", query = "SELECT p FROM PcOrder p WHERE p.vatRate = :vatRate"),
    @NamedQuery(name = "PcOrder.findByVatAmount", query = "SELECT p FROM PcOrder p WHERE p.vatAmount = :vatAmount"),
    @NamedQuery(name = "PcOrder.findByTotalAmount", query = "SELECT p FROM PcOrder p WHERE p.totalAmount = :totalAmount"),
    @NamedQuery(name = "PcOrder.findByQuotationNo", query = "SELECT p FROM PcOrder p WHERE p.quotationNo = :quotationNo"),
    @NamedQuery(name = "PcOrder.findByQuotationDate", query = "SELECT p FROM PcOrder p WHERE p.quotationDate = :quotationDate"),
    @NamedQuery(name = "PcOrder.findBySendDays", query = "SELECT p FROM PcOrder p WHERE p.sendDays = :sendDays"),
    @NamedQuery(name = "PcOrder.findBySendPlace", query = "SELECT p FROM PcOrder p WHERE p.sendPlace = :sendPlace"),
    @NamedQuery(name = "PcOrder.findByAttachPages", query = "SELECT p FROM PcOrder p WHERE p.attachPages = :attachPages"),
    @NamedQuery(name = "PcOrder.findByFineRate", query = "SELECT p FROM PcOrder p WHERE p.fineRate = :fineRate"),
    @NamedQuery(name = "PcOrder.findByFineAmount", query = "SELECT p FROM PcOrder p WHERE p.fineAmount = :fineAmount"),
    @NamedQuery(name = "PcOrder.findByFineMethodType", query = "SELECT p FROM PcOrder p WHERE p.fineMethodType = :fineMethodType"),
    @NamedQuery(name = "PcOrder.findByFineTimeType", query = "SELECT p FROM PcOrder p WHERE p.fineTimeType = :fineTimeType"),
    @NamedQuery(name = "PcOrder.findByFineAddition", query = "SELECT p FROM PcOrder p WHERE p.fineAddition = :fineAddition"),
    @NamedQuery(name = "PcOrder.findByWarrantYears", query = "SELECT p FROM PcOrder p WHERE p.warrantYears = :warrantYears"),
    @NamedQuery(name = "PcOrder.findByWarrantMonths", query = "SELECT p FROM PcOrder p WHERE p.warrantMonths = :warrantMonths"),
    @NamedQuery(name = "PcOrder.findByGuaranteeRate", query = "SELECT p FROM PcOrder p WHERE p.guaranteeRate = :guaranteeRate"),
    @NamedQuery(name = "PcOrder.findByGuaranteeAmount", query = "SELECT p FROM PcOrder p WHERE p.guaranteeAmount = :guaranteeAmount"),
    @NamedQuery(name = "PcOrder.findByFixDays", query = "SELECT p FROM PcOrder p WHERE p.fixDays = :fixDays"),
    @NamedQuery(name = "PcOrder.findByPayType", query = "SELECT p FROM PcOrder p WHERE p.payType = :payType"),
    @NamedQuery(name = "PcOrder.findByPayDays", query = "SELECT p FROM PcOrder p WHERE p.payDays = :payDays"),
    @NamedQuery(name = "PcOrder.findByDueDateType", query = "SELECT p FROM PcOrder p WHERE p.dueDateType = :dueDateType"),
    @NamedQuery(name = "PcOrder.findByIsCountWorkDate", query = "SELECT p FROM PcOrder p WHERE p.isCountWorkDate = :isCountWorkDate"),
    @NamedQuery(name = "PcOrder.findByIsCountStartDate", query = "SELECT p FROM PcOrder p WHERE p.isCountStartDate = :isCountStartDate"),
    @NamedQuery(name = "PcOrder.findByBorrowRequestId", query = "SELECT p FROM PcOrder p WHERE p.borrowRequestId = :borrowRequestId"),
    @NamedQuery(name = "PcOrder.findByPrettyCashId", query = "SELECT p FROM PcOrder p WHERE p.prettyCashId = :prettyCashId"),
    @NamedQuery(name = "PcOrder.findByOwnerPerId", query = "SELECT p FROM PcOrder p WHERE p.ownerPerId = :ownerPerId"),
    @NamedQuery(name = "PcOrder.findByOwnerWorkGroupId", query = "SELECT p FROM PcOrder p WHERE p.ownerWorkGroupId = :ownerWorkGroupId"),
    @NamedQuery(name = "PcOrder.findByApprovePerId", query = "SELECT p FROM PcOrder p WHERE p.approvePerId = :approvePerId"),
    @NamedQuery(name = "PcOrder.findByApprovePositionId", query = "SELECT p FROM PcOrder p WHERE p.approvePositionId = :approvePositionId"),
    @NamedQuery(name = "PcOrder.findByApproveActId", query = "SELECT p FROM PcOrder p WHERE p.approveActId = :approveActId"),
    @NamedQuery(name = "PcOrder.findByApproveImageId", query = "SELECT p FROM PcOrder p WHERE p.approveImageId = :approveImageId"),
    @NamedQuery(name = "PcOrder.findByApproveResult", query = "SELECT p FROM PcOrder p WHERE p.approveResult = :approveResult"),
    @NamedQuery(name = "PcOrder.findByApproveDate", query = "SELECT p FROM PcOrder p WHERE p.approveDate = :approveDate"),
    @NamedQuery(name = "PcOrder.findByApproveAddition", query = "SELECT p FROM PcOrder p WHERE p.approveAddition = :approveAddition"),
    @NamedQuery(name = "PcOrder.findByCancelDate", query = "SELECT p FROM PcOrder p WHERE p.cancelDate = :cancelDate"),
    @NamedQuery(name = "PcOrder.findByCancelPerId", query = "SELECT p FROM PcOrder p WHERE p.cancelPerId = :cancelPerId"),
    @NamedQuery(name = "PcOrder.findByCancelReason", query = "SELECT p FROM PcOrder p WHERE p.cancelReason = :cancelReason"),
    @NamedQuery(name = "PcOrder.findByCreateTime", query = "SELECT p FROM PcOrder p WHERE p.createTime = :createTime"),
    @NamedQuery(name = "PcOrder.findByCreateUserId", query = "SELECT p FROM PcOrder p WHERE p.createUserId = :createUserId"),
    @NamedQuery(name = "PcOrder.findByCreateProg", query = "SELECT p FROM PcOrder p WHERE p.createProg = :createProg"),
    @NamedQuery(name = "PcOrder.findByLastUpdTime", query = "SELECT p FROM PcOrder p WHERE p.lastUpdTime = :lastUpdTime"),
    @NamedQuery(name = "PcOrder.findByLastUpdUserId", query = "SELECT p FROM PcOrder p WHERE p.lastUpdUserId = :lastUpdUserId"),
    @NamedQuery(name = "PcOrder.findByLastUpdProg", query = "SELECT p FROM PcOrder p WHERE p.lastUpdProg = :lastUpdProg"),
    @NamedQuery(name = "PcOrder.findByLastUpdVersion", query = "SELECT p FROM PcOrder p WHERE p.lastUpdVersion = :lastUpdVersion")})
public class PcOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "BUSINESS_UNIT_ID")
    private int businessUnitId;
    
    @Column(name = "FORM_TYPE_CODE")
    private String formTypeCode;
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="counter_pc_order")
    @Column(name = "ORDER_ID")
    private Integer orderId;
    
    @Column(name = "ORDER_TYPE_CODE")
    private String orderTypeCode;
    
    @Column(name = "ORDER_NO")
    private String orderNo;
    @Column(name = "BUDGET_YEAR")
    private String budgetYear;
    
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Column(name = "CONTRACT_TYPE_ID")
    private Integer contractTypeId;
    @Column(name = "CONTRACT_NO")
    private String contractNo;
    @Column(name = "CONTRACT_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date contractStartDate;
    @Column(name = "CONTRACT_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date contractEndDate;
    
    @Column(name = "FORM_STATUS_CODE")
    private String formStatusCode;
    
    @Column(name = "WORK_STATUS_CODE")
    private String workStatusCode;
    
    @Column(name = "JOB_TYPE")
    private String jobType;
    
    @Column(name = "REFER_TYPE")
    private String referType;
    @Column(name = "REFER_PR_ID")
    private Integer referPrId;
    @Column(name = "REFER_PA_ID")
    private Integer referPaId;
    @Column(name = "REFER_MEMO_ID")
    private Integer referMemoId;
    @Column(name = "REFER_ORDER_ID")
    private Integer referOrderId;
    @Column(name = "REFER_DOC_DATE")
    @Temporal(TemporalType.DATE)
    private Date referDocDate;
    @Column(name = "REFER_BUDGET_YEAR")
    private String referBudgetYear;
    @Column(name = "REQUEST_DEPT_ID")
    private Integer requestDeptId;
    @Column(name = "PC_TYPE_ID")
    private Integer pcTypeId;
    @Column(name = "PC_METHOD_ID")
    private Integer pcMethodId;
    @Column(name = "DOC_SUBJECT")
    private String docSubject;
    @Column(name = "SUPPLIER_ID")
    private Integer supplierId;
    @Column(name = "SEND_DATE")
    @Temporal(TemporalType.DATE)
    private Date sendDate;
    @Column(name = "ATTACH_NUMBER")
    private Integer attachNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL_NO_VAT")
    private BigDecimal totalNoVat;
    @Column(name = "VAT_RATE")
    private BigDecimal vatRate;
    @Column(name = "VAT_AMOUNT")
    private BigDecimal vatAmount;
    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;
    @Column(name = "QUOTATION_NO")
    private String quotationNo;
    @Column(name = "QUOTATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date quotationDate;
    @Column(name = "SEND_DAYS")
    private Integer sendDays;
    @Column(name = "SEND_PLACE")
    private String sendPlace;
    @Column(name = "ATTACH_PAGES")
    private Integer attachPages;
    @Column(name = "FINE_RATE")
    private BigDecimal fineRate;
    @Column(name = "FINE_AMOUNT")
    private BigDecimal fineAmount;
    @Column(name = "FINE_METHOD_TYPE")
    private String fineMethodType;
    @Column(name = "FINE_TIME_TYPE")
    private String fineTimeType;
    @Column(name = "FINE_ADDITION")
    private String fineAddition;
    @Column(name = "WARRANT_YEARS")
    private Integer warrantYears;
    @Column(name = "WARRANT_MONTHS")
    private Integer warrantMonths;
    @Column(name = "GUARANTEE_RATE")
    private BigDecimal guaranteeRate;
    @Column(name = "GUARANTEE_AMOUNT")
    private BigDecimal guaranteeAmount;
    @Column(name = "FIX_DAYS")
    private Integer fixDays;
    
    @Column(name = "PAY_TYPE")
    private String payType;
    @Column(name = "PAY_DAYS")
    private Integer payDays;
    @Column(name = "DUE_DATE_TYPE")
    private String dueDateType;
    @Column(name = "IS_COUNT_WORK_DATE")
    private String isCountWorkDate;
    @Column(name = "IS_COUNT_START_DATE")
    private String isCountStartDate;
    @Column(name = "BORROW_REQUEST_ID")
    private Integer borrowRequestId;
    @Column(name = "PRETTY_CASH_ID")
    private Integer prettyCashId;
    
    @Column(name = "OWNER_PER_ID")
    private int ownerPerId;
    @Column(name = "OWNER_WORK_GROUP_ID")
    private Integer ownerWorkGroupId;
    @Column(name = "APPROVE_PER_ID")
    private Integer approvePerId;
    @Column(name = "APPROVE_POSITION_ID")
    private Integer approvePositionId;
    @Column(name = "APPROVE_ACT_ID")
    private Integer approveActId;
    @Column(name = "APPROVE_IMAGE_ID")
    private Integer approveImageId;
    @Column(name = "APPROVE_RESULT")
    private String approveResult;
    @Column(name = "APPROVE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approveDate;
    @Column(name = "APPROVE_ADDITION")
    private String approveAddition;
    @Column(name = "CANCEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelDate;
    @Column(name = "CANCEL_PER_ID")
    private Integer cancelPerId;
    @Column(name = "CANCEL_REASON")
    private String cancelReason;
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

    public PcOrder() {
    }

    public PcOrder(Integer orderId) {
        this.orderId = orderId;
    }

    public PcOrder(Integer orderId, int businessUnitId, String formTypeCode, String orderTypeCode, String orderNo, Date orderDate, String formStatusCode, String workStatusCode, String jobType, String referType, String payType, int ownerPerId) {
        this.orderId = orderId;
        this.businessUnitId = businessUnitId;
        this.formTypeCode = formTypeCode;
        this.orderTypeCode = orderTypeCode;
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.formStatusCode = formStatusCode;
        this.workStatusCode = workStatusCode;
        this.jobType = jobType;
        this.referType = referType;
        this.payType = payType;
        this.ownerPerId = ownerPerId;
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderTypeCode() {
        return orderTypeCode;
    }

    public void setOrderTypeCode(String orderTypeCode) {
        this.orderTypeCode = orderTypeCode;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBudgetYear() {
        return budgetYear;
    }

    public void setBudgetYear(String budgetYear) {
        this.budgetYear = budgetYear;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getContractTypeId() {
        return contractTypeId;
    }

    public void setContractTypeId(Integer contractTypeId) {
        this.contractTypeId = contractTypeId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getFormStatusCode() {
        return formStatusCode;
    }

    public void setFormStatusCode(String formStatusCode) {
        this.formStatusCode = formStatusCode;
    }

    public String getWorkStatusCode() {
        return workStatusCode;
    }

    public void setWorkStatusCode(String workStatusCode) {
        this.workStatusCode = workStatusCode;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getReferType() {
        return referType;
    }

    public void setReferType(String referType) {
        this.referType = referType;
    }

    public Integer getReferPrId() {
        return referPrId;
    }

    public void setReferPrId(Integer referPrId) {
        this.referPrId = referPrId;
    }

    public Integer getReferPaId() {
        return referPaId;
    }

    public void setReferPaId(Integer referPaId) {
        this.referPaId = referPaId;
    }

    public Integer getReferMemoId() {
        return referMemoId;
    }

    public void setReferMemoId(Integer referMemoId) {
        this.referMemoId = referMemoId;
    }

    public Integer getReferOrderId() {
        return referOrderId;
    }

    public void setReferOrderId(Integer referOrderId) {
        this.referOrderId = referOrderId;
    }

    public Date getReferDocDate() {
        return referDocDate;
    }

    public void setReferDocDate(Date referDocDate) {
        this.referDocDate = referDocDate;
    }

    public String getReferBudgetYear() {
        return referBudgetYear;
    }

    public void setReferBudgetYear(String referBudgetYear) {
        this.referBudgetYear = referBudgetYear;
    }

    public Integer getRequestDeptId() {
        return requestDeptId;
    }

    public void setRequestDeptId(Integer requestDeptId) {
        this.requestDeptId = requestDeptId;
    }

    public Integer getPcTypeId() {
        return pcTypeId;
    }

    public void setPcTypeId(Integer pcTypeId) {
        this.pcTypeId = pcTypeId;
    }

    public Integer getPcMethodId() {
        return pcMethodId;
    }

    public void setPcMethodId(Integer pcMethodId) {
        this.pcMethodId = pcMethodId;
    }

    public String getDocSubject() {
        return docSubject;
    }

    public void setDocSubject(String docSubject) {
        this.docSubject = docSubject;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Integer getAttachNumber() {
        return attachNumber;
    }

    public void setAttachNumber(Integer attachNumber) {
        this.attachNumber = attachNumber;
    }

    public BigDecimal getTotalNoVat() {
        return totalNoVat;
    }

    public void setTotalNoVat(BigDecimal totalNoVat) {
        this.totalNoVat = totalNoVat;
    }

    public BigDecimal getVatRate() {
        return vatRate;
    }

    public void setVatRate(BigDecimal vatRate) {
        this.vatRate = vatRate;
    }

    public BigDecimal getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(BigDecimal vatAmount) {
        this.vatAmount = vatAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getQuotationNo() {
        return quotationNo;
    }

    public void setQuotationNo(String quotationNo) {
        this.quotationNo = quotationNo;
    }

    public Date getQuotationDate() {
        return quotationDate;
    }

    public void setQuotationDate(Date quotationDate) {
        this.quotationDate = quotationDate;
    }

    public Integer getSendDays() {
        return sendDays;
    }

    public void setSendDays(Integer sendDays) {
        this.sendDays = sendDays;
    }

    public String getSendPlace() {
        return sendPlace;
    }

    public void setSendPlace(String sendPlace) {
        this.sendPlace = sendPlace;
    }

    public Integer getAttachPages() {
        return attachPages;
    }

    public void setAttachPages(Integer attachPages) {
        this.attachPages = attachPages;
    }

    public BigDecimal getFineRate() {
        return fineRate;
    }

    public void setFineRate(BigDecimal fineRate) {
        this.fineRate = fineRate;
    }

    public BigDecimal getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(BigDecimal fineAmount) {
        this.fineAmount = fineAmount;
    }

    public String getFineMethodType() {
        return fineMethodType;
    }

    public void setFineMethodType(String fineMethodType) {
        this.fineMethodType = fineMethodType;
    }

    public String getFineTimeType() {
        return fineTimeType;
    }

    public void setFineTimeType(String fineTimeType) {
        this.fineTimeType = fineTimeType;
    }

    public String getFineAddition() {
        return fineAddition;
    }

    public void setFineAddition(String fineAddition) {
        this.fineAddition = fineAddition;
    }

    public Integer getWarrantYears() {
        return warrantYears;
    }

    public void setWarrantYears(Integer warrantYears) {
        this.warrantYears = warrantYears;
    }

    public Integer getWarrantMonths() {
        return warrantMonths;
    }

    public void setWarrantMonths(Integer warrantMonths) {
        this.warrantMonths = warrantMonths;
    }

    public BigDecimal getGuaranteeRate() {
        return guaranteeRate;
    }

    public void setGuaranteeRate(BigDecimal guaranteeRate) {
        this.guaranteeRate = guaranteeRate;
    }

    public BigDecimal getGuaranteeAmount() {
        return guaranteeAmount;
    }

    public void setGuaranteeAmount(BigDecimal guaranteeAmount) {
        this.guaranteeAmount = guaranteeAmount;
    }

    public Integer getFixDays() {
        return fixDays;
    }

    public void setFixDays(Integer fixDays) {
        this.fixDays = fixDays;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Integer getPayDays() {
        return payDays;
    }

    public void setPayDays(Integer payDays) {
        this.payDays = payDays;
    }

    public String getDueDateType() {
        return dueDateType;
    }

    public void setDueDateType(String dueDateType) {
        this.dueDateType = dueDateType;
    }

    public String getIsCountWorkDate() {
        return isCountWorkDate;
    }

    public void setIsCountWorkDate(String isCountWorkDate) {
        this.isCountWorkDate = isCountWorkDate;
    }

    public String getIsCountStartDate() {
        return isCountStartDate;
    }

    public void setIsCountStartDate(String isCountStartDate) {
        this.isCountStartDate = isCountStartDate;
    }

    public Integer getBorrowRequestId() {
        return borrowRequestId;
    }

    public void setBorrowRequestId(Integer borrowRequestId) {
        this.borrowRequestId = borrowRequestId;
    }

    public Integer getPrettyCashId() {
        return prettyCashId;
    }

    public void setPrettyCashId(Integer prettyCashId) {
        this.prettyCashId = prettyCashId;
    }

    public int getOwnerPerId() {
        return ownerPerId;
    }

    public void setOwnerPerId(int ownerPerId) {
        this.ownerPerId = ownerPerId;
    }

    public Integer getOwnerWorkGroupId() {
        return ownerWorkGroupId;
    }

    public void setOwnerWorkGroupId(Integer ownerWorkGroupId) {
        this.ownerWorkGroupId = ownerWorkGroupId;
    }

    public Integer getApprovePerId() {
        return approvePerId;
    }

    public void setApprovePerId(Integer approvePerId) {
        this.approvePerId = approvePerId;
    }

    public Integer getApprovePositionId() {
        return approvePositionId;
    }

    public void setApprovePositionId(Integer approvePositionId) {
        this.approvePositionId = approvePositionId;
    }

    public Integer getApproveActId() {
        return approveActId;
    }

    public void setApproveActId(Integer approveActId) {
        this.approveActId = approveActId;
    }

    public Integer getApproveImageId() {
        return approveImageId;
    }

    public void setApproveImageId(Integer approveImageId) {
        this.approveImageId = approveImageId;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public String getApproveAddition() {
        return approveAddition;
    }

    public void setApproveAddition(String approveAddition) {
        this.approveAddition = approveAddition;
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

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PcOrder)) {
            return false;
        }
        PcOrder other = (PcOrder) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ERP_PC.PcOrder[ orderId=" + orderId + " ]";
    }
    
}
