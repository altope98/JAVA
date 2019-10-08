public class MainCola {
    public static void main(String[] args) {
                String coche="Peugeot";
		String coche2="Evolution";
		Integer num=300;
		Cola cola=new Cola();
		cola.vacia();
		cola.ponEnCola(coche2);
		cola.ponEnCola(coche);
		cola.ponEnCola(num);
		cola.visualizaElementos();
		System.out.println("\n"+cola.frente());
		cola.extraeDeCola();
		System.out.println("\n"+cola.frente());
    }
    
}
