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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "SH_FORM_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShFormType.findAll", query = "SELECT s FROM ShFormType s"),
    @NamedQuery(name = "ShFormType.findByFormTypeId", query = "SELECT s FROM ShFormType s WHERE s.formTypeId = :formTypeId"),
    @NamedQuery(name = "ShFormType.findByFormTypeCode", query = "SELECT s FROM ShFormType s WHERE s.formTypeCode = :formTypeCode"),
    @NamedQuery(name = "ShFormType.findByFormTypeName", query = "SELECT s FROM ShFormType s WHERE s.formTypeName = :formTypeName"),
    @NamedQuery(name = "ShFormType.findByPrefixLetter", query = "SELECT s FROM ShFormType s WHERE s.prefixLetter = :prefixLetter"),
    @NamedQuery(name = "ShFormType.findByIsCancel", query = "SELECT s FROM ShFormType s WHERE s.isCancel = :isCancel"),
    @NamedQuery(name = "ShFormType.findByCancelDate", query = "SELECT s FROM ShFormType s WHERE s.cancelDate = :cancelDate"),
    @NamedQuery(name = "ShFormType.findByCancelPerId", query = "SELECT s FROM ShFormType s WHERE s.cancelPerId = :cancelPerId"),
    @NamedQuery(name = "ShFormType.findByCreateTime", query = "SELECT s FROM ShFormType s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "ShFormType.findByLastUpdTime", query = "SELECT s FROM ShFormType s WHERE s.lastUpdTime = :lastUpdTime"),
    @NamedQuery(name = "ShFormType.findByCreateUserId", query = "SELECT s FROM ShFormType s WHERE s.createUserId = :createUserId"),
    @NamedQuery(name = "ShFormType.findByLastUpdUserId", query = "SELECT s FROM ShFormType s WHERE s.lastUpdUserId = :lastUpdUserId"),
    @NamedQuery(name = "ShFormType.findByCreateProg", query = "SELECT s FROM ShFormType s WHERE s.createProg = :createProg"),
    @NamedQuery(name = "ShFormType.findByLastUpdProg", query = "SELECT s FROM ShFormType s WHERE s.lastUpdProg = :lastUpdProg"),
    @NamedQuery(name = "ShFormType.findByLastUpdVersion", query = "SELECT s FROM ShFormType s WHERE s.lastUpdVersion = :lastUpdVersion"),
    @NamedQuery(name = "ShFormType.findByUrl", query = "SELECT s FROM ShFormType s WHERE s.url = :url")})
public class ShFormType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FORM_TYPE_ID")
    private Integer formTypeId;
    @Column(name = "FORM_TYPE_CODE")
    private String formTypeCode;
    @Column(name = "FORM_TYPE_NAME")
    private String formTypeName;
    @Column(name = "PREFIX_LETTER")
    private String prefixLetter;
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
    @Column(name = "LAST_UPD_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdTime;
    @Column(name = "CREATE_USER_ID")
    private String createUserId;
    @Column(name = "LAST_UPD_USER_ID")
    private String lastUpdUserId;
    @Column(name = "CREATE_PROG")
    private String createProg;
    @Column(name = "LAST_UPD_PROG")
    private String lastUpdProg;
    @Column(name = "LAST_UPD_VERSION")
    private Integer lastUpdVersion;
    @Column(name = "URL")
    private String url;
    @JoinColumn(name = "SYSTEM_ID", referencedColumnName = "SYSTEM_ID")
    @ManyToOne
    private ShSystem systemId;

    public ShFormType() {
    }

    public ShFormType(Integer formTypeId) {
        this.formTypeId = formTypeId;
    }

    public ShFormType(Integer formTypeId, String isCancel) {
        this.formTypeId = formTypeId;
        this.isCancel = isCancel;
    }

    public Integer getFormTypeId() {
        return formTypeId;
    }

    public void setFormTypeId(Integer formTypeId) {
        this.formTypeId = formTypeId;
    }

    public String getFormTypeCode() {
        return formTypeCode;
    }

    public void setFormTypeCode(String formTypeCode) {
        this.formTypeCode = formTypeCode;
    }

    public String getFormTypeName() {
        return formTypeName;
    }

    public void setFormTypeName(String formTypeName) {
        this.formTypeName = formTypeName;
    }

    public String getPrefixLetter() {
        return prefixLetter;
    }

    public void setPrefixLetter(String prefixLetter) {
        this.prefixLetter = prefixLetter;
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

    public Date getLastUpdTime() {
        return lastUpdTime;
    }

    public void setLastUpdTime(Date lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getLastUpdUserId() {
        return lastUpdUserId;
    }

    public void setLastUpdUserId(String lastUpdUserId) {
        this.lastUpdUserId = lastUpdUserId;
    }

    public String getCreateProg() {
        return createProg;
    }

    public void setCreateProg(String createProg) {
        this.createProg = createProg;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ShSystem getSystemId() {
        return systemId;
    }

    public void setSystemId(ShSystem systemId) {
        this.systemId = systemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formTypeId != null ? formTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShFormType)) {
            return false;
        }
        ShFormType other = (ShFormType) object;
        if ((this.formTypeId == null && other.formTypeId != null) || (this.formTypeId != null && !this.formTypeId.equals(other.formTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_SH.ShFormType[ formTypeId=" + formTypeId + " ]";
    }
    
}
