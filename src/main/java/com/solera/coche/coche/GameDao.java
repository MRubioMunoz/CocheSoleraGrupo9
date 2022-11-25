package com.solera.coche.coche;

import org.springframework.stereotype.Component;

@Component
public class GameDao {
	
	protected static Matriz matriz = new Matriz();
	protected static Coche coche = new Coche(0,0);
	

	
	public Matriz startMatriz() {
		return matriz;
	}
	
	public Coche startCoche() {
		return coche;
	}
	
	public int[] move(String w) {
        int[] array = new int[2];
        switch (w) {
            case "w":
                if(coche.getX() > 0) coche.setX(coche.getX()-1);
                else coche.setX(7);
                array[0] = coche.getX();
                array[1] = coche.getY();
                return array;
            case "s":
                if (coche.getX() < 7)coche.setX(coche.getX()+1);
                else coche.setX(0);
                array[0] = coche.getX();
                array[1] = coche.getY();
                return array;
            case "d":
                if (coche.getY() < 7) coche.setY(coche.getY() +1);
                else coche.setY(0);
                array[0] = coche.getX();
                array[1] = coche.getY();
                return array;
            case "a":
                if (coche.getY() > 0)coche.setY(coche.getY() -1);
                else coche.setY(7); 
                array[0] = coche.getX();
                array[1] = coche.getY();
                return array;

            default:
                return array;

        }

    }
	
	public int valorarPosicion(Integer[][] matriz) {
    	if(matriz[coche.getX()][coche.getY()] == 2){
			System.out.println("El coche cayo por un barranco y haz perdido todas tus vidas. GAME OVER");
			coche.setVidas(0);
		}
		if(matriz[coche.getX()][coche.getY()] == 1){
			coche.setVidas(coche.getVidas() - 1);
			System.out.println("El coche entro en barro por lo tanto pierdes una vida. Te quedan: " + coche.getVidas());			
			System.out.println("Debera moverse de sitio para salir de aqui");
			//i--; 
			matriz[coche.getX()][coche.getY()] = 2;
		}
		return coche.getVidas();
    }
	
	public Integer[] mostrarCercanos(Integer[][] matriz){
		Integer[] array = new Integer[4];

        if (coche.getX() > 0) array[0] = matriz[coche.getX() - 1][coche.getY()];
        else array[0] = matriz[7][coche.getY()];

        if(coche.getX() < 7) array[2] = matriz[coche.getX() + 1][coche.getY()];
        else array[2] = matriz[0][coche.getY()];

        if (coche.getY() > 0) array[3] = matriz[coche.getX()][coche.getY() - 1];
        else array[3] = matriz[coche.getX()][7];

        if(coche.getY() < 7) array[1] = matriz[coche.getX()][coche.getY() + 1];
        else array[1] = matriz[coche.getX()][0];

        return array;
    }
}
