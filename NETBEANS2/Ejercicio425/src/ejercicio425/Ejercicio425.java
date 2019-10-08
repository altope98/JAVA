package ejercicio425;

import javax.swing.JOptionPane;

public class Ejercicio425 {
    public static void main(String[] args) {
                double nota;
                double ins=0,suf=0,bien=0,notable=0,sob=0,total=0;	
		nota=Double.parseDouble(JOptionPane.showInputDialog("Introduce nota [0 para finalizar]: "));
                while (nota!=0)
		{
                    total++;
                    if(nota<0){
                        total--;
                    }
                    else if(nota<5){
                        ins++;
                    }else if(nota<6){
                        suf++;
                    }else if(nota<7){
                        bien++;
                    }else if(nota<9){
                        notable++;
                    }else if (nota <=10){
                        sob++;
                    }
                    nota=Integer.parseInt(JOptionPane.showInputDialog("Introduce nota [0 para finalizar]: "));
                }  
                System.out.println("Insuficientes: "+ins/total*100+"%");
                System.out.println("Suficientes: "+suf/total*100+"%");
                System.out.println("Bienes: "+bien/total*100+"%");
                System.out.println("Notables: "+notable/total*100+"%");
                System.out.println("Sobresalientes: "+sob/total*100+"%");
    } 
}
