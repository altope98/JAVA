package Modelo;

public class Contacto {
    private String nombre;
    private String direccion;
    private String localidad;
    private String telefonos;
    private String correo;
    private int edad;
    public Contacto(String nom, String dir, String loc, String tel, String mail, int ed){
        nombre=nom; direccion=dir; localidad=loc; telefonos=tel; correo=mail; edad=ed;
    }
    public Contacto(String nom, String dir, String tel, int ed){
        nombre=nom; direccion=dir; telefonos=tel; edad=ed;
    }
    public String getNombre() {return nombre;}
    public String getDireccion() {return direccion;}
    public String getTelefonos() {return telefonos;}
    public String getCorreo() {return correo;}
    public int getEdad() {return edad;}
    public String getLocalidad() {return localidad;}
}


