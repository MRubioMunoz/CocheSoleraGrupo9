package com.solera.coche.coche;

public class Helper {
	
	public static int x = 0;
	public static int y = 0;
	public static int vidas = 10;
	
	public static int[][] fillMatriz( int row) {
		int[][] matriz = new int[row][row];
		for(int i = 0; i<row;i++) {
			for(int j = 0; j<row;j++) {
				matriz[i][j] = 0;
			}
		}
		return matriz;
	}
	
	public static int[][] fillObstacles(int[][] matriz) {
		for(int i = 0;i<5;i++) {
			matriz[(int) (Math.random()*8)][(int) (Math.random()*8)] = 1;
			matriz[(int) (Math.random()*8)][(int) (Math.random()*8)] = 2;
		}
		matriz[0][0] = 0;
		return matriz;
	}
	
	public static void move(String w) {
        switch (w) {
            case "w":
                if(x > 0) x--;
                else x = 7;
                break;
            case "s":
                if (x < 7)x++;
                else x = 0;
                break;
            case "d":
                if (y < 7) y++;
                else y = 0;
                break;
            case "a":
                if (y > 0)y--;
                else y = 7;
                break;

            default:
                System.out.println("Mal movimiento");
        }

    }


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
}

