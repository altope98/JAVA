
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alvaro
 */
public class Agenda extends javax.swing.JFrame {
ArrayList<TPersona> coleccionpersona= new ArrayList<TPersona>();
    /**
     * Creates new form Agenda
     */
    public Agenda() {
        initComponents();
        choice.requestFocus();
    }

    public void nuevo(){
        try{
        TPersona persona=new TPersona();
        persona.setNombre(nombre.getText());
        persona.setDireccion(direccion.getText());
        persona.setEdad(Integer.parseInt(edad.getText()));
        persona.setTelefono(Integer.parseInt(telefono.getText()));
        coleccionpersona.add(persona);
        choice.addItem(persona.getNombre());
        nombre.setText(null);
        direccion.setText(null);
        edad.setText(null);
        telefono.setText(null);
        }catch(NumberFormatException e){
            dialogonum.show();
            edad.setText(null);
            telefono.setText(null);
        }
        
    }
    public void cambioItem(){
        TPersona personacomprobacion = new TPersona();
        personacomprobacion = coleccionpersona.get(choice.getSelectedIndex());
        nombre.setText(personacomprobacion.getNombre());
        direccion.setText(personacomprobacion.getDireccion());
        edad.setText(Integer.toString(personacomprobacion.getEdad()));
        telefono.setText(Integer.toString(personacomprobacion.getTelefono()));
        nombre.requestFocus();
    }
    public void borrar() {                                
        
        if (choice.getItemCount() > 0) {
            dialogoseguridad.show();
        }else{
            dialogoerrorborrar.show();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo3 = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        aceptar2 = new javax.swing.JButton();
        dialogoerrorborrar = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        aceptar3 = new javax.swing.JButton();
        dialogoseguridad = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        si = new javax.swing.JButton();
        no = new javax.swing.JButton();
        dialogo2 = new javax.swing.JDialog();
        jLabel11 = new javax.swing.JLabel();
        aceptar1 = new javax.swing.JButton();
        dialogonum = new javax.swing.JDialog();
        jLabel9 = new javax.swing.JLabel();
        cerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        choice = new javax.swing.JComboBox();
        borrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        edad = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        nuevo = new javax.swing.JButton();

        dialogo3.setMinimumSize(new java.awt.Dimension(500, 500));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Introduccion de los valores incorrecta");

        aceptar2.setText("Aceptar");
        aceptar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogo3Layout = new javax.swing.GroupLayout(dialogo3.getContentPane());
        dialogo3.getContentPane().setLayout(dialogo3Layout);
        dialogo3Layout.setHorizontalGroup(
            dialogo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogo3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogo3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aceptar2)
                .addGap(152, 152, 152))
        );
        dialogo3Layout.setVerticalGroup(
            dialogo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogo3Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(aceptar2)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        dialogoerrorborrar.setMinimumSize(new java.awt.Dimension(500, 500));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("No hay ningun elemento en la agenda");

        aceptar3.setText("Aceptar");
        aceptar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogoerrorborrarLayout = new javax.swing.GroupLayout(dialogoerrorborrar.getContentPane());
        dialogoerrorborrar.getContentPane().setLayout(dialogoerrorborrarLayout);
        dialogoerrorborrarLayout.setHorizontalGroup(
            dialogoerrorborrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoerrorborrarLayout.createSequentialGroup()
                .addGroup(dialogoerrorborrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogoerrorborrarLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7))
                    .addGroup(dialogoerrorborrarLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(aceptar3)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        dialogoerrorborrarLayout.setVerticalGroup(
            dialogoerrorborrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoerrorborrarLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel7)
                .addGap(47, 47, 47)
                .addComponent(aceptar3)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        dialogoseguridad.setMinimumSize(new java.awt.Dimension(500, 500));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("¿Desea eliminar el contacto?");

        si.setText("Si");
        si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siActionPerformed(evt);
            }
        });

        no.setText("No");
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogoseguridadLayout = new javax.swing.GroupLayout(dialogoseguridad.getContentPane());
        dialogoseguridad.getContentPane().setLayout(dialogoseguridadLayout);
        dialogoseguridadLayout.setHorizontalGroup(
            dialogoseguridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoseguridadLayout.createSequentialGroup()
                .addGroup(dialogoseguridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogoseguridadLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel10))
                    .addGroup(dialogoseguridadLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(si)
                        .addGap(109, 109, 109)
                        .addComponent(no)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        dialogoseguridadLayout.setVerticalGroup(
            dialogoseguridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoseguridadLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel10)
                .addGap(46, 46, 46)
                .addGroup(dialogoseguridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(si)
                    .addComponent(no)))
        );

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("Debe rellenar todos los campos");

        aceptar1.setText("Aceptar");
        aceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogo2Layout = new javax.swing.GroupLayout(dialogo2.getContentPane());
        dialogo2.getContentPane().setLayout(dialogo2Layout);
        dialogo2Layout.setHorizontalGroup(
            dialogo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogo2Layout.createSequentialGroup()
                .addGroup(dialogo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogo2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel11))
                    .addGroup(dialogo2Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(aceptar1)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        dialogo2Layout.setVerticalGroup(
            dialogo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogo2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel11)
                .addGap(31, 31, 31)
                .addComponent(aceptar1)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Compruebe edad o telefono");

        cerrar.setText("Cerrar");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogonumLayout = new javax.swing.GroupLayout(dialogonum.getContentPane());
        dialogonum.getContentPane().setLayout(dialogonumLayout);
        dialogonumLayout.setHorizontalGroup(
            dialogonumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogonumLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(dialogonumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogonumLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogonumLayout.createSequentialGroup()
                        .addComponent(cerrar)
                        .addGap(153, 153, 153))))
        );
        dialogonumLayout.setVerticalGroup(
            dialogonumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogonumLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(cerrar)
                .addGap(59, 59, 59))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccionar");

        choice.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceItemStateChanged(evt);
            }
        });

        borrar.setText("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Datos de contacto:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Dirección:");

        jLabel5.setText("Edad:");

        jLabel6.setText("Teléfono:");

        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreKeyReleased(evt);
            }
        });

        direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                direccionKeyReleased(evt);
            }
        });

        edad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edadActionPerformed(evt);
            }
        });
        edad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edadKeyReleased(evt);
            }
        });

        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addComponent(choice, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(borrar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(27, 27, 27)
                                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nuevo)))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(choice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        try{
            nuevo();
        }catch (IllegalArgumentException u)
        {
            dialogo2.show();
        }
    }//GEN-LAST:event_nuevoActionPerformed

    private void choiceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceItemStateChanged
        cambioItem();
    }//GEN-LAST:event_choiceItemStateChanged

    private void nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyReleased
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            direccion.requestFocus();
        }
    }//GEN-LAST:event_nombreKeyReleased

    private void direccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            edad.requestFocus();
        }
    }//GEN-LAST:event_direccionKeyReleased

    private void edadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edadKeyReleased
        // TODO add your handling code here:
       
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            telefono.requestFocus();
        }
        
        
    }//GEN-LAST:event_edadKeyReleased

    private void aceptar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar2ActionPerformed
        // TODO add your handling code here:
        dialogo3.dispose();
    }//GEN-LAST:event_aceptar2ActionPerformed

    private void aceptar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar3ActionPerformed
        // TODO add your handling code here:
        dialogoerrorborrar.dispose();
    }//GEN-LAST:event_aceptar3ActionPerformed

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
        // TODO add your handling code here:
        dialogoseguridad.dispose();
    }//GEN-LAST:event_noActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:
        borrar();
    }//GEN-LAST:event_borrarActionPerformed

    private void siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siActionPerformed
        // TODO add your handling code here:
        coleccionpersona.remove( choice.getSelectedIndex() );
             
        nombre.setText(null);
        direccion.setText(null);
        edad.setText(null);
        telefono.setText(null);
        nombre.requestFocus();
        choice.removeItem(choice.getSelectedItem());
        dialogoseguridad.dispose();
    }//GEN-LAST:event_siActionPerformed

    private void aceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aceptar1ActionPerformed

    private void edadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edadActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        // TODO add your handling code here:
        dialogonum.dispose();
        edad.requestFocus();
    }//GEN-LAST:event_cerrarActionPerformed

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
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar1;
    private javax.swing.JButton aceptar2;
    private javax.swing.JButton aceptar3;
    private javax.swing.JButton borrar;
    private javax.swing.JButton cerrar;
    private javax.swing.JComboBox choice;
    private javax.swing.JDialog dialogo2;
    private javax.swing.JDialog dialogo3;
    private javax.swing.JDialog dialogoerrorborrar;
    private javax.swing.JDialog dialogonum;
    private javax.swing.JDialog dialogoseguridad;
    private javax.swing.JTextField direccion;
    private javax.swing.JTextField edad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton no;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton nuevo;
    private javax.swing.JButton si;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
