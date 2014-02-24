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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "V_SH_SUPPLIER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VShSupplier.findAll", query = "SELECT v FROM VShSupplier v"),
    @NamedQuery(name = "VShSupplier.findBySupplierId", query = "SELECT v FROM VShSupplier v WHERE v.supplierId = :supplierId"),
    @NamedQuery(name = "VShSupplier.findByTitleName", query = "SELECT v FROM VShSupplier v WHERE v.titleName = :titleName"),
    @NamedQuery(name = "VShSupplier.findBySupplierName", query = "SELECT v FROM VShSupplier v WHERE v.supplierName = :supplierName"),
    @NamedQuery(name = "VShSupplier.findByLastName", query = "SELECT v FROM VShSupplier v WHERE v.lastName = :lastName"),
    @NamedQuery(name = "VShSupplier.findByFullName", query = "SELECT v FROM VShSupplier v WHERE v.fullName = :fullName"),
    @NamedQuery(name = "VShSupplier.findByTitleNameEn", query = "SELECT v FROM VShSupplier v WHERE v.titleNameEn = :titleNameEn"),
    @NamedQuery(name = "VShSupplier.findBySupplierNameEn", query = "SELECT v FROM VShSupplier v WHERE v.supplierNameEn = :supplierNameEn"),
    @NamedQuery(name = "VShSupplier.findByLastNameEn", query = "SELECT v FROM VShSupplier v WHERE v.lastNameEn = :lastNameEn"),
    @NamedQuery(name = "VShSupplier.findByFullNameEn", query = "SELECT v FROM VShSupplier v WHERE v.fullNameEn = :fullNameEn"),
    @NamedQuery(name = "VShSupplier.findByBusinessTypeId", query = "SELECT v FROM VShSupplier v WHERE v.businessTypeId = :businessTypeId"),
    @NamedQuery(name = "VShSupplier.findByTaxNo", query = "SELECT v FROM VShSupplier v WHERE v.taxNo = :taxNo"),
    @NamedQuery(name = "VShSupplier.findByRegisterNo", query = "SELECT v FROM VShSupplier v WHERE v.registerNo = :registerNo"),
    @NamedQuery(name = "VShSupplier.findByRegisterDate", query = "SELECT v FROM VShSupplier v WHERE v.registerDate = :registerDate"),
    @NamedQuery(name = "VShSupplier.findByAddress", query = "SELECT v FROM VShSupplier v WHERE v.address = :address"),
    @NamedQuery(name = "VShSupplier.findByRegionId", query = "SELECT v FROM VShSupplier v WHERE v.regionId = :regionId"),
    @NamedQuery(name = "VShSupplier.findByFullAddress", query = "SELECT v FROM VShSupplier v WHERE v.fullAddress = :fullAddress"),
    @NamedQuery(name = "VShSupplier.findByPostalCode", query = "SELECT v FROM VShSupplier v WHERE v.postalCode = :postalCode"),
    @NamedQuery(name = "VShSupplier.findByPhone", query = "SELECT v FROM VShSupplier v WHERE v.phone = :phone"),
    @NamedQuery(name = "VShSupplier.findByFax", query = "SELECT v FROM VShSupplier v WHERE v.fax = :fax"),
    @NamedQuery(name = "VShSupplier.findByEmail", query = "SELECT v FROM VShSupplier v WHERE v.email = :email"),
    @NamedQuery(name = "VShSupplier.findByAddition", query = "SELECT v FROM VShSupplier v WHERE v.addition = :addition"),
    @NamedQuery(name = "VShSupplier.findByIsCancel", query = "SELECT v FROM VShSupplier v WHERE v.isCancel = :isCancel"),
    @NamedQuery(name = "VShSupplier.findByCancelDate", query = "SELECT v FROM VShSupplier v WHERE v.cancelDate = :cancelDate"),
    @NamedQuery(name = "VShSupplier.findByCancelPerId", query = "SELECT v FROM VShSupplier v WHERE v.cancelPerId = :cancelPerId")})
public class VShSupplier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "SUPPLIER_ID")
    @Id
    private int supplierId;
    @Column(name = "TITLE_NAME")
    private String titleName;
    @Column(name = "SUPPLIER_NAME")
    private String supplierName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "FULL_NAME")
    private String fullName;
    @Column(name = "TITLE_NAME_EN")
    private String titleNameEn;
    @Column(name = "SUPPLIER_NAME_EN")
    private String supplierNameEn;
    @Column(name = "LAST_NAME_EN")
    private String lastNameEn;
    @Basic(optional = false)
    @Column(name = "FULL_NAME_EN")
    private String fullNameEn;
    @Column(name = "BUSINESS_TYPE_ID")
    private Integer businessTypeId;
    @Column(name = "TAX_NO")
    private String taxNo;
    @Column(name = "REGISTER_NO")
    private String registerNo;
    @Column(name = "REGISTER_DATE")
    @Temporal(TemporalType.DATE)
    private Date registerDate;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "REGION_ID")
    private Integer regionId;
    @Basic(optional = false)
    @Column(name = "FULL_ADDRESS")
    private String fullAddress;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADDITION")
    private String addition;
    @Basic(optional = false)
    @Column(name = "IS_CANCEL")
    private String isCancel;
    @Column(name = "CANCEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelDate;
    @Column(name = "CANCEL_PER_ID")
    private Integer cancelPerId;

    public VShSupplier() {
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitleNameEn() {
        return titleNameEn;
    }

    public void setTitleNameEn(String titleNameEn) {
        this.titleNameEn = titleNameEn;
    }

    public String getSupplierNameEn() {
        return supplierNameEn;
    }

    public void setSupplierNameEn(String supplierNameEn) {
        this.supplierNameEn = supplierNameEn;
    }

    public String getLastNameEn() {
        return lastNameEn;
    }

    public void setLastNameEn(String lastNameEn) {
        this.lastNameEn = lastNameEn;
    }

    public String getFullNameEn() {
        return fullNameEn;
    }

    public void setFullNameEn(String fullNameEn) {
        this.fullNameEn = fullNameEn;
    }

    public Integer getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(Integer businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
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
    
}
