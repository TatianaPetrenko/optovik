/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import prod.model.Images;
import prod.model.Product;
import prod.service.HibernateUtil;
import prod.servicebeans.ImgServBean;

/**
 *
 * @author Altarix
 */
public class ImageDaoImpl {

    Session session = HibernateUtil.getSession();

    public void saveImage(Images img) {

        Transaction tx = session.beginTransaction();
        session.save(img);

        tx.commit();

    }

}
