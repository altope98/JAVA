public class Vegetales extends SerVivo 
{	
	protected String partes[];
	//protected int parte;
	
	public Vegetales(String nombreCientifico, String nombreVulgar, String partes[]/*,int parte*/)
	{
		super(nombreCientifico,nombreVulgar);
		this.partes=partes;
		
	}
	/*protected String vegetal[]=new String[parte];
	public void creacionVegetal()
	{	
		System.out.print("Introduce parte: ");
		String descripcion=EntradaConsola.leeCadena();
		for (int i=0;i<=parte-1 ;i++ )
		{
			vegetal[i]=descripcion;
		}
	}*/
	public void visualizarPartes()
	{	System.out.print("Partes: ");
		for (int i=0;i<partes.length-1 ;i++ )
		{
			System.out.print(partes[i]+", ");
		}
		System.out.print(partes[partes.length-1]+".");
	}
	public void describete()
	{
		super.describete();
		visualizarPartes();

			/*for (int i=0;i<=parte-1 ;i++ )
		{
			System.out.println(vegetal[i]);
		}*/
	}
}
