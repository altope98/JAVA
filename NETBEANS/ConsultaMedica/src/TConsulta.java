/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvar
 */
public class TConsulta {
    private String nombre;
    private int telefono;
    
    public TConsulta(){
        this.nombre= nombre;
        this.telefono= telefono;
    }
    
    public void setNombre(String n){
        nombre=n;
    }
    public void setTelefono(int n){
        telefono=n;
    }
    public String getNombre(){
        return nombre;
    }
    public int getTelefono(){
        return telefono;
    }
}
