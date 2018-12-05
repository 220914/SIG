package ventanas;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;


import conexiones.ModificarBD;


public class ModificarProveedores extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField textno_serie;
	public static JTextField textNombreP;
	public static JTextField textNmbreMat;
	public static JTextField txtCantidad;
	public static JTextField txtPrecio;
	public static JTextField textid;
	public static JDateChooser fecha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarProveedores frame = new ModificarProveedores();
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
	public ModificarProveedores() {
		setBounds(100, 100, 450, 300);
		setTitle("Actualizar registros");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);


		JButton btnAgregar = new JButton("actualizar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*InsertarBD.registrarcliente(Integer.parseInt(textid.getName()),textNombre.getText(), 
						textPrecioT.getText(),textImporte.getText(),textDescripcion.getText(),
						dateChooser.getDateFormatString());*/

				/*ModificarBD.rellenarcliente(Integer.parseInt(textid.getName()),textNombre.getText(),textDescripcion.getText() ,
						textPrecioT.getText(),textImporte.getText(),
						dateChooser.getDateFormatString());*/
			}	
		});
		btnAgregar.setBounds(447, 7, 79, 23);
		getContentPane().add(btnAgregar);

		textno_serie = new JTextField();
		textno_serie.setColumns(10);
		textno_serie.setBounds(127, 11, 86, 20);
		getContentPane().add(textno_serie);

		JLabel label = new JLabel("No. serie");
		label.setBounds(35, 20, 49, 14);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("Nombre:");
		label_1.setBounds(35, 45, 49, 14);
		getContentPane().add(label_1);

		textNombreP = new JTextField();
		textNombreP.setColumns(10);
		textNombreP.setBounds(127, 42, 266, 20);
		getContentPane().add(textNombreP);

		JLabel label_2 = new JLabel("Material:");
		label_2.setBounds(35, 70, 49, 14);
		getContentPane().add(label_2);

		textNmbreMat = new JTextField();
		textNmbreMat.setColumns(10);
		textNmbreMat.setBounds(127, 67, 193, 20);
		getContentPane().add(textNmbreMat);

		JLabel label_3 = new JLabel("Cantidad que se compro:");
		label_3.setBounds(38, 110, 125, 14);
		getContentPane().add(label_3);

		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(167, 107, 86, 20);
		getContentPane().add(txtCantidad);

		txtPrecio = new JTextField();
		txtPrecio.setText("");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(82, 148, 72, 20);
		getContentPane().add(txtPrecio);

		JLabel label_4 = new JLabel("Precio:");
		label_4.setBounds(38, 151, 38, 14);
		getContentPane().add(label_4);

		fecha = new JDateChooser();
		fecha.setBounds(284, 147, 96, 20);
		getContentPane().add(fecha);

		JLabel label_5 = new JLabel("Fecha:");
		label_5.setBounds(238, 151, 46, 14);
		getContentPane().add(label_5);

		JButton button = new JButton("actualizar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
				conexiones.ConsultarBD.consultaTotal("proveedor");
				dispose();
				}
		});
		button.setBounds(203, 212, 89, 23);
		getContentPane().add(button);

		textid = new JTextField();
		textid.setColumns(10);
		textid.setBounds(79, 238, 86, 20);
		getContentPane().add(textid);

		JLabel label_6 = new JLabel("id");
		label_6.setBounds(23, 241, 46, 14);
		getContentPane().add(label_6);

	}
	public static void rellenarproveedor(String  id, String nombred, 
			String no_serie,String NombreMat, String CantidaComprada, 
			String precio,String fecha1) {
		java.util.Date date = null;
		try {
			date = new SimpleDateFormat("yyy/MM/dd").parse(fecha1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textid.setText(id);
		textNombreP.setText(nombred);
		textno_serie.setText(no_serie);
		textNmbreMat.setText(NombreMat);
		txtCantidad.setText(CantidaComprada);
		txtPrecio.setText(precio);
		fecha.setDate(date);
	
	}
	public static void modificar() {
		ModificarBD.registrarProveedor(Integer.parseInt(textid.getText()),textNombreP.getText(),textno_serie.getText() ,
				textNmbreMat.getText(),txtCantidad.getText(),txtPrecio.getText(),fecha.getDateFormatString());
		

	}
}

