package control;

import prueba.Hebra;

public class Control {

public static void main(String[] args) {
		
		int numeroHebras = 50;
		
		for (int i = 1; i < numeroHebras+1; i++) {
			Hebra hebra = new Hebra("Hebra " + i);

			hebra.start();
			
		}
		
		System.out.println("Creadas las hebras");
	}

}
