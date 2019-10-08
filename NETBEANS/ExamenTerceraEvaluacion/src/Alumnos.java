
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
public class Alumnos extends javax.swing.JFrame {
AlumnosBD alumnos;
    DefaultTableModel modelo;
    float sobresaliente,notable, bien, suficiente, insuficiente;
    boolean existe =false;
    int notas1;
    int sobresaliente1,notable1, bien1, suficiente1, insuficiente1;
    /**
     * Creates new form Alumnos
     */
    public Alumnos() {
        initComponents();
       alumnos = new AlumnosBD();
        rellenarListaCursos();
        rellenarListaEvaluaciones();
        rellenarListaAsignaturas();
        sobresaliente = 0;
        notable = 0;
        bien = 0;
        suficiente = 0;
        insuficiente = 0;
        sobresaliente1=0;
        notable1=0;
        suficiente1 = 0;
        insuficiente1 = 0;
        bien1 = 0;
        
    }
  public void rellenarListaCursos(){
        combocurso.removeAllItems(); // importante limpiar el combobox
        ResultSet resultado1=alumnos.obtenerTabla("cursos", "idCurso");
        if(resultado1!=null){ // comprobamos que ese objeto sea distinto de null para que no salga nada si por alguna razón no se cargue. 
            try{
                while (resultado1.next()){
                    combocurso.addItem(resultado1.getString("curso"));
                }
            } catch(SQLException e){}
            combocurso.setSelectedIndex(0);
        }   
    }
    
