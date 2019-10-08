/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alvaro
 */
public class  Coche extends Vehiculo
{	
		protected String color,modelo,matricula;
	
public Coche(String color,String modelo, String matricula)
{
	super();
	this.color=color;
	this.modelo=modelo;
	this.matricula=matricula;
}

public String getColorCoche(String color)
{
	return color;
}
public String getModelo(String modelo)
{
	return modelo;
}
public String getMatricula(String matricula)
{
	return matricula;
}
public void imprimeEstado()
{	super.imprimeEstado();
	System.out.println("El modelo del vehiculo es: "+modelo);
	System.out.println("La matricula es: "+matricula);
	System.out.println("El color del vehiculo es: "+color);
}

}
