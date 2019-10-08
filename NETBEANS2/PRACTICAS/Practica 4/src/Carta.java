public class Carta{
    protected int numero, palo;
	public Carta( int numero, int palo)
	{
		this.numero=numero;
		this.palo=palo;
	}
	public Carta()
	{
		this(1,1);
	}
	public void visualizaCarta()
	{
                if (numero<=7)
		System.out.print(numero + " de ");
		else
                    if (numero==8)
			System.out.print("Sota de ");
                    else 
			if (numero==9)
                            System.out.print("Caballo de ");
			else
                            System.out.print("Rey de ");
		switch (palo)
		{
		case 1:System.out.println("oros");break;
		case 2:System.out.println("bastos");break;
		case 3:System.out.println("espadas");break;
		case 4:System.out.println("copas");break;
		}
	}
	public double valorCarta()
	{
		if(numero==8||numero==9||numero==10)
                    return 0.5;
		return numero;
	}
}
