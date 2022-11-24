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
		
		for(int i = 0; i < 100; i++) {
			System.out.println("nuevo movimiento");
			String move = sc.nextLine();
			Helper.move(move);
			if(matriz[Helper.x][Helper.y] == 2){
				System.out.println("El coche cayo por un barranco y haz perdido todas tus vidas. GAME OVER");
				return;
			}
			if(matriz[Helper.x][Helper.y] == 1){
				System.out.println("El coche entro en barro por lo tanto pierdes una vida");
				Helper.vidas--;
				System.out.println("Debera moverse de sitio para salir de aqui");
				i--;
				matriz[Helper.x][Helper.y] = 2;
			}
			int[] cercanos = Helper.mostrarCercanos(Helper.x, Helper.y, matriz);
			for (int j = 0; j < cercanos.length; j++) {
				System.out.print(cercanos[j]);
			}
//			System.out.println("   " + Helper.x + "/" + Helper.y);
		}
		sc.close();
	}

}
