package Vista;
import Controlador.AgendaBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
public class AgendaTablaFrame extends javax.swing.JFrame {
    protected AgendaBD datos;
    protected DefaultTableModel modelo;
    public AgendaTablaFrame() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        dialogo.pack();
        dialogo.setLocationRelativeTo(null);
        datos=new AgendaBD();
        generarTabla();
        rellenarListaDesplegable();
        areanombre.requestFocus();
    }
    public void rellenarListaDesplegable(){
        ResultSet res=datos.obtenerRegistros("Contacto");
        try{
            if(res!=null){
                while(res.next()){
                    combocontacto.addItem(res.getString("nombre"));
                }
            }
        }catch(SQLException e){}
        combocontacto.setSelectedIndex(0);
        
    }
    public void rellenarDatos(){
        String nombre=(String)combocontacto.getSelectedItem();
        for(int fila=0; fila<modelo.getRowCount(); fila++){
            for(int col=0; col<modelo.getColumnCount(); col++){
                if(modelo.getValueAt(fila, col).toString().equals(nombre)){
                    tabla.changeSelection(fila, col, false, false);
                }
            }
        }
        ResultSet res=datos.obtenerContacto(nombre);
        try{
            if(res!=null){
                while(res.next()){
                    areanombre.setText(res.getString("nombre"));
                    areadireccion.setText(res.getString("direccion"));
                    arealocalidad.setText(res.getString("localidad"));
                    areatelefonos.setText(res.getString("telefonos"));
                    areaemail.setText(res.getString("correo"));
                    areaedad.setText(res.getString("edad"));
                }
            }
        }catch(SQLException e){}
    }
    public void generarTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Localidad");
        modelo.addColumn("Telefonos");
        modelo.addColumn("E-mail");
        modelo.addColumn("Edad");
        ResultSet res=datos.obtenerRegistros("Contacto");
        int fila=0;
        try{
            if(res!=null){
                while(res.next()){
                    agregarFila();
                    modelo.setValueAt(res.getString("nombre"),fila,0);
                    modelo.setValueAt(res.getString("direccion"),fila,1);
                    modelo.setValueAt(res.getString("localidad"),fila,2);
                    modelo.setValueAt(res.getString("telefonos"),fila,3);
                    modelo.setValueAt(res.getString("correo"),fila,4);
                    modelo.setValueAt(res.getString("edad"),fila,5);
                    fila++;
                }
            }
        }catch(SQLException e){}
        tabla.setModel(modelo);
    }
    public void agregarFila(){
        modelo.addRow(new Object[tabla.getColumnCount()]);
    }
    public void eliminarFilas(){
        for(int i=modelo.getRowCount()-1; i>=0;i--){
            modelo.removeRow(i);
        }
    }
    public void limpiarTabla() {
        for(int fila=0; fila<modelo.getRowCount(); fila++){
            for(int col=1; col<modelo.getColumnCount(); col++){
                modelo.setValueAt("", fila, col);
            }
        }
    }
    public void cambiarCombo(){
        combocontacto.setSelectedItem(modelo.getValueAt(tabla.getSelectedRow(), 0));
    }
    public void nuevo(){
        combocontacto.setSelectedIndex(0);
        areanombre.setText(null);
        areatelefonos.setText(null);
        areaedad.setText(null);
        areaemail.setText(null);
        arealocalidad.setText(null);
        areadireccion.setText(null);
        areanombre.requestFocus();
    }
    public void borrarContacto(){
        String contacto=(String)combocontacto.getSelectedItem();
        datos.borrarContacto(contacto);
        combocontacto.removeItemAt(combocontacto.getSelectedIndex());
        combocontacto.setSelectedIndex(0);
        generarTabla();
    }
    public void comprobar(){
        String nombre=areanombre.getText();
        boolean condicion=false;
        ResultSet res=datos.obtenerRegistros("Contacto");
        try{
            if(res!=null){
                while(res.next()){
                    if(res.getString("nombre").equals(nombre))
                        condicion=true;
                }
            }
        }catch(SQLException e){}
        if (condicion){
            actualizar();
        }else{
            insertar();
        }
    }
    public void insertar(){
        String nombre=areanombre.getText();
        String direccion=areadireccion.getText();
        String localidad=arealocalidad.getText();
        String telefono=areatelefonos.getText();
        String correo=areaemail.getText();
        String edad=areaedad.getText();
        datos.grabarContaco(nombre, direccion, localidad, telefono, correo, edad);
        generarTabla();
        combocontacto.setSelectedIndex(0);
        
    }
    public void actualizar(){
        String contacto=(String)combocontacto.getSelectedItem();
        String nombre=areanombre.getText();
        String direccion=areadireccion.getText();
        String localidad=arealocalidad.getText();
        String telefono=areatelefonos.getText();
        String correo=areaemail.getText();
        String edad=areaedad.getText();
        datos.actualizarContaco(nombre, direccion, localidad, telefono, correo, edad,contacto);
        generarTabla();
        combocontacto.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        si = new javax.swing.JButton();
        no = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        combocontacto = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        areanombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        areadireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        arealocalidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        areaedad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        areatelefonos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        areaemail = new javax.swing.JTextField();
        nuevo = new javax.swing.JButton();
        grabar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        dialogo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("¿Seguro que quiere borrar el contacto?");
        dialogo.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 520, 50));

        si.setText("Si");
        si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(si, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 90, -1));

        no.setText("No");
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(no, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 80, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenimiento de contactos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Seleccionar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        combocontacto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combocontactoItemStateChanged(evt);
            }
        });
        getContentPane().add(combocontacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 240, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        jPanel1.add(areanombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 190, -1));

        jLabel3.setText("Direccion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        jPanel1.add(areadireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 190, -1));

        jLabel4.setText("Localidad");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        jPanel1.add(arealocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 190, -1));

        jLabel5.setText("Edad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        jPanel1.add(areaedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 60, -1));

        jLabel6.setText("Telefonos");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        jPanel1.add(areatelefonos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 190, -1));

        jLabel7.setText("E-mail");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));
        jPanel1.add(areaemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 330, 240));

        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        getContentPane().add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 70, -1));

        grabar.setText("Grabar");
        grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarActionPerformed(evt);
            }
        });
        getContentPane().add(grabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 70, -1));

        borrar.setText("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        getContentPane().add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 70, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 70, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void combocontactoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combocontactoItemStateChanged
        rellenarDatos();
    }//GEN-LAST:event_combocontactoItemStateChanged
    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_nuevoActionPerformed
    private void grabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarActionPerformed
        comprobar();
    }//GEN-LAST:event_grabarActionPerformed
    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        dialogo.show();
    }//GEN-LAST:event_borrarActionPerformed
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed
    private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
        cambiarCombo();
    }//GEN-LAST:event_tablaMousePressed
    private void siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siActionPerformed
        borrarContacto();
        dialogo.dispose();
    }//GEN-LAST:event_siActionPerformed
    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
        dialogo.dispose();
    }//GEN-LAST:event_noActionPerformed
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
            java.util.logging.Logger.getLogger(AgendaTablaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendaTablaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendaTablaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendaTablaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendaTablaFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areadireccion;
    private javax.swing.JTextField areaedad;
    private javax.swing.JTextField areaemail;
    private javax.swing.JTextField arealocalidad;
    private javax.swing.JTextField areanombre;
    private javax.swing.JTextField areatelefonos;
    private javax.swing.JButton borrar;
    private javax.swing.JComboBox combocontacto;
    private javax.swing.JDialog dialogo;
    private javax.swing.JButton grabar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton no;
    private javax.swing.JButton nuevo;
    private javax.swing.JButton salir;
    private javax.swing.JButton si;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
