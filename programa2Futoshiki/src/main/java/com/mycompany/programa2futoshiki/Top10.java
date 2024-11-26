
package com.mycompany.programa2futoshiki;

import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap; //para que mantenga forma el hashmap en el Xml

//Para guardar en XML
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Kendall Ariel Rojas Cartin
 */
@XmlRootElement
public class Top10 {
    
    @XmlTransient
    public static LinkedHashMap<String, String> jugadoresFacil= new LinkedHashMap(); //key nombre value tiempo (el tiempo se guarda 00:00:00 para evitar problemas con Xml y listas)
    @XmlTransient
    public static LinkedHashMap<String, String> jugadoresIntermedio= new LinkedHashMap(); //key nombre value tiempo (el tiempo se guarda 00:00:00 para evitar problemas con Xml y listas)
    @XmlTransient
    public static LinkedHashMap<String, String> jugadoresDificil = new LinkedHashMap(); //key nombre value tiempo (el tiempo se guarda 00:00:00 para evitar problemas con Xml y listas)
    
    Top10(){}
    
    private static Map<String, String> actualizarJugadores(Map<String, String> jugadores, String nombre, int hora, int minuto, int segundo) {
        
        int tiempoJugadorActual = hora * 3600 + minuto * 60 + segundo;
        boolean reemplazado = false;

        int[] tiempos = new int[10];
        String[] tiemposStr = new String[10];
        String[] jugadoresNombres = new String[10];
        int contador = 0;

        for (Map.Entry<String, String> jugador : jugadores.entrySet()) {
            String tiempo = jugador.getValue();
            String[] tiempoDividido = tiempo.split(":"); //divide el string en 00 00 00 para volverlos int

            int horasJugador = Integer.parseInt(tiempoDividido[0]);
            int minutosJugador = Integer.parseInt(tiempoDividido[1]);
            int segundosJugador = Integer.parseInt(tiempoDividido[2]);

            int tiempoJugador = horasJugador * 3600 + minutosJugador * 60 + segundosJugador;

            if (jugador.getKey().equals(nombre)) { //si el tiempo es de un mismo jugador se cambia dependiendo de si es mejor o no
                if (tiempoJugadorActual < tiempoJugador) {
                    tiempos[contador] = tiempoJugadorActual;
                    tiemposStr[contador] = hora+":"+minuto+":"+segundo;
                } 
                else {
                    tiempos[contador] = tiempoJugador;
                    tiemposStr[contador] = jugador.getValue();
                }
                reemplazado = true; //si estaba presente entonces true
            }
            else {
                tiempos[contador] = tiempoJugador; 
                tiemposStr[contador] = jugador.getValue();
            }

            jugadoresNombres[contador] = jugador.getKey();
            contador++;
        }

        if (!reemplazado) { //si no es un reemplazo entonces se agrega
            if (contador < 10) {
                tiempos[contador] = tiempoJugadorActual;
                tiemposStr[contador] = hora+":"+minuto+":"+segundo;
                jugadoresNombres[contador] = nombre;
                contador++;
                
            } else {
                for (int i = 0; i < contador; i++) { 
                    if (tiempoJugadorActual < tiempos[i]) { //reemplazar jugador si el espacio y el tiempo dejan
                        
                        tiempos[i] = tiempoJugadorActual;
                        tiemposStr[i] = hora+":"+minuto+":"+segundo;
                        jugadoresNombres[i] = nombre;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < contador - 1; i++) {
            for (int j = i + 1; j < contador; j++) { //ordenar
                if (tiempos[i] > tiempos[j]) {
                    
                    int actualTiempo = tiempos[i];
                    tiempos[i] = tiempos[j];
                    tiempos[j] = actualTiempo;

                    String actualTiempoStr = tiemposStr[i];
                    tiemposStr[i] = tiemposStr[j];
                    tiemposStr[j] = actualTiempoStr;
                    
                    
                    String actualJugadorNombre = jugadoresNombres[i];
                    jugadoresNombres[i] = jugadoresNombres[j];
                    jugadoresNombres[j] = actualJugadorNombre;
                    
                }
            }
        }
        jugadores.clear();
        for(int i = 0; i < contador; i++) { //agregar ordenado
            if (jugadoresNombres[i] != null) {
                jugadores.put(jugadoresNombres[i], tiemposStr[i]);
            }
        }
        return jugadores;
    }



    
    public static void addJugadores(String nombre, int hora, int minuto, int segundo, String nivel){
        switch(nivel){
            case "Facil":
                System.out.println("Facil");
                jugadoresFacil = (LinkedHashMap) actualizarJugadores(jugadoresFacil, nombre, hora, minuto, segundo);
                Top10.setJugadoresFacil(jugadoresFacil);
                Top10.guardarTopXML(new Top10());
                System.out.println(Top10.toStringJugadoresFacil());
                break;
            case "Intermedio":
                System.out.println("Intermedio");
                jugadoresIntermedio = (LinkedHashMap) actualizarJugadores(jugadoresIntermedio, nombre, hora, minuto, segundo);
                Top10.setJugadoresIntermedio(jugadoresIntermedio);
                Top10.guardarTopXML(new Top10());
                System.out.println(Top10.toStringJugadoresIntermedio());
                break;
            case "Dificil":
                System.out.println("Dificil");
                jugadoresDificil = (LinkedHashMap) actualizarJugadores(jugadoresDificil, nombre, hora, minuto, segundo);
                Top10.setJugadoresDificil(jugadoresDificil);
                Top10.guardarTopXML(new Top10());
                System.out.println(Top10.toStringJugadoresDificil());
                break;
            
            }
    }
    
    public static String toStringJugadoresFacil(){
        String jugadores = "";
        for (Map.Entry<String, String> jugador : jugadoresFacil.entrySet()) {
            jugadores += jugador.getKey() +" " + jugador.getValue()+ " \n";
        }
        return jugadores;
    }
    
    public static String toStringJugadoresIntermedio(){
        String jugadores = "";
        for (Map.Entry<String, String> jugador : jugadoresIntermedio.entrySet()) {
            jugadores += jugador.getKey() +" " + jugador.getValue()+ " \n";
        }
        return jugadores;
    }
    
    public static String toStringJugadoresDificil(){
        String jugadores = "";
        for (Map.Entry<String, String> jugador : jugadoresDificil.entrySet()) {
            jugadores += jugador.getKey() +" " + jugador.getValue()+ " \n";
        }
        return jugadores;
    }
    
    public static <T> void guardarTopXML(T objetoConfig) { //programacion generica
        try{
            JAXBContext objetoContext = JAXBContext.newInstance(objetoConfig.getClass()); // JAXB = Java Architecture for XML Binding. Crea una instancia JAXB del objeto para serializarlo y asi guardarlo

            Marshaller objetoMarsh = objetoContext.createMarshaller(); //java a xml
            objetoMarsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // las propiedades del archivo

            objetoMarsh.marshal(objetoConfig, new File("files/futoshiki2024top10.xml")); //convierte el objeto a xml
            System.out.println("Se guardo correctamente");
        }
        catch (JAXBException e){ //error al hacerlo
            System.out.println(e);
        }
    }
    
    public static Top10 cargarTopXML() {
    try {

            JAXBContext objetoContext = JAXBContext.newInstance(Top10.class); //JAXB= Java Architecture for XML Binding. Crea una instancia JAXB del objeto

            Unmarshaller objetoUnmarsh = objetoContext.createUnmarshaller(); //xml a java

            File archivo = new File("files/futoshiki2024top10.xml"); //crea objeto file con la informacion
            Top10 top = (Top10) objetoUnmarsh.unmarshal(archivo); //crea el top

            System.out.println("Se cargo correctamente");
            return top;
        } catch (JAXBException e) { //error
            System.out.println(e);
            return null;
        }
    }
    
    //getters
    
    @XmlElement // elemento en el xml
    public Map<String, String> getJugadoresFacil(){
        return jugadoresFacil;
    }
    
    @XmlElement // elemento en el xml
    public Map<String, String> getJugadoresIntermedio(){
        return jugadoresIntermedio;
    }
    
    @XmlElement // elemento en el xml
    public Map<String, String> getJugadoresDificil(){
        return jugadoresDificil;
    }
    
    //setters
    
    public static void setJugadoresFacil(LinkedHashMap<String, String> pJugadoresFacil){
        jugadoresFacil = (LinkedHashMap) pJugadoresFacil;
    }
    
    public static void setJugadoresIntermedio(LinkedHashMap<String, String> pJugadoresIntermedio){
        jugadoresIntermedio = (LinkedHashMap) pJugadoresIntermedio;
    }

    public static void setJugadoresDificil(LinkedHashMap<String, String> pJugadoresDificil){
        jugadoresDificil = (LinkedHashMap) pJugadoresDificil;
    }
    
}
