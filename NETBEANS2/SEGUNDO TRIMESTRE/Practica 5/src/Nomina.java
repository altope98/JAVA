/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alvaro
 */
public class Nomina extends javax.swing.JFrame {

    /**
     * Creates new form Nomina
     */
    public Nomina() {
        initComponents();
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        areabase = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        itemcivil = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        si = new javax.swing.JRadioButton();
        no = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        areahijos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        areaantiguedad = new javax.swing.JTextField();
        areasueldo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        calcular = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculo Nomina");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Sueldo base");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));
        getContentPane().add(areabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 110, -1));

        jLabel2.setText("Estado Civil");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        itemcivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soltero", "Casado", "Viudo", "Divorciado" }));
        getContentPane().add(itemcivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 120, -1));

        jLabel3.setText("Jefe Departamento");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));

        buttonGroup1.add(si);
        si.setText("Si");
        getContentPane().add(si, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, -1));

        buttonGroup1.add(no);
        no.setSelected(true);
        no.setText("No");
        getContentPane().add(no, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, -1));

        jLabel4.setText("Nº Hijos");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));
        getContentPane().add(areahijos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 70, -1));

        jLabel5.setText("Antiguedad");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, -1));
        getContentPane().add(areaantiguedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 70, -1));

        areasueldo.setEditable(false);
        getContentPane().add(areasueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 100, -1));

        jLabel6.setText("Sueldo Bruto");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, -1, -1));

        calcular.setText("Calcular");
        calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularActionPerformed(evt);
            }
        });
        getContentPane().add(calcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, -1, -1));

        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularActionPerformed
        // TODO add your handling code here:
        double base, total;
        int antiguedad, departamento=0, casado=0, hijos;
        
        base=Double.parseDouble(areabase.getText());
        antiguedad=(Integer.parseInt(areaantiguedad.getText())/3)*30;
        if(si.isSelected()){
            departamento=42;
        }
        if(itemcivil.getSelectedIndex()==1){
            casado=60;
        }
        hijos=(Integer.parseInt(areahijos.getText()))*18;
        
        total= base+antiguedad+departamento+casado+hijos;
        areasueldo.setText(total+"");
    }//GEN-LAST:event_calcularActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        // TODO add your handling code here:
        itemcivil.setSelectedIndex(0);
        areabase.setText(null);
        areahijos.setText(null);
        areaantiguedad.setText(null);
        areasueldo.setText(null);
        no.setSelected(true);
    }//GEN-LAST:event_limpiarActionPerformed

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
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nomina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areaantiguedad;
    private javax.swing.JTextField areabase;
    private javax.swing.JTextField areahijos;
    private javax.swing.JTextField areasueldo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton calcular;
    private javax.swing.JComboBox itemcivil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton limpiar;
    private javax.swing.JRadioButton no;
    private javax.swing.JRadioButton si;
    // End of variables declaration//GEN-END:variables
}
