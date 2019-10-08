
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvar
 */
public class Facturas extends javax.swing.JFrame {
        FacturasBD facturas;
        DefaultTableModel modelo;
        Date fechasistema;  
        double importetotal,ivatotal,facturatotal;
        String valorimporte;
    /**
     * Creates new form Facturas
     */
    public Facturas() {
        initComponents();
        facturas=new FacturasBD();
        modelo=new DefaultTableModel();
        generarTabla();
        fechasistema=new Date();
    }

    
    public void generarTabla(){
        modelo.addColumn("nº linea");
        modelo.addColumn("Articulo");
        modelo.addColumn("P.V.P.");
        modelo.addColumn("Unidades");
        modelo.addColumn("Importe");
        
        tabla.setModel(modelo);
    }
     public void agregarFila(){
        modelo.addRow(new Object[tabla.getColumnCount()]);
    }
    public void rellenarListaDesplegable(){
        
        ResultSet res=facturas.rellenarLista();
        
        if(res!=null){
             try{
                 while(res.next()){
                     combocliente.addItem(res.getString("cliente"));
                 }
             }catch(SQLException e){}
        }
        
    }
    public void nueva(){
        
        ResultSet res=facturas.obtenerFactura();
        if (res!=null){
            try{
                while(res.next()){
                    int factura=Integer.parseInt(res.getString("nFactura"))+1;
                    areafactura.setText(factura+"");
                }
            }catch(SQLException e){}
        }
        
        areafactura.setEditable(false);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        areafecha.setText(dateFormat.format(fechasistema));
         areafecha.requestFocus();
         añadirlinea.setEnabled(true);
       borrarlinea.setEnabled(true);
       grabar.setEnabled(true);
        limpiarTodo();
       rellenarListaDesplegable();
       combocliente.setSelectedIndex(0);
       tabla.setEnabled(true);
       
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
    
    public void cambiarCliente(){
        String nombre=(String) combocliente.getSelectedItem();
        ResultSet res= facturas.obtenerCliente(nombre);
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
    
    
    
    
    public void rellenarListaConsulta(){
        limpiarTodo();
        
        String factura=areafactura.getText();
        ResultSet res= facturas.rellenarLista(factura);
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
    }
    
    
    public void rellenarTablaConsulta(){
        String factura=areafactura.getText();
        String codigo=areacliente.getText();
        ResultSet res= facturas.rellenarTabla(factura,codigo);
        int fila=0;
         if(res!=null){
            try{
                while(res.next()){
                    agregarFila();
                    modelo.setValueAt(res.getString("nLinea"),fila,0);
                    modelo.setValueAt(res.getString("articulo"), fila, 1);
                    modelo.setValueAt(res.getString("pvp"), fila, 2);
                    modelo.setValueAt(res.getString("unidades"), fila, 3);
                    modelo.setValueAt(res.getString("importe"), fila, 4);
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
        ResultSet res= facturas.rellenarTotales(factura,codigo);
        
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
            linea++;}
    }
    
    public void calcularImporte(){
        for(int i=0;i<modelo.getRowCount();i++){
            if(modelo.getValueAt(i, 2)!=null && modelo.getValueAt(i, 3)!=null){
           double importe=(Integer.parseInt((String)modelo.getValueAt(i, 2)))*(Integer.parseInt((String)modelo.getValueAt(i, 3)));
           modelo.setValueAt(importe, i, 4);
        }
        }
        
        calcularTotales2();
        
    }
    
    
    public void calcularTotales2(){
        
        for(int i=0;i<modelo.getRowCount();i++){
            if(modelo.getValueAt(i, 4)!=null){
                valorimporte=(modelo.getValueAt(i, 4).toString());
                importetotal= importetotal+Double.parseDouble(valorimporte);
                 DecimalFormat df = new DecimalFormat("#.00");
                areaimporte.setText(df.format(importetotal)+"");
               ivatotal= importetotal/1.21;
                areaiva.setText(df.format(ivatotal)+"");
                facturatotal= importetotal+ivatotal ;
                areatotal.setText(df.format(facturatotal)+"");
                
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
        String importe2=areaimporte.getText();
        String iva=areaiva.getText();
        String total=areatotal.getText();
        
        facturas.insertarFactura(factura, fecha, codigo, importe2, iva, total);
        
        for(int i=0;i<modelo.getRowCount();i++){
            
                String linea=modelo.getValueAt(i,0).toString();
                String articulo=modelo.getValueAt(i, 1).toString();
                String pvp=modelo.getValueAt(i, 2).toString();
                String unidades=modelo.getValueAt(i, 3).toString();
                String importe1=modelo.getValueAt(i, 4).toString();
                
                facturas.insertarLineasFactura(factura, linea, articulo, unidades, pvp, importe1);
            
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

        jLabel1 = new javax.swing.JLabel();
        areafactura = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        areafecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        areacliente = new javax.swing.JTextField();
        combocliente = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        areanombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        areanif = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        areatelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        areaimporte = new javax.swing.JTextField();
        areatotal = new javax.swing.JTextField();
        areaiva = new javax.swing.JTextField();
        añadirlinea = new javax.swing.JButton();
        borrarlinea = new javax.swing.JButton();
        grabar = new javax.swing.JButton();
        consultar = new javax.swing.JButton();
        nueva = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Factura nº");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        areafactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areafacturaActionPerformed(evt);
            }
        });
        getContentPane().add(areafactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 150, -1));

        jLabel2.setText("Fecha");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));
        getContentPane().add(areafecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 150, -1));

        jLabel3.setText("Codigo cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        areacliente.setEditable(false);
        getContentPane().add(areacliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 150, -1));

        combocliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboclienteItemStateChanged(evt);
            }
        });
        getContentPane().add(combocliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 210, -1));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 520, 90));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 250, 520, 90));

        jLabel7.setText("Total importe");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        jLabel8.setText("Total factura");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));

        jLabel9.setText("Total IVA");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, -1));

        areaimporte.setEditable(false);
        getContentPane().add(areaimporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 110, -1));

        areatotal.setEditable(false);
        getContentPane().add(areatotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 110, -1));

        areaiva.setEditable(false);
        getContentPane().add(areaiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 120, -1));

        añadirlinea.setText("Añadir linea");
        añadirlinea.setEnabled(false);
        añadirlinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirlineaActionPerformed(evt);
            }
        });
        getContentPane().add(añadirlinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, -1, -1));

        borrarlinea.setText("Borrar linea");
        borrarlinea.setEnabled(false);
        borrarlinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarlineaActionPerformed(evt);
            }
        });
        getContentPane().add(borrarlinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, -1, -1));

        grabar.setText("Grabar factura");
        grabar.setEnabled(false);
        grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarActionPerformed(evt);
            }
        });
        getContentPane().add(grabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, -1, -1));

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        getContentPane().add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, -1));

        nueva.setText("Nueva");
        nueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaActionPerformed(evt);
            }
        });
        getContentPane().add(nueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, -1));

        salir.setText("Salir");
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaActionPerformed
        // TODO add your handling code here:
        nueva();
    }//GEN-LAST:event_nuevaActionPerformed

    private void comboclienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboclienteItemStateChanged
        // TODO add your handling code here:
        cambiarCliente();
    }//GEN-LAST:event_comboclienteItemStateChanged

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        // TODO add your handling code here:
        rellenarListaConsulta();
        rellenarTablaConsulta();
    }//GEN-LAST:event_consultarActionPerformed

    private void areafacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areafacturaActionPerformed
        // TODO add your handling code here:
        rellenarListaConsulta();
        rellenarTablaConsulta();
    }//GEN-LAST:event_areafacturaActionPerformed

    private void añadirlineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirlineaActionPerformed
        // TODO add your handling code here:
        añadirLinea();
        
        
    }//GEN-LAST:event_añadirlineaActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        calcularImporte();
        
        
    }//GEN-LAST:event_tablaMouseClicked

    private void borrarlineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarlineaActionPerformed
        // TODO add your handling code here:
        borrarLinea();
    }//GEN-LAST:event_borrarlineaActionPerformed

    private void grabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarActionPerformed
        // TODO add your handling code here:
        grabarFactura();
        
        
    }//GEN-LAST:event_grabarActionPerformed

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
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Facturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JButton grabar;
    private javax.swing.JLabel jLabel1;
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
