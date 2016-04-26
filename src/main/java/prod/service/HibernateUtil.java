/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Altarix
 */
public class HibernateUtil 
{
   private static SessionFactory sessionFactory = buildSessionFactory();
   
 public static Session getSession() throws HibernateException {         
   Session sess = null;       
   try {         
       sess = sessionFactory.getCurrentSession();  
   } catch (org.hibernate.HibernateException he) {  
       sess = sessionFactory.openSession();     
   }             
   return sess;
} 
 
   private static SessionFactory buildSessionFactory()
   {
      try
      {
         if (sessionFactory == null)
         {
           Configuration configuration = new Configuration().configure();
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
    	                              .applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
        configuration.setProperty("hibernate.temp.use_jdbc_metadata_defaults","false");
         }
         return sessionFactory;
      } catch (Throwable ex)
      {
         System.err.println("Initial SessionFactory creation failed." + ex);
         throw new ExceptionInInitializerError(ex);
      }
   }
 
   public static SessionFactory getSessionFactory()
   {
      return sessionFactory;
   }
 
   public static void shutdown()
   {
      getSessionFactory().close();
   }
}