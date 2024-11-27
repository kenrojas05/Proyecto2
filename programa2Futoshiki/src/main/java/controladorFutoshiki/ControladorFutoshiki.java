
package controladorFutoshiki;

import modeloFutoshiki.*;
import vistaFutoshiki.*;
import static vistaFutoshiki.GUIFutoshiki.*;

/**
 *
 * @author Kendall Ariel Rojas Cartin
 */

//Controlador general 

public class ControladorFutoshiki {
    
    /**
     *Guarda los objetos en su respectivo archivo
     * @param <T> objeto generico
     * @param objeto objeto a guardar
     */
    
    public static <T> void guardarObjeto(T objeto){
        if (objeto instanceof Configuracion){
            Configuracion.guardarConfiguracionXML(objeto);
        }
        if (objeto instanceof Top10){
            Top10.guardarTopXML(objeto);
        }
        if (objeto instanceof PartidasFutoshiki){
            PartidasFutoshiki.guardarPartidaFutoshikiXML(objeto);
        }
    }
    
    
    public void agregarAlTop10(String nombre, int hora, int minutos, int segundos, String nivel){
        System.out.println("Top 10");
        if (configFutoshiki.getReloj().equals("Temporizador")|| configFutoshiki.getReloj().equals("No")) {
            return;
        }
        if (!nombre.equals("incognito") ){
            Top10 top = new Top10();
            String jugador = nombre;
            System.out.println(jugador +" "+ hora +" "+ minutos +" "+" "+segundos);
            
            Top10.addJugadores(jugador, hora, minutos, segundos, nivel);
            
            guardarObjeto(top);
            
            System.out.println("Guardado");
            System.out.println(Top10.toStringJugadoresFacil());
        }
        
    }
    
}
