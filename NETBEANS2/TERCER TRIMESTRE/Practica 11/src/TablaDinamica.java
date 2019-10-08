import java.util.Vector;
import javax.swing.table.DefaultTableModel;
public class TablaDinamica extends javax.swing.JFrame {
    DefaultTableModel modelotabla1, modelotabla2;
    public TablaDinamica() {
        initComponents();
        this.pack();
        dialogo.pack();
        dialogo.setLocationRelativeTo(null);
        dialogo2.pack();
        dialogo2.setLocationRelativeTo(null);
        dialogo3.pack();
        dialogo3.setLocationRelativeTo(null);
        dialogo4.pack();
        dialogo4.setLocationRelativeTo(null);
        dialogo5.pack();
        dialogo5.setLocationRelativeTo(null);
        modelotabla1=new DefaultTableModel();
        modelotabla1= (DefaultTableModel) tabla1.getModel();
    }   
    public void cambiarNombres(){
        modelotabla2 = new DefaultTableModel();
        int numerocolumnas=modelotabla1.getColumnCount();
        for(int i=1; i<=numerocolumnas; i++){
            modelotabla2.addColumn("Columna-"+i);
            Object[] fila = new Object[numerocolumnas];
            modelotabla2.addRow(fila);
        }
        for(int i=0; i<numerocolumnas; i++){
            modelotabla2.setValueAt(modelotabla1.getColumnName(i),0,i);
            tabla2.setModel(modelotabla2);    
        }
        dialogo.show();
    }
    public void cambiarIndices(){
        Vector identificador = new Vector();
        for(int i=0 ; i<modelotabla2.getColumnCount();i++){
            identificador.add(tabla2.getValueAt(0, i));
        }
        modelotabla1.setColumnIdentifiers(identificador);
        dialogo.dispose();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        siguiente = new javax.swing.JButton();
        dialogo2 = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        dialogo3 = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        aceptar2 = new javax.swing.JButton();
        dialogo4 = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        aceptar4 = new javax.swing.JButton();
        dialogo5 = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        aceptar5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        añadirfila = new javax.swing.JButton();
        eliminarfila = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        nuevacolumna = new javax.swing.JButton();
        areanombre = new javax.swing.JTextField();
        cambiarnombres = new javax.swing.JButton();
        borrarcolumna = new javax.swing.JButton();

        dialogo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cambia el nombre de las columnas y pulsa siguiente:");
        dialogo.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla2);

        dialogo.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, 90));

        jLabel2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel2.setText("Recuerda pulsar \"Enter\" para aplicar los nombres antes de pulsar en siguiente");
        dialogo.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 410, -1));

        siguiente.setText("Siguiente");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));

        dialogo2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("No hay ninguna columna seleccionada");
        dialogo2.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        dialogo2.getContentPane().add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        dialogo3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("No hay nada para limpiar");
        dialogo3.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 61, -1, -1));

        aceptar2.setText("Aceptar");
        aceptar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar2ActionPerformed(evt);
            }
        });
        dialogo3.getContentPane().add(aceptar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        dialogo4.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("No se ha introducido un nombre");
        dialogo4.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        aceptar4.setText("Aceptar");
        aceptar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar4ActionPerformed(evt);
            }
        });
        dialogo4.getContentPane().add(aceptar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        dialogo5.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("No quedan columnas");
        dialogo5.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        aceptar5.setText("Aceptar");
        aceptar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar5ActionPerformed(evt);
            }
        });
        dialogo5.getContentPane().add(aceptar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Filas y Columnas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Columna 1", "Columna 2", "Columna 3"
            }
        ));
        jScrollPane1.setViewportView(tabla1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 440, 200));

        añadirfila.setText("Añadir Fila");
        añadirfila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirfilaActionPerformed(evt);
            }
        });
        getContentPane().add(añadirfila, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        eliminarfila.setText("Eliminar Fila");
        eliminarfila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarfilaActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarfila, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, -1, -1));

        nuevacolumna.setText("Nueva Columna");
        nuevacolumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevacolumnaActionPerformed(evt);
            }
        });
        getContentPane().add(nuevacolumna, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));
        getContentPane().add(areanombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 270, -1));

        cambiarnombres.setText("Cambiar nombres de columnas");
        cambiarnombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarnombresActionPerformed(evt);
            }
        });
        getContentPane().add(cambiarnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, -1));

        borrarcolumna.setText("Borrar Columna");
        borrarcolumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarcolumnaActionPerformed(evt);
            }
        });
        getContentPane().add(borrarcolumna, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void añadirfilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirfilaActionPerformed
        modelotabla1.addRow(new Object[tabla1.getColumnCount()]);
    }//GEN-LAST:event_añadirfilaActionPerformed
    private void eliminarfilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarfilaActionPerformed
        try{
            modelotabla1.removeRow(tabla1.getSelectedRow());
        }catch(ArrayIndexOutOfBoundsException e){
            dialogo2.show();
        }
    }//GEN-LAST:event_eliminarfilaActionPerformed
    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        dialogo2.dispose();
    }//GEN-LAST:event_aceptarActionPerformed
    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        try{ 
           do{
            modelotabla1.removeRow(0);
            }while(modelotabla1.getRowCount()!=0);
       }catch(ArrayIndexOutOfBoundsException e){
           dialogo3.show();
       }
    }//GEN-LAST:event_limpiarActionPerformed
    private void aceptar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar2ActionPerformed
        dialogo3.dispose();
    }//GEN-LAST:event_aceptar2ActionPerformed
    private void nuevacolumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevacolumnaActionPerformed
        if ("".equals(areanombre.getText())){
            dialogo4.show();
        }else{
        modelotabla1.addColumn(areanombre.getText());        
        }
    }//GEN-LAST:event_nuevacolumnaActionPerformed
    private void aceptar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar4ActionPerformed
        dialogo4.dispose();
    }//GEN-LAST:event_aceptar4ActionPerformed
    private void borrarcolumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarcolumnaActionPerformed
        try{  
            modelotabla1.setColumnCount(modelotabla1.getColumnCount()-1);
        }catch(ArrayIndexOutOfBoundsException e){
            dialogo5.show();
        }
    }//GEN-LAST:event_borrarcolumnaActionPerformed
    private void aceptar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar5ActionPerformed
        dialogo5.dispose();
    }//GEN-LAST:event_aceptar5ActionPerformed
    private void cambiarnombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarnombresActionPerformed
        cambiarNombres();
    }//GEN-LAST:event_cambiarnombresActionPerformed
    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        cambiarIndices();
    }//GEN-LAST:event_siguienteActionPerformed
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
            java.util.logging.Logger.getLogger(TablaDinamica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaDinamica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaDinamica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaDinamica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaDinamica().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton aceptar2;
    private javax.swing.JButton aceptar4;
    private javax.swing.JButton aceptar5;
    private javax.swing.JTextField areanombre;
    private javax.swing.JButton añadirfila;
    private javax.swing.JButton borrarcolumna;
    private javax.swing.JButton cambiarnombres;
    private javax.swing.JDialog dialogo;
    private javax.swing.JDialog dialogo2;
    private javax.swing.JDialog dialogo3;
    private javax.swing.JDialog dialogo4;
    private javax.swing.JDialog dialogo5;
    private javax.swing.JButton eliminarfila;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton nuevacolumna;
    private javax.swing.JButton siguiente;
    private javax.swing.JTable tabla1;
    private javax.swing.JTable tabla2;
    // End of variables declaration//GEN-END:variables
}
