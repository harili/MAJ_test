/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.dao;
import java.sql.*;
import javax.swing.*;


/**
 *
 * @author chafy
 */
public class DBConnexion {
    
//     ********************************************************
//              Classe d'initialisation de la connexion
//              à la BDD.
//              Utilisation d'un singleton permettant la réduction
//              l'instanciation d'une classe à un seul objet.
//     ********************************************************
    
    static private Connection conn = null; //objet permettant la connexion à la BDD
    
    public static Connection ConnectDB(){
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //méthode qui retourne la classe de l'objet assoccié au string
        if(conn==null){ //si la connexion est null
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=exfiles;integratedSecurity=true;","LAPTOP-O6TEJHR5\\chafy",""); //récupérer les informations de la connexion (serveur, BDD...)
        }
        
        return conn; //retourne la connexion
        }catch(Exception e){ //s'il y a une erreur
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
    
}
