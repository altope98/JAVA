
import javax.swing.table.DefaultTableModel;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvar
 */
public class EjercicioBaloncesto extends javax.swing.JFrame {
DefaultTableModel modelo;
BaloncestoBD baloncesto;
int suma1=0;
int suma2=0;
    
    /**
     * Creates new form EjercicioBaloncesto
     */
    public EjercicioBaloncesto() {
        initComponents();
        
        baloncesto=new BaloncestoBD();
        rellenarListaJornada();
        
        
        
    }

    
    public void generarTabla(){
        modelo.addColumn("Jornada");
        modelo.addColumn("Partido");
        modelo.addColumn("Equipo local");
        modelo.addColumn("Ptos equipo local");
        modelo.addColumn("Equipo visitante");
        modelo.addColumn("Ptos equipo visitante");
        modelo.addColumn("Equipo ganador");
        
        tabla.setModel(modelo);
        
        
        
    }
     public void agregarFila(){
        modelo.addRow(new Object[tabla.getColumnCount()]);
    }
    
    public void rellenarListaJornada(){
        ResultSet res=baloncesto.obtenerTabla("JORNADAS", "jornada");
        
        if(res!=null){
            try{
                while(res.next()){
                    
                    combojornada.addItem(res.getString("jornada"));
                }
                
            }catch(SQLException e){}
        }
    }
    
    public void cambiarFecha(){
        String jornada=(String)combojornada.getSelectedItem();
        
        ResultSet res=baloncesto.obtenerFecha(jornada);
        
         if(res!=null){
            try{
                while(res.next()){
                    
                    areafecha.setText(res.getString("fecha"));
                }
                
            }catch(SQLException e){}
        }
    }
    
    
    public void rellenarListaPartidos(){
        combopartido.removeAllItems();
        String jornada=(String)combojornada.getSelectedItem();
        ResultSet res=baloncesto.partidosJornada(jornada);
        
         if(res!=null){
            try{
                while(res.next()){
                    
                    combopartido.addItem(res.getString("codigoPartido"));
                }
                
            }catch(SQLException e){}
        }
    }
    

    
    public void ResultadosUna(){
        boolean local=true;
        int fila=0;
        String jornada=(String) combojornada.getSelectedItem();
        String partido=(String) combopartido.getSelectedItem();
        ResultSet resultado=baloncesto.puntuacionesJornada("Puntuaciones", "codigoJornada", jornada,partido);
        try{
            if(resultado!=null){
                while(resultado.next()){
   
                    int canastas1=resultado.getInt("canastas1");
                    int canastas2=resultado.getInt("canastas2");
                    int canastas3=resultado.getInt("canastas3");
                    int suma= canastas1+(canastas2*2)+(canastas3*3);
                    
                    String codEquipo=resultado.getString("codigoEquipo");
                    String equipo=baloncesto.nombreEquipo(codEquipo);
                    if(local==true) {
                        agregarFila();
                        
                        modelo.setValueAt(resultado.getString("codigoJornada"), fila, 0);
                        modelo.setValueAt(resultado.getString("codigoPartido"), fila, 1);
                        modelo.setValueAt(equipo,fila,2);
                        modelo.setValueAt(suma,fila,3);
                        
                        local=false;
                    } else {
                        modelo.setValueAt(equipo,fila,4);
                        modelo.setValueAt(suma,fila,5);
                        
                        local=true;
                    }
                }
            }
        }catch(SQLException e){}
        
        for(int i =0; i<modelo.getRowCount();i++){
            
            int suma1=Integer.parseInt(modelo.getValueAt(i, 3).toString());
            int suma2=Integer.parseInt(modelo.getValueAt(i, 5).toString());
            
            if(suma1>suma2){
                modelo.setValueAt(modelo.getValueAt(i, 2), i, 6);
            }else{
                modelo.setValueAt(modelo.getValueAt(i, 4), i, 6);
            }
            
            
        }
    }
    
