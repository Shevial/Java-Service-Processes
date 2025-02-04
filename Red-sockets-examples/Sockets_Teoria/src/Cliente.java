import java.io.DataOutputStream;
import java.io.IOException;

public class Cliente extends Conexion {
    public Cliente() throws IOException {
        super("cliente");
    }

    public void startClient() throws IOException {
        salidaS=new DataOutputStream(cs.getOutputStream());
        for(int i=0;i<3;i++){
            salidaS.writeUTF("mensaje "+i+"\n");
        }
        cs.close();
    }
}//cierra clase
