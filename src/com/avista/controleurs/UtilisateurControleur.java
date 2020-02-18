/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.controleurs;
import com.avista.modeles.Utilisateur;
import com.avista.dao.UtilisateurDAO;

/**
 *
 * @author chafy
 */
public class UtilisateurControleur {
    
    UtilisateurDAO unUtilisateurDAO = new UtilisateurDAO(); //création d'un objet UtilisateurDAO
    
//     ********************************************************
//              Fonction qui retourne le message de réussite
//              (ou non) de la connexion
//     ********************************************************
    public String authentifierUtilisateur(String login, String mdp){
        
        
        if(login == null || login.isEmpty()){ //Si le login est vide ou null
            return "Veuillez saisir votre login";
            
        }
        
        if(mdp == null || mdp.isEmpty()){ //si le mdp est dans le même cas
            return "Veuillez saisir votre mot de passe";
        }
        
        
        Utilisateur unUtilisateur = new Utilisateur(login,mdp); //Création d'un utilisateur avec mdp et 
        boolean res = unUtilisateurDAO.authentifierUtilisateur(unUtilisateur); //authentification de l'utilisateur en appelant celui - ci avec la méthode DAO
        
        if(res){ //si res est vrai
            return "Ok";
        }
        return "Login ou Mot de passe Incorrect";
        
        
    }
    
}
