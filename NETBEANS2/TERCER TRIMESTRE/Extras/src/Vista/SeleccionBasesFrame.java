package Vista;
import Controlador.SeleccionBasesBD;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
public class SeleccionBasesFrame extends javax.swing.JFrame {
    SeleccionBasesBD datos;
    public SeleccionBasesFrame() {
        initComponents();
        this.pack();
    }
    public void consultar(){
        area.setText(null);
        String sentenciaSQL=areasentencia.getText();
        ResultSet res=datos.obtenerDatos(sentenciaSQL);
        if(res!=null){
            try{
                for (int x=1;x<=res.getMetaData().getColumnCount();x++){
                        area.append(res.getMetaData().getColumnName(x)+ "\t");
                    }
                area.append("\n");
                while(res.next()){
                    for (int x=1;x<=res.getMetaData().getColumnCount();x++){
                        area.append(res.getString(x)+ "\t");
                    }
                    area.append("\n");
               }
            }catch(SQLException e){}
        }
    }   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filechooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        ruta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        areasentencia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        consultar = new javax.swing.JButton();

        filechooser.setCurrentDirectory(new java.io.File("C:\\Users\\Alvaro\\Desktop"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Base de datos:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));
        getContentPane().add(ruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 350, -1));

        jLabel2.setText("Sentencia SQL:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));
        getContentPane().add(areasentencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 350, -1));

        area.setColumns(20);
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 450, 190));

        jLabel3.setText("Resultado");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 90, -1));

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        getContentPane().add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        //filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);  
        FileNameExtensionFilter filtrodebases = new FileNameExtensionFilter("sqlite", "s3db"); 
        filechooser.setFileFilter(filtrodebases);
        int result = filechooser.showOpenDialog(this);
        if (result != JFileChooser.CANCEL_OPTION) {
            File fileName = filechooser.getSelectedFile();
            if ((fileName == null) || (fileName.getName().equals(""))) {
                ruta.setText("...");
            } else {
                ruta.setText(fileName.getAbsolutePath());
                datos=new SeleccionBasesBD(fileName.getAbsolutePath());
            }
        }
    }//GEN-LAST:event_buscarActionPerformed
    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        consultar();
    }//GEN-LAST:event_consultarActionPerformed
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
            java.util.logging.Logger.getLogger(SeleccionBasesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionBasesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionBasesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionBasesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionBasesFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JTextField areasentencia;
    private javax.swing.JButton buscar;
    private javax.swing.JButton consultar;
    private javax.swing.JFileChooser filechooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ruta;
    // End of variables declaration//GEN-END:variables
}
