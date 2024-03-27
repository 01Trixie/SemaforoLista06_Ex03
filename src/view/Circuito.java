package view;

import java.util.concurrent.Semaphore;

import controller.CircuitoController;

public class Circuito {

	public static void main(String[] args) {
		
		int permissao = 5;
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int idAtleta = 0; idAtleta < 25; idAtleta++) {
			Thread tCorre = new CircuitoController(idAtleta, semaforo);
			tCorre.start();
		}
	}

}
