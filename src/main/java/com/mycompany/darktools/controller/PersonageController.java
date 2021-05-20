/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller;
import com.mycompany.darktools.model.vo.Personage;
import com.mycompany.darktools.utils.JsonTratament;
import static com.mycompany.darktools.utils.JsonTratament.readAllArraysInArchiveJSON;
import static com.mycompany.darktools.utils.JsonTratament.readScriptSegments;
import java.util.List;

/**
 *
 * @author acer
 */
public class PersonageController {
    List<Personage> personages;
    
    public PersonageController(){
        personages = JsonTratament.createAllNPCs(readAllArraysInArchiveJSON("characters.json"));
    }
}
