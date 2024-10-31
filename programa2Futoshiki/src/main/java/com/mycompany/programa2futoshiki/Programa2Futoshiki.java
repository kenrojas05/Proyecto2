

package com.mycompany.programa2futoshiki;

/**
 *
 * @author Kendall Ariel Rojas Cartin
 * 
 */
public class Programa2Futoshiki {

    public static void main(String[] args) {
        Configuracion newConfig2 = new Configuracion((byte) 5, "Facil", false, "Cronometro", false);
        newConfig2.addJugadores("Kendall","Tango");
        System.out.println(Configuracion.toStringJugador("Kendall"));
        
        GUIFutoshiki.main(args);
        
    }
}
