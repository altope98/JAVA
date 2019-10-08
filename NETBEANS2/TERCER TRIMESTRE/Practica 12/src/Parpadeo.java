import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Parpadeo extends javax.swing.JFrame {
    protected int rojo,verde,azul;
    protected boolean parpadeo=true;
    public Parpadeo() {
        initComponents();
        for(int i=0;i<=100;i++){
            tamaño.addItem(i+"");
        }
    }
    public void cambiarTexto() throws InterruptedException{
        texto.setText(areatexto.getText());
        texto.setFont(new Font("",0,Integer.parseInt(tamaño.getSelectedItem())));
        for (int i=0;i<100;i++){
        if (parpadeo){
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

        texto = new java.awt.Label();
        areatexto = new java.awt.TextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tamaño = new java.awt.Choice();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        barrarojo = new javax.swing.JScrollBar();
        barraverde = new javax.swing.JScrollBar();
        barraazul = new javax.swing.JScrollBar();
        salir = new java.awt.Button();
        aplicar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        texto.setAlignment(java.awt.Label.CENTER);
        texto.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        texto.setText("Texto");
        getContentPane().add(texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 950, 100));
        getContentPane().add(areatexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 180, -1));

        jLabel4.setText("Texto");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        jLabel5.setText("Tamaño");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));
        getContentPane().add(tamaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 60, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Color"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Rojo");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel2.setText("Verde");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        jLabel3.setText("Azul");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 30, 20));

        barrarojo.setMaximum(256);
        barrarojo.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        barrarojo.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                barrarojoAdjustmentValueChanged(evt);
            }
        });
        jPanel2.add(barrarojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 130, 30));

        barraverde.setMaximum(256);
        barraverde.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        barraverde.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                barraverdeAdjustmentValueChanged(evt);
            }
        });
        jPanel2.add(barraverde, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 130, 30));

        barraazul.setMaximum(256);
        barraazul.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        barraazul.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                barraazulAdjustmentValueChanged(evt);
            }
        });
        jPanel2.add(barraazul, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 130, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 710, 180));

        salir.setLabel("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, -1, -1));

        aplicar.setLabel("Aplicar");
        aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarActionPerformed(evt);
            }
        });
        getContentPane().add(aplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void barrarojoAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_barrarojoAdjustmentValueChanged
        rojo=barrarojo.getValue();
    }//GEN-LAST:event_barrarojoAdjustmentValueChanged
    private void barraverdeAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_barraverdeAdjustmentValueChanged
        verde=barraverde.getValue();
    }//GEN-LAST:event_barraverdeAdjustmentValueChanged
    private void barraazulAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_barraazulAdjustmentValueChanged
        azul=barraazul.getValue();
    }//GEN-LAST:event_barraazulAdjustmentValueChanged
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed
    private void aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarActionPerformed
        try {
            cambiarTexto();
        } catch (InterruptedException ex) {
            Logger.getLogger(Parpadeo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aplicarActionPerformed
    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parpadeo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button aplicar;
    private java.awt.TextField areatexto;
    private javax.swing.JScrollBar barraazul;
    private javax.swing.JScrollBar barrarojo;
    private javax.swing.JScrollBar barraverde;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private java.awt.Button salir;
    private java.awt.Choice tamaño;
    private java.awt.Label texto;
    // End of variables declaration//GEN-END:variables
}
