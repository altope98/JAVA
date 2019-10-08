/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author dmp_p
 */
public class Partido {
    String codigoLocal;
    String codigoVisitante;
    String equipoLocal;
    String equipoVisitante;

    public Partido(String codigoLocal, String codigoVisitante, String equipoLocal, String equipoVisitante) {
        this.codigoLocal = codigoLocal;
        this.codigoVisitante = codigoVisitante;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public String getCodigoLocal() {
        return codigoLocal;
    }

    public String getCodigoVisitante() {
        return codigoVisitante;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    
}
