package com.solera.coche.coche;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CocheApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(CocheApplication.class, args);
		GameDao service = new GameDao();

		Scanner sc = new Scanner(System.in);
			
		int turnos = 0;
		do {
			System.out.println("nuevo movimiento");
			String move = sc.nextLine();
			service.move(move);
			service.valorarPosicion(service.startMatriz().getMatriz());
			int[] cercanos = service.mostrarCercanos(service.startMatriz().getMatriz());
			for (int j = 0; j < cercanos.length; j++) {
				System.out.print(cercanos[j]);
			}
			
		}while(turnos <100 && service.startCoche().getVidas() > 0);
		sc.close();
	}

}
