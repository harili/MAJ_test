/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.modeles;

/**
 *
 * @author chafy
 * 
 */
public class Pini {
//     ********************************************************
//          Modèle - encapsule la logique métier
//          donnant ainsi accès aux données
//     ********************************************************
    private int idIni; //attributs 
    private String codeIni;
    private String valeurIni;

    public Pini(int idIni, String codeIni, String valeurIni) { //constructeur paramétré qui initialise les attributs
        this.idIni = idIni;
        this.codeIni = codeIni;
        this.valeurIni = valeurIni;
    }

    
    //     ********************************************************
//          Accesseurs - Getters/Setters
//     ********************************************************
    public int getIdIni() {
        return idIni;
    }

    public void setIdIni(int idIni) {
        this.idIni = idIni;
    }

    public String getCodeIni() {
        return codeIni;
    }

    public void setCodeIni(String codeIni) {
        this.codeIni = codeIni;
    }

    public String getValeurIni() {
        return valeurIni;
    }

    public void setValeurIni(String valeurIni) {
        this.valeurIni = valeurIni;
    }
    
    
    
    
    
    
    
    
}
