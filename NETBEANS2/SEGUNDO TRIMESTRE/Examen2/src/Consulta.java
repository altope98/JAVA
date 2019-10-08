import java.util.ArrayList;
public class Consulta extends javax.swing.JFrame {
ArrayList<Paciente> coleccionpacientes= new ArrayList<Paciente>();
    public Consulta() {
        initComponents();
        dialogo2.pack();
        dialogo2.setLocationRelativeTo(null);
        dialogo.pack();
        dialogo.setLocationRelativeTo(null);
        dialogo3.pack();
        dialogo3.setLocationRelativeTo(null);
        dialogoe.pack();
        dialogoe.setLocationRelativeTo(null);
    }
    public void nuevoPaciente(){
        try{
        Paciente paciente1=new Paciente();
        paciente1.setNombre(areapaciente2.getText());
        paciente1.setTelefono(Integer.parseInt(areatelefono.getText()));
        coleccionpacientes.add(paciente1);
        System.out.println(coleccionpacientes.size());
        }catch(NumberFormatException e){
            dialogoe.show();
            areatelefono.setText(null);
        }
    }
    public void cogerPacientes(){
        for(int i=coleccionpacientes.size()-1;i>=0;i--){  
        Paciente paciente2=new Paciente();
        paciente2=coleccionpacientes.get(i);
        String nombre=paciente2.getNombre();
        lista1.add(nombre);
        }
    }
    public void copiarPacienteAlArea(){
        if(lista1.getItemCount()!=0){
            areapaciente.setText(lista1.getItem(lista1.getItemCount()-1));
            lista1.remove(lista1.getItemCount()-1);
            coleccionpacientes.remove(lista1.getItemCount());
        }
        else{
            dialogo2.show();
        }
    }
    public void copiarPaciente(){
        if(areapaciente.getText().equals("")){
            dialogo3.show();
        }else{
            lista2.add(areapaciente.getText());
            areapaciente.setText(null);
        }     
    }
    public void add(){
        nuevoPaciente();
        areapaciente2.setText(null);
        areatelefono.setText(null);
        areapaciente2.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        areapaciente2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        areatelefono = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        dialogo2 = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        cerrar = new javax.swing.JButton();
        dialogo3 = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        cerrar2 = new javax.swing.JButton();
        dialogoe = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        cerrar3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        finalizar = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        comenzar = new javax.swing.JButton();
        solicitar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        areapaciente = new javax.swing.JTextField();
        lista1 = new java.awt.List();
        lista2 = new java.awt.List();

        dialogo.setTitle("Nueva cita");
        dialogo.setMinimumSize(new java.awt.Dimension(800, 800));
        dialogo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Paciente:");
        dialogo.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        areapaciente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areapaciente2ActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(areapaciente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 290, -1));

        jLabel5.setText("Telefono:");
        dialogo.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        areatelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areatelefonoActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(areatelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 290, -1));

        add.setText("Añadir");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        dialogo2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("No quedan elementos en la lista de espera");
        dialogo2.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        cerrar.setText("Cerrar");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        dialogo2.getContentPane().add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        dialogo3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("No hay ningún paciente en consulta");
        dialogo3.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        cerrar2.setText("Cerrar");
        cerrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar2ActionPerformed(evt);
            }
        });
        dialogo3.getContentPane().add(cerrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        dialogoe.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("No has introducido correctamente el telefono");
        dialogoe.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, 20));

        cerrar3.setText("Cerrar");
        cerrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar3ActionPerformed(evt);
            }
        });
        dialogoe.getContentPane().add(cerrar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion consulta medica");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Lista de espera");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel2.setText("Pacientes atendidos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        finalizar.setText("Finalizar paciente");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });
        getContentPane().add(finalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, -1, -1));

        siguiente.setText("Siguiente paciente");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, -1, -1));

        comenzar.setText("Comenzar consulta");
        comenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comenzarActionPerformed(evt);
            }
        });
        getContentPane().add(comenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        solicitar.setText("Solicitar cita");
        solicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitarActionPerformed(evt);
            }
        });
        getContentPane().add(solicitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        jLabel3.setText("Paciente en consulta:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        areapaciente.setEditable(false);
        getContentPane().add(areapaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 150, -1));
        getContentPane().add(lista1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 210, 110));
        getContentPane().add(lista2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 210, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void solicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitarActionPerformed
        areapaciente.setText(null);
        areatelefono.setText(null);
        dialogo.show();
    }//GEN-LAST:event_solicitarActionPerformed
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        add();
    }//GEN-LAST:event_addActionPerformed
    private void comenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comenzarActionPerformed
        lista1.removeAll();
        lista2.removeAll();
        cogerPacientes();
    }//GEN-LAST:event_comenzarActionPerformed
    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        copiarPacienteAlArea();
    }//GEN-LAST:event_siguienteActionPerformed
    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        copiarPaciente();
    }//GEN-LAST:event_finalizarActionPerformed
    private void areapaciente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areapaciente2ActionPerformed
        areatelefono.requestFocus();
    }//GEN-LAST:event_areapaciente2ActionPerformed
    private void areatelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areatelefonoActionPerformed
        add();
    }//GEN-LAST:event_areatelefonoActionPerformed
    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        dialogo2.dispose();
    }//GEN-LAST:event_cerrarActionPerformed
    private void cerrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar2ActionPerformed
        dialogo3.dispose();
    }//GEN-LAST:event_cerrar2ActionPerformed
    private void cerrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar3ActionPerformed
        dialogoe.dispose();
    }//GEN-LAST:event_cerrar3ActionPerformed
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
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField areapaciente;
    private javax.swing.JTextField areapaciente2;
    private javax.swing.JTextField areatelefono;
    private javax.swing.JButton cerrar;
    private javax.swing.JButton cerrar2;
    private javax.swing.JButton cerrar3;
    private javax.swing.JButton comenzar;
    private javax.swing.JDialog dialogo;
    private javax.swing.JDialog dialogo2;
    private javax.swing.JDialog dialogo3;
    private javax.swing.JDialog dialogoe;
    private javax.swing.JButton finalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private java.awt.List lista1;
    private java.awt.List lista2;
    private javax.swing.JButton siguiente;
    private javax.swing.JButton solicitar;
    // End of variables declaration//GEN-END:variables
}
