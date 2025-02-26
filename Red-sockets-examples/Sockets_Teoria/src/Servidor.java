import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Servidor extends Conexion {

    public Servidor() throws IOException {
        super("servidor");

    }
    public void startServer() throws IOException {
        System.out.println("Servidor arrancado y listo");
        cs=ss.accept();
        System.out.println("cliente conectado");
        salidaC=new DataOutputStream(cs.getOutputStream());
        salidaC.writeUTF("petición recibida");
        BufferedReader br=new BufferedReader(new InputStreamReader(cs.getInputStream()));
        while((mensajeServidor=br.readLine())! = null){
            System.out.println(mensajeServidor);
        }
        System.out.println("Fin de la conexión");
        ss.close();
    }

}//cierra clase
