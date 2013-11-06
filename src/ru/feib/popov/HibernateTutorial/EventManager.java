/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.feib.popov.HibernateTutorial;

import java.sql.SQLException;
import org.hibernate.Session;
import java.util.*;

/**
 *
 * @author popov
 */
public class EventManager {
    public static void main(String[] args) {
        EventManager mgr = new EventManager();
        mgr.createAndStoreEvent("Test Title1", new Date());
    }
    
    public void createAndStoreEvent(String title, Date date) {
        try {
            Session session = Util.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Event event = new Event();
            event.setTitle(title);
            event.setDate(date);
            session.save(event);

            session.getTransaction().commit();
        } catch(Exception e) {
            
        }
    }
    
    public void createAndStorePerson(
            int age, String firstName, String lastName) {
        Session session = Util.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Person p = new Person();
        p.setAge(age);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        session.save(p);
        
        session.getTransaction().commit();
    }
    
    public void addPersonToEvent(long personId, long eventId) {
        Session session = Util.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Person person = (Person)session
                .createQuery("SELECT p FROM Person p "
                +   "LEFT JOIN FETCH p.events "
                +             "WHERE p.id = :pid")
                .setParameter("pid", personId)
                .uniqueResult();
        Event event = (Event)session.load(Event.class, eventId);
        
        session.getTransaction().commit();
        
       person.getEvents().add(event);
       
       Session session2 = Util.getSessionFactory().getCurrentSession();
       session2.beginTransaction();
       session2.update(person);
       
       session2.getTransaction().commit();
    }
}
