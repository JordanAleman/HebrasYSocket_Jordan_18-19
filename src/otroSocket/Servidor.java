package otroSocket;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Servidor extends Conexion { // Se hereda de conexión para hacer uso de los sockets y demás

	public Servidor() throws IOException { // Se usa el constructor para servidor de Conexion
		super("servidor", 12345);
	} 

	public void startServer() { // Método para iniciar el servidor
		try {
			System.out.println("Esperando..."); // Esperando conexión

			

			//System.out.println("Fin de la conexión");

			while (true) {
				clientSocket = serverSocket.accept(); // Accept comienza el socket y espera una conexión desde un cliente
				System.out.println("Cliente en línea");
				
				// Se obtiene el flujo de salida del cliente para enviarle mensajes
				salidaCliente = new DataOutputStream(clientSocket.getOutputStream());
				
				// Se le envía un mensaje al cliente usando su flujo de salida
				salidaCliente.writeUTF("Petición recibida y aceptada");
				
				// Se obtiene el flujo entrante desde el cliente
				BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				while ((mensajeServidor = entrada.readLine()) != null) {// Mientras haya mensajes desde el cliente
					// Se muestra por pantalla el mensaje recibido
					System.out.println(mensajeServidor);
				}
				serverSocket.close();// Se finaliza la conexión con el cliente
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}