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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "SH_TITLE")
@NamedQueries({
    @NamedQuery(name = "ShTitle.findAll", query = "SELECT s FROM ShTitle s"),
    @NamedQuery(name = "ShTitle.findByTitleName", query = "SELECT s FROM ShTitle s WHERE s.titleName = :titleName")})
public class ShTitle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TITLE_ID", nullable = false)
    private Integer titleId;
    @Column(name = "TITLE_CODE", length = 10)
    private String titleCode;
    @Column(name = "SHORT_TITLE_NAME", length = 30)
    private String shortTitleName;
    @Column(name = "TITLE_NAME", length = 250)
    private String titleName;
    @Column(name = "ENG_TITLE_NAME", length = 250)
    private String engTitleName;
    @Column(name = "LEGACY_CODE", length = 10)
    private String legacyCode;
    @Basic(optional = false)
    @Column(name = "IS_CANCEL", nullable = false, length = 1)
    private String isCancel;
    @Column(name = "CANCEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelDate;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "CANCEL_PER_ID")
    private Integer cancelPerId;
    @Column(name = "CREATE_USER_ID", length = 20)
    private String createUserId;
    @Column(name = "CREATE_PROG", length = 30)
    private String createProg;
    @Column(name = "LAST_UPD_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdTime;
    @Column(name = "LAST_UPD_USER_ID", length = 20)
    private String lastUpdUserId;
    @Column(name = "LAST_UPD_PROG", length = 30)
    private String lastUpdProg;
    @Column(name = "LAST_UPD_VERSION")
    private Integer lastUpdVersion;

    public ShTitle() {
    }

    public ShTitle(Integer titleId) {
        this.titleId = titleId;
    }

    public ShTitle(Integer titleId, String isCancel) {
        this.titleId = titleId;
        this.isCancel = isCancel;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public String getTitleCode() {
        return titleCode;
    }

    public void setTitleCode(String titleCode) {
        this.titleCode = titleCode;
    }

    public String getShortTitleName() {
        return shortTitleName;
    }

    public void setShortTitleName(String shortTitleName) {
        this.shortTitleName = shortTitleName;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getEngTitleName() {
        return engTitleName;
    }

    public void setEngTitleName(String engTitleName) {
        this.engTitleName = engTitleName;
    }

    public String getLegacyCode() {
        return legacyCode;
    }

    public void setLegacyCode(String legacyCode) {
        this.legacyCode = legacyCode;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCancelPerId() {
        return cancelPerId;
    }

    public void setCancelPerId(Integer cancelPerId) {
        this.cancelPerId = cancelPerId;
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
        hash += (titleId != null ? titleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShTitle)) {
            return false;
        }
        ShTitle other = (ShTitle) object;
        if ((this.titleId == null && other.titleId != null) || (this.titleId != null && !this.titleId.equals(other.titleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_SH.ShTitle[ titleId=" + titleId + " ]";
    }
    
}
