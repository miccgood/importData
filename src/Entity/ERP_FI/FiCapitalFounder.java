/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_FI;

import java.io.Serializable;
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
@Table(name = "FI_CAPITAL_FOUNDER")
@TableGenerator(
        name = "counter_capital_funder",
        table = "AC_COUNTER",
        pkColumnName = "name",
        valueColumnName = "value",
        pkColumnValue = "FI_CAPITAL_FOUNDER",
        initialValue = 1,
        allocationSize = 10)

public class FiCapitalFounder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="counter_capital_funder")
    
    @Column(name = "CAPITAL_FOUNDER_ID")
    private Integer capitalFounderId;
    @Column(name = "CAPITAL_ID")
    private Integer capitalId;
    @Column(name = "PERSON_ID")
    private Integer personId;
    
    @Column(name = "IS_CANCEL")
    private String isCancel;
    @Column(name = "CANCEL_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cancelDate;
    @Column(name = "CANCEL_PER_ID")
    private Integer cancelPerId;
    
    @Column(name = "IS_LOCK_UPDATE")
    private String isLockUpdate;
    
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
    private int lastUpdVersion;

    public FiCapitalFounder() {
    }

    public FiCapitalFounder(Integer capitalFounderId) {
        this.capitalFounderId = capitalFounderId;
    }

    public FiCapitalFounder(Integer capitalFounderId, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.capitalFounderId = capitalFounderId;
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

    public Integer getCapitalFounderId() {
        return capitalFounderId;
    }

    public void setCapitalFounderId(Integer capitalFounderId) {
        this.capitalFounderId = capitalFounderId;
    }

    public Integer getCapitalId() {
        return capitalId;
    }

    public void setCapitalId(Integer capitalId) {
        this.capitalId = capitalId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capitalFounderId != null ? capitalFounderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FiCapitalFounder)) {
            return false;
        }
        FiCapitalFounder other = (FiCapitalFounder) object;
        if ((this.capitalFounderId == null && other.capitalFounderId != null) || (this.capitalFounderId != null && !this.capitalFounderId.equals(other.capitalFounderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_FI.FiCapitalFounder[ capitalFounderId=" + capitalFounderId + " ]";
    }
    
}
