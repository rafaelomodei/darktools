/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.dao;

import com.mycompany.darktools.model.vo.Board;
import java.util.List;

/**
 *
 * @author acer
 */
public interface BoardDAO {
    void save(Board board);
    
    void update(Board board);
    
    void delete(Board board);
    
    List<Board> listAll();
}
