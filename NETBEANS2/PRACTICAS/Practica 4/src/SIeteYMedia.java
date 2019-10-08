
import javax.swing.JOptionPane;


public class SIeteYMedia {
    public static void main(String[] args) {
        char respuesta, sacar;
        String cadena;
        int repeticion_maquina, contador=0;
        double suma_jugador=0, suma_maquina=0;
        BarajaDeCartas baraja=new BarajaDeCartas();
        Carta carta;
        
        do{
            do{ //Juega el jugador
                carta=baraja.sacaCarta();
                carta.visualizaCarta();
                suma_jugador=suma_jugador+carta.valorCarta();
                //System.out.println(suma_jugador);
                cadena=JOptionPane.showInputDialog("Desea sacar otra carta (S/N): ");
                sacar=cadena.charAt(0);    
            }while (sacar=='s'||sacar=='S' && suma_jugador<=7.5 && baraja.quedanCartas());
            if (suma_jugador>=7.5)
            { 
                System.out.println("Gana la banca, has perdido");
		return;
            }
            repeticion_maquina=(int)(Math.random()*6);
            do{ //Juega la maquina
                for(int i=0;i<=repeticion_maquina;i++){
                    carta=baraja.sacaCarta();
                    carta.visualizaCarta();;
                    suma_maquina=suma_maquina+carta.valorCarta();
                    contador=i;
                } 
            }while (suma_maquina<=7.5 && baraja.quedanCartas() || contador==repeticion_maquina);

                //RESULTADOS
                System.out.print("El jugador ha obtenido "+suma_jugador+" puntos");
                System.out.print("La maquina ha obtenido "+suma_maquina+" puntos");
            
                //COMPROBACIÓN
                if (suma_maquina>=7.5 && suma_jugador<7.5)
                {
                    System.out.print("Enhorabuena ganaste");
                }
                if (suma_maquina>=suma_jugador)
                {
                    System.out.print("Gana la maquina");
                }
                if (suma_maquina>=7.5 && suma_jugador >=7.5 && suma_maquina<=7.5 && suma_jugador <=7.5)
                {
                    System.out.print("Empate, gana la maquina");
                }
            
            
            cadena= JOptionPane.showInputDialog("Deseas jugar otra vez (S/N): ");
            respuesta=cadena.charAt(0);
        }while (respuesta=='S'||respuesta=='s');
    } 
}
