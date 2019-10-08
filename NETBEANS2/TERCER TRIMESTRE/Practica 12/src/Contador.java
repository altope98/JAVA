public class Contador extends javax.swing.JFrame implements Runnable{
    int desde, hasta;
    Thread hiloCuenta;
    public Contador(){
        initComponents();
        hiloCuenta=null;
    }
    public void run(){
        try{
         contar();
        } catch(InterruptedException e){}
    }
    public void contar() throws InterruptedException{
        leerDatos();
        int i = desde;
        while(i<=hasta && Thread.currentThread()==hiloCuenta){
            areasecuencial.setText("" + i);
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
    public void comenzarHiloCuenta(){
        if(hiloCuenta==null){
            hiloCuenta = new Thread(this);
            hiloCuenta.start();      
        }
    }
   public void reanudarHiloCuenta(){	
	if(hiloCuenta!=null)
	hiloCuenta.resume();
    }
    public void pararHiloCuenta(){
	if(hiloCuenta != null)
	hiloCuenta.suspend();
    }
    public void finalizarHiloCuenta(){
        hiloCuenta=null;
        limpiarCampos();
    }
    public void limpiarCampos(){
        areadesde.setText(null);
        areahasta.setText(null);
        areasecuencial.setText(null);
    }   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        areahasta = new javax.swing.JTextField();
        areadesde = new javax.swing.JTextField();
        areasecuencial = new javax.swing.JTextField();
        contar = new javax.swing.JButton();
        parar = new javax.swing.JButton();
        reanudar = new javax.swing.JButton();
        finalizar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Desde:");

        jLabel2.setText("Hasta:");

        areahasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areahastaActionPerformed(evt);
            }
        });

        areadesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areadesdeActionPerformed(evt);
            }
        });

        areasecuencial.setEditable(false);

        contar.setText("Contar");
        contar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contarActionPerformed(evt);
            }
        });

        parar.setText("Parar");
        parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pararActionPerformed(evt);
            }
        });

        reanudar.setText("Reanudar");
        reanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reanudarActionPerformed(evt);
            }
        });

        finalizar.setText("Finalizar");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(areasecuencial, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(contar)
                                .addGap(18, 18, 18)
                                .addComponent(parar))
                            .addComponent(areadesde, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(areahasta, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(reanudar)
                                .addGap(18, 18, 18)
                                .addComponent(finalizar)
                                .addGap(18, 18, 18)
                                .addComponent(salir)))))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(areahasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areadesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(areasecuencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contar)
                    .addComponent(parar)
                    .addComponent(reanudar)
                    .addComponent(finalizar)
                    .addComponent(salir))
                .addGap(115, 115, 115))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void areadesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areadesdeActionPerformed
        areahasta.requestFocus();
    }//GEN-LAST:event_areadesdeActionPerformed
    private void areahastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areahastaActionPerformed
        comenzarHiloCuenta();
    }//GEN-LAST:event_areahastaActionPerformed
    private void pararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pararActionPerformed
        pararHiloCuenta();
    }//GEN-LAST:event_pararActionPerformed
    private void reanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reanudarActionPerformed
        reanudarHiloCuenta();
    }//GEN-LAST:event_reanudarActionPerformed
    private void contarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contarActionPerformed
        comenzarHiloCuenta();
    }//GEN-LAST:event_contarActionPerformed
    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        finalizarHiloCuenta();
    }//GEN-LAST:event_finalizarActionPerformed
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed
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
            java.util.logging.Logger.getLogger(Contador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contador().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areadesde;
    private javax.swing.JTextField areahasta;
    private javax.swing.JTextField areasecuencial;
    private javax.swing.JButton contar;
    private javax.swing.JButton finalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton parar;
    private javax.swing.JButton reanudar;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
