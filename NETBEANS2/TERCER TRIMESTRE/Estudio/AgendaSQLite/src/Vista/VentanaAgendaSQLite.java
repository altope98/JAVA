package Vista;
import Controlador.AgendaBD;
import Modelo.Contacto;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class VentanaAgendaSQLite extends javax.swing.JFrame {
    private AgendaBD agenda;
    private ArrayList <Contacto> contactos;
    private ResultSet res;
    private DefaultTableModel modeloContactos;
    
    public VentanaAgendaSQLite() {
        agenda = new AgendaBD();
        initComponents();
        rellenarListaDesplegable();
        this.setLocationRelativeTo(null);  
        bModificar.setEnabled(false);
        bBorrar.setEnabled(false);
        generarTabla();
        tfNombre.requestFocus();
    }
    public void generarTabla() {
        modeloContactos = new DefaultTableModel();
        modeloContactos.addColumn("Nombre");
        modeloContactos.addColumn("Direccion");
        modeloContactos.addColumn("Localidad");
        modeloContactos.addColumn("Telefonos");
        modeloContactos.addColumn("e-mail");
        modeloContactos.addColumn("Edad");
        tablaContactos.setModel(modeloContactos);        
    }
    public void agregarFila(){               
        Object[] fila = new Object[modeloContactos.getColumnCount()];
        modeloContactos.addRow(fila);            
    }
    public void limpiarFilas(){
        modeloContactos.setRowCount(0);
    }
    /*public void rellenarListaDesplegable() {
       // Utilizando un objeto ResultSet
       cbNombres.removeAllItems();
       res = agenda.obtenerContactos();
       if(res!=null) {
           try{
              while(res.next())
                  cbNombres.addItem(res.getString("nombre"));
           }catch(SQLException e){}
       }
    }*/   
    public void rellenarListaDesplegable() {
        // Utilizando un objeto ArrayList de objetos Contacto
        cbNombres.removeAll();
        contactos = agenda.obtenerContactos();
        if(contactos!=null)
            for(int i = 0; i < contactos.size(); i++)
                cbNombres.addItem(contactos.get(i).getNombre());
    }
    public void visualizarContacto() {
        String nom = (String) cbNombres.getSelectedItem();
        if(nom!=null){
            Contacto contacto = agenda.obtenerContacto(nom);
            if(contacto!=null){
                tfNombre.setText(contacto.getNombre());
                tfDireccion.setText(contacto.getDireccion());
                tfTelefonos.setText(contacto.getTelefonos());
                tfEdad.setText("" + contacto.getEdad());
            }
        }
    }
    public void nuevoContacto(){
        String nom;
        if(tfNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe rellenar este campo");
            tfNombre.requestFocus();
            return;
        } else
              nom = tfNombre.getText();        
        String dir = tfDireccion.getText();
        int edad=0;
        try{
            edad = Integer.parseInt(tfEdad.getText());
        }catch(NumberFormatException e){
           JOptionPane.showMessageDialog(null, "Edad incorrecta");
           tfEdad.setText(null);
           tfEdad.requestFocus();
           return;
        }
        String tlf = tfTelefonos.getText();
        Contacto contacto = new Contacto(nom, dir, tlf, edad);
        agenda.nuevoContacto(contacto);                
    }
    public void modificarContacto() {
        String nom = cbNombres.getSelectedItem();
        String dir = tfDireccion.getText();
        int edad=0;
        try{
            edad = Integer.parseInt(tfEdad.getText());
        }catch(NumberFormatException e){
           JOptionPane.showMessageDialog(null, "Edad incorrecta");
           tfEdad.setText(null);
           tfEdad.requestFocus();
           return;
        }
        String tlf = tfTelefonos.getText();
        Contacto contacto = new Contacto(nom, dir, tlf, edad);
        agenda.guardarContacto(contacto);
    }
    public void borrar() {
        dialogoConfirmar.setSize(370, 150);
        dialogoConfirmar.setLocationRelativeTo(this); 
        dialogoConfirmar.setVisible(true);
    }
    public void borrarContacto() {
        String nom = tfNombre.getText();
        agenda.borrarContacto(nom);
        rellenarListaDesplegable();
        limpiar();
        tfNombre.requestFocus();
    }
    public void limpiar() {
        limpiarCampos();
        bNuevo.setEnabled(true);
        bModificar.setEnabled(false);
        bBorrar.setEnabled(false);
        tfNombre.setEditable(true);       
        tfNombre.requestFocus();
    }
    public void limpiarCampos(){
        tfNombre.setText(null);
        tfDireccion.setText(null);
        tfEdad.setText(null);
        tfTelefonos.setText(null);
    }
    public void visualizaContacto(Contacto contacto){
        tfNombre.setText(contacto.getNombre());
        tfDireccion.setText(contacto.getDireccion());
        tfTelefonos.setText(contacto.getTelefonos());
        tfEdad.setText("" + contacto.getEdad());
    }
    public void primerContacto(){
        Contacto contacto = agenda.primerContacto();
        if(contacto!=null)
            visualizaContacto(contacto);
    }
    public void ultimoContacto(){
        Contacto contacto = agenda.ultimoContacto();
        if(contacto!=null)
            visualizaContacto(contacto);
    }
    public void siguienteContacto() {
        String nom=tfNombre.getText();
        Contacto contacto = agenda.siguienteContacto(nom);
        if(contacto!=null)
            visualizaContacto(contacto);
    }
    public void anteriorContacto(){
        String nom=tfNombre.getText();
        Contacto contacto = agenda.anteriorContacto(nom);
        if(contacto!=null)
            visualizaContacto(contacto);
    }
    public void visualizarContactos() {
        rellenarTablaContactos();
        dialogoVisualizarTabla.setSize(600, 400);
        dialogoVisualizarTabla.setLocation(300, 300);
        dialogoVisualizarTabla.setVisible(true);
    }
    public void rellenarTablaContactos() {
        Contacto contacto=null;
        contactos = agenda.obtenerContactos();
        if(contactos!=null) 
            for(int fila=0; fila<contactos.size(); fila++){
                contacto = contactos.get(fila);
                agregarFila();
                modeloContactos.setValueAt(contacto.getNombre(), fila, 0);
                modeloContactos.setValueAt(contacto.getDireccion(), fila, 1);
                modeloContactos.setValueAt(contacto.getLocalidad(), fila, 2);
                modeloContactos.setValueAt(contacto.getTelefonos(), fila, 3);
                modeloContactos.setValueAt(contacto.getCorreo(), fila, 4);
                modeloContactos.setValueAt(contacto.getEdad(), fila, 5);                
            }
    }
    public void habilitarBotones() {
        bNuevo.setEnabled(false);
        bModificar.setEnabled(true);
        bBorrar.setEnabled(true);
        tfNombre.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogoConfirmar = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        bSi = new javax.swing.JButton();
        bNo = new javax.swing.JButton();
        dialogoVisualizarTabla = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaContactos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfDireccion = new javax.swing.JTextField();
        tfEdad = new javax.swing.JTextField();
        tfTelefonos = new javax.swing.JTextField();
        bModificar = new javax.swing.JButton();
        bNuevo = new javax.swing.JButton();
        bBorrar = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        bLimpiar = new javax.swing.JButton();
        cbNombres = new java.awt.Choice();
        bPrimero = new javax.swing.JButton();
        bAnterior = new javax.swing.JButton();
        bSiguiente = new javax.swing.JButton();
        bUltimo = new javax.swing.JButton();
        bVisualizar = new javax.swing.JButton();

        dialogoConfirmar.getContentPane().setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("¿Estas seguro?: ");
        dialogoConfirmar.getContentPane().add(jLabel6);
        jLabel6.setBounds(55, 45, 110, 20);

        bSi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bSi.setLabel("SI");
        bSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiActionPerformed(evt);
            }
        });
        dialogoConfirmar.getContentPane().add(bSi);
        bSi.setBounds(180, 40, 45, 23);

        bNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bNo.setLabel("NO");
        bNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNoActionPerformed(evt);
            }
        });
        dialogoConfirmar.getContentPane().add(bNo);
        bNo.setBounds(250, 40, 49, 23);

        dialogoVisualizarTabla.setTitle("Tabla contactos");
        dialogoVisualizarTabla.setModal(true);

        tablaContactos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaContactos);

        javax.swing.GroupLayout dialogoVisualizarTablaLayout = new javax.swing.GroupLayout(dialogoVisualizarTabla.getContentPane());
        dialogoVisualizarTabla.getContentPane().setLayout(dialogoVisualizarTablaLayout);
        dialogoVisualizarTablaLayout.setHorizontalGroup(
            dialogoVisualizarTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        dialogoVisualizarTablaLayout.setVerticalGroup(
            dialogoVisualizarTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Agenda");
        setMinimumSize(new java.awt.Dimension(550, 500));
        getContentPane().setLayout(null);

        jLabel1.setText("Seleccionar ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(91, 45, 70, 14);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del contacto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel2.setText("Nombre");

        jLabel3.setText("Direccion");

        jLabel4.setText("Edad");

        jLabel5.setText("Telefonos");

        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        tfDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDireccionActionPerformed(evt);
            }
        });

        tfEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEdadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfNombre)
                    .addComponent(tfDireccion)
                    .addComponent(tfEdad)
                    .addComponent(tfTelefonos, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfTelefonos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(59, 85, 445, 250);

        bModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bModificar.setText("Modificar");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });
        getContentPane().add(bModificar);
        bModificar.setBounds(150, 360, 89, 23);

        bNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bNuevo.setText("Nuevo");
        bNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(bNuevo);
        bNuevo.setBounds(60, 360, 80, 23);

        bBorrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bBorrar.setText("Borrar");
        bBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(bBorrar);
        bBorrar.setBounds(250, 360, 71, 23);

        bSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });
        getContentPane().add(bSalir);
        bSalir.setBounds(420, 360, 59, 23);

        bLimpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bLimpiar.setText("Limpiar");
        bLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(bLimpiar);
        bLimpiar.setBounds(330, 360, 77, 23);

        cbNombres.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNombresItemStateChanged(evt);
            }
        });
        getContentPane().add(cbNombres);
        cbNombres.setBounds(190, 40, 190, 20);

        bPrimero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bPrimero.setLabel(" |<  ");
        bPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPrimeroActionPerformed(evt);
            }
        });
        getContentPane().add(bPrimero);
        bPrimero.setBounds(40, 420, 65, 25);

        bAnterior.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bAnterior.setLabel(" <<");
        bAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(bAnterior);
        bAnterior.setBounds(120, 420, 59, 25);

        bSiguiente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bSiguiente.setLabel(" >>");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(bSiguiente);
        bSiguiente.setBounds(190, 420, 60, 25);

        bUltimo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bUltimo.setLabel(" >|");
        bUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUltimoActionPerformed(evt);
            }
        });
        getContentPane().add(bUltimo);
        bUltimo.setBounds(260, 420, 60, 25);

        bVisualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bVisualizar.setLabel("Visualizar contactos");
        bVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVisualizarActionPerformed(evt);
            }
        });
        getContentPane().add(bVisualizar);
        bVisualizar.setBounds(330, 420, 160, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        tfDireccion.requestFocus();
    }//GEN-LAST:event_tfNombreActionPerformed

    private void tfDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDireccionActionPerformed
        tfEdad.requestFocus();
    }//GEN-LAST:event_tfDireccionActionPerformed

    private void tfEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEdadActionPerformed
        tfTelefonos.requestFocus();
    }//GEN-LAST:event_tfEdadActionPerformed

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
        nuevoContacto();        
        rellenarListaDesplegable();
        limpiarCampos();
        tfNombre.requestFocus();
    }//GEN-LAST:event_bNuevoActionPerformed

    private void bLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_bLimpiarActionPerformed

    private void cbNombresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNombresItemStateChanged
        visualizarContacto();
        tfNombre.setEditable(false);        
        habilitarBotones();
        tfDireccion.requestFocus();
    }//GEN-LAST:event_cbNombresItemStateChanged

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        modificarContacto();
        limpiarCampos();
        tfNombre.requestFocus();
    }//GEN-LAST:event_bModificarActionPerformed

    private void bBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarActionPerformed
        borrar();
    }//GEN-LAST:event_bBorrarActionPerformed

    private void bNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNoActionPerformed
       dialogoConfirmar.setVisible(false);
    }//GEN-LAST:event_bNoActionPerformed

    private void bSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiActionPerformed
        borrarContacto();
        habilitarBotones();
    }//GEN-LAST:event_bSiActionPerformed

    private void bPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPrimeroActionPerformed
        primerContacto();
        habilitarBotones();
    }//GEN-LAST:event_bPrimeroActionPerformed

    private void bUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUltimoActionPerformed
        ultimoContacto();
        habilitarBotones();
    }//GEN-LAST:event_bUltimoActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        siguienteContacto();
        habilitarBotones();
    }//GEN-LAST:event_bSiguienteActionPerformed

    private void bAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnteriorActionPerformed
        anteriorContacto();
    }//GEN-LAST:event_bAnteriorActionPerformed

    private void bVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVisualizarActionPerformed
        visualizarContactos();
    }//GEN-LAST:event_bVisualizarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bSalirActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAgendaSQLite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAgendaSQLite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAgendaSQLite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAgendaSQLite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAgendaSQLite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAnterior;
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bLimpiar;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bNo;
    private javax.swing.JButton bNuevo;
    private javax.swing.JButton bPrimero;
    private javax.swing.JButton bSalir;
    private javax.swing.JButton bSi;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JButton bUltimo;
    private javax.swing.JButton bVisualizar;
    private java.awt.Choice cbNombres;
    private javax.swing.JDialog dialogoConfirmar;
    private javax.swing.JDialog dialogoVisualizarTabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaContactos;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfEdad;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfTelefonos;
    // End of variables declaration//GEN-END:variables
}
