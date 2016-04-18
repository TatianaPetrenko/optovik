/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.servicebeans;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import prod.dao.WholesalerDaoImpl;
import prod.model.Wholesaler;

/**
 *
 * @author Altarix
 */
@ManagedBean
@SessionScoped
public class WhServBean {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getByUsername() throws  SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    
        WholesalerDaoImpl whdao = new WholesalerDaoImpl();
        String n = whdao.getName().getName();
 
        return n;
    }
    
}
