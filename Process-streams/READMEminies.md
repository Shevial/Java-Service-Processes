# Resumen Esquemático: Gestión de E/S de Procesos en Java

## Teoría
- **Flujos del Proceso:**  
  - `getOutputStream()`: Envía datos a la entrada del proceso.  
  - `getInputStream()`: Lee la salida estándar del proceso.  
  - `getErrorStream()`: Lee la salida de error del proceso.

- **Clases y Herramientas:**  
  - `ProcessBuilder` y `Runtime` para iniciar procesos externos.  
  - `InputStreamReader` y `BufferedReader` para leer datos (convertir bytes en caracteres).  
  - `BufferedWriter` y `FileWriter` para escribir en ficheros.

- **Redirección de Flujos:**  
  - `Redirect.PIPE` (por defecto), `Redirect.INHERIT`, `Redirect.DISCARD`.  
  - `Redirect.to(File)`, `Redirect.appendTo(File)`, `Redirect.from(File)`.

- **Tuberías:**  
  - `ProcessBuilder.startPipeline` para encadenar procesos (ej: `ps aux | grep root`).

## Ejemplos Prácticos
- **EjemploRedirect0.java:**  
  - Ejecuta `cal 2022` y redirige su salida a `calendario.txt`.

- **EjemploRedirect1.java:**  
  - Ejecuta `cal 2022` y hereda la salida para mostrarla en la consola.

- **EjemploRedirect2.java:**  
  - Escribe una cabecera en `calendario2022.txt` y redirige la salida de `cal 2022` al mismo fichero.

- **cp4.java:**  
  - Crea una tubería manual entre `ps aux` y `grep root`, enviando la salida de uno como entrada del otro.

- **EjemploStreams2.java:**  
  - Captura la salida de `cal 2022` y la volca en `calendario2022.txt` mediante streams.

- **EjemploStreams1.java:**  
  - Lee la salida de `cal 2022` y la muestra línea a línea en la consola.

## Archivo de Salida: calendario.txt
- Contiene el calendario del año 2022 en formato de texto plano.  
- Funciones:  
  - Visualización del calendario.  
  - Ejemplo práctico de redirección de la salida de un proceso a un fichero.  
  - Fuente de datos para posteriores análisis o conversiones.
