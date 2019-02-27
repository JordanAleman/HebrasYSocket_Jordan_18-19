package prueba;

import java.io.*;
import java.net.*;

public class EchoServer {
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
			 
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
			if (".".equals(inputLine)) {
			    out.println("good bye");
			    break;
			 }
			 out.println(inputLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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