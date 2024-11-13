
package com.mycompany.programa2futoshiki;
import static com.mycompany.programa2futoshiki.GUIFutoshiki.configFutoshiki; //por los datos


/**
 *
 * @author Kendall Ariel Rojas Cartin
 */

//(Documentar mejor PDF final) XML
import javax.xml.bind.annotation.*; //para la serializacion y el guardado de archivo xml
import javax.xml.bind.*;   
import java.io.File;

import java.util.ArrayList; //DE MOMENTO NO LO USO PERO POR SI ACASO (en caso de no borrar)
import java.util.Collections;
import java.util.List;

@XmlRootElement
public class PartidasFutoshiki {
    
    List<Partida> listaPartidas;
    
    PartidasFutoshiki(){}
    
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

    
}
