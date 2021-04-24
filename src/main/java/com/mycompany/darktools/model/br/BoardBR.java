/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.br;

import com.mycompany.darktools.model.dao.BoardDAO;
import com.mycompany.darktools.model.dao.BoardDAOImpl;
import com.mycompany.darktools.model.vo.Board;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author acer
 */
public class BoardBR {
    private BoardDAO boardDao;
    
    public BoardBR(){
        boardDao = new BoardDAOImpl();
    }
    
    public void Save(Board board){
        try {
            boardDao.save(board);
        } catch (HibernateException he) {
            System.out.println("Erro in to save Skill class :"+he);
        }
    }
    
    public void Upgrade(Board board){
        try {
            boardDao.update(board);
        } catch (HibernateException he) {
            System.out.println("Erro in to upgrade Skill class :"+he);
        }
    }
    
    public void Delete(Board board){
        try {
            boardDao.delete(board);
        } catch (HibernateException he) {
            System.out.println("Erro in to delete Skill class :"+he);
        }
    }
    
    public List<Board> ListAll(){
        try {
            return boardDao.listAll();
        } catch (HibernateException he){
            System.out.println("Erro in show board list :"+he);
            return null;
        }
    }
}
