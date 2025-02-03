import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class BasicoSocketServer {
    public static void main (String[] args){
        final int puerto=1234;
        try {
            ServerSocket ss=new ServerSocket(puerto);
            System.out.println("Servidor preparado en puerto "+ss.getLocalPort());
            Socket sc=ss.accept();
            System.out.println("cliente conectado desde "+sc.getInetAddress());
            InputStream is=sc.getInputStream();
            OutputStream os=sc.getOutputStream();

            byte[] buffer=new byte[1024];
            int leerBytes = is.read(buffer);
            String mensaje=new String(buffer,0,leerBytes);
            System.out.println("mensaje del cliente "+mensaje);
            String respuesta="soy servidor, mensaje recibido";
            os.write(respuesta.getBytes());
            is.close();
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
