/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_SH;

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
@Table(name = "SH_SYSTEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShSystem.findAll", query = "SELECT s FROM ShSystem s"),
    @NamedQuery(name = "ShSystem.findBySystemId", query = "SELECT s FROM ShSystem s WHERE s.systemId = :systemId"),
    @NamedQuery(name = "ShSystem.findBySystemCode", query = "SELECT s FROM ShSystem s WHERE s.systemCode = :systemCode"),
    @NamedQuery(name = "ShSystem.findBySystemName", query = "SELECT s FROM ShSystem s WHERE s.systemName = :systemName"),
    @NamedQuery(name = "ShSystem.findByIsCancel", query = "SELECT s FROM ShSystem s WHERE s.isCancel = :isCancel"),
    @NamedQuery(name = "ShSystem.findByCancelDate", query = "SELECT s FROM ShSystem s WHERE s.cancelDate = :cancelDate"),
    @NamedQuery(name = "ShSystem.findByCancelPerId", query = "SELECT s FROM ShSystem s WHERE s.cancelPerId = :cancelPerId"),
    @NamedQuery(name = "ShSystem.findByCreateTime", query = "SELECT s FROM ShSystem s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "ShSystem.findByCreateUserId", query = "SELECT s FROM ShSystem s WHERE s.createUserId = :createUserId"),
    @NamedQuery(name = "ShSystem.findByCreateProg", query = "SELECT s FROM ShSystem s WHERE s.createProg = :createProg"),
    @NamedQuery(name = "ShSystem.findByLastUpdTime", query = "SELECT s FROM ShSystem s WHERE s.lastUpdTime = :lastUpdTime"),
    @NamedQuery(name = "ShSystem.findByLastUpdUserId", query = "SELECT s FROM ShSystem s WHERE s.lastUpdUserId = :lastUpdUserId"),
    @NamedQuery(name = "ShSystem.findByLastUpdProg", query = "SELECT s FROM ShSystem s WHERE s.lastUpdProg = :lastUpdProg"),
    @NamedQuery(name = "ShSystem.findByLastUpdVersion", query = "SELECT s FROM ShSystem s WHERE s.lastUpdVersion = :lastUpdVersion")})
public class ShSystem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SYSTEM_ID")
    private Integer systemId;
    @Column(name = "SYSTEM_CODE")
    private String systemCode;
    @Column(name = "SYSTEM_NAME")
    private String systemName;
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
    @OneToMany(mappedBy = "systemId")
    private Collection<ShFormType> shFormTypeCollection;

    public ShSystem() {
    }

    public ShSystem(Integer systemId) {
        this.systemId = systemId;
    }

    public ShSystem(Integer systemId, String isCancel) {
        this.systemId = systemId;
        this.isCancel = isCancel;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
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
    public Collection<ShFormType> getShFormTypeCollection() {
        return shFormTypeCollection;
    }

    public void setShFormTypeCollection(Collection<ShFormType> shFormTypeCollection) {
        this.shFormTypeCollection = shFormTypeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (systemId != null ? systemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShSystem)) {
            return false;
        }
        ShSystem other = (ShSystem) object;
        if ((this.systemId == null && other.systemId != null) || (this.systemId != null && !this.systemId.equals(other.systemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_SH.ShSystem[ systemId=" + systemId + " ]";
    }
    
}
