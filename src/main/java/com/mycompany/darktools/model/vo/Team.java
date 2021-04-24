/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.vo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "Team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @OneToMany
    @JoinTable(name = "PERSONAGE_LIST",
            joinColumns=@JoinColumn(name = "TEAM_ID"),
            inverseJoinColumns=@JoinColumn(name = "PERSONAGE_ID"))
    List<Personage> personages;
   
    @Column(name = "money", nullable = false)
    Double money;

    public Team(){
        
    }
    
    public Team(List personages, Double money) {
        this.personages = personages;
        this.money = money;
    }
    
    public List<Personage> getPersonages() {
        return personages;
    }

    public void setPersonages(List<Personage> personages) {
        this.personages = personages;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    
    
    
}
