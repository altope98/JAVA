public class SimuladorDados extends javax.swing.JFrame implements Runnable{
    Thread hilo1;
    Bombo bombo;
    int cont1,cont2,cont3,cont4,cont5,cont6;
    public SimuladorDados() {
        initComponents();
        this.pack();
        hilo1=null;
        bombo=new Bombo(10);
    }
    public void run(){
        try{
         contar();
        } catch(InterruptedException e){}
    }
    public void contar() throws InterruptedException{
        int hasta=Integer.parseInt(areatiradas.getText());
        int i = 1;
        while(i<=hasta && Thread.currentThread()==hilo1){
            int dado=(int)(Math.random()*6+1);
            area.append(dado+"\n");
            switch (dado){
                case 1:cont1++;area1.setText("Nº veces 1: "+cont1);break;
                case 2:cont2++;area2.setText("Nº veces 2: "+cont2);break;
                case 3:cont3++;area3.setText("Nº veces 3: "+cont3);break;
                case 4:cont4++;area4.setText("Nº veces 4: "+cont4);break;
                case 5:cont5++;area5.setText("Nº veces 5: "+cont5);break;
                case 6:cont6++;area6.setText("Nº veces 6: "+cont6);break;
            }
            Thread.sleep(500);
            i++;
        }
    }
    public void comenzarHilo(){
        if(automatico.isSelected()){
            parar.setEnabled(false);
            continuar.setEnabled(false);
            
        }else{
            parar.setEnabled(true);
            continuar.setEnabled(true);
        }
        if(hilo1==null){
            hilo1 = new Thread(this);
            hilo1.start();      
        }
    }
   public void reanudarHilo(){	
	if(hilo1!=null)
	hilo1.resume();
    }
    public void pararHilo(){
	if(hilo1 != null)
	hilo1.suspend();
    }
    public void limpiar(){
        areatiradas.setText(null);
        areatiradas.requestFocus();
        manual.setSelected(true);
        area.setText(null);
        cont1=0;
        cont2=0;
        cont3=0;
        cont4=0;
        cont5=0;
        cont6=0;
        area1.setText("Nº veces 1: "+cont1);
        area2.setText("Nº veces 2: "+cont2);
        area3.setText("Nº veces 3: "+cont3);
        area4.setText("Nº veces 4: "+cont4);
        area5.setText("Nº veces 5: "+cont5);
        area6.setText("Nº veces 6: "+cont6);
        hilo1=null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        areatiradas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        manual = new javax.swing.JRadioButton();
        automatico = new javax.swing.JRadioButton();
        area1 = new javax.swing.JTextField();
        area2 = new javax.swing.JTextField();
        area3 = new javax.swing.JTextField();
        area4 = new javax.swing.JTextField();
        area5 = new javax.swing.JTextField();
        area6 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        simular = new javax.swing.JButton();
        parar = new javax.swing.JButton();
        continuar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        dialogo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("El Nº de tiradas no tiene el formato adecuado");
        dialogo.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador dado");
        setResizable(false);

        jLabel2.setText("Nº Tiradas");

        jLabel3.setText("Modo");

        buttonGroup1.add(manual);
        manual.setSelected(true);
        manual.setText("Manual");

        buttonGroup1.add(automatico);
        automatico.setText("Automatico");

        area1.setEditable(false);
        area1.setText("Nº veces 1: 0");

        area2.setEditable(false);
        area2.setText("Nº veces 2: 0");

        area3.setEditable(false);
        area3.setText("Nº veces 3: 0");

        area4.setEditable(false);
        area4.setText("Nº veces 4: 0");

        area5.setEditable(false);
        area5.setText("Nº veces 5: 0");

        area6.setEditable(false);
        area6.setText("Nº veces 6: 0");

        area.setEditable(false);
        area.setColumns(20);
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        simular.setText("Simular");
        simular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simularActionPerformed(evt);
            }
        });

        parar.setText("Parar");
        parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pararActionPerformed(evt);
            }
        });

        continuar.setText("Continuar");
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });

        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel2)
                .addGap(272, 272, 272)
                .addComponent(jLabel3))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(areatiradas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manual)
                    .addComponent(automatico)))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(area1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(area4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(area2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(area5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(area3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(area6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(simular)
                .addGap(6, 6, 6)
                .addComponent(parar)
                .addGap(8, 8, 8)
                .addComponent(continuar)
                .addGap(5, 5, 5)
                .addComponent(limpiar)
                .addGap(7, 7, 7)
                .addComponent(salir))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(areatiradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(manual)
                        .addGap(2, 2, 2)
                        .addComponent(automatico)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(area1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(area4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(area2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(area5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(area3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(area6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(simular)
                    .addComponent(parar)
                    .addComponent(continuar)
                    .addComponent(limpiar)
                    .addComponent(salir)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        dialogo.dispose();
    }//GEN-LAST:event_aceptarActionPerformed
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed
    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarActionPerformed
    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        reanudarHilo();
    }//GEN-LAST:event_continuarActionPerformed
    private void pararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pararActionPerformed
        pararHilo();
    }//GEN-LAST:event_pararActionPerformed
    private void simularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simularActionPerformed
        comenzarHilo();
    }//GEN-LAST:event_simularActionPerformed
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
            java.util.logging.Logger.getLogger(SimuladorDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimuladorDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimuladorDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimuladorDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimuladorDados().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JTextArea area;
    private javax.swing.JTextField area1;
    private javax.swing.JTextField area2;
    private javax.swing.JTextField area3;
    private javax.swing.JTextField area4;
    private javax.swing.JTextField area5;
    private javax.swing.JTextField area6;
    private javax.swing.JTextField areatiradas;
    private javax.swing.JRadioButton automatico;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton continuar;
    private javax.swing.JDialog dialogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar;
    private javax.swing.JRadioButton manual;
    private javax.swing.JButton parar;
    private javax.swing.JButton salir;
    private javax.swing.JButton simular;
    // End of variables declaration//GEN-END:variables
}
