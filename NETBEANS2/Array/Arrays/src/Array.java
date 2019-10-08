
import javax.swing.JOptionPane;


public class Array {
    
    
    
    
     public void rellenarVector(int v[]){
        for(int i=0;i<v.length;i++){
            v[i]= Integer.parseInt(JOptionPane.showInputDialog("Introduce numero: "));
        }
    }
    public void visualizarVector(int v[]){
        for (int i=0;i<v.length;i++){
            System.out.println(v[i]);
        }
    }
    public void ordenarVector(int v[]){ /*menor a mayor*/
        for(int i=1; i<v.length;i++){
            for(int j=0;j<v.length-1;j++){
                if(v[j]>v[j+1]){
                    int aux=v[j];
                    v[j]=v[j+1];
                    v[j+1]=aux;
                }
            }
        }
    }
    
    public void rellenarAleatorio(int v[],int n){
        for (int i=0; i<v.length;i++){
            v[i]=(int) (Math.random()*n+1);
            
        }
    }
    
    
}
