/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7;

/**
 *
 * @author alvar
 */
public class TPersona {
    private String nom,dir;
    private int age,tel;
   
    public TPersona()
    {
        nom="";
        dir="";
        age=0;
        tel=0;
    }
    
    public void setNombre(String n)
    {
        nom=n;
    }
    public String getNombre()
    {
        return nom;
    }
    public void setDireccion(String d)
    {
        dir=d;
    }
    public String getDireccion()
    {
        return dir;
    }
    public void setEdad(int a)
    {
        age=a;
    }
    public int getEdad()
    {
        return age;
    }
    public void setTelefono(int t)
    {
        tel=t;
    }
    public int getTelefono()
    {
        return tel;
    }
    
    
    
    
}

