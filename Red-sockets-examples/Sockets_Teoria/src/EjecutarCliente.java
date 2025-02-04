import java.io.IOException;

public class EjecutarCliente {


    public static void main(String[] args) throws IOException {
        Cliente cliente = new Cliente();
        System.out.println("iniciando cliente");
        cliente.startClient();
    }

}
