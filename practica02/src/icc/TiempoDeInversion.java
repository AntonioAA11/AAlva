package icc;

import java.util.Scanner;

/**
 * Clase que simula una inversion bancaria. Pide al inversionista el monto,
 * la fecha de inicio y la fecha de fin, y muestra cuantos dias dura la
 * inversion y su rendimiento con una tasa anual del 12%.
 * Objetivo: probar la clase Fecha y usar instrucciones condicionales.
 * @author Antonio Alva Pacheco
 * @version 1.0
 */
public class TiempoDeInversion {

  /**
   * Metodo principal que realiza la simulacion de inversion.
   * @param pps - argumentos de la linea de comandos (no se usan)
   */
  public static void main(String[] pps) {
                                                  // Declaracion de variables
    Scanner in = new Scanner(System.in);  // Lector
    final double TASA_ANUAL = 0.12;       // Tasa de rendimiento anual (12%)
    String nombre;                        // Nombre del inversionista
    String respuesta;                     // Respuesta para otra simulacion
    double monto;                         // Monto a invertir
    double rendimiento;                   // Ganancia de la inversion
    int dia, mes, anio;                   // Datos leidos de una fecha
    int dias;                             // Dias que dura la inversion
    boolean fechaValida;                  // Indica si la fecha leida existe
    boolean otra;                         // Indica si se hace otra simulacion
    Fecha inicio;                         // Fecha de inicio de la inversion
    Fecha fin;                            // Fecha de fin de la inversion

                          // (a) Da la bienvenida y solicita el nombre
    System.out.println("=============================================");
    System.out.println("  Bienvenido al simulador de inversiones");
    System.out.println("=============================================");
    System.out.print("Por favor, escribe tu nombre: ");
                          // (b) Recaba el nombre del inversionista
    nombre = in.nextLine().trim();

    do {
                          // (c) Saluda y pregunta por el monto a invertir
      System.out.println();
      System.out.println("Hola " + nombre + ", ¿cuanto dinero deseas invertir?");
                          // (d) Recaba el monto, debe ser mayor que cero
      do {
        System.out.print("Monto: $");
        monto = in.nextDouble();
        if (monto <= 0) {
          System.out.println("El monto debe ser mayor que cero.");
        }
      } while (monto <= 0);

                          // (e) Pregunta por la fecha de inicio
      System.out.println("¿En que fecha inicia tu inversion?");
                          // (f) Recaba la fecha de inicio y la valida
      do {
        System.out.print("  Dia: ");
        dia = in.nextInt();
        System.out.print("  Mes (numero del 1 al 12): ");
        mes = in.nextInt();
        System.out.print("  Anio: ");
        anio = in.nextInt();
        inicio = new Fecha(dia, mes, anio);
                          // Si la clase Fecha corrigio algun dato, la fecha no existe
        fechaValida = inicio.obtenerDia() == dia && inicio.obtenerMes() == mes
                      && inicio.obtenerAnio() == anio;
        if (!fechaValida) {
          System.out.println("Esa fecha no existe, intentalo de nuevo.");
        }
      } while (!fechaValida);

                          // (g) Pregunta por la fecha de fin
      System.out.println("¿En que fecha termina tu inversion?");
                          // (h) Recaba la fecha de fin, debe existir y ser
                          //     posterior a la fecha de inicio
      do {
        System.out.print("  Dia: ");
        dia = in.nextInt();
        System.out.print("  Mes (numero del 1 al 12): ");
        mes = in.nextInt();
        System.out.print("  Anio: ");
        anio = in.nextInt();
        fin = new Fecha(dia, mes, anio);
        fechaValida = fin.obtenerDia() == dia && fin.obtenerMes() == mes
                      && fin.obtenerAnio() == anio;
        if (!fechaValida) {
          System.out.println("Esa fecha no existe, intentalo de nuevo.");
        } else if (fin.comparar(inicio) <= 0) {
          System.out.println("La fecha de fin debe ser posterior a "
                             + inicio + ", intentalo de nuevo.");
          fechaValida = false;
        }
      } while (!fechaValida);

                          // (i) Muestra los dias de la inversion y su rendimiento
      dias = fin.diferencia(inicio);
      rendimiento = monto * TASA_ANUAL * dias / 365;
      rendimiento = Math.round(rendimiento * 100) / 100.0;   // Redondea a centavos

      System.out.println();
      System.out.println("---------------- Resultado ----------------");
      System.out.println("Inversionista: " + nombre);
      System.out.println("Monto invertido: $" + monto);
      System.out.println("Del " + inicio + " al " + fin);
      System.out.println("Tu inversion seria de " + dias + " dias.");
      System.out.println("Rendimiento al 12% anual: $" + rendimiento);
      System.out.println("Total al terminar: $"
                         + Math.round((monto + rendimiento) * 100) / 100.0);
      System.out.println("-------------------------------------------");

                          // (j) Pregunta si desea hacer otra simulacion
      System.out.print("¿Deseas hacer otra simulacion? (si/no): ");
      in.nextLine();                      // Descarta el fin de linea pendiente
      respuesta = in.nextLine().trim().toLowerCase();
      otra = respuesta.equals("si") || respuesta.equals("sí")
             || respuesta.equals("s");
    } while (otra);                       // Si responde si, vuelve al paso (c)

    System.out.println("Gracias por usar el simulador, " + nombre + ". ¡Hasta pronto!");
  }
}