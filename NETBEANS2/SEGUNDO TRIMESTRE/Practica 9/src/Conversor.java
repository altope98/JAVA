
import java.text.DecimalFormat;

public class Conversor extends javax.swing.JFrame {
    public Conversor() {
        initComponents();
        dialogo.pack();
        dialogo.setLocationRelativeTo(null);
    }
    
    public void euro(){
        DecimalFormat numberFormat = new DecimalFormat("#0.00");
        areadolares.setText(null);
        arealibras.setText(null);
        double euros=Double.parseDouble(areaeuros.getText());
        double libras=euros*0.86;
        double dolares=libras*1.32;
        areadolares.setText(numberFormat.format(dolares));
        arealibras.setText(numberFormat.format(libras));
    }
    
    public void dolar(){
        DecimalFormat numberFormat = new DecimalFormat("#0.00");
        areaeuros.setText(null);
        arealibras.setText(null);
        double dolares=Double.parseDouble(areadolares.getText());
        double libras=dolares*0.75;
        double euros=libras*1.17;
        areaeuros.setText(numberFormat.format(euros));
        arealibras.setText(numberFormat.format(libras));
    }
    
    public void libra(){
        DecimalFormat numberFormat = new DecimalFormat("#0.00");
        areaeuros.setText(null);
        areadolares.setText(null);
        double libras=Double.parseDouble(arealibras.getText());
        double dolares=libras*1.33;
        double euros=dolares*0.88;
        areaeuros.setText(numberFormat.format(euros));
        areadolares.setText(numberFormat.format(dolares));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        cerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        areaeuros = new javax.swing.JTextField();
        areadolares = new javax.swing.JTextField();
        arealibras = new javax.swing.JTextField();
        limpiar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ERROR: Escribe un numero");

        cerrar.setText("Cerrar");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogoLayout = new javax.swing.GroupLayout(dialogo.getContentPane());
        dialogo.getContentPane().setLayout(dialogoLayout);
        dialogoLayout.setHorizontalGroup(
            dialogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoLayout.createSequentialGroup()
                .addGroup(dialogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogoLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel4))
                    .addGroup(dialogoLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(cerrar)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        dialogoLayout.setVerticalGroup(
            dialogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(cerrar)
                .addGap(66, 66, 66))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conversor de monedas");

        jLabel1.setText("Euros");

        jLabel2.setText("Dólares");

        jLabel3.setText("Libras");

        areaeuros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                areaeurosKeyReleased(evt);
            }
        });

        areadolares.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                areadolaresKeyReleased(evt);
            }
        });

        arealibras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                arealibrasKeyReleased(evt);
            }
        });

        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(areaeuros, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(areadolares, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(arealibras, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(limpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salir)
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(areaeuros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areadolares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arealibras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpiar)
                    .addComponent(salir))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        dialogo.dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        areaeuros.setText(null);
        areadolares.setText(null);
        arealibras.setText(null);
        areaeuros.requestFocus();
    }//GEN-LAST:event_limpiarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void areaeurosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaeurosKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER)
        {
            System.exit(0);
        }
        try{
            euro();
        }catch(NumberFormatException e)
        {
            dialogo.show();
            String aux=areaeuros.getText();
            StringBuffer cadena=new StringBuffer(aux);
            cadena.setLength(aux.length()-1);
            areaeuros.setText(cadena.toString());
            areadolares.setText("");
            arealibras.setText("");
        }
        
    }//GEN-LAST:event_areaeurosKeyReleased

    private void areadolaresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areadolaresKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER)
        {
            System.exit(0);
        }
        try{
            dolar();
        }catch(NumberFormatException e)
        {
            dialogo.show();
            String aux=areadolares.getText();
            StringBuffer cadena=new StringBuffer(aux);
            cadena.setLength(aux.length()-1);
            areadolares.setText(cadena.toString());
            areaeuros.setText("");
            arealibras.setText("");
        }
    }//GEN-LAST:event_areadolaresKeyReleased

    private void arealibrasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_arealibrasKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER)
        {
            System.exit(0);
        }
        try{
            libra();
        }catch(NumberFormatException e)
        {
            dialogo.show();
            String aux=arealibras.getText();
            StringBuffer cadena=new StringBuffer(aux);
            cadena.setLength(aux.length()-1);
            arealibras.setText(cadena.toString());
            areadolares.setText("");
            areaeuros.setText("");
        }
    }//GEN-LAST:event_arealibrasKeyReleased
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
            java.util.logging.Logger.getLogger(Conversor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Conversor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Conversor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Conversor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Conversor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areadolares;
    private javax.swing.JTextField areaeuros;
    private javax.swing.JTextField arealibras;
    private javax.swing.JButton cerrar;
    private javax.swing.JDialog dialogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
