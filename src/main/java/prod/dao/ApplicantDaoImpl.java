/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import prod.model.Applicant;
import prod.model.Roles;
import prod.model.UserModel;
import prod.model.Users;
import prod.model.Wholesaler;
import prod.service.HibernateUtil;

/**
 *
 * @author Altarix
 */
public class ApplicantDaoImpl {

    Session session = HibernateUtil.getSession();

    public Applicant getCurrentAppl(int id) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Users.class);
        List<Users> u = (List<Users>) criteria.add(Restrictions.eq("username", name)).list();

        Criteria criteriaw = session.createCriteria(Wholesaler.class);
        Applicant n = (Applicant) criteriaw.add(Restrictions.eq("userId.id", u.get(0).getId()))
                .uniqueResult();
        tx.commit();
        return n;

    }
    
    
      public void newAppl(UserModel n) {
        Applicant appl = n.getAppl();
        Users u = new Users();
        u.setUsername(n.getLogin());
        u.setPassword(n.getPwd());
        u.setEnabled(Boolean.TRUE);
        Transaction tx = session.beginTransaction();
        session.save(u);

        Roles r = new Roles("ROLE_APPLICANT", "Соискатель");
        r.setUserId(u);

        session.save(r);
 
        appl.setUserId(u);

        session.save(appl);
        tx.commit();
    }

    public void updateApplicant(Applicant a) {
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(a);
        tx.commit();
    }
    
   
    

}
