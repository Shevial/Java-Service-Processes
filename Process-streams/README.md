# Gestión de la Entrada y Salida de Procesos en Java

Este repositorio contiene ejemplos prácticos que ilustran cómo gestionar la entrada y salida de procesos en Java mediante el uso de `ProcessBuilder`, `Runtime` y las clases asociadas a los streams (como `InputStreamReader`, `BufferedReader` y `BufferedWriter`). A continuación, se explica la teoría y se detalla el funcionamiento de cada archivo de ejemplo.

---

## Teoría

Los procesos creados con `ProcessBuilder` o `Runtime.exec` no tienen un terminal (tty) asociado, por lo que se deben gestionar sus flujos de datos manualmente. La clase `Process` ofrece tres métodos clave para trabajar con estos flujos:

- **`getOutputStream()`**: Permite enviar datos a la entrada estándar del proceso.
- **`getInputStream()`**: Permite leer los datos que el proceso envía a su salida estándar.
- **`getErrorStream()`**: Permite leer los datos que el proceso envía a su salida de error.

Para transformar los bytes en caracteres y facilitar la lectura, se utiliza `InputStreamReader` en combinación con `BufferedReader`, que ofrece métodos para leer línea a línea. De igual forma, se puede usar `BufferedWriter` junto con `FileWriter` para escribir en ficheros.

La clase `ProcessBuilder` facilita la redirección de estos flujos mediante sus métodos de redirección:
- **`Redirect.PIPE`**: Conecta la E/S del subproceso al proceso Java actual (comportamiento por defecto).
- **`Redirect.INHERIT`**: Permite que el subproceso utilice los mismos flujos de E/S que el proceso padre.
- **`Redirect.DISCARD`**: Descarta la salida del subproceso.
- **`Redirect.to(File)`**: Redirige la salida hacia un fichero, sobrescribiendo su contenido.
- **`Redirect.appendTo(File)`**: Redirige la salida hacia un fichero, agregando al final del contenido existente.
- **`Redirect.from(File)`**: Redirige la entrada desde un fichero.

Además, el método `startPipeline` de `ProcessBuilder` permite encadenar procesos de forma que la salida de uno se conecte a la entrada del siguiente, similar al uso de tuberías en la terminal (por ejemplo, `ps aux | grep root`).

---

## Archivos de Ejemplo

### 1. EjemploRedirect0.java
**Descripción**:  
Este ejemplo muestra cómo redirigir la salida de un proceso a un fichero utilizando `ProcessBuilder.Redirect.to`.

**Funcionamiento**:  
- Se ejecuta el comando `cal 2022`.
- La salida se redirige a un fichero llamado `calendario.txt`.

---

### 2. EjemploRedirect1.java
**Descripción**:  
Demuestra cómo redirigir la salida del proceso para que se herede la salida del proceso actual.

**Funcionamiento**:  
- Se ejecuta el comando `cal 2022`.
- Se utiliza `ProcessBuilder.Redirect.INHERIT`, haciendo que la salida se imprima directamente en la consola del proceso padre.

---

### 3. EjemploRedirect2.java
**Descripción**:  
Combina la escritura manual en un fichero con la redirección de la salida del proceso.

**Funcionamiento**:  
- Se crea el fichero `calendario2022.txt` y se escribe una cabecera mediante `BufferedWriter`.
- Luego, se redirige la salida del comando `cal 2022` a ese fichero (con opción de sobrescribir o ampliar el contenido).

---

### 4. cp4.java
**Descripción**:  
Ejemplo de cómo crear una tubería entre dos procesos de forma manual.

**Funcionamiento**:  
- Se ejecuta `ps aux` para listar los procesos del sistema.
- Se ejecuta `grep root` para filtrar las líneas que contienen la palabra "root".
- La salida del primer proceso se envía a la entrada del segundo mediante un `BufferedWriter`, y luego se muestra la salida filtrada en la consola.

---

### 5. EjemploStreams2.java
**Descripción**:  
Demuestra cómo capturar la salida de un proceso y volcarla en un fichero utilizando streams.

**Funcionamiento**:  
- Se ejecuta el comando `cal 2022`.
- Se lee la salida del proceso mediante un `BufferedReader`.
- La salida se escribe en un fichero (`calendario2022.txt`) usando `BufferedWriter`.

---

### 6. EjemploStreams1.java
**Descripción**:  
Ejemplo sencillo de cómo capturar y mostrar la salida de un proceso en la consola.

**Funcionamiento**:  
- Se ejecuta el comando `cal 2022`.
- La salida del proceso se lee línea a línea y se imprime en la consola mediante un `BufferedReader`.

---

## Conclusión

Estos ejemplos ilustran diversas técnicas para gestionar la entrada y salida de procesos en Java, desde la redirección de flujos a ficheros o la consola, hasta la creación de tuberías entre procesos. Los conceptos y ejemplos presentados son fundamentales para entender cómo interactuar con procesos externos y manipular sus datos de manera eficiente en aplicaciones Java.

