
package icc;

import java.util.Scanner;

/**
 * Programa para generar una clave al estilo del RFC de las personas.
 * RFC.java
 * @author Alva Pacheco Antonio
 * @version 1.0
 * Num. Cuenta: 323569369
 * Fecha: 06/10/2026

*/

public  class RFC {
    public static void main (String [] args){
        Scanner in = new Scanner(System.in);
        String nombreCompleto;
        String fecha;
    

        System.out.println("Deme su nombre completo");
        nombreCompleto = in.nextLine();

        System.out.println("ingrese su fecha de nacimiento, en formato dd/mm/aa,");
        fecha = in.nextLine();
        String [] partes = nombreCompleto.split(" ");
        String  paterno = partes[1].substring(0, 2);
        String materno = partes[2].substring(0, 1);
        String nombre = partes[0].substring(0, 1);

        String [] partesFecha = fecha.split("/");
        String dia = partesFecha[0].substring(0, 2);
        String mes = partesFecha[1].substring(0, 2);
        String año = partesFecha[2].substring(0, 2);

        String rfc = paterno + materno + nombre + año + mes + dia; 
        System.out.println("El RFC de " + nombreCompleto + " es: " + rfc.toUpperCase());







    }



}