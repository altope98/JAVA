package arraylistejemplo;
public class Rectangulo
{
	protected double ancho, largo; //Objetos, variables de objetos
	private static int numObjetos=0; //Variable de clase
	private double Volumen;
	public Rectangulo (double ancho, double largo) //Metodos
	{	
		this.ancho=ancho;
		this.largo=largo;
		numObjetos++;
	}
	public Rectangulo()
	{
		this (1.0,2.0);
	}
	public double area() {return ancho*largo;}
	public double perimetro() {return 2*(ancho+largo);}
	public double getAncho() {return ancho;}
	public double getLargo() {return largo;}
	public int getNumObjetos() {return numObjetos;}
}