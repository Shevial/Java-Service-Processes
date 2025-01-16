# Proyecto de Comunicación Cliente-Servidor Básico en Java

Este proyecto demuestra cómo configurar una comunicación básica entre un cliente y un servidor utilizando sockets en Java.

## Requisitos

- Java Development Kit (JDK) instalado.
- Un entorno de desarrollo como IntelliJ IDEA, Eclipse, o NetBeans.

## Estructura del Proyecto

El proyecto contiene dos archivos principales:

- `BasicoSocketCliente.java`
- `BasicoSocketServer.java`

## Conceptos Clave

### Socket
Un socket es un punto final para la comunicación bidireccional entre dos máquinas a través de una red. Se utiliza para enviar y recibir datos entre aplicaciones que se ejecutan en diferentes dispositivos.

### Protocolo
Los sockets generalmente utilizan el protocolo TCP (Transmission Control Protocol) para establecer conexiones fiables y seguras entre el cliente y el servidor.

### JKS (Java KeyStore)
Un JKS es un archivo que almacena claves criptográficas y certificados utilizados para establecer conexiones seguras en aplicaciones Java. Se utiliza para gestionar claves privadas, públicas y certificados de confianza.

## Instrucciones de Configuración

### Pasos para Configurar un Socket Cliente en Java

1. **Importar Clases Necesarias**
   - Asegúrate de importar las clases `java.io` y `java.net`.

2. **Crear una Instancia de Socket**
   - En el método `main`, crea un objeto `Socket`, especificando la dirección del servidor (por ejemplo, `"localhost"`) y el puerto (por ejemplo, `1234`).

3. **Obtener Flujos de Entrada y Salida**
   - Obtén los flujos de entrada (`InputStream`) y salida (`OutputStream`) del socket para manejar la comunicación.

4. **Enviar Mensaje**
   - Convierte la cadena de texto que deseas enviar en un array de bytes y utiliza el flujo de salida para enviar los datos.

5. **Recibir Mensaje**
   - Prepara un buffer de bytes para recibir el mensaje. Lee los datos del flujo de entrada y convierte el buffer en una cadena de texto para mostrar el mensaje.

6. **Cerrar Flujo de Salida**
   - Una vez finalizada la comunicación, cierra el flujo de salida para liberar recursos.

7. **Manejo de Excepciones**
   - Utiliza un bloque `try-catch` para manejar posibles excepciones y asegurar que el programa funcione de manera robusta.

### Pasos para Configurar un Socket Servidor en Java

1. **Importar Clases Necesarias**
   - Importa las clases `java.io` y `java.net`.

2. **Crear una Instancia de ServerSocket**
   - En el método `main`, crea un objeto `ServerSocket` especificando un puerto libre (por ejemplo, `1234`).

3. **Esperar y Aceptar Conexiones Entrantes**
   - Utiliza el método `accept` del `ServerSocket` para esperar y aceptar conexiones de clientes.

4. **Obtener Flujos de Entrada y Salida**
   - Obtén los flujos de entrada (`InputStream`) y salida (`OutputStream`) del socket cliente para manejar la comunicación.

5. **Leer Mensaje del Cliente**
   - Prepara un buffer de bytes para recibir el mensaje del cliente. Lee los datos del flujo de entrada y convierte el buffer en una cadena de texto para mostrar el mensaje.

6. **Enviar Respuesta al Cliente**
   - Convierte la respuesta del servidor en un array de bytes y utiliza el flujo de salida para enviar los datos al cliente.

7. **Cerrar Flujos de Entrada y Salida**
   - Una vez finalizada la comunicación, cierra los flujos de entrada y salida para liberar recursos.

8. **Manejo de Excepciones**
   - Utiliza un bloque `try-catch` para manejar posibles excepciones y asegurar que el programa funcione de manera robusta.

## Funciones de los Archivos

### BasicoSocketCliente.java

**Descripción:**
- El cliente crea una instancia de la clase `Socket`, especificando la dirección del servidor y el puerto de conexión.
- Usa flujos de entrada y salida (`InputStream` y `OutputStream`) para comunicar datos.
- Envía mensajes que se convierten de arrays de bytes a cadenas de texto y se muestran en la consola.

**Elementos Imprescindibles:**
- Crear la instancia del `Socket`.
- Obtener y manejar los flujos de entrada y salida.
- Enviar y recibir mensajes.
- Cerrar los flujos de salida para liberar recursos.

### BasicoSocketServer.java

**Descripción:**
- El servidor crea una instancia de `ServerSocket`, especificando un puerto para escuchar las conexiones entrantes.
- Utiliza el método `accept()` para aceptar conexiones de los clientes.
- Maneja los flujos de entrada y salida para leer y responder a los mensajes del cliente.

**Elementos Imprescindibles:**
- Crear la instancia de `ServerSocket`.
- Esperar y aceptar conexiones de los clientes.
- Obtener y manejar los flujos de entrada y salida.
- Leer y responder a los mensajes del cliente.
- Cerrar los flujos de entrada y salida para liberar recursos.

## Ejecución del Proyecto

1. **Ejecutar el Servidor:**
   - Compila y ejecuta `BasicoSocketServer.java`. El servidor empezará a escuchar en el puerto especificado y esperará conexiones entrantes.

2. **Ejecutar el Cliente:**
   - Compila y ejecuta `BasicoSocketCliente.java`. El cliente se conectará al servidor, enviará un mensaje y esperará la respuesta del servidor.
