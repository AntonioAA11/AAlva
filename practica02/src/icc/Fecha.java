package icc;

/**
 * Clase para crear y manejar fechas formadas por dia, mes y anio.
 * Permite sumar dias, obtener diferencias entre fechas, comparar
 * fechas y convertir el numero de un mes en su nombre y viceversa.
 * @author Antonio Alva Pacheco
 * @version 1.0
 */
public class Fecha {
                                        // Estructura
  private int dia;
  private int mes;
  private int anio;

  /* ======================= Metodos constructores ======================= */

  /**
   * Constructor por omision. Construye la fecha 1 de enero de 2000.
   */
  public Fecha() {
    this(1, 1, 2000);
  }

  /**
   * Constructor de una Fecha a partir del dia, el mes y el anio.
   * @param d - valor para el dia
   * @param m - valor para el mes (1 a 12)
   * @param a - valor para el anio (mayor o igual que 1)
   */
  public Fecha(int d, int m, int a) {
    asignarFecha(d, m, a);
  }

  /**
   * Constructor de una Fecha a partir del dia, el nombre del mes y el anio.
   * @param d - valor para el dia
   * @param nombreMes - nombre del mes, por ejemplo "septiembre"
   * @param a - valor para el anio (mayor o igual que 1)
   */
  public Fecha(int d, String nombreMes, int a) {
    asignarFecha(d, numeroDeMes(nombreMes), a);
  }

  /**
   * Constructor de una Fecha a partir de otra.
   * @param f - Fecha que se copiara
   */
  public Fecha(Fecha f) {
    this(f.dia, f.mes, f.anio);
  }

  /* ======================= Metodos modificadores ======================= */

  /**
   * Metodo para asignar los tres campos de una fecha. Primero se asigna el
   * anio, luego el mes y al final el dia, porque los dias validos dependen
   * del mes y del anio.
   * @param d - valor para el dia
   * @param m - valor para el mes
   * @param a - valor para el anio
   */
  public void asignarFecha(int d, int m, int a) {
    asignarAnio(a);
    asignarMes(m);
    asignarDia(d);
  }

  /**
   * Metodo para asignar el dia. Si el valor no es valido para el mes y
   * anio de la fecha, se envia un mensaje y se asigna el dia 1.
   * @param d - el dia para el objeto Fecha
   */
  public void asignarDia(int d) {
    if (d >= 1 && d <= diasDelMes(mes, anio)) {
      dia = d;
    } else {
      System.out.println("El valor " + d + " no es apropiado para el dia.");
      dia = 1;
    }
  }

  /**
   * Metodo para asignar el mes. Si el valor no esta entre 1 y 12 se envia
   * un mensaje y se asigna el mes 1. Si el dia actual ya no cabe en el
   * nuevo mes, se ajusta al ultimo dia de ese mes.
   * @param m - el mes para el objeto Fecha
   */
  public void asignarMes(int m) {
    if (m >= 1 && m <= 12) {
      mes = m;
    } else {
      System.out.println("El valor " + m + " no es apropiado para el mes.");
      mes = 1;
    }
    ajustarDia();
  }

  /**
   * Metodo para asignar el anio. Si el valor es menor que 1 se envia un
   * mensaje y se asigna el anio 1. Si el dia actual ya no cabe en el mes
   * (29 de febrero en un anio no bisiesto), se ajusta.
   * @param a - el anio para el objeto Fecha
   */
  public void asignarAnio(int a) {
    if (a >= 1) {
      anio = a;
    } else {
      System.out.println("El valor " + a + " no es apropiado para el anio.");
      anio = 1;
    }
    ajustarDia();
  }

  /* ======================= Metodos de acceso ======================= */

  /**
   * Metodo para obtener el dia de la fecha.
   * @return int - el dia del objeto Fecha
   */
  public int obtenerDia() {
    return dia;
  }

  /**
   * Metodo para obtener el mes de la fecha.
   * @return int - el mes del objeto Fecha
   */
  public int obtenerMes() {
    return mes;
  }

  /**
   * Metodo para obtener el anio de la fecha.
   * @return int - el anio del objeto Fecha
   */
  public int obtenerAnio() {
    return anio;
  }

  /* ======================= Metodos privados ======================= */

  /* Metodo que ajusta el dia cuando, al cambiar el mes o el anio, el dia
   * guardado ya no existe en ese mes. Lo deja en el ultimo dia del mes.
   */
  private void ajustarDia() {
    if (mes >= 1 && dia > diasDelMes(mes, anio)) {
      dia = diasDelMes(mes, anio);
    }
  }

