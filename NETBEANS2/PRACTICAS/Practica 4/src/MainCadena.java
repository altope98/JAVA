import javax.swing.JOptionPane;
public class MainCadena {
    public static void main(String[] args) {
        
        
        Cadena cadena=new Cadena(JOptionPane.showInputDialog("Introduce cadena"));
        
        cadena.visualizaCadena();
        cadena.invierteCadena();
        cadena.visualizaCadena();
        cadena.encriptaCadena();
        cadena.visualizaCadena();
        cadena.desencriptaCadena();
        cadena.visualizaCadena();
    }
    
}
