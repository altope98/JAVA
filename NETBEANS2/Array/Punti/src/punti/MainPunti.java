/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punti;

/**
 *
 * @author Alvaro
 */
public class MainPunti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    Punti x1=new Punti(1,1);
    Punti x2=new Punti(8,1);
    Punti y1=new Punti(1,8);
    Punti y2=new Punti(8,8);
    
    Segmento s1=new Segmento(x1,y1);
    Segmento s2=new Segmento(x2,y2);
    System.out.println(x1.distancia(x2));
    Rectangulo rec1=new Rectangulo(s1,s2);
    System.out.println(rec1.area());
    
    System.out.println(rec1.perimetro());
    
        
        
    }
    
}
