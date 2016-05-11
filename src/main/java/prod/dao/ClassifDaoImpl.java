/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import prod.model.City;
import prod.model.Region;

import prod.service.HibernateUtil;

/**
 *
 * @author Altarix
 */
public class ClassifDaoImpl {

    Session session = HibernateUtil.getSession();

    public List<City> getPlacesList() {
        Transaction tx = session.beginTransaction();
        List<City> places = (List<City>) session.createCriteria(City.class).list();
        tx.commit();
        return places;
    }
    
     public List<Region> getRegionList() {
        Transaction tx = session.beginTransaction();
        List<Region> reg = (List<Region>) session.createCriteria(Region.class).list();
        tx.commit();
        return reg;
    }

}
