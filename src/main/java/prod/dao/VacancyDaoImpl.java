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
import prod.model.Roles;
import prod.model.UserModel;
import prod.model.Users;
import prod.model.Vacancy;
import prod.model.Wholesaler;
import prod.service.HibernateUtil;
import prod.servicebeans.VacServBean;

/**
 *
 * @author Tatiana
 */
public class VacancyDaoImpl {

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public void newVac(VacServBean n) {
        WholesalerDaoImpl whdao = new WholesalerDaoImpl();
        Vacancy vac = n.getVac();
       
        Transaction tx = session.beginTransaction();
        session.save(vac);

        tx.commit();
    }

    public List<Vacancy> getWhVac() {
        WholesalerDaoImpl whdao = new WholesalerDaoImpl();
        Wholesaler wh = whdao.getName();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Vacancy.class);
        List<Vacancy> vacs = (List<Vacancy>) criteria.add(Restrictions.eq("whId", wh)).list();
        tx.commit();
        return vacs;

    }

    public Vacancy getVacByID(int id) {

        Vacancy vac = null;
        Transaction tx = session.beginTransaction();
        vac = (Vacancy) session.get(Vacancy.class, id);
        tx.commit();
        return vac;

    }
}
