/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploerrores;

/**
 *
 * @author alvar
 */
public class Cuenta extends java.awt.Frame implements Runnable{

    Thread hiloCuenta;
    /**
     * Creates new form Cuenta
     */
    public Cuenta() {
        initComponents();
        hiloCuenta=null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        label3 = new java.awt.Label();
        aceptar1 = new java.awt.Button();
        dialogo2 = new javax.swing.JDialog();
        label4 = new java.awt.Label();
        aceptar2 = new java.awt.Button();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        desde = new java.awt.TextField();
        hasta = new java.awt.TextField();
        result = new java.awt.TextField();
        contar = new java.awt.Button();
        parar = new java.awt.Button();
        reanudar = new java.awt.Button();
        salir = new java.awt.Button();

        dialogo.setBackground(new java.awt.Color(255, 0, 0));
        dialogo.setMinimumSize(new java.awt.Dimension(500, 400));
        dialogo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label3.setText("ERROR EN LA INTRODUCCION DE DESDE");
        dialogo.getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 300, 70));

        aceptar1.setLabel("ACEPTAR");
        aceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar1ActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(aceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, -1));

        dialogo2.setBackground(new java.awt.Color(255, 0, 0));
        dialogo2.setMinimumSize(new java.awt.Dimension(500, 400));
        dialogo2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label4.setText("ERROR EN LA INTRODUCCION DE HASTA");
        dialogo2.getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 260, 80));

        aceptar2.setLabel("ACEPTAR");
        aceptar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar2ActionPerformed(evt);
            }
        });
        dialogo2.getContentPane().add(aceptar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));

        setTitle("Ejemplo bloque try catch");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setText("Desde");
        add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        label2.setText("Hasta");
        add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

        desde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desdeActionPerformed(evt);
            }
        });
        add(desde, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 50, -1));

        hasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hastaActionPerformed(evt);
            }
        });
        add(hasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 60, -1));

        result.setEditable(false);
        add(result, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 60, -1));

        contar.setLabel("Contar");
        contar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contarActionPerformed(evt);
            }
        });
        add(contar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        parar.setLabel("Parar");
        parar.setName(""); // NOI18N
        parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pararActionPerformed(evt);
            }
        });
        add(parar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        reanudar.setLabel("Reanudar");
        reanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reanudarActionPerformed(evt);
            }
        });
        add(reanudar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));

        salir.setLabel("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    
    
    public void nuevoHilo() {
        if(hiloCuenta==null) {
            hiloCuenta = new Thread(this);
            hiloCuenta.start();      
        }
    }
   public void iniciarHilo()
{	
	if(hiloCuenta!=null)
	hiloCuenta.resume();
}
    public void pararHilo ()
{
	if(hiloCuenta != null)
	hiloCuenta.suspend();
}
    public void crearHilo()
{

    if (hiloCuenta==null)
{
    hiloCuenta = new Thread (this);
    hiloCuenta.start();
}
}
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm
    public void contar()
    {
        bol=true;
        bol2=true;
        try{
        n1=Integer.parseInt(desde.getText());
        } catch(NumberFormatException e)
        {
           /* n1=1;
            desde.setText(""+n1);*/
            bol=false;
            dialogo.show(); 
        }
        
           
           try{
                n2=Integer.parseInt(hasta.getText());
                } catch(NumberFormatException e)
                {
                /*n2=100;
                hasta.setText(""+n2);*/
                    bol2=false;
                    dialogo2.show();
            
                }
        
                
            
        if (bol==true && bol2==true){
        for (int i=n1;i<=n2;i++)
        {   
            result.setText(i+"");
            try{
                Thread.sleep(1000);
                
            }catch(InterruptedException e)
            {}
            
        }
        }
    }
    private void contarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contarActionPerformed
        // TODO add your handling code here:
        contar();
        
    }//GEN-LAST:event_contarActionPerformed

    private void desdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desdeActionPerformed
        // TODO add your handling code here:
        hasta.requestFocus(); 
    }//GEN-LAST:event_desdeActionPerformed

    private void hastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hastaActionPerformed
        // TODO add your handling code here:
        contar();//con esto lo que haces es darle al intro pa contarpero no funciona
    }//GEN-LAST:event_hastaActionPerformed

    private void aceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar1ActionPerformed
        // TODO add your handling code here:
        desde.setText("");
        desde.requestFocus();
        dialogo.dispose();
        bol=true;
        result.setText("");
    }//GEN-LAST:event_aceptar1ActionPerformed

    private void aceptar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar2ActionPerformed
        // TODO add your handling code here:
        hasta.setText("");
        hasta.requestFocus();
        dialogo2.dispose();
        bol2=true;
        result.setText("");
        
    }//GEN-LAST:event_aceptar2ActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void pararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pararActionPerformed
        // TODO add your handling code here:
        pararHilo();
    }//GEN-LAST:event_pararActionPerformed

    private void reanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reanudarActionPerformed
        // TODO add your handling code here:
        iniciarHilo();
    }//GEN-LAST:event_reanudarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cuenta().setVisible(true);
            }
        });
    }

    protected int n1,n2;
    protected boolean bol,bol2;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected java.awt.Button aceptar1;
    protected java.awt.Button aceptar2;
    protected java.awt.Button contar;
    protected java.awt.TextField desde;
    protected javax.swing.JDialog dialogo;
    protected javax.swing.JDialog dialogo2;
    protected java.awt.TextField hasta;
    protected java.awt.Label label1;
    protected java.awt.Label label2;
    protected java.awt.Label label3;
    protected java.awt.Label label4;
    protected java.awt.Button parar;
    protected java.awt.Button reanudar;
    protected java.awt.TextField result;
    protected java.awt.Button salir;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}