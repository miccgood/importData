/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_SH;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Cacheable;
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
//@Cacheable
@Table(name = "SH_DEPARTMENT")
@NamedQueries({
    @NamedQuery(name = "ShDepartment.findAll", query = "SELECT s FROM ShDepartment s")})

public class ShDepartment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
    
    @Column(name = "DEPARTMENT_CODE")
    private String departmentCode;
    
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @Column(name = "DEPARTMENT_DESC")
    private String departmentDesc;
    @Column(name = "DEPARTMENT_TYPE")
    private String departmentType;
    @Column(name = "ALLOW_SELECT")
    private String allowSelect;
    @Column(name = "TREE_LEFT")
    private Integer treeLeft;
    @Column(name = "TREE_RIGHT")
    private Integer treeRight;
    @Column(name = "TREE_LEVEL")
    private Integer treeLevel;
    @Column(name = "PARENT_ID")
    private Integer parentId;
    @Column(name = "DEPARTMENT_CHART_ID")
    private Integer departmentChartId;
    @Column(name = "IS_LEAF")
    private String isLeaf;
    
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
    @Column(name = "IS_SELF_PAY")
    private String isSelfPay;
    @Column(name = "IS_SPECIALIST")
    private String isSpecialist;
    @Column(name = "BUSINESS_UNIT_TYPE")
    private String businessUnitType;
    @Column(name = "IS_FINANCE_CENTER")
    private String isFinanceCenter;

    public ShDepartment() {
    }

    public ShDepartment(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public ShDepartment(Integer departmentId, String departmentCode, String departmentName, String isCancel, String isLockUpdate, Date createTime, String createUserId, String createProg, Date lastUpdTime, String lastUpdUserId, String lastUpdProg, int lastUpdVersion) {
        this.departmentId = departmentId;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
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

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public String getAllowSelect() {
        return allowSelect;
    }

    public void setAllowSelect(String allowSelect) {
        this.allowSelect = allowSelect;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getDepartmentChartId() {
        return departmentChartId;
    }

    public void setDepartmentChartId(Integer departmentChartId) {
        this.departmentChartId = departmentChartId;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
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

    public String getIsSelfPay() {
        return isSelfPay;
    }

    public void setIsSelfPay(String isSelfPay) {
        this.isSelfPay = isSelfPay;
    }

    public String getIsSpecialist() {
        return isSpecialist;
    }

    public void setIsSpecialist(String isSpecialist) {
        this.isSpecialist = isSpecialist;
    }

    public String getBusinessUnitType() {
        return businessUnitType;
    }

    public void setBusinessUnitType(String businessUnitType) {
        this.businessUnitType = businessUnitType;
    }

    public String getIsFinanceCenter() {
        return isFinanceCenter;
    }

    public void setIsFinanceCenter(String isFinanceCenter) {
        this.isFinanceCenter = isFinanceCenter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShDepartment)) {
            return false;
        }
        ShDepartment other = (ShDepartment) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_SH.ShDepartment[ departmentId=" + departmentId + " ]";
    }
    
}
