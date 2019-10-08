
import static java.lang.System.exit;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author blanc
 */
public class Grafica extends javax.swing.JFrame {

    AlumnosBD alumnos;
    DefaultTableModel modelo;
    float sobresaliente,notable, bien, suficiente, insuficiente;
    boolean existe =false;
    int notas1;
    int sobresaliente1,notable1, bien1, suficiente1, insuficiente1;
    
    public Grafica() {
        initComponents();
        alumnos = new AlumnosBD();
        rellenarListaCursos();
        rellenarListaEvaluaciones();
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
        cbCurso.removeAllItems(); // importante limpiar el combobox
        ResultSet resultado1=alumnos.obtenerTabla("cursos", "idCurso");
        if(resultado1!=null){ // comprobamos que ese objeto sea distinto de null para que no salga nada si por alguna razón no se cargue. 
            try{
                while (resultado1.next()){
                    cbCurso.addItem(resultado1.getString("curso"));
                }
            } catch(SQLException e){}
            cbCurso.setSelectedIndex(0);
        }   
    }
    
    public void rellenarListaEvaluaciones(){
        ResultSet resultado1=alumnos.obtenerTabla1("notas", "evaluacion");
        /*limpiarTabla();*/
        if(resultado1!=null){
            try{
                while (resultado1.next()){
                    cbEvaluacion.addItem(resultado1.getString("evaluacion"));
                }
            } catch(SQLException e){}
            cbCurso.setSelectedIndex(0);
        }   
    }
    
    
    public void rellenarAsignatura(){
        String curso=(String) cbCurso.getSelectedItem();
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
            agregarFilaTabla();
        }
        
    
        modelo.setValueAt("Insuficiente", 0, 0);
        modelo.setValueAt("Suficiente", 1, 0);
        modelo.setValueAt("Bien", 2, 0);
        modelo.setValueAt("Notable", 3, 0);
        modelo.setValueAt("Sobresaliente", 4, 0);
        jTable1.setModel(modelo);
        
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
      for(int i=1;i<modelo.getColumnCount();i++){
        String curso=(String) cbCurso.getSelectedItem();
        String evaluacion=(String) cbEvaluacion.getSelectedItem();
        String asignatura=(String) modelo.getColumnName(i);
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
        cbCurso = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cbEvaluacion = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selección curso/evaluación"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Curso:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Evaluación:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estadística Notas"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton1)
                        .addGap(27, 27, 27)
                        .addComponent(jButton2)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        obtenerDatosChoice();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Grafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbCurso;
    private javax.swing.JComboBox cbEvaluacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
