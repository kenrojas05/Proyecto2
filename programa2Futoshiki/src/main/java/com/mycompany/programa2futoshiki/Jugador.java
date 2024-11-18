
package com.mycompany.programa2futoshiki;

/**
 *
 * @author Kendall Ariel Rojas Cartin
 */

//(Documentar mejor PDF final) XML

import javax.xml.bind.annotation.*; //para la serializacion y el guardado de archivo xml
import javax.xml.bind.*;  

import java.util.ArrayList;
import java.util.List;


@XmlRootElement
public class Jugador {
    private String nombre = "incognito";
    private String password;
    
    private int[][] cuadriculaActual;
    Partida partidaActual;
    List<Partida> partidasJugadas = new ArrayList<>();
    
    Jugador(){}

    public Jugador(String pNombre, String pPassword){
        setNombre(pNombre);
        setPassword(pPassword);
    }
    

   //getters

    @XmlElement
    public String getNombre(){
        return nombre;
    }
    
    @XmlElement
    public String getPassword(){
        return password;
    }
    
    @XmlElement 
    public int[][] getCuadriculaActual(){
        return cuadriculaActual;
    }
    
    @XmlElement 
    public Partida getPartidaActual(){
        return partidaActual;
    }
    
    @XmlElement 
    public List<Partida> getListaPartidasJugadas(){
        return partidasJugadas;
    }
    
    
    
    
   //setters
    
    public void setNombre(String pNombre){
        nombre = pNombre;
    }
    
    public void setPassword(String pPassword){
        password = pPassword;
    }
    
    public void getCuadriculaActual(int[][] pCuadriculaActual){
        cuadriculaActual = pCuadriculaActual;
    }
    
    public void getPartidaActual(Partida pPartidaActual){
        partidaActual = pPartidaActual;
    }
    
    public void getListaPartidasJugadas(List<Partida> pPartidasJugadas){
        partidasJugadas = pPartidasJugadas;
    }
    
    
    
}