    public void rellenarListaEvaluaciones(){
        ResultSet resultado1=alumnos.obtenerTabla1("notas", "evaluacion");
        /*limpiarTabla();*/
        if(resultado1!=null){
            try{
                while (resultado1.next()){
                    comboevaluacion.addItem(resultado1.getString("evaluacion"));
                }
            } catch(SQLException e){}
            combocurso.setSelectedIndex(0);
        }   
    }
    public void rellenarListaAsignaturas(){
        String curso=(String) combocurso.getSelectedItem();
         ResultSet resultado1=alumnos.obtenerAsignaturas(curso);
         if(resultado1!=null){
            try{
                while (resultado1.next()){
                    comboasignatura.addItem(resultado1.getString("asignatura"));
                }
            } catch(SQLException e){}
            combocurso.setSelectedIndex(0);
        }   
    
}
     public void rellenarAsignatura(){
      
        
        modelo=new DefaultTableModel();
        modelo.addColumn(" ");
        modelo.addColumn("1º Evaluacion");
        modelo.addColumn("2º Evaluacion");
        modelo.addColumn("3º Evaluacion");
        modelo.addColumn("Evaluacion final");
            
               
            
            
                
        for(int i =0; i<5;i++){
            agregarFilaTabla();
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
    
    public void agregarFilaTabla() {
        Object [] fila = new Object[modelo.getColumnCount()];
        modelo.addRow(fila);
         }
    

    
    public void notas(){
     DecimalFormat df = new DecimalFormat("0.0");
     if (toda.isSelected()){
     for(int i=1;i<modelo.getColumnCount();i++){
        String curso=(String) combocurso.getSelectedItem();
        String evaluacion=(String) comboevaluacion.getSelectedItem();
        String asignatura=(String) comboasignatura.getSelectedItem();
        ResultSet res=alumnos.obtenerNotas(evaluacion, curso, asignatura);
        try{
            if(res!=null){
                while(res.next()){
                   Double nota=Double.parseDouble(res.getString("nota"));
                    if(nota>=0 && nota<5){
                        insuficiente++;
                        notas1++;
                        insuficiente1++;
                        
                    }
                    if(nota>=5 && nota<6){
                        suficiente++;
                        suficiente1++;
                        notas1++;
                    }
                    if(nota>=6 && nota<7){
                        bien++;
                        bien1++;
                        notas1++;
                    }
                    if(nota>=7 && nota<9){
                        notable++;
                        notable1++;
                        notas1++;
                    }
                    if(nota>=9 && nota<=10){
                        sobresaliente++;
                        sobresaliente1++;
                        notas1++;
                    }
                    modelo.setValueAt(insuficiente1+"--"+""+df.format(insuficiente*100/notas1)+ "%", 0, i);
                    modelo.setValueAt(suficiente1+"--"+""+df.format(suficiente*100/notas1)+ "%", 1, i);
                    modelo.setValueAt(bien1+"--"+""+df.format(bien*100/notas1)+ "%", 2, i);
                    modelo.setValueAt(notable1+"--"+""+df.format(notable*100/notas1)+ "%", 3, i);
                    modelo.setValueAt(sobresaliente1+"--"+""+df.format(sobresaliente*100/notas1)+ "%", 4, i);
                    
                    
                }
            }
            
        }catch(SQLException e){}
        
      }  
     }if(una.isSelected()){
         String curso=(String) combocurso.getSelectedItem();
        String evaluacion=(String) comboevaluacion.getSelectedItem();
        String asignatura=(String) comboasignatura.getSelectedItem();
        ResultSet res=alumnos.obtenerNotas(evaluacion, curso, asignatura);
        try{
            if(res!=null){
                while(res.next()){
                   Double nota=Double.parseDouble(res.getString("nota"));
                    if(nota>=0 && nota<5){
                        insuficiente++;
                        notas1++;
                        insuficiente1++;
                        
                    }
                    if(nota>=5 && nota<6){
                        suficiente++;
                        suficiente1++;
                        notas1++;
                    }
                    if(nota>=6 && nota<7){
                        bien++;
                        bien1++;
                        notas1++;
                    }
                    if(nota>=7 && nota<9){
                        notable++;
                        notable1++;
                        notas1++;
                    }
                    if(nota>=9 && nota<=10){
                        sobresaliente++;
                        sobresaliente1++;
                        notas1++;
                    }
                    int c=1;
                    if(comboevaluacion.getSelectedIndex()==0){
                        c=1;
                    }
                    if(comboevaluacion.getSelectedIndex()==1){
                        c=2;
                    }
                    if(comboevaluacion.getSelectedIndex()==2){
                        c=3;
                    }
                    if(comboevaluacion.getSelectedIndex()==3){
                        c=4;
                    }
                    modelo.setValueAt(insuficiente1+"--"+""+df.format(insuficiente*100/notas1)+ "%", 0, c);
                    modelo.setValueAt(suficiente1+"--"+""+df.format(suficiente*100/notas1)+ "%", 1, c);
                    modelo.setValueAt(bien1+"--"+""+df.format(bien*100/notas1)+ "%", 2, c);
                    modelo.setValueAt(notable1+"--"+""+df.format(notable*100/notas1)+ "%", 3, c);
                    modelo.setValueAt(sobresaliente1+"--"+""+df.format(sobresaliente*100/notas1)+ "%", 4, c);
                    
       }
            }
                }catch(SQLException e){}}
        suficiente=0;
        insuficiente=0;
        bien=0;
        notable=0;
        sobresaliente=0;
     }
    
    
    
    public void obtenerDatosChoice(){
        rellenarAsignatura();
        notas();
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
        combocurso = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        comboevaluacion = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        comboasignatura = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        toda = new javax.swing.JRadioButton();
        una = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        consultar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estadistica notas de una Asignatura");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccion asignatura/evaluacion"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Curso:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 29, -1, -1));

        jPanel1.add(combocurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 120, -1));

        jLabel2.setText("Evaluacion:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jPanel1.add(comboevaluacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 120, -1));

        jLabel3.setText("Asignaturas:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        jPanel1.add(comboasignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 160, -1));

        jLabel4.setText("Evalucaciones");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        toda.setSelected(true);
        toda.setText("Todas");
        jPanel1.add(toda, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, -1, -1));

        una.setText("Una");
        jPanel1.add(una, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 29, 680, 190));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estadisticas notas"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 120));

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        jPanel2.add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel2.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 690, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        // TODO add your handling code here:
        obtenerDatosChoice();
    }//GEN-LAST:event_consultarActionPerformed

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
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboasignatura;
    private javax.swing.JComboBox combocurso;
    private javax.swing.JComboBox comboevaluacion;
    private javax.swing.JButton consultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    private javax.swing.JRadioButton toda;
    private javax.swing.JRadioButton una;
    // End of variables declaration//GEN-END:variables
}
