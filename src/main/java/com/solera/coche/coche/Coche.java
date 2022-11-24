package com.solera.coche.coche;

import org.springframework.stereotype.Component;

@Component
public class Coche {
	
	private Integer x;
	private Integer y;
	private Integer vidas;
	private Integer[][] matriz;
	
	public Coche() {
		x = 0;
		y = 0;
		vidas = 10;
		matriz = Matriz.fillMatriz(8);
	}
	
	public Coche(Integer x, Integer y) {
		this.x = x;
		this.y = y;
		this.vidas = 10;
		this.matriz = Matriz.fillMatriz(8);
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Integer getVidas() {
		return vidas;
	}
	public void setVidas(Integer vidas) {
		this.vidas = vidas;
	}
	
}
