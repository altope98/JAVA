package Vista;
import javax.swing.table.DefaultTableModel;
public class Bingo extends javax.swing.JFrame implements Runnable {
    Thread hilo1;
    Bombo bombo1,bombo2,bombo3,bombo;
    Carton cartonjugador, cartonordenador;
    DefaultTableModel modelojugador,modeloordenador,modelobombo;
    public Bingo() {
        initComponents(); 
        this.pack();
        this.setLocationRelativeTo(null);
        dialogojugador.pack();
        dialogojugador.setLocationRelativeTo(this);
        dialogoordenador.pack();
        dialogoordenador.setLocationRelativeTo(this);
        bingoordenador.pack();
        bingoordenador.setLocationRelativeTo(this);
        bingojugador.pack();
        bingojugador.setLocationRelativeTo(this); 
    }
    public void run(){
        try{
         comenzar();
        } catch(InterruptedException e){}
    }
    public void comenzar() throws InterruptedException{
        bombo=new Bombo(90);
        cartonjugador=new Carton();
        cartonordenador=new Carton();
        generarTablas();
        rellenarTablas();
        while(Thread.currentThread()==hilo1){
        String numero=Integer.toString(bombo.sacaBola());
        for(int fila=0; fila<modelobombo.getRowCount(); fila++){
            for(int col=0; col<modelobombo.getColumnCount(); col++){
                if(modelobombo.getValueAt(fila, col).toString().equals(numero) && modelobombo.getValueAt(fila, col)!=""){
                    modelobombo.setValueAt("", fila, col);
                }
            }
        }
        label.setText(numero+"");
        int i=0;
        int j=0;
        for(int fila=0; fila<modelojugador.getRowCount(); fila++){
            for(int col=0; col<modelojugador.getColumnCount(); col++){
                if(modelojugador.getValueAt(fila, col).toString().equals(numero) && modelojugador.getValueAt(fila, col)!="X"){
                    modelojugador.setValueAt("X", fila, col);
                }
                i++;
            }
        }
        for(int fila=0; fila<modeloordenador.getRowCount(); fila++){
            for(int col=0; col<modeloordenador.getColumnCount(); col++){
                if(modeloordenador.getValueAt(fila, col).toString().equals(numero) && modeloordenador.getValueAt(fila, col)!="X"){
                    modeloordenador.setValueAt("X", fila, col);
                }
                i++;
            }
        }
        comprobar();
        Thread.sleep(1000);
        } 
    }
    public void comprobar(){
        int cont1=0,cont2=0;
        int linea1=0,linea2=0,linea3=0;
        boolean condicion=false;
        for(int col=0; col<modelojugador.getRowCount(); col++){
                if(modelojugador.getValueAt(0, col)=="X"){
                    linea1++;
                    if(linea1==5 && condicion==false){
                        pararHilo();
                        dialogojugador.show();
                        condicion=true;
                    }
                }
                if(modelojugador.getValueAt(1, col)=="X"){
                    linea2++;
                    if(linea2==5 && condicion==false){
                        pararHilo();
                        dialogojugador.show();
                        condicion=true;
                    }
                }
                if(modelojugador.getValueAt(2, col)=="X"){
                    linea3++;
                    if(linea3==5 && condicion==false){
                        pararHilo();
                        dialogojugador.show();
                        condicion=true;
                    }
                }
                linea1=0;
                linea2=0;
                linea3=0;
        }
                linea1=0;
                linea2=0;
                linea3=0;
        for(int col=0; col<modeloordenador.getRowCount(); col++){
                if(modeloordenador.getValueAt(0, col)=="X"){
                    linea1++;
                    if(linea1==5 && condicion==false){
                        pararHilo();
                        dialogoordenador.show();
                        condicion=true;
                    }
                }
                if(modeloordenador.getValueAt(1, col)=="X"){
                    linea2++;
                    if(linea2==5 && condicion==false){
                        pararHilo();
                        dialogoordenador.show();
                        condicion=true;
                    }
                }
                if(modeloordenador.getValueAt(2, col)=="X"){
                    linea3++;
                    if(linea3==5 && condicion==false){
                        pararHilo();
                        dialogoordenador.show();
                        condicion=true;
                    }
                }
                linea1=0;
                linea2=0;
                linea3=0;
        }
        
        for(int fila=0; fila<modelojugador.getRowCount(); fila++){
            for(int col=0; col<modelojugador.getColumnCount(); col++){
                 if(modelojugador.getValueAt(fila, col)=="X"){
                     cont1++;
                 }
            }
        }
        if(cont1==15){
            bingojugador.show();
            pararHilo();
        }
        for(int fila=0; fila<modeloordenador.getRowCount(); fila++){
            for(int col=0; col<modeloordenador.getColumnCount(); col++){
                if(modeloordenador.getValueAt(fila, col)=="X"){
                     cont2++;
                 }
            }
        }
        if(cont2==15){
            bingoordenador.show();
            pararHilo();
        }
    }
    public void comenzarHilo(){
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
    public void generarTablas(){
        modelobombo=new DefaultTableModel();
        modelojugador=new DefaultTableModel();
        modeloordenador=new DefaultTableModel();
        for(int i=1;i<=10;i++){
            modelobombo.addColumn("");
        }
        for(int i=1;i<=9;i++){
            agregarFilaBombo();
        }
        tablabombo.setModel(modelobombo);
        for(int i=1;i<=5;i++){
            modelojugador.addColumn("");
            modeloordenador.addColumn("");
        }
        for(int i=1;i<=3;i++){
            agregarFilaJugador();
            agregarFilaOrdenador();
        }
        tablajugador.setModel(modelojugador);
        tablaordenador.setModel(modeloordenador);
    }
    public void rellenarTablas(){
        bombo1=new Bombo(90);
        int i=0;
        for(int fila=0; fila<modelobombo.getRowCount(); fila++){
            for(int col=0; col<modelobombo.getColumnCount(); col++){
                modelobombo.setValueAt(bombo1.sacaBola(), fila, col);
            }
        }
        bombo2=new Bombo(90);
        bombo3=new Bombo(90);
        for(int fila=0; fila<modelojugador.getRowCount(); fila++){
            for(int col=0; col<modelojugador.getColumnCount(); col++){
                cartonjugador.setnumero(i, bombo2.sacaBola());
                cartonordenador.setnumero(i, bombo3.sacaBola());
                modelojugador.setValueAt(cartonjugador.getnumero(i), fila, col);
                modeloordenador.setValueAt(cartonordenador.getnumero(i), fila, col);
                i++;
            }
        }
        
    }
    public void agregarFilaBombo(){
        modelobombo.addRow(new Object[tablabombo.getColumnCount()]);
    }
    public void agregarFilaJugador(){
        modelojugador.addRow(new Object[tablajugador.getColumnCount()]);
    }
    public void agregarFilaOrdenador(){
        modeloordenador.addRow(new Object[tablaordenador.getColumnCount()]);
    }
    public void eliminarFilas(DefaultTableModel modelo){
        for(int i=modelo.getRowCount()-1; i>=0;i--){
            modelo.removeRow(i);
        }
    }
    public void limpiar(){
        eliminarFilas(modelojugador);
        eliminarFilas(modeloordenador);
        eliminarFilas(modelobombo);
        label.setText(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogojugador = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        aceptarjugador = new javax.swing.JButton();
        dialogoordenador = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        aceptarordenador = new javax.swing.JButton();
        bingojugador = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        aceptarjugador2 = new javax.swing.JButton();
        bingoordenador = new javax.swing.JDialog();
        aceptarordenador2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comenzar = new javax.swing.JButton();
        parar = new javax.swing.JButton();
        continuar = new javax.swing.JButton();
        finalizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablabombo = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablajugador = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaordenador = new javax.swing.JTable();
        label = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Linea para jugador");

        aceptarjugador.setText("Aceptar");
        aceptarjugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarjugadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogojugadorLayout = new javax.swing.GroupLayout(dialogojugador.getContentPane());
        dialogojugador.getContentPane().setLayout(dialogojugadorLayout);
        dialogojugadorLayout.setHorizontalGroup(
            dialogojugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogojugadorLayout.createSequentialGroup()
                .addGroup(dialogojugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogojugadorLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(aceptarjugador))
                    .addGroup(dialogojugadorLayout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel3)))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        dialogojugadorLayout.setVerticalGroup(
            dialogojugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogojugadorLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(aceptarjugador)
                .addGap(107, 107, 107))
        );

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Linea para ordenador");

        aceptarordenador.setText("Aceptar");
        aceptarordenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarordenadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogoordenadorLayout = new javax.swing.GroupLayout(dialogoordenador.getContentPane());
        dialogoordenador.getContentPane().setLayout(dialogoordenadorLayout);
        dialogoordenadorLayout.setHorizontalGroup(
            dialogoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogoordenadorLayout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(106, 106, 106))
            .addGroup(dialogoordenadorLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(aceptarordenador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogoordenadorLayout.setVerticalGroup(
            dialogoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoordenadorLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(aceptarordenador)
                .addGap(76, 76, 76))
        );

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Bingo para el jugador");

        aceptarjugador2.setText("Aceptar");
        aceptarjugador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarjugador2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bingojugadorLayout = new javax.swing.GroupLayout(bingojugador.getContentPane());
        bingojugador.getContentPane().setLayout(bingojugadorLayout);
        bingojugadorLayout.setHorizontalGroup(
            bingojugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bingojugadorLayout.createSequentialGroup()
                .addGroup(bingojugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bingojugadorLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel5))
                    .addGroup(bingojugadorLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(aceptarjugador2)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        bingojugadorLayout.setVerticalGroup(
            bingojugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bingojugadorLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel5)
                .addGap(90, 90, 90)
                .addComponent(aceptarjugador2)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        aceptarordenador2.setText("Aceptar");
        aceptarordenador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarordenador2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Bingo para el ordenador");

        javax.swing.GroupLayout bingoordenadorLayout = new javax.swing.GroupLayout(bingoordenador.getContentPane());
        bingoordenador.getContentPane().setLayout(bingoordenadorLayout);
        bingoordenadorLayout.setHorizontalGroup(
            bingoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bingoordenadorLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(aceptarordenador2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bingoordenadorLayout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(88, 88, 88))
        );
        bingoordenadorLayout.setVerticalGroup(
            bingoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bingoordenadorLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(aceptarordenador2)
                .addGap(84, 84, 84))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jugando al bingo");

        comenzar.setText("Comenzar");
        comenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comenzarActionPerformed(evt);
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

        finalizar.setText("Finalizar");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Bombo"));

        tablabombo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablabombo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cartones"));

        jLabel1.setText("Jugador");

        jLabel2.setText("Ordenador");

        tablajugador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablajugador);

        tablaordenador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablaordenador);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        label.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(comenzar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(parar)
                                .addGap(76, 76, 76)
                                .addComponent(continuar)
                                .addGap(81, 81, 81)
                                .addComponent(finalizar)
                                .addGap(69, 69, 69))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comenzar)
                    .addComponent(parar)
                    .addComponent(continuar)
                    .addComponent(finalizar))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void comenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comenzarActionPerformed
        comenzarHilo();
    }//GEN-LAST:event_comenzarActionPerformed
    private void pararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pararActionPerformed
        pararHilo();
    }//GEN-LAST:event_pararActionPerformed
    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        reanudarHilo();
    }//GEN-LAST:event_continuarActionPerformed
    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_finalizarActionPerformed
    private void aceptarjugador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarjugador2ActionPerformed
        bingojugador.dispose();
        limpiar();
        hilo1=null;
    }//GEN-LAST:event_aceptarjugador2ActionPerformed
    private void aceptarordenador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarordenador2ActionPerformed
        bingoordenador.dispose();
        limpiar();
        hilo1=null;
    }//GEN-LAST:event_aceptarordenador2ActionPerformed
    private void aceptarordenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarordenadorActionPerformed
        dialogoordenador.dispose();
        reanudarHilo();
    }//GEN-LAST:event_aceptarordenadorActionPerformed
    private void aceptarjugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarjugadorActionPerformed
        dialogojugador.dispose();
        reanudarHilo();
    }//GEN-LAST:event_aceptarjugadorActionPerformed
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
            java.util.logging.Logger.getLogger(Bingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bingo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarjugador;
    private javax.swing.JButton aceptarjugador2;
    private javax.swing.JButton aceptarordenador;
    private javax.swing.JButton aceptarordenador2;
    private javax.swing.JDialog bingojugador;
    private javax.swing.JDialog bingoordenador;
    private javax.swing.JButton comenzar;
    private javax.swing.JButton continuar;
    private javax.swing.JDialog dialogojugador;
    private javax.swing.JDialog dialogoordenador;
    private javax.swing.JButton finalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label;
    private javax.swing.JButton parar;
    private javax.swing.JTable tablabombo;
    private javax.swing.JTable tablajugador;
    private javax.swing.JTable tablaordenador;
    // End of variables declaration//GEN-END:variables
}
