package urnatrampa;
public class Urna {
    protected int bolasnegras, bolasblancas, bolanegra,bolablanca;
	public Urna (int bolasnegras, int bolasblancas)
	{
            this.bolasnegras=bolasnegras;    
            this.bolasblancas=bolasblancas;
        }
        public Urna ()
        {
            bolasnegras=10;
            bolasblancas=10;
        }
        public int totalBolas()
        {
            return bolasnegras+bolasblancas;
        }
        public int sacaBola()
        {
            int random= (int) (Math.random()*totalBolas()+1);
            if(random%2==0){
                bolasnegras--;
                bolanegra=1;
                return bolanegra;
            }
            bolasblancas--;
            bolablanca=0;
            return bolablanca;
        }
         public void meteBola(int bolanueva)
         {
             if (bolanueva==0){
                 bolasblancas++;
             }else if(bolanueva==1){
                 bolasnegras++;
             }
         }
         public boolean quedanBolas()
	{
		if (bolasnegras==0 && bolasblancas==0)
			return false;
		else
			return true;
	}
	public boolean quedaMasDeUnaBola()
	{
		if (bolasnegras>1 && bolasblancas>0)
			return true;
		else
			return false;
	}
}
