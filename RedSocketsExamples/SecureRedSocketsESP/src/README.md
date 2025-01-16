# Proyecto de Comunicación Servidor Seguro en Java

Este proyecto demuestra cómo configurar un servidor que maneja conexiones seguras utilizando sockets SSL/TLS en Java.

## Requisitos

- Java Development Kit (JDK) instalado.
- Un entorno de desarrollo como IntelliJ IDEA, Eclipse, o NetBeans.
- Certificados y claves en un archivo JKS (Java KeyStore).

## Estructura del Proyecto

El proyecto contiene un archivo principal:

- `ServidorSeguro.java`

## Conceptos Clave

### Socket
Un socket es un punto final para la comunicación bidireccional entre dos máquinas a través de una red. Se utiliza para enviar y recibir datos entre aplicaciones que se ejecutan en diferentes dispositivos.

### Protocolo
Los sockets generalmente utilizan el protocolo TCP (Transmission Control Protocol) para establecer conexiones fiables y seguras entre el cliente y el servidor.

### JKS (Java KeyStore)
Un JKS es un archivo que almacena claves criptográficas y certificados utilizados para establecer conexiones seguras en aplicaciones Java. Se utiliza para gestionar claves privadas, públicas y certificados de confianza.

## Instrucciones de Configuración

### Pasos para Configurar un Socket Servidor Seguro en Java

1. **Importar Clases Necesarias:**
   - Importa las clases `javax.net.ssl.*`, `java.io.*`, y `java.security.*`.

2. **Crear SSLContext:**
   - Obtén una instancia de `SSLContext` especificando el protocolo (por ejemplo, TLS).

3. **Configurar KeyManagerFactory y TrustManagerFactory:**
   - Crea instancias de `KeyManagerFactory` y `TrustManagerFactory` utilizando los algoritmos por defecto.

4. **Establecer Contraseña:**
   - Define la contraseña en un array de caracteres (por ejemplo, `password`).

5. **Configurar KeyStore:**
   - Obtén una instancia de `KeyStore` especificando el tipo (por ejemplo, JKS). Carga el archivo de KeyStore desde el sistema de archivos.

6. **Inicializar KeyManagerFactory y TrustManagerFactory:**
   - Inicializa `KeyManagerFactory` y `TrustManagerFactory` con el `KeyStore` cargado.

7. **Inicializar SSLContext:**
   - Inicializa `SSLContext` con los gestores de claves (KeyManagers) y de confianza (TrustManagers).

8. **Crear SSLServerSocketFactory y SSLServerSocket:**
   - Obtén la fábrica de sockets seguros (`SSLServerSocketFactory`) del `SSLContext`. Crea un `SSLServerSocket` especificando el puerto.

9. **Esperar y Aceptar Conexiones Seguras:**
   - Utiliza el método `accept` del `SSLServerSocket` para esperar y aceptar conexiones seguras de clientes.

10. **Confirmar Conexión Segura:**
    - Imprime mensajes de confirmación en consola para verificar que el servidor está operativo y aceptando peticiones.

11. **Manejar Comunicaciones:**
    - Utiliza los flujos de entrada y salida para leer y responder a los mensajes del cliente.

12. **Cerrar Flujos y Socket:**
    - Cierra los flujos de entrada, salida y el `SSLSocket` una vez finalizada la comunicación.

## Funciones del Archivo

### `ServidorSeguro.java`
**Descripción:** El servidor seguro utiliza SSL/TLS para manejar conexiones seguras. Configura el `SSLContext` con el `KeyManagerFactory` y `TrustManagerFactory` utilizando el `KeyStore`. Utiliza un `SSLServerSocket` para aceptar conexiones seguras de los clientes y manejar las comunicaciones.

**Elementos Imprescindibles:**
- Configurar e inicializar el `SSLContext`.
- Configurar el `KeyStore`, `KeyManagerFactory`, y `TrustManagerFactory`.
- Crear y configurar el `SSLServerSocket`.
- Aceptar conexiones seguras.
- Manejar los flujos de entrada y salida.
- Cerrar los flujos y el `SSLServerSocket` para liberar recursos.

## Ejecución del Proyecto

1. **Ejecutar el Servidor Seguro:**
   - Compila y ejecuta `ServidorSeguro.java`. El servidor empezará a escuchar en el puerto especificado y esperará conexiones entrantes.
