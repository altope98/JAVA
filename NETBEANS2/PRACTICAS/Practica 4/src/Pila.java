public class Pila extends Lista
{

	public Pila()
	{
		super();
	}
	public Pila(Object ob)
	{
		super(ob);
	}
	public void push (Object ob)
	{
		addElement(ob);
		
	}
	public void pop()
	{	
		if (!vacia())
			removeElementAt(size()-1);
	}
	public boolean vacia()
	{
		return estaVacia();
	}
	public Object cima()
	{
		if (vacia())
		
			return null;
		
		return lastElement();
	}
}
