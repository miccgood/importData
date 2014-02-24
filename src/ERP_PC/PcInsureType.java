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
@Table(name = "PC_INSURE_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcInsureType.findAll", query = "SELECT p FROM PcInsureType p"),
    @NamedQuery(name = "PcInsureType.findByInsureTypeId", query = "SELECT p FROM PcInsureType p WHERE p.insureTypeId = :insureTypeId"),
    @NamedQuery(name = "PcInsureType.findByInsureTypeName", query = "SELECT p FROM PcInsureType p WHERE p.insureTypeName = :insureTypeName"),
    @NamedQuery(name = "PcInsureType.findBySeqOrder", query = "SELECT p FROM PcInsureType p WHERE p.seqOrder = :seqOrder"),
    @NamedQuery(name = "PcInsureType.findByIsCancel", query = "SELECT p FROM PcInsureType p WHERE p.isCancel = :isCancel"),
    @NamedQuery(name = "PcInsureType.findByCancelDate", query = "SELECT p FROM PcInsureType p WHERE p.cancelDate = :cancelDate"),
    @NamedQuery(name = "PcInsureType.findByCancelPerId", query = "SELECT p FROM PcInsureType p WHERE p.cancelPerId = :cancelPerId"),
    @NamedQuery(name = "PcInsureType.findByCreateTime", query = "SELECT p FROM PcInsureType p WHERE p.createTime = :createTime"),
    @NamedQuery(name = "PcInsureType.findByCreateUserId", query = "SELECT p FROM PcInsureType p WHERE p.createUserId = :createUserId"),
    @NamedQuery(name = "PcInsureType.findByCreateProg", query = "SELECT p FROM PcInsureType p WHERE p.createProg = :createProg"),
    @NamedQuery(name = "PcInsureType.findByLastUpdTime", query = "SELECT p FROM PcInsureType p WHERE p.lastUpdTime = :lastUpdTime"),
    @NamedQuery(name = "PcInsureType.findByLastUpdUserId", query = "SELECT p FROM PcInsureType p WHERE p.lastUpdUserId = :lastUpdUserId"),
    @NamedQuery(name = "PcInsureType.findByLastUpdProg", query = "SELECT p FROM PcInsureType p WHERE p.lastUpdProg = :lastUpdProg"),
    @NamedQuery(name = "PcInsureType.findByLastUpdVersion", query = "SELECT p FROM PcInsureType p WHERE p.lastUpdVersion = :lastUpdVersion")})
public class PcInsureType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "INSURE_TYPE_ID")
    private Integer insureTypeId;
    @Column(name = "INSURE_TYPE_NAME")
    private String insureTypeName;
    @Column(name = "SEQ_ORDER")
    private Integer seqOrder;
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
    @OneToMany(mappedBy = "insureTypeId")
    private Collection<PcInsure> pcInsureCollection;

    public PcInsureType() {
    }

    public PcInsureType(Integer insureTypeId) {
        this.insureTypeId = insureTypeId;
    }

    public PcInsureType(Integer insureTypeId, String isCancel) {
        this.insureTypeId = insureTypeId;
        this.isCancel = isCancel;
    }

    public Integer getInsureTypeId() {
        return insureTypeId;
    }

    public void setInsureTypeId(Integer insureTypeId) {
        this.insureTypeId = insureTypeId;
    }

    public String getInsureTypeName() {
        return insureTypeName;
    }

    public void setInsureTypeName(String insureTypeName) {
        this.insureTypeName = insureTypeName;
    }

    public Integer getSeqOrder() {
        return seqOrder;
    }

    public void setSeqOrder(Integer seqOrder) {
        this.seqOrder = seqOrder;
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
        hash += (insureTypeId != null ? insureTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PcInsureType)) {
            return false;
        }
        PcInsureType other = (PcInsureType) object;
        if ((this.insureTypeId == null && other.insureTypeId != null) || (this.insureTypeId != null && !this.insureTypeId.equals(other.insureTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ERP_PC.PcInsureType[ insureTypeId=" + insureTypeId + " ]";
    }
    
}
