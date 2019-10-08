public class Deque {
    protected Lista lista;
    public Deque(int n){
        lista=new Lista(n);
    }
    public void borraIzquierda(){
        lista.removeElementAt(0);
      }
    public void borraDerecha(){
        lista.removeElementAt(lista.v.length-1);
    }
    public void insertaIzquierda(int n){
        lista.insertElementAt(n, 0);
    }
    public void insertaDerecha(int n){
        if(lista.v[lista.v.length-1]!=0){
                for(int i=lista.v.length-1; i>0; i--){
                    if(lista.v[i]!=0){
                lista.v[i+1] = lista.v[i];
               }
        }
         lista.v[lista.v.length-1]=n;}else{
         lista.v[lista.v.length-1]=n;
        }
    }
    public void visualiza(){
        lista.visualiza();
        System.out.println("   ");
        lista.visualizaVector();
    }
}
