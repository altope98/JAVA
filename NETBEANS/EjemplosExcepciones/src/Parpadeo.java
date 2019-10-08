
import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javafx.scene.control.ScrollBar;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvar
 */
public class Parpadeo extends javax.swing.JFrame {

    /**
     * Creates new form Parpadeo
     */
    public Parpadeo() {
        initComponents();
         for(int i=0;i<=100;i++){
            tamaño.addItem(i+"");
        }
         
    }

    
    public void cambiarTexto() throws InterruptedException{
        texto.setText(area.getText());
         texto.setFont(new Font("",0,Integer.parseInt(tamaño.getSelectedItem())));
       
        for (int i=0;i<100;i++){
        if (parpadeo)
        {
                texto.setForeground(new Color(rojo,verde,azul));
                parpadeo=false;
                Thread.sleep(100);
           
          
        }else{
                texto.setForeground(Color.white);
                parpadeo=true;
                Thread.sleep(100);
        }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        brojo = new javax.swing.JScrollBar();
        bverde = new javax.swing.JScrollBar();
        bazul = new javax.swing.JScrollBar();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        aplicar = new java.awt.Button();
        salir = new java.awt.Button();
        area = new java.awt.TextField();
        tamaño = new java.awt.Choice();
        texto = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 505));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Color"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Rojo");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel2.setText("Verde");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        jLabel3.setText("Azul");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 30, 20));

        brojo.setMaximum(256);
        brojo.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        brojo.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                brojoAdjustmentValueChanged(evt);
            }
        });
        jPanel2.add(brojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 130, 30));

        bverde.setMaximum(256);
        bverde.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        bverde.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                bverdeAdjustmentValueChanged(evt);
            }
        });
        jPanel2.add(bverde, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 130, 30));

        bazul.setMaximum(256);
        bazul.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        bazul.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                bazulAdjustmentValueChanged(evt);
            }
        });
        jPanel2.add(bazul, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 130, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 710, 180));

        jLabel4.setText("Texto");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        jLabel5.setText("Tamaño");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        aplicar.setLabel("Aplicar");
        aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarActionPerformed(evt);
            }
        });
        getContentPane().add(aplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, -1, -1));

        salir.setLabel("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, -1, -1));
        getContentPane().add(area, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 180, -1));
        getContentPane().add(tamaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 60, -1));

        texto.setAlignment(java.awt.Label.CENTER);
        texto.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        texto.setText("Texto");
        getContentPane().add(texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 950, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void brojoAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_brojoAdjustmentValueChanged
        // TODO add your handling code here:
        rojo=brojo.getValue();
    }//GEN-LAST:event_brojoAdjustmentValueChanged

    private void bverdeAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_bverdeAdjustmentValueChanged
        // TODO add your handling code here:
         verde=bverde.getValue();
    }//GEN-LAST:event_bverdeAdjustmentValueChanged

    private void bazulAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_bazulAdjustmentValueChanged
        // TODO add your handling code here:
        azul=bazul.getValue();
    }//GEN-LAST:event_bazulAdjustmentValueChanged

    private void aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarActionPerformed
        // TODO add your handling code here:
         try {
            cambiarTexto();
        } catch (InterruptedException ex) {
            Logger.getLogger(Parpadeo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aplicarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

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
            java.util.logging.Logger.getLogger(Parpadeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Parpadeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Parpadeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Parpadeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parpadeo().setVisible(true);
            }
        });
    }

    
    protected int rojo,verde,azul;
    protected boolean parpadeo=true;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected java.awt.Button aplicar;
    protected java.awt.TextField area;
    protected javax.swing.JScrollBar bazul;
    protected javax.swing.JScrollBar brojo;
    protected javax.swing.JScrollBar bverde;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel jLabel3;
    protected javax.swing.JLabel jLabel4;
    protected javax.swing.JLabel jLabel5;
    protected javax.swing.JPanel jPanel2;
    protected java.awt.Button salir;
    protected java.awt.Choice tamaño;
    protected java.awt.Label texto;
    // End of variables declaration//GEN-END:variables
}
