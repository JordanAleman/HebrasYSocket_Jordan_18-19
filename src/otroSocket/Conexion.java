package otroSocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
    //private final int PUERTO = 12345; //Puerto para la conexión
    private final String HOST = "localhost"; //Host para la conexión
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket serverSocket; //Socket del servidor
    protected Socket clientSocket; //Socket del cliente
    protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida

    public Conexion(String tipo, int puerto) throws IOException //Constructor
    {
        if(tipo.equalsIgnoreCase("servidor"))
        {
            serverSocket = new ServerSocket(puerto);//Se crea el socket para el servidor en puerto 1234
            clientSocket = new Socket(); //Socket para el cliente
        }
        else
        {
        	clientSocket = new Socket(HOST, puerto); //Socket para el cliente en localhost en puerto 1234
        }
    }
}