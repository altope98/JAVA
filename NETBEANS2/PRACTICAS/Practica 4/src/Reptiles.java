public class Reptiles extends Animales 
{	
	
	public Reptiles(String nombreCientifico, String nombreVulgar,int patas)
	{
		super(nombreCientifico,nombreVulgar,patas);
		
	}
	public Reptiles()
	{
		super();
	}
	
	public void describete()
	{	
		super.describete();
		System.out.println("Es un reptil y tiene la sangre fria");
	}
}
