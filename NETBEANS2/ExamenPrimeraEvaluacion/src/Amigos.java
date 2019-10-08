import javax.swing.JOptionPane;
public class Amigos {
    public static void main(String[] args) {
       int n1=Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer numero"));
       int n2=Integer.parseInt(JOptionPane.showInputDialog("Introduce el segundo numero"));      
       if(Mate.amigos(n1, n2)){
           JOptionPane.showMessageDialog(null, "Los numeros "+n1+" y "+n2+" son amigos");
       }else{
           JOptionPane.showMessageDialog(null, "Los numeros "+n1+" y "+n2+" no son amigos");
       }
    }
}
