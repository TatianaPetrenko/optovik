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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Altarix
 */
@Entity
@Table(name = "wholesaler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wholesaler.findAll", query = "SELECT w FROM Wholesaler w"),
    @NamedQuery(name = "Wholesaler.findById", query = "SELECT w FROM Wholesaler w WHERE w.id = :id"),
    @NamedQuery(name = "Wholesaler.findBySite", query = "SELECT w FROM Wholesaler w WHERE w.site = :site"),
    @NamedQuery(name = "Wholesaler.findByName", query = "SELECT w FROM Wholesaler w WHERE w.name = :name"),
    @NamedQuery(name = "Wholesaler.findByEmail", query = "SELECT w FROM Wholesaler w WHERE w.email = :email"),
    @NamedQuery(name = "Wholesaler.findByActDescription", query = "SELECT w FROM Wholesaler w WHERE w.actDescription = :actDescription"),
    @NamedQuery(name = "Wholesaler.findByTradeMark", query = "SELECT w FROM Wholesaler w WHERE w.tradeMark = :tradeMark")})
public class Wholesaler implements Serializable {

    @OneToMany(mappedBy = "idWh")
    private Collection<Images> imagesCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 256)
    @Column(name = "site")
    private String site;
    @Size(max = 256)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 256)
    @Column(name = "email")
    private String email;
    @Size(max = 2147483647)
    @Column(name = "act_description")
    private String actDescription;
    @Size(max = 256)
    @Column(name = "trade_mark")
    private String tradeMark;
    @JoinColumn(name = "city", referencedColumnName = "city_id")
    @ManyToOne
    private City city;
    @JoinColumn(name = "region", referencedColumnName = "region_id")
    @ManyToOne
    private Region region;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private Users userId;

    public Wholesaler() {
    }

    public Wholesaler(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActDescription() {
        return actDescription;
    }

    public void setActDescription(String actDescription) {
        this.actDescription = actDescription;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        if (!(object instanceof Wholesaler)) {
            return false;
        }
        Wholesaler other = (Wholesaler) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prod.model.Wholesaler[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Images> getImagesCollection() {
        return imagesCollection;
    }

    public void setImagesCollection(Collection<Images> imagesCollection) {
        this.imagesCollection = imagesCollection;
    }
    
}
