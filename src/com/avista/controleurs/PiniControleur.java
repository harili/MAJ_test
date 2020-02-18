/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.controleurs;
import com.avista.dao.PiniDAO;

/**
 *
 * @author chafy
 * controleur : Gestion de la dynamique de l'application (lien utilisateur -  reste de l'application)
 */


public class PiniControleur {
    
    PiniDAO unPiniDAO = new PiniDAO(); //Instancier l'objet 
    
    public String VersionActuelle(){ //Fonction qui retourne la valeur de
        String res;      //Déclaration d'une variable
        res = unPiniDAO.VersionActuelle(); //récupération grâce au DAO de la variable
        return res; //retourner
    
    }
    
}
