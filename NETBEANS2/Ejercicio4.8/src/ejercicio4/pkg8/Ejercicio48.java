/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4.pkg8;

import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class Ejercicio48 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double a=Double.parseDouble(JOptionPane.showInputDialog("Escribe el primer lado del triangulo "));
        double b=Double.parseDouble(JOptionPane.showInputDialog("Escribe el segundo lado del triangulo "));
        double c=Double.parseDouble(JOptionPane.showInputDialog("Escribe el tercer lado del triangulo "));
        
        if(a>=b+c){
            JOptionPane.showMessageDialog(null,"No es un triangulo");
        }else{  
        if(a*a == b*b+c*c){
            JOptionPane.showMessageDialog(null,"Es un triangulo rectangulo");
        }else{
        if(a*a > b*b+c*c){
            JOptionPane.showMessageDialog(null,"Es un triangulo obtusangulo");
            }else{
            JOptionPane.showMessageDialog(null,"Es un triangulo acutangulo");
        }
        
            }
            }
    }
    
}
