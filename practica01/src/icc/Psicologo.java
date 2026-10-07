package icc;

import java.util.Scanner;

/**
 * Simula una sesión con un psicologo.
 * Psicologo.java
 * @author Alva Pacheco Antonio
 * @version 1.0
 * Num. Cuenta: 323569369
 * Fecha: 06/10/2026

*/

public class Psicologo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nombre;
        String problema;
        String respuesta;


        System.out.println("Bienvenido, ¿cuál es su nombre?");
        nombre = in.nextLine();

        System.out.println("Buenas tardes, " + nombre + ".");
        System.out.println("Dígame, cuál es su problema en la vida?");
        problema = in.nextLine();

        System.out.println("MMM, ya veo");
        System.out.println("Y dígame...");
        System.out.println("Por qué dice" + " \"" + problema + "\"?");
        respuesta = in.nextLine();

        System.out.println ("Interesante interesante!!, hablaremos de ello con más detalle en la siguiente sesión");



    }
}