/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.ERP_AC;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author tanet-t
 */
@Entity
@Table(name = "AC_COUNTER")
@TableGenerator(
	name="counter_ac_counter", 
	table="AC_COUNTER", 
	pkColumnName="name", 
	valueColumnName="value", 
	pkColumnValue="AC_COUNTER", 
	initialValue=1, 
	allocationSize=10)
@NamedQuery(name = "AcCounter.findByName", query = "SELECT s FROM AcCounter s WHERE s.name = :name")
public class AcCounter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="counter_ac_counter")
    @Column(name = "NAME")
    private String name;
    @Column(name = "VALUE")
    private Integer value;

    public AcCounter() {
    }

    public AcCounter(String name) {
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

}
