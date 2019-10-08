/*
 * VentanaBaloncesto.java
 *
 * Created on 8 de abril de 2008, 13:02
 */

/**
 *
 * @author  manolo
 */
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class VentanaBaloncesto extends javax.swing.JFrame {
    BaloncestoBD baloncesto;
    DefaultTableModel modelo;
    String codEquipo1="";
    String codEquipo2="";
    
    public VentanaBaloncesto() {
        initComponents();
        baloncesto=new BaloncestoBD();
        generarTabla();
        rellenarListaJornadas();       
    }
    public void generarTabla(){
        modelo=new DefaultTableModel();
        jTable1.setModel(modelo);
        modelo.addColumn("canastas de 1");
        modelo.addColumn("canastas de 2");
        modelo.addColumn("canastas de 3");
        for(int i=1; i<=2; i++)
            agregarFilaTabla();
    }
    public void agregarFilaTabla() {
        Object [] fila = new Object[modelo.getColumnCount()];
        modelo.addRow(fila);
    }
    public void limpiarFilasTabla() {
        modelo.setRowCount(0);
    }
    public void limpiarTabla() {
        for(int fila=0; fila<2; fila++)
            for(int col=0; col<3; col++)
            modelo.setValueAt("", fila, col);
    } 
    public void rellenarListaJornadas(){
        ResultSet resultado=baloncesto.obtenerTabla("Jornadas", "jornada");
        limpiarTabla();
        if(resultado!=null){
            try{
                while (resultado.next()){
                    jComboBox1.addItem(resultado.getString("jornada"));
                }
            } catch(SQLException e){}
            jComboBox1.setSelectedIndex(0);
        }        
    }    
    public void rellenarListaPartidos() {
        String jornada=(String) jComboBox1.getSelectedItem();
        ResultSet resultado=baloncesto.partidosJornada(jornada);
        jComboBox2.removeAllItems();
        limpiarTabla();
        if(resultado != null) {
            try{
                while (resultado.next()){
                    jComboBox2.addItem(resultado.getString("codigoPartido" ));
                }
            } catch(SQLException e){}
            jComboBox2.setSelectedIndex(0);
        }      
    }
    public void visualizaDatosPartido(){
        limpiarTabla();
        String jornada=(String) jComboBox1.getSelectedItem();
        String partido=(String) jComboBox2.getSelectedItem();        
        ResultSet rs=baloncesto.obtenerPartido(jornada, partido);        
        if(rs!=null){
            try{
                if(rs.next()){                                
                    jTextField1.setText(rs.getString("fecha"));
                    codEquipo1=rs.getString("codigoEquipo1");
                    jTextField2.setText(baloncesto.nombreEquipo(codEquipo1));
                    codEquipo2=rs.getString("codigoEquipo2");
                    jTextField3.setText(baloncesto.nombreEquipo(codEquipo2));
                }
            } catch(SQLException e){}
        } 
    }
    public void estadistica(){
        String jornada=(String) jComboBox1.getSelectedItem();
        String partido=(String) jComboBox2.getSelectedItem();
        visualizaEstadistica(jornada, partido, codEquipo1, 0);
        visualizaEstadistica(jornada, partido, codEquipo2, 1);
    }
    public void visualizaEstadistica(String jornada, String partido, String codEquipo, int linea){
        ResultSet rs=baloncesto.puntuacionesPartido(jornada, partido, codEquipo);
        if(rs!=null){
            try{
                if(rs.next()){                    
                    modelo.setValueAt((rs.getInt("canastas1")*100)/(rs.getInt("intentos1"))+" %", linea, 0);
                    modelo.setValueAt((rs.getInt("canastas2")*100)/(rs.getInt("intentos2"))+" %", linea, 1);
                    modelo.setValueAt((rs.getInt("canastas3")*100)/(rs.getInt("intentos3"))+" %", linea, 2);
                }
            } catch(SQLException e){}
        }
    }
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estadísticas del partido");
        setMinimumSize(new java.awt.Dimension(550, 430));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Jornada");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(84, 26, 63, 15);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(159, 20, 75, 21);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Partido");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(298, 26, 54, 15);

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(371, 20, 75, 21);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos partido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("     Fecha ");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("     Local");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Visitante");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(84, 84, 84)
                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel4)
                        .add(33, 33, 33)
                        .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(9, 9, 9)
                        .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(13, 13, 13)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(1, 1, 1)
                        .add(jLabel3)))
                .add(28, 28, 28)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(1, 1, 1)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(55, 76, 460, 120);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "canastas de 1", "canastas de 2 ", "canastas de 3 "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(154, 218, 292, 60);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("   Local");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(76, 235, 57, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Visitante");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(86, 256, 64, 15);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 255));
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(360, 320, 82, 23);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 320, 110, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        visualizaDatosPartido();       
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        rellenarListaPartidos();        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        estadistica();
    }//GEN-LAST:event_jButton1ActionPerformed
               
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaBaloncesto().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
    
}
