/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alvaro
 */
public class Avion extends Vehiculo
{	protected int z,n;
	protected boolean vuelo;
	
	public Avion()
	
	{
		super();
	
			z=0;
		
			vuelo=false;
	
	}

	public void Despegar()
	{	
		if (estaArrancado())
		{
			vuelo=true;
			z=1;
		}else System.out.println("Los motores no estan arrancados");
	}
	public void Subir()
	{
		if (vuelo=true)
		{
			z++;
		}
	}
	public void Subir(int n)
	{
		if (vuelo==true)
		{
			z=z+n;
		}
	}
	public void Bajar()
	{
		if (vuelo=true && z>0)
		{
			z--;
		}
	}
	public void Bajar(int n)
	{
		if (vuelo==true && y>0 && x>0)
		{
			z=z-n;
		}
	}
	public void imprimeEstado()
	{	super.imprimeEstado();
		if (vuelo=true)
		{
			System.out.print("El vehiculo ha despegado");
			System.out.print("La altura del vehiculo es: "+z);
		}else System.out.print("El vehiculo no ha despegado");
	}
}