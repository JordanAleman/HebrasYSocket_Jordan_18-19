package otroSocket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorMultiple extends Conexion { // Se hereda de conexi�n para hacer uso de los sockets y dem�s

	public ServidorMultiple() throws IOException { // Se usa el constructor para servidor de Conexion
		super("servidor", 12345);
	} 

	public void startServer() { // M�todo para iniciar el servidor
		try {
			System.out.println("Esperando..."); // Esperando conexi�n

			// System.out.println("Fin de la conexi�n");

			while (true) {
				new EchoClientHandler(serverSocket.accept()).start();; // Accept comienza el socket y espera una conexi�n desde un cliente
			}
			
//			serverSocket.close();// Se finaliza la conexi�n con el cliente
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static class EchoClientHandler extends Thread {
		
		protected Socket clientSocket; //Socket del cliente
	    protected DataOutputStream salidaCliente; //Flujo de datos de salida
	    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
	    
	    public EchoClientHandler(Socket socket) {
			this.clientSocket = socket;
		}
	    
		public void run() {
			try {
				System.out.println("Cliente en l�nea");

				// Se obtiene el flujo de salida del cliente para enviarle mensajes
				salidaCliente = new DataOutputStream(clientSocket.getOutputStream());


				// Se le env�a un mensaje al cliente usando su flujo de salida
				salidaCliente.writeUTF("Petici�n recibida y aceptada.\nEscriba \"exit\" para salir");

				// Se obtiene el flujo entrante desde el cliente
				BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				while ((mensajeServidor = entrada.readLine()) != null) { // Mientras haya mensajes desde el cliente
					// Se muestra por pantalla el mensaje recibido
					if("exit".equals(mensajeServidor)) {
						salidaCliente.writeUTF("Fin de la conexion");
						System.out.println("Fin de la conexion");
						break;
					}
					System.out.println(mensajeServidor);
				}
				
				entrada.close();
				salidaCliente.close();
				clientSocket.close();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			

		}
	}
}