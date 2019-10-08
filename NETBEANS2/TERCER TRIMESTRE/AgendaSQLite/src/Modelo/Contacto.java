package Modelo;
public class Contacto {
    private String nombre, direccion, localidad, telefonos, correo;
    private int edad;
    public Contacto(String nom, String dir, String loc, String tlf, String correo, int edad){
        nombre=nom;
        direccion=dir;
        localidad=loc;
        telefonos=tlf;
        this.correo=correo;
        this.edad=edad;
    }
    public String getNombre() {return nombre;}
    public String getDireccion() {return direccion;}
    public String getLocalidad() {return localidad;}
    public String getTelefonos() {return telefonos;}
    public String getCorreo() {return correo;}
    public int getEdad() {return edad;}
}
