/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvar
 */
public class ContarDescontar extends java.awt.Frame {

    /**
     * Creates new form ContarDescontar
     */
    public ContarDescontar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        area1 = new java.awt.TextField();
        area2 = new java.awt.TextField();
        parar1 = new java.awt.Button();
        reanudar1 = new java.awt.Button();
        comenzar1 = new java.awt.Button();
        parar2 = new java.awt.Button();
        reanudar2 = new java.awt.Button();
        comenzar2 = new java.awt.Button();
        salir = new java.awt.Button();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(area1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 70, -1));
        add(area2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 70, -1));

        parar1.setLabel("Parar");
        add(parar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        reanudar1.setLabel("Reanudar");
        add(reanudar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        comenzar1.setLabel("Comenzar");
        add(comenzar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        parar2.setLabel("Parar");
        add(parar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        reanudar2.setLabel("Reanudar");
        add(reanudar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        comenzar2.setLabel("Comenzar");
        add(comenzar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));

        salir.setLabel("Salir");
        add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContarDescontar().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected java.awt.TextField area1;
    protected java.awt.TextField area2;
    protected java.awt.Button comenzar1;
    protected java.awt.Button comenzar2;
    protected java.awt.Button parar1;
    protected java.awt.Button parar2;
    protected java.awt.Button reanudar1;
    protected java.awt.Button reanudar2;
    protected java.awt.Button salir;
    // End of variables declaration//GEN-END:variables
}
