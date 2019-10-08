
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

//@author alvar

public class Alumnos extends javax.swing.JFrame {

    DefaultTableModel modelo;
    DefaultListModel modelolista1,modelolista2;
    AlumnosBD alumnos;
    public Alumnos() {
        initComponents();
        alumnos=new AlumnosBD();
        modelolista1=new DefaultListModel();
        modelolista2=new DefaultListModel();
        modelo=new DefaultTableModel();
        generarTabla();
        rellenarListaCursos();
        rellenarListaEvaluacion();
        
    }

    public void generarTabla(){
        tabla.setModel(modelo);
        modelo.addColumn("Alumnos");
        modelo.addColumn("");

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
     public void rellenarListaAsignaturas(){
         String curso=(String) ccurso.getSelectedItem();
        ResultSet resultado=alumnos.obtenerAsignaturas(curso);
            casignatura.removeAllItems();
            try{
                while (resultado.next()){
                    System.out.print(resultado.getString("asignatura"));
                    casignatura.addItem(resultado.getString("asignatura"));
                }
            } catch(SQLException e){}
     }
     public void rellenarListaAlumnosCandidatos(){
         String curso=(String) ccurso.getSelectedItem();
        ResultSet resultado=alumnos.obtenerAlumnosCandidatos(curso);
            modelolista1.removeAllElements();
            try{
                while (resultado.next()){
                    //System.out.print(resultado.getString("nombre"));
                    modelolista1.addElement(resultado.getString("nombre"));
                    listacandidatos.setModel(modelolista1);
                }
            } catch(SQLException e){}
     }
     public void agregarFilaTabla(DefaultTableModel modelo) {
        Object [] fila = new Object[modelo.getColumnCount()];
        modelo.addRow(fila);
    }
     
     
     public void rellenarAlumnos(){
         int fila=0;
         System.out.println(modelolista2.getSize());
         for(int i=0;i<modelolista2.getSize();i++){ 
             
             modelo.setValueAt(modelolista2.getElementAt(i),fila,0);
             fila++;
         }
             
         
     }
     public void rellenarNotas(){
         String curso=(String) ccurso.getSelectedItem();
         String evaluacion=(String) cevaluacion.getSelectedItem();
         String asignatura=(String) casignatura.getSelectedItem();
         ResultSet resultado=alumnos.obtenerNotas(curso,evaluacion,asignatura);

         int fila=0;
         try{
                while (resultado.next()){
                   agregarFilaTabla(modelo);
                    //System.out.print(resultado.getString("nombre"));
                    //modelo.setValueAt(resultado.getString("nombre"),fila,0);
                    modelo.setValueAt(resultado.getString("nota"),fila,1);
                    fila++;
                }
            } catch(SQLException e){}
     }

     public void rellenar0(){
        
        for(int i=0;i<modelo.getRowCount();i++){ 
         if(modelo.getValueAt(i, 1)==null){
             modelo.setValueAt("0", i, 1);
             
             
         }
        }
         
     }
     
     
     public void actualizar(){
        
        for (int i=0;i<modelo.getRowCount();i++){
            /*if(modelo.getValueAt(i, 1).equals("0")){
            String alumno=(String)modelo.getValueAt(i, 0);
            String nota=(String)modelo.getValueAt(i,1);
            String evaluacion=(String)cevaluacion.getSelectedItem();
            String asignatura=(String)casignatura.getSelectedItem();
            ResultSet res=alumnos.obtenerIDAsignatura(asignatura);
            ResultSet res2=alumnos.obtenerIDalumnos(alumno);
            try{
            alumnos.insertarNotas(res2.getString("idAlumno"), nota, res.getString("idAsignatura"), evaluacion);
            }catch(SQLException e){}
            }else{*/
            String alumno=(String)modelo.getValueAt(i, 0);
            String nota=(String)modelo.getValueAt(i,1);
            alumnos.actualizarNotas(alumno,nota);
              //}
     }
     }
              
           

        
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        salir2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ccurso = new javax.swing.JComboBox();
        cevaluacion = new javax.swing.JComboBox();
        casignatura = new javax.swing.JComboBox();
        aplicar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        moverderecha = new javax.swing.JButton();
        movertododerecha = new javax.swing.JButton();
        moverizquierda = new javax.swing.JButton();
        movertodoizquierda = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        evaluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listacandidatos = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaseleccionados = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        salir = new javax.swing.JButton();
        procesar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        dialogo.setMinimumSize(new java.awt.Dimension(800, 800));
        dialogo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("NO HAY NINGUN ELEMENTO SELECCIONADO O NO HAY NINGUN ELEMENTO");
        dialogo.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 690, 70));

        salir2.setText("Salir");
        salir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir2ActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(salir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccion asignatura"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Curso");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel2.setText("Evaluacion");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel3.setText("Asignatura");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        ccurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ccursoItemStateChanged(evt);
            }
        });
        jPanel1.add(ccurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 120, -1));

        jPanel1.add(cevaluacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 120, -1));

        jPanel1.add(casignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 120, -1));

        aplicar.setText("Aplicar");
        aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarActionPerformed(evt);
            }
        });
        jPanel1.add(aplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 23, 710, 120));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Selección alumnos"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Alumnos candidatos");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        moverderecha.setText(">>");
        moverderecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moverderechaActionPerformed(evt);
            }
        });
        jPanel2.add(moverderecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 50, -1));

        movertododerecha.setText(">|");
        movertododerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movertododerechaActionPerformed(evt);
            }
        });
        jPanel2.add(movertododerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 50, -1));

        moverizquierda.setText("<<");
        moverizquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moverizquierdaActionPerformed(evt);
            }
        });
        jPanel2.add(moverizquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 50, -1));

        movertodoizquierda.setText("|<");
        movertodoizquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movertodoizquierdaActionPerformed(evt);
            }
        });
        jPanel2.add(movertodoizquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 50, -1));

        jLabel5.setText("Alumnos seleccionados");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        evaluar.setText("Evaluar");
        evaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluarActionPerformed(evt);
            }
        });
        jPanel2.add(evaluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, -1, -1));

        jScrollPane1.setViewportView(listacandidatos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, -1));

        jScrollPane2.setViewportView(listaseleccionados);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 220, 130));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 700, 230));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Evaluación alumnos"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel3.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 80, -1));

        procesar.setText("Procesar");
        procesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarActionPerformed(evt);
            }
        });
        jPanel3.add(procesar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Alumno", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabla);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 550, 140));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 700, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ccursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ccursoItemStateChanged

        rellenarListaAsignaturas();
    }//GEN-LAST:event_ccursoItemStateChanged

    private void aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarActionPerformed

        rellenarListaAlumnosCandidatos();
    }//GEN-LAST:event_aplicarActionPerformed

    private void moverderechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moverderechaActionPerformed

       if (listacandidatos.getSelectedValue()==null){
           dialogo.show();
       }else{
       modelolista2.addElement(listacandidatos.getSelectedValue());
       listaseleccionados.setModel(modelolista2);   
       }
       modelolista1.removeElementAt(listacandidatos.getSelectedIndex());
    }//GEN-LAST:event_moverderechaActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed

        dispose();
    }//GEN-LAST:event_salirActionPerformed
    private void salir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir2ActionPerformed
        dialogo.dispose();
    }//GEN-LAST:event_salir2ActionPerformed
    private void movertododerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movertododerechaActionPerformed
        modelolista2.removeAllElements();
        for(int i=0;i<modelolista1.getSize();i++){
            modelolista2.addElement(modelolista1.getElementAt(i));
            listaseleccionados.setModel(modelolista2);
        }modelolista1.removeAllElements();
    }//GEN-LAST:event_movertododerechaActionPerformed
    private void moverizquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moverizquierdaActionPerformed

        
        
        if (listaseleccionados.getSelectedValue()==null){
           dialogo.show();
       }else{
       modelolista1.addElement(listaseleccionados.getSelectedValue());
       listacandidatos.setModel(modelolista1);   
       }modelolista2.removeElementAt(listaseleccionados.getSelectedIndex());
       
    }//GEN-LAST:event_moverizquierdaActionPerformed

    private void movertodoizquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movertodoizquierdaActionPerformed
        modelolista1.removeAllElements();
        
        
        for(int i=0;i<modelolista2.getSize();i++){
            modelolista1.addElement(modelolista2.getElementAt(i));
            listacandidatos.setModel(modelolista1);
            /*DefaultListModel modelotemp=new DefaultListModel();
        listaseleccionados.setModel(modelotemp);*/
        }modelolista2.removeAllElements();
        
        
        
        /*listacandidatos.setModel(listaseleccionados.getModel());
        modelolista2.removeAllElements();
        DefaultListModel modelotemp=new DefaultListModel();
        listaseleccionados.setModel(modelotemp);*/
        
    }//GEN-LAST:event_movertodoizquierdaActionPerformed

    private void evaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluarActionPerformed
        JTableHeader head = tabla.getTableHeader();
        TableColumnModel tcm = head.getColumnModel();
        TableColumn tabCM = tcm.getColumn(1);
        tabCM.setHeaderValue(casignatura.getSelectedItem().toString());
        tabla.repaint();
        
        rellenarNotas();
        rellenarAlumnos();
        rellenar0();
       
        for (int i=1;i<modelo.getRowCount();i++){
            if(modelo.getValueAt(i, 0)==null){
              modelo.removeRow(i);
             
         }
        }
        modelolista1.removeAllElements();
        modelolista2.removeAllElements();
        /*DefaultListModel modelotemp=new DefaultListModel();
        listaseleccionados.setModel(modelotemp);
        listacandidatos.setModel(modelotemp);*/
    }//GEN-LAST:event_evaluarActionPerformed

    private void procesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesarActionPerformed
        // TODO add your handling code here:
        actualizar();
    }//GEN-LAST:event_procesarActionPerformed

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
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aplicar;
    private javax.swing.JComboBox casignatura;
    private javax.swing.JComboBox ccurso;
    private javax.swing.JComboBox cevaluacion;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JList listacandidatos;
    private javax.swing.JList listaseleccionados;
    private javax.swing.JButton moverderecha;
    private javax.swing.JButton moverizquierda;
    private javax.swing.JButton movertododerecha;
    private javax.swing.JButton movertodoizquierda;
    private javax.swing.JButton procesar;
    private javax.swing.JButton salir;
    private javax.swing.JButton salir2;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
