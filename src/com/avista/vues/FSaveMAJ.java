/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.vues;

import com.avista.dao.DBConnexion;
import com.avista.dao.ScriptExfilesDAO;
import java.sql.CallableStatement;
import java.sql.*;
import javax.swing.*;
import java.awt.Dimension;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 *
 * @author chafy
 */
public class FSaveMAJ extends javax.swing.JFrame {
    
    //     ********************************************************
//          Vue de l'interface de sauvegarde de la BDD et dossier eXfiles
//     ********************************************************
    
   ScriptExfilesDAO uneSave; //constructeur 
   String path = null; //chemin
   String filename; //nom fichier
   Connection cnx; //connexion
   final static Logger logger = LogManager.getLogger(FSaveMAJ.class);
   DBConnexion uneConnex = new DBConnexion();
   
   
    public FSaveMAJ() {
        initComponents();
        this.setTitle("Exfiles_MAJ : Sauvegarde des données");
        this.setSize(new Dimension(615, 295));
        this.setLocationRelativeTo(null);
        setResizable(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSave.setText("Oui");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 180, 110, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Voulez - vous sauvegarder vos ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 310, -1));

        jButton1.setText("Non");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 110, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("données (Base de données...) ?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/avist.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 13, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/bandebleu.PNG"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, -1, 10));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/bandebleu.PNG"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 260));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\chafy\\Desktop\\bandebleu.PNG")); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        executeProcedureSave();
        String sql = "exec sauvegardeExfiles"; //string de la requête d'exécution de la procédure présente dans sql server
        cnx = DBConnexion.ConnectDB(); //connexion à la bdd
        
        try{
        CallableStatement cs = cnx.prepareCall(sql); //permet de faire appel à la procédure stockée
        cs.executeUpdate(); //exécute l'instruction sql fournie (requête sql qui impacte sur bdd)
        FMajEx fenMaj = new FMajEx();
        JOptionPane.showMessageDialog(null,"La sauvegarde a été effectué");
        this.setVisible(false);
        fenMaj.setVisible(true);

        
        
        
        }catch(Exception e){
            e.printStackTrace();
     
        }
    }//GEN-LAST:event_btnSaveActionPerformed
    public void executeProcedureSave(){
        cnx = DBConnexion.ConnectDB(); //connexion bdd
        try{
        String createProcedure = "CREATE OR ALTER PROCEDURE [dbo].[sauvegardeExfiles]"+
                                  "as "+
                                   "DECLARE @nom VARCHAR(50) "+
                                    "DECLARE @path VARCHAR(256) "
                                    +"DECLARE @fileNom VARCHAR(256) "+
                                    "DECLARE @date VARCHAR(20) "
                                    +"SET @path = 'C:\\Program Files\\Microsoft SQL Server\\MSSQL14.MSSQLSERVER\\MSSQL\\Backup\\' "
                                    +
                                    "SELECT @date = CONVERT(VARCHAR(20),GETDATE(),112) "+
                                    "DECLARE db_cursor CURSOR FOR "
                                    +"SELECT name "+
                                    "FROM master.dbo.sysdatabases "+
                                    "WHERE name NOT IN ('tempdb','master','model','msdb') "+
                                    "AND name = '"+uneConnex.getNomBDD()+"'"+
                                    "OPEN db_cursor "
                                    +"FETCH NEXT FROM db_cursor INTO @nom "+
                                    "WHILE @@FETCH_STATUS = 0 "+
                                    "BEGIN "+
                                    "SET @fileNom = @path + @nom + '_BDD_' + @date + '.BAK' "+
                                    "BACKUP DATABASE @nom TO DISK = @fileNom "
                                    +"FETCH NEXT FROM db_cursor INTO @nom "
                                    +"END "
                                    +"CLOSE db_cursor "+
                                    "DEALLOCATE db_cursor";
        Statement stmt = cnx.createStatement();
        stmt.executeUpdate(createProcedure);
        }catch(SQLException e){
            logger.error(e);
         }                         
    
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FMajEx fenMaj = new FMajEx();
       
        fenMaj.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FSaveMAJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FSaveMAJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FSaveMAJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FSaveMAJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
