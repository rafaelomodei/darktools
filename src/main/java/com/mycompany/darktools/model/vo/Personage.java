/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.vo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author acer
 */
@Entity
@Table (name = "Personage")
public class Personage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Transient
    private String NPCid;
    
    @Column(name = "isalive")
    boolean isAlive;
    
    @Column(name = "isactivetobattle")
    boolean isActiveToBattle;
    
    @Transient
    float life;
    
    @Transient
    float maxlife;
    
    @Column(name = "name", nullable = false)
    String name;
    
    @ManyToMany
    List<Skill> skills;

    @Transient
    String pathImageFace;
    
    @Transient
    String pathImageBody;
    
    /**
     * Contrutor do Personage para o usuário
     * @param name Nome do perosnagem
     * @param maxlife Vida máxima do jogador
     * @param skills Lista de habilidades
     * @param pathImageFace Caminho onde se encontra a imagem de rosto
     * @param pathImageBody Caminho onde se econtra a imagem de corpo
     */
    public Personage(String name, float maxlife,List skills, String pathImageFace, String pathImageBody) {
        this.name = name;
        this.skills = skills;
        this.pathImageFace = pathImageFace;
        this.pathImageBody = pathImageBody;
        this.maxlife = maxlife;
        this.life = this.maxlife;
        this.isAlive = true;
        this.isActiveToBattle = true;
    }

    /**
     * Contrutos para NPC (Personagens não jogáveis)
     * @param NPCid Id do NPC
     * @param name Nome
     * @param skills Lista de Skill, com as habilidades
     * @param pathImageBody Caminho onde se encontra a imagem de corpo do personagem
     * @param pathImageFace Caminho onde se encontra a imagem de rosto do personagem
     */
    public Personage(String NPCid ,String name, float life, List skills, String pathImageFace, String pathImageBody){
        this.NPCid = NPCid;
        this.name = name;
        this.life = life;
        this.maxlife = life;
        this.isAlive = true;
        this.isActiveToBattle = true;
        this.skills = skills;
        this.pathImageFace = pathImageFace;
        this.pathImageBody = pathImageBody;
    }
    
    
    public float getLife() {
        return life;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public String getPathImageFace() {
        return pathImageFace;
    }

    public String getPathImageBody() {
        return pathImageBody;
    }

    public String getNPCid() {
        return NPCid;
    }

    public void setNPCid(String NPCid) {
        this.NPCid = NPCid;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isIsActiveToBattle() {
        return isActiveToBattle;
    }

    public void setIsActiveToBattle(boolean isActiveToBattle) {
        this.isActiveToBattle = isActiveToBattle;
    }

    public float getMaxlife() {
        return maxlife;
    }
    
    
}
