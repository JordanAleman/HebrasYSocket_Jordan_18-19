package otroSocket;

import java.io.IOException;

//Clase principal que hará uso del cliente
public class MainCliente {
	
    public static void main(String[] args) throws IOException
    {
        Cliente cli2 = new Cliente(); //Se crea el cliente

        System.out.println("Iniciando cliente\n");
        cli2.startClient(); //Se inicia el cliente

    }
}
