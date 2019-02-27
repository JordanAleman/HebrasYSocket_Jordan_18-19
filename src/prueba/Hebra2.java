package prueba;

public class Hebra2 implements Runnable {
	

	public Hebra2() {
		
	}


	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {
			System.out.println(Thread.currentThread().getName() + " -> " + i);
		}
		
	}

	
public static void main(String[] args) {
		
		int numeroHebras = 50;
		
		for (int i = 1; i < numeroHebras+1; i++) {
			Thread hebra = new Thread(new Hebra2());
			hebra.setName("Hebra " + i);

			hebra.start();
			
		}
		
		System.out.println("Creadas las hebras");
	}



	
} 
