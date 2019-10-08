
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvar
 */
public class ExtraPartidos extends javax.swing.JFrame {
DefaultTableModel modelo,modelo2;
    BD bd;
    /**
     * Creates new form ExtraPartidos
     */
    public ExtraPartidos() {
        initComponents();
        bd = new BD();
        modelo = new DefaultTableModel();
        modelo2=new DefaultTableModel();
        rellenarListaDesplegable1();
        generarTabla1();
        generarTabla2();
    }
 public void generarTabla1(){
        modelo=new DefaultTableModel();
        modelo.addColumn("Local");
         modelo.addColumn("Canastas de 1");
          modelo.addColumn("Canastas de 2");
          modelo.addColumn("Canastas de 3");
               tabla1.setModel(modelo);
    }
    public void agregarFila1(){
        modelo.addRow(new Object[tabla1.getColumnCount()]);
    }
    public void generarTabla2(){
        modelo2=new DefaultTableModel();
        modelo2.addColumn("Visitante");
         modelo2.addColumn("Canastas de 1");
          modelo2.addColumn("Canastas de 2");
          modelo2.addColumn("Canastas de 3");
               tabla2.setModel(modelo2);
    }
    public void agregarFila2(){
        modelo2.addRow(new Object[tabla2.getColumnCount()]);
    }
    public void rellenarListaDesplegable1(){
        ResultSet res=bd.obtenerRegistros("JORNADAS");
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
        }
    public void visualizarFecha(){
       String jornada=(String) combojornada.getSelectedItem();
       ResultSet res= bd.obtenerFecha(jornada);
       try{
             areafecha.setText(res.getString("fecha"));
        }catch(SQLException e){}
    }
   
    
    
     public void visualizarCanastas(){      
        
            String jornada=(String) combojornada.getSelectedItem();
            ResultSet res= bd.obtenerPartidosLocal(jornada);
            ResultSet res2= bd.obtenerPartidosVisitante(jornada);
    int fila=0;
      
             fila=0;
                  try{
                      while(res.next()){
                          agregarFila1();
                          modelo.setValueAt(res.getString("codigoEquipo1"),fila,0);
                          fila++;
                      }
                  }catch(SQLException e){}
                  fila=0;
                  try{
                      while(res2.next()){
                          agregarFila2();
                          modelo2.setValueAt(res2.getString("codigoEquipo2"),fila,0);
                          fila++;
                      }
                  }catch(SQLException e){}
                  cuentasVisitante();
                  cuentasLocal();
            
    }
     
    public void cuentasLocal(){
        String jornada=(String) combojornada.getSelectedItem();
            ResultSet res= bd.obtenerPartidosLocal(jornada);
        
        try{ 
            while(res.next()){
            for(int i=0;i<modelo.getRowCount();i++){
            int intentos=Integer.parseInt(res.getString("intentos1"));
            int canastas=Integer.parseInt(res.getString("canastas1"));
            double porcentaje=(canastas*100)/intentos;
            System.out.println(porcentaje);
            String porcentajeCanastas=String.valueOf(porcentaje)+"%";
            modelo.setValueAt(porcentajeCanastas,i,1);
           
            intentos=Integer.parseInt(res.getString("intentos2"));
            canastas=Integer.parseInt(res.getString("canastas2"));
            porcentaje=(canastas*100)/intentos;
            System.out.println(porcentaje);
            porcentajeCanastas=String.valueOf(porcentaje)+"%";
            modelo.setValueAt(porcentajeCanastas,i,2);
            
            intentos=Integer.parseInt(res.getString("intentos3"));
            canastas=Integer.parseInt(res.getString("canastas3"));
            porcentaje=(canastas*100)/intentos;
            System.out.println(porcentaje);
            porcentajeCanastas=String.valueOf(porcentaje)+"%";
            modelo.setValueAt(porcentajeCanastas,i,3);
            }}
        } catch(SQLException e){}
    }

public void cuentasVisitante(){
    String jornada=(String) combojornada.getSelectedItem();
            ResultSet res2= bd.obtenerPartidosVisitante(jornada);
            
        try{ 
            while(res2.next()){
            for(int i=0;i<modelo2.getRowCount();i++){
            int intentos=Integer.parseInt(res2.getString("intentos1"));
            int canastas=Integer.parseInt(res2.getString("canastas1"));
            double porcentaje=(canastas*100)/intentos;
            System.out.println(porcentaje);
            String porcentajeCanastas=String.valueOf(porcentaje)+"%";
            modelo2.setValueAt(porcentajeCanastas,i,1);
           
            intentos=Integer.parseInt(res2.getString("intentos2"));
            canastas=Integer.parseInt(res2.getString("canastas2"));
            porcentaje=(canastas*100)/intentos;
            System.out.println(porcentaje);
            porcentajeCanastas=String.valueOf(porcentaje)+"%";
            modelo2.setValueAt(porcentajeCanastas,i,2);
            
            intentos=Integer.parseInt(res2.getString("intentos3"));
            canastas=Integer.parseInt(res2.getString("canastas3"));
            porcentaje=(canastas*100)/intentos;
            System.out.println(porcentaje);
            porcentajeCanastas=String.valueOf(porcentaje)+"%";
            modelo2.setValueAt(porcentajeCanastas,i,3);
            }}
        } catch(SQLException e){}
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
        combojornada = new javax.swing.JComboBox();
        areafecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Jornada");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        combojornada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combojornadaItemStateChanged(evt);
            }
        });
        getContentPane().add(combojornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 90, -1));

        areafecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(areafecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 150, 30));

        jLabel2.setText("Fecha");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Local", "Canastas de 1", "Canastas de 2", "Canastas de 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 100));

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Visitante", "Canastas de 1", "Canastas de 2", "Canastas de 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabla2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, -1, 100));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, -1, -1));

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combojornadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combojornadaItemStateChanged
        visualizarFecha();
        //visualizarCanastas();
        

    }//GEN-LAST:event_combojornadaItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        visualizarCanastas();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ExtraPartidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExtraPartidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExtraPartidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExtraPartidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExtraPartidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areafecha;
    private javax.swing.JComboBox combojornada;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla1;
    private javax.swing.JTable tabla2;
    // End of variables declaration//GEN-END:variables
}
