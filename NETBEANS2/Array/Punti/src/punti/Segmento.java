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
public class Segmento {
     protected Punti punto1,punto2;
    
    public Segmento(Punti p, Punti q){
        
        this.punto1=p;
        this.punto2=q;
    }
    public double longitudSegmento(){
        
        return punto1.distancia(punto2);
    }
}
