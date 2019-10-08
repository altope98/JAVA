/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alvaro
 */
public class Bombi {
    protected int n,bolas,bolasacada,bola;
    protected int v[];
	public Bombi(int n)
	{
		this.n=n;
                v=new int[n];
	}
	
	public void crearVector()
	{	
		for (int i=0;i<v.length ;i++ )
			v[i]=(int) (Math.random()*n+1);
	}
	public int sacaBola()
	{ 
	
		bolasacada=(int)(Math.random()*n+1);
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
        
        
        
        
}
