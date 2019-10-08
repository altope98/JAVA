package Vista;
import Controlador.AlumnosBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class AlumnosFrame3 extends javax.swing.JFrame {
    int suspenso, aprobado, notas1, cont;
    AlumnosBD datos;
    DefaultTableModel modelo;
    ArrayList<String> notas;
    public AlumnosFrame3() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        datos=new AlumnosBD();
        rellenarListaCursos();
        rellenarListaEvaluaciones();
    }
    public void generarTabla(){
        if(todas.isSelected()){
            modelo=new DefaultTableModel();
            modelo.addColumn("");
            modelo.addColumn("1º Evaluacion");
            modelo.addColumn("2º Evaluacion");
            modelo.addColumn("3º Evaluacion");
            modelo.addColumn("Evaluacion Final");
            for(int i=1;i<=3;i++)
                agregarFila();
            modelo.setValueAt("0 suspensos", 0, 0);
            modelo.setValueAt("1 suspenso", 1, 0);
            modelo.setValueAt(">1 suspensos", 2, 0);
            tabla.setModel(modelo);
        }else{
            modelo=new DefaultTableModel();
            modelo.addColumn("");
            modelo.addColumn(comboevaluacion.getSelectedItem());
            for(int i=1;i<=3;i++)
            agregarFila();
            modelo.setValueAt("0 suspensos", 0, 0);
            modelo.setValueAt("1 suspenso", 1, 0);
            modelo.setValueAt(">1 suspensos", 2, 0);
            tabla.setModel(modelo);
        }
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
    public void consultarTodas(){
        notas1=0;
        generarTabla();
        limpiarTabla();
        DecimalFormat df = new DecimalFormat("0.0");
        for(int i=1;i<modelo.getColumnCount();i++){
            String curso=(String) combocurso.getSelectedItem();
            ResultSet res=datos.obtenerNotas3(curso);
            try{
                if(res!=null){
                    while(res.next()){
                        Double nota=Double.parseDouble(res.getString("nota"));
                        if(nota>=0 && nota<5){
                            suspenso++;
                            notas1++;
                        }
                        if(nota>=5 && nota<=10){
                            aprobado++;
                            notas1++;
                        }
                        modelo.setValueAt(df.format(aprobado)+"("+df.format(aprobado*100/notas1)+"%)", 0, i);
                        if(suspenso>1){
                            modelo.setValueAt(df.format(suspenso)+"("+df.format(suspenso*100/notas1)+"%)", 2, i);
                        }
                        if(suspenso==1){
                            modelo.setValueAt(df.format(suspenso)+"("+df.format(suspenso*100/notas1)+"%)", 1, i);
                        }
                    }
                }
            }catch(SQLException e){}
        }  
        suspenso=0;
        aprobado=0;
    }
    public void consultarUna(){
        notas1=0;
        generarTabla();
        limpiarTabla();
        DecimalFormat df = new DecimalFormat("0.0");
        String curso=(String) combocurso.getSelectedItem();
        String evaluacion=(String) comboevaluacion.getSelectedItem();
        ResultSet res=datos.obtenerNotas4(curso,evaluacion);
        Double v[]=new Double[datos.numeroAsignaturas(curso)];
        System.out.println(v.length);
        boolean aprobado1=true;
            try{
                if(res!=null){
                    while(res.next()){
                        for(int i=0; i<v.length;i++){
                            v[i]=Double.parseDouble(res.getString("nota"));
                            System.out.println(v[i]);
                        }
                        for(int i=0;i<v.length;i++){
                            if(v[i]<5){
                                aprobado1=false;
                            }
                        }
                        if(aprobado1=true){
                            aprobado++;
                        }else{
                            suspenso++;
                        }
                        
                        
                        
                        
                        /*Double nota=Double.parseDouble(res.getString("nota"));
                        if(nota>=0 && nota<5){
                            suspenso++;
                        }
                        if(nota>=5 && nota<=10){
                            aprobado++;
                        }*/
                        notas1++;  
                    }
                }
            }catch(SQLException e){}
            modelo.setValueAt(df.format(aprobado)+"("+df.format(aprobado*100/notas1)+"%)", 0, 1);
            if(suspenso>1){
                modelo.setValueAt(df.format(suspenso)+"("+df.format(suspenso*100/notas1)+"%)", 2, 1);
            }
            if(suspenso==1){
                modelo.setValueAt(df.format(suspenso)+"("+df.format(suspenso*100/notas1)+"%)", 1, 1);
            }
        suspenso=0;
        aprobado=0;
    }
   /*public void consultarTodas(){
        
    }
    public void consultarUna(){
        DecimalFormat df = new DecimalFormat("0.0");
        String curso=(String)combocurso.getSelectedItem();
        String evaluacion=(String)comboevaluacion.getSelectedItem();
        ResultSet res=datos.numeroAsignaturas(curso);
        int numerodenotas=0;
        boolean aprobado=true;
        try{
                if(res!=null){
                    while(res.next()){
                        numerodenotas=Integer.parseInt(res.getString("count(asignaturas)"));
                        notas=new ArrayList<String>(numerodenotas);
                        System.out.println(numerodenotas);
                        
                    }
                }
            }catch(SQLException e){}
        ResultSet res2=datos.obtenerNotas4(curso, evaluacion);
        try{
                if(res!=null){
                    while(res.next()){
                        if(notas.size()>=numerodenotas){
                           for(int i=0;i<notas.size();i++){
                               if(Integer.parseInt(notas.get(i))<5){
                                   aprobado=false;
                               }
                               
                               notas.set(i, null);
                           }
                           if(aprobado==false){
                               suspenso++;
                           }
                           if(aprobado==true){
                                cont++;
                           }
                           for(int i=0;i<notas.size();i++){
                                notas.set(i, res.getString("nota"));
                            }
                        }else{
                            for(int i=0;i<notas.size();i++){
                                notas.set(i, res.getString("nota"));
                            }
                        } 
                        notas1++;
                        
                    }
                }
            }catch(SQLException e){}
       
            modelo.setValueAt(df.format(cont)+"("+df.format(cont*100/notas1)+"%)", 0, 1);
            if(suspenso>1){
                modelo.setValueAt(df.format(suspenso)+"("+df.format(suspenso*100/notas1)+"%)", 2, 1);
            }
            if(suspenso==1){
                modelo.setValueAt(df.format(suspenso)+"("+df.format(suspenso*100/notas1)+"%)", 1, 1);
            }
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combocurso = new javax.swing.JComboBox();
        comboevaluacion = new javax.swing.JComboBox();
        todas = new javax.swing.JRadioButton();
        una = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        consultar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccion curso/evaluacion"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Curso");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 39, -1, -1));

        jLabel2.setText("Evaluacion");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        jPanel1.add(combocurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 180, -1));

        jPanel1.add(comboevaluacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 180, -1));

        buttonGroup1.add(todas);
        todas.setSelected(true);
        todas.setText("Todas");
        jPanel1.add(todas, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        buttonGroup1.add(una);
        una.setText("Una");
        jPanel1.add(una, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 800, 120));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estadistica notas"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        jPanel2.add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, -1, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel2.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 80, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 590, 140));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 800, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        if(todas.isSelected()){
            consultarTodas();
        }else{
            consultarUna();
        }
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
            java.util.logging.Logger.getLogger(AlumnosFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlumnosFrame3().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JRadioButton todas;
    private javax.swing.JRadioButton una;
    // End of variables declaration//GEN-END:variables
}
