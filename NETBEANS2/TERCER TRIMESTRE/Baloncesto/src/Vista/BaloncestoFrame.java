package Vista;
import Controlador.BaloncestoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
public class BaloncestoFrame extends javax.swing.JFrame {
    BaloncestoBD datos;
    DefaultTableModel modelotabla;
    String codEquipo1, codEquipo2;
    public BaloncestoFrame() {
        initComponents();
        this.pack();
        datos=new BaloncestoBD();
        rellenarListaJornadas();
        generarTabla();
    }
    public void generarTabla(){
        modelotabla=new DefaultTableModel();
        modelotabla.addColumn("canastas de 1");
        modelotabla.addColumn("canastas de 2");
        modelotabla.addColumn("canastas de 3");
        for(int i=1; i<=2; i++)
            agregarFila();
        tabla.setModel(modelotabla);
    }
    public void agregarFila(){
        modelotabla.addRow(new Object[tabla.getColumnCount()]);
    }
    public void eliminarFilas(){
        for(int i=modelotabla.getRowCount()-1; i>=0;i--){
            modelotabla.removeRow(i);
        }
    }
    public void limpiarTabla() {
        for(int fila=0; fila<2; fila++)
            for(int col=0; col<3; col++)
            modelotabla.setValueAt("", fila, col);
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
    public void rellenarListaPartidos() {
        String jornada=(String) combojornada.getSelectedItem();
        ResultSet res=datos.partidosJornada(jornada);
        combopartido.removeAllItems();
        if(res != null) {
            try{
                while (res.next()){
                    combopartido.addItem(res.getString("codigoPartido" ));
                }
            } catch(SQLException e){}
            combopartido.setSelectedIndex(0);
        }      
    }
    public void visualizarDatosPartido(){
        String jornada=(String) combojornada.getSelectedItem();
        String partido=(String) combopartido.getSelectedItem();        
        ResultSet res=datos.obtenerPartido(jornada, partido);        
        if(res!=null){
            try{
                if(res.next()){                                
                    areafecha.setText(res.getString("fecha"));
                    codEquipo1=res.getString("codigoEquipoLocal");
                    arealocal.setText(datos.nombreEquipo(codEquipo1));
                    codEquipo2=res.getString("codigoEquipoVisitante");
                    areavisitante.setText(datos.nombreEquipo(codEquipo2));
                }
            } catch(SQLException e){}
        } 
    }
    public void consultar(){
        String jornada=(String) combojornada.getSelectedItem();
        String partido=(String) combopartido.getSelectedItem();
        visualizarConsulta(jornada, partido, codEquipo1, 0);
        visualizarConsulta(jornada, partido, codEquipo2, 1);
    }
    public void visualizarConsulta(String jornada, String partido, String codEquipo, int linea){
        ResultSet res=datos.puntuacionesPartido(jornada, partido, codEquipo);
        if(res!=null){
            try{
                if(res.next()){                    
                    modelotabla.setValueAt((res.getInt("canastas1")*100)/(res.getInt("intentos1"))+" %", linea, 0);
                    modelotabla.setValueAt((res.getInt("canastas2")*100)/(res.getInt("intentos2"))+" %", linea, 1);
                    modelotabla.setValueAt((res.getInt("canastas3")*100)/(res.getInt("intentos3"))+" %", linea, 2);
                }
            } catch(SQLException e){}
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        combojornada = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        combopartido = new javax.swing.JComboBox();
        panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        areafecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        arealocal = new javax.swing.JTextField();
        areavisitante = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        consultar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estadisticas del partido");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Jornada");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        combojornada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combojornadaItemStateChanged(evt);
            }
        });
        getContentPane().add(combojornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 110, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Partido");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));

        combopartido.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combopartidoItemStateChanged(evt);
            }
        });
        getContentPane().add(combopartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 140, -1));

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de partido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 0, 255))); // NOI18N
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Fecha");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 47, -1, -1));

        areafecha.setEditable(false);
        panel.add(areafecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 120, -1));

        jLabel4.setText("Local");
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        arealocal.setEditable(false);
        panel.add(arealocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 120, -1));

        areavisitante.setEditable(false);
        panel.add(areavisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 130, -1));

        jLabel5.setText("Visitante");
        panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 620, 180));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 330, 410, 60));

        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Local");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Visitante");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, -1));

        consultar.setForeground(new java.awt.Color(0, 0, 255));
        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        getContentPane().add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, -1, 40));

        salir.setForeground(new java.awt.Color(0, 0, 255));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 482, -1, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        limpiarTabla();
        consultar();
    }//GEN-LAST:event_consultarActionPerformed
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed
    private void combojornadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combojornadaItemStateChanged
        rellenarListaPartidos();
    }//GEN-LAST:event_combojornadaItemStateChanged
    private void combopartidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combopartidoItemStateChanged
        visualizarDatosPartido();
    }//GEN-LAST:event_combopartidoItemStateChanged
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
            java.util.logging.Logger.getLogger(BaloncestoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaloncestoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaloncestoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaloncestoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaloncestoFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areafecha;
    private javax.swing.JTextField arealocal;
    private javax.swing.JTextField areavisitante;
    private javax.swing.JComboBox combojornada;
    private javax.swing.JComboBox combopartido;
    private javax.swing.JButton consultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
