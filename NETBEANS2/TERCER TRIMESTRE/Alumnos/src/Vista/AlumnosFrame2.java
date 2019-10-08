package Vista;
import Controlador.AlumnosBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
public class AlumnosFrame2 extends javax.swing.JFrame {
    AlumnosBD datos;
    DefaultTableModel modelo;
    float sobresaliente,notable, bien, suficiente, insuficiente;
    int notas1;
    int sobresaliente1,notable1, bien1, suficiente1, insuficiente1;
    public AlumnosFrame2() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        datos=new AlumnosBD();
        rellenarListaCursos();
        rellenarListaEvaluaciones();
    }
    public void rellenarListaCursos(){
        ResultSet res=datos.obtenerRegistros("cursos");
        if(res != null) {
                try{
                    while (res.next()){
                        combocurso.addItem(res.getString("curso"));
                    }
                } catch(SQLException e){}
        }
    }
    public void rellenarListaEvaluaciones(){
        ResultSet res=datos.obtenerRegistrosAgrupados("notas","evaluacion");
        if(res != null) {
                try{
                    while (res.next()){
                        comboevaluacion.addItem(res.getString("evaluacion"));
                    }
                } catch(SQLException e){}
        }
        comboevaluacion.setSelectedIndex(0);
    }
    public void generarTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("");
        ResultSet res=datos.obtenerAsignaturas(combocurso.getSelectedItem().toString());
        if(res != null) {
                try{
                    while (res.next()){
                        modelo.addColumn(res.getString("asignatura"));
                    }
                } catch(SQLException e){}
        }
        for (int i=1;i<=5;i++){
            agregarFila();
            switch (i){
                case 1:modelo.setValueAt("Insuficiente", i-1, 0);break;
                case 2:modelo.setValueAt("Suficiente", i-1, 0);break;
                case 3:modelo.setValueAt("Bien", i-1, 0);break;
                case 4:modelo.setValueAt("Notable", i-1, 0);break;
                case 5:modelo.setValueAt("Sobresaliente", i-1, 0);break;
            }
        }
        tabla.setModel(modelo);
    }
    public void agregarFila(){
        modelo.addRow(new Object[tabla.getColumnCount()]);
    }
    public void eliminarFilas(){
        for(int i=modelo.getRowCount()-1; i>=0;i--){
            modelo.removeRow(i);
        }
    }
    public void limpiarTabla() {
        for(int fila=0; fila<modelo.getRowCount(); fila++){
            for(int col=1; col<modelo.getColumnCount(); col++){
                modelo.setValueAt("", fila, col);
            }
        }
    }
    public void consultar(){
        generarTabla();
        limpiarTabla();
        DecimalFormat df = new DecimalFormat("0.0");
        for(int i=1;i<modelo.getColumnCount();i++){
            String curso=(String) combocurso.getSelectedItem();
            String evaluacion=(String) comboevaluacion.getSelectedItem();
            String asignatura=(String) modelo.getColumnName(i);
            ResultSet res=datos.obtenerNotas2(curso, evaluacion, asignatura);
            try{
                if(res!=null){
                    while(res.next()){
                        Double nota=Double.parseDouble(res.getString("nota"));
                        if(nota>=0 && nota<5){
                            insuficiente++;
                            //insuficiente1++;
                            notas1++;
                        }
                        if(nota>=5 && nota<6){
                            suficiente++;
                            //suficiente1++;
                            notas1++;
                        }
                        if(nota>=6 && nota<7){
                            bien++;
                            //bien1++;
                            notas1++;
                        }
                        if(nota>=7 && nota<9){
                            notable++;
                            //notable1++;
                            notas1++;
                        }
                        if(nota>=9 && nota<=10){
                            sobresaliente++;
                            //sobresaliente1++;
                            notas1++;
                        }
                        modelo.setValueAt(/*insuficiente1+"--"+*/""+df.format(insuficiente*100/notas1)+ "%", 0, i);
                        modelo.setValueAt(/*suficiente1+"--"+*/""+df.format(suficiente*100/notas1)+ "%", 1, i);
                        modelo.setValueAt(/*bien1+"--"+*/""+df.format(bien*100/notas1)+ "%", 2, i);
                        modelo.setValueAt(/*notable1+"--"+*/""+df.format(notable*100/notas1)+ "%", 3, i);
                        modelo.setValueAt(/*sobresaliente1+"--"+*/""+df.format(sobresaliente*100/notas1)+ "%", 4, i);  
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combocurso = new javax.swing.JComboBox();
        comboevaluacion = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        consultar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccion curso/evaluacion"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Curso");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jLabel2.setText("Evaluacion");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jPanel1.add(combocurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 170, -1));

        jPanel1.add(comboevaluacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 170, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 840, 120));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estadistica notas"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 37, 630, 200));

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        jPanel2.add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, -1, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel2.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 840, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        consultar();
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
            java.util.logging.Logger.getLogger(AlumnosFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlumnosFrame2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combocurso;
    private javax.swing.JComboBox comboevaluacion;
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
