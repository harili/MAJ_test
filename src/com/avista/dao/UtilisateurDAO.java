/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.dao;
import com.avista.modeles.Utilisateur;
import java.sql.SQLException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author chafy
 */
public class UtilisateurDAO extends DAO implements IUtilisateurDAO{
 final static Logger logger = LogManager.getLogger(UtilisateurDAO.class);
    @Override //La surcharge utilisée dans le cas d'un héritage (ici DAO).
              //Le compilateur vérifie que la méthode est correctement utilisé.
    
    
    
    
//     ********************************************************
//          Fonction qui renvoie true si elle trouve le login et le mdp correcte. 
//          False dans le cas contraire
//     ********************************************************
    public boolean authentifierUtilisateur(Utilisateur unUtilisateur){
        
        boolean res = false; //initialisation de la variable à false
        String sql = "select nomUtilisateur, mdpUtilisateur from dbo.p_utilisateur where nomUtilisateur=? and mdpUtilisateur=?"; //requête préparée pour le login
        try{
            cnx = DBConnexion.ConnectDB(); //connexion bdd
            prepared = cnx.prepareStatement(sql); //instruction paramétrée avec une reuqête SQL déjà compilée
            prepared.setString(1,unUtilisateur.getLogin()); //définit le paramètre selon le string donné 
            
            
            prepared.setString(2,unUtilisateur.getMdp()); //définit le paramètre selon le string donné 

            resultat = prepared.executeQuery(); //exécute la requête
            
            if(resultat.next()){ //renvoie la chaine suivante jusqu'à rencontrer une espace
                res = true; // res est vrai si le login && mdp saisis sont bien dans la bdd (requête précédente)
                logger.debug("Réussite de la connexion de l'utilisateur");
            }
            return res; //retourner le boolean
            
        }catch(SQLException e){logger.error(e);}
         finally{return res;}
    
    }
}
    
    
    

