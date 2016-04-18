/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.service;
 
import javax.inject.Inject;
import javax.inject.Named;
import prod.dao.UserDAOImpl;
import prod.model.UserModel;
 

/**
 *
 * @author Tatiana
 */
@Named
public class UserManager {
    
  @Inject
    public UserDAOImpl userDAO;
 
    public void setUserDAO(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }
 
    public void addUser(UserModel model) {
        userDAO.addUser(model);
    }
 
}
