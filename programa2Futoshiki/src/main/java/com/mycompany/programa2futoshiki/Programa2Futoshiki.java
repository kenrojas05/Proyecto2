

package com.mycompany.programa2futoshiki;

/**
 *
 * @author Kendall Ariel Rojas Cartin
 * 
 */
public class Programa2Futoshiki {

    public static void main(String[] args) {
        
        Configuracion newConfig = new Configuracion();
        newConfig.setJugadores("Kendall", "Tango");
        System.out.println(newConfig.toStringJugador("Kendall"));
        GUIFutoshiki.main(args);
        
    }
}
