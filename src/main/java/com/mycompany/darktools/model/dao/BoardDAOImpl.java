package com.mycompany.darktools.model.dao;

import com.mycompany.darktools.model.vo.Board;
import java.util.ArrayList;
import java.util.List;


public class BoardDAOImpl implements BoardDAO{
//    EntityManager manager;
    
    public BoardDAOImpl(){
        try {
            //manager = ConectionHibernate.getInstance();
        } catch (Exception e) {
            System.out.println("Erro no BoardDAOImpl "+e);
        }
       
    }   
    
    @Override
    public void save(Board board) {
//        manager.getTransaction().begin();
//        manager.persist(board);
//        manager.getTransaction().commit();
    }

    @Override
    public void update(Board board) {
//        manager.getTransaction().begin();
//        manager.merge(board);
//        manager.getTransaction().commit();
    }

    @Override
    public void delete(Board board) {
//        manager.getTransaction().begin();
//        manager.remove(board);
//        manager.getTransaction().commit();
    }
    
    public List<Board> listAll(){
        List<Board> boards = new ArrayList();
        
//        Query query = manager.createQuery("Select b FROM Board b");
//        boards = query.getResultList();
        
        return boards;
    }
    
}
