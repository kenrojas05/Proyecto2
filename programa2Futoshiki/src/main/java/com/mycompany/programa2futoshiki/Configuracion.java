
package com.mycompany.programa2futoshiki; //correo jvim woqi nqnz puyb

//(Documentar mejor en el PDF al final)
import java.util.HashMap;  //Map es un objeto
import java.util.Map;      //lo que hace es que guarda valores con Keys o llaves (parecido a un directorio)

import java.time.LocalDateTime; // Sirve para dar la hora del sistema
import javax.mail.*; // Se añadió la librería llib al proyecto para la API javax.mail
import java.util.Properties; 
import javax.mail.internet.*; // Importa las clases necesarias para MIME


/**
 *
 * @author Kendall Rojas Cartin
 */
public class Configuracion {
    private byte cuadricula; //puesto que es cuadrada es decir 2x2 3x3 y asi solo ocupa el digito
    private String nivel; //Facil, Intermedio, Dificil
    private boolean multinivel; //false: no, true: si
    private String reloj; //Cronometro, No, Temporizador
    private boolean posicion; // false: derecha, true: izquierda

    public static Map<String, String> jugadores = new HashMap<>(); //nombre key password value
    
    public String toStringJugador(String nombre){
        if (jugadores.containsKey(nombre)){
            return nombre + " " + jugadores.get(nombre);
        }
        return "";
    }
    
    public static boolean nombreValido(String nombre){
        if (nombre.length()>=1 || nombre.length()<=30){
            return true;
        }
        else {
            return false;
        }
    }
    
    public static void setJugadores(String nombre, String password){
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
            jugadores.put(nombre, password);
        }
        
    }
}
