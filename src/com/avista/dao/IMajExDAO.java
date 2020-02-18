/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.dao;
import com.avista.dao.MajExDAO;
import java.util.ArrayList;
/**
 *
 * @author chafy
 */
public interface IMajExDAO {
    
    public void executeScript(ArrayList<String> listRequete);
    
}
