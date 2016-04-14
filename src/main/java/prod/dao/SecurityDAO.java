/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.dao;

import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import prod.model.Users;

/**
 *
 * @author Tatyana
 */

@Transactional
public class SecurityDAO {

    SessionFactory sessions = new Configuration().configure().buildSessionFactory();

    public Users thyPass(String uname) {

        Query query = sessions.getCurrentSession().createQuery("FROM Users where username= :uname");
        if (query.list().get(0) != null) {
            return (Users) query.list().get(0);

        } else {
            return null;
        }
    }

}
