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
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import prod.model.Product;
import prod.model.Vacancy;
import prod.model.VolumeClassif;
import prod.model.Wholesaler;
import prod.service.HibernateUtil;
import prod.servicebeans.PrServBean;
import prod.servicebeans.VacServBean;

/**
 *
 * @author Altarix
 */
public class ProductDaoImpl {
    Session session = HibernateUtil.getSession();
    
     public void newProd(PrServBean n) {
       
        Product vac = n.getProd();
       
        Transaction tx = session.beginTransaction();
        session.save(vac);

        tx.commit();
    }

    public List<Product> getWhProd() {
        WholesalerDaoImpl whdao = new WholesalerDaoImpl();
        Wholesaler wh = whdao.getCurrentWh();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Product.class);
        List<Product> vacs = (List<Product>) criteria.add(Restrictions.eq("whId", wh)).list();
        tx.commit();
        return vacs;

    }

    public Product getProdByID(int id) {

        Product vac = null;
        Transaction tx = session.beginTransaction();
        vac = (Product) session.get(Product.class, id);
        tx.commit();
        return vac;

    }
    
    public List<VolumeClassif> getVols() {
      
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(VolumeClassif.class).setProjection(Projections.property("name"));
        List<VolumeClassif> vols = (List<VolumeClassif>) criteria.list();
        tx.commit();
        return vols;

    }
    
}
