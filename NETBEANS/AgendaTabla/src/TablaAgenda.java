
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvar
 */
public class TablaAgenda extends javax.swing.JFrame {
    AgendaBD agenda;
    Contacto contacto;
    /**
     * Creates new form TablaAgenda
     */DefaultTableModel modelo;
    
 
       
       
    
    public TablaAgenda() {
        initComponents();
        agenda = new AgendaBD();
        rellenarListaDesplegable();
        generarTabla();
    }
    
    public void generarTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("Nombre");
         modelo.addColumn("Direccion");
          modelo.addColumn("Localidad");
           modelo.addColumn("Telefonos");
           modelo.addColumn("Correo");
           modelo.addColumn("Edad");
               tabla1.setModel(modelo);
    }
    public void agregarFila(){
        modelo.addRow(new Object[tabla1.getColumnCount()]);
    }


     public void rellenarListaDesplegable(){
        ResultSet res=agenda.obtenerRegistros("Contacto");
        if(res!=null){
            try{
                barraContactos.removeAllItems();
                while(res.next()){
                    barraContactos.addItem(res.getString("nombre"));
                }
            }catch(SQLException e){
                System.out.println("Error");
            }
        }
    }
    public void mostrarRegistro(){
        String nom = (String) barraContactos.getSelectedItem();
        Contacto contacto=agenda.obtenerContacto(nom);
        if(contacto!=null){
            nombre.setText(contacto.getNombre());
            direccion.setText(contacto.getDireccion());
            localidad.setText(contacto.getLocalidad());
            telefonos.setText(contacto.getTelefonos());
            correo.setText(contacto.getCorreo());
            edad.setText(""+contacto.getEdad());
        }
    }
    public void nuevo(){
        leerDatos();
        agenda.nuevoContacto(contacto);
        rellenarListaDesplegable();
        limpiarCampos();
    }
    public void borrar(){
        String nom=nombre.getText();
        //COMPROBAMOS SI EXISTE UN CONTACTO CON TAL NOMBRE
        contacto=agenda.obtenerContacto(nom);
        if(contacto==null){
            jDialog3.pack();
            jDialog3.setLocationRelativeTo(this);
            jDialog3.setVisible(true);
        }
        else{
            mostrarRegistro();
            jDialog2.pack();
            jDialog2.setLocationRelativeTo(this);
            jDialog2.setVisible(true);
        }
    }
    public void leerDatos(){
        String nom = nombre.getText();
        String dir = direccion.getText();
        String loc = localidad.getText();
        String tel = telefonos.getText();
        String email = correo.getText();
        int ed=0;
        try{
             ed = Integer.parseInt(edad.getText());
        }catch(NumberFormatException e){}
        contacto=new Contacto(nom, dir, loc, tel, email, ed);
    }
    public void limpiarCampos(){
        nombre.setText(null);
        direccion.setText(null);
        localidad.setText(null);
        telefonos.setText(null);
        correo.setText(null);
        edad.setText(null);
    }
    public void borrarRegistro(){
        String nom=nombre.getText();
        agenda.borrarContacto(nom);
        rellenarListaDesplegable();
        limpiarCampos();
        nombre.requestFocus();
    }
    public void grabar(){
        String nom=nombre.getText();
        contacto=agenda.obtenerContacto(nom);
        if(contacto==null){
            nuevoContacto();
        }else
            modificarContacto();
    }
    public void nuevoContacto(){
        leerDatos();
        agenda.nuevoContacto(contacto);
        rellenarListaDesplegable();
        limpiarCampos();
        nombre.requestFocus();
    }
    
    public void modificarContacto(){
        leerDatos();
        agenda.modificarContacto(contacto);
        limpiarCampos();
        nombre.requestFocus();
    }
    public void visualizarContactos(){
       ResultSet res= agenda.obtenerRegistros("Contacto");
       int fila=0;
       if(res!=null){
           try{
               while(res.next()){
                   agregarFila();
                   modelo.setValueAt(res.getString("Nombre"),fila ,0);
                   modelo.setValueAt(res.getString("Direccion"),fila ,1);
                   modelo.setValueAt(res.getString("Localidad"),fila ,2);
                   modelo.setValueAt(res.getString("Telefonos"),fila ,3);
                   modelo.setValueAt(res.getString("Correo"),fila ,4);
                   modelo.setValueAt(res.getString("Edad"),fila ,5);
                   
                   fila++;
                   
               }
           }catch(SQLException e){}
       }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        cerrar = new javax.swing.JButton();
        jDialog3 = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDialog1 = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        jDialog2 = new javax.swing.JDialog();
        jLabel9 = new javax.swing.JLabel();
        si = new javax.swing.JButton();
        no = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        barraContactos = new javax.swing.JComboBox();
        grabar = new javax.swing.JButton();
        visualizar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        localidad = new javax.swing.JTextField();
        telefonos = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        edad = new javax.swing.JTextField();

        dialogo.setMinimumSize(new java.awt.Dimension(900, 900));
        dialogo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Direccion", "Localidad", "Telefono", "E-Mail", "Edad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla1);

        dialogo.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 830, 140));

        cerrar.setText("Cerrar");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 280, -1, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("NO EXISTE ESE CONTACTO!!!");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jButton1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel10)
                .addGap(52, 52, 52)
                .addComponent(jButton1)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DEBEN DE ESTAR TODOS LOS CAMPOS RELLENADOS");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jLabel9.setText("¿Estas seguro que quieres borrar el contacto?");

        si.setText("SI");
        si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siActionPerformed(evt);
            }
        });

        no.setText("NO");
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(si)
                        .addGap(68, 68, 68)
                        .addComponent(no)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel9)
                .addGap(85, 85, 85)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(si)
                    .addComponent(no))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 900));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Seleccionar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        barraContactos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                barraContactosItemStateChanged(evt);
            }
        });
        getContentPane().add(barraContactos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 180, -1));

        grabar.setText("Grabar");
        grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarActionPerformed(evt);
            }
        });
        getContentPane().add(grabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));

        visualizar.setText("Visualizar");
        visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarActionPerformed(evt);
            }
        });
        getContentPane().add(visualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, -1, -1));

        borrar.setText("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        getContentPane().add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, -1, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del contacto"));

        jLabel2.setText("Nombre");

        jLabel3.setText("Dirección");

        jLabel4.setText("Localidad");

        jLabel5.setText("Telefonos");

        jLabel6.setText("Correo");

        jLabel7.setText("Edad");

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionActionPerformed(evt);
            }
        });

        localidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localidadActionPerformed(evt);
            }
        });

        telefonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonosActionPerformed(evt);
            }
        });

        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(direccion)
                    .addComponent(nombre)
                    .addComponent(localidad)
                    .addComponent(correo, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefonos, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(localidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(telefonos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barraContactosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_barraContactosItemStateChanged
        mostrarRegistro();
    }//GEN-LAST:event_barraContactosItemStateChanged

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        direccion.requestFocus();
    }//GEN-LAST:event_nombreActionPerformed

    private void direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionActionPerformed
        localidad.requestFocus();
    }//GEN-LAST:event_direccionActionPerformed

    private void localidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localidadActionPerformed
        telefonos.requestFocus();
    }//GEN-LAST:event_localidadActionPerformed

    private void telefonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonosActionPerformed
        correo.requestFocus();
    }//GEN-LAST:event_telefonosActionPerformed

    private void correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoActionPerformed
        edad.requestFocus();
    }//GEN-LAST:event_correoActionPerformed

    private void grabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarActionPerformed
        grabar();
    }//GEN-LAST:event_grabarActionPerformed

    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed
        visualizarContactos();
        dialogo.show();
    }//GEN-LAST:event_visualizarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        borrar();
    }//GEN-LAST:event_borrarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        // TODO add your handling code here:
        dialogo.dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jDialog3.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siActionPerformed
        jDialog2.setVisible(false);
        borrarRegistro();
        limpiarCampos();
        rellenarListaDesplegable();
    }//GEN-LAST:event_siActionPerformed

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
        jDialog2.setVisible(false);
        nombre.requestFocus();
    }//GEN-LAST:event_noActionPerformed

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
            java.util.logging.Logger.getLogger(TablaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox barraContactos;
    private javax.swing.JButton borrar;
    private javax.swing.JButton cerrar;
    private javax.swing.JTextField correo;
    private javax.swing.JDialog dialogo;
    private javax.swing.JTextField direccion;
    private javax.swing.JTextField edad;
    private javax.swing.JButton grabar;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField localidad;
    private javax.swing.JButton no;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton salir;
    private javax.swing.JButton si;
    private javax.swing.JTable tabla1;
    private javax.swing.JTextField telefonos;
    private javax.swing.JButton visualizar;
    // End of variables declaration//GEN-END:variables
}
