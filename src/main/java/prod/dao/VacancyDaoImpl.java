/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.dao;

import org.hibernate.Session;
import prod.service.HibernateUtil;

/**
 *
 * @author Tatiana
 */
public class VacancyDaoImpl {
     Session session = HibernateUtil.getSessionFactory().getCurrentSession();
     
     
     
}
