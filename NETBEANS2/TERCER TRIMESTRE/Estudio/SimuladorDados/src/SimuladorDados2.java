public class SimuladorDados2 extends javax.swing.JFrame implements Runnable {
    Thread hilo1;
    int cont1=0,cont2=0,cont3=0,cont4=0,cont5=0,cont6=0;
    Bombo bombo;
    public SimuladorDados2() {
        initComponents();
        hilo1=null;
        this.setLocationRelativeTo(null);
        this.pack();
        bombo=new Bombo(20);
        area1.setText("Nº veces 1: "+cont1);
        area2.setText("Nº veces 2: "+cont2);
        area3.setText("Nº veces 3: "+cont3);
        area4.setText("Nº veces 4: "+cont4);
        area5.setText("Nº veces 5: "+cont5);
        area6.setText("Nº veces 6: "+cont6);
    }
    public void run(){
        try{
         contar();
        } catch(InterruptedException e){}
    }
    public void contar() throws InterruptedException{
        int hasta;
        if(automatico.isSelected()){
            int tiradas=(int)(Math.random()*bombo.sacaBola()+1);
            hasta=tiradas;
        }else{
        hasta=Integer.parseInt(areatiradas.getText());
        }
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
        area1.setText("Nº veces 1:");

        area2.setEditable(false);
        area2.setText("Nº veces 2:");

        area3.setEditable(false);
        area3.setText("Nº veces 3:");

        area4.setEditable(false);
        area4.setText("Nº veces 4:");

        area5.setEditable(false);
        area5.setText("Nº veces 5:");

        area6.setEditable(false);
        area6.setText("Nº veces 6:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(simular)
                                .addGap(18, 18, 18)
                                .addComponent(parar)
                                .addGap(18, 18, 18)
                                .addComponent(continuar)
                                .addGap(18, 18, 18)
                                .addComponent(limpiar)
                                .addGap(18, 18, 18)
                                .addComponent(salir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(239, 239, 239)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(areatiradas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(automatico)
                                    .addComponent(manual))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(area1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(area4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(area2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(area3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(area5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(area6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areatiradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(automatico)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(area4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(area1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(area2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(area5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(area3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(area6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simular)
                    .addComponent(parar)
                    .addComponent(continuar)
                    .addComponent(limpiar)
                    .addComponent(salir))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void simularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simularActionPerformed
        comenzarHilo();
    }//GEN-LAST:event_simularActionPerformed
    private void pararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pararActionPerformed
        pararHilo();
    }//GEN-LAST:event_pararActionPerformed
    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        reanudarHilo();
    }//GEN-LAST:event_continuarActionPerformed
    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarActionPerformed
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed
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
            java.util.logging.Logger.getLogger(SimuladorDados2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimuladorDados2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimuladorDados2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimuladorDados2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimuladorDados2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
