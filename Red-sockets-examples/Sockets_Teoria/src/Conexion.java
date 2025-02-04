import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
    private final int PUERTO=1236;
    private final String HOST="localhost";
    protected String mensajeServidor;
    protected ServerSocket ss;
    protected Socket cs;
    protected DataOutputStream salidaS, salidaC;//flujo de comunicación

    public Conexion(String tipo) throws IOException {
        if(tipo.equalsIgnoreCase("servidor")){
            ss=new ServerSocket(PUERTO);
            cs=new Socket();
        }
        else{
            cs=new Socket(HOST, PUERTO);
        }
    }}//cierra clase
