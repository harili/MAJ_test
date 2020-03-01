/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.dao;
import java.io.File;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.io.IOException;

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
 
    private static String typeConnexion;
    private static String nomBDD;
    private ArrayList<String> listExport;
    Cryptage crypt = new Cryptage();
    final static Logger logger = LogManager.getLogger(DBConnexion.class); //Logger qui recense les événements   
    public static Connection ConnectDB(){
        try {
            // ouverture d’un document XML sous DOM
            File fichier;
            String root="";
            for (File lment : File.listRoots()) {
                fichier = new File(lment + "\\XFiles\\Conf\\init.xml");
                if (fichier.exists()) {
                    root=lment+"\\XFiles\\Conf\\init.xml";
                    
                }
            }
            File fXmlFile = new File(root);
            
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            // no use DTD validation
            dbFactory.setValidating(false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            
            NodeList nList;
            // get all nodes person
            nList = doc.getElementsByTagName("Resource");
            // treat each node
            String driver = "";
            String url = "";
            String username = "";
            String password = "";
            String mdpDecrypte;
            
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    typeConnexion = eElement.getAttribute("typeConn").trim();
                    nomBDD = eElement.getAttribute("nomBDD").trim();
                    username = eElement.getAttribute("username").trim();
                    password = eElement.getAttribute("password").trim();                   
                    driver = eElement.getAttribute("driverClassName").trim();
                    url = eElement.getAttribute("url").trim();
                }
            }
            Cryptage cipherUtil = new Cryptage();
            mdpDecrypte = cipherUtil.decrypt(password);
           
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url+";user="+username+";password="+mdpDecrypte);
            return conn;
            
        } catch (ParserConfigurationException | ClassNotFoundException | SAXException | IOException ex) {
            logger.error(ex);
        } catch (SQLException ex) {
            logger.error(ex);
            //Boîte du message d'erreur
            JOptionPane.showMessageDialog(null, "Accès impossible à la base de données. Vérifiez les informations saisies.", "Message d'erreur Connexion BDD", JOptionPane.ERROR_MESSAGE);
        }finally{return conn;}
    }

    public String getNomBDD(){
        return nomBDD;
    }
//    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //méthode qui retourne la classe de l'objet assoccié au string
//        if(conn==null){ //si la connexion est null
//            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=exfiles;integratedSecurity=true;","LAPTOP-O6TEJHR5\\chafy",""); //récupérer les informations de la connexion (serveur, BDD...)
//        }
//        
//        return conn; //retourne la connexion
//        }catch(Exception e){ //s'il y a une erreur
//            JOptionPane.showMessageDialog(null,e);
//            return null;
//        }
    
}
