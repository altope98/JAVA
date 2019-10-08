package Vista;
import Controlador.FacturasBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Facturas extends javax.swing.JFrame {
    FacturasBD datos;
    DefaultTableModel modelo;
    Date fecha;  
    double importetotal,ivatotal,facturatotal;
    String valorimporte;
    public Facturas() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.pack();
        datos=new FacturasBD();
        modelo=new DefaultTableModel();
        fecha=new Date();
        generarTabla();
        rellenarListaClientes();
        dialogo.pack();
        dialogo.setLocationRelativeTo(null);
    }
    public void rellenarListaClientes(){
        ResultSet res= datos.rellenarLista();
        if (res!=null){
            try{
                while(res.next()){
                    combocliente.addItem(res.getString("cliente"));
                }
            }catch(SQLException e){}
        }
    }
    public void generarTabla(){
        modelo.addColumn("Nº linea");
        modelo.addColumn("Articulo");
        modelo.addColumn("P.V.P");
        modelo.addColumn("Unidades");
        modelo.addColumn("Importe");
        tabla.setModel(modelo);
    }
    public void agregarFila(){
        modelo.addRow(new Object[tabla.getColumnCount()]);
    }
    public void nuevaFactura(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        areafecha.setText(dateFormat.format(fecha));
        areafecha.requestFocus();
        ResultSet res=datos.obtenerFactura();
        if (res!=null){
            try{
                while(res.next()){
                    int factura=Integer.parseInt(res.getString("nFactura"))+1;
                    areafactura.setText(factura+"");
                }
            }catch(SQLException e){}
        }
        areafactura.setEditable(false);
        añadirlinea.setEnabled(true);
        borrarlinea.setEnabled(true);
        grabar.setEnabled(true);
        limpiarTodo();
        rellenarListaClientes();
        combocliente.setSelectedIndex(0);
        tabla.setEnabled(true);
        consultar.setEnabled(false);
    }
    public void limpiarTodo(){
       for(int i=tabla.getRowCount()-1; i >= 0; i--){
        modelo.removeRow(i);
       }
       areaimporte.setText(null);
       areaiva.setText(null);
       areatotal.setText(null);
       combocliente.removeAllItems();
    }
    public void limpiar(){
        areafactura.setText(null);
        areafecha.setText(null);
        combocliente.setSelectedIndex(0);
        areaiva.setText(null);
        areatotal.setText(null);
        areaimporte.setText(null);
        for(int i=0;i<modelo.getRowCount();i++){
            modelo.removeRow(i);
        }
        consultar.setEnabled(true);
    }
    public void cambiarCliente(){
        String nombre=(String) combocliente.getSelectedItem();
        ResultSet res= datos.obtenerCliente(nombre);
        if(res!=null){
            try{
                while(res.next()){
                    areanif.setText(res.getString("nif"));
                    areacliente.setText(res.getString("codCliente"));
                    areatelefono.setText(res.getString("telefono"));
                    areanombre.setText(res.getString("cliente"));
                }
            }catch(SQLException e){}
        } 
    }
    public void consultar(){
        limpiarTodo();
        String factura=areafactura.getText();
        ResultSet res= datos.rellenarLista(factura);
        if(res!=null){
            try{
                while(res.next()){
                   combocliente.addItem(res.getString("cliente"));
                   areafecha.setText(res.getString("fecha"));
                }
            }catch(SQLException e){}
        }
        combocliente.setSelectedIndex(0);
        areafecha.setEditable(false);
        cambiarCliente();
        String codigo=areacliente.getText();
        ResultSet res2=datos.rellenarTabla(factura,codigo);
        int fila=0;
         if(res2!=null){
            try{
                while(res2.next()){
                    agregarFila();
                    modelo.setValueAt(res2.getString("nLinea"),fila,0);
                    modelo.setValueAt(res2.getString("articulo"), fila, 1);
                    modelo.setValueAt(res2.getString("pvp"), fila, 2);
                    modelo.setValueAt(res2.getString("unidades"), fila, 3);
                    modelo.setValueAt(res2.getString("importe"), fila, 4);
                    fila++;
                }
            }catch(SQLException e){}
        }
        tabla.setEnabled(false);
        calcularTotales();
    }
    public void calcularTotales(){
        String factura=areafactura.getText();
        String codigo=areacliente.getText();
        ResultSet res= datos.rellenarTotales(factura,codigo);
         if(res!=null){
            try{
                while(res.next()){
                   areaimporte.setText(res.getString("importe"));
                   areaiva.setText(res.getString("iva"));
                   areatotal.setText(res.getString("total"));
                }
            }catch(SQLException e){}
        }
    }
    public void añadirLinea(){ 
        agregarFila();
        numeroLinea();
        calcularImporte();
    }
    public void numeroLinea(){
        int linea=1;
        for(int i=0;i<modelo.getRowCount();i++){
            modelo.setValueAt(linea, i, 0);
            linea++;
        }
    }
    public void calcularImporte(){
        for(int i=0;i<modelo.getRowCount();i++){
            if(modelo.getValueAt(i, 2)!=null && modelo.getValueAt(i, 3)!=null){
                double importe=(Integer.parseInt((String)modelo.getValueAt(i, 2)))*(Integer.parseInt((String)modelo.getValueAt(i, 3)));
                modelo.setValueAt(importe, i, 4);
            }
        }
        calcularTotalesTabla();
    }
    public void calcularTotalesTabla(){
        for(int i=0;i<modelo.getRowCount();i++){
            if(modelo.getValueAt(i, 4)!=null){
                valorimporte=(modelo.getValueAt(i, 4).toString());
                importetotal= importetotal+Double.parseDouble(valorimporte);
                areaimporte.setText((importetotal)+"");
                ivatotal= importetotal/1.21;
                areaiva.setText((ivatotal)+"");
                facturatotal= importetotal+ivatotal;
                areatotal.setText((facturatotal)+"");
            }
        }
        importetotal=0;
        ivatotal=0;
        facturatotal=0; 
    } 
    public void borrarLinea(){
        modelo.removeRow(tabla.getSelectedRow());
        numeroLinea();
    }
    public void grabarFactura(){
        String factura=areafactura.getText();
        String codigo=areacliente.getText();
        String fecha=areafecha.getText();
        String importe1=areaimporte.getText();
        String iva=areaiva.getText();
        String total=areatotal.getText();
        datos.insertarFactura(factura, fecha, codigo, importe1, iva, total);
        for(int i=0;i<modelo.getRowCount();i++){
                String linea=modelo.getValueAt(i,0).toString();
                String articulo=modelo.getValueAt(i, 1).toString();
                String pvp=modelo.getValueAt(i, 2).toString();
                String unidades=modelo.getValueAt(i, 3).toString();
                String importe2=modelo.getValueAt(i, 4).toString();
                datos.insertarLineasFactura(factura, linea, articulo, unidades, pvp, importe2);
        }
        limpiar();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        areafactura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        areacliente = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        areanombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        areanif = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        areatelefono = new javax.swing.JTextField();
        combocliente = new javax.swing.JComboBox();
        areafecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        consultar = new javax.swing.JButton();
        nueva = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        areaiva = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        areaimporte = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        areatotal = new javax.swing.JTextField();
        añadirlinea = new javax.swing.JButton();
        borrarlinea = new javax.swing.JButton();
        grabar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("No se ha seleccionado ninguna fila o no hay filas que borrar");

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogoLayout = new javax.swing.GroupLayout(dialogo.getContentPane());
        dialogo.getContentPane().setLayout(dialogoLayout);
        dialogoLayout.setHorizontalGroup(
            dialogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel10)
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aceptar)
                .addGap(273, 273, 273))
        );
        dialogoLayout.setVerticalGroup(
            dialogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel10)
                .addGap(69, 69, 69)
                .addComponent(aceptar)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areafactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areafacturaActionPerformed(evt);
            }
        });

        jLabel1.setText("Factura nº");

        jLabel3.setText("Codigo cliente");

        areacliente.setEditable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Clientes"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        areanombre.setEditable(false);
        jPanel1.add(areanombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 120, -1));

        jLabel5.setText("N.I.F.");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        areanif.setEditable(false);
        jPanel1.add(areanif, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 160, -1));

        jLabel6.setText("Telefono");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        areatelefono.setEditable(false);
        jPanel1.add(areatelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 120, -1));

        combocliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboclienteItemStateChanged(evt);
            }
        });

        jLabel2.setText("Fecha");

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });

        nueva.setText("Nueva");
        nueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        areaiva.setEditable(false);

        jLabel9.setText("Total IVA");

        areaimporte.setEditable(false);

        jLabel7.setText("Total importe");

        jLabel8.setText("Total factura");

        areatotal.setEditable(false);

        añadirlinea.setText("Añadir linea");
        añadirlinea.setEnabled(false);
        añadirlinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirlineaActionPerformed(evt);
            }
        });

        borrarlinea.setText("Borrar linea");
        borrarlinea.setEnabled(false);
        borrarlinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarlineaActionPerformed(evt);
            }
        });

        grabar.setText("Grabar factura");
        grabar.setEnabled(false);
        grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.setEnabled(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(areafactura, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(areacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(areafecha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(combocliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(areaimporte, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(areatotal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(añadirlinea)
                                        .addGap(70, 70, 70)
                                        .addComponent(borrarlinea)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addComponent(grabar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(areaiva, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(consultar)
                    .addComponent(nueva)
                    .addComponent(salir))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(areafactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(areafecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(consultar))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(areacliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nueva)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salir)
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(areaimporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(areaiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areatotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añadirlinea)
                    .addComponent(borrarlinea)
                    .addComponent(grabar))
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void areafacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areafacturaActionPerformed
        consultar();
    }//GEN-LAST:event_areafacturaActionPerformed
    private void comboclienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboclienteItemStateChanged
        cambiarCliente();
    }//GEN-LAST:event_comboclienteItemStateChanged
    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        consultar();
    }//GEN-LAST:event_consultarActionPerformed
    private void nuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaActionPerformed
        nuevaFactura();
    }//GEN-LAST:event_nuevaActionPerformed
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed
    private void añadirlineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirlineaActionPerformed
        añadirLinea();
    }//GEN-LAST:event_añadirlineaActionPerformed
    private void borrarlineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarlineaActionPerformed
        try{
            borrarLinea();
        }catch(ArrayIndexOutOfBoundsException e){
            dialogo.show();
        }
    }//GEN-LAST:event_borrarlineaActionPerformed
    private void grabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarActionPerformed
        grabarFactura();
    }//GEN-LAST:event_grabarActionPerformed
    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        calcularImporte();
    }//GEN-LAST:event_tablaMouseClicked
    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        dialogo.dispose();
    }//GEN-LAST:event_aceptarActionPerformed
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
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Facturas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JTextField areacliente;
    private javax.swing.JTextField areafactura;
    private javax.swing.JTextField areafecha;
    private javax.swing.JTextField areaimporte;
    private javax.swing.JTextField areaiva;
    private javax.swing.JTextField areanif;
    private javax.swing.JTextField areanombre;
    private javax.swing.JTextField areatelefono;
    private javax.swing.JTextField areatotal;
    private javax.swing.JButton añadirlinea;
    private javax.swing.JButton borrarlinea;
    private javax.swing.JComboBox combocliente;
    private javax.swing.JButton consultar;
    private javax.swing.JDialog dialogo;
    private javax.swing.JButton grabar;
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
    private javax.swing.JButton nueva;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
