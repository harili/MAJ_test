/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author chafy
 */
public abstract class DAO {
    
//     ********************************************************
//              Attributs de connexion du type "protected"
//              permettant leur utilisation dans l'ensemble
//              du programme
//     ********************************************************
    
    protected Connection cnx = null; //variable de connexion
    protected PreparedStatement prepared = null; //variable qui permet de stocker la requête sql compilée, et ainsi être executée.
    protected ResultSet  resultat = null;//retourne la réponse d'une requête sous forme de table
    
    
    
}
