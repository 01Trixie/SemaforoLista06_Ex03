package view;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

import controller.CircuitoController;

public class Circuito {

	public static void main(String[] args) {
		CircuitoController vetor [] = new CircuitoController[25];
		int permissao = 5;
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int idAtleta = 0; idAtleta < 25; idAtleta++) {
			vetor[idAtleta] = new CircuitoController(idAtleta, semaforo);
			vetor[idAtleta].start();
		}
		while(CircuitoController.posChegada < 25) {
			System.out.print("");
		}
		Arrays.sort(vetor);
		for(int i = 0; i < 25; i++) {
			System.out.println( "O atleta # " + vetor[i].idAtleta + " fez " + vetor[i].pontos);
		}
	}

}
