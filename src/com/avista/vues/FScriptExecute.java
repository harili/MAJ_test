/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.vues;

import java.awt.Dimension;

/**
 *
 * @author chafy
 */
public class FScriptExecute extends javax.swing.JFrame {

    /**
     * Creates new form FScriptExecute
     */
    public FScriptExecute() {
        initComponents();
        this.setTitle("Exfiles_MAJ : Exécution des requêtes.. ");
   
        setResizable(false);
       
        this.setSize(new Dimension(700, 320));
        setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtScript = new javax.swing.JTextArea();
        btnOui = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Avancement de l'exécution :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        txtScript.setColumns(20);
        txtScript.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtScript.setRows(5);
        txtScript.setEnabled(false);
        jScrollPane1.setViewportView(txtScript);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 401, 172));

        btnOui.setText("Quitter");
        btnOui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOuiActionPerformed(evt);
            }
        });
        jPanel1.add(btnOui, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/bandebleu.PNG"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, 10));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/bandebleu.PNG"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 370, 10));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/avist.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 3, 690, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOuiActionPerformed
        FPreMAJ unFenet = new FPreMAJ();
        setVisible(false);
        unFenet.setVisible(true);
    }//GEN-LAST:event_btnOuiActionPerformed

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
            java.util.logging.Logger.getLogger(FScriptExecute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FScriptExecute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FScriptExecute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FScriptExecute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FScriptExecute().setVisible(true);
            }
        });
    }
    public javax.swing.JTextArea getTxtScript(){
    
        return this.txtScript;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOui;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtScript;
    // End of variables declaration//GEN-END:variables
}
