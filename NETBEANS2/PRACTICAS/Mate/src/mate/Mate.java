package mate;
public class Mate {
   public static int factorial(int n)
   { 
        int fact=1;
        if(n<0)
            return -1;
        for (int i= 1; i<=n; i++ )
            fact=fact*i;
	return fact;      
   }
   public static boolean primo(int n)
   {
       for (int i=2;i<n ;i++ )
       {    if(n%i==0)
               return false;
       }
       return true;  
   }
   public static boolean perfecto(int n)
   {
       int sum=0;
       for(int i=1;i<n;i++)
       {
           if (n%i==0)
                sum=sum+i;
       }
       if(sum==n)
               return true;
       return false;
   }
   public static int sumadivisores(int n)
   {	
       int cont=0;
	for (int i=1;i<n ;i++ )
        { 
            if (n%i==0)
            {
		cont=cont+i;
            }
	}
        return cont;
   }
   public static boolean amigos(int n,int m)
   {
       if(sumadivisores(n)==m && sumadivisores(m)==n)    //o return (sumadivisores(n)==m && sumadivisores(m)==n);
           return true;
       return false;   
   }
   public static boolean primos(int n, int m)
   { //OTRA FORMA VER MATE EN PRCTICA 1 2017 ( CON FUNCION EL MENOR)
       if (n<m)
       {
           int aux=m;
           m=n;
           n=aux;
       }
       for(int i=2;i<=m;i++)
       {
           if (n%m==0 && m%n==0)
		return false;
       }
       return true;
   }
   public static int euler(int n)
   {	
        int euler=0;
	for (int i=1;i<n ;i++ )
	{	
            if (primos(i,n))
		euler++;
	}
        return euler;
   }
   public static int potencia(int n, int a)
   {	
       int potenza=1;
       for (int i=1;i<=n;i++ )
       {
           potenza=potenza*a;
       }
       return potenza;
   }
}
