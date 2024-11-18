
package com.mycompany.programa2futoshiki;

/**
 *
 * @author Kendall Ariel Rojas Cartin
 */

//(Documentar mejor PDF final) XML
import javax.xml.bind.annotation.*; //para la serializacion y el guardado de archivo xml
import javax.xml.bind.*;   
import java.io.File;


                             //Map es un objeto
import java.util.HashMap;   //lo que hace es que guarda valores con Keys o llaves (parecido a un directorio)
import java.util.Map;      
import java.util.List;
import java.util.ArrayList;


@XmlRootElement
public class Partida {
    
    private String nivel;  
    private byte cuadricula;
    
    @XmlTransient 
    private Map<String, List<int[]>> desigualdades = new HashMap<>(); 
    @XmlTransient 
    private Map<String, List<int[]>> constantes = new HashMap<>();     
    
    private int[][] partidaJuego;
    
    public Partida(String pNivel, byte pCuadricula) {
        setNivel(pNivel);
        setCuadricula(pCuadricula);
    }
    
    Partida(){}
    
    public void agregarDes(String tipoDesigualdad, int fila, int columna) {
        desigualdades.putIfAbsent(tipoDesigualdad, new ArrayList<>()); // solo si no existe
        desigualdades.get(tipoDesigualdad).add(new int[] {fila, columna});
    }

    public void agregarCons(int constante, int fila, int columna) {
        constantes.putIfAbsent(String.valueOf(constante), new ArrayList<>()); // put solo si no existe
        constantes.get(String.valueOf(constante)).add(new int[] {fila, columna});                
    }
    
    // getters 
    @XmlElement
    public String getNivel() {
        return nivel;
    }

    @XmlElement
    public byte getCuadricula() {
        return cuadricula;
    }

    @XmlElementWrapper(name = "desigualdades")
    @XmlElement(name = "des")
    public List<String> getDesigualdades() {
        List<String> des = new ArrayList<>();
        for (Map.Entry<String, List<int[]>> desigualdad : desigualdades.entrySet()) {
            for (int[] i : desigualdad.getValue()) {
                des.add(desigualdad.getKey() + ", " + i[0] + ", " + i[1]);
            }
        }
        return des;
    }

    @XmlElementWrapper(name = "constantes")
    @XmlElement(name = "cons")
    public List<String> getConstantes() {
        List<String> cons = new ArrayList<>();
        for (Map.Entry<String, List<int[]>> constante : constantes.entrySet()) {
            for (int[] i : constante.getValue()) {
                cons.add(constante.getKey() + ", " + i[0] + ", " + i[1]);
            }
        }
        return cons;
    }
    
    @XmlElementWrapper(name = "partidaJuego")
    @XmlElement(name = "fila")
    public int[][] getPartidaJuego() {
        return partidaJuego;
    }
   

    // setters
    public void setNivel(String pNivel) {
        nivel = pNivel;
    }

    public void setCuadricula(byte pCuadricula) {
        cuadricula = pCuadricula;
    }

    public void setDesigualdades(Map<String, List<int[]>> pDesigualdades) {
        desigualdades = pDesigualdades;
    }

    public void setConstantes(Map<String, List<int[]>> pConstantes) {
        constantes = pConstantes;
    }

    public void setPartidaJuego(int[][] pPartidaJuego) {
        partidaJuego = pPartidaJuego;
    }
    

}
    