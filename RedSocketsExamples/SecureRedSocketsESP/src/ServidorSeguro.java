import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * Crear un servidor de socket seguro:
 * Crear almacén de claves jks donde almacenamos nuestra contraseña cifrada en base a los algoritmos por defecto de la clase TrustManagerFactory
 */
public class ServidorSeguro {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, KeyManagementException {
        int puerto=12345;
        SSLContext sslContext = SSLContext.getInstance("TLS"); // declarar que se va a trabajar con conexiones seguras CONTEXTO SSL
        KeyManagerFactory factoria = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()); // crea la factoria de gestion de claves POR DEFECTO
        TrustManagerFactory trust = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm()); // factoria confiable
        char[] pass = "password".toCharArray(); // array de caracteres lo quiero convertir a array de subcaracteres

        //para cifrar la palabra password
        KeyStore keyStore = KeyStore.getInstance("JKS"); // para cifrarla ir a la clase keystore y usar archivo jks (maneja claves privadas)
        FileInputStream keyStoreFile = new FileInputStream("C:\\Users\\User\\OneDrive\\Escritorio\\DAM 2 clases\\PSP\\Java-Service-Processes\\RedSocketsExamples\\SecureRedSocketsESP\\src\\servidor-keystore.jks"); // crear archivo y guardarlo en carpeta
        keyStore.load(keyStoreFile,pass); // cargar en ese archivo la contraseña que he creado  ¿?
        trust.init(keyStore); // iniciar proceso de cifrado, y se almacena en el archivo la clave privada

        sslContext.init(factoria.getKeyManagers(),trust.getTrustManagers(),null);

        SSLServerSocketFactory sslServerSocketFactory=sslContext.getServerSocketFactory();
        SSLServerSocket sslss= (SSLServerSocket) sslServerSocketFactory.createServerSocket(puerto);

        System.out.println("servidor seguro ok");
        SSLSocket sslSocket= (SSLSocket) sslss.accept(); // se aceptan las comunicaciones seguras (el socket cliente debe poner la contraseña)
        System.out.println("Esperando peticiones");






    }

}//cierra class
