import javax.net.ssl.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * Crear un servidor de socket seguro:
 * Crear almacén de claves jks donde almacenamos nuestra contraseña cifrada en base a los algoritmos por defecto de la clase TrustManagerFactory
 */
public class ServidorSeguro {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, KeyManagementException, UnrecoverableKeyException {
        int puerto = 12345;
        SSLContext sslContext = SSLContext.getInstance("TLS"); // declarar que se va a trabajar con conexiones seguras CONTEXTO SSL
        KeyManagerFactory factoria = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()); // crea la factoria de gestion de claves POR DEFECTO
        TrustManagerFactory trust = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm()); // factoria confiable
        char[] pass = "password".toCharArray(); // array de caracteres lo quiero convertir a array de subcaracteres

        //para cifrar la palabra password
        KeyStore keyStore = KeyStore.getInstance("JKS"); // para cifrarla ir a la clase keystore y usar archivo jks (maneja claves privadas)
        FileInputStream keyStoreFile = new FileInputStream("C:\\Users\\User\\OneDrive\\Escritorio\\DAM 2 clases\\PSP\\Java-Service-Processes\\RedSocketsExamples\\SecureRedSocketsESP\\src\\servidor2-keystore.jks"); // crear archivo y guardarlo en carpeta
        keyStore.load(keyStoreFile,pass); // cargar en ese archivo la contraseña que he creado  ¿?

        factoria.init(keyStore, pass); // inicializar KeyManagerFactory con KeyStore y contraseña
        trust.init(keyStore); // iniciar proceso de cifrado, y se almacena en el archivo la clave privada

        sslContext.init(factoria.getKeyManagers(),trust.getTrustManagers(),null);

        SSLServerSocketFactory sslServerSocketFactory=sslContext.getServerSocketFactory();
        SSLServerSocket sslss = (SSLServerSocket) sslServerSocketFactory.createServerSocket(puerto);

        System.out.println("servidor seguro ok");
        SSLSocket sslSocket = (SSLSocket) sslss.accept(); // se aceptan las comunicaciones seguras (el socket cliente debe poner la contraseña)
        System.out.println("Esperando peticiones");

        //probando v v v v v v
        // Ejemplo de manejo de comunicaciones (lectura y escritura)
        InputStream is = sslSocket.getInputStream();
        OutputStream os = sslSocket.getOutputStream();
        byte[] buffer = new byte[1024];
        int leerBytes = is.read(buffer);
        String mensaje = new String(buffer, 0, leerBytes, StandardCharsets.UTF_8);
        System.out.println("Mensaje del cliente: " + mensaje);
        String respuesta = "Hola, soy el servidor seguro";
        os.write(respuesta.getBytes(StandardCharsets.UTF_8));
        // Cerrar los flujos y socket
        is.close();
        os.close();
        sslSocket.close();
        sslss.close();
    }

}
