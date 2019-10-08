/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bombo;

import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class MainBombo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
     int n=Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de bolas en el bombo: "));
     //int v[];
     Bombo boleto=new Bombo(n);
     boleto.crearVector(n);
     for(int i=0;i<=6;i++){
         boleto.sacaBola();
     }
     boleto.visualizar();
    }
    
}
