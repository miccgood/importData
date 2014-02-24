/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ERP_PS;

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
@Table(name = "V_PS_PERSON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VPsPerson.findAll", query = "SELECT v FROM VPsPerson v"),
    @NamedQuery(name = "VPsPerson.findByBusinessUnitId", query = "SELECT v FROM VPsPerson v WHERE v.businessUnitId = :businessUnitId"),
    @NamedQuery(name = "VPsPerson.findByPersonId", query = "SELECT v FROM VPsPerson v WHERE v.personId = :personId"),
    @NamedQuery(name = "VPsPerson.findByBasePersonId", query = "SELECT v FROM VPsPerson v WHERE v.basePersonId = :basePersonId"),
    @NamedQuery(name = "VPsPerson.findByTitleId", query = "SELECT v FROM VPsPerson v WHERE v.titleId = :titleId"),
    @NamedQuery(name = "VPsPerson.findByTitleName", query = "SELECT v FROM VPsPerson v WHERE v.titleName = :titleName"),
    @NamedQuery(name = "VPsPerson.findByFirstName", query = "SELECT v FROM VPsPerson v WHERE v.firstName = :firstName"),
    @NamedQuery(name = "VPsPerson.findByLastName", query = "SELECT v FROM VPsPerson v WHERE v.lastName = :lastName"),
    @NamedQuery(name = "VPsPerson.findByPersonName", query = "SELECT v FROM VPsPerson v WHERE v.personName = :personName"),
    @NamedQuery(name = "VPsPerson.findByEngFirstName", query = "SELECT v FROM VPsPerson v WHERE v.engFirstName = :engFirstName"),
    @NamedQuery(name = "VPsPerson.findByEngLastName", query = "SELECT v FROM VPsPerson v WHERE v.engLastName = :engLastName"),
    @NamedQuery(name = "VPsPerson.findByIdCard", query = "SELECT v FROM VPsPerson v WHERE v.idCard = :idCard"),
    @NamedQuery(name = "VPsPerson.findByGender", query = "SELECT v FROM VPsPerson v WHERE v.gender = :gender"),
    @NamedQuery(name = "VPsPerson.findByMarriageStatus", query = "SELECT v FROM VPsPerson v WHERE v.marriageStatus = :marriageStatus"),
    @NamedQuery(name = "VPsPerson.findByTaxNo", query = "SELECT v FROM VPsPerson v WHERE v.taxNo = :taxNo"),
    @NamedQuery(name = "VPsPerson.findByBirthDate", query = "SELECT v FROM VPsPerson v WHERE v.birthDate = :birthDate"),
    @NamedQuery(name = "VPsPerson.findByEmail", query = "SELECT v FROM VPsPerson v WHERE v.email = :email"),
    @NamedQuery(name = "VPsPerson.findByInStructure", query = "SELECT v FROM VPsPerson v WHERE v.inStructure = :inStructure"),
    @NamedQuery(name = "VPsPerson.findByPersonCode", query = "SELECT v FROM VPsPerson v WHERE v.personCode = :personCode"),
    @NamedQuery(name = "VPsPerson.findByPersonTypeId", query = "SELECT v FROM VPsPerson v WHERE v.personTypeId = :personTypeId"),
    @NamedQuery(name = "VPsPerson.findByPosition", query = "SELECT v FROM VPsPerson v WHERE v.position = :position"),
    @NamedQuery(name = "VPsPerson.findByGroupLineId", query = "SELECT v FROM VPsPerson v WHERE v.groupLineId = :groupLineId"),
    @NamedQuery(name = "VPsPerson.findByPositionLineId", query = "SELECT v FROM VPsPerson v WHERE v.positionLineId = :positionLineId"),
    @NamedQuery(name = "VPsPerson.findByDepartmentId", query = "SELECT v FROM VPsPerson v WHERE v.departmentId = :departmentId"),
    @NamedQuery(name = "VPsPerson.findByJobDepartmentId", query = "SELECT v FROM VPsPerson v WHERE v.jobDepartmentId = :jobDepartmentId"),
    @NamedQuery(name = "VPsPerson.findByPlaceId", query = "SELECT v FROM VPsPerson v WHERE v.placeId = :placeId"),
    @NamedQuery(name = "VPsPerson.findByIsCancel", query = "SELECT v FROM VPsPerson v WHERE v.isCancel = :isCancel"),
    @NamedQuery(name = "VPsPerson.findByExtPhone", query = "SELECT v FROM VPsPerson v WHERE v.extPhone = :extPhone"),
    @NamedQuery(name = "VPsPerson.findByRemark", query = "SELECT v FROM VPsPerson v WHERE v.remark = :remark")})
