/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Altarix
 */
@Entity
@Table(name = "vacancy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacancy.findAll", query = "SELECT v FROM Vacancy v"),
    @NamedQuery(name = "Vacancy.findById", query = "SELECT v FROM Vacancy v WHERE v.id = :id"),
    @NamedQuery(name = "Vacancy.findByName", query = "SELECT v FROM Vacancy v WHERE v.name = :name"),
    @NamedQuery(name = "Vacancy.findByText", query = "SELECT v FROM Vacancy v WHERE v.text = :text"),
    @NamedQuery(name = "Vacancy.findBySalary", query = "SELECT v FROM Vacancy v WHERE v.salary = :salary")})
public class Vacancy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 256)
    @Column(name = "name")
    private String name;
    @Size(max = 2147483647)
    @Column(name = "text")
    private String text;
    @Size(max = 512)
    @Column(name = "salary")
    private String salary;
    @JoinColumn(name = "wh_id", referencedColumnName = "id")
    @ManyToOne
    private Wholesaler whId;

    public Vacancy() {
    }

    public Vacancy(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Wholesaler getWhId() {
        return whId;
    }

    public void setWhId(Wholesaler whId) {
        this.whId = whId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacancy)) {
            return false;
        }
        Vacancy other = (Vacancy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prod.model.Vacancy[ id=" + id + " ]";
    }
    
}
