/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alvaro
 */
public class Oposicion extends java.awt.Frame {

    /**
     * Creates new form Oposicion
     */
    public Oposicion() {
        initComponents();
        dialogo.pack();
        dialogo.setLocationRelativeTo(null);
    }

    
    public void simular(){
         
        Bombo bombo=new Bombo(Integer.parseInt(areanumero.getText()));
        for(int i=1;i<=3;i++){
        listaobtenidos.add(bombo.sacaBola()+"");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        areatema = new java.awt.TextField();
        label6 = new java.awt.Label();
        introducir = new java.awt.Button();
        cancelar = new java.awt.Button();
        jPanel1 = new javax.swing.JPanel();
        listapreparados = new java.awt.List();
        label2 = new java.awt.Label();
        label1 = new java.awt.Label();
        areanumero = new java.awt.TextField();
        label3 = new java.awt.Label();
        generar = new java.awt.Button();
        listaobtenidos = new java.awt.List();
        areaprobabilidad = new java.awt.TextField();
        nuevo = new java.awt.Button();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        simular = new java.awt.Button();
        añadir = new java.awt.Button();

        dialogo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        areatema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areatemaActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(areatema, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 270, 20));

        label6.setText("Introduce tema");
        dialogo.getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        introducir.setLabel("Introducir");
        introducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                introducirActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(introducir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        cancelar.setLabel("cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Simulacion Oposicion"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(listapreparados, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 130, 150));

        label2.setText("Temas preparados");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        label1.setText("Nº temas oposicion");
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));
        jPanel1.add(areanumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 110, -1));

        label3.setText("Temas obtenidos");
        jPanel1.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        generar.setLabel("generar");
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });
        jPanel1.add(generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));
        jPanel1.add(listaobtenidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 100, 60));

        areaprobabilidad.setEditable(false);
        jPanel1.add(areaprobabilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 70, -1));

        nuevo.setLabel("nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 60, -1));

        label4.setText("probabilidad");
        jPanel1.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 70, -1));

        label5.setText("%");
        jPanel1.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, -1, -1));

        simular.setLabel("simular");
        simular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simularActionPerformed(evt);
            }
        });
        jPanel1.add(simular, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        añadir.setLabel("añadir");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });
        jPanel1.add(añadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 60, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 500, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        // TODO add your handling code here:
        areanumero.setText(null);
        listapreparados.removeAll();
        listaobtenidos.removeAll();
        areaprobabilidad.setText(null);
    }//GEN-LAST:event_nuevoActionPerformed

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed
        // TODO add your handling code here:
        dialogo.show();
    }//GEN-LAST:event_añadirActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        dialogo.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void introducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_introducirActionPerformed
        // TODO add your handling code here:
        listapreparados.add(areatema.getText());
        areatema.setText(null);
        areatema.requestFocus();
    }//GEN-LAST:event_introducirActionPerformed

    private void simularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simularActionPerformed
        // TODO add your handling code here:
       listaobtenidos.removeAll();
        simular();
    }//GEN-LAST:event_simularActionPerformed

    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
        // TODO add your handling code here:
        int cont=0;
        for(int i=1; i<=100;i++){
            simular();
            for(int j=0;j<listapreparados.getItemCount();j++){
                for(int v=0;v<listaobtenidos.getItemCount();v++){
                   
                    if(listapreparados.getItem(j).equals(listaobtenidos.getItem(v))){
                        cont++;
                    }
                }
            }
            listaobtenidos.removeAll();
            
        }
        double probabilidad=cont*100/100;
        areaprobabilidad.setText(probabilidad+"");
        
        
    }//GEN-LAST:event_generarActionPerformed

    private void areatemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areatemaActionPerformed
        // TODO add your handling code here:
        listapreparados.add(areatema.getText());
        areatema.setText(null);
        areatema.requestFocus();
    }//GEN-LAST:event_areatemaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Oposicion().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField areanumero;
    private java.awt.TextField areaprobabilidad;
    private java.awt.TextField areatema;
    private java.awt.Button añadir;
    private java.awt.Button cancelar;
    private javax.swing.JDialog dialogo;
    private java.awt.Button generar;
    private java.awt.Button introducir;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.List listaobtenidos;
    private java.awt.List listapreparados;
    private java.awt.Button nuevo;
    private java.awt.Button simular;
    // End of variables declaration//GEN-END:variables
}
