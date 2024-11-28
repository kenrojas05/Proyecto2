
package modeloFutoshiki;

/**
 *
 * @author Kendall Ariel Rojas Cartin
 */

//XML
import javax.xml.bind.annotation.*; //para la serializacion y el guardado de archivo xml


                             //Map es un objeto
import java.util.HashMap;   //lo que hace es que guarda valores con Keys o llaves (parecido a un directorio)
import java.util.Map;      


@XmlRootElement
public class Partida {
    
    private String nivel;  
    private byte cuadricula;
    
   
    private Map<String, int[]> desigualdades = new HashMap<>(); 
    private Map<Integer, int[]> constantes = new HashMap<>();     
    
    private int[][] partidaJuego;
    
    /**
     * Constructor de la clase partida con cuadricula y nivel
     * @param pNivel El nivel de dificultad de la partida
     * @param pCuadricula El numero en byte del tamano cuadrado de la cuadricula de la partida
     **/
    
    public Partida(String pNivel, byte pCuadricula) {
        setNivel(pNivel);
        setCuadricula(pCuadricula);
    }
    
    /**
     * Constructor vacio de la clase partida
     **/
    
    public Partida(){}
    
    /**
     * Agrega la desigualdad al Map con el tipo de desigualdad junto con la posicion x,y de la desigualdad
     * @param tipoDesigualdad El tipo de desigualdad dependiendo si es maf mef mac mec
     * @param fila numero de la fila x
     * @param columna numero de la columna y
     **/
    
    public void agregarDes(String tipoDesigualdad, int fila, int columna) {
        desigualdades.putIfAbsent(tipoDesigualdad, new int[] {fila, columna}); // solo si no existe
    }
    
    /**
     * Agrega las constantes al Map
     * @param constante numero de la constante
     * @param fila numero de la fila x
     * @param columna numero de la columna y
     **/
    
    public void agregarCons(Integer constante, int fila, int columna) {
        constantes.putIfAbsent(constante, new int[] {fila, columna}); // put solo si no existe          
    }
    
    /**
     * Retorna el Map con las desigualdades
     * @return Map con las desigualdades donde key es el nombre y value la posicion en formato int[]
     **/
    
    public Map<String, int[]> conseguirDes() {
        return desigualdades;
    }
    
    /**
     * Retorna el Map con las constantes
     * @return Map con las constantes donde key es el numero constante y value la posicion en formato int[]
     **/
    
    public Map<Integer, int[]> conseguirCons() {
        return constantes;
    }
    
    /**
     * toString de las constantes
     * @return cada constante en el map de constanetes
     **/
    
    public String toStringConstante(){
       String constanteString = "";
        for (Map.Entry<Integer, int[]> constante : constantes.entrySet()) {
            constanteString += " "+constante.getKey();
            for (int i : constante.getValue()) {
                constanteString += " "+ i;
            }
        }
        return constanteString;
    }
    
    /**
     * toString de las desigualdades
     * @return cada desigualdad en el map de desigualdades
     **/
    
    public String toStringDesigualdad(){
       String desigualdadString = "";
        for (Map.Entry<String, int[]> desigualdad : desigualdades.entrySet()) {
            desigualdadString += " "+desigualdad.getKey();
            for (int i : desigualdad.getValue()) {
                desigualdadString += " " + i;
            }
        }
        return desigualdadString;
    }
    
    
    /**
     * Consigue el nivel de dificultad de la partida
     * @return nivel de dificultad 
     **/
    
    // getters 
    @XmlElement
    public String getNivel() {
        return nivel;
    }

    /**
     * Consigue el numero de la matriz cuadrada
     * @return byte del numero de la cuadricula
     **/
    
    @XmlElement
    public byte getCuadricula() {
        return cuadricula;
    }
    
    /**
     * Consigue el map de las desigualdades
     * @return Un map con las desigualdades donde key es el nombre de la desigualdad y value la posicion x,y en int[]
     **/
    
    @XmlElementWrapper(name = "desigualdades") //para que se guarde con el nombre desigualdades
    public Map<String, int[]> getDesigualdades() {
        return desigualdades;
    }

    /**
     * Consigue el map de las constantes
     * @return Un map con las constantes donde key es el numero constante y value la posicion x,y en int[]
     **/
    
    @XmlElementWrapper(name = "constantes") //para que se guarde con el nombre constantes
    public Map<Integer, int[]> getConstantes() {
        return constantes;
    }
    
    /**
     * Consigue la partida del juego 
     * @return retorna la matriz donde esta el juego 
     **/
    
    @XmlElementWrapper(name = "partidaJuego")
    @XmlElement(name = "fila")
    public int[][] getPartidaJuego() {
        return partidaJuego;
    }
   
    /**
     * Coloca la dificultad a la partida
     * @param pNivel el nivel de dificultad de la partida
     **/

    // setters
    public void setNivel(String pNivel) {
        nivel = pNivel;
    }

    /**
     * Coloca la cuadricula a la partida
     * @param pCuadricula el numero en byte de la matriz cuadrada que forma la cuadricula 
     **/

    
    public void setCuadricula(byte pCuadricula) {
        cuadricula = pCuadricula;
    }

    /**
     * Coloca las desigualdades de la partida
     * @param pDesigualdades las desigualdades de la partida en Map donde key es el nombre e int[] la posicion
     **/

    public void setDesigualdades(Map<String, int[]> pDesigualdades) {
        desigualdades = pDesigualdades;
    }

     /**
     * Coloca las constantes de la partida
     * @param pConstantes las constantes de la partida en Map donde key es el numero e int[] la posicion
     **/

    public void setConstantes(Map<Integer, int[]> pConstantes) {
        constantes = pConstantes;
    }
    
    /**
     * Coloca la partida de juego
     * @param pPartidaJuego int[][] que es la matriz del juego 
     **/

    public void setPartidaJuego(int[][] pPartidaJuego) {
        partidaJuego = pPartidaJuego;
    }
    

}
    