import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ClienteSeguro {
    public static void main(String[] args) {
        // Configurar la confianza en el TrustStore
        System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\User\\OneDrive\\Escritorio\\DAM 2 clases\\PSP\\Java-Service-Processes\\RedSocketsExamples\\SecureRedSocketsESP\\src\\truststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        String host = "localhost";
        int puerto = 12345;
        try {
            SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket ssls = (SSLSocket) ssf.createSocket(host, puerto);

            // Iniciar handshake
            ssls.startHandshake();

            // Obtener los flujos de entrada y salida
            OutputStream os = ssls.getOutputStream();
            InputStream is = ssls.getInputStream();

            // Enviar mensaje al servidor
            String mensaje = "Hola, soy cliente seguro";
            os.write(mensaje.getBytes(StandardCharsets.UTF_8));

            // Leer respuesta del servidor
            byte[] buffer = new byte[1024];
            int leerBytes = is.read(buffer);
            String respuesta = new String(buffer, 0, leerBytes, StandardCharsets.UTF_8);
            System.out.println("Respuesta del servidor: " + respuesta);

            // Cerrar los flujos y socket
            os.close();
            is.close();
            ssls.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