  /* Metodo para determinar si un anio es bisiesto. Un anio es bisiesto si
   * es divisible entre 4 y no entre 100, o si es divisible entre 400.
   */
  private boolean esBisiesto(int a) {
    return (a % 4 == 0 && a % 100 != 0) || a % 400 == 0;
  }

  /* Metodo que devuelve la cantidad de dias que tiene el mes m del anio a.
   */
  private int diasDelMes(int m, int a) {
    if (m == 2) {
      if (esBisiesto(a)) {
        return 29;
      } else {
        return 28;
      }
    } else if (m == 4 || m == 6 || m == 9 || m == 11) {
      return 30;
    } else {
      return 31;
    }
  }

  /* Metodo que devuelve cuantos dias del anio a ya pasaron antes de que
   * empiece el mes m. Por ejemplo, antes de marzo de un anio no bisiesto
   * han pasado 31 + 28 = 59 dias.
   */
  private int diasAntesDelMes(int m, int a) {
    int dias;
    if (m == 1) {
      dias = 0;
    } else if (m == 2) {
      dias = 31;
    } else if (m == 3) {
      dias = 59;
    } else if (m == 4) {
      dias = 90;
    } else if (m == 5) {
      dias = 120;
    } else if (m == 6) {
      dias = 151;
    } else if (m == 7) {
      dias = 181;
    } else if (m == 8) {
      dias = 212;
    } else if (m == 9) {
      dias = 243;
    } else if (m == 10) {
      dias = 273;
    } else if (m == 11) {
      dias = 304;
    } else {
      dias = 334;
    }
    if (m > 2 && esBisiesto(a)) {    // Febrero de un bisiesto tiene un dia mas
      dias = dias + 1;
    }
    return dias;
  }

  /* Metodo para convertir una fecha en un numero entero que representa los
   * dias transcurridos desde el 1 de enero del anio 1 (ese dia vale 1).
   * Se suman los dias de los anios completos anteriores (365 cada uno mas
   * un dia por cada bisiesto) y los dias transcurridos en el anio actual.
   */
  private int enDias() {
    int a = anio - 1;
    int bisiestos = a / 4 - a / 100 + a / 400;
    return a * 365 + bisiestos + diasTranscurridos();
  }

  /* Metodo para convertir un numero entero, que representa los dias
   * transcurridos desde el 1 de enero del anio 1, en un objeto Fecha.
   * Se usa que el calendario se repite cada 400 anios (146097 dias), cada
   * 100 anios hay 36524 dias, cada 4 anios 1461 dias y cada anio 365.
   */
  private Fecha enFecha(int n) {
    int resto = n - 1;                     // Dias completos ya transcurridos

    int ciclos400 = resto / 146097;
    resto = resto % 146097;

    int ciclos100 = resto / 36524;
    if (ciclos100 == 4) {                  // Ultimo dia de un ciclo de 400 anios
      ciclos100 = 3;
    }
    resto = resto - ciclos100 * 36524;

    int ciclos4 = resto / 1461;
    resto = resto % 1461;

    int anios = resto / 365;
    if (anios == 4) {                      // Ultimo dia de un ciclo de 4 anios
      anios = 3;
    }
    resto = resto - anios * 365;

    int a = ciclos400 * 400 + ciclos100 * 100 + ciclos4 * 4 + anios + 1;
    int diaDelAnio = resto + 1;

                                    // Se busca el mes en el que cae ese dia
    int m = 0;
    do {
      m = m + 1;
    } while (m < 12 && diaDelAnio > diasAntesDelMes(m + 1, a));

    int d = diaDelAnio - diasAntesDelMes(m, a);
    return new Fecha(d, m, a);
  }

  /* ======================= Metodos que operan con fechas ======================= */

  /**
   * Metodo para obtener la diferencia, en dias, entre dos fechas. El
   * resultado siempre es positivo o cero, sin importar cual fecha es mayor.
   * @param f - Fecha contra la que se calculara la diferencia
   * @return int - cantidad de dias entre las dos fechas
   */
  public int diferencia(Fecha f) {
    return Math.abs(enDias() - f.enDias());
  }

