/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_AC;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "AC_CREDIT_CARD_TYPE")
@NamedQueries({
    @NamedQuery(name = "AcCreditCardType.findAll", query = "SELECT a FROM AcCreditCardType a"),
    @NamedQuery(name = "AcCreditCardType.findByName", query = "SELECT a FROM AcCreditCardType a WHERE a.name = :name")})
public class AcCreditCardType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CREDIT_CARD_TYPE_ID")
    private Integer creditCardTypeId;
    @Basic(optional = false)
    @Column(name = "CODE")
    private String code;
    @Column(name = "NAME")
    private String name;

    public AcCreditCardType() {
    }

    public AcCreditCardType(Integer creditCardTypeId) {
        this.creditCardTypeId = creditCardTypeId;
    }

    public AcCreditCardType(Integer creditCardTypeId, String code) {
        this.creditCardTypeId = creditCardTypeId;
        this.code = code;
    }

    public Integer getCreditCardTypeId() {
        return creditCardTypeId;
    }

    public void setCreditCardTypeId(Integer creditCardTypeId) {
        this.creditCardTypeId = creditCardTypeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditCardTypeId != null ? creditCardTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcCreditCardType)) {
            return false;
        }
        AcCreditCardType other = (AcCreditCardType) object;
        if ((this.creditCardTypeId == null && other.creditCardTypeId != null) || (this.creditCardTypeId != null && !this.creditCardTypeId.equals(other.creditCardTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_AC.AcCreditCardType[ creditCardTypeId=" + creditCardTypeId + " ]";
    }
    
}