    public void ResultadosToda(){
        
         boolean local=true;
        int fila=0;
        String partido=(String) combopartido.getSelectedItem();
        ResultSet resultado=baloncesto.puntuacionesJornadas(partido);
        try{
            if(resultado!=null){
                while(resultado.next()){
   
                    int canastas1=resultado.getInt("canastas1");
                    int canastas2=resultado.getInt("canastas2");
                    int canastas3=resultado.getInt("canastas3");
                    int suma= canastas1+(canastas2*2)+(canastas3*3);
                    
                    String codEquipo=resultado.getString("codigoEquipo");
                    String equipo=baloncesto.nombreEquipo(codEquipo);
                    if(local==true) {
                        agregarFila();
                        
                        modelo.setValueAt(resultado.getString("codigoJornada"), fila, 0);
                        modelo.setValueAt(resultado.getString("codigoPartido"), fila, 1);
                        modelo.setValueAt(equipo,fila,2);
                        modelo.setValueAt(suma,fila,3);
                        
                        local=false;
                    } else {
                        modelo.setValueAt(equipo,fila,4);
                        modelo.setValueAt(suma,fila,5);
                        
                        local=true;
                        fila++;
                    }
                    
                    canastas1=0;
                    canastas2=0;
                    canastas3=0;
                    suma=0;
                    
                }
            }
        }catch(SQLException e){}
        
        for(int i =0; i<modelo.getRowCount();i++){
            
            int suma1=Integer.parseInt(modelo.getValueAt(i, 3).toString());
            int suma2=Integer.parseInt(modelo.getValueAt(i, 5).toString());
            
            if(suma1>suma2){
                modelo.setValueAt(modelo.getValueAt(i, 2), i, 6);
            }else{
                modelo.setValueAt(modelo.getValueAt(i, 4), i, 6);
            }
            
            
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

        buttonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        combojornada = new javax.swing.JComboBox();
        combopartido = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        una = new javax.swing.JRadioButton();
        todas = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        consultar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        areafecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Jornada");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 58, -1, -1));

        combojornada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combojornadaItemStateChanged(evt);
            }
        });
        getContentPane().add(combojornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 120, -1));

        getContentPane().add(combopartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 120, -1));

        jLabel2.setText("Fecha");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        buttonGroup.add(una);
        una.setSelected(true);
        una.setText("Una jornada");
        una.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                unaItemStateChanged(evt);
            }
        });
        getContentPane().add(una, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, -1));

        buttonGroup.add(todas);
        todas.setText("Todas");
        todas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                todasItemStateChanged(evt);
            }
        });
        getContentPane().add(todas, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, -1, -1));

        jLabel3.setText("Partido");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

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
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 170, 940, 120));

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        getContentPane().add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));
        getContentPane().add(areafecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 200, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        // TODO add your handling code here:
        
        
        if(una.isSelected()){
        modelo=new DefaultTableModel();   
        generarTabla();
        ResultadosUna();}
        if(todas.isSelected()){
        modelo=new DefaultTableModel();    
        generarTabla();
        ResultadosToda();}
        
    }//GEN-LAST:event_consultarActionPerformed

    private void combojornadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combojornadaItemStateChanged
        // TODO add your handling code here:
        cambiarFecha();
        rellenarListaPartidos();
        
    }//GEN-LAST:event_combojornadaItemStateChanged

    private void todasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_todasItemStateChanged
        // TODO add your handling code here:
          modelo=new DefaultTableModel();   
        generarTabla();
    }//GEN-LAST:event_todasItemStateChanged

    private void unaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_unaItemStateChanged
        // TODO add your handling code here:
         modelo=new DefaultTableModel();   
        generarTabla();
    }//GEN-LAST:event_unaItemStateChanged

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
            java.util.logging.Logger.getLogger(EjercicioBaloncesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EjercicioBaloncesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EjercicioBaloncesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EjercicioBaloncesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EjercicioBaloncesto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areafecha;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JComboBox combojornada;
    private javax.swing.JComboBox combopartido;
    private javax.swing.JButton consultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    private javax.swing.JRadioButton todas;
    private javax.swing.JRadioButton una;
    // End of variables declaration//GEN-END:variables
}
