/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.dao;

import java.sql.CallableStatement;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/**
 *
 * @author chafy
 */
public class ScriptExfilesDAO extends DAO implements IScriptExfilesDAO {
    final static Logger logger = LogManager.getLogger(ScriptExfilesDAO.class);
    @Override
    public void saveExfilesBDD(){
    
        String sql = "exec p1"; //string de la requête d'exécution de la procédure présente dans sql server
        cnx = DBConnexion.ConnectDB(); //connexion à la bdd
        
        try{
        CallableStatement cs = cnx.prepareCall(sql); //permet de faire appel à la procédure stockée
        cs.executeUpdate(); //exécute l'instruction sql fournie (reuqête sql qui impacte sur bdd)
        logger.debug("Réussite de la sauvegarde");
        
        
        
        }catch(Exception e){
            logger.error(e);
          
        }

}
    
}
