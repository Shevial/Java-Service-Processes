import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BasicoSocketCliente {
    public static void main(String[] args){
        try {
            Socket cliente=new Socket("localhost",1234);
            InputStream is=cliente.getInputStream();
            OutputStream os=cliente.getOutputStream();

            //envia
            String mensaje_enviado="hola, soy cliente";
            os.write(mensaje_enviado.getBytes());

            //lee
            byte[] buffer=new byte[1024];
            int leerBytes = is.read(buffer);
            String mensajeRecibido=new String(buffer,0,leerBytes);
            System.out.println("mensaje del servidor "+mensajeRecibido);

            os.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
