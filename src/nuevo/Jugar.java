/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nuevo;

import nuevo.juego;
import nuevo.Tablero_1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author ar466
 */
public class Jugar extends javax.swing.JFrame {

    /**
     * Creates new form Jugar
     */
    private Tablero_1 tablero;
    private juego juego;
    private String usuarioLogueado;
    private static String[] usuarios = new String[100];
    private static int countUsuarios = 0;

    public Jugar() {
        initComponents();
        tablero = new Tablero_1("", "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpanelTab = new javax.swing.JPanel();
        btnTablero = new javax.swing.JButton();
        btnVampiro = new javax.swing.JButton();
        btnHombreLobo = new javax.swing.JButton();
        BtnNecromancer = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout JpanelTabLayout = new javax.swing.GroupLayout(JpanelTab);
        JpanelTab.setLayout(JpanelTabLayout);
        JpanelTabLayout.setHorizontalGroup(
            JpanelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );
        JpanelTabLayout.setVerticalGroup(
            JpanelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );

        btnTablero.setText("Mostrar Tablero");
        btnTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableroActionPerformed(evt);
            }
        });

        btnVampiro.setText("Vampiro");
        btnVampiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVampiroActionPerformed(evt);
            }
        });

        btnHombreLobo.setText("Hombre Lobo");
        btnHombreLobo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHombreLoboActionPerformed(evt);
            }
        });

        BtnNecromancer.setText("Necromancer");
        BtnNecromancer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNecromancerActionPerformed(evt);
            }
        });

        jButton1.setText("Retirar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(353, 353, 353)
                        .addComponent(btnTablero))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(JpanelTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVampiro)
                            .addComponent(btnHombreLobo)
                            .addComponent(BtnNecromancer)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton1)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(42, Short.MAX_VALUE)
                        .addComponent(JpanelTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnVampiro)
                        .addGap(29, 29, 29)
                        .addComponent(btnHombreLobo)
                        .addGap(31, 31, 31)
                        .addComponent(BtnNecromancer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(35, 35, 35)
                .addComponent(btnTablero)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableroActionPerformed
        // TODO add your handling code here:
        JpanelTab.removeAll();
         GridLayout gridLayout = new GridLayout(tablero.getFilas(), tablero.getColumnas());
        gridLayout.setHgap(0);
        gridLayout.setVgap(0); 
        JpanelTab.setLayout(gridLayout);
        for (int i = 0; i < tablero.getFilas(); i++) {
        for (int j = 0; j < tablero.getColumnas(); j++) {
           JButton button = new JButton(String.valueOf(tablero.getValorCasilla(i, j)));
            Color color = (i + j) % 2 == 0 ? Color.WHITE : Color.BLACK;
            button.setBackground(color);
            button.setFont(new Font("Arial", Font.PLAIN, 31)); 
            button.setFocusPainted(false); 
            Dimension dimension = new Dimension(80, 80); 
            button.setPreferredSize(dimension);
            button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); 
            button.setBorder(BorderFactory.createRaisedBevelBorder()); 
            
            JpanelTab.add(button);
        }
    }
    JpanelTab.revalidate();
    JpanelTab.repaint();
    }//GEN-LAST:event_btnTableroActionPerformed

    private void btnVampiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVampiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVampiroActionPerformed

    private void btnHombreLoboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHombreLoboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHombreLoboActionPerformed

    private void BtnNecromancerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNecromancerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnNecromancerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        juego.retirar(usuarioLogueado);
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
            java.util.logging.Logger.getLogger(Jugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jugar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnNecromancer;
    private javax.swing.JPanel JpanelTab;
    private javax.swing.JButton btnHombreLobo;
    private javax.swing.JButton btnTablero;
    private javax.swing.JButton btnVampiro;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
