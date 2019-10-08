
public class Quiniela extends javax.swing.JFrame {
    public Quiniela() {
        initComponents();
        this.pack();
        dialogo.pack();
        dialogo.setLocationRelativeTo(null);
        dialogoe.pack();
        dialogoe.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        areaañadir = new javax.swing.JTextField();
        añadir = new javax.swing.JButton();
        dialogoe = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lista2 = new java.awt.List();
        lista1 = new java.awt.List();
        jLabel1 = new javax.swing.JLabel();
        nuevo = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        vaciar = new javax.swing.JButton();
        generar = new javax.swing.JButton();

        dialogo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Partido:");
        dialogo.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));
        dialogo.getContentPane().add(areaañadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 180, -1));

        añadir.setText("Añadir");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(añadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        dialogoe.setTitle("ERROR");
        dialogoe.setMinimumSize(new java.awt.Dimension(500, 300));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ERROR, NO SE HA SELECCIONADO UN ITEM");

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("ACEPTAR");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogoeLayout = new javax.swing.GroupLayout(dialogoe.getContentPane());
        dialogoe.getContentPane().setLayout(dialogoeLayout);
        dialogoeLayout.setHorizontalGroup(
            dialogoeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
            .addGroup(dialogoeLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogoeLayout.setVerticalGroup(
            dialogoeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoeLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lista2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 130, 180));
        getContentPane().add(lista1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, 180));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GENERACIÓN DE QUINIELAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 350, -1));

        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        getContentPane().add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 80, -1));

        borrar.setText("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        getContentPane().add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 80, -1));

        vaciar.setText("Vaciar");
        vaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaciarActionPerformed(evt);
            }
        });
        getContentPane().add(vaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 80, -1));

        generar.setText("Generar");
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });
        getContentPane().add(generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void generar(){
        for(int i=0;i<=lista1.getItemCount()-1;i++){
            
            int n=(int)(Math.random()*10+1);
            switch(n){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:lista2.add("1     "+lista1.getItem(i));break;
                case 6:
                case 7:
                case 8:lista2.add("X     "+lista1.getItem(i));break;
                case 9:
                case 10:lista2.add("2     "+lista1.getItem(i));break;
            }
            
            
        }
    }
    public void borrar(){
        try{
        lista1.remove(lista1.getSelectedItem());}
        catch(IllegalArgumentException e)
        {
            dialogoe.show();
        }
    }
    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
        // TODO add your handling code here:
        generar();
    }//GEN-LAST:event_generarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:
        borrar();
    }//GEN-LAST:event_borrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dialogoe.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void vaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaciarActionPerformed
        // TODO add your handling code here:
        lista1.removeAll();
        lista2.removeAll();
    }//GEN-LAST:event_vaciarActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        // TODO add your handling code here:
        dialogo.show();
    }//GEN-LAST:event_nuevoActionPerformed

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed
        // TODO add your handling code here:
        lista1.addItem(areaañadir.getText()+"");
        areaañadir.setText(null);
        dialogo.dispose();
    }//GEN-LAST:event_añadirActionPerformed

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
            java.util.logging.Logger.getLogger(Quiniela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiniela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiniela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiniela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiniela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areaañadir;
    private javax.swing.JButton añadir;
    private javax.swing.JButton borrar;
    private javax.swing.JDialog dialogo;
    private javax.swing.JDialog dialogoe;
    private javax.swing.JButton generar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private java.awt.List lista1;
    private java.awt.List lista2;
    private javax.swing.JButton nuevo;
    private javax.swing.JButton vaciar;
    // End of variables declaration//GEN-END:variables
}
