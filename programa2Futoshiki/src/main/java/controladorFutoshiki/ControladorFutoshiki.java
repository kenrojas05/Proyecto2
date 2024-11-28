
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
    
    /**
     * Agrega el jugador al top 10 de entrar en el y comprueba el nombre
     * @param nombre nombre del jugador
     * @param hora numero de la hora
     * @param minutos numero de los minutos
     * @param segundos numero de los segundos
     * @param nivel dificultad del nivel
     **/
    
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
    
    /**
     * Retorna la configuracion predeterminada
     * @return Configuracion con los valores predeterminados del programa
     **/
    
    public static Configuracion conseguirConfigPredeterminada(){
        return new Configuracion((byte) 5, "Facil", false, "Cronometro", false); //set en predeterminado
    }
    
    /**
     * Agrega el jugador
     * @param nombre nombre del jugador
     * @param password contrasena del jugador
     **/
    
    public static void agregarJugador(String nombre , String password){
        if(!nombre.equals("incognito")){
            Jugador jugador = new Jugador(nombre, password);
            Configuracion.addJugadores(nombre, jugador);
        }
    }
    
    /**
     * Determina si el nombre tiene un tamano valido
     * @param nombre el nombre
     * @return true si es valido false en caso contrario
     **/
    
    public static boolean nombreValido(String nombre){
        if (nombre.length()>=1 || nombre.length()<=30){
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Consigue de configuracion la contrasena de un jugador
     * @param nombre nombre del jugador a conseguir
     * @return String contrasena
     **/
    
    public static String conseguirPasswordJugador(String nombre){
        return Configuracion.jugadores.get(nombre).getPassword();
    }
    
    /**
     * Consigue de configuracion el nombre de un jugador
     * @param nombre nombre del jugador a conseguir
     * @return String nombre
     **/
    
    public static String conseguirNombreJugador(String nombre){
        return Configuracion.jugadores.get(nombre).getNombre();
    }
    
}
    