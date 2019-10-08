
import java.util.Vector;

public class VectorNumerico {
     private int vector[];
    public VectorNumerico(int tamaño){
        vector= new int[tamaño];
    }
    
    public VectorNumerico(){
        this(100);
    }
    
    public void rellena(){
       
        for(int i=0;i<vector.length;i++){
                int random=(int)(Math.random()*100+1);
                vector[i]=random;
        }
    }
    public void rellena(int n){
         for(int i=0;i<vector.length;i++){
                int random=(int)(Math.random()*n+1);
                vector[i]=random;
        }
    }
    
    public void visualiza(){
        for(int i=0;i<vector.length;i++){   
            System.out.print(vector[i]+"   "); 
        }
         System.out.println("  ");
    }
   public void invierte(){
        int aux;
        for(int i=0; i<vector.length/2; i++) {
            aux = vector[i];
            vector[i] = vector[vector.length-1-i];
            vector[vector.length-1-i] = aux;   
        }
    }
    
    public void ordena(){
        for(int i=1; i<vector.length;i++){
            for(int j=0;j<vector.length-1;j++){
                if(vector[j]>vector[j+1]){
                    int aux=vector[j];
                    vector[j]=vector[j+1];
                    vector[j+1]=aux;
                }
            }
        }      
    }
    
    
    public void rotaDerecha(){
        int aux;
        aux=vector[vector.length-1];
      for(int i=vector.length-1; i>0; i--){
                vector[i] = vector[i-1];            
        }
      vector[0]=aux;
    }
    public void rotaIzquierda(){
        int aux;
        aux=vector[0];
        for(int i=0; i<vector.length-1; i++){
                vector[i] = vector[i+1];            
        }
      vector[vector.length-1]=aux;   
    }
}
