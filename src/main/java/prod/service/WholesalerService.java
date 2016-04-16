/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import prod.dao.WholesalerDao;
import prod.model.Wholesaler;

/**
 *
 * @author Tatiana
 */
@ManagedBean
@SessionScoped
public class WholesalerService {
    Wholesaler wholesaler;

    public Wholesaler getWholesaler() {
        return wholesaler;
    }

    public void setWholesaler(Wholesaler wholesaler) {
        this.wholesaler = wholesaler;
    }
    
    public Wholesaler getWByUname() {
    
    WholesalerDao wholesalerdao = new WholesalerDao();
    Wholesaler w = wholesalerdao.getWholesalerByUserId();
    return w;
    }
    
}
