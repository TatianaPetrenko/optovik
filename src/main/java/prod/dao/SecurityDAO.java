/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.dao;

import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import prod.model.Roles;
import prod.model.UserModel;
import prod.model.Users;

/**
 *
 * @author Tatyana
 */
@Named
@Transactional
public class SecurityDAO {

    @Inject
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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
    
    
}
