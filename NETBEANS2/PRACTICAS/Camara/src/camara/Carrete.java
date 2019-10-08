/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camara;

import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class Carrete {
    protected int espacio, hechas, fotosvalidas, fotosveladas;  //fotsVeladas nueva porque se requiere en la clase CamaraFotografica
	
public Carrete(int espacio){
	if (espacio==12 || espacio==24 || espacio==36)
		this.espacio=espacio;
	else
		this.espacio=12;
		hechas=0;
		fotosvalidas=0;
		fotosveladas=0;
	}
public Carrete(){
	this(12); //Asi se llama a otro constructor ya definido en la misma clase
	}

public boolean estaLleno(){
    if(espacio-hechas==0){
        return true;
    }
    return false;
}
public boolean sePuedeHacer(){
    if(hechas<espacio){
        return true;
    }
    return false;
}
public void nueva(){
    if(sePuedeHacer()){
        hechas++;
    }else
    JOptionPane.showMessageDialog(null,"El carrete esta lleno");
}
public int numeroFotos(){
    return hechas;
}
public void revelar(){
    fotosvalidas=0;
    fotosveladas=0;
	for (int i=1;i<=hechas;i++ )
	{
		if ((int)(Math.random()*100+1)<=98){
			fotosvalidas++;}
		else
			fotosveladas++;
		}
	
}
public int numeroFotosValidas(){
	return fotosvalidas;
	}
public int numeroFotosVeladas(){
	return fotosveladas;
	}

}
