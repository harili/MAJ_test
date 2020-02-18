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

    final static Logger logger = LogManager.getLogger(MajExDAO.class);    
    @Override
    public void executeScript(ArrayList<String> listRequete){
        cnx = DBConnexion.ConnectDB(); //connexion bdd
        
    	try {
	    	for(String uneRequete : listRequete){
                    
                    
                        
                        logger.debug("Début d'exécution de la requête : " + uneRequete );
			prepared = cnx.prepareStatement(uneRequete);
			prepared.executeUpdate();
                        
                        logger.debug("Fin d'exécution de la requête");
                }
	} catch (SQLException e) {
                
		logger.error(e);
	}
    
    
    }
    
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
