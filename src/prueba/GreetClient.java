package prueba;

import java.io.*;
import java.net.*;

public class GreetClient {
	private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
 
    public void startConnection(String ip, int port) {
        try {
			clientSocket = new Socket(ip, port);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
 
    public String sendMessage(String msg) {
        try {
			out.println(msg);
			String resp = in.readLine();
			return resp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }
 
    public void stopConnection() {
        try {
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args) {
    	GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1", 6669);
        String response = client.sendMessage("hola servidor");
        System.out.println("Servidor respuesta: " + response);
    }
}
