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

/**
 *
 * @author acer
 */
public class BoardBR {
    private BoardDAO boardDao;
    
    public BoardBR(){
        try {
            boardDao = new BoardDAOImpl();
        } catch (Exception e) {
            System.out.println("Problema no BoardBR "+e);
        }
        
    }
    
    public void Save(Board board){
        try {
            boardDao.save(board);
        } catch (Exception he) {
            System.out.println("Erro in to save Board class :"+he);
        }
    }
    
    public void Upgrade(Board board){
        try {
            boardDao.update(board);
        } catch (Exception he) {
            System.out.println("Erro in to upgrade Board class :"+he);
        }
    }
    
    public void Delete(Board board){
        try {
            boardDao.delete(board);
        } catch (Exception he) {
            System.out.println("Erro in to delete Board class :"+he);
        }
    }
    
    public List<Board> ListAll(){
        return boardDao.listAll();
    }
}
