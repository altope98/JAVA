
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvar
 */
public class Ahorcado extends javax.swing.JFrame {
    ArrayList<TAhorcado> ahorcado1= new ArrayList<TAhorcado>();
    String palabra,cadena;
    int intentos;
    StringBuffer cadena1=new StringBuffer();
    StringBuffer cadena2=new StringBuffer();
     int j=0;
    /**
     * Creates new form Ahorcado
     */
    public Ahorcado() {
        initComponents();
        //arealetra.requestFocus();
        
    }
    public void nuevaPalabra(){
        TAhorcado tahorcado=new TAhorcado();
        tahorcado.setPalabra(areaintroducir.getText());
        ahorcado1.add(tahorcado);
        System.out.println(ahorcado1.size());
    }
    public void establecerPalabra(){
        
         int n=(int)(Math.random()*ahorcado1.size());
         TAhorcado tahorcado2 = new TAhorcado();
            tahorcado2=ahorcado1.get(n);
            palabra=tahorcado2.getPalabra();
            System.out.println(palabra.length());
            for(int i=0;i<palabra.length();i++){                
                cadena1.append('_').toString();
                cadena=cadena1.toString();
                //System.out.println(cadena1);
                 areapalabra.setText(cadena);           
            }
     
    }
    
    public void comprobarLetra(){
        cadena2.append(arealetra.getText()).toString();
        System.out.println(cadena2);
        
        for(int i=0;i<palabra.length();i++){
           
            if(cadena2.charAt(j)==(palabra.charAt(i))){
                
                cadena1.setCharAt(i, cadena2.charAt(j));
               
                cadena=cadena1.toString();
                areapalabra.setText(cadena);
            } 
        }
        arealetra.setText("");
         j++;
        
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
        areaintroducir = new javax.swing.JTextField();
        añadir = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        dialogo2 = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        si = new javax.swing.JButton();
        no = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        areapalabra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        arealetra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        areaintentos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        introducir = new javax.swing.JButton();
        jugar = new javax.swing.JButton();
        finalizar = new javax.swing.JButton();

        dialogo.setTitle("Guardar palabras");
        dialogo.setMinimumSize(new java.awt.Dimension(500, 450));
        dialogo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("palabra:");
        dialogo.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 120, -1, -1));

        areaintroducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaintroducirActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(areaintroducir, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 140, -1));

        añadir.setText("Añadir");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(añadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, -1, -1));

        dialogo2.setTitle("Te has ahorcado");
        dialogo2.setMinimumSize(new java.awt.Dimension(400, 400));
        dialogo2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("¿Volver a Jugar?");
        dialogo2.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 160, 40));

        si.setText("Si");
        si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siActionPerformed(evt);
            }
        });
        dialogo2.getContentPane().add(si, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        no.setText("No");
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });
        dialogo2.getContentPane().add(no, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel6.setText("Te has ahorcado  :_-(");
        dialogo2.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juego del ahorcado");
        setMinimumSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        areapalabra.setEditable(false);
        getContentPane().add(areapalabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 69, 150, 30));

        jLabel1.setText("Palabra");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        arealetra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                arealetraKeyReleased(evt);
            }
        });
        getContentPane().add(arealetra, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 30, 30));

        jLabel2.setText("Letra");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        areaintentos.setEditable(false);
        getContentPane().add(areaintentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 30, 30));

        jLabel3.setText("Intentos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        introducir.setText("Introducir palabras");
        introducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                introducirActionPerformed(evt);
            }
        });
        getContentPane().add(introducir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jugar.setText("Jugar");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });
        getContentPane().add(jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        finalizar.setText("Finalizar");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });
        getContentPane().add(finalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        dialogo.dispose();
        arealetra.requestFocus();
    }//GEN-LAST:event_salirActionPerformed

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed
        // TODO add your handling code here:
        nuevaPalabra();
        areaintroducir.setText("");
        areaintroducir.requestFocus();
    }//GEN-LAST:event_añadirActionPerformed

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
        // TODO add your handling code here:
        cadena1.delete(0, cadena1.length());
        intentos=5;
        areaintentos.setText(intentos+"");
        establecerPalabra();
        arealetra.requestFocus();
    }//GEN-LAST:event_jugarActionPerformed

    private void introducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_introducirActionPerformed
        // TODO add your handling code here:
        dialogo.show();
        dialogo.pack();
    }//GEN-LAST:event_introducirActionPerformed

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_finalizarActionPerformed

    private void arealetraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_arealetraKeyReleased
        // TODO add your handling code here:
        comprobarLetra();
        intentos--;
        areaintentos.setText(intentos+"");
        if(intentos==0){
            dialogo2.show();
            dialogo2.pack();
        }
    }//GEN-LAST:event_arealetraKeyReleased

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_noActionPerformed

    private void siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siActionPerformed
        // TODO add your handling code here:
        areapalabra.setText("");
        arealetra.setText("");
        intentos=5;
        areaintentos.setText(intentos+"");
        cadena1.delete(0, cadena1.length());
        establecerPalabra();
        dialogo2.dispose();
        arealetra.requestFocus();
    }//GEN-LAST:event_siActionPerformed

    private void areaintroducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaintroducirActionPerformed
        // TODO add your handling code here:
        nuevaPalabra();
        areaintroducir.setText("");
        areaintroducir.requestFocus();
    }//GEN-LAST:event_areaintroducirActionPerformed

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
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ahorcado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areaintentos;
    private javax.swing.JTextField areaintroducir;
    private javax.swing.JTextField arealetra;
    private javax.swing.JTextField areapalabra;
    private javax.swing.JButton añadir;
    private javax.swing.JDialog dialogo;
    private javax.swing.JDialog dialogo2;
    private javax.swing.JButton finalizar;
    private javax.swing.JButton introducir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jugar;
    private javax.swing.JButton no;
    private javax.swing.JButton salir;
    private javax.swing.JButton si;
    // End of variables declaration//GEN-END:variables
}
