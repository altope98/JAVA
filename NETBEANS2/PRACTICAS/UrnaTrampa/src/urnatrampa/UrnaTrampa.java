
package urnatrampa;

public class UrnaTrampa extends Urna{
    protected int random=(int)(Math.random()*1000+1);
	public int sacaBola()
	{
		if((random==1||random==2)&& super.quedaMasDeUnaBola()==true)
		{
			super.bolasblancas--;
			super.bolasnegras++;
		}
		return super.sacaBola();
	}
}
