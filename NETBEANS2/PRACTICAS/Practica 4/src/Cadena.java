public class Cadena {
    protected String cadena;
    public Cadena(String cadena){
        this.cadena=cadena;
    }
    public void invierteCadena(){
        String cadenainvertida="";
        
        for(int i=cadena.length()-1;i>=0;i--){
            cadenainvertida=cadenainvertida+cadena.charAt(i);
        }
        cadena=cadenainvertida;
        
        
    }
    
    public void invierteCadena2(){
           StringBuffer aux=new StringBuffer(cadena);
           aux.reverse();
           cadena=aux.toString();
        
    
    }
    
    public void encriptaCadena(){
        int encriptador=0;
        String cadenafinal="";
        for(int i=0;i<cadena.length();i++){
            encriptador=Caracter.ordinal(cadena.charAt(i))+3;
            cadenafinal=cadenafinal+(char)encriptador;
            
        }
        cadena=cadenafinal;
        
        
    }
    
    
    
    public void desencriptaCadena(){
        int desencriptador=0;
        String cadenafinal="";
        for(int i=0;i<cadena.length();i++){
            desencriptador=Caracter.ascii(cadena.charAt(i))-3;
            cadenafinal=cadenafinal+(char)desencriptador;
            
        }
        cadena=cadenafinal;
    }
    
    public void visualizaCadena(){
        System.out.println(cadena);
    }
    
}
