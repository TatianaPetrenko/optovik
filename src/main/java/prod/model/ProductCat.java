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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Altarix
 */
@Entity
@Table(name = "product_cat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductCat.findAll", query = "SELECT p FROM ProductCat p"),
    @NamedQuery(name = "ProductCat.findById", query = "SELECT p FROM ProductCat p WHERE p.id = :id")})
public class ProductCat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "pr_id", referencedColumnName = "id")
    @ManyToOne
    private Product prId;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne
    private ProductCategory catId;

    public ProductCat() {
    }

    public ProductCat(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getPrId() {
        return prId;
    }

    public void setPrId(Product prId) {
        this.prId = prId;
    }

    public ProductCategory getCatId() {
        return catId;
    }

    public void setCatId(ProductCategory catId) {
        this.catId = catId;
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
        if (!(object instanceof ProductCat)) {
            return false;
        }
        ProductCat other = (ProductCat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prod.model.ProductCat[ id=" + id + " ]";
    }
    
}
