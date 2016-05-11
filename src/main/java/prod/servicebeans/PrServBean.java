/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.servicebeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import prod.dao.ProductDaoImpl;
import prod.dao.VacancyDaoImpl;
import prod.model.Product;
import prod.model.Vacancy;
import prod.model.VolumeClassif;
import prod.model.Wholesaler;

/**
 *
 * @author Altarix
 */
@ManagedBean
@SessionScoped
public class PrServBean implements Serializable {

    private Wholesaler whId;
    private Product prod = new Product();

    public Wholesaler getWhId() {
        return whId;
    }

    public void setWhId(Wholesaler whId) {
        this.whId = whId;
    }

    public Product getProd() {
        return prod;
    }

    public void setProd(Product prod) {
        this.prod = prod;
    }

    public void saveProd() {
        ProductDaoImpl proddao = new ProductDaoImpl();
        proddao.newProd(this);

    }

    public List<Product> getProds() {
        ProductDaoImpl proddao = new ProductDaoImpl();
        return proddao.getWhProd();
    }

    public Product getProdById(int id) {
        ProductDaoImpl proddao = new ProductDaoImpl();
        return proddao.getProdByID(id);
    }

    public List<VolumeClassif> getVols() {
        ProductDaoImpl proddao = new ProductDaoImpl();
        List<VolumeClassif> vols = proddao.getVols();
        return vols;
    }

}
