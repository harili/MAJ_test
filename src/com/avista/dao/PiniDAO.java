/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.dao;

import java.sql.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 *
 * @author chafy
 */
public class PiniDAO extends DAO implements IPiniDAO {
    final static Logger logger = LogManager.getLogger(PiniDAO.class);
    //     ********************************************************
//              DAO d'utilisateur permettant un accès à la BDD
//     ********************************************************

    /**
     *
     * @return
     */
    
    @Override
    public String VersionActuelle(){ //fonction qui retourne la version
        String res="";
        String sql = "select valeurIni from dbo.p_ini where codeIni = 'version'"; //requete
        
        cnx = DBConnexion.ConnectDB(); //connexion à la bdd
        
         
         try{
         prepared = cnx.prepareStatement(sql); //instruction paramétrée avec une reuqête SQL déjà compilée
         resultat = prepared.executeQuery(); //execute l'instruction sql et retourne un objet
         resultat.next(); //renvoie la chaine suivante jusqu'à rencontrer une espace
         res=resultat.getString(1); //Récupère la valeur du nom (ou numéro) de la colonne dans la ligne
         resultat.close(); //fermeture de l'instruction executée
         logger.debug("Réussite de l'exécution des requêtes");
         
         }
         catch(SQLException e){
             logger.error(e);
         }finally{return res;}
    
    
    
    }

    
    
}
