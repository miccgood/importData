/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ERP_PC;

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
@Table(name = "PC_INSURE_KIND")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcInsureKind.findAll", query = "SELECT p FROM PcInsureKind p"),
    @NamedQuery(name = "PcInsureKind.findByInsureKindId", query = "SELECT p FROM PcInsureKind p WHERE p.insureKindId = :insureKindId"),
    @NamedQuery(name = "PcInsureKind.findByInsureKindName", query = "SELECT p FROM PcInsureKind p WHERE p.insureKindName = :insureKindName"),
    @NamedQuery(name = "PcInsureKind.findBySeqOrder", query = "SELECT p FROM PcInsureKind p WHERE p.seqOrder = :seqOrder"),
    @NamedQuery(name = "PcInsureKind.findByIsCash", query = "SELECT p FROM PcInsureKind p WHERE p.isCash = :isCash"),
    @NamedQuery(name = "PcInsureKind.findByIsCancel", query = "SELECT p FROM PcInsureKind p WHERE p.isCancel = :isCancel"),
    @NamedQuery(name = "PcInsureKind.findByCancelDate", query = "SELECT p FROM PcInsureKind p WHERE p.cancelDate = :cancelDate"),
    @NamedQuery(name = "PcInsureKind.findByCancelPerId", query = "SELECT p FROM PcInsureKind p WHERE p.cancelPerId = :cancelPerId"),
    @NamedQuery(name = "PcInsureKind.findByCreateTime", query = "SELECT p FROM PcInsureKind p WHERE p.createTime = :createTime"),
    @NamedQuery(name = "PcInsureKind.findByCreateUserId", query = "SELECT p FROM PcInsureKind p WHERE p.createUserId = :createUserId"),
    @NamedQuery(name = "PcInsureKind.findByCreateProg", query = "SELECT p FROM PcInsureKind p WHERE p.createProg = :createProg"),
    @NamedQuery(name = "PcInsureKind.findByLastUpdTime", query = "SELECT p FROM PcInsureKind p WHERE p.lastUpdTime = :lastUpdTime"),
    @NamedQuery(name = "PcInsureKind.findByLastUpdUserId", query = "SELECT p FROM PcInsureKind p WHERE p.lastUpdUserId = :lastUpdUserId"),
    @NamedQuery(name = "PcInsureKind.findByLastUpdProg", query = "SELECT p FROM PcInsureKind p WHERE p.lastUpdProg = :lastUpdProg"),
    @NamedQuery(name = "PcInsureKind.findByLastUpdVersion", query = "SELECT p FROM PcInsureKind p WHERE p.lastUpdVersion = :lastUpdVersion")})
public class PcInsureKind implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "INSURE_KIND_ID")
    private Integer insureKindId;
    @Column(name = "INSURE_KIND_NAME")
    private String insureKindName;
    @Column(name = "SEQ_ORDER")
    private Integer seqOrder;
    @Column(name = "IS_CASH")
    private String isCash;
    @Basic(optional = false)
    @Column(name = "IS_CANCEL")
    private String isCancel;
    @Column(name = "CANCEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelDate;
    @Column(name = "CANCEL_PER_ID")
    private Integer cancelPerId;
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
    @OneToMany(mappedBy = "insureKindId")
    private Collection<PcInsure> pcInsureCollection;

    public PcInsureKind() {
    }

    public PcInsureKind(Integer insureKindId) {
        this.insureKindId = insureKindId;
    }

    public PcInsureKind(Integer insureKindId, String isCancel) {
        this.insureKindId = insureKindId;
        this.isCancel = isCancel;
    }

    public Integer getInsureKindId() {
        return insureKindId;
    }

    public void setInsureKindId(Integer insureKindId) {
        this.insureKindId = insureKindId;
    }

    public String getInsureKindName() {
        return insureKindName;
    }

    public void setInsureKindName(String insureKindName) {
        this.insureKindName = insureKindName;
    }

    public Integer getSeqOrder() {
        return seqOrder;
    }

    public void setSeqOrder(Integer seqOrder) {
        this.seqOrder = seqOrder;
    }

    public String getIsCash() {
        return isCash;
    }

    public void setIsCash(String isCash) {
        this.isCash = isCash;
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

    @XmlTransient
    public Collection<PcInsure> getPcInsureCollection() {
        return pcInsureCollection;
    }

    public void setPcInsureCollection(Collection<PcInsure> pcInsureCollection) {
        this.pcInsureCollection = pcInsureCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insureKindId != null ? insureKindId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PcInsureKind)) {
            return false;
        }
        PcInsureKind other = (PcInsureKind) object;
        if ((this.insureKindId == null && other.insureKindId != null) || (this.insureKindId != null && !this.insureKindId.equals(other.insureKindId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ERP_PC.PcInsureKind[ insureKindId=" + insureKindId + " ]";
    }
    
}
