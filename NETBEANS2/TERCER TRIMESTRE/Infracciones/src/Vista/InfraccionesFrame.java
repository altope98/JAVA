package Vista;
import Controlador.InfraccionesBD;
import Modelo.Coche;
import Modelo.Infraccion;
import Modelo.Multa;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
public class InfraccionesFrame extends javax.swing.JFrame {
    DefaultTableModel modelotabla;
    InfraccionesBD datos;
    Coche coche;
    Multa multa;
    Infraccion infraccion;
    public InfraccionesFrame() {
        initComponents();
        datos=new InfraccionesBD();
        rellenarListaDesplegable(); 
        generarTabla();
    }
    public void generarTabla(){
        modelotabla=new DefaultTableModel();
        modelotabla.addColumn("Infraccion");
        modelotabla.addColumn("Fecha");
        modelotabla.addColumn("Penalizacion");
        tabla.setModel(modelotabla);
    }
    public void rellenarListaDesplegable(){
        ResultSet res=datos.obtenerRegistros("Coches");
        if (res!=null) {
            try{
                comboconductor.removeAllItems();
                while(res.next()){
                    comboconductor.addItem(res.getString("nombre"));
                }
            }catch(SQLException e){
                System.out.println("Error");
            }
        }
    }
    public void mostrarDatos(){
        String nombre = (String) comboconductor.getSelectedItem();
        Coche coche=datos.obtenerCoche(nombre);
        if(coche!=null){
            areacoche.setText(coche.getModelo());
            areamatricula.setText(coche.getMatricula());
        }  
    }
    public void agregarFila(){
        modelotabla.addRow(new Object[tabla.getColumnCount()]);
    }
    public void eliminarFilas(){
        for(int i=modelotabla.getRowCount()-1; i>=0;i--){
            modelotabla.removeRow(i);
        }
    }
    public void visualizarInfracciones(){
        String matr=areamatricula.getText();
        ResultSet res=datos.obtenerInfracciones(matr);
        int fila=0;
        if(res!=null){
            try{
                while(res.next()){
                   agregarFila();
                   modelotabla.setValueAt(res.getString("infraccion"),fila ,0);
                   modelotabla.setValueAt(res.getString("fecha"),fila ,1);
                   modelotabla.setValueAt(res.getString("penalizacion"),fila ,2);
                   fila++;
               }
            }catch(SQLException e){}
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboconductor = new javax.swing.JComboBox();
        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        areacoche = new javax.swing.JTextField();
        areamatricula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        consultar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de multas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Conductor:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        comboconductor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboconductorItemStateChanged(evt);
            }
        });
        getContentPane().add(comboconductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 360, -1));

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos coche"));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Coche:");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel3.setText("Matrícula:");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        areacoche.setEditable(false);
        panel.add(areacoche, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 170, -1));

        areamatricula.setEditable(false);
        panel.add(areamatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 170, -1));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 470, 230));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Infraccion", "Fecha", "Penalización"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 470, 100));

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        getContentPane().add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, -1, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 550, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void comboconductorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboconductorItemStateChanged
        mostrarDatos();
    }//GEN-LAST:event_comboconductorItemStateChanged
    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        eliminarFilas();
        visualizarInfracciones();
    }//GEN-LAST:event_consultarActionPerformed
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed
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
            java.util.logging.Logger.getLogger(InfraccionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfraccionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfraccionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfraccionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfraccionesFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areacoche;
    private javax.swing.JTextField areamatricula;
    private javax.swing.JComboBox comboconductor;
    private javax.swing.JButton consultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
