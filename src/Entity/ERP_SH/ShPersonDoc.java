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
@Table(name = "SH_PERSON_DOC")
@TableGenerator(
	name="counter_sh_person_doc", 
	table="AC_COUNTER", 
	pkColumnName="name", 
	valueColumnName="value", 
	pkColumnValue="SH_PERSON_DOC", 
	initialValue=1, 
	allocationSize=10)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShPersonDoc.findAll", query = "SELECT s FROM ShPersonDoc s"),
    @NamedQuery(name = "ShPersonDoc.findByDocId", query = "SELECT s FROM ShPersonDoc s WHERE s.docId = :docId"),
    @NamedQuery(name = "ShPersonDoc.findBySeqOrder", query = "SELECT s FROM ShPersonDoc s WHERE s.seqOrder = :seqOrder"),
    @NamedQuery(name = "ShPersonDoc.findByDocType", query = "SELECT s FROM ShPersonDoc s WHERE s.docType = :docType"),
    @NamedQuery(name = "ShPersonDoc.findByIssuer", query = "SELECT s FROM ShPersonDoc s WHERE s.issuer = :issuer"),
    @NamedQuery(name = "ShPersonDoc.findByDocNo", query = "SELECT s FROM ShPersonDoc s WHERE s.docNo = :docNo"),
    @NamedQuery(name = "ShPersonDoc.findByExpireDate", query = "SELECT s FROM ShPersonDoc s WHERE s.expireDate = :expireDate"),
    @NamedQuery(name = "ShPersonDoc.findByIsCancel", query = "SELECT s FROM ShPersonDoc s WHERE s.isCancel = :isCancel"),
    @NamedQuery(name = "ShPersonDoc.findByCancelDate", query = "SELECT s FROM ShPersonDoc s WHERE s.cancelDate = :cancelDate"),
    @NamedQuery(name = "ShPersonDoc.findByCancelPerId", query = "SELECT s FROM ShPersonDoc s WHERE s.cancelPerId = :cancelPerId"),
    @NamedQuery(name = "ShPersonDoc.findByIsLockUpdate", query = "SELECT s FROM ShPersonDoc s WHERE s.isLockUpdate = :isLockUpdate"),
    @NamedQuery(name = "ShPersonDoc.findByCreateTime", query = "SELECT s FROM ShPersonDoc s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "ShPersonDoc.findByCreateUserId", query = "SELECT s FROM ShPersonDoc s WHERE s.createUserId = :createUserId"),
    @NamedQuery(name = "ShPersonDoc.findByCreateProg", query = "SELECT s FROM ShPersonDoc s WHERE s.createProg = :createProg"),
    @NamedQuery(name = "ShPersonDoc.findByLastUpdTime", query = "SELECT s FROM ShPersonDoc s WHERE s.lastUpdTime = :lastUpdTime"),
    @NamedQuery(name = "ShPersonDoc.findByLastUpdUserId", query = "SELECT s FROM ShPersonDoc s WHERE s.lastUpdUserId = :lastUpdUserId"),
    @NamedQuery(name = "ShPersonDoc.findByLastUpdProg", query = "SELECT s FROM ShPersonDoc s WHERE s.lastUpdProg = :lastUpdProg"),
    @NamedQuery(name = "ShPersonDoc.findByLastUpdVersion", query = "SELECT s FROM ShPersonDoc s WHERE s.lastUpdVersion = :lastUpdVersion"),
    @NamedQuery(name = "ShPersonDoc.findByBusinessUnitId", query = "SELECT s FROM ShPersonDoc s WHERE s.businessUnitId = :businessUnitId")})
public class ShPersonDoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="counter_sh_person_doc")
    @Basic(optional = false)
    @Column(name = "DOC_ID")
    private Integer docId;
    @Column(name = "SEQ_ORDER")
    private Integer seqOrder;
    @Column(name = "DOC_TYPE")
    private String docType;
    @Column(name = "ISSUER")
    private String issuer;
    @Column(name = "DOC_NO")
    private String docNo;
    @Column(name = "EXPIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;
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
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "PERSON_ID")
    @ManyToOne
    private ShPerson personId;

    public ShPersonDoc() {
    }

    public ShPersonDoc(Integer docId) {
        this.docId = docId;
    }

    public ShPersonDoc(Integer docId, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.docId = docId;
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

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Integer getSeqOrder() {
        return seqOrder;
    }

    public void setSeqOrder(Integer seqOrder) {
        this.seqOrder = seqOrder;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
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

    public ShPerson getPersonId() {
        return personId;
    }

    public void setPersonId(ShPerson personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docId != null ? docId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShPersonDoc)) {
            return false;
        }
        ShPersonDoc other = (ShPersonDoc) object;
        if ((this.docId == null && other.docId != null) || (this.docId != null && !this.docId.equals(other.docId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_SH.ShPersonDoc[ docId=" + docId + " ]";
    }
    
}
