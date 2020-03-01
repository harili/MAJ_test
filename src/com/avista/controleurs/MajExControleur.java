/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.controleurs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.avista.dao.MajExDAO;
import com.avista.dao.PiniDAO;
import com.avista.vues.FScriptExecute;

/**
 *
 * @author chafy
 */
public class MajExControleur {
    
    //création d'objets (constructeurs, vues..)
    PiniDAO unPiniDAO = new PiniDAO(); 
    
    MajExDAO uneMajExDAO = new MajExDAO(); 
    FScriptExecute fenetScript = new FScriptExecute();
    
    
    /**
     * procédure qui lit le script sql voulu
     */
    
    public void controleScript(String chemin){
        
        BufferedReader br = null; //variabale lecture texte
        ArrayList<String> listRequete = new ArrayList<String>(); //création d'une liste
 
        try {
         String sCurrentLine; //ligne courante
         br = new BufferedReader(new FileReader(chemin)); //lecture du fichier
         String ligneFinale = ""; //dernière ligne lue
         
         while ((sCurrentLine = br.readLine()) != null) { //tant que la ligne courante n'est pas vide
            if(!sCurrentLine.startsWith("--") && !sCurrentLine.equals("GO") && !sCurrentLine.equals("/") 
                    && !sCurrentLine.equals("*")){ //ne pas prendre en compte ces caractères
                
                ligneFinale = ligneFinale.concat(sCurrentLine); //concaténation de la chaine vide avec la ligne courante
                if(sCurrentLine.contains(";")){ //s'il y a présence du ";"
                    
                    listRequete.add(ligneFinale); //ajouter celle - ci à la liste
                    ligneFinale = ""; //réinitialisation    
                }                 
            }          
         }
         
         if(!listRequete.isEmpty()){ //si la liste est vide
             fenetScript.setVisible(true); //affichage du form 
             String message = ""; // message

             for(String uneRequete : listRequete){ //parcours de la liste des requêtes 
                 
                 uneMajExDAO.executeRequete(uneRequete); //appel de la fonction DAO permettant l'exécution d'une requête 
                 
                 
                 
          
                 
             }
             message = "les requêtes ont bien été exécutées";
             fenetScript.getTxtScript().setText(message); //écriture du message
         }
         
         

        } catch (IOException e) {
         e.printStackTrace();
        } finally {
         try {
          if (br != null)br.close();
         } catch (IOException ex) {
          ex.printStackTrace();
         }
        }
    
    }
    
    
    /**
     * fonction qui retourne vrai si la version du logiciel est la plus récente
     */
    public boolean versionAjour(String chemin){
        BufferedReader br = null; //lecture de texte
       
        boolean res = false; //initialisation false
        try {
            String sCurrentLine; //ligne
            br = new BufferedReader(new FileReader(chemin)); //lecture du fichier
            

            while ((sCurrentLine = br.readLine()) != null) { // si la ligne courante n'est pas vide
          
                  
                   if(sCurrentLine.contains("v"+unPiniDAO.VersionActuelle()) || sCurrentLine.contains(unPiniDAO.VersionActuelle())){ //si la version présente dans la BDD est égale à celle présente dans le script exécuté

                       res = true; //retourne vrai

                   }   
                   
                   
                
        }
         
         

        } catch (IOException e) {
         e.printStackTrace();
        }finally{return res;}
    }
    


}
