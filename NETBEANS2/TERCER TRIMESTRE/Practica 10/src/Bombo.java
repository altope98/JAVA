/*public class Bombo {
    
    protected int n,bolas,bolasacada,bola;
	
	public Bombo(int n)
	{
		this.n=n;
                crearVector(n);
	}
	int v[];
	public void crearVector(int n)
	{	
                v=new int[n];
		for (int i=0;i<v.length ;i++ )
			v[i]=(int) (Math.random()*n+1);
               
	}
        public void visulizarVector(){
            for(int i=0;i<v.length;i++){
                System.out.println(v[i]+" ");
                System.out.println(v.length+" ");
            }
            
        }
	public int sacaBola()
	{ 
	
		bolasacada=(int)(Math.random()*n);
		v[bolasacada]=-1;
		n--;
		return bolasacada;
		
		
	}
	public void meteBola(int bola)
	{	
		if (0>=bola&&bola<=(n-1))
		{
			v[bola]=bola;
			n++;
		}
		
	}
	public boolean quedanBolas()
	{
		if (totalBolas()>0)
		{
			return true;
		}
		return false;
	}
	public int totalBolas()
	{
		return n;
	}

	public  void visualizar()
	{	
		for (int i=0;i<v.length ;i++ )
			System.out.print(v[i]+" ");
	}
}*/

public class Bombo {
    private int n;
    private boolean bombo[];

public Bombo(int n){
    this.n=n;
    bombo=new boolean[n];
}

public Bombo(){
    n=10;
    bombo=new boolean[n];
}

public int sacaBola(){
    int bola;
    do{
       bola =(int) (Math.random()*n);
    }while(bombo[bola]==true);
    bombo[bola]=true;
    return bola;
}

public void meteBola(int bola){
    bombo[bola]=false;
}

public boolean quedanBolas(){
    for (int i=0; i < n; i++){
        if (bombo[i]==false){
            return false;
        }
    }
return true;
}
}
