package com.conversor;

import java.util.Map;

import javax.swing.JOptionPane;

public class OperacionesDeConversion {
	
	RespuestaApi api;
	
	public double ObtenerDecimal() {
		while (true) {
            String input = JOptionPane.showInputDialog(null, "Ingrese el valor a convertir:", "Input", JOptionPane.QUESTION_MESSAGE);
            try {
            	if(input == null) {
            		Finalizar();
            	}else {
            		double numero = Double.parseDouble(input);
                    return numero;
            	}
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Sólo se aceptan números.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
	}
	public String[] ObtenerMoneda(int posicion, double input) {
		String[] partes;
		partes = new String[] {};
		var valores = Map.of(1, "PEN-AUD",2, "PEN-EUR",3, "PER-GBP", 4, "PEN-JPY", 5, "PEN-KRW",
				6, "AUD-PEN",7, "EUR-PEN",8, "GBP-PEN",9, "JPY-PEN",10, "KRW-PEN");
		for (Map.Entry<Integer, String> entry : valores.entrySet()) {
            if(posicion == entry.getKey()) {
            	String cadena = entry.getValue();
            	partes = cadena.split("-");	
            }
		}
		return partes ;
	}
	
	public void Finalizar() {
		JOptionPane.showMessageDialog(null, "Programa finalizado", "Información", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	
	public void asignarOperaciones(RespuestaApi api) {
		this.api = api;
	}
}
