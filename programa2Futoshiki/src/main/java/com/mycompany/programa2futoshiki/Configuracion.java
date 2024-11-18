
package com.mycompany.programa2futoshiki; //correo jvim woqi nqnz puyb


//(Documentar mejor en el PDF al final) MAP
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;  //Map es un objeto
import java.util.Map;      //lo que hace es que guarda valores con Keys o llaves (parecido a un directorio)
import javax.swing.SwingUtilities;

//(Documentar mejor PDF final) XML
import javax.xml.bind.annotation.*; //para la serializacion y el guardado de archivo xml
import javax.xml.bind.*;            


/**
 *
 * @author Kendall Rojas Cartin
 */

@XmlRootElement // raiz del xml
public class Configuracion {

    private byte cuadricula = 5; //puesto que es cuadrada es decir 3x3 y asi solo ocupa el digito
    private String nivel = "Facil"; //Facil, Intermedio, Dificil
    private boolean multinivel = false; //false: no, true: si
    private String reloj = "Cronometro"; //Cronometro, No, Temporizador
    private boolean posicion = false; // false: derecha, true: izquierda
    
    public static int temporizadorHora = 0;
    public static int temporizadorMinuto = 0;
    public static int temporizadorSegundo = 0;
    

    
    @XmlTransient //ignora el atributo
    public static HashMap<String, Jugador> jugadores = new HashMap<>(); //nombre key password value
    
    Configuracion(){
        setCuadricula((byte)5);
        setNivel("Facil");
        setMultinivel(false);
        setReloj("Cronometro");
        setPosicion(false);
    }
    
    Configuracion(byte pCuadricula, String pNivel, boolean pMultinivel, String pReloj, boolean pPosicion){
        setCuadricula(pCuadricula);
        setNivel(pNivel);
        setMultinivel(pMultinivel);
        setReloj(pReloj);
        setPosicion(pPosicion);
    }
    
    
    public static <T> void guardarConfiguracionXML(T objetoConfig) { //programacion generica
        try{
            JAXBContext objetoContext = JAXBContext.newInstance(objetoConfig.getClass()); // JAXB = Java Architecture for XML Binding. Crea una instancia JAXB del objeto para serializarlo y asi guardarlo

            Marshaller objetoMarsh = objetoContext.createMarshaller(); //java a xml
            objetoMarsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // las propiedades del archivo

            objetoMarsh.marshal(objetoConfig, new File("files/futoshiki2024configuración.xml")); //convierte el objeto a xml
            System.out.println("Se guardo correctamente");
        }
        catch (JAXBException e){ //error al hacerlo
            System.out.println(e);
        }
    }
    
    public static Configuracion cargarConfiguracionXML() {
    try {

            JAXBContext objetoContext = JAXBContext.newInstance(Configuracion.class); //JAXB= Java Architecture for XML Binding. Crea una instancia JAXB del objeto

            Unmarshaller objetoUnmarsh = objetoContext.createUnmarshaller(); //xml a java

            File archivo = new File("files/futoshiki2024configuración.xml"); //crea objeto file con la informacion
            Configuracion config = (Configuracion) objetoUnmarsh.unmarshal(archivo); //crea la config

            System.out.println("Se cargo correctamente");
            return config;
        } catch (JAXBException e) { //error
            System.out.println(e);
            return null;
        }
    }
    
    
    
    
    
    public String toStringConfiguracion(){
        return "Cuadricula: "+cuadricula+" Nivel: "+nivel+" Multinivel: "+multinivel+" Reloj: "+reloj+" Posicion: "+posicion;
    }
    
    public static String toStringJugador(String nombre){
        if (jugadores.containsKey(nombre)){
            return "Nombre: " + jugadores.get(nombre).getNombre() + " Contrasena: " + jugadores.get(nombre).getPassword()   + " Cuadricula: " + Arrays.toString(jugadores.get(nombre).getCuadriculaActual())
                                                                                                    + " PartidaActual: " + jugadores.get(nombre).getPartidaActual()
                                                                                                    + " Partidas Jugadas: " + jugadores.get(nombre).getListaPartidasJugadas();
        }
        return "";
    }
    
