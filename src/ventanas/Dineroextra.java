package ventanas;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexiones.InsertarBD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.event.ActionEvent;


public class Dineroextra extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JTextField textdinero;
	public static JTextArea textdescripcion;
	public static JTextField textID;

	public static Connection conexion=null;
	public static Statement s = null;

	public static Statement conectar(){
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			// Se obtiene una conexión con la base de datos.
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/imprenta?useSSL=false", Principal.usuario, Principal.contraseña);
			// Se crea un Statement, para realizar el query
			s = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return s;
	}
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dineroextra frame = new Dineroextra();
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
	public Dineroextra() {
		
		setMaximizable(false);
		setIconifiable(true);
		setClosable(true);
		
		setTitle("Dinero extra");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertarCantidad = new JLabel("Insertar cantidad:");
		lblInsertarCantidad.setBounds(27, 45, 100, 14);
		contentPane.add(lblInsertarCantidad);
		
		textdinero = new JTextField();
		textdinero.setBounds(137, 42, 86, 20);
		contentPane.add(textdinero);
		textdinero.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n del dep\u00F3sito:");
		lblDescripcin.setBounds(27, 87, 145, 14);
		contentPane.add(lblDescripcin);
		
	 textdescripcion = new JTextArea();
		textdescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textdescripcion.setBounds(50, 112, 331, 34);
		contentPane.add(textdescripcion);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			rellenar();	
			conexiones.ConsultarBD.consultaTotal("Dineroextra");
			dispose();
			}
		});
		btnRegistrar.setBounds(165, 157, 89, 23);
		contentPane.add(btnRegistrar);
		
		JLabel lblTipoDeTransaccin = new JLabel("Ingreso de dinero");
		lblTipoDeTransaccin.setBounds(137, 11, 100, 14);
		contentPane.add(lblTipoDeTransaccin);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(261, 45, 22, 14);
		contentPane.add(lblId);
		
		textID = new JTextField();
		textID.setBounds(283, 42, 76, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JButton btnMostrarTotalDe = new JButton("Mostrar total de dinero ingresado");
		btnMostrarTotalDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//total();
				
				int cantidad=0;
					
					try {
						ResultSet rs = conectar().executeQuery("SELECT SUM(cantidad) FROM dineroextra;");
						//Datos=rs.getString("SUM(cantidad)");
						while (rs.next()) {
							cantidad =rs.getInt(1);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, cantidad);
					
				
			}
		});
		btnMostrarTotalDe.setBounds(87, 215, 249, 23);
		contentPane.add(btnMostrarTotalDe);
		
	}
	
	
	public static void rellenar() {
	InsertarBD.RegistrarDineroExtra(Integer.parseInt(textID.getText()),Integer.parseInt(textdinero.getText()),textdescripcion.getText());
	}
}
