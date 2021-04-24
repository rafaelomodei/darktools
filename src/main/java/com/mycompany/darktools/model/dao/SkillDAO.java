/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.dao;

import com.mycompany.darktools.model.vo.Skill;
import java.util.List;

/**
 *
 * @author acer
 */
public interface SkillDAO {
    void save(Skill skill);
    
    void update(Skill skill);
    
    void delete(Skill skill);
    
    void saveAll(List Skills);
    
    List<Skill> listAll();
    
}
