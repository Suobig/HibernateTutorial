/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.feib.popov.HibernateTutorial;

import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author popov
 */
public class Util {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        try {
            Configuration config = new Configuration();
            ConnectionDialog d = new ConnectionDialog();
            d.setVisible(true);
            if(!d.isCanceled()) {
                config.setProperty("hibernate.connection.password", d.getPassword());
                return config.configure().buildSessionFactory();
            } else {
                throw new HibernateException("Password not entered");
            }
        } catch (HibernateException e) {
            System.err.println("Initial SessionFactory creation failed. " + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