public class VPsPerson implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "BUSINESS_UNIT_ID")
    private Integer businessUnitId;
    @Basic(optional = false)
    @Column(name = "PERSON_ID")
    @Id
    private int personId;
    @Basic(optional = false)
    @Column(name = "BASE_PERSON_ID")
    private int basePersonId;
    @Column(name = "TITLE_ID")
    private Integer titleId;
    @Column(name = "TITLE_NAME")
    private String titleName;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "PERSON_NAME")
    private String personName;
    @Column(name = "ENG_FIRST_NAME")
    private String engFirstName;
    @Column(name = "ENG_LAST_NAME")
    private String engLastName;
    @Column(name = "ID_CARD")
    private String idCard;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "MARRIAGE_STATUS")
    private String marriageStatus;
    @Column(name = "TAX_NO")
    private String taxNo;
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "IN_STRUCTURE")
    private String inStructure;
    @Column(name = "PERSON_CODE")
    private String personCode;
    @Column(name = "PERSON_TYPE_ID")
    private Integer personTypeId;
    @Column(name = "POSITION")
    private String position;
    @Column(name = "GROUP_LINE_ID")
    private Integer groupLineId;
    @Column(name = "POSITION_LINE_ID")
    private Integer positionLineId;
    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
    @Column(name = "JOB_DEPARTMENT_ID")
    private Integer jobDepartmentId;
    @Column(name = "PLACE_ID")
    private Integer placeId;
    @Basic(optional = false)
    @Column(name = "IS_CANCEL")
    private String isCancel;
    @Column(name = "EXT_PHONE")
    private String extPhone;
    @Column(name = "REMARK")
    private String remark;

    public VPsPerson() {
    }

    public Integer getBusinessUnitId() {
        return businessUnitId;
    }

    public void setBusinessUnitId(Integer businessUnitId) {
        this.businessUnitId = businessUnitId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getBasePersonId() {
        return basePersonId;
    }

    public void setBasePersonId(int basePersonId) {
        this.basePersonId = basePersonId;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getEngFirstName() {
        return engFirstName;
    }

    public void setEngFirstName(String engFirstName) {
        this.engFirstName = engFirstName;
    }

    public String getEngLastName() {
        return engLastName;
    }

    public void setEngLastName(String engLastName) {
        this.engLastName = engLastName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInStructure() {
        return inStructure;
    }

    public void setInStructure(String inStructure) {
        this.inStructure = inStructure;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public Integer getPersonTypeId() {
        return personTypeId;
    }

    public void setPersonTypeId(Integer personTypeId) {
        this.personTypeId = personTypeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getGroupLineId() {
        return groupLineId;
    }

    public void setGroupLineId(Integer groupLineId) {
        this.groupLineId = groupLineId;
    }

    public Integer getPositionLineId() {
        return positionLineId;
    }

    public void setPositionLineId(Integer positionLineId) {
        this.positionLineId = positionLineId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getJobDepartmentId() {
        return jobDepartmentId;
    }

    public void setJobDepartmentId(Integer jobDepartmentId) {
        this.jobDepartmentId = jobDepartmentId;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel;
    }

    public String getExtPhone() {
        return extPhone;
    }

    public void setExtPhone(String extPhone) {
        this.extPhone = extPhone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
}
