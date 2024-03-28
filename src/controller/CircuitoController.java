package controller;

import java.util.concurrent.Semaphore;

public class CircuitoController extends Thread implements Comparable <CircuitoController>{
	public int idAtleta;
	private Semaphore semaforo;
	public static int posChegada;
	public int pontos = 0;
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
			int nota = (int)((Math.random()*11));
			pontos += nota;
			tiroteio += 1;
			System.out.println("#" + idAtleta + " deu seu "+ tiroteio + "° tiro e tirou nota " + nota);
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
		System.out.println("#" + idAtleta + " foi o " + posChegada + "° a chegar e recebeu " + 	(260 - (posChegada * 10)));
		pontos += 260 - (posChegada * 10);
	}

	public int compareTo(CircuitoController o) {
		return pontos > o.pontos?-1:1;
	}
	
}
