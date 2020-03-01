/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.vues;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;

import com.avista.controleurs.MajExControleur;
import com.avista.dao.MajExDAO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author chafy
 */

  
public class FMajEx extends javax.swing.JFrame {
    private String complet;
    MajExControleur uneMajEx = new MajExControleur();
     final static Logger logger = LogManager.getLogger(FMajEx.class); //Logger qui recense les événements  
    /**
     * Creates new form FMajEx
     */
    public FMajEx() {
        initComponents();
        this.setTitle("Exfiles_MAJ : Mise à jour");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnChoisir2 = new javax.swing.JButton();
        txtNomFichier = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnChoisir1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/avist.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        jLabel2.setText("Veuillez choisir le script permettant la mise à jour de l'application eXfiles.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 29, -1, -1));

        btnChoisir2.setText("Valider");
        btnChoisir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoisir2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnChoisir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 100, -1));

        txtNomFichier.setEnabled(false);
        txtNomFichier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomFichierActionPerformed(evt);
            }
        });
        jPanel1.add(txtNomFichier, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 230, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/bandebleu.PNG"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 330, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/bandebleu.PNG"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 340, 30));

        btnChoisir1.setText("Choisir Script...");
        btnChoisir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoisir1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnChoisir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomFichierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomFichierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomFichierActionPerformed
    
    /**
     * Procédure qui permet d'ouvrir un gestionnaire de fichier et de n'afficher que les fichiers .sql
     */
    private void btnChoisir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoisir1ActionPerformed
         JFileChooser choixF = new  JFileChooser(); 
         FileNameExtensionFilter filter = new FileNameExtensionFilter("SQL","sql");//filtre
         choixF.setFileFilter(filter);
         choixF.showOpenDialog(null);
         
        
         String chemin = choixF.getSelectedFile().getPath(); //récupération du chemin
         complet = chemin;
        txtNomFichier.setText((complet)); //écriture du chemins
        
    }//GEN-LAST:event_btnChoisir1ActionPerformed
    
    public String getComplet(){ //Un accesseur de type getter, pour récupérer le chemin
        return this.complet;
    }
    
    /**
     * lecture du script permettant l'upgrade de la version d'eXfiles
     */
    private void btnChoisir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoisir2ActionPerformed
        try{
          if(uneMajEx.versionAjour(complet)){ //Si la version correspondant à la dernière
                FVersionAJour unFenet = new FVersionAJour(); //ouverture de la fenêtre
                unFenet.setVisible(true);
            }
            else{
              uneMajEx.controleScript(complet); // sinon, ouverture de la fenêtre d'exécution des requêtes du script.
            }
        }catch(Exception e){
            logger.error(e);
        }
          


    }//GEN-LAST:event_btnChoisir2ActionPerformed

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
            java.util.logging.Logger.getLogger(FMajEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FMajEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FMajEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FMajEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FMajEx().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoisir1;
    private javax.swing.JButton btnChoisir2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNomFichier;
    // End of variables declaration//GEN-END:variables
}
