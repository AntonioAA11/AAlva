# Práctica 01 - Introducción a Ciencias de la Computación

**Alumno:** Antonio Alva Pacheco
**Profesor:** Salvador López Mendoza
**Ayudante de Laboratorio:** Rosa Victoria Villa Padilla
** Ayudante:** Yanahi Demerio Torres

## 1. Psicólogo

### Objetivo
Familiarizarse con la creación y uso de objetos de la clase `String`, utilizando algunos de sus métodos en la elaboración de un programa.

### Descripción
Programa que simula una sesión con un psicólogo usando cadenas de caracteres.

### Desarrollo
a. Da la bienvenida y solicita el nombre del paciente.
b. Recaba el nombre del paciente.
c. Saluda al paciente y pregunta cuál es su problema.
d. Lee, en una línea, la descripción del problema.
e. Contesta "MMMM... ya veo", luego "Y digame..." y pregunta "Por qué dice" incluyendo la respuesta anterior entre comillas.
f. Lee la respuesta del paciente.
g. Se despide diciendo que hablarán de ello con más detalle en la siguiente sesión.

## 2. RFC

### Descripción
Programa que genera una clave al estilo del RFC a partir del nombre completo y la fecha de nacimiento. La clave se forma con las dos primeras letras del apellido paterno, la inicial del materno, la inicial del nombre y la fecha en formato aammdd.

### Desarrollo
a. Solicita el nombre completo, en una línea.
b. Solicita la fecha de nacimiento en formato dd/mm/aa.
c. Recaba los datos.
d. Extrae la inicial del nombre.
e. Extrae las dos primeras letras del apellido paterno.
f. Extrae la inicial del apellido materno.
g. Forma el RFC con las letras obtenidas.
h. Separa la fecha en año, mes y día y los agrega al RFC.


## Cómo compilar y ejecutar

Desde la carpeta `practica01/src`:

    javac icc/Psicologo.java
    java icc.Psicologo

    javac icc/RFC.java
    java icc.RFC