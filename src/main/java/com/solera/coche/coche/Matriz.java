package com.solera.coche.coche;

public class Matriz {
	
	private Integer[][] matriz;
	
	

	public Matriz() {
		this.matriz = fillObstacles(fillMatriz(8));
	}

	public Integer[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(Integer[][] matriz) {
		this.matriz = matriz;
	}
	
	public static Integer[][] fillMatriz(Integer row) {
		Integer[][] matriz = new Integer[row][row];
		for(int i = 0; i<row;i++) {
			for(int j = 0; j<row;j++) {
				matriz[i][j] = 0;
			}
		}
		return matriz;
	}
	
	public static Integer[][] fillObstacles(Integer[][] matriz) {
        for (int i = 0; i < 5; i++) {
            matriz[(int) (Math.random()*8)][(int) (Math.random()*8)] = 2;
        }
        for(int i = 0;i<10;i++) {
            matriz[(int) (Math.random()*8)][(int) (Math.random()*8)] = 1;
        }
		matriz[0][0] = 0;
		return matriz;
	}
	
	

}
