/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.dao;

import com.mycompany.darktools.model.vo.Board;
import com.mycompany.darktools.model.vo.Skill;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author acer
 */
public class BoardDAOImpl implements BoardDAO{
    EntityManager manager;
    
    public BoardDAOImpl(){
       manager = (EntityManager) ConectionHibernate.getInstance();
    }   
    
    @Override
    public void save(Board board) {
        manager.getTransaction().begin();
        manager.persist(board);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Board board) {
        manager.getTransaction().begin();
        manager.merge(board);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(Board board) {
        manager.getTransaction().begin();
        manager.remove(board);
        manager.getTransaction().commit();
    }
    
    public List<Board> listAll(){
        List<Board> boards;
        
        Query query = manager.createQuery("Select b FROM Board b");
        boards = query.getResultList();
        
        return boards;
    }
    
}
