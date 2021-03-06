/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.vues;
import com.avista.controleurs.UtilisateurControleur;
import com.avista.dao.Cryptage;
import com.avista.dao.ScriptExfilesDAO;
import com.avista.dao.UtilisateurDAO;
import java.awt.Dimension;
import java.awt.Event;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 *
 * @author chafy
 */
public class FAuthentification extends javax.swing.JFrame {
    
    //On instancie un objet de type UtilisateurControleur
    UtilisateurControleur unUtilisateurControleur = new UtilisateurControleur();
    UtilisateurDAO unUtilisateurDAO = new UtilisateurDAO();
    final static Logger logger = LogManager.getLogger(FAuthentification.class);

    /**
     * Creates new form FAuthentification
     */
    public FAuthentification() {
        initComponents();
        this.setTitle("Exfiles_MAJ : Connexion");
        this.setSize(new Dimension(743, 285));
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblMessageConnexion = new javax.swing.JLabel();
        txtMdp = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnConnexion = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Georgia Pro Semibold", 0, 13)); // NOI18N
        jLabel1.setText("Nom d'utilisateur :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Georgia Pro Cond Semibold", 0, 13)); // NOI18N
        jLabel2.setText("Mot de passe :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));

        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        getContentPane().add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 176, -1));

        lblMessageConnexion.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(lblMessageConnexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 336, 20));

        txtMdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMdpActionPerformed(evt);
            }
        });
        getContentPane().add(txtMdp, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 176, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/bandebleu.PNG"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 380, 10));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/bandebleu.PNG"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, 10));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/avist.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/annuler-icone-4608-16.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 50, -1));

        btnConnexion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/accepter-icone-3895-16.png"))); // NOI18N
        btnConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnexionActionPerformed(evt);
            }
        });
        jPanel1.add(btnConnexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 240));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\chafy\\Desktop\\bandebleu.PNG")); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginActionPerformed

    
    
//     **************************************************************
//              Procédure de déclenchement du bouton 'btnConnexion'
//              Récupère le message lors de l'authentification et l'affiche
//     **************************************************************
    
    private void btnConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnexionActionPerformed
        Cryptage cipherUtil = new Cryptage();
        String mdpDecrypte = cipherUtil.encrypt(txtMdp.getText());
        String res = unUtilisateurControleur.authentifierUtilisateur(txtLogin.getText(), mdpDecrypte); //saisis des identifiants
        lblMessageConnexion.setText(res); //écrire s'il y a une erreur

        if(res.equals("Ok")){   //si c'est bon
            FPostMAJ fenetPostMAJ = new FPostMAJ(); //ouverture de la fenêtre suivante
            this.setVisible(false);
            
            fenetPostMAJ.setVisible(true);
            fenetPostMAJ.setTitle("Exfiles_MAJ : Interface de mise à jour");

        }

    }//GEN-LAST:event_btnConnexionActionPerformed

    private void txtMdpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMdpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMdpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
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
            java.util.logging.Logger.getLogger(FAuthentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FAuthentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FAuthentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FAuthentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FAuthentification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnexion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMessageConnexion;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtMdp;
    // End of variables declaration//GEN-END:variables
}
