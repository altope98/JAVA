/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Casa Portatil
 */
public class HiloCuenta extends javax.swing.JFrame implements Runnable{
    int desde, hasta;
    Thread hiloCuenta;
    
    public HiloCuenta() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(480, 200);
        hiloCuenta=null;
    }
    public void run() {
        try{
         contar();
        } catch(InterruptedException e) {}
    }
    public void contar() throws InterruptedException {
        leerDatos();
        int i = desde;
        while(i<=hasta && Thread.currentThread()==hiloCuenta) {
            tfContar.setText("" + i);
            //try{
            Thread.sleep(1000);
            //} catch(InterruptedException e) {}
            i++;
        }
    }    
    public void leerDatos() {
        try{
            desde = Integer.parseInt(tfDesde.getText());
        } catch(NumberFormatException e) {
            desde=1;
            tfDesde.setText("" + desde);
        }
        try{
            hasta = Integer.parseInt(tfHasta.getText());
        } catch(NumberFormatException e) {
            hasta=100;
            tfHasta.setText("" + hasta);
        }
    }    
    public void nuevoHilo() {
        if(hiloCuenta==null) {
            hiloCuenta = new Thread(this);
            hiloCuenta.start();      
        }
    }
   public void iniciarHilo()
{	
	if(hiloCuenta!=null)
	hiloCuenta.resume();
}
    public void pararHilo ()
{
	if(hiloCuenta != null)
	hiloCuenta.suspend();
}
     public void finalizarHilo()
     {
     dispose();
     }
    public void crearHilo(){
        if (hiloCuenta==null){
            hiloCuenta = new Thread (this);
            hiloCuenta.start();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfDesde = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        tfHasta = new java.awt.TextField();
        bContar = new javax.swing.JButton();
        tfContar = new java.awt.TextField();
        bFinalizar = new javax.swing.JButton();
        parar = new javax.swing.JButton();
        reanudar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ejemplo bloque try");
        setBackground(new java.awt.Color(51, 255, 0));
        setMinimumSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Desde");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(44, 68, 60, 20);

        tfDesde.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDesdeActionPerformed(evt);
            }
        });
        getContentPane().add(tfDesde);
        tfDesde.setBounds(100, 70, 60, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Hasta");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(330, 70, 50, 20);

        tfHasta.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHastaActionPerformed(evt);
            }
        });
        getContentPane().add(tfHasta);
        tfHasta.setBounds(390, 70, 70, 23);

        bContar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bContar.setText("Contar");
        bContar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bContarActionPerformed(evt);
            }
        });
        getContentPane().add(bContar);
        bContar.setBounds(40, 310, 100, 33);

        tfContar.setEditable(false);
        tfContar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(tfContar);
        tfContar.setBounds(210, 220, 80, 23);

        bFinalizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bFinalizar.setText("Finalizar");
        bFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(bFinalizar);
        bFinalizar.setBounds(390, 310, 90, 33);

        parar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        parar.setText("Parar");
        parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pararActionPerformed(evt);
            }
        });
        getContentPane().add(parar);
        parar.setBounds(160, 310, 80, 33);

        reanudar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reanudar.setText("Reanudar");
        reanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reanudarActionPerformed(evt);
            }
        });
        getContentPane().add(reanudar);
        reanudar.setBounds(260, 310, 110, 33);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDesdeActionPerformed
       tfHasta.requestFocus();
    }//GEN-LAST:event_tfDesdeActionPerformed

    private void tfHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHastaActionPerformed
        nuevoHilo();
    }//GEN-LAST:event_tfHastaActionPerformed

    private void bContarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bContarActionPerformed
        nuevoHilo();
    }//GEN-LAST:event_bContarActionPerformed

    private void bFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFinalizarActionPerformed
        finalizarHilo();      
    }//GEN-LAST:event_bFinalizarActionPerformed

    private void pararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pararActionPerformed
        // TODO add your handling code here:
        pararHilo();
    }//GEN-LAST:event_pararActionPerformed

    private void reanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reanudarActionPerformed
        // TODO add your handling code here:
        iniciarHilo();
    }//GEN-LAST:event_reanudarActionPerformed

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
            java.util.logging.Logger.getLogger(HiloCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HiloCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HiloCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HiloCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HiloCuenta().setVisible(true);
            }
        }) ;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bContar;
    private javax.swing.JButton bFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton parar;
    private javax.swing.JButton reanudar;
    private java.awt.TextField tfContar;
    private java.awt.TextField tfDesde;
    private java.awt.TextField tfHasta;
    // End of variables declaration//GEN-END:variables
}
