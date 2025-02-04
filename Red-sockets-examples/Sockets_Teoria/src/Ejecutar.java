import java.io.IOException;

public class Ejecutar {
    public static void main(String[] args) throws IOException {


        Servidor servidor=new Servidor();
        System.out.println("iniciando servidor");
        servidor.startServer();


    }
}
