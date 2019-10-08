public class Animales extends SerVivo
{	
	
	protected int patas;
	public Animales(String nombreCientifico, String nombreVulgar,  int patas)
	{
		super(nombreCientifico,nombreVulgar);
		this.patas=patas;
	}
	public Animales()
	{
		super();
		patas=0;
	}
	public String mostrarNombreCientifico()
	{
		return nombreCientifico;
	}
	public String mostrarNombreVulgar()
	{
		return nombreVulgar;
	}
	public int mostrarPatas()
	{
		return patas;
	}
	public void nuevasPatas(int nuevas)
	{
		patas=nuevas;
	}
	public void describete()
	{	
		super.describete();
		System.out.println("Puede moverse");
		System.out.println("Numero de patas:  "+patas);
	}
}
