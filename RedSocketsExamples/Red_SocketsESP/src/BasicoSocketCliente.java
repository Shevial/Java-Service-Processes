import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Clase socket representa al cliente
 */

/**
 * Cliente crea instancia de clase Socket que indica la direccion y el puerto.
 * Usa flujos de input y output Stream para comunicar datos
 * Una vez lanzadas las comunicaciones se encargan de enviar los mensajes que son arrays de bytes que se transforman a string para ponerlos por consola.
 */

public class BasicoSocketCliente {
    public static void main(String[] args){
        try {
            // se crea el socket de cliente que apunta al puerto del servidor
            Socket cliente = new Socket("localhost",1234);
            // el cliente abra su mensaje de entrada y mensaje de salida
            InputStream is = cliente.getInputStream();
            OutputStream os = cliente.getOutputStream();

            //envía
            String mensaje_enviado="hola, soy cliente";
            os.write(mensaje_enviado.getBytes()); //envío de información

            //lee:
            byte[] buffer=new byte[1024]; //prepara array de bytes para leer el mensaje que llegara del servidor
            int leerBytes = is.read(buffer); // está preparado para leerlo
            String mensajeRecibido = new String(buffer,0,leerBytes); // recibe el mensaje en un string
            System.out.println("mensaje del servidor " + mensajeRecibido);

            os.close(); //cierro canal de salida

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
