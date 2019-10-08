import javax.swing.JOptionPane;
public class MainVector{
    public static void main(String[] args){
        /*int n= Integer.parseInt(JOptionPane.showInputDialog("Introduce tamaño de vector: "));
        int v[]=new int[n];*/
        /*int v[]=new int[30];
        Array array=new Array();
        array.rellenarAleatorio(v,100);
        array.ordenarVector(v);
        array.visualizarVector(v);   */
        
        VectorNumerico v=new VectorNumerico(5);
        v.rellena();
        v.visualiza();
        v.invierte();
         v.visualiza();
         v.ordena();
         v.visualiza();
         v.rotaDerecha();
         v.visualiza();
         v.rotaIzquierda();
         v.visualiza();
        
        
        
        
    }
   
}
