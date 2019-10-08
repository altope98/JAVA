package Vista;
import Controlador.InfraccionesBD;
import Modelo.Coche;
import Modelo.Infraccion;
import Modelo.Multa;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
public class InfraccionesFrame3 extends javax.swing.JFrame {
    DefaultTableModel modelotabla;
    InfraccionesBD datos;
    Coche coche;
    Multa multa;
    Infraccion infraccion;
    public InfraccionesFrame3() {
        initComponents();
        this.pack();
        datos=new InfraccionesBD();
        generarTabla();
    }
    public void generarTabla(){
        modelotabla=new DefaultTableModel();
        modelotabla.addColumn("Infraccion");
        modelotabla.addColumn("Fecha");
        modelotabla.addColumn("Matricula");
        modelotabla.addColumn("Conductor");
        modelotabla.addColumn("Penalizacion");
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
    public void consultar(){
        String desde=areadesde.getText();
        String hasta=areahasta.getText();
        ResultSet res=datos.obtenerInfraccionesEntreFechas(desde,hasta);
        int fila=0;
        if(res!=null){
            try{
                while(res.next()){
                   agregarFila();
                   modelotabla.setValueAt(res.getString("infraccion"),fila ,0);
                   modelotabla.setValueAt(res.getString("fecha"),fila ,1);
                   modelotabla.setValueAt(res.getString("matricula"),fila ,2);
                   modelotabla.setValueAt(res.getString("nombre"),fila ,3);
                   modelotabla.setValueAt(res.getString("penalizacion"),fila ,4);
                   fila++;
               }
            }catch(SQLException e){}
        }
    }
    public void calculoPenalizacion(){
        double totalpenalizacion=0;
        for(int i=0;i<=modelotabla.getRowCount()-1;i++){
            Double valortabla=Double.parseDouble(tabla.getValueAt(i, 4).toString());
            totalpenalizacion=totalpenalizacion+valortabla;
        }
        penalizacion.setText(totalpenalizacion+"");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        areadesde = new javax.swing.JTextField();
        areahasta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        penalizacion = new javax.swing.JLabel();
        consultar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Desde (dd/mm/aa)");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 65, -1, -1));

        jLabel2.setText("Hasta (dd/mm/aa)");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, -1));
        getContentPane().add(areadesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 150, -1));
        getContentPane().add(areahasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 140, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 140, 600, 160));

        jLabel3.setText("Total penalización");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, -1, -1));

        penalizacion.setText("0");
        getContentPane().add(penalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 40, -1));

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        getContentPane().add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        eliminarFilas();
        consultar();
        calculoPenalizacion();
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
            java.util.logging.Logger.getLogger(InfraccionesFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfraccionesFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfraccionesFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfraccionesFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfraccionesFrame3().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areadesde;
    private javax.swing.JTextField areahasta;
    private javax.swing.JButton consultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel penalizacion;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
