public class Reloj extends javax.swing.JFrame implements Runnable{
    Thread hilo;
    int hora,minuto,segundo;
    public Reloj() {
        initComponents();
        hilo=null;
        this.pack();
        dialogo.pack();
        dialogo.setLocationRelativeTo(null);
    }
    public void run(){
        try{
         contar();
        } catch(InterruptedException e){}
    }
    public void contar() throws InterruptedException{
        int j,k,i;
        while(Thread.currentThread()==hilo){
            for(i=hora;i<=24;i++ ){               
                for(j=minuto;j<=60;j++){           
                    for(k=segundo;k<=60;k++){
                         if(i==24){
                            i=0;
                            j=0;
                        }
                        if(j==60){
                            j=0;
                            i++;
                        }
                        if(k==60){
                            k=0;
                            j++;
                        }
                        areareloj.setText(i+":"+j+":"+k);
                        Thread.sleep(1000);  
                    }
                }
            }
            
        }
    }    
    public void comenzarHilo(){
        if(hilo==null){
            hilo = new Thread(this);
            hilo.start();      
        }
    }
   public void reanudarHilo(){	
	if(hilo!=null)
	hilo.resume();
    }
    public void pararHilo(){
	if(hilo != null)
	hilo.suspend();
    }
    public void finalizarHilo(){
        hilo.stop();
        hilo=null;
        limpiarCampos();
    }
    public void limpiarCampos(){
        hora=00;
        minuto=00;
        segundo=00;
        areareloj.setText(hora+":"+minuto+":"+segundo);
    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        areahora = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        areaminuto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        areasegundo = new javax.swing.JTextField();
        aplicar = new javax.swing.JButton();
        areareloj = new javax.swing.JTextField();
        resetear = new javax.swing.JButton();
        parar = new javax.swing.JButton();
        reanudar = new javax.swing.JButton();
        poner = new javax.swing.JButton();

        dialogo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Hora");
        dialogo.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        dialogo.getContentPane().add(areahora, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 40, -1));

        jLabel2.setText("Minutos");
        dialogo.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));
        dialogo.getContentPane().add(areaminuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 40, -1));

        jLabel3.setText("Segundos");
        dialogo.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));
        dialogo.getContentPane().add(areasegundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 40, -1));

        aplicar.setText("Aplicar");
        aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(aplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        areareloj.setEditable(false);
        getContentPane().add(areareloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 150, -1));

        resetear.setText("Resetear");
        resetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetearActionPerformed(evt);
            }
        });
        getContentPane().add(resetear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        parar.setText("Parar");
        parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pararActionPerformed(evt);
            }
        });
        getContentPane().add(parar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        reanudar.setText("Reanudar");
        reanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reanudarActionPerformed(evt);
            }
        });
        getContentPane().add(reanudar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, -1, -1));

        poner.setText("Poner en hora");
        poner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ponerActionPerformed(evt);
            }
        });
        getContentPane().add(poner, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarActionPerformed
       try{
       
       hora=Integer.parseInt(areahora.getText());
       minuto=Integer.parseInt(areaminuto.getText());
       segundo=Integer.parseInt(areasegundo.getText());
       areareloj.setText(hora+":"+minuto+":"+segundo);
       areahora.setText(null);
       areaminuto.setText(null);
       areasegundo.setText(null);
       dialogo.dispose();
       comenzarHilo();
       }catch(NumberFormatException e){
       }       
    }//GEN-LAST:event_aplicarActionPerformed
    private void ponerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ponerActionPerformed
        dialogo.show();
    }//GEN-LAST:event_ponerActionPerformed
    private void resetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetearActionPerformed
        finalizarHilo();
    }//GEN-LAST:event_resetearActionPerformed
    private void reanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reanudarActionPerformed
        reanudarHilo();
    }//GEN-LAST:event_reanudarActionPerformed
    private void pararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pararActionPerformed
        pararHilo();
    }//GEN-LAST:event_pararActionPerformed
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
            java.util.logging.Logger.getLogger(Reloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reloj().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aplicar;
    private javax.swing.JTextField areahora;
    private javax.swing.JTextField areaminuto;
    private javax.swing.JTextField areareloj;
    private javax.swing.JTextField areasegundo;
    private javax.swing.JDialog dialogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton parar;
    private javax.swing.JButton poner;
    private javax.swing.JButton reanudar;
    private javax.swing.JButton resetear;
    // End of variables declaration//GEN-END:variables
}
