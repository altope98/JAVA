
public class Ejercicio3 extends java.awt.Frame {
    private Object temasob;


    public Ejercicio3() {
        initComponents();
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        label4 = new java.awt.Label();
        areadialog = new java.awt.TextField();
        aceptar = new java.awt.Button();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        temasn = new java.awt.TextField();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        nuevo = new java.awt.Button();
        añadir = new java.awt.Button();
        simular = new java.awt.Button();
        generar = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        temasp = new java.awt.List();
        temaso = new java.awt.List();
        probabilidad = new java.awt.TextField();

        dialogo.setMinimumSize(new java.awt.Dimension(500, 500));
        dialogo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label4.setText("Introduce el tema");
        dialogo.getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 120, 60));
        dialogo.getContentPane().add(areadialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 220, 20));

        aceptar.setLabel("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        setPreferredSize(new java.awt.Dimension(500, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Simulacion Oposicion"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setText("NºTemas Oposicion");
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));
        jPanel1.add(temasn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 140, -1));

        label2.setText("Temas preparados");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        label3.setText("Temas obtenidos");
        jPanel1.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        nuevo.setLabel("nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 60, -1));

        añadir.setLabel("añadir");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });
        jPanel1.add(añadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 60, -1));

        simular.setLabel("simular");
        simular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simularActionPerformed(evt);
            }
        });
        jPanel1.add(simular, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 60, -1));

        generar.setLabel("generar");
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });
        jPanel1.add(generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        jLabel1.setText("Probabilidad");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        jLabel2.setText("%");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, -1, -1));
        jPanel1.add(temasp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 110, 130));
        jPanel1.add(temaso, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 100, 90));
        jPanel1.add(probabilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 80, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 410, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
    /*
    public void simular()
    {
        
        
    }
    */
    /* 
    public void obtenerTemas(int temas[])
    {
        int n=Integer.parseInt(tfTemas.getText());
        Bombo bombo=new Bombo(n);
        for(int i=0;i<3;i++)
            temas[i]=bombo.sacaBola()+1;
    }
    */
    /*
    public void generar(){
    {
        int temas]=new int[3];
        int cont=0;
        lObtenidos.removeAll();
        for (int i=1;i<=100000;i++)
            obtenerTemas(temas);}
            if (existeTema(temas))
            cont++
        tfProbabilidad.setText(""+cont/1000);
    */
    /*
    public void existeTema(int temas[])
    {
    for (int i=0; i<lPreparados.getItemCount();i++)
        for (int j=0;j<3;j++)
            if (temas[j]==Integer.parseInt(lPreparados.getItem(i)))
                return true;
    return false;
    */
    
    
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed

        temasp.clear();
        temaso.clear();
        temasn.setText("");
        probabilidad.setText("");
        temasn.requestFocus();
    }//GEN-LAST:event_nuevoActionPerformed

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed

        dialogo.show();
        dialogo.setLocation(300,200);
    }//GEN-LAST:event_añadirActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed

        temasp.add(areadialog.getText());
        dialogo.dispose();
        areadialog.setText("");
    }//GEN-LAST:event_aceptarActionPerformed

    private void simularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simularActionPerformed

             
        
        int n=Integer.parseInt(temasn.getText());
             for(int i=1;i<=3;i++)
             {  
                 int aleatorio=(int)(Math.random()*n);
                 temaso.add(aleatorio+"");
                 
             }     
     
    }//GEN-LAST:event_simularActionPerformed

    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed

        double n=Double.parseDouble(temasn.getText());
        double n2=temasp.getItemCount(); 
        nprobabilidad=((n2/n)*100);
        probabilidad.setText(nprobabilidad+"");
    }//GEN-LAST:event_generarActionPerformed

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ejercicio3().setVisible(true);
            }
        });
    }
    
    private double nprobabilidad;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button aceptar;
    private java.awt.TextField areadialog;
    private java.awt.Button añadir;
    private javax.swing.JDialog dialogo;
    private java.awt.Button generar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Button nuevo;
    private java.awt.TextField probabilidad;
    private java.awt.Button simular;
    private java.awt.TextField temasn;
    private java.awt.List temaso;
    private java.awt.List temasp;
    // End of variables declaration//GEN-END:variables
}
