package camara;

import javax.swing.JOptionPane;

public class CamaraFotografica {
    
    protected int numCarretes, validas, fotosVeladas;
	protected Carrete carrete1;
	public CamaraFotografica(){
		numCarretes=0;
                validas=0;
                fotosVeladas=0;
		carrete1=null;
	}
        public boolean hayCarrete(){
		if(carrete1==null)
			return false;
		return true;
	}
	public void ponerCarrete(Carrete c) {
		if (!hayCarrete()){
			carrete1=c;
			numCarretes++;}else
                    JOptionPane.showMessageDialog(null,"Ya hay un carrete");
                
	}
	
	public boolean sePuedeHacerFoto(){
		if(hayCarrete() && carrete1.sePuedeHacer())
			return true;
		return false;
	}
	public void nuevaFotografia(){
		if(sePuedeHacerFoto())
			carrete1.nueva();
		else
			JOptionPane.showMessageDialog(null,"No se puede realizar fotografia");
	}
	public void quitarCarrete(){
		if (hayCarrete()){
			carrete1.revelar();
                        validas=carrete1.numeroFotosValidas();
                        fotosVeladas=carrete1.numeroFotosVeladas();
			carrete1=null;}
                
		else
			JOptionPane.showMessageDialog(null,"No se pudo quitar el carrete");
	}

}