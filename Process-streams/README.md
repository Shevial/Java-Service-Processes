# Gestión de la Entrada y Salida de Procesos en Java

Este repositorio contiene ejemplos prácticos que ilustran cómo gestionar la entrada y salida de procesos en Java mediante el uso de `ProcessBuilder`, `Runtime` y las clases asociadas a los streams (como `InputStreamReader`, `BufferedReader` y `BufferedWriter`). Además, se incluye un ejemplo de archivo de salida generado, que en este caso es un calendario del año 2022.

---

## Teoría

Cuando se crean procesos externos mediante `ProcessBuilder` o `Runtime.exec`, estos procesos no tienen un terminal (tty) asociado. Para interactuar con ellos, se gestionan sus flujos de datos a través de la clase `Process`, la cual provee tres métodos esenciales:

- **`getOutputStream()`**: Permite enviar datos a la entrada estándar del proceso.
- **`getInputStream()`**: Permite leer los datos que el proceso envía a su salida estándar.
- **`getErrorStream()`**: Permite leer los datos que el proceso envía a su salida de error.

**Gestión de Streams:**

- **InputStreamReader**: Recubre un `InputStream` y convierte los bytes en caracteres, teniendo en cuenta la codificación (por ejemplo, UTF-8 o Windows-1252).
- **BufferedReader**: Recubre un `InputStreamReader` y ofrece métodos para leer líneas de texto de forma sencilla.
- **BufferedWriter**: Permite escribir caracteres en un fichero de forma eficiente, generalmente en combinación con `FileWriter`.

**Redirección con ProcessBuilder:**

La clase `ProcessBuilder` ofrece una forma sencilla de redirigir la entrada y salida de un proceso mediante:
- **`Redirect.PIPE`**: Conecta la E/S del subproceso al proceso Java actual (comportamiento por defecto).
- **`Redirect.INHERIT`**: Permite que el subproceso utilice los mismos flujos de E/S que el proceso padre.
- **`Redirect.DISCARD`**: Descarta la salida del subproceso.
- **`Redirect.to(File)`**: Redirige la salida hacia un fichero (sobrescribiendo su contenido).
- **`Redirect.appendTo(File)`**: Redirige la salida para que se añada al final de un fichero.
- **`Redirect.from(File)`**: Redirige la entrada del proceso desde un fichero.

Además, la API de `ProcessBuilder` permite crear tuberías entre procesos con el método `startPipeline`, de forma similar a como se haría en una terminal (por ejemplo, `ps aux | grep root`).

---

## Archivos de Ejemplo

### 1. EjemploRedirect0.java
**Descripción:**  
Este ejemplo muestra cómo redirigir la salida de un proceso a un fichero utilizando `ProcessBuilder.Redirect.to`.

**Funcionamiento:**  
- Se ejecuta el comando `cal 2022`.
- La salida del proceso se redirige a un fichero llamado `calendario.txt`.
- Este ejemplo es útil para generar un fichero de salida directamente desde la ejecución de un comando.

---

### 2. EjemploRedirect1.java
**Descripción:**  
Demuestra cómo redirigir la salida del proceso para que se herede la salida del proceso actual.

**Funcionamiento:**  
- Se ejecuta el comando `cal 2022`.
- Se utiliza `ProcessBuilder.Redirect.INHERIT`, lo que hace que la salida se imprima directamente en la consola del proceso padre, en lugar de ser capturada o redirigida a un fichero.

---

### 3. EjemploRedirect2.java
**Descripción:**  
Combina la escritura manual en un fichero con la redirección de la salida del proceso.

**Funcionamiento:**  
- Se crea el fichero `calendario2022.txt` y se escribe una cabecera utilizando `BufferedWriter`.
- Posteriormente, se redirige la salida del comando `cal 2022` hacia el mismo fichero, permitiendo sobrescribir o ampliar el contenido.

---

### 4. cp4.java
**Descripción:**  
Ejemplo de cómo crear una tubería entre dos procesos de forma manual.

**Funcionamiento:**  
- Se ejecuta `ps aux` para listar los procesos del sistema.
- Se ejecuta `grep root` para filtrar las líneas que contienen la palabra "root".
- La salida del primer proceso se lee mediante un `BufferedReader` y se escribe en la entrada del segundo proceso a través de un `BufferedWriter`.
- Finalmente, se muestra en la consola la salida filtrada por `grep root`.

---

### 5. EjemploStreams2.java
**Descripción:**  
Demuestra cómo capturar la salida de un proceso y volcarla en un fichero utilizando streams.

**Funcionamiento:**  
- Se ejecuta el comando `cal 2022`.
- Se captura la salida del proceso mediante un `BufferedReader`.
- La salida se escribe en un fichero (`calendario2022.txt`) usando un `BufferedWriter`, junto con una cabecera.

---

### 6. EjemploStreams1.java
**Descripción:**  
Ejemplo sencillo de cómo capturar y mostrar la salida de un proceso en la consola.

**Funcionamiento:**  
- Se ejecuta el comando `cal 2022`.
- La salida del proceso se lee línea a línea mediante un `BufferedReader` y se imprime directamente en la consola.

---

## Archivo de Salida: calendario.txt

**Descripción:**  
El archivo `calendario.txt` contiene el calendario del año 2022, generado al ejecutar el comando `cal 2022` a través de alguno de los ejemplos (por ejemplo, en `EjemploRedirect0.java`). Este archivo es una representación en texto plano del calendario, con la cabecera:

------------- Calendario del año 2022 -----------------

y luego el calendario formateado, que incluye:
- Los nombres de los meses (por ejemplo, "De gener", "De febrer", etc.).
- Los días organizados en columnas correspondientes a los días de la semana.

**Utilidad:**  
- **Visualización:** Proporciona una vista rápida del calendario en formato de texto.
- **Práctica de redirección:** Sirve como ejemplo de cómo redirigir la salida de un proceso a un fichero.
- **Entrada para procesamiento:** Puede utilizarse como fuente de datos para aplicaciones que necesiten analizar o transformar calendarios en texto, como convertirlo a otros formatos (CSV, JSON) o para realizar búsquedas específicas dentro del contenido.

---

## Conclusión

Estos ejemplos muestran diversas técnicas para gestionar la entrada y salida de procesos en Java, desde la redirección de flujos a ficheros o a la consola, hasta la creación manual de tuberías entre procesos. Además, el archivo `calendario.txt` generado es un ejemplo práctico de cómo se puede utilizar la salida de un comando del sistema para producir un recurso que puede ser procesado o visualizado posteriormente.

Este conjunto de ejemplos es fundamental para entender la interacción entre procesos externos y una aplicación Java, y proporciona una base sólida para la integración de procesos y el manejo de datos en tiempo real.

---

