package Vista;
import Controlador.AlumnosBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
public class AlumnosFrame extends javax.swing.JFrame {
    AlumnosBD datos;
    DefaultTableModel modelotabla;
    DefaultListModel modelocandidatos,modeloseleccionados;
    boolean condicion, condicion2;
    int x;
    int v[]=new int[10];
    public AlumnosFrame() {
        initComponents();
        this.pack();
        dialogo.pack();
        dialogo.setLocationRelativeTo(null);
        datos=new AlumnosBD();
        modelocandidatos=new DefaultListModel();
        modeloseleccionados=new DefaultListModel();
        rellenarListaCursos();
        rellenarListaEvaluaciones();
        generarTabla();
    }
    public void generarTabla(){
        modelotabla=new DefaultTableModel();
        modelotabla.addColumn("Alumno");
        modelotabla.addColumn("");
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
    public void limpiarTabla() {
        for(int fila=0; fila<2; fila++)
            for(int col=0; col<3; col++)
            modelotabla.setValueAt("", fila, col);
    } 
    public void rellenarListaCursos(){       
        ResultSet res=datos.obtenerRegistrosOrdenados("cursos", "curso");
        if(res!=null){
            try{
                while (res.next()){
                    choicecurso.addItem(res.getString("curso"));
                }
            } catch(SQLException e){}
            choicecurso.setSelectedIndex(0);
        }        
    }
    public void rellenarListaEvaluaciones(){
        ResultSet res=datos.obtenerRegistrosAgrupados("notas", "evaluacion");
        if(res!=null){
            try{
                while (res.next()){
                    choiceevaluacion.addItem(res.getString("evaluacion"));
                }
            } catch(SQLException e){}
            choiceevaluacion.setSelectedIndex(0);
        }        
    }
    public void rellenarListaAsignaturas(){
        choiceasignatura.removeAllItems();
        String curso=(String)choicecurso.getSelectedItem();
        ResultSet res=datos.obtenerAsignaturas(curso);
        if(res!=null){
            try{
                while (res.next()){
                    choiceasignatura.addItem(res.getString("asignatura"));
                }
            } catch(SQLException e){}
        }
        choiceasignatura.setSelectedIndex(0);
    }
    public void rellenarListaAlumnosCandidatos(){
        modelocandidatos.removeAllElements();
        String curso=(String)choicecurso.getSelectedItem();
        ResultSet res=datos.obtenerAlumnosCandidatos(curso);
        if(res!=null){
            try{
                while (res.next()){
                    modelocandidatos.addElement(res.getString("alumno"));
                }
            } catch(SQLException e){}
        }
        listacandidatos.setModel(modelocandidatos);
    }
    public void pasarDerecha(){
        String candidato=(String)listacandidatos.getSelectedValue();
        try{
            if(candidato.equals("")){}
            else{
                modeloseleccionados.addElement(listacandidatos.getSelectedValue());
                modelocandidatos.removeElement(listacandidatos.getSelectedValue());
                listaseleccionados.setModel(modeloseleccionados);
            }
        }catch(NullPointerException e){
            dialogo.show();
        }
    }
    public void pasarIzquierda(){
        String candidato=(String)listaseleccionados.getSelectedValue();
        try{
            if(candidato.equals("")){}
            else{
                modelocandidatos.addElement(listaseleccionados.getSelectedValue());
                modeloseleccionados.removeElement(listaseleccionados.getSelectedValue());
                listacandidatos.setModel(modelocandidatos);
            }
        }catch(NullPointerException e){
            dialogo.show();
        }
    }
    public void pasarTodaDerecha(){
        modeloseleccionados.removeAllElements();
        for(int i=0;i<modelocandidatos.getSize();i++){
            modeloseleccionados.addElement(modelocandidatos.getElementAt(i));
            listaseleccionados.setModel(modeloseleccionados);
        }modelocandidatos.removeAllElements();
    }
    public void pasarTodaIzquierda(){
        modelocandidatos.removeAllElements();
        for(int i=0;i<modeloseleccionados.getSize();i++){
            modelocandidatos.addElement(modeloseleccionados.getElementAt(i));
            listacandidatos.setModel(modelocandidatos);
        }modeloseleccionados.removeAllElements();
    }
    public void evaluar(){
        cambiarColumna();
        int fila=0;
        for(int i=0;i<modeloseleccionados.getSize();i++){
            agregarFila();
            String alumno=(String)modeloseleccionados.getElementAt(i);
            String curso=(String)choicecurso.getSelectedItem();
            String asignatura=(String)choiceasignatura.getSelectedItem();
            String evaluacion=(String)choiceevaluacion.getSelectedItem();
            String idAlumno=null;
            String idAsignatura=null;
            String idCurso=null;
            ResultSet res2=datos.obtenerID(curso,asignatura,alumno);
                    if(res2 != null) {
                    try{
                        while (res2.next()){
                            idCurso=res2.getString("idCurso");
                            idAsignatura=res2.getString("idAsignatura");
                            idAlumno=res2.getString("idAlumno");
                        }
                    } catch(SQLException e){}
                    }
            ResultSet res=datos.obtenerNotasV32(idCurso, evaluacion, idAsignatura, idAlumno);
            modelotabla.setValueAt(alumno, fila, 0);
            if(res != null) {
                try{
                    while (res.next()){
                        
                        modelotabla.setValueAt(res.getString("nota"),fila,1);
                    }
                } catch(SQLException e){}
            }
            fila++;
        }
        rellenar();
    }
    public void rellenar(){
        for(int i=0;i<modelotabla.getRowCount();i++){ 
            if(modelotabla.getValueAt(i, 1)==null){
                modelotabla.setValueAt("0", i, 1);
            }
        }
     }
    public void cambiarColumna(){
        JTableHeader head = tabla.getTableHeader();
        TableColumnModel tcm = head.getColumnModel();
        TableColumn tabCM = tcm.getColumn(1);
        tabCM.setHeaderValue(choiceasignatura.getSelectedItem().toString());
        tabla.repaint();
        tabla.updateUI();
    }
      
    
    public void comprobar(){
        int x=0;
        for(int i=0;i<modelotabla.getRowCount();i++){
            String nombre=modelotabla.getValueAt(i, 0).toString();
            String curso=choicecurso.getSelectedItem().toString();
            boolean condicion=false;
            ResultSet res=datos.obtenerCondicion(nombre,curso);
        try{
            if(res!=null){
                while(res.next()){
                    if(res.getString("alumno").equals(nombre)){
                        condicion=true;
                    }else{
                        x=i;
                    }
                }
            }
        }catch(SQLException e){}
        if (condicion){
            actualizar();
        }else{
            if (!"0".equals(modelotabla.getValueAt(x, 1))){
            insertar(x);
            }
        }
        }
        
    }
    public void actualizar(){
        for (int i=0;i<modelotabla.getRowCount();i++){
            String alumno=(String)modelotabla.getValueAt(i, 0);
            String nota=(String)modelotabla.getValueAt(i,1);
            String evaluacion=(String)choiceevaluacion.getSelectedItem();
            String asignatura=(String)choiceasignatura.getSelectedItem();
             datos.actualizarNotas(alumno,nota,evaluacion,asignatura);
        }
    }
    public void insertar(int x){

                String nota=(String)modelotabla.getValueAt(x,1);

                    String evaluacion=(String)choiceevaluacion.getSelectedItem();
                    String curso=(String)choicecurso.getSelectedItem();
                    String asignatura=(String)choiceasignatura.getSelectedItem();
                    String alumno=(String)modelotabla.getValueAt(x, 0);
                    String idAsignatura=null;
                    String idAlumno=null;
                    String idCurso=null;
                    ResultSet res=datos.obtenerID(curso,asignatura,alumno);
                
                    if(res != null) {
                    try{
                        while (res.next()){
                            idCurso=res.getString("idCurso");
                            idAsignatura=res.getString("idAsignatura");
                            idAlumno=res.getString("idAlumno");
                        }
                    } catch(SQLException e){}
                }
                datos.insertarNotas(evaluacion,idAsignatura,idAlumno,nota,alumno,idCurso);
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        aplicar = new javax.swing.JButton();
        choicecurso = new javax.swing.JComboBox();
        choiceasignatura = new javax.swing.JComboBox();
        choiceevaluacion = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listacandidatos = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaseleccionados = new javax.swing.JList();
        evaluar = new javax.swing.JButton();
        pasarunoderacha = new javax.swing.JButton();
        pasartodosderecha = new javax.swing.JButton();
        pasarunoizquierda = new javax.swing.JButton();
        pasartodosizquierda = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        procesar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        dialogo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("NO SE HA SELECIONADO NINGUN ELEMENTO O NO HAY ELEMENTOS EN LA LISTA");
        dialogo.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Evaluacion de alumnos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccion asignatura"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Curso:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jLabel2.setText("Evaluación:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        jLabel3.setText("Asignatura:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        aplicar.setText("Aplicar");
        aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarActionPerformed(evt);
            }
        });
        jPanel1.add(aplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        choicecurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choicecursoItemStateChanged(evt);
            }
        });
        jPanel1.add(choicecurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 180, -1));

        jPanel1.add(choiceasignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 180, -1));

        jPanel1.add(choiceevaluacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 180, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 870, 120));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccion alumnos"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Alumnos candidatos");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        jLabel5.setText("Alumnos selecionados");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        jScrollPane1.setViewportView(listacandidatos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 200, 140));

        jScrollPane2.setViewportView(listaseleccionados);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 200, 140));

        evaluar.setText("Evaluar");
        evaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluarActionPerformed(evt);
            }
        });
        jPanel2.add(evaluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, -1, -1));

        pasarunoderacha.setText(">>");
        pasarunoderacha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasarunoderachaActionPerformed(evt);
            }
        });
        jPanel2.add(pasarunoderacha, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 50, -1));

        pasartodosderecha.setText(">|");
        pasartodosderecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasartodosderechaActionPerformed(evt);
            }
        });
        jPanel2.add(pasartodosderecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 50, -1));

        pasarunoizquierda.setText("<<");
        pasarunoizquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasarunoizquierdaActionPerformed(evt);
            }
        });
        jPanel2.add(pasarunoizquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 50, -1));

        pasartodosizquierda.setText("|<");
        pasartodosizquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasartodosizquierdaActionPerformed(evt);
            }
        });
        jPanel2.add(pasartodosizquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 50, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 870, 280));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Evauacion alumnos"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabla);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 110));

        procesar.setText("Procesar");
        procesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarActionPerformed(evt);
            }
        });
        jPanel3.add(procesar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel3.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 870, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed
    private void procesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesarActionPerformed
        comprobar();
    }//GEN-LAST:event_procesarActionPerformed
    private void evaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluarActionPerformed
        evaluar();
    }//GEN-LAST:event_evaluarActionPerformed
    private void aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarActionPerformed
        rellenarListaAlumnosCandidatos();
    }//GEN-LAST:event_aplicarActionPerformed
    private void choicecursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choicecursoItemStateChanged
        rellenarListaAsignaturas();
    }//GEN-LAST:event_choicecursoItemStateChanged
    private void pasarunoderachaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasarunoderachaActionPerformed
        pasarDerecha();
    }//GEN-LAST:event_pasarunoderachaActionPerformed
    private void pasartodosderechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasartodosderechaActionPerformed
        pasarTodaDerecha();
    }//GEN-LAST:event_pasartodosderechaActionPerformed
    private void pasarunoizquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasarunoizquierdaActionPerformed
        pasarIzquierda();
    }//GEN-LAST:event_pasarunoizquierdaActionPerformed
    private void pasartodosizquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasartodosizquierdaActionPerformed
        pasarTodaIzquierda();
    }//GEN-LAST:event_pasartodosizquierdaActionPerformed
    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        dialogo.dispose();
    }//GEN-LAST:event_aceptarActionPerformed
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
            java.util.logging.Logger.getLogger(AlumnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlumnosFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton aplicar;
    private javax.swing.JComboBox choiceasignatura;
    private javax.swing.JComboBox choicecurso;
    private javax.swing.JComboBox choiceevaluacion;
    private javax.swing.JDialog dialogo;
    private javax.swing.JButton evaluar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listacandidatos;
    private javax.swing.JList listaseleccionados;
    private javax.swing.JButton pasartodosderecha;
    private javax.swing.JButton pasartodosizquierda;
    private javax.swing.JButton pasarunoderacha;
    private javax.swing.JButton pasarunoizquierda;
    private javax.swing.JButton procesar;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
