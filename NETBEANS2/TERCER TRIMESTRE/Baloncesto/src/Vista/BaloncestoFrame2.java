package Vista;
import Controlador.BaloncestoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
public class BaloncestoFrame2 extends javax.swing.JFrame {
    BaloncestoBD datos;
    DefaultTableModel modelotablalocal, modelotablavisitante;
    String codEquipo1, codEquipo2;
    public BaloncestoFrame2() {
        initComponents();
        this.pack();
        datos=new BaloncestoBD();
        rellenarListaJornadas();
        generarTabla();
    }
    public void generarTabla(){
        modelotablalocal=new DefaultTableModel();
        modelotablavisitante=new DefaultTableModel();
        modelotablalocal.addColumn("Equipo local");
        modelotablalocal.addColumn("canastas de 1");
        modelotablalocal.addColumn("canastas de 2");
        modelotablalocal.addColumn("canastas de 3");
        modelotablavisitante.addColumn("Equipo visitante");
        modelotablavisitante.addColumn("canastas de 1");
        modelotablavisitante.addColumn("canastas de 2");
        modelotablavisitante.addColumn("canastas de 3");
        tablalocal.setModel(modelotablalocal);
        tablavisitante.setModel(modelotablavisitante);
    }
    public void agregarFilaTabla(DefaultTableModel modelo) {
        Object [] fila = new Object[modelo.getColumnCount()];
        modelo.addRow(fila);
    }
    public void eliminarFilas(){
        for(int i=modelotablalocal.getRowCount()-1; i>=0;i--){
            modelotablalocal.removeRow(i);
        }
        for(int i=modelotablavisitante.getRowCount()-1; i>=0;i--){
            modelotablavisitante.removeRow(i);
        }
    }
    public void rellenarListaJornadas(){
        ResultSet res=datos.obtenerTabla("Jornadas", "jornada");
        if(res!=null){
            try{
                while (res.next()){
                    combojornada.addItem(res.getString("jornada"));
                }
            } catch(SQLException e){}
            combojornada.setSelectedIndex(0);
        }        
    }
    public void mostrarFecha(){
        String jornada=(String) combojornada.getSelectedItem();
        ResultSet res=datos.fechaJornada(jornada);
        if(res!=null){
            try{
                while (res.next()){
                    areafecha.setText(res.getString("fecha"));
                }
            } catch(SQLException e){}
        }       
    }
    public void aceptar(){
        eliminarFilas();
        boolean local=true;
        int fila=0;
        String jornada=(String) combojornada.getSelectedItem();
        ResultSet res=datos.puntuacionesJornada("Puntuaciones", jornada);
        try{
            if(res!=null){
                while(res.next()){
                    int intentos1=res.getInt("intentos1");
                    int canastas1=res.getInt("canastas1");
                    int intentos2=res.getInt("intentos2");
                    int canastas2=res.getInt("canastas2");
                    int intentos3=res.getInt("intentos3");
                    int canastas3=res.getInt("canastas3");
                    String codEquipo=res.getString("codigoEquipo");
                    String equipo=datos.nombreEquipo(codEquipo);
                    if(local) {
                        agregarFilaTabla(modelotablalocal);
                        modelotablalocal.setValueAt(equipo,fila,0);
                        int por=canastas1*100/intentos1;
                        modelotablalocal.setValueAt("    "+por+" %",fila,1);
                        por=canastas2*100/intentos2;
                        modelotablalocal.setValueAt("    "+por+" %",fila,2);
                        por=canastas3*100/intentos3;
                        modelotablalocal.setValueAt("    "+por+" %",fila,3);
                        local=false;
                    } else {
                        agregarFilaTabla(modelotablavisitante);
                        modelotablavisitante.setValueAt(equipo,fila,0);
                        int por=canastas1*100/intentos1;
                        modelotablavisitante.setValueAt("    "+por+" %",fila,1);
                        por=canastas2*100/intentos2;
                        modelotablavisitante.setValueAt("    "+por+" %",fila,2);
                        por=canastas3*100/intentos3;
                        modelotablavisitante.setValueAt("    "+por+" %",fila++,3);
                        local=true;
                    }
                }
            }
        }catch(SQLException e){}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combojornada = new javax.swing.JComboBox();
        areafecha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalocal = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablavisitante = new javax.swing.JTable();
        aceptar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Esatdisticas de la jornada");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Jornada");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        jLabel2.setText("Fecha");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, -1, -1));

        combojornada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combojornadaItemStateChanged(evt);
            }
        });
        getContentPane().add(combojornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 150, -1));

        areafecha.setEditable(false);
        getContentPane().add(areafecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 160, -1));

        tablalocal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablalocal);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 240, 400, 90));

        tablavisitante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablavisitante);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 360, 90));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, -1, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        eliminarFilas();
        aceptar();
    }//GEN-LAST:event_aceptarActionPerformed
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed
    private void combojornadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combojornadaItemStateChanged
        mostrarFecha();
    }//GEN-LAST:event_combojornadaItemStateChanged
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
            java.util.logging.Logger.getLogger(BaloncestoFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaloncestoFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaloncestoFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaloncestoFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaloncestoFrame2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JTextField areafecha;
    private javax.swing.JComboBox combojornada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton salir;
    private javax.swing.JTable tablalocal;
    private javax.swing.JTable tablavisitante;
    // End of variables declaration//GEN-END:variables
}
