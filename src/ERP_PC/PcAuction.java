/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ERP_PC;

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
@Table(name = "PC_AUCTION")
@TableGenerator(
	name="counter_pc_auction", 
	table="FW_SEQUENCE_GENERATOR", 
	pkColumnName="name", 
	valueColumnName="value", 
	pkColumnValue="PC_AUCTION", 
	initialValue=1, 
	allocationSize=10)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcAuction.findAll", query = "SELECT p FROM PcAuction p"),
    @NamedQuery(name = "PcAuction.findByBusinessUnitId", query = "SELECT p FROM PcAuction p WHERE p.businessUnitId = :businessUnitId"),
    @NamedQuery(name = "PcAuction.findByFormTypeCode", query = "SELECT p FROM PcAuction p WHERE p.formTypeCode = :formTypeCode"),
    @NamedQuery(name = "PcAuction.findByAuctionId", query = "SELECT p FROM PcAuction p WHERE p.auctionId = :auctionId"),
    @NamedQuery(name = "PcAuction.findByAuctionNo", query = "SELECT p FROM PcAuction p WHERE p.auctionNo = :auctionNo"),
    @NamedQuery(name = "PcAuction.findByBudgetYear", query = "SELECT p FROM PcAuction p WHERE p.budgetYear = :budgetYear"),
    @NamedQuery(name = "PcAuction.findByAuctionDate", query = "SELECT p FROM PcAuction p WHERE p.auctionDate = :auctionDate"),
    @NamedQuery(name = "PcAuction.findByFormStatusCode", query = "SELECT p FROM PcAuction p WHERE p.formStatusCode = :formStatusCode"),
    @NamedQuery(name = "PcAuction.findByWorkStatusCode", query = "SELECT p FROM PcAuction p WHERE p.workStatusCode = :workStatusCode"),
    @NamedQuery(name = "PcAuction.findByDocSubject", query = "SELECT p FROM PcAuction p WHERE p.docSubject = :docSubject"),
    @NamedQuery(name = "PcAuction.findByReferPrId", query = "SELECT p FROM PcAuction p WHERE p.referPrId = :referPrId"),
    @NamedQuery(name = "PcAuction.findByReferMemoId", query = "SELECT p FROM PcAuction p WHERE p.referMemoId = :referMemoId"),
    @NamedQuery(name = "PcAuction.findByAddition", query = "SELECT p FROM PcAuction p WHERE p.addition = :addition"),
    @NamedQuery(name = "PcAuction.findByNoticeDate1", query = "SELECT p FROM PcAuction p WHERE p.noticeDate1 = :noticeDate1"),
    @NamedQuery(name = "PcAuction.findByNoticeDate2", query = "SELECT p FROM PcAuction p WHERE p.noticeDate2 = :noticeDate2"),
    @NamedQuery(name = "PcAuction.findByEnvelopPlace", query = "SELECT p FROM PcAuction p WHERE p.envelopPlace = :envelopPlace"),
    @NamedQuery(name = "PcAuction.findByEnvelopDate1", query = "SELECT p FROM PcAuction p WHERE p.envelopDate1 = :envelopDate1"),
    @NamedQuery(name = "PcAuction.findByEnvelopDate2", query = "SELECT p FROM PcAuction p WHERE p.envelopDate2 = :envelopDate2"),
    @NamedQuery(name = "PcAuction.findByAnnounceCheckDate", query = "SELECT p FROM PcAuction p WHERE p.announceCheckDate = :announceCheckDate"),
    @NamedQuery(name = "PcAuction.findByOpenTechnicDate", query = "SELECT p FROM PcAuction p WHERE p.openTechnicDate = :openTechnicDate"),
    @NamedQuery(name = "PcAuction.findByOpenPriceDate", query = "SELECT p FROM PcAuction p WHERE p.openPriceDate = :openPriceDate"),
    @NamedQuery(name = "PcAuction.findByAnnounceWinDate", query = "SELECT p FROM PcAuction p WHERE p.announceWinDate = :announceWinDate"),
    @NamedQuery(name = "PcAuction.findByOwnerPerId", query = "SELECT p FROM PcAuction p WHERE p.ownerPerId = :ownerPerId"),
    @NamedQuery(name = "PcAuction.findByCancelDate", query = "SELECT p FROM PcAuction p WHERE p.cancelDate = :cancelDate"),
    @NamedQuery(name = "PcAuction.findByCancelPerId", query = "SELECT p FROM PcAuction p WHERE p.cancelPerId = :cancelPerId"),
    @NamedQuery(name = "PcAuction.findByCancelReason", query = "SELECT p FROM PcAuction p WHERE p.cancelReason = :cancelReason"),
    @NamedQuery(name = "PcAuction.findByCreateTime", query = "SELECT p FROM PcAuction p WHERE p.createTime = :createTime"),
    @NamedQuery(name = "PcAuction.findByCreateUserId", query = "SELECT p FROM PcAuction p WHERE p.createUserId = :createUserId"),
    @NamedQuery(name = "PcAuction.findByCreateProg", query = "SELECT p FROM PcAuction p WHERE p.createProg = :createProg"),
    @NamedQuery(name = "PcAuction.findByLastUpdTime", query = "SELECT p FROM PcAuction p WHERE p.lastUpdTime = :lastUpdTime"),
    @NamedQuery(name = "PcAuction.findByLastUpdUserId", query = "SELECT p FROM PcAuction p WHERE p.lastUpdUserId = :lastUpdUserId"),
    @NamedQuery(name = "PcAuction.findByLastUpdProg", query = "SELECT p FROM PcAuction p WHERE p.lastUpdProg = :lastUpdProg"),
    @NamedQuery(name = "PcAuction.findByLastUpdVersion", query = "SELECT p FROM PcAuction p WHERE p.lastUpdVersion = :lastUpdVersion")})
