package com.solera.coche.coche;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	private GameDao service;
	
	public Controller(GameDao service) {
		this.service = service;
	}
	
	@GetMapping("/start")
	public Matriz getMatriz() {
		return service.startMatriz();
	}
	
	@GetMapping("/game")
	public Coche getCoche() {
		return service.startCoche();
	}
	
	

}
