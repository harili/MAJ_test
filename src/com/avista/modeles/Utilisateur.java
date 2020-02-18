/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.modeles;

/**
 *
 * @author chafyy
 */
public class Utilisateur {
    
//     ********************************************************
//             DTO d'utilisateur
//             Création du constructeur paramétré et des setters/getters
//     ********************************************************
    
    private String login;
    private String mdp;

    public Utilisateur(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    
    
}
