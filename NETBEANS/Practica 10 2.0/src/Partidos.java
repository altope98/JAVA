import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.lang.Thread;

/*
 @author alvar
 */
public class Partidos extends javax.swing.JFrame {
    DefaultTableModel modelo;
    BD bd;
    
    String codEquipo1="";
    String codEquipo2="";
    
    public Partidos() {
        initComponents();
        bd = new BD();
        rellenarListaDesplegable1();
        visualizarPartido();
        modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) tabla.getModel();
        
    }

    public void rellenarListaDesplegable1(){
        ResultSet res=bd.obtenerRegistros("JORNADAS");
        ResultSet res2=bd.obtenerRegistros("PARTIDOS");
        if(res!=null){
            try{
                combojornada.removeAllItems();
                while(res.next()){
                    combojornada.addItem(res.getString("jornada"));
                }
            }catch(SQLException e){
                System.out.println("Error");
            }
        }
        if(res2!=null){
            try{
                combopartido.removeAllItems();
                while(res2.next()){
                    combopartido.addItem(res2.getString("codigoPartido"));
                }
            }catch(SQLException e){
                System.out.println("Error");
            
                }
            }
        }
    
    public void visualizarPartido(){
       
       String jornada=(String) combojornada.getSelectedItem();
       String partido=(String) combopartido.getSelectedItem();
       ResultSet res= bd.obtenerFecha(jornada);
       ResultSet res2= bd.obtenerLocal(jornada,partido);
       ResultSet res3= bd.obtenerVisitante(jornada,partido);
       try{
             areafecha.setText(res.getString("fecha"));
             arealocal.setText(res2.getString("nombre"));
             areavisitante.setText(res3.getString("nombre"));
        }catch(SQLException e){}
        
    }
    public void visualizarCanastas(){      
        try{
            String jornada=(String) combojornada.getSelectedItem();
            String partido=(String) combopartido.getSelectedItem();
            
            ResultSet resultadocodigo=bd.obtenerCodigoEquipo(jornada, partido);
            ResultSet res= bd.obtenerResultados(jornada,partido,resultadocodigo.getString("codigoEquipo1"));
            System.out.println(res.getString("canastas1"));
            System.out.println(res.getString("intentos1"));
            int intentos=Integer.parseInt(res.getString("intentos1"));
            int canastas=Integer.parseInt(res.getString("canastas1"));
            double porcentaje=(canastas*100)/intentos;
            System.out.println(porcentaje);
            String porcentajeCanastas=String.valueOf(porcentaje)+"%";
     
            if (modelo==null){
                System.out.print("modelo nulooo");
            }
            modelo.setValueAt(porcentajeCanastas,0,0);
            
            intentos=Integer.parseInt(res.getString("intentos2"));
            canastas=Integer.parseInt(res.getString("canastas2"));
            porcentaje=(canastas*100)/intentos;
            System.out.println(porcentaje);
            porcentajeCanastas=String.valueOf(porcentaje)+"%";
            modelo.setValueAt(porcentajeCanastas,0,1);
            
            intentos=Integer.parseInt(res.getString("intentos3"));
            canastas=Integer.parseInt(res.getString("canastas3"));
            porcentaje=(canastas*100)/intentos;
            System.out.println(porcentaje);
            porcentajeCanastas=String.valueOf(porcentaje)+"%";
            modelo.setValueAt(porcentajeCanastas,0,2);
           
            ResultSet res2= bd.obtenerResultados(jornada,partido,resultadocodigo.getString("codigoEquipo2"));
            intentos=Integer.parseInt(res2.getString("intentos1"));
            canastas=Integer.parseInt(res2.getString("canastas1"));
            porcentaje=(canastas*100)/intentos;
            System.out.println(porcentaje);
            porcentajeCanastas=String.valueOf(porcentaje)+"%";
            modelo.setValueAt(porcentajeCanastas,1,0);
            
            intentos=Integer.parseInt(res2.getString("intentos2"));
            canastas=Integer.parseInt(res2.getString("canastas2"));
            porcentaje=(canastas*100)/intentos;
            System.out.println(porcentaje);
            porcentajeCanastas=String.valueOf(porcentaje)+"%";
            modelo.setValueAt(porcentajeCanastas,1,1);
            
            intentos=Integer.parseInt(res2.getString("intentos2"));
            canastas=Integer.parseInt(res2.getString("canastas2"));
            porcentaje=(canastas*100)/intentos;
            System.out.println(porcentaje);
            porcentajeCanastas=String.valueOf(porcentaje)+"%";
            modelo.setValueAt(porcentajeCanastas,1,2);
           }catch(SQLException e){} 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        combojornada = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        combopartido = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        areafecha = new javax.swing.JTextField();
        arealocal = new javax.swing.JTextField();
        areavisitante = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        salir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Jornada");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        combojornada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combojornadaItemStateChanged(evt);
            }
        });
        getContentPane().add(combojornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 90, -1));

        jLabel2.setText("Partido");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        combopartido.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combopartidoItemStateChanged(evt);
            }
        });
        getContentPane().add(combopartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 90, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Partido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Fecha");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel4.setText("Local");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel5.setText("Visitante");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));
        jPanel1.add(areafecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 110, -1));
        jPanel1.add(arealocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 100, -1));
        jPanel1.add(areavisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 380, 180));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Canastas de 1", "Canastas de 2", "Canastas de 3"
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 310, 410, 130));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, -1, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, -1, -1));

        jLabel6.setText("Local");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel7.setText("Visitante");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
    }//GEN-LAST:event_salirActionPerformed
    private void combojornadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combojornadaItemStateChanged
        visualizarPartido();
        visualizarCanastas();
       
    }//GEN-LAST:event_combojornadaItemStateChanged

    private void combopartidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combopartidoItemStateChanged
        visualizarPartido();
        //visualizarCanastas();
    }//GEN-LAST:event_combopartidoItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        visualizarCanastas();
    }//GEN-LAST:event_jButton1ActionPerformed
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
            java.util.logging.Logger.getLogger(Partidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Partidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Partidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Partidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Partidos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areafecha;
    private javax.swing.JTextField arealocal;
    private javax.swing.JTextField areavisitante;
    private javax.swing.JComboBox combojornada;
    private javax.swing.JComboBox combopartido;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
