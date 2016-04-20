/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import prod.model.Roles;
import prod.model.UserModel;
import prod.model.Users;
import prod.model.Wholesaler;
import prod.service.HibernateUtil;

/**
 *
 * @author Altarix
 */
public class WholesalerDaoImpl {

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public Wholesaler getName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

//        String hql = "from Users where username="+name;
//     Query query = session.createQuery(hql);
//     //query.setParameter("groupId", groupId);
//     List<Users> u = query.list();
        Criteria criteria = session.createCriteria(Users.class);
        List<Users> u = (List<Users>) criteria.add(Restrictions.eq("username", name)).list();

        Criteria criteriaw = session.createCriteria(Wholesaler.class);
        Wholesaler n = (Wholesaler) criteriaw.add(Restrictions.eq("userId.id", u.get(0).getId()))
                .uniqueResult();
        return n;
    }

    public void newWH(UserModel n) {
        Wholesaler wh = new Wholesaler();
        Users u = new Users();
        u.setUsername(n.getLogin());
        u.setPassword(n.getPwd());
        u.setEnabled(Boolean.TRUE);
        Transaction tx = session.beginTransaction();
        session.save(u);

        Roles r = new Roles("ROLE_WHOLESALER", "Оптовик");
        r.setUserId(u);

        session.save(r);

        wh.setName(n.getName());
        wh.setEmail(n.getEmail());
        wh.setSite(n.getSite());
        wh.setUserId(u);

        session.save(wh);
        tx.commit();
    }

    public void updateWholesaler(Wholesaler w) {
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(w);
        tx.commit();
    }
}
