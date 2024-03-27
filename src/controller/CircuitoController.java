package controller;

import java.util.concurrent.Semaphore;

public class CircuitoController extends Thread {
	private int idAtleta;
	private Semaphore semaforo;
	private static int posChegada;
	private int pontos = 260;
	public CircuitoController(int idAtleta, Semaphore semaforo) {
		this.idAtleta = idAtleta;
		this.semaforo = semaforo;
		
	}
	public void run() {
		corrida();
		try {
			semaforo.acquire();
			tiroAlvo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		ciclismo();
	}
	private void corrida() {
		int distanciaTotal = 3000;
		int distanciaPercorrida = 0;
		int deslocamento = (int) ((Math.random() * 21) + 10);
		int tempo = 1000;
		while (distanciaPercorrida < distanciaTotal) { 
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("# " + idAtleta + " ja CORREU " + distanciaPercorrida + "m");
		}
		System.out.println("# " + idAtleta + " foi para o tiro ao alvo.");		
	}
	private void tiroAlvo() {
		System.out.println("#" + idAtleta + " pegou sua arma.");
		int tempo = (int) ((Math.random() * 301) + 5000);
		int tiroteio = 0;
		while(tiroteio < 3) {
			tiroteio += 1;
			System.out.println("#" + idAtleta + " deu seu "+ tiroteio + "° tiro.");
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("#" + idAtleta + " pegou a bicicleta.");
	}
	private void ciclismo() {
		int distanciaTotal = 5000;
		int distanciaPercorrida = 0;
		int deslocamento = (int) ((Math.random() * 30) + 40);
		int tempo = 1000;
		while (distanciaPercorrida < distanciaTotal) { 
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("# " + idAtleta + " ja PERCOREU " + distanciaPercorrida + "m");
		}
		posChegada++;
		System.out.println("#" + idAtleta + " foi o " + posChegada + "° a chegar e recebeu " + 	(pontos = pontos - (posChegada * 10)));

	}
	
}
