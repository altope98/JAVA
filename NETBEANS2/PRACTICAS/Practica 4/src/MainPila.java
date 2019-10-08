public class MainPila {
        public static void main(String[] args) 
	{	String coche="Peugeot";
		Pila pila=new Pila();
		pila.vacia();
		pila.push(coche);
		pila.push(new Integer("100"));
		pila.push(new String("ANTONIO"));
		pila.visualizaElementos();
		System.out.println("\n"+pila.cima());
		pila.pop();
		System.out.println("\n"+pila.cima());
	}
    }
    

