package com.solera.coche.coche;

import org.springframework.web.bind.annotation.GetMapping;

@Deprecated
public class Helper {
	
	
	public static int x = 0;
	public static int y = 0;
	public static int vidas = 10;

	public static int[][] fillMatriz(int row) {
		int[][] matriz = new int[row][row];
		for(int i = 0; i<row;i++) {
			for(int j = 0; j<row;j++) {
				matriz[i][j] = 0;
			}
		}
		return matriz;
	}
	
	public static int[][] fillObstacles(int[][] matriz) {
        for (int i = 0; i < 5; i++) {
            matriz[(int) (Math.random()*8)][(int) (Math.random()*8)] = 2;
        }
        for(int i = 0;i<10;i++) {
            matriz[(int) (Math.random()*8)][(int) (Math.random()*8)] = 1;
        }
		matriz[0][0] = 0;
		return matriz;
	}

    //Modificar para que sea GET
	public static int[] move(String w) {
        int[] array = new int[2];
        switch (w) {
            case "w":
                if(x > 0) x--;
                else x = 7;
                array[0] = x;
                array[1] = y;
                return array;
            case "s":
                if (x < 7)x++;
                else x = 0;
                array[0] = x;
                array[1] = y;
                return array;
            case "d":
                if (y < 7) y++;
                else y = 0;
                array[0] = x;
                array[1] = y;
                return array;
            case "a":
                if (y > 0)y--;
                else y = 7;
                array[0] = x;
                array[1] = y;
                return array;

            default:
                return array;

        }

    }

    //Modificar para que sea GET
    public static int[] mostrarCercanos(int num1, int num2, int[][] matriz){
        int[] array = new int[4];

        if (num1 > 0) array[0] = matriz[num1 - 1][num2];
        else array[0] = matriz[7][num2];

        if(num1 < 7) array[2] = matriz[num1 + 1][num2];
        else array[2] = matriz[0][num2];

        if (num2 > 0) array[3] = matriz[num1][num2 - 1];
        else array[3] = matriz[num1][7];

        if(num2 < 7) array[1] = matriz[num1][num2 + 1];
        else array[1] = matriz[num1][0];

        return array;
    }
    
    // Get de las vidas
    public static int valorarPosicion(int[][] matriz) {
    	if(matriz[x][y] == 2){
			System.out.println("El coche cayo por un barranco y haz perdido todas tus vidas. GAME OVER");
			vidas = 0;
		}
		if(matriz[x][y] == 1){
			--Helper.vidas;
			System.out.println("El coche entro en barro por lo tanto pierdes una vida. Te quedan: " + vidas);			
			System.out.println("Debera moverse de sitio para salir de aqui");
			//i--; 
			matriz[x][y] = 2;
		}
		return vidas;
    }
}

