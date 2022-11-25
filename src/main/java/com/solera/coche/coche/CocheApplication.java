package com.solera.coche.coche;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CocheApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(CocheApplication.class, args);
		GameDao service = new GameDao();
		String[] posiciones = new String[4];
		posiciones[0]= "Arriba: ";
		posiciones[1]= "Derecha: ";
		posiciones[2]= "Abajo: ";
		posiciones[3]= "Izquierda: ";

		Scanner sc = new Scanner(System.in);
			
		int turnos = 0;
		
		do {
			System.out.println("nuevo movimiento");
			String move = sc.nextLine();
			service.move(move);
			service.valorarPosicion(service.startMatriz().getMatriz());
			Integer[] cercanos = service.mostrarCercanos(service.startMatriz().getMatriz());
			for (int j = 0; j < cercanos.length; j++) {
				System.out.println(posiciones[j] + cercanos[j]);
			}
			turnos++;

			
		}while(turnos < 100 && !(service.startCoche().getVidas() == 0));
		sc.close();
		System.exit(0);
		
	}

}
