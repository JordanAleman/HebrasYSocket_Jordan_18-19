package otroSocket;

import java.io.DataOutputStream;
import java.io.IOException;

public class Cliente extends Conexion
{
    public Cliente() throws IOException { //Se usa el constructor para cliente de Conexion
    	super("cliente", 12345);
    } 

    public void startClient() //Método para iniciar el cliente
    {
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(clientSocket.getOutputStream());

            //Se enviarán dos mensajes
            for (int i = 0; i < 2; i++)
            {
                //Se escribe en el servidor usando su flujo de datos
                salidaServidor.writeUTF("Este es el mensaje numero " + (i+1) + "\n");
            }
            
            

            clientSocket.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
