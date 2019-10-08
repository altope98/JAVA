public class MainLista {
    public static void main(String[] args) {
        Lista lista=new Lista();
        String coche=new String("Peugeot");
        String coche2=new String("BMW");
        
        lista.ponPrimero(coche);
        lista.ponUltimo(coche2);
        lista.extraePrimero();
        lista.visualizaElementos();
        
    }
    
}
