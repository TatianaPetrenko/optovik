/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import prod.model.Roles;
import prod.model.UserModel;
import prod.model.Users;

/**
 *
 * @author Altarix
 */
@Named
@Transactional("transactionManager")
public class UserDAOImpl {

    private SessionFactory sessionFactory;

    public void addUser(UserModel model) {
     Users user = new Users();
        user.setUsername(model.getLogin());
        user.setPassword(model.getPwd());
        user.setEnabled(true);
        Roles role = (Roles) sessionFactory.getCurrentSession()
                .createQuery("from Role where code='ROLE_USER'").uniqueResult();
        if (role == null) {
            role = new Roles();
            role.setCode("ROLE_USER");
            role.setLabel("ROLE FOR SIMPLE ACCESS");
            sessionFactory.getCurrentSession().save(role);
        }
        Set<Roles> roles = new HashSet<Roles>();
        roles.add(role);
        user.setRolesCollection(roles);
        sessionFactory.getCurrentSession().save(user);
        
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
