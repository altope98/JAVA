/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infracciones;

/**
 *
 * @author alvar
 */
public class Coche {
    private String codigo,nif,nombre,direccion,matricula,nombrecoche;
    public Coche(String codigo,String nif,String nombre,String direccion,String matricula, String nombrecoche){
    
        this.codigo=codigo;
        this.nif=nif;
        this.nombre=nombre;
        this.direccion=direccion;
        this.matricula=matricula;
        this.nombrecoche=nombrecoche;
    }
    public String getCodigo() {return codigo;}
    public String getNif() {return nif;}
    public String getNombre() {return nombre;}
    public String getDireccion() {return direccion;}
    public String getMatricula() {return matricula;}
    public String getNombreCoche() {return nombrecoche;}
  
}
