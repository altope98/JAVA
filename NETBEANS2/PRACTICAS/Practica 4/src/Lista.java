import java.util.*;
public class Lista extends Vector
{
	public Lista()
	{
		super();
	}
	public Lista(Object ob)
	{
		super();
		addElement(ob); //lo pone en la primera posicion se puede hacer con insert
	}
	public void ponPrimero(Object ob)
	{
		insertElementAt(ob,0); //LO PONE EN LA PRIMERA POSICION
	}
	public void ponUltimo(Object ob)
	{
		addElement(ob); /*LO PONE AL FINAL, PODRIA SER insertElementAt(ob,size()-1);*/
	}
	public boolean estaVacia()
	{
		return isEmpty();
	}
	public Object extraePrimero()
	{
		if (estaVacia())
			return null;
		Object ob=firstElement(); /*devuelve el primer objeto y Se guarda el objeto*/
		removeElementAt(0); /*Puede ser removeElement(firstElement)*/
		return ob;
	}
	public Object extraeUltimo()
	{	if (estaVacia())
			return null;
		Object ob=lastElement();
		removeElementAt(size()-1);
		return ob;
	}
	public void visualizaElementos()
	{
		for(Enumeration e=elements();e.hasMoreElements();)
		{System.out.println(e.nextElement());}
	}
}