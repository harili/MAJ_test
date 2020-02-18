/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chafy
 */

import com.avista.modeles.Pini;
import com.avista.dao.PiniDAO;
public class PiniTest {
     /**
     * Classe de test unitaire
     */
    Pini unPini;
    PiniDAO unPiniDAO;
    @Before
    public void init(){ //initialisation de l'objet Pini
    
    unPini = new Pini(29,"version","4.0.11");
    unPiniDAO = new PiniDAO();
    
    }
    @Test
    public void P_initnotNull(){ //voir si l'objet a bien été crée
    
    assertNotNull("LePini n'existe pas",unPini);
    assertNotNull("Le PiniDAO n'existe pas",unPiniDAO);
    
    
    }
    
    @Test
    public void derniereVersionTest(){ // voir si la version récupérée par la requête sql dans le DAO est bien égale à ce voulu
    
        assertEquals("La valeur de la version n'est pas la bonne",unPini.getValeurIni(),unPiniDAO.VersionActuelle());
        System.out.println(unPiniDAO.VersionActuelle());
    
    }
    
    


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