public class PcAuction implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "BUSINESS_UNIT_ID")
    private int businessUnitId;
    
    @Column(name = "FORM_TYPE_CODE")
    private String formTypeCode;
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="counter_pc_auction")
    
    @Column(name = "AUCTION_ID")
    private Integer auctionId;
    @Column(name = "AUCTION_NO")
    private String auctionNo;
    @Column(name = "BUDGET_YEAR")
    private String budgetYear;
    
    @Column(name = "AUCTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date auctionDate;
    
    @Column(name = "FORM_STATUS_CODE")
    private String formStatusCode;
    
    @Column(name = "WORK_STATUS_CODE")
    private String workStatusCode;
    @Column(name = "DOC_SUBJECT")
    private String docSubject;
    @Column(name = "REFER_PR_ID")
    private Integer referPrId;
    @Column(name = "REFER_MEMO_ID")
    private Integer referMemoId;
    @Column(name = "ADDITION")
    private String addition;
    @Column(name = "NOTICE_DATE_1")
    @Temporal(TemporalType.DATE)
    private Date noticeDate1;
    @Column(name = "NOTICE_DATE_2")
    @Temporal(TemporalType.DATE)
    private Date noticeDate2;
    @Column(name = "ENVELOP_PLACE")
    private String envelopPlace;
    @Column(name = "ENVELOP_DATE_1")
    @Temporal(TemporalType.DATE)
    private Date envelopDate1;
    @Column(name = "ENVELOP_DATE_2")
    @Temporal(TemporalType.DATE)
    private Date envelopDate2;
    @Column(name = "ANNOUNCE_CHECK_DATE")
    @Temporal(TemporalType.DATE)
    private Date announceCheckDate;
    @Column(name = "OPEN_TECHNIC_DATE")
    @Temporal(TemporalType.DATE)
    private Date openTechnicDate;
    @Column(name = "OPEN_PRICE_DATE")
    @Temporal(TemporalType.DATE)
    private Date openPriceDate;
    @Column(name = "ANNOUNCE_WIN_DATE")
    @Temporal(TemporalType.DATE)
    private Date announceWinDate;
    
    @Column(name = "OWNER_PER_ID")
    private int ownerPerId;
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
    @JoinColumn(name = "AUCTION_TYPE_ID", referencedColumnName = "AUCTION_TYPE_ID")
    @ManyToOne(optional = false)
    private PcAuctionType auctionTypeId;

    public PcAuction() {
    }

    public PcAuction(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public PcAuction(Integer auctionId, int businessUnitId, String formTypeCode, Date auctionDate, String formStatusCode, String workStatusCode, int ownerPerId) {
        this.auctionId = auctionId;
        this.businessUnitId = businessUnitId;
        this.formTypeCode = formTypeCode;
        this.auctionDate = auctionDate;
        this.formStatusCode = formStatusCode;
        this.workStatusCode = workStatusCode;
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

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public String getAuctionNo() {
        return auctionNo;
    }

    public void setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo;
    }

    public String getBudgetYear() {
        return budgetYear;
    }

    public void setBudgetYear(String budgetYear) {
        this.budgetYear = budgetYear;
    }

    public Date getAuctionDate() {
        return auctionDate;
    }

    public void setAuctionDate(Date auctionDate) {
        this.auctionDate = auctionDate;
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

    public String getDocSubject() {
        return docSubject;
    }

    public void setDocSubject(String docSubject) {
        this.docSubject = docSubject;
    }

    public Integer getReferPrId() {
        return referPrId;
    }

    public void setReferPrId(Integer referPrId) {
        this.referPrId = referPrId;
    }

    public Integer getReferMemoId() {
        return referMemoId;
    }

    public void setReferMemoId(Integer referMemoId) {
        this.referMemoId = referMemoId;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public Date getNoticeDate1() {
        return noticeDate1;
    }

    public void setNoticeDate1(Date noticeDate1) {
        this.noticeDate1 = noticeDate1;
    }

    public Date getNoticeDate2() {
        return noticeDate2;
    }

    public void setNoticeDate2(Date noticeDate2) {
        this.noticeDate2 = noticeDate2;
    }

    public String getEnvelopPlace() {
        return envelopPlace;
    }

    public void setEnvelopPlace(String envelopPlace) {
        this.envelopPlace = envelopPlace;
    }

    public Date getEnvelopDate1() {
        return envelopDate1;
    }

    public void setEnvelopDate1(Date envelopDate1) {
        this.envelopDate1 = envelopDate1;
    }

    public Date getEnvelopDate2() {
        return envelopDate2;
    }

    public void setEnvelopDate2(Date envelopDate2) {
        this.envelopDate2 = envelopDate2;
    }

    public Date getAnnounceCheckDate() {
        return announceCheckDate;
    }

    public void setAnnounceCheckDate(Date announceCheckDate) {
        this.announceCheckDate = announceCheckDate;
    }

    public Date getOpenTechnicDate() {
        return openTechnicDate;
    }

    public void setOpenTechnicDate(Date openTechnicDate) {
        this.openTechnicDate = openTechnicDate;
    }

    public Date getOpenPriceDate() {
        return openPriceDate;
    }

    public void setOpenPriceDate(Date openPriceDate) {
        this.openPriceDate = openPriceDate;
    }

    public Date getAnnounceWinDate() {
        return announceWinDate;
    }

    public void setAnnounceWinDate(Date announceWinDate) {
        this.announceWinDate = announceWinDate;
    }

    public int getOwnerPerId() {
        return ownerPerId;
    }

    public void setOwnerPerId(int ownerPerId) {
        this.ownerPerId = ownerPerId;
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

    public PcAuctionType getAuctionTypeId() {
        return auctionTypeId;
    }

    public void setAuctionTypeId(PcAuctionType auctionTypeId) {
        this.auctionTypeId = auctionTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auctionId != null ? auctionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PcAuction)) {
            return false;
        }
        PcAuction other = (PcAuction) object;
        if ((this.auctionId == null && other.auctionId != null) || (this.auctionId != null && !this.auctionId.equals(other.auctionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ERP_PC.PcAuction[ auctionId=" + auctionId + " ]";
    }
    
}
