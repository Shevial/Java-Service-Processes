import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Para ejecutar este ejercicio hay que proporcionar un puerto libre y
 * hay que abrir un socket cliente que acepte la comunicación
 */

/**
 * Clase Server socket representa al servidor. Espero la consxión
 */

/**
 * 1. Arranco instancia de serversocket indicando el puerto por el que se va a escuchar
 * 2. Sc espera y acepta conexiones entrantes
 */

public class BasicoSocketServer {
    public static void main (String[] args){
        final int puerto=1234;
        try {
            //creo objeto ss con puerto en desuso por parámetro
            ServerSocket ss = new ServerSocket(puerto);
            System.out.println("Servidor preparado en puerto " + ss.getLocalPort());
            // saco la dirección de socket cliente (sc)
            Socket sc = ss.accept(); // Muy importante esta línea, de aceptar conexiones y esperar clientes que se conecten

            System.out.println("cliente conectado desde " + sc.getInetAddress());
            // mensaje de entrada (enviado por cliente)
            InputStream is = sc.getInputStream();
            // mensaje de salida (enviado por servidor)
            OutputStream os = sc.getOutputStream();

            // array de bytes -> buffer
            byte[] buffer = new byte[1024];
            // numero entero para decirle al buffer que se está leyendo
            int leerBytes = is.read(buffer);
            // cuando yo reciba el mensaje
            String mensaje = new String(buffer,0,leerBytes);
            System.out.println("mensaje del cliente " + mensaje);
            // respuesta
            String respuesta = "soy servidor, mensaje recibido";
            os.write(respuesta.getBytes());
            // cierro comunicación de entrada y comunicación de salida
            is.close();
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
