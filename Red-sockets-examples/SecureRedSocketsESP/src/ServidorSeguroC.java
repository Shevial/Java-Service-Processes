import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class ServidorSeguro {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, KeyManagementException {
        int puerto=12345;
        SSLContext sslContext=SSLContext.getInstance("TLS");
        KeyManagerFactory factoria=KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        TrustManagerFactory trust =TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        char[] pass="password".toCharArray();
        KeyStore keyStore=KeyStore.getInstance("JKS");
        FileInputStream keyStoreFile=new FileInputStream("C:/Users/Tecnicos/Desktop/n/servidor-keystore.jks");
        keyStore.load(keyStoreFile,pass);
        trust.init(keyStore);

        sslContext.init(factoria.getKeyManagers(),trust.getTrustManagers(),null);

        SSLServerSocketFactory sslServerSocketFactory=sslContext.getServerSocketFactory();
        SSLServerSocket sslss= (SSLServerSocket) sslServerSocketFactory.createServerSocket(puerto);

        System.out.println("servidor seguro ok");
        SSLSocket sslSocket= (SSLSocket) sslss.accept();
        System.out.println("Esperando peticiones");

    }

}//cierra class
