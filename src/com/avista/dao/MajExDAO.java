/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.dao;

import java.util.ArrayList;
import java.sql.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 *
 * @author chafy
 */


public class MajExDAO extends DAO implements IMajExDAO {

    final static Logger logger = LogManager.getLogger(MajExDAO.class); //Logger qui recense les événements   
    @Override
    
//     ********************************************************
//              Procédure qui execute le script .sql passé en paramètres
//     ********************************************************
    public void executeScript(ArrayList<String> listRequete){ 
        cnx = DBConnexion.ConnectDB(); //connexion bdd
        
    	try {
	    	for(String uneRequete : listRequete){ //parcours les lignes du script

                        logger.debug("Début d'exécution de la requête : " + uneRequete ); // Suivi de la requête
			prepared = cnx.prepareStatement(uneRequete); // exécute la reuqête
			prepared.executeUpdate(); //met à jour la BDD
                        
                        logger.debug("Fin d'exécution de la requête");
                }
	} catch (SQLException e) {
                
		logger.error(e);//s'il y a une erreur
	}
    
    
    }
    
        //     ********************************************************
//              Procédure qui exécute une requête sql
//     ********************************************************
    
    public void executeRequete(String uneRequete){
        cnx = DBConnexion.ConnectDB(); //connexion bdd
        
    	try {
	    	
                    
                  
                        logger.debug("Début d'exécution de la requête : " + uneRequete );
			prepared = cnx.prepareStatement(uneRequete);
			prepared.executeUpdate();
                        
                        logger.debug("Fin d'exécution de la requête");
                
	} catch (SQLException e) {
                
		logger.error(e);
	}
    
    
    }
    
}
