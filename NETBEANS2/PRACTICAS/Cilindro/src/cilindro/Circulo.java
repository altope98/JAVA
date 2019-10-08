
package cilindro;
public class Circulo {
    protected double radio;
	
	public Circulo(double radio) 
        {
		this.radio=radio;
	}
	public Circulo(){
		radio=1;
	}
	public double area(){return Math.PI*radio*radio;}
	public double circunferencia(){return 2*Math.PI*radio;}

}
