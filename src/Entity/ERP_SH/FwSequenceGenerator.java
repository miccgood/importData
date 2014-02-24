/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_SH;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "FW_SEQUENCE_GENERATOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FwSequenceGenerator.findAll", query = "SELECT f FROM FwSequenceGenerator f"),
    @NamedQuery(name = "FwSequenceGenerator.findByName", query = "SELECT f FROM FwSequenceGenerator f WHERE f.name = :name"),
    @NamedQuery(name = "FwSequenceGenerator.findByValue", query = "SELECT f FROM FwSequenceGenerator f WHERE f.value = :value"),
    @NamedQuery(name = "FwSequenceGenerator.findByRemark", query = "SELECT f FROM FwSequenceGenerator f WHERE f.remark = :remark")})
public class FwSequenceGenerator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "VALUE")
    private Integer value;
    @Column(name = "REMARK")
    private String remark;

    public FwSequenceGenerator() {
    }

    public FwSequenceGenerator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FwSequenceGenerator)) {
            return false;
        }
        FwSequenceGenerator other = (FwSequenceGenerator) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ERP_SH.FwSequenceGenerator[ name=" + name + " ]";
    }
    
}
