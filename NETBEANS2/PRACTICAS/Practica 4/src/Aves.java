public class Aves extends Animales 
{	
	
	public Aves(String nombreCientifico, String nombreVulgar, int patas)
	{
		super(nombreCientifico,nombreVulgar,patas);
		
	}
	public Aves()
	{
		super();
	}

	public void describete()
	{	
		super.describete();
		System.out.println("Es una ave y puede volar");
	}
}
