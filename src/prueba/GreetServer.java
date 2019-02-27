package prueba;

import java.io.*;
import java.net.*;

public class GreetServer {
	private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
 
    public void start(int port) {
        try {
			serverSocket = new ServerSocket(port);
			clientSocket = serverSocket.accept();
	        out = new PrintWriter(clientSocket.getOutputStream(), true);
	        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	        String greeting = in.readLine();
	            if ("hola servidor".equals(greeting)) {
	                out.println("hola cliente");
	            }
	            else {
	                out.println("Bienvenido al sistema");
	            }
	        
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        stop();
    }
 
    public void stop() {
        try {
			in.close();
			out.close();
	        clientSocket.close();
	        serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
    
    
    public static void main(String[] args) {
        GreetServer server=new GreetServer();
        server.start(6669);
       
    }
}
