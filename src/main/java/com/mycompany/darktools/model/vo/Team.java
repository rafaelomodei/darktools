/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.vo;

import java.util.List;

public class Team {
    
    private Long id;
    
    List<Personage> personages;
   
    Double money;

    public Team() {
    }
    
    public Team(List<Personage> personages, Double money) {
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
