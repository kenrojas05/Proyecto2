
package modeloFutoshiki;

/**
 *
 * @author Kendall Ariel Rojas Cartin
 */

//XML

import javax.xml.bind.annotation.*; //para la serializacion y el guardado de archivo xml

import java.util.ArrayList;
import java.util.List;


@XmlRootElement
public class Jugador {
    private String nombre = "incognito";
    private String password;
    
    private int[][] cuadriculaActual;
    Partida partidaActual;
    List<Partida> partidasJugadas = new ArrayList<>();
    
    /**
     * Constructor del jugador sin parametros
     **/
    
    Jugador(){}

    /**
     * Constructor del jugador con el nombre y la constraseña
     **/
    
    public Jugador(String pNombre, String pPassword){
        setNombre(pNombre);
        setPassword(pPassword);
    }
    

   //getters

    /**
     * Consigue el nombre del jugador
     * @return nombre
     **/
    
    @XmlElement
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Consigue la contrasena del jugador
     * @return password o contrasena
     **/
    
    @XmlElement
    public String getPassword(){
        return password;
    }
    
    /**
     * Consigue la cuadricula de juego actual
     * @return int[][] cuadricula
     **/
    
    @XmlElement 
    public int[][] getCuadriculaActual(){
        return cuadriculaActual;
    }
    
    /**
     * Consigue la partida actual
     * @return Partida partidaActual
     **/
    
    @XmlElement 
    public Partida getPartidaActual(){
        return partidaActual;
    }
    
    /**
     * Consigue la lista de partidas jugadas por el jugador
     * @return partidasJugadas
     **/
    
    @XmlElement 
    public List<Partida> getListaPartidasJugadas(){
        return partidasJugadas;
    }
    
    
    
    
   //setters
    
    /**
     * Set del nombre del jugador
     * @param pNombre nombre
     **/
    
    public void setNombre(String pNombre){
        nombre = pNombre;
    }
    
    /**
     * Set de la contrasena del jugador
     * @param pPassword password o contrasena
     **/
    
    public void setPassword(String pPassword){
        password = pPassword;
    }
    
    /**
     * Set de la cuadricula actual
     * @param pCuadriculaActual cuadricula int[][]
     **/
    
    public void getCuadriculaActual(int[][] pCuadriculaActual){
        cuadriculaActual = pCuadriculaActual;
    }
    
    /**
     * Set de la partida actual
     * @param pPartidaActual Partida
     **/
    
    public void getPartidaActual(Partida pPartidaActual){
        partidaActual = pPartidaActual;
    }
    
    /**
     * Set de las partidas jugadas
     * @param pPartidasJugadas List de Partida de las partidasJugadas
     **/
    
    public void getListaPartidasJugadas(List<Partida> pPartidasJugadas){
        partidasJugadas = pPartidasJugadas;
    }
    
    
    
}
