
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvar
 */
public class Consulta extends javax.swing.JFrame {
ArrayList<TConsulta> consulta1= new ArrayList<TConsulta>();
DefaultListModel modelolistaespera, modelolistaatendidos;
    /**
     * Creates new form Consulta
     */
    public Consulta() {
        initComponents();
        modelolistaespera=new DefaultListModel();
        modelolistaatendidos=new DefaultListModel();
    }

    
    
    
    public void nuevoPaciente(){
        TConsulta tconsulta=new TConsulta();
        tconsulta.setNombre(areapaciente2.getText());
        tconsulta.setTelefono(Integer.parseInt(areatelefono.getText()));
        consulta1.add(tconsulta);
        System.out.println(consulta1.size());
    }
    
    public void cogerPacientes(){
            for(int i=consulta1.size()-1;i>=0;i--){  
            TConsulta tconsulta2=new TConsulta();
            tconsulta2=consulta1.get(i);
            String nombre=tconsulta2.getNombre();
            modelolistaespera.addElement(nombre);
            listaespera.setModel(modelolistaespera);
        }
        
        
        
    }
    
    
    public void copiarPacienteAlArea(){
        
        areapaciente.setText(modelolistaespera.getElementAt(modelolistaespera.getSize()-1)+"");
        modelolistaespera.removeElementAt(modelolistaespera.getSize()-1);
        consulta1.remove(modelolistaespera.size());

        
    }
    
    public void copiarPaciente(){
        modelolistaatendidos.addElement(areapaciente.getText());
        listaatendidos.setModel(modelolistaatendidos);
        areapaciente.setText(null);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        areapaciente2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        areatelefono = new javax.swing.JTextField();
        añadir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaespera = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaatendidos = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        finalizar = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        comenzar = new javax.swing.JButton();
        solicitar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        areapaciente = new javax.swing.JTextField();

        dialogo.setTitle("Nueva cita");
        dialogo.setMinimumSize(new java.awt.Dimension(800, 800));
        dialogo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Paciente:");
        dialogo.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        dialogo.getContentPane().add(areapaciente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 290, -1));

        jLabel5.setText("Telefono:");
        dialogo.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        dialogo.getContentPane().add(areatelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 290, -1));

        añadir.setText("Añadir");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(añadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion consulta medica");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(listaespera);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 200, -1));

        jScrollPane2.setViewportView(listaatendidos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 190, -1));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void solicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitarActionPerformed
        // TODO add your handling code here:
        dialogo.show();
    }//GEN-LAST:event_solicitarActionPerformed

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed
        // TODO add your handling code here:
        nuevoPaciente();
        areapaciente2.setText(null);
        areatelefono.setText(null);
        areapaciente2.requestFocus();
    }//GEN-LAST:event_añadirActionPerformed

    private void comenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comenzarActionPerformed
        // TODO add your handling code here:
       listaespera.removeAll();
        listaatendidos.removeAll();
        cogerPacientes();
    }//GEN-LAST:event_comenzarActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        // TODO add your handling code here:
        copiarPacienteAlArea();
    }//GEN-LAST:event_siguienteActionPerformed

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        // TODO add your handling code here:
        copiarPaciente();
    }//GEN-LAST:event_finalizarActionPerformed

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
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areapaciente;
    private javax.swing.JTextField areapaciente2;
    private javax.swing.JTextField areatelefono;
    private javax.swing.JButton añadir;
    private javax.swing.JButton comenzar;
    private javax.swing.JDialog dialogo;
    private javax.swing.JButton finalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaatendidos;
    private javax.swing.JList listaespera;
    private javax.swing.JButton siguiente;
    private javax.swing.JButton solicitar;
    // End of variables declaration//GEN-END:variables
}