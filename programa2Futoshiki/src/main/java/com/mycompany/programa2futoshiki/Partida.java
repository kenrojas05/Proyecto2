
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
    
   
    private Map<String, int[]> desigualdades = new HashMap<>(); 
    private Map<Integer, int[]> constantes = new HashMap<>();     
    
    private int[][] partidaJuego;
    
    public Partida(String pNivel, byte pCuadricula) {
        setNivel(pNivel);
        setCuadricula(pCuadricula);
    }
    
    Partida(){}
    
    public void agregarDes(String tipoDesigualdad, int fila, int columna) {
        desigualdades.putIfAbsent(tipoDesigualdad, new int[] {fila, columna}); // solo si no existe
    }
    
    public Map<String, int[]> conseguirDes() {
        return desigualdades;
    }
    
    public Map<Integer, int[]> conseguirCons() {
        return constantes;
    }
    

    public void agregarCons(Integer constante, int fila, int columna) {
        constantes.putIfAbsent(constante, new int[] {fila, columna}); // put solo si no existe          
    }
    
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
    
    // getters 
    @XmlElement
    public String getNivel() {
        return nivel;
    }

    @XmlElement
    public byte getCuadricula() {
        return cuadricula;
    }
    
    @XmlElementWrapper(name = "desigualdades") //nose como evitar que se vea como key item
    public Map<String, int[]> getDesigualdades() {
        return desigualdades;
    }

    @XmlElementWrapper(name = "constantes")
    public Map<Integer, int[]> getConstantes() {
        return constantes;
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


    public void setDesigualdades(Map<String, int[]> pDesigualdades) {
        desigualdades = pDesigualdades;
    }


    public void setConstantes(Map<Integer, int[]> pConstantes) {
        constantes = pConstantes;
    }

    public void setPartidaJuego(int[][] pPartidaJuego) {
        partidaJuego = pPartidaJuego;
    }
    

}
    