public class SerVivo 
{
	protected String nombreCientifico, nombreVulgar;
	
	public SerVivo(String nombreCientifico, String nombreVulgar)
	{
		this.nombreCientifico=nombreCientifico;
		this.nombreVulgar=nombreVulgar;
	}
	public SerVivo()
	{
		this("","");
	}
	public void cambiarNombreCientifico(String cientifico)
	{
		nombreCientifico=cientifico;
	}
	public void cambiarNombreVulgar(String vulgar)
	{
		nombreVulgar=vulgar;
	}		
	public void describete()
	{
		System.out.println("Ser vivo con:");
		System.out.println("Nombre Cientifico: "+nombreCientifico);
		System.out.println("Nombre Vulgar: "+nombreVulgar);
	}



}