  /**
   * Metodo para obtener la fecha que resulta de sumar una cantidad de dias
   * a la fecha actual. La cantidad puede ser negativa para ir hacia atras.
   * Por ejemplo, 3-9-2013 mas 5 da 8-9-2013 y 3-9-2013 mas -2 da 1-9-2013.
   * La fecha actual no se modifica.
   * @param dias - cantidad de dias que se sumaran (puede ser negativa)
   * @return Fecha - nueva fecha con el resultado
   */
  public Fecha sumarDias(int dias) {
    int total = enDias() + dias;
    if (total < 1) {
      System.out.println("No hay fechas antes del 1 de enero del anio 1.");
      return new Fecha(1, 1, 1);
    } else {
      return enFecha(total);
    }
  }

  /**
   * Metodo para comparar dos fechas, devolviendo la relacion de orden
   * entre ellas.
   * @param f - Fecha con la que se comparara el objeto que envia el mensaje
   * @return int - mayor que 0 si esta fecha es posterior a f, menor que 0
   *               si es anterior y 0 si son la misma fecha
   */
  public int comparar(Fecha f) {
    return enDias() - f.enDias();
  }

  /**
   * Metodo para determinar si dos fechas son iguales.
   * @param f - fecha contra la cual se va a comparar
   * @return boolean - true si son iguales y false en otro caso
   */
  public boolean equals(Object f) {
    Fecha otra = (Fecha) f;
    return dia == otra.dia && mes == otra.mes && anio == otra.anio;
  }

  /**
   * Metodo para obtener el numero de un mes a partir de su nombre. No
   * importa si el nombre esta en mayusculas o minusculas.
   * @param nombre - nombre del mes, por ejemplo "Marzo"
   * @return int - numero del mes (1 a 12), o 0 si el nombre no es valido
   */
  public int numeroDeMes(String nombre) {
    String n = nombre.trim().toLowerCase();
    if (n.equals("enero")) {
      return 1;
    } else if (n.equals("febrero")) {
      return 2;
    } else if (n.equals("marzo")) {
      return 3;
    } else if (n.equals("abril")) {
      return 4;
    } else if (n.equals("mayo")) {
      return 5;
    } else if (n.equals("junio")) {
      return 6;
    } else if (n.equals("julio")) {
      return 7;
    } else if (n.equals("agosto")) {
      return 8;
    } else if (n.equals("septiembre") || n.equals("setiembre")) {
      return 9;
    } else if (n.equals("octubre")) {
      return 10;
    } else if (n.equals("noviembre")) {
      return 11;
    } else if (n.equals("diciembre")) {
      return 12;
    } else {
      return 0;
    }
  }

  /**
   * Metodo para obtener el nombre de un mes a partir de su numero.
   * @param m - numero del mes (1 a 12)
   * @return String - nombre del mes en minusculas, o "mes invalido" si el
   *                  numero no esta entre 1 y 12
   */
  public String nombreDeMes(int m) {
    if (m == 1) {
      return "enero";
    } else if (m == 2) {
      return "febrero";
    } else if (m == 3) {
      return "marzo";
    } else if (m == 4) {
      return "abril";
    } else if (m == 5) {
      return "mayo";
    } else if (m == 6) {
      return "junio";
    } else if (m == 7) {
      return "julio";
    } else if (m == 8) {
      return "agosto";
    } else if (m == 9) {
      return "septiembre";
    } else if (m == 10) {
      return "octubre";
    } else if (m == 11) {
      return "noviembre";
    } else if (m == 12) {
      return "diciembre";
    } else {
      return "mes invalido";
    }
  }

  /**
   * Metodo para obtener los dias transcurridos en el anio hasta esta fecha,
   * contando el dia de la fecha. Por ejemplo, el 30 de diciembre de 2013
   * devuelve 364.
   * @return int - numero de dia dentro del anio
   */
  public int diasTranscurridos() {
    return diasAntesDelMes(mes, anio) + dia;
  }

  /**
   * Metodo para convertir una Fecha a cadena con el formato dd/mes/aaaa,
   * donde dd es el dia a dos digitos, mes es el nombre del mes y aaaa es
   * el anio a cuatro digitos. Por ejemplo: 03/septiembre/2013.
   * @return String - la fecha en formato de cadena
   */
  public String toString() {
    String dd = "" + dia;
    if (dia < 10) {
      dd = "0" + dd;
    }
    String aaaa = "" + anio;
    if (anio < 10) {
      aaaa = "000" + aaaa;
    } else if (anio < 100) {
      aaaa = "00" + aaaa;
    } else if (anio < 1000) {
      aaaa = "0" + aaaa;
    }
    return dd + "/" + nombreDeMes(mes) + "/" + aaaa;
  }
}