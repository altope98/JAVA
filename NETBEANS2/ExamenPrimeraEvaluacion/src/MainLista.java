public class MainLista {
    public static void main(String[] args) {
        Lista lista=new Lista(4);
        lista.addElement(5);
        lista.addElement(8);
        lista.addElement(9);
        System.out.println(lista.size());
        System.out.println(lista.capacity());
        System.out.println(lista.isEmpty());
        lista.visualiza();
        //lista.visualizaVector();
        lista.removeElementAt(0);
        lista.visualiza();
        //lista.visualizaVector();
        lista.insertElementAt(7, 1); 
        lista.visualiza();
    } 
}
