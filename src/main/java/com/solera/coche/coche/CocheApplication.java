package com.solera.coche.coche;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CocheApplication {
	
	

	public static void main(String[] args) {
		//SpringApplication.run(CocheApplication.class, args);

		Scanner sc = new Scanner(System.in);
		
		int[][] matriz = Helper.fillMatriz(8);
		matriz = Helper.fillObstacles(matriz);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
		
		int turnos = 0;
		do {
			System.out.println("nuevo movimiento");
			String move = sc.nextLine();
			Helper.move(move);
			Helper.valorarPosicion(matriz);
			int[] cercanos = Helper.mostrarCercanos(Helper.x, Helper.y, matriz);
			for (int j = 0; j < cercanos.length; j++) {
				System.out.print(cercanos[j]);
			}
//			System.out.println("   " + Helper.x + "/" + Helper.y);
		}while(turnos <100 && Helper.vidas > 0);
		sc.close();
	}

}
