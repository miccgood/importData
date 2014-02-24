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
import javax.persistence.CascadeType;
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
@Table(name = "PC_AUCTION_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcAuctionType.findAll", query = "SELECT p FROM PcAuctionType p"),
    @NamedQuery(name = "PcAuctionType.findByAuctionTypeId", query = "SELECT p FROM PcAuctionType p WHERE p.auctionTypeId = :auctionTypeId"),
    @NamedQuery(name = "PcAuctionType.findByAuctionTypeName", query = "SELECT p FROM PcAuctionType p WHERE p.auctionTypeName = :auctionTypeName"),
    @NamedQuery(name = "PcAuctionType.findBySeqOrder", query = "SELECT p FROM PcAuctionType p WHERE p.seqOrder = :seqOrder"),
    @NamedQuery(name = "PcAuctionType.findByIsCancel", query = "SELECT p FROM PcAuctionType p WHERE p.isCancel = :isCancel"),
    @NamedQuery(name = "PcAuctionType.findByCancelDate", query = "SELECT p FROM PcAuctionType p WHERE p.cancelDate = :cancelDate"),
    @NamedQuery(name = "PcAuctionType.findByCancelPerId", query = "SELECT p FROM PcAuctionType p WHERE p.cancelPerId = :cancelPerId"),
    @NamedQuery(name = "PcAuctionType.findByCreateTime", query = "SELECT p FROM PcAuctionType p WHERE p.createTime = :createTime"),
    @NamedQuery(name = "PcAuctionType.findByCreateUserId", query = "SELECT p FROM PcAuctionType p WHERE p.createUserId = :createUserId"),
    @NamedQuery(name = "PcAuctionType.findByCreateProg", query = "SELECT p FROM PcAuctionType p WHERE p.createProg = :createProg"),
    @NamedQuery(name = "PcAuctionType.findByLastUpdTime", query = "SELECT p FROM PcAuctionType p WHERE p.lastUpdTime = :lastUpdTime"),
    @NamedQuery(name = "PcAuctionType.findByLastUpdUserId", query = "SELECT p FROM PcAuctionType p WHERE p.lastUpdUserId = :lastUpdUserId"),
    @NamedQuery(name = "PcAuctionType.findByLastUpdProg", query = "SELECT p FROM PcAuctionType p WHERE p.lastUpdProg = :lastUpdProg"),
    @NamedQuery(name = "PcAuctionType.findByLastUpdVersion", query = "SELECT p FROM PcAuctionType p WHERE p.lastUpdVersion = :lastUpdVersion")})
public class PcAuctionType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AUCTION_TYPE_ID")
    private Integer auctionTypeId;
    @Column(name = "AUCTION_TYPE_NAME")
    private String auctionTypeName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auctionTypeId")
    private Collection<PcAuction> pcAuctionCollection;

    public PcAuctionType() {
    }

    public PcAuctionType(Integer auctionTypeId) {
        this.auctionTypeId = auctionTypeId;
    }

    public PcAuctionType(Integer auctionTypeId, String isCancel) {
        this.auctionTypeId = auctionTypeId;
        this.isCancel = isCancel;
    }

    public Integer getAuctionTypeId() {
        return auctionTypeId;
    }

    public void setAuctionTypeId(Integer auctionTypeId) {
        this.auctionTypeId = auctionTypeId;
    }

    public String getAuctionTypeName() {
        return auctionTypeName;
    }

    public void setAuctionTypeName(String auctionTypeName) {
        this.auctionTypeName = auctionTypeName;
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
    public Collection<PcAuction> getPcAuctionCollection() {
        return pcAuctionCollection;
    }

    public void setPcAuctionCollection(Collection<PcAuction> pcAuctionCollection) {
        this.pcAuctionCollection = pcAuctionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auctionTypeId != null ? auctionTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PcAuctionType)) {
            return false;
        }
        PcAuctionType other = (PcAuctionType) object;
        if ((this.auctionTypeId == null && other.auctionTypeId != null) || (this.auctionTypeId != null && !this.auctionTypeId.equals(other.auctionTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ERP_PC.PcAuctionType[ auctionTypeId=" + auctionTypeId + " ]";
    }
    
}
