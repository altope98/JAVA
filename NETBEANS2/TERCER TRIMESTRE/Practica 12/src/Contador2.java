public class Contador2 extends javax.swing.JFrame implements Runnable {
    int desde, hasta;
    Thread hilo1,hilo2;
    public Contador2() {
        initComponents();
        hilo1=null;
        hilo2=null;
    }
    public void run(){
        try{
         contar();
        } catch(InterruptedException e){}
    }
    public void contar() throws InterruptedException{
        leerDatos();
        int i = desde;
        while(i<=hasta && Thread.currentThread()==hilo1){
            areasecuencial1.setText("" + i);
            Thread.sleep(1000);
            i++;
        }
        while(i<=hasta && Thread.currentThread()==hilo2){
            areasecuencial2.setText("" + i);
            Thread.sleep(1000);
            i++;
        }
    }
    public void leerDatos(){
        try{
            desde = Integer.parseInt(areadesde.getText());
        } catch(NumberFormatException e){
            desde=1;
            areadesde.setText("" + desde);
        }
        try{
            hasta = Integer.parseInt(areahasta.getText());
        } catch(NumberFormatException e){
            hasta=100;
            areahasta.setText("" + hasta);
        }
    }
    public void comenzarHilo1(){
        if(hilo1==null){
            hilo1 = new Thread(this);
            hilo1.start();      
        }
    }
   public void reanudarHilo1(){	
	if(hilo1!=null)
	hilo1.resume();
    }
    public void pararHilo1(){
	if(hilo1 != null)
	hilo1.suspend();
    }
    public void comenzarHilo2(){
        if(hilo2==null){
            hilo2 = new Thread(this);
            hilo2.start();      
        }
    }
   public void reanudarHilo2(){	
	if(hilo2!=null)
	hilo2.resume();
    }
    public void pararHilo2(){
	if(hilo2 != null)
	hilo2.suspend();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        areadesde = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        areahasta = new javax.swing.JTextField();
        areasecuencial1 = new javax.swing.JTextField();
        areasecuencial2 = new javax.swing.JTextField();
        comenzar1 = new javax.swing.JButton();
        parar1 = new javax.swing.JButton();
        reanudar1 = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        comenzar2 = new javax.swing.JButton();
        parar2 = new javax.swing.JButton();
        reanudar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Desde:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        areadesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areadesdeActionPerformed(evt);
            }
        });
        getContentPane().add(areadesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 180, -1));

        jLabel2.setText("Hasta:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));
        getContentPane().add(areahasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 200, -1));

        areasecuencial1.setEditable(false);
        getContentPane().add(areasecuencial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 110, -1));

        areasecuencial2.setEditable(false);
        getContentPane().add(areasecuencial2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 120, -1));

        comenzar1.setText("Comenzar");
        comenzar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comenzar1ActionPerformed(evt);
            }
        });
        getContentPane().add(comenzar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        parar1.setText("Parar");
        parar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parar1ActionPerformed(evt);
            }
        });
        getContentPane().add(parar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));

        reanudar1.setText("Reanudar");
        reanudar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reanudar1ActionPerformed(evt);
            }
        });
        getContentPane().add(reanudar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        comenzar2.setText("Comenzar");
        comenzar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comenzar2ActionPerformed(evt);
            }
        });
        getContentPane().add(comenzar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, -1, -1));

        parar2.setText("Parar");
        parar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parar2ActionPerformed(evt);
            }
        });
        getContentPane().add(parar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, -1, -1));

        reanudar2.setText("Reanudar");
        reanudar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reanudar2ActionPerformed(evt);
            }
        });
        getContentPane().add(reanudar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void areadesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areadesdeActionPerformed
        areahasta.requestFocus();
    }//GEN-LAST:event_areadesdeActionPerformed
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed
    private void comenzar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comenzar1ActionPerformed
        comenzarHilo1();
    }//GEN-LAST:event_comenzar1ActionPerformed
    private void parar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parar1ActionPerformed
        pararHilo1();
    }//GEN-LAST:event_parar1ActionPerformed
    private void reanudar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reanudar1ActionPerformed
        reanudarHilo1();
    }//GEN-LAST:event_reanudar1ActionPerformed
    private void comenzar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comenzar2ActionPerformed
        comenzarHilo2();
    }//GEN-LAST:event_comenzar2ActionPerformed
    private void parar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parar2ActionPerformed
        pararHilo2();
    }//GEN-LAST:event_parar2ActionPerformed
    private void reanudar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reanudar2ActionPerformed
        reanudarHilo2();
    }//GEN-LAST:event_reanudar2ActionPerformed
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
            java.util.logging.Logger.getLogger(Contador2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contador2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contador2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contador2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contador2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areadesde;
    private javax.swing.JTextField areahasta;
    private javax.swing.JTextField areasecuencial1;
    private javax.swing.JTextField areasecuencial2;
    private javax.swing.JButton comenzar1;
    private javax.swing.JButton comenzar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton parar1;
    private javax.swing.JButton parar2;
    private javax.swing.JButton reanudar1;
    private javax.swing.JButton reanudar2;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
