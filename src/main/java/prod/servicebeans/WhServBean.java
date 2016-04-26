/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.servicebeans;

import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import prod.dao.WholesalerDaoImpl;
import prod.model.Wholesaler;

/**
 *
 * @author Altarix
 */
@ManagedBean
@SessionScoped
public class WhServBean implements Serializable{

    Wholesaler thisWholesaler;

    public Wholesaler getThisWholesaler() {
        return thisWholesaler;
    }

    public void setThisWholesaler(Wholesaler thisWholesaler) {
        this.thisWholesaler = thisWholesaler;
    }

   
    
    public String getByUsername() throws  SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        WholesalerDaoImpl whdao = new WholesalerDaoImpl();
        Wholesaler n = whdao.getName();
        setThisWholesaler(n);
        return n.getName();
    }
    
   public void updateWH() {
     WholesalerDaoImpl whdao = new WholesalerDaoImpl();
     whdao.updateWholesaler(thisWholesaler);
   
   }
}
