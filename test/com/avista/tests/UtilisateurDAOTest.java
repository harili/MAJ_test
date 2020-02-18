package com.avista.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.avista.dao.UtilisateurDAO;
import com.avista.modeles.Utilisateur;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

 /**
     * Classe de test unitaire
     */
public class UtilisateurDAOTest {
    
    public UtilisateurDAOTest() {
    }
    
     private Utilisateur unUtilisateur;
    private UtilisateurDAO unUtilisateurDAO;
    
    @Before
    public void init(){
        unUtilisateur = new Utilisateur("ili1","ili2");
        unUtilisateurDAO = new UtilisateurDAO();
    }
    
    public void UtilisateurDAONotNull(){
    
        assertNotNull("L'utilisateurDAO n'existe pas",unUtilisateurDAO);
        
    }
    
    public void UtilisateurNotNull(){
    
        assertNotNull("L'utilisateur n'existe pas",unUtilisateur);
        
    }
    
    @Test
    public void authentifierUtilisateurTest(){ //test de l'authentification si celui - ci est vrai
        
       
        assertTrue("L'authentification de l'utilisateur a bien marché",unUtilisateurDAO.authentifierUtilisateur(unUtilisateur));
        
    
    }
    @Test
    public void setLoginTest(){ //test des setters/getters
        
        unUtilisateur.setLogin("undeux");
        assertTrue("Le getter du login ne marche pas",unUtilisateur.getLogin().equals("undeux"));
        

    
    }
}
