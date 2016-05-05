/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Altarix
 */
@Entity
@Table(name = "container_classif")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContainerClassif.findAll", query = "SELECT c FROM ContainerClassif c"),
    @NamedQuery(name = "ContainerClassif.findById", query = "SELECT c FROM ContainerClassif c WHERE c.id = :id"),
    @NamedQuery(name = "ContainerClassif.findByName", query = "SELECT c FROM ContainerClassif c WHERE c.name = :name"),
    @NamedQuery(name = "ContainerClassif.findByShortName", query = "SELECT c FROM ContainerClassif c WHERE c.shortName = :shortName")})
public class ContainerClassif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 256)
    @Column(name = "name")
    private String name;
    @Size(max = 128)
    @Column(name = "short_name")
    private String shortName;
    @OneToMany(mappedBy = "cont")
    private Collection<Product> productCollection;

    public ContainerClassif() {
    }

    public ContainerClassif(Integer id) {
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
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
        if (!(object instanceof ContainerClassif)) {
            return false;
        }
        ContainerClassif other = (ContainerClassif) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prod.model.ContainerClassif[ id=" + id + " ]";
    }
    
}
