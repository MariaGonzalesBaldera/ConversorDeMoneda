package com.conversor;

public class Aplicacion {
	OperacionesDeConversion misConversiones;
	RespuestaApi api;
	
	public Aplicacion() {
		misConversiones = new OperacionesDeConversion();
		api = new RespuestaApi(); 
		presentarVentana();
	}

	public void presentarVentana() {
		VentanaConversor miVentana = new VentanaConversor();
		miVentana.setVisible(true);
		miVentana.asignarOperaciones(misConversiones);
		miVentana.asignarOperaciones(api);
	}
}
