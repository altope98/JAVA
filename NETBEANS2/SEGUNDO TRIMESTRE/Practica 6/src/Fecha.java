/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alvaro
 */
public class Fecha extends java.awt.Frame {

    /**
     * Creates new form Fecha
     */
    public Fecha() {
        initComponents();
        generador();
        this.pack();
        limpiardias();
    }

    public void generador(){
        
        for (int i=1;i<=12;i++){
            switch (i){
                case 1: choicemes.addItem("Enero");break;
                case 2: choicemes.addItem("Febrero");break;
                case 3: choicemes.addItem("Marzo");break;
                case 4: choicemes.addItem("Abril");break;
                case 5: choicemes.addItem("Mayo");break;
                case 6: choicemes.addItem("Junio");break;
                case 7: choicemes.addItem("Julio");break;
                case 8: choicemes.addItem("Agosto");break;
                case 9: choicemes.addItem("Septiembre");break;
                case 10: choicemes.addItem("Octubre");break;
                case 11: choicemes.addItem("Noviembre");break;
                case 12: choicemes.addItem("Diciembre");break;
            }
        }

        
    }
    public void cambio(){
        limpiardias();
        String mes=choicemes.getSelectedItem();
        if(mes.equals("Abril")|| mes.equals("Junio") || mes.equals("Septiembre") || mes.equals("Noviembre")){
                for(int j=1;j<=30;j++){
                    choicedia.add(j+"");
                }
            }else{
            if(mes.equals("Febrero")){
                for(int j=1;j<=28;j++){
                    choicedia.add(j+"");
                }
            }else{
            for(int j=1;j<=31;j++){
                choicedia.add(j+"");
            }
        }
            }
        
    }
    public void limpiardias(){
                
        choicedia.removeAll();
        if(choicemes.getSelectedItem().equals("Enero")){
            for (int i=1;i<=31;i++){
            choicedia.add(""+i);
            
        }choicedia.select("1");
            
        }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        choicedia = new java.awt.Choice();
        label2 = new java.awt.Label();
        choicemes = new java.awt.Choice();
        barra = new java.awt.Scrollbar();
        reset = new java.awt.Button();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setText("Dia");
        add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));
        add(choicedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 70, -1));

        label2.setText("Mes");
        add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        choicemes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choicemesItemStateChanged(evt);
            }
        });
        add(choicemes, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 110, -1));

        barra.setMaximum(375);
        barra.setMinimumSize(new java.awt.Dimension(100, 30));
        barra.setOrientation(java.awt.Scrollbar.HORIZONTAL);
        barra.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                barraAdjustmentValueChanged(evt);
            }
        });
        add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 210, 30));

        reset.setLabel("Resetear");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void choicemesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choicemesItemStateChanged
        // TODO add your handling code here:
        cambio();    
    }//GEN-LAST:event_choicemesItemStateChanged

    
//    HACER LO DE LA BARRA **************************************
    
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        choicemes.select("Enero");
        limpiardias();
        barra.setValue(0);
    }//GEN-LAST:event_resetActionPerformed
int valor=0;
    private void barraAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_barraAdjustmentValueChanged
        // TODO add your handling code here:
            
    valor = evt.getValue();
        if (valor <= 30) {
            choicedia.select(valor);
            choicemes.select(0);
        }
        if (valor > 30 && valor <= 58) {
            choicedia.select(valor - 31);
            choicemes.select(1);
        }
        if (valor > 58 && valor <= 89) {
            choicedia.select(valor - 59);
            choicemes.select(2);
        }
        if (valor > 89 && valor <= 119) {
            choicedia.select(valor - 90);
            choicemes.select(3);
        }
        if (valor > 119 && valor <= 150) {
            choicedia.select(valor - 120);
            choicemes.select(4);
        }
        if (valor > 150 && valor <= 180) {
            choicedia.select(valor - 151);
            choicemes.select(5);
        }
        if (valor > 180 && valor <= 211) {
            choicedia.select(valor - 181);
            choicemes.select(6);
        }
        if (valor > 211 && valor <= 242) {
            choicedia.select(valor - 212);
            choicemes.select(7);
        }
        if (valor > 242 && valor <= 272) {
            choicedia.select(valor - 243);
            choicemes.select(8);
        }
        if (valor > 272 && valor <= 303) {
            choicedia.select(valor - 273);
            choicemes.select(9);
        }
        if (valor > 303 && valor <= 333) {
            choicedia.select(valor - 304);
            choicemes.select(10);
        }
        if (valor > 333 && valor <= 364) {
            choicedia.select(valor - 334);
            choicemes.select(11);
        }

    }//GEN-LAST:event_barraAdjustmentValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fecha().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Scrollbar barra;
    private java.awt.Choice choicedia;
    private java.awt.Choice choicemes;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Button reset;
    // End of variables declaration//GEN-END:variables
}
