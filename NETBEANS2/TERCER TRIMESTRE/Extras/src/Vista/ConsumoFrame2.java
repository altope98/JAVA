package Vista;

import Controlador.ConsumoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ConsumoFrame2 extends javax.swing.JFrame {
    DefaultTableModel modelotabla;
    ConsumoBD datos;
    public ConsumoFrame2() {
        initComponents();
        this.pack();
        datos=new ConsumoBD();
        generarTabla();
    }
    public void generarTabla(){
        modelotabla=new DefaultTableModel();
        modelotabla.addColumn("Articulo");
        modelotabla.addColumn("Barra");
        modelotabla.addColumn("Unidades");
        modelotabla.addColumn("PVP");
        modelotabla.addColumn("Importe");
        modelotabla.addColumn("Fecha");
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
        ResultSet res=datos.obtenerConsumosEntreFechas(desde,hasta);
        int fila=0;
        if(res!=null){
            try{
                while(res.next()){
                   agregarFila();
                   modelotabla.setValueAt(res.getString("articulo"),fila ,0);
                   modelotabla.setValueAt(res.getString("barra"), fila, 1);
                   modelotabla.setValueAt(res.getString("unidades"),fila ,2);
                   modelotabla.setValueAt(res.getString("pvp"),fila ,3);
                   double auximporte=(Double.parseDouble(tabla.getValueAt(fila, 3).toString())*Double.parseDouble(tabla.getValueAt(fila, 2).toString()));
                   modelotabla.setValueAt(auximporte, fila, 4);
                   modelotabla.setValueAt(res.getString("fecha"), fila, 5);
                   fila++;
               }
            }catch(SQLException e){}
        }
    }
    public void calculoImporte(){
        double totalimporte=0;
        for(int i=0;i<=modelotabla.getRowCount()-1;i++){
            Double valortabla=Double.parseDouble(tabla.getValueAt(i, 4).toString());
            totalimporte=totalimporte+valortabla;
        }
        importe.setText(totalimporte+" euros");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        areahasta = new javax.swing.JTextField();
        areadesde = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        consultar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        importe = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Desde (AAAA/MM/DD)");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel2.setText("Hasta (AAAA/MM/DD)");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));
        getContentPane().add(areahasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 140, -1));
        getContentPane().add(areadesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 140, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 630, 130));

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        getContentPane().add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, -1, -1));

        jLabel3.setText("Total importe");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, -1, -1));

        importe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        importe.setText("0");
        getContentPane().add(importe, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 60, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        eliminarFilas();
        consultar();
        calculoImporte();
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
            java.util.logging.Logger.getLogger(ConsumoFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsumoFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsumoFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsumoFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsumoFrame2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areadesde;
    private javax.swing.JTextField areahasta;
    private javax.swing.JButton consultar;
    private javax.swing.JLabel importe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
