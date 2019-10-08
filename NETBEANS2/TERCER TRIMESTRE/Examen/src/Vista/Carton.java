package Vista;
public class Carton {
    int v[];
    public Carton(){
        v=new int[15];
    }
    public void setnumero(int posicion,int numero){
        v[posicion]=numero;
    }
    public int getnumero(int posicion){
        return v[posicion];
    }
    public int getposicion(int numero){
        int condicion=0;
        int i=0;
        for(i=0;i<v.length;i++){
            if(v[i]==numero)
                condicion=i;
        }
        return condicion; 
    }
}
