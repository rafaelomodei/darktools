/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.dao;

import com.mycompany.darktools.model.vo.Personage;
import java.lang.reflect.Array;
import java.util.List;

/**
 *
 * @author acer
 */
public interface PersonageDAO {
    void save(Personage personagem);
    
    void saveAll(List Personages);
    
    void update(Personage personagem);
    
    void delete(Personage personagem);
    
    List<Personage> listAll();
}
