
package com.avista.dao;
import com.avista.modeles.Utilisateur;
/**
 *
 * @author chafy
 */
public interface IUtilisateurDAO {
//     ********************************************************
//              Interface contenant les signatures des méthodes 
//              qui seront utilisées dans UtilisateurDAO
//     ********************************************************
    public boolean authentifierUtilisateur(Utilisateur unUtilisateur); //signature de la fonction d'authentification
}
