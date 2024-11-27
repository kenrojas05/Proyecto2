
package modeloFutoshiki;


/**
 *
 * @author Kendall Ariel Rojas Cartin
 */

//(Documentar mejor PDF final) XML
import javax.xml.bind.annotation.*; //para la serializacion y el guardado de archivo xml
import javax.xml.bind.*;   
import java.io.File;

import java.util.ArrayList; //DE MOMENTO NO LO USO PERO POR SI ACASO (en caso de no borrar)
import java.util.List;

@XmlRootElement
public class PartidasFutoshiki {
    
    
    List<Partida> listaPartidas = new ArrayList<>();
    
    /**
     * Constructor vacio de partidas futoshiki
     **/
    
    PartidasFutoshiki(){}
    
    /**
     * Constructor de las partidas futoshiki
     * @param pListaPartidas lista de partidas;
     **/
    
    public PartidasFutoshiki(List<Partida> pListaPartidas){
        listaPartidas = pListaPartidas;
    }
    
    /**
     * Agregar la partida a la lista de partidas
     * @param partida la partida a agregar
     **/
    
    public void agregarPartida(Partida partida){
        listaPartidas.add(partida);
    }

    /**
     * Consigue la Partida para jugar dependiendo del nivel y la cuadricula
     * @param nivel nivel de dificultad
     * @param cuadricula byte del tamano de cuadricula
     * @return Partida juego
     **/
    
    public Partida partidaJugar(String nivel, byte cuadricula){
        for (Partida juego : listaPartidas){
            if (juego.getNivel().equals(nivel) && juego.getCuadricula()==cuadricula){
                return juego;
            }
        }
        return null;
    }
    
    /**
     * toString de las partidas
     * @return String de todas las partidas
     **/
    
    public String toStringPartidas() {
        String partida = "";
        for (Partida juego : listaPartidas) {
            partida+="Nivel: " + juego.getNivel()
                   + " Cuadricula: " + juego.getCuadricula()
                   + "\nConstantes: " + juego.toStringConstante()
                   + "\nDesigualdades: " + juego.toStringDesigualdad()
                   + "\nPartida Juego:\n";

            // Imprimir la partidaJuego de manera legible
            for (int fila = 0; fila < juego.getPartidaJuego().length; fila++) {
                for (int columna = 0; columna < juego.getPartidaJuego()[fila].length; columna++) {
                    partida += juego.getPartidaJuego()[fila][columna] + " ";
                }
                partida += "\n";
            }
            partida += "\n";
        }
        return partida;
    }
    
    /**
     * Imprime los numeros de la partida int[][]
     * @param partida la partida en matriz
     **/
    
    public void imprimeNumeros(int[][] partida){
        for (int i = 0; i < partida.length; i++) {
            for (int j = 0; j < partida[i].length; j++) {
                    System.out.print(partida[i][j] + " ");
                }
        System.out.println();    
        }
            
    }

    /**
     * Guarda PartidaFutoshiji en un XML
     * @param <T> recibeobjeto
     * @param objetoConfig el objeto a guardar
     **/
    
    public static <T> void guardarPartidaFutoshikiXML(T objetoConfig) { //programacion generica
        try{
            JAXBContext objetoContext = JAXBContext.newInstance(objetoConfig.getClass()); // JAXB = Java Architecture for XML Binding. Crea una instancia JAXB del objeto para serializarlo y asi guardarlo

            Marshaller objetoMarsh = objetoContext.createMarshaller(); //java a xml
            objetoMarsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // las propiedades del archivo

            objetoMarsh.marshal(objetoConfig, new File("files/futoshiki2024partidas.xml")); //convierte el objeto a xml
            System.out.println("Se guardo correctamente");
        }
        catch (JAXBException e){ //error al hacerlo
            System.out.println(e);
        }
    }
    
    /**
     * Recupera los datos del XML 
     * @return PartidasFutoshiki
     **/
    
    public static PartidasFutoshiki cargarPartidaFutoshikiXML() {
    try {

            JAXBContext objetoContext = JAXBContext.newInstance(PartidasFutoshiki.class); //JAXB= Java Architecture for XML Binding. Crea una instancia JAXB del objeto

            Unmarshaller objetoUnmarsh = objetoContext.createUnmarshaller(); //xml a java

            File archivo = new File("files/futoshiki2024partidas.xml"); //crea objeto file con la informacion
            PartidasFutoshiki partida = (PartidasFutoshiki) objetoUnmarsh.unmarshal(archivo); //crea la config

            System.out.println("Se cargo correctamente");
            return partida;
        } catch (JAXBException e) { //error
            System.out.println(e);
            return null;
        }
    }
    

    /**
     * Consigue la lista de partidas 
     * @return List de todas las Partida
     **/
    
    @XmlElementWrapper(name = "partidas")
    @XmlElement(name = "partida")
    public List<Partida> getListaPartidas() {
        return listaPartidas;
    }
    
    
}
