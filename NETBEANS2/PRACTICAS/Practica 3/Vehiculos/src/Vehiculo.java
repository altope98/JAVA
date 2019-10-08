public class Vehiculo 
{	

protected boolean arrancado;
protected int x,y,direccion,n;


 
 public Vehiculo() //norte 0,  sur 2, este 1,oeste 3
	{
		x=0;
		y=0;
		arrancado=false;
		direccion=1;
	}

 
 public void arrancar()
{
			arrancado=true;
		 
}
public void parar()	
{	
			arrancado=false;
		
}
public void mover(int n)
{	if (estaArrancado())
	{
		for (int i=1;i<=n ;i++ )
		{
			mover();
		}
	}else System.out.print("El vehiculo no esta arrancado");
}
public void mover()
{	if (estaArrancado())
	{switch (direccion)
	{
	case 0: y++;break;
	case 1: x++;break;
	case 2: y--;break;
	case 3: x--;break;
	
	}
	}else System.out.print("El vehiculo no esta arrancado");
}
public boolean estaArrancado()
{
	if (arrancado=true)
		return true;
	return false;
}
public int getDireccion ()
{
	return direccion;
}
public int getX()
{
	return x;
}
public int getY()
{
	return y;
}

public void imprimeEstado()
{
	System.out.println("Vehiculo con coordenada x= "+x+" y coordenada y= "+y);
	if (estaArrancado())
	{System.out.println("Vehiculo esta arrancado");
	}else System.out.println("Vehiculo esta parado");
	switch (direccion)
	{
	case 0:System.out.println("Vehiculo en direccion Norte");break;
	case 1:System.out.println("Vehiculo en direccion Este");break;
	case 2:System.out.println("Vehiculo en direccion Sur");break;
	case 3:System.out.println("Vehiculo en direccion Oeste");break;
	}

}
public void girarDerecha()
{
	direccion++;
	if (direccion==4)
		direccion=0;
	
}
public void girarIzquierda()
{
	direccion--;
	if (direccion==-1)
		direccion=3;
	
}
public void girar(int giro)
{
	if (giro>=0)
	{
		for (int i=1;i<=giro ;i++ )
		{
			girarDerecha();
		}
	}else
		{
			for (int i=1;i<=Math.abs(giro) ;i++ )
			{
				girarIzquierda();
			}
		}
}
}