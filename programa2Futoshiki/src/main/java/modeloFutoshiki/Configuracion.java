
package modeloFutoshiki; 



//MAP

import java.util.Arrays;
import java.util.HashMap;  //Map es un objeto
import java.util.Map;      //lo que hace es que guarda valores con Keys o llaves (parecido a un directorio)

//XML
import java.io.File;
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
    

    
    @XmlTransient //ignora el atributo al formar el XML
    public static HashMap<String, Jugador> jugadores = new HashMap<>(); //nombre key password value
    
    /**
     * Constructor de la configuracion inicializada en los valores predeterminados
     **/
    
    public Configuracion(){
        setCuadricula((byte)5);
        setNivel("Facil");
        setMultinivel(false);
        setReloj("Cronometro");
        setPosicion(false);
    }
    
    /**
     * Constructor con valores perzonalizados
     * @param pCuadricula byte que determina la matriz del juego
     * @param pNivel String que decide el nivel en "Facil" "Intermedio" "Dificil"
     * @param pMultinivel determina si es multinivel o no 
     * @param pReloj String que determina si se utiliza reloj "No" y de que tipo Cronometro o Temporizador
     * @param pPosicion false se posiciona los numeros en la derecha true en la izquierda
     **/
    
    public Configuracion(byte pCuadricula, String pNivel, boolean pMultinivel, String pReloj, boolean pPosicion){
        setCuadricula(pCuadricula);
        setNivel(pNivel);
        setMultinivel(pMultinivel);
        setReloj(pReloj);
        setPosicion(pPosicion);
    }
    
    /**
     * Consigue el jugador del HashMap de los jugadores con el nombre de este
     * @param keyNombre el nombre del jugador a buscar
     * @return retorna el objeto Jugador de este
     **/
    
    public Jugador conseguirJugador(String keyNombre){ //si no se encuentra entonces incognito
        if (jugadores.containsKey(keyNombre)){
            return jugadores.get(keyNombre);
        }
        else {
            return new Jugador();
        }
    }
    
    /**
     * Guarda la configuracion en un archivo XML
     * @param objetoConfig Objeto a guardar
     * @param <T> Objeto de Configuracion ya que se guarda en un archivo dedicado
     **/
    
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
    
    /**
     * Carga la configuracion del archivo XML
     * @return objeto Configuracion
     **/
    
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
    
    /**
     * toString de la configuracion
     * @return String de la configuracion
     **/
    
    public String toStringConfiguracion(){
        return "Cuadricula: "+cuadricula+" Nivel: "+nivel+" Multinivel: "+multinivel+" Reloj: "+reloj+" Posicion: "+posicion;
    }
    
    /**
     * toString del Jugador buscado con nombre
     * @param nombre nombre del jugador a buscar
     * @return String de los datos del jugador
     **/
    
    public static String toStringJugador(String nombre){
        if (jugadores.containsKey(nombre)){
            return "Nombre: " + jugadores.get(nombre).getNombre() + " Contrasena: " + jugadores.get(nombre).getPassword()   + " Cuadricula: " + Arrays.toString(jugadores.get(nombre).getCuadriculaActual())
                                                                                                    + " PartidaActual: " + jugadores.get(nombre).getPartidaActual()
                                                                                                    + " Partidas Jugadas: " + jugadores.get(nombre).getListaPartidasJugadas();
        }
        return "";
    }
    
    /**
     * toString de los jugadores
     * @return String de los jugadores del Map
     **/
    
    public static String toStringJugadores(){
        String jugadoresRegistrados = "";
        for (Map.Entry<String, Jugador> jugador : jugadores.entrySet()) {
            
            jugadoresRegistrados += "Jugador: " + toStringJugador(jugador.getKey())+"\n";
        }
        return jugadoresRegistrados;
    }
    
    /**
     * Determina si el nombre tiene un tamano valido
     * @param nombre el nombre
     * @return true si es valido false en caso contrario
     **/
    
    public static boolean nombreValido(String nombre){
        if (nombre.length()>=1 || nombre.length()<=30){
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Agrega el jugador si es valido su nombre y es unico
     * @param nombre nombre del jugador
     * @param jugador objeto jugador 
     **/
    
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
    
    /**
     * Comprueba que el temporizador no inicie en 0
     **/
    
    public void comprobarTemporizador(){
        if (temporizadorHora == 0 && temporizadorMinuto == 0 && temporizadorSegundo == 0){
            throw new IllegalArgumentException("0 0 0");
        }
    }
    
    
    //getters
    
    /**
     * Consigue el byte que determina la cuadricula
     * @return byte del 3 al 10
     **/
    
    @XmlElement // elemento en el xml
    public byte getCuadricula(){
        return cuadricula;
    }
    
    /**
     * Consigue el nivel de dificultad
     * @return String dificultad entre "Facil "Intermedio" "Dificil
     **/
    
    @XmlElement // elemento en el xml
    public String getNivel(){
        return nivel;
    }
    
    /**
     * Consigue el booleano que determina si es multinivel o no
     * @return boolean false no multinivel true multinivel
     **/
    
    @XmlElement // elemento en el xml
    public boolean getMultinivel(){
        return multinivel;
    }
    
    /**
     * Consigue el string que determina el reloj
     * @return Cronometro, No, Temporizador
     **/
    
    @XmlElement // elemento en el xml
    public String getReloj(){
        return reloj;
    }
    
    /**
     * Consigue la posicion del panel de numeros en booleano
     * @return false derecha true izquierda
     **/
    
    @XmlElement // elemento en el xml
    public boolean getPosicion(){
        return posicion;
    }
    
    /**
     * Consigue el map de los jugadores
     * @return Map de jugadores key nombre string value objeto Jugador
     **/
    
    @XmlElement // elemento en el xml
    public Map<String, Jugador> getJugadores(){
        return jugadores;
    }
    
    /**
     * Consigue la hora del temporizador 
     * @return int hora 
     **/
    
    @XmlElement // elemento en el xml
    public int getTemporizadorHora(){
        return temporizadorHora;
    }
    
    /**
     * Consigue los minutos del temporizador
     * @return int minutos
     **/
    
    @XmlElement // elemento en el xml
    public int getTemporizadorMinuto(){
        return temporizadorMinuto;
    }
    
    /**
     * Consigue los segundos del temporizador
     * @return int segundos
     **/
    
    @XmlElement // elemento en el xml
    public int getTemporizadorSegundo(){
        return temporizadorSegundo;
    }
    
    
    //setters
    
    /**
     * Set la cuadricula
     * @param pCuadricula byte numero de la cuadricula
     **/
    
    public void setCuadricula(byte pCuadricula){
        if (pCuadricula<3 || pCuadricula>10){
            throw new IllegalArgumentException("Tamano de cuadricula inadecuado");
        }
        else {
            cuadricula = pCuadricula;
        }
    }
    
    /**
     * Set del nivel
     * @param pNivel String que determina la dificultad
     **/
    
    public void setNivel(String pNivel){ 
        nivel = pNivel;
    }
    
    /**
     * Set de si es Multinivel o no
     * @param pMultinivel boolean que determina el multinivel
     **/
    
    public void setMultinivel(boolean pMultinivel){
        multinivel = pMultinivel;
    }
    
    /**
     * Set del reloj
     * @param pReloj string del tipo de reloj que se quiere
     **/
    
    public void setReloj(String pReloj){
        reloj = pReloj;
    }
    
    /**
     * Set de la posicion del panel de numeros
     * @param pPosicion boolean que determina derecha o izquierda
     **/
    
    public void setPosicion(boolean pPosicion){
        posicion = pPosicion;
    }
    
    /**
     * Set del temporizadorHora
     * @param hora int que dicta la hora del temporizador
     **/

    public void setTemporizadorHora(int hora){
        if (hora<0 || hora>5){
            throw new IllegalArgumentException("Hora debe ser entre 0 y 5");
        }
        else {
            temporizadorHora = hora;
        }
    }
    
    /**
     * Set del temporizadorMinuto
     * @param minuto int que dicta los minutos del temporizador
     **/
    
    public void setTemporizadorMinuto(int minuto){
        if (minuto<0 || minuto>59){
            throw new IllegalArgumentException("Minuto debe ser entre 0 y 59");
        }
        else {
            temporizadorMinuto = minuto;
        }
    }
    
    /**
     * Set del temporizadorSegundo
     * @param segundo byte numero de la cuadricula
     **/
    
    public void setTemporizadorSegundo(int segundo){
        if (segundo<0 || segundo>59){ //puesto que ya se valida par evitar 0s en todo no es necesario ver si los segundos son validos para que no pongan vacio asi que el tiempo minio es 1sec
            throw new IllegalArgumentException("Segundos debe ser entre 0 y 59");
        }
        else {
            temporizadorSegundo = segundo;
        }
    }
}
