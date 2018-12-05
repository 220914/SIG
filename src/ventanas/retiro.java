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

public class retiro extends JInternalFrame {

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
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JTextField textdinero;
	public static JTextArea textdescripcion;
	public static JTextField textID;
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					retiro frame = new retiro();
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
	public retiro() {
		setMaximizable(false);
		setIconifiable(true);
		setClosable(true);
		
		setTitle("Retiros");
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertarCantidad = new JLabel("Insertar cantidad:");
		lblInsertarCantidad.setBounds(27, 45, 100, 14);
		contentPane.add(lblInsertarCantidad);
		
		textdinero = new JTextField();
		textdinero.setBounds(122, 42, 86, 20);
		contentPane.add(textdinero);
		textdinero.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n del dep\u00F3sito:");
		lblDescripcin.setBounds(27, 87, 145, 14);
		contentPane.add(lblDescripcin);
		
	 textdescripcion = new JTextArea();
		textdescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textdescripcion.setBounds(57, 112, 331, 34);
		contentPane.add(textdescripcion);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			rellenar();	
			conexiones.ConsultarBD.consultaTotal("retiro");
			dispose();
			}
		});
		btnRegistrar.setBounds(172, 154, 89, 23);
		contentPane.add(btnRegistrar);
		
		JLabel lblTipoDeTransaccin = new JLabel("Retiro de dinero");
		lblTipoDeTransaccin.setBounds(137, 11, 100, 14);
		contentPane.add(lblTipoDeTransaccin);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(261, 45, 12, 14);
		contentPane.add(lblId);
		
		textID = new JTextField();
		textID.setBounds(283, 42, 76, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JButton btnTotalDeRetiros = new JButton("Total de retiros");
		btnTotalDeRetiros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//total();

				int cantidad=0;
					
					try {
						ResultSet rs = conectar().executeQuery("SELECT SUM(cantidad) FROM retiro;");
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
		btnTotalDeRetiros.setBounds(158, 214, 123, 23);
		contentPane.add(btnTotalDeRetiros);
		
	}
	public static void rellenar() {
	InsertarBD.Registraretiro(Integer.parseInt(textID.getText()),Integer.parseInt(textdinero.getText()),textdescripcion.getText());

	
	}
}
