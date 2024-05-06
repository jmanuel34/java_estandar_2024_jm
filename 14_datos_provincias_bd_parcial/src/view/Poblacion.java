package view;

import service.ComunidadesService;

public class Poblacion {

	public static void main(String[] args) {
		var comService = new ComunidadesService();
		System.out.println("Poblacion de Madrid "+comService.poblacionTotalProvincia("Ourense"));
	}

}
