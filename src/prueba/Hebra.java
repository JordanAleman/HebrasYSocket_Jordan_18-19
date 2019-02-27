package prueba;

public class Hebra extends Thread {
	
	public Hebra() {
		
	}
	
	public Hebra(String nombre) {
		super(nombre);
	}
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
			}
			System.out.println(this.getName() + " -> " + i);
		}
	}
	
public static void main(String[] args) {
		
		int numeroHebras = 50;
		
		for (int i = 1; i < numeroHebras+1; i++) {
			Hebra hebra = new Hebra("Hebra " + i);

			hebra.start();
			
		}
		
		System.out.println("Creadas las hebras");
	}

}
