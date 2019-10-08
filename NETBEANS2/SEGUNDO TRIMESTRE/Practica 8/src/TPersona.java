/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alvaro
 */
public class TPersona {
    String name, address;
    int age,  telephone;
    public TPersona(){
        name="";
        address="";
        age=0;
        telephone=0;
    }
    public void setNombre(String nombre){
        name=nombre;
    }
    public void setDireccion(String direccion){
        address=direccion;
    }
    public void setEdad(int edad){
        age=edad;
    }
    public void setTelefono(int telefono){
        telephone=telefono;
    }
    public String getNombre(){
        return name;
    }
    public String getDireccion(){
        return address;
    }
    public int getEdad(){
        return age;
    }
    public int getTelefono(){
        return telephone;
    }
    
}
