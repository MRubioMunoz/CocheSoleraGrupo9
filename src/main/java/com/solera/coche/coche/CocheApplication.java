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
		
		int[][] matrizObstaculos = Helper.fillMatriz(8);
		
		for(int i = 0; i < 100; i++) {
			System.out.println("nuevo movimiento");
			String move = sc.nextLine();
			Helper.move( move);
			int[] cercanos = Helper.mostrarCercanos(Helper.x, Helper.y, matriz);
			for (int j = 0; j < cercanos.length; j++) {
				System.out.print(cercanos[j]);
			}
			System.out.println("   " + Helper.x + "/" + Helper.y);
		}
		sc.close();
	}

}
