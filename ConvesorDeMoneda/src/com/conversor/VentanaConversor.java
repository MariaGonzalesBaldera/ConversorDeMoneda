package com.conversor;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JButton;
public class VentanaConversor extends JFrame implements ActionListener {

	private JPanel contentPane;
	JComboBox<String> cboOpciones;
	OperacionesDeConversion misConversiones;
	RespuestaApi api;
	
	JButton btnSalir;
	JLabel lblRespuesta;
	JLabel lblRespuesta2;

	/**
	 * Create the frame.
	 */
	public VentanaConversor() {
		setTitle("Conversor ONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione la opción a convertir");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(44, 55, 333, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Convesor De Monedas");
		lblNewLabel.setBounds(10, 11, 414, 20);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		String[] valores = {"Seleccione una opción","Soles a Dólares", "Soles a Euros", "Soles a Libras Esterlinas", "Soles a Yen Japonés", "Soles a Won sur-coreano", "Dólares a Soles", "Euros a Soles", "Libras Esterlinas a Soles", "Yen Japonés a Soles", "Won sul-coreano a Soles"};
		cboOpciones = new JComboBox<>(valores);
		cboOpciones.setBackground(Color.WHITE);
		cboOpciones.setSelectedIndex(0);
		cboOpciones.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		cboOpciones.setBounds(114, 86, 202, 31);
		cboOpciones.addActionListener(this);
		contentPane.add(cboOpciones);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		btnSalir.setBounds(300, 213, 89, 23);
		btnSalir.addActionListener(this);
		contentPane.add(btnSalir);
		
		lblRespuesta = new JLabel("");
		lblRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespuesta.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblRespuesta.setBounds(44, 137, 333, 20);
		contentPane.add(lblRespuesta);
		
		lblRespuesta2 = new JLabel("");
		lblRespuesta2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespuesta2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblRespuesta2.setBounds(44, 162, 333, 20);
		contentPane.add(lblRespuesta2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(cboOpciones== e.getSource() ) {
			if(cboOpciones.getSelectedIndex()==0) {
				return;
			}
			lblRespuesta2.setText("Cargando ...");
			double input = misConversiones.ObtenerDecimal() ;
			invocarSeleccion(cboOpciones.getSelectedIndex(),input,cboOpciones.getSelectedItem());
			
		}
		if(btnSalir== e.getSource()) {
			misConversiones.Finalizar();
		}
	}
	
	private void invocarSeleccion(int posicion, double input, Object texto) {
		String[] partes = misConversiones.ObtenerMoneda(posicion, input);
		String salida = api.llamada(partes[0],partes[1],input);
    	String[] nuevaPalabra = salida.split(" ");
    	String palabraExtraida=nuevaPalabra[1];
    	lblRespuesta.setText("La conversión de "+texto+" es :");
    	lblRespuesta2.setText(palabraExtraida.replace(",", ""));
	}

	public void asignarOperaciones(OperacionesDeConversion misConversiones) {
		this.misConversiones = misConversiones;
	}

	public void asignarOperaciones(RespuestaApi api) {
		this.api = api;
	}
}
