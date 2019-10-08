/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alvaro
 */
public class  CocheAcuatico extends Coche implements Sumergible
{	protected int z;
	protected boolean inmersion;
	protected String medio;

	public CocheAcuatico(String color,String modelo, String matricula)
	{	
		super(color,modelo,matricula);
		z=0;
		inmersion=false;
		medio="tierra";
	}
	public boolean estaEnElAgua()
	{
		if (medio=="agua")
		{
			return true;
		}return false;
	}
	public boolean estaInmerso()
	{
		if (estaEnElAgua()==true && z<0)
		{
			return true;
		}return false;
	}
	public void imprimeEstado()
	{
		super.imprimeEstado();
		if (estaEnElAgua()==true)
		{
			System.out.println("El vehiculo esta en el agua");
			if (estaInmerso()==true)
			{
				System.out.println("El vehiculo esta sumergido");
				System.out.println("Su profundidad es "+z);
			}else System.out.println("El vehiculo esta en el agua pero no esta sumergido");
		}else System.out.println("El vehiculo no esta en el agua");
	}
	public void cambioDeMedio()
	{	
		if (z==0)
		{
			if (medio=="tierra")
				medio="agua";
			else
				medio="tierra";
		}	
	}
	public void inmersion()
	{
		if (estaArrancado() && medio=="agua")
		{	
				z=-1;
				inmersion=true;
		}
		inmersion= false;		
	}
	public void ascender(int n)
	{
		if (medio=="agua" && estaArrancado() && inmersion==true)
		{
			z=z+n;
			if (z==0)
			{
				inmersion=false;
			}
		}
	}
	public void descender(int n)
	{
		if (medio=="agua" && estaArrancado() && inmersion==true)
		{
			z=z-n;
		}
	}
		
}
