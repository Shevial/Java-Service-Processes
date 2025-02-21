# Explicación del uso de procesos en Java

## ¿Por qué Java no tiene una clase propia para un "Proceso"?

Java no tiene una clase propia para representar un proceso de forma directa debido a su diseño orientado a la portabilidad y la compatibilidad entre sistemas operativos. En lugar de crear una clase específica para representar un "proceso", Java ofrece mecanismos que permiten a los desarrolladores interactuar con los procesos a través de una abstracción del sistema operativo subyacente. Esto se logra utilizando las clases `ProcessBuilder` y `Runtime`.

### Razones por las que Java no tiene una clase propia para un proceso:

- **Abstracción y compatibilidad entre sistemas operativos**: Java es multiplataforma, lo que significa que el código debe ejecutarse sin modificaciones en diferentes sistemas operativos. Cada SO maneja los procesos de forma distinta, por lo que una única clase para procesos podría complicar la interoperabilidad. En cambio, `ProcessBuilder` y `Runtime` proporcionan una interfaz uniforme.

- **Gestión indirecta de procesos**: Java no gestiona directamente los procesos del sistema operativo. En lugar de interactuar con ellos a través de una clase dedicada, ofrece objetos que representan procesos en ejecución (`Process`).

- **Simplicidad**: Al no tener una clase específica, Java mantiene una interfaz sencilla y flexible para la ejecución de procesos sin necesidad de comprender detalles internos del sistema operativo.

---

## Las dos maneras de crear un proceso en Java

### 1. Usando `ProcessBuilder`:

`ProcessBuilder` permite crear y configurar un proceso antes de iniciarlo. Es útil cuando se necesita un control más detallado sobre la ejecución, como redirigir la entrada/salida o definir el directorio de trabajo.

### 2. Usando `Runtime`:

`Runtime` ejecuta procesos de forma más directa mediante `exec()`. Es más simple que `ProcessBuilder`, pero tiene menos flexibilidad y control sobre el proceso.

### Diferencias:
- `ProcessBuilder` ofrece mayor personalización y control sobre la ejecución.
- `Runtime` es más sencillo y útil cuando no se requieren configuraciones avanzadas.

---

## Explicación de los archivos

### 1. `Lanzador1.java`

**Descripción**: Este archivo muestra el uso básico de `ProcessBuilder` para lanzar un proceso.

**Paso a paso**:
- Se crea una instancia de `ProcessBuilder` con el comando que se desea ejecutar.
- Se inicia el proceso con `start()`.

**Resumen**:
- Este ejemplo ilustra la manera más simple de usar `ProcessBuilder` para ejecutar comandos externos. Permite lanzar procesos.

---

### 2. `Lanzador2.java`

**Descripción**: Aquí se amplía el uso de `ProcessBuilder` permitiendo redirigir la salida del proceso.

**Paso a paso**:
- Se crea el objeto `ProcessBuilder` con el comando a ejecutar.
- Se configura la redirección de la salida del proceso para que se escriba en la consola o en un archivo.
- Se ejecuta el proceso con `start()`.

**Resumen**:
- Este ejemplo muestra cómo redirigir la salida de un proceso, lo que es útil cuando se necesita capturar su salida en un archivo o en la consola.

---

### 3. `Lanzador3.java`

**Descripción**: En este ejemplo se introduce la captura de la salida del proceso usando `InputStream`.

**Paso a paso**:
- Se instancia `ProcessBuilder` con el comando deseado.
- Se inicia el proceso y se obtiene su `InputStream`.
- Se lee la salida del proceso línea por línea.
- Se espera a que el proceso finalice con isAlive que devuelve si el proceso sigue vivo o no.
- Si el proceso sigue vivo, esperaremos un milisegundo, y mostraremos un mensaje.

**Resumen**:
- Este método permite capturar la salida del proceso en tiempo real, útil para leer resultados generados por el comando sin necesidad de redireccionar a un archivo.

---
### 4. `Lanzador4.java`

**Descripción**
En este ejemplo se demuestra cómo iniciar un proceso externo desde Java utilizando `ProcessBuilder` y obtener información detallada del mismo mediante `ProcessHandle.Info`.

**Paso a paso**:
1. Se crea un array `app[]` con el comando y los argumentos necesarios para lanzar una aplicación externa.
2. Se instancia un `ProcessBuilder` con el array de comandos.
3. Se inicia el proceso con `pb.start()`, lo que devuelve un objeto `Process`.
4. Se obtiene información del proceso con `ProcessHandle.Info`, incluyendo:
   - **PID (Process ID)** del proceso.
   - **Comando ejecutado**.
   - **Línea de comando completa**.
   - **Hora de inicio del proceso**.
   - **Usuario que ejecuta el proceso**.
5. Se imprimen los detalles del proceso en la consola.

**Resumen**:
- Este programa permite ejecutar aplicaciones externas desde Java y obtener información relevante del proceso en ejecución.
- Es útil para la monitorización y gestión de procesos iniciados desde un programa Java.

**Ejemplo**:
Si se ejecuta en un sistema con **Firefox instalado**, abrirá la URL especificada en el código:
```shell
PID: 12345
Comando: /usr/bin/firefox
Línea de comando: firefox https://docs.oracle.com/en/java/javase/17/core/process-api1.html
Hora de inicio: 2024-02-20T12:34:56.789Z
Usuario: usuarioEjemplo
```


---

### 5. `EjemploRuntime.java`

**Descripción**: Este archivo muestra cómo ejecutar un proceso usando `Runtime`.

**Paso a paso**:
- Se obtiene una instancia de `Runtime` mediante `getRuntime()`.
- Se ejecuta el comando con `exec()`.
- Se espera la finalización con `waitFor()`.
- Se puede capturar la salida del proceso si es necesario.

**Resumen**:
- `Runtime.exec()` es un método directo y fácil de usar para ejecutar comandos sin configuraciones avanzadas. Sin embargo, su flexibilidad es menor comparada con `ProcessBuilder`.

---

## ¿Cómo ejecutar estos archivos?

Para compilar y ejecutar los ejemplos, sigue estos pasos en la terminal:

1. **Compilar un archivo**:
   ```sh
   javac Lanzador1.java
   ```
2. **Ejecutar el archivo compilado**:
   ```sh
   java Lanzador1
   ```

Para ejecutar los otros archivos, reemplaza `Lanzador1` con el nombre del archivo correspondiente.

---

## Conclusión

- `ProcessBuilder` es más flexible y ofrece mayor control sobre la ejecución de procesos externos.
- `Runtime.exec()` es útil para ejecuciones rápidas sin necesidad de configuraciones avanzadas.
- Redirigir la entrada/salida y capturar la salida del proceso es clave en muchos escenarios.

Estos ejemplos ilustran cómo Java maneja los procesos sin necesidad de una clase específica para representarlos, proporcionando abstracciones eficientes a través de `ProcessBuilder` y `Runtime`.

