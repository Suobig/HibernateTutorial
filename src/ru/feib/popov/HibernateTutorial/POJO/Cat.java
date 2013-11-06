/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.feib.popov.HibernateTutorial.POJO;

import java.awt.Color;
import java.util.*;

public class Cat {
    private long id;
    
    private Date birthDate;
    private Color color;
    private char sex;
    private float weight;
    private int litterId;
    
    private Cat mother;
    private Set kittens = new HashSet();
    
    private void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
    
    public void setBirthDate(Date date) { this.birthDate = date; }
    public Date getBirthDate() { return birthDate; }
    
    public void setWeight(float weight) { this.weight = weight; }
    public float getWeight() { return weight; }
    
    public void setColor(Color color) { this.color = color; }
    public Color getColor() { return color; }
    
    public void setSex(char sex) { this.sex = sex; }
    public char getSex() { return sex; }
    
    public void setLitterId(int litterId) { this.litterId = litterId; }
    public int getLitterId() { return litterId; }
    
    public void setMother(Cat mother) { this.mother = mother; }
    public Cat getMother() { return mother; }
    
    public void setKittens(Set kittens) { this.kittens = kittens; }
    public Set getKittens() { return kittens; }
    
    public void addKitten(Cat kitten) {
        kitten.setMother(this);
        kitten.setLitterId(kittens.size());
        kittens.add(kitten);
    }    
    
}
