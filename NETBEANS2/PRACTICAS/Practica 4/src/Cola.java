    public class Cola extends Lista
{
	public Cola()
	{
		super();
	}
	public Cola(Object ob)
	{
		super(ob);
	}
	public void ponEnCola(Object ob)
	{
		ponPrimero(ob);
	}
	public void extraeDeCola()
	{
		extraeUltimo();
	}
	public boolean vacia()
	{
		return estaVacia();
	}
	public Object frente()
	{
		return lastElement();
	}
}

