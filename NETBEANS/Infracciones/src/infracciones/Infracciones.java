/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infracciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alvar
 */
public class Infracciones extends javax.swing.JFrame {
DefaultTableModel modelo;
    AgendaBD agenda;
    Coche coche;
    Multa multa;
    Infraccion infraccion;
    /**
     * Creates new form Infraccion
     */
    public Infracciones() {
        initComponents();
        agenda = new AgendaBD();
        rellenarListaDesplegable();
        generarTabla();
        
    }

     public void generarTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("Infraccion");
         modelo.addColumn("Fecha");
          modelo.addColumn("Penalizacion");
               tabla.setModel(modelo);
    }
    public void agregarFila(){
        modelo.addRow(new Object[tabla.getColumnCount()]);
    }
     public void rellenarListaDesplegable(){
        ResultSet res=agenda.obtenerRegistros("Coches");
        if(res!=null){
            try{
                barraContactos.removeAllItems();
                while(res.next()){
                    barraContactos.addItem(res.getString("nombre"));
                }
            }catch(SQLException e){
                System.out.println("Error");
            }
        }
    }
    public void mostrarRegistro(){
        String nombre = (String) barraContactos.getSelectedItem();
        Coche coche=agenda.obtenerCoche(nombre);
        if(coche!=null){
            areacoche.setText(coche.getNombreCoche());
            areamatricula.setText(coche.getMatricula());
            
        }
        
    }
    
     /*public void visualizarInfracciones(){
       ResultSet res= agenda.obtenerRegistros("infracciones");
       ResultSet res2= agenda.obtenerRegistros("multas");
       int fila=0;
       if(res!=null){
           try{
               while(res.next()){
                   agregarFila();
                   modelo.setValueAt(res.getString("Infraccion"),fila ,0);
                   
                   modelo.setValueAt(res.getString("Penalizacion"),fila ,2);
                 
                   fila++;
                   
               }
           }catch(SQLException e){}
       }
      fila=0;
       if(res2!=null){
           try{
               
               while(res2.next()){
                   
                   
                  modelo.setValueAt(res2.getString("Fecha"),fila ,1);
                  
                  
               }
           }catch(SQLException e){}
       }
       
    }*/
    
    public void visualizarInfracciones(){
       String matr=areamatricula.getText();
    ResultSet res= agenda.obtenerInfracciones(matr);
    int fila=0;
       if(res!=null){
           try{
               while(res.next()){
                   agregarFila();
                   modelo.setValueAt(res.getString("Infraccion"),fila ,0);
                   modelo.setValueAt(res.getString("Fecha"),fila ,1);
                   modelo.setValueAt(res.getString("Penalizacion"),fila ,2);
                   fila++;
                   
               }
           }catch(SQLException e){}
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        areacoche = new javax.swing.JTextField();
        areamatricula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        consoltar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        barraContactos = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Coche"));

        jLabel2.setText("Coche");

        jLabel3.setText("Matricula");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(areamatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(areacoche))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addComponent(areacoche))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(areamatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 370, 120));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Conductor");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Infraccion", "Fecha", "Penalizacion"
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 380, 160));

        consoltar.setText("Consultar");
        consoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consoltarActionPerformed(evt);
            }
        });
        getContentPane().add(consoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, -1, -1));

        barraContactos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                barraContactosItemStateChanged(evt);
            }
        });
        getContentPane().add(barraContactos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 190, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consoltarActionPerformed
        // TODO add your handling code here:
        visualizarInfracciones();
        
    }//GEN-LAST:event_consoltarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void barraContactosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_barraContactosItemStateChanged
        // TODO add your handling code here:
        mostrarRegistro();
        if(tabla.getRowCount()!=0)
        {
            modelo.setRowCount(0);
        }       
    }//GEN-LAST:event_barraContactosItemStateChanged

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
            java.util.logging.Logger.getLogger(Infracciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Infracciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Infracciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Infracciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Infracciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areacoche;
    private javax.swing.JTextField areamatricula;
    private javax.swing.JComboBox barraContactos;
    private javax.swing.JButton consoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}