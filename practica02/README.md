# Práctica 02 - Introducción a Ciencias de la Computación

**Alumno:** Antonio Alva Pacheco  
**Profesor:** Salvador López Mendoza  
**Ayudante de Laboratorio:** Rosa Victoria Villa Padilla  
**Ayudante:** Yanahi Demerio Torres

## 1. Simulación de inversión

### 1.1 Objetivo

El objetivo de esta práctica es que el alumno ejercite la teoría acerca del uso y aplicación de las instrucciones condicionales dentro de un programa, así como de la creación y uso de objetos de clases existentes.

### 1.2 Descripción general

En una institución bancaria se requiere hacer cierto manejo de fechas para determinar, por ejemplo, la fecha final de una inversión de dinero. Por ello el propósito de este problema es escribir una clase para crear y manejar fechas.

### 1.3 Desarrollo

1. Crea el archivo Fecha.java, en el directorio de trabajo para esta práctica.
2. La clase Fecha debe incluir los siguientes métodos:
   - (a) Crear una fecha inicial. Uno sin parámetros, otro que tome tres enteros (día, mes, año); y un tercero con tres datos: dos enteros (día y año) y una cadena para el nombre del mes.
   - (b) Asignar valor a los campos de una fecha.
   - (c) Obtener los campos de una fecha.
   - (d) Obtener la diferencia, en días, entre dos fechas.
   - (e) Dada una fecha inicial y un número entero que representa una cantidad de días, obtener la fecha que corresponde, por ejemplo: con 3-9-2013 y 5, deberá dar 8-9-2013. Con la misma fecha inicial y -2 se debe obtener 1-9-2013.
   - (f) Determinar si dos fechas son iguales.
   - (g) Devolver el número correspondiente a un mes a partir de que reciba una cadena con su nombre.
   - (h) Devolver la cadena correspondiente a un mes a partir de que reciba un número.
   - (i) Dada una fecha, especificar los días transcurridos en el año. Por ejemplo, 30 de diciembre de 2013, debe devolver 364.
   - (j) Representar una fecha en el formato dd/mes/aaaa, donde dd es el día, **mes** es el nombre del mes y aaaa son cuatro dígitos que representan el año.
3. Crea la clase TiempoDeInversion, realiza el método main para que este haga lo siguiente:
   - (a) Dar bienvenida y solicitar el nombre del inversionista.
   - (b) Recabar el nombre del inversionista.
   - (c) Saludar al inversionista y preguntar por el monto a invertir.
   - (d) Recabar monto.
   - (e) Preguntar por una fecha inicio de inversión.
   - (f) Recabar fecha inicio de inversión.
   - (g) Preguntar por una fecha fin de inversión.
   - (h) Recabar fecha fin de inversión.
   - (i) Mostrar al usuario cuántos días sería su inversión, y mostrar su rendimiento al 12%.
   - (j) Preguntar si desea hacer otra simulación, en caso de que responda sí, volver al paso 3(c), en otro caso, salir de la simulación.

