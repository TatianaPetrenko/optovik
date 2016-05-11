/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.servicebeans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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
public class WhServBean implements Serializable {

    Wholesaler thisWholesaler;

    public Wholesaler getThisWholesaler() {
        return thisWholesaler;
    }

    public void setThisWholesaler(Wholesaler thisWholesaler) {
        this.thisWholesaler = thisWholesaler;
    }

     @PostConstruct
    public void init() {
        try {
            thisWholesaler = getByUsername();
        } catch (SQLException ex) {
            Logger.getLogger(WhServBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WhServBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(WhServBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(WhServBean.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    
    
    public Wholesaler getByUsername() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        WholesalerDaoImpl whdao = new WholesalerDaoImpl();
        Wholesaler n = whdao.getCurrentWh();
        return n;
    }

    public void updateWH() {
        WholesalerDaoImpl whdao = new WholesalerDaoImpl();
        whdao.updateWholesaler(thisWholesaler);

    }
}
