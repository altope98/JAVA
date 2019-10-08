package punti;

import javax.swing.JOptionPane;

public class Rectangulo {
       
    protected Segmento s1,s2;
    
    public Rectangulo(Segmento s1, Segmento s2){
        /*if(s1.punto1.y == s2.punto1.y && s1.punto1.x == s2.punto1.x){*/
            this.s1=s1;
            this.s2=s2;
        /*}else
		JOptionPane.showMessageDialog(null,"No se pudo crear el rectangulo");*/
    }
    public double area()
	{
		return s1.longitudSegmento()*s2.longitudSegmento();
	}
	public double perimetro()
	{
		return 2*(s1.longitudSegmento()+s2.longitudSegmento());
	}
    
}
