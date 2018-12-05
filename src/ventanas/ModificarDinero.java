package ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import conexiones.ModificarBD;

public class ModificarDinero extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel txtdescripcion;
	public static JTextField textdinero;
	public static JTextArea txtdesc;
	public static JTextField textid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarDinero frame = new ModificarDinero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModificarDinero() {
		setBounds(100, 100, 450, 300);
		setTitle("Modificar Dinero extra");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		
		setBounds(100, 100, 450, 300);
		txtdescripcion = new JPanel();
		txtdescripcion.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(txtdescripcion);
		txtdescripcion.setLayout(null);
		
		JLabel lblInsertarCantidad = new JLabel("Insertar cantidad:");
		lblInsertarCantidad.setBounds(27, 45, 100, 14);
		txtdescripcion.add(lblInsertarCantidad);
		
		textdinero = new JTextField();
		textdinero.setBounds(137, 42, 86, 20);
		txtdescripcion.add(textdinero);
		textdinero.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n del dep\u00F3sito:");
		lblDescripcin.setBounds(27, 87, 145, 14);
		txtdescripcion.add(lblDescripcin);
		
		JButton btnRegistrar = new JButton("Actualizar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
				dispose();
				conexiones.ConsultarBD.consultaTotal("Dineroextra");
			}
		});
		btnRegistrar.setBounds(149, 199, 89, 23);
		txtdescripcion.add(btnRegistrar);
		
		txtdesc = new JTextArea();
		txtdesc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtdesc.setBounds(27, 130, 331, 58);
		txtdescripcion.add(txtdesc);
		
		textid = new JTextField();
		textid.setColumns(10);
		textid.setBounds(286, 39, 76, 20);
		txtdescripcion.add(textid);
		
		JLabel label = new JLabel("id");
		label.setBounds(264, 42, 22, 14);
		txtdescripcion.add(label);
	
	}
	public static void modificar() {
	ModificarBD.registrarDineroextra(Integer.parseInt(textid.getText()),Integer.parseInt(textdinero.getText()),txtdesc.getText());
	
	}
	public static void rellenardineroextra(String id,String  dinero, String descripcion) {
		textid.setText(id);
		textdinero.setText(dinero);
		txtdesc.setText(descripcion);
		
	
}	
}
