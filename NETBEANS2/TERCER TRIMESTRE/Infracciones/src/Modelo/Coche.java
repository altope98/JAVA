package Modelo;
public class Coche {
    private String codigoCoche, nombre, direccion, matricula, modelo, nif;
    public Coche(String cod, String codnif, String nomb, String dir, String matr, String model){
        codigoCoche=cod;
        nif=codnif;
        nombre=nomb;
        direccion=dir;
        matricula=matr;
        modelo=model;
    }
    public String getNombre() {return nombre;}
    public String getDireccion() {return direccion;}
    public String getCodigo() {return codigoCoche;}
    public String getMatricula() {return matricula;}
    public String getNIF() {return nif;}
    public String getModelo() {return modelo;}
}
