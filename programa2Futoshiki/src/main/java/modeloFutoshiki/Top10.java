
package modeloFutoshiki;

import controladorFutoshiki.*;


import java.io.File;
import java.util.Map;
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
    
    /**
     * Constructor vacio de Top10
     **/
    
    public Top10(){}
    
    /**
     * Constructor de Top10
     * @param jugFacil LinkedHashMap de los jugadores que ganaron en Facil
     * @param jugIntermedio LinkedHashMap de los jugadores que ganaron en Intermedio
     * @param jugDificil LinkedHashMap de los jugadores que ganaron en Dificil
     **/
    
    public Top10(LinkedHashMap<String, String> jugFacil , LinkedHashMap<String, String> jugIntermedio, LinkedHashMap<String, String> jugDificil){
        jugadoresFacil = jugFacil;
        jugadoresIntermedio = jugIntermedio;
        jugadoresDificil = jugDificil;
    }
    
    /**
     * Actualiza el Map para guardar los jugadores dependiendo del tiempo que hicieron
     * @param jugadores key nombre del jugador value el numero en formato 00:00:00
     * @param nombre nombre del jugador a poner
     * @param hora numero de la hora que hizo
     * @param minuto numero de los minutos que hizo
     * @param segundo numero de los segundos que hizo
     * @return el Map actualizado
     **/
    
    private static Map<String, String> actualizarJugadores(Map<String, String> jugadores, String nombre, int hora, int minuto, int segundo) {
        
        int tiempoJugadorActual = hora * 3600 + minuto * 60 + segundo; //para tener el valor del tiempo tipo a segundos
        
        boolean reemplazado = false;

        int[] tiempos = new int[10]; //los tiempos en segundos
        String[] tiemposStr = new String[10]; //los tiempos en string
        String[] jugadoresNombres = new String[10]; //los jugadores
        
        int contador = 0;
        for (Map.Entry<String, String> jugador : jugadores.entrySet()) {
            String tiempo = jugador.getValue();
            String[] tiempoDividido = tiempo.split(":"); //divide el string en 00 00 00 para volverlos int (Documentar Split)

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
    
    /**
     * Agrega el jugador dependiendo del nivel y de si su tiempo cumple para entrar en el Top10
     * @param nombre nombre del jugador
     * @param hora numero de la hora que hizo
     * @param minuto numero de los minutos que hizo
     * @param segundo numero de los segundos que hizo
     * @param nivel nivel de dificultad
     **/
    
    public static void addJugadores(String nombre, int hora, int minuto, int segundo, String nivel){
        switch(nivel){
            case "Facil":
                System.out.println("Facil");
                jugadoresFacil = (LinkedHashMap) actualizarJugadores(jugadoresFacil, nombre, hora, minuto, segundo);
                Top10.setJugadoresFacil(jugadoresFacil);
                ControladorFutoshiki.guardarObjeto(new Top10()); //guardar
                System.out.println(Top10.toStringJugadoresFacil());
                break;
            case "Intermedio":
                System.out.println("Intermedio");
                jugadoresIntermedio = (LinkedHashMap) actualizarJugadores(jugadoresIntermedio, nombre, hora, minuto, segundo);
                Top10.setJugadoresIntermedio(jugadoresIntermedio);
                ControladorFutoshiki.guardarObjeto(new Top10()); //guardar
                System.out.println(Top10.toStringJugadoresIntermedio());
                break;
            case "Dificil":
                System.out.println("Dificil");
                jugadoresDificil = (LinkedHashMap) actualizarJugadores(jugadoresDificil, nombre, hora, minuto, segundo);
                Top10.setJugadoresDificil(jugadoresDificil);
                ControladorFutoshiki.guardarObjeto(new Top10()); //guardar
                System.out.println(Top10.toStringJugadoresDificil());
                break;
            
            }
    }
    
    /**
     * toString de los jugadores en dificultad facil
     * @return los jugadores en facil
     **/
    
    public static String toStringJugadoresFacil(){
        String jugadores = "";
        for (Map.Entry<String, String> jugador : jugadoresFacil.entrySet()) {
            jugadores += jugador.getKey() +" " + jugador.getValue()+ " \n";
        }
        return jugadores;
    }
    
    /**
     * toString de los jugadores en dificultad intermedio
     * @return los jugadores en intermedio
     **/
    
    public static String toStringJugadoresIntermedio(){
        String jugadores = "";
        for (Map.Entry<String, String> jugador : jugadoresIntermedio.entrySet()) {
            jugadores += jugador.getKey() +" " + jugador.getValue()+ " \n";
        }
        return jugadores;
    }
    
    /**
     * toString de los jugadores en dificultad dificil
     * @return los jugadores en dificil
     **/
    
    public static String toStringJugadoresDificil(){
        String jugadores = "";
        for (Map.Entry<String, String> jugador : jugadoresDificil.entrySet()) {
            jugadores += jugador.getKey() +" " + jugador.getValue()+ " \n";
        }
        return jugadores;
    }
    
    /**
     * Guarda el TOP10 en un archivo Xml
     * @param <T> objeto 
     * @param objetoTop el objeto del Top a guardar
     **/
    
    public static <T> void guardarTopXML(T objetoTop) { //programacion generica
        try{
            JAXBContext objetoContext = JAXBContext.newInstance(objetoTop.getClass()); // JAXB = Java Architecture for XML Binding. Crea una instancia JAXB del objeto para serializarlo y asi guardarlo

            Marshaller objetoMarsh = objetoContext.createMarshaller(); //java a xml
            objetoMarsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // las propiedades del archivo

            objetoMarsh.marshal(objetoTop, new File("files/futoshiki2024top10.xml")); //convierte el objeto a xml
            System.out.println("Se guardo correctamente");
        }
        catch (JAXBException e){ //error al hacerlo
            System.out.println(e);
        }
    }
    
    /**
     * Carga el TOP10 de un archivo Xml
     * @return Top10 del Xml
     **/
    
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
    
    /**
     * Consigue el Map de los jugadores en Facil
     * @return key es nombre value es tiempo tipo 00:00:00
     **/
    
    @XmlElement // elemento en el xml
    public Map<String, String> getJugadoresFacil(){
        return jugadoresFacil;
    }
    
    /**
     * Consigue el Map de los jugadores en Intermedio
     * @return key es nombre value es tiempo tipo 00:00:00
     **/
    
    @XmlElement // elemento en el xml
    public Map<String, String> getJugadoresIntermedio(){
        return jugadoresIntermedio;
    }
    
    /**
     * Consigue el Map de los jugadores en Dificil
     * @return key es nombre value es tiempo tipo 00:00:00
     **/
    
    @XmlElement // elemento en el xml
    public Map<String, String> getJugadoresDificil(){
        return jugadoresDificil;
    }
    
    //setters
    
    /**
     * Set los jugadores en facil
     * @param pJugadoresFacil LinkedHashMap con key nombre y value tiempo en formato 00:00:00
     **/
    
    public static void setJugadoresFacil(LinkedHashMap<String, String> pJugadoresFacil){
        jugadoresFacil = (LinkedHashMap) pJugadoresFacil;
    }
    
    /**
     * Set los jugadores en intermedio
     * @param pJugadoresIntermedio LinkedHashMap con key nombre y value tiempo en formato 00:00:00
     **/

    public static void setJugadoresIntermedio(LinkedHashMap<String, String> pJugadoresIntermedio){
        jugadoresIntermedio = (LinkedHashMap) pJugadoresIntermedio;
    }
    
    /**
     * Set los jugadores en Dificil
     * @param pJugadoresDificil LinkedHashMap con key nombre y value tiempo en formato 00:00:00
     **/

    public static void setJugadoresDificil(LinkedHashMap<String, String> pJugadoresDificil){
        jugadoresDificil = (LinkedHashMap) pJugadoresDificil;
    }
    
}
