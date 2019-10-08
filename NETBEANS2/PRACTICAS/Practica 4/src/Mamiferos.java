public class Mamiferos extends Animales
{
	protected String familia;
	public Mamiferos(String nombreCientifico,String nombreVulgar,String familia)
	{
		super(nombreCientifico,nombreVulgar,4);
		this.familia=familia;
		
	}
	public void nuevasPatas(int nuevas)
	{
		
	}
	public void describete()
	{
		super.describete();
		System.out.println("Es un mamifero");
		System.out.println("Familia: "+familia);
	}
}
