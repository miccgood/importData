/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_SH;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "SH_SOURCE")
@NamedQueries({
    @NamedQuery(name = "ShSource.findAll", query = "SELECT s FROM ShSource s")})
public class ShSource implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "SOURCE_ID")
    private Integer sourceId;
    @Column(name = "SOURCE_CODE")
    private String sourceCode;
    @Column(name = "TREE_LEFT")
    private Integer treeLeft;
    @Column(name = "TREE_RIGHT")
    private Integer treeRight;
    @Column(name = "TREE_LEVEL")
    private Integer treeLevel;
    @Column(name = "IS_LEAF")
    private String isLeaf;
    @Column(name = "OLD_CODE")
    private String oldCode;
    @Column(name = "OLD_NAME")
    private String oldName;
    @Column(name = "OLD_CLASS_CODE")
    private String oldClassCode;
    @Column(name = "IS_INHERIT")
    private String isInherit;
    @Column(name = "IS_OBJECTIVE_DONATE")
    private String isObjectiveDonate;
    @Column(name = "IS_PROPAGATE")
    private String isPropagate;
    @Column(name = "IS_EXTERNAL")
    private String isExternal;
    
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
    @Column(name = "BUSINESS_UNIT_ID")
    private Integer businessUnitId;
    @Column(name = "SOURCE_NAME")
    private String sourceName;
    @Column(name = "SOURCE_DESC")
    private String sourceDesc;
    @JoinColumn(name = "SOURCE_CHART_ID", referencedColumnName = "SOURCE_CHART_ID")
    @ManyToOne
    private ShSourceChart sourceChartId;
    @OneToMany(mappedBy = "parentId")
    private Collection<ShSource> shSourceCollection;
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "SOURCE_ID")
    @ManyToOne
    private ShSource parentId;

    public ShSource() {
    }

    public ShSource(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public ShSource(Integer sourceId, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.sourceId = sourceId;
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

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Integer getTreeLeft() {
        return treeLeft;
    }

    public void setTreeLeft(Integer treeLeft) {
        this.treeLeft = treeLeft;
    }

    public Integer getTreeRight() {
        return treeRight;
    }

    public void setTreeRight(Integer treeRight) {
        this.treeRight = treeRight;
    }

    public Integer getTreeLevel() {
        return treeLevel;
    }

    public void setTreeLevel(Integer treeLevel) {
        this.treeLevel = treeLevel;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getOldCode() {
        return oldCode;
    }

    public void setOldCode(String oldCode) {
        this.oldCode = oldCode;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getOldClassCode() {
        return oldClassCode;
    }

    public void setOldClassCode(String oldClassCode) {
        this.oldClassCode = oldClassCode;
    }

    public String getIsInherit() {
        return isInherit;
    }

    public void setIsInherit(String isInherit) {
        this.isInherit = isInherit;
    }

    public String getIsObjectiveDonate() {
        return isObjectiveDonate;
    }

    public void setIsObjectiveDonate(String isObjectiveDonate) {
        this.isObjectiveDonate = isObjectiveDonate;
    }

    public String getIsPropagate() {
        return isPropagate;
    }

    public void setIsPropagate(String isPropagate) {
        this.isPropagate = isPropagate;
    }

    public String getIsExternal() {
        return isExternal;
    }

    public void setIsExternal(String isExternal) {
        this.isExternal = isExternal;
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

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceDesc() {
        return sourceDesc;
    }

    public void setSourceDesc(String sourceDesc) {
        this.sourceDesc = sourceDesc;
    }

    public ShSourceChart getSourceChartId() {
        return sourceChartId;
    }

    public void setSourceChartId(ShSourceChart sourceChartId) {
        this.sourceChartId = sourceChartId;
    }

    @XmlTransient
    public Collection<ShSource> getShSourceCollection() {
        return shSourceCollection;
    }

    public void setShSourceCollection(Collection<ShSource> shSourceCollection) {
        this.shSourceCollection = shSourceCollection;
    }

    public ShSource getParentId() {
        return parentId;
    }

    public void setParentId(ShSource parentId) {
        this.parentId = parentId;
    }
    
}
