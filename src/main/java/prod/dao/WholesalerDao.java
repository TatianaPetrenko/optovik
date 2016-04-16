/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.dao;

import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import prod.model.Users;
import prod.model.Wholesaler;

/**
 *
 * @author Tatiana
 */
public class WholesalerDao {
     @Inject
    private SessionFactory sessionFactory;
     
    public Wholesaler getWholesalerByUserId() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String name = auth.getName(); //get logged in username
    Users us = (Users) sessionFactory.getCurrentSession().createQuery("from users where username= :name").uniqueResult();
    int userid = us.getId();
    Wholesaler info = (Wholesaler) sessionFactory.getCurrentSession().createQuery("from wholesaler where user_id= :userid").uniqueResult();;
    return info;
    }
}
