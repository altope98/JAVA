
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
public class PorcentajeNotas extends javax.swing.JFrame {
int insuficiente=0,suficiente=0,bien=0,notable=0,sobresaliente=0;
    DefaultTableModel modelo;
    AlumnosBD alumnos;
    /**
     * Creates new form PorcentajeNotas
     */
    public PorcentajeNotas() {
        initComponents();
        alumnos=new AlumnosBD();
        modelo=new DefaultTableModel();
        rellenarListaCursos();
        rellenarListaEvaluacion();
    }

    public void rellenarListaCursos(){
        ResultSet resultado=alumnos.obtenerTabla("cursos","curso");
        //limpiarTabla();
        ccurso.removeAllItems();
        if(resultado!=null){
            try{
                while (resultado.next()){
                    ccurso.addItem(resultado.getString("curso"));
                }
            } catch(SQLException e){}
            ccurso.setSelectedIndex(0);
        } 
       
            
    }
     public void rellenarListaEvaluacion(){
         ResultSet resultado=alumnos.obtenerTabla("notas","evaluacion");
         cevaluacion.removeAllItems();
         if(resultado!=null){
            try{
                while (resultado.next()){
                    cevaluacion.addItem(resultado.getString("evaluacion"));
                }
            } catch(SQLException e){}
            
        }  
     }
     public void agregarFilaTabla(DefaultTableModel modelo) {
        Object [] fila = new Object[modelo.getColumnCount()];
        modelo.addRow(fila);
    }
     /*public void notas(){
         int insuficiente=0,suficiente=0,bien=0,notable=0,sobresaliente=0;
      for(int i=1;i<modelo.getColumnCount();i++){
        String curso=(String) ccurso.getSelectedItem();
        String evaluacion=(String) cevaluacion.getSelectedItem();
        String asignatura=(String) modelo.getColumnName(i);
        ResultSet res=alumnos.obtenerNotas(evaluacion, curso, asignatura);
        try{
            if(res!=null){
                while(res.next()){
                   Double nota=Double.parseDouble(res.getString("nota"));
                   
                    if(nota>=0 && nota<5){
                        insuficiente++;
                        modelo.setValueAt(insuficiente, 0, i);
                        
                    }
                    if(nota>=5 && nota<6){
                        suficiente++;
                        modelo.setValueAt(suficiente, 1, i);
                        
                    }
                    if(nota>=6 && nota<7){
                        bien++;
                        modelo.setValueAt(bien, 2, i);
                        
                    }
                    if(nota>=7 && nota<9){
                        notable++;
                        modelo.setValueAt(notable, 3, i);
                        
                    }
                    if(nota>=9 && nota<=10){
                        sobresaliente++;
                        modelo.setValueAt(sobresaliente, 1, i);
                        
                    }
                    
                }
            }
            
        }catch(SQLException e){}
        
        suficiente=0;
        insuficiente=0;
        bien=0;
        notable=0;
        sobresaliente=0;
      }  
      
     }*/
     /*public void generarTabla(){
       String curso=(String) ccurso.getSelectedItem();
        ResultSet res=alumnos.obtenerAsignaturas(curso);
         modelo.addColumn("");
         
        try{
            if(res!=null){
                while(res.next()){
                     modelo.addColumn(res.getString("asignatura"));    
                }
            }
        }catch(SQLException e){}
       for(int i=0;i<5;i++){
        agregarFilaTabla(modelo);
        
       }
       
       tabla.setModel(modelo);
        modelo.setValueAt("Insuficiente", 0, 0);
        modelo.setValueAt("Suficiente", 1, 0);
        modelo.setValueAt("Bien", 2, 0);
        modelo.setValueAt("Notable", 3, 0);
        modelo.setValueAt("Sobresaliente", 4, 0);
        
        for(int i=1;i<modelo.getColumnCount();i++){
         for(int j=0;j<modelo.getRowCount();j++){
             modelo.setValueAt("0", j, i);
         }
        }
        notas();*/
         
     
     
     
     
     public void notas(){
     
      for(int i=1;i<modelo.getColumnCount();i++){
        String curso=(String) ccurso.getSelectedItem();
        String evaluacion=(String) cevaluacion.getSelectedItem();
        String asignatura=(String) modelo.getColumnName(i);
        ResultSet res=alumnos.obtenerNotas(evaluacion, curso, asignatura);
        try{
            if(res!=null){
                while(res.next()){
                   Double nota=Double.parseDouble(res.getString("nota"));
                    if(nota>=0 && nota<5){
                        insuficiente++;
                        modelo.setValueAt(insuficiente, 0, i);
                        
                    }
                    if(nota>=5 && nota<6){
                        suficiente++;
                        modelo.setValueAt(suficiente, 1, i);
                        
                    }
                    if(nota>=6 && nota<7){
                        bien++;
                        modelo.setValueAt(bien, 2, i);
                        
                    }
                    if(nota>=7 && nota<9){
                        notable++;
                        modelo.setValueAt(notable, 3, i);
                        
                    }
                    if(nota>=9 && nota<=10){
                        sobresaliente++;
                        modelo.setValueAt(sobresaliente, 1, i);
                        
                    }
                    
                }
            }
            
        }catch(SQLException e){}
        
        suficiente=0;
        insuficiente=0;
        bien=0;
        notable=0;
        sobresaliente=0;
      }  
      
     }
         public void rellenarAsignatura(){
        String curso=(String) ccurso.getSelectedItem();
        ResultSet resultado=alumnos.obtenerAsignaturas(curso);
        modelo=new DefaultTableModel();
        modelo.addColumn(" ");
        
            try{
                if(resultado!=null){
                    while (resultado.next()){
                        modelo.addColumn(resultado.getString("asignatura"));
                    }
                }
            } catch(SQLException e){
               
            }
            
                
        for(int i =0; i<5;i++){
            agregarFilaTabla(modelo);
        }
        
    
        modelo.setValueAt("Insuficiente", 0, 0);
        modelo.setValueAt("Suficiente", 1, 0);
        modelo.setValueAt("Bien", 2, 0);
        modelo.setValueAt("Notable", 3, 0);
        modelo.setValueAt("Sobresaliente", 4, 0);
        tabla.setModel(modelo);
        
        for(int i=1;i<modelo.getColumnCount();i++){
            for(int j=0;j<modelo.getRowCount();j++){
                modelo.setValueAt("0",j,i);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ccurso = new javax.swing.JComboBox();
        cevaluacion = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        consultar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccion curso/evaluacion"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Curso:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 29, -1, -1));

        jLabel2.setText("Evaluación:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jPanel1.add(ccurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 120, -1));

        jPanel1.add(cevaluacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 690, 190));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estadistica notas"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        jPanel2.add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel2.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 80, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 550, 170));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 690, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        // TODO add your handling code here:
        //generarTabla();
        rellenarAsignatura();
        notas();
    }//GEN-LAST:event_consultarActionPerformed

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
            java.util.logging.Logger.getLogger(PorcentajeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PorcentajeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PorcentajeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PorcentajeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PorcentajeNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ccurso;
    private javax.swing.JComboBox cevaluacion;
    private javax.swing.JButton consultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
