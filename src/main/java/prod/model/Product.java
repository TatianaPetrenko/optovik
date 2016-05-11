/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Altarix
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByIsProduced", query = "SELECT p FROM Product p WHERE p.isProduced = :isProduced"),
    @NamedQuery(name = "Product.findByIsAvailable", query = "SELECT p FROM Product p WHERE p.isAvailable = :isAvailable"),
    @NamedQuery(name = "Product.findByVolume", query = "SELECT p FROM Product p WHERE p.volume = :volume"),
    @NamedQuery(name = "Product.findByDateProd", query = "SELECT p FROM Product p WHERE p.dateProd = :dateProd"),
    @NamedQuery(name = "Product.findByCost", query = "SELECT p FROM Product p WHERE p.cost = :cost"),
    @NamedQuery(name = "Product.findByCostMin", query = "SELECT p FROM Product p WHERE p.costMin = :costMin"),
    @NamedQuery(name = "Product.findByCostMax", query = "SELECT p FROM Product p WHERE p.costMax = :costMax")})
public class Product implements Serializable {

    @OneToMany(mappedBy = "prId")
    private Collection<ProductCat> productCatCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 512)
    @Column(name = "name")
    private String name;
    @Column(name = "isProduced")
    private Boolean isProduced;
    @Column(name = "isAvailable")
    private Boolean isAvailable;
    @Column(name = "volume")
    private Integer volume;
    @Column(name = "date_prod")
    @Temporal(TemporalType.DATE)
    private Date dateProd;
    @Column(name = "cost")
    private Integer cost;
    @Column(name = "cost_min")
    private Integer costMin;
    @Column(name = "cost_max")
    private Integer costMax;
    @JoinColumn(name = "cont", referencedColumnName = "id")
    @ManyToOne
    private ContainerClassif cont;
    @JoinColumn(name = "vol_class", referencedColumnName = "id")
    @ManyToOne
    private VolumeClassif volClass;
    @JoinColumn(name = "wh_id", referencedColumnName = "id")
    @ManyToOne
    private Wholesaler whId;

    public Product() {
    }

    public Product(Integer id) {
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

    public Boolean getIsProduced() {
        return isProduced;
    }

    public void setIsProduced(Boolean isProduced) {
        this.isProduced = isProduced;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Date getDateProd() {
        return dateProd;
    }

    public void setDateProd(Date dateProd) {
        this.dateProd = dateProd;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCostMin() {
        return costMin;
    }

    public void setCostMin(Integer costMin) {
        this.costMin = costMin;
    }

    public Integer getCostMax() {
        return costMax;
    }

    public void setCostMax(Integer costMax) {
        this.costMax = costMax;
    }

    public ContainerClassif getCont() {
        return cont;
    }

    public void setCont(ContainerClassif cont) {
        this.cont = cont;
    }

    public VolumeClassif getVolClass() {
        return volClass;
    }

    public void setVolClass(VolumeClassif volClass) {
        this.volClass = volClass;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prod.model.Product[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<ProductCat> getProductCatCollection() {
        return productCatCollection;
    }

    public void setProductCatCollection(Collection<ProductCat> productCatCollection) {
        this.productCatCollection = productCatCollection;
    }
    
}
