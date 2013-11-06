/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.feib.popov.HibernateTutorial;
import java.util.*;
/**
 *
 * @author popov
 */
public class Event {
    private long id;
    private Set participants = new HashSet();
    
    private String title;
    private Date date;
    
    public Event() {}
    
    public Long getId() { return id; }
    private void setId(Long id) { this.id = id; }
    
    public Set getParticipants() { return participants; }
    public void  setParticipants(Set participants) { this.participants = participants; }
    
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