    public static String toStringJugadores(){
        String jugadoresRegistrados = "";
        for (Map.Entry<String, Jugador> jugador : jugadores.entrySet()) {
            
            jugadoresRegistrados += "Jugador: " + toStringJugador(jugador.getKey())+"\n";
        }
        return jugadoresRegistrados;
    }
    
    
    public static boolean nombreValido(String nombre){
        if (nombre.length()>=1 || nombre.length()<=30){
            return true;
        }
        else {
            return false;
        }
    }
    public static void addJugadores(String nombre, Jugador jugador){
        if (nombre.length()==0){
            throw new IllegalArgumentException("INCOGNITO DEBERIA SER");
        }
        if (nombre.length()>30){
            throw new IllegalArgumentException("Exceso de caracteres en el nombre (+30)");
        }
        else if (jugadores.containsKey(nombre)){
            throw new IllegalArgumentException("Nombre debe ser unico");
        }
        else{
            jugadores.put(nombre, jugador);
        }
        
    }
    
    public void comprobarTemporizador(){
        if (temporizadorHora == 0 && temporizadorMinuto == 0 && temporizadorSegundo == 0){
            throw new IllegalArgumentException("0 0 0");
        }
    }
    
    
    //getters
    
    @XmlElement // elemento en el xml
    public byte getCuadricula(){
        return cuadricula;
    }
    @XmlElement // elemento en el xml
    public String getNivel(){
        return nivel;
    }
    @XmlElement // elemento en el xml
    public boolean getMultinivel(){
        return multinivel;
    }
    @XmlElement // elemento en el xml
    public String getReloj(){
        return reloj;
    }
    @XmlElement // elemento en el xml
    public boolean getPosicion(){
        return posicion;
    }
    @XmlElement // elemento en el xml
    public Map<String, Jugador> getJugadores(){
        return jugadores;
    }
    @XmlElement // elemento en el xml
    public int getTemporizadorHora(){
        return temporizadorHora;
    }
    @XmlElement // elemento en el xml
    public int getTemporizadorMinuto(){
        return temporizadorMinuto;
    }
    @XmlElement // elemento en el xml
    public int getTemporizadorSegundo(){
        return temporizadorSegundo;
    }
    
    
    //falta guardar jugaodres
    
    //setters
    
    public void setCuadricula(byte pCuadricula){
        if (pCuadricula<3 || pCuadricula>10){
            throw new IllegalArgumentException("Tamano de cuadricula inadecuado");
        }
        else {
            cuadricula = pCuadricula;
        }
    }
    public void setNivel(String pNivel){
        nivel = pNivel;
    }
    
    public void setMultinivel(boolean pMultinivel){
        multinivel = pMultinivel;
    }
    
    public void setReloj(String pReloj){
        reloj = pReloj;
    }
    public void setPosicion(boolean pPosicion){
        posicion = pPosicion;
    }

    public void setTemporizadorHora(int hora){
        if (hora<0 || hora>5){
            throw new IllegalArgumentException("Hora debe ser entre 0 y 5");
        }
        else {
            temporizadorHora = hora;
        }
    }
    
    public void setTemporizadorMinuto(int minuto){
        if (minuto<0 || minuto>59){
            throw new IllegalArgumentException("Minuto debe ser entre 0 y 59");
        }
        else {
            temporizadorMinuto = minuto;
        }
    }
    
    public void setTemporizadorSegundo(int segundo){
        if (segundo<0 || segundo>59){
            throw new IllegalArgumentException("Segundos debe ser entre 0 y 59");
        }
        else {
            temporizadorSegundo = segundo;
        }
    }
}
