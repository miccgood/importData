/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.Sys;

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
@Table(name = "SYSIBM.SQLPRIMARYKEYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sqlprimarykeys.findAll", query = "SELECT s FROM Sqlprimarykeys s"),
    @NamedQuery(name = "Sqlprimarykeys.findByTableCat", query = "SELECT s FROM Sqlprimarykeys s WHERE s.tableCat = :tableCat"),
    @NamedQuery(name = "Sqlprimarykeys.findByTableSchem", query = "SELECT s FROM Sqlprimarykeys s WHERE s.tableSchem = :tableSchem"),
    @NamedQuery(name = "Sqlprimarykeys.findByTableName", query = "SELECT s FROM Sqlprimarykeys s WHERE s.tableName = :tableName"),
    @NamedQuery(name = "Sqlprimarykeys.findByColumnName", query = "SELECT s FROM Sqlprimarykeys s WHERE s.columnName = :columnName"),
    @NamedQuery(name = "Sqlprimarykeys.findByKeySeq", query = "SELECT s FROM Sqlprimarykeys s WHERE s.keySeq = :keySeq"),
    @NamedQuery(name = "Sqlprimarykeys.findByPkName", query = "SELECT s FROM Sqlprimarykeys s WHERE s.pkName = :pkName")})
public class Sqlprimarykeys implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "TABLE_CAT")
    private String tableCat;
    @Basic(optional = false)
    @Column(name = "TABLE_SCHEM")
    private String tableSchem;
    @Id
    @Basic(optional = false)
    @Column(name = "TABLE_NAME")
    private String tableName;
    @Basic(optional = false)
    @Column(name = "COLUMN_NAME")
    private String columnName;
    @Column(name = "KEY_SEQ")
    private Short keySeq;
    @Basic(optional = false)
    @Column(name = "PK_NAME")
    private String pkName;

    public Sqlprimarykeys() {
    }

    public String getTableCat() {
        return tableCat;
    }

    public void setTableCat(String tableCat) {
        this.tableCat = tableCat;
    }

    public String getTableSchem() {
        return tableSchem;
    }

    public void setTableSchem(String tableSchem) {
        this.tableSchem = tableSchem;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Short getKeySeq() {
        return keySeq;
    }

    public void setKeySeq(Short keySeq) {
        this.keySeq = keySeq;
    }

    public String getPkName() {
        return pkName;
    }

    public void setPkName(String pkName) {
        this.pkName = pkName;
    }
    
}
