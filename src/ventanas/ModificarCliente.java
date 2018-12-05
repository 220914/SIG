package ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;


import conexiones.ModificarBD;


public class ModificarCliente extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField textNombre;
	public static JTextField textPrecioT;
	public static JTextField textImporte;
	public static JTextField textid;
	public static JTextArea 		 textDescripcion;
	public static JDateChooser fecha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCliente frame = new ModificarCliente();
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
	public ModificarCliente() {
		setBounds(100, 100, 450, 300);
		setTitle("Actualizar registros");
		
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombre:");
		lblNombres.setBounds(32, 14, 62, 14);
		getContentPane().add(lblNombres);
		
		JLabel lblDescripcinDelMaterial = new JLabel("Descripci\u00F3n del material a utilizar:");
		lblDescripcinDelMaterial.setBounds(32, 39, 192, 14);
		getContentPane().add(lblDescripcinDelMaterial);
		
		JLabel lblPrecioTotal = new JLabel("Precio total:");
		lblPrecioTotal.setBounds(42, 133, 79, 14);
		getContentPane().add(lblPrecioTotal);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setBounds(155, 133, 69, 14);
		getContentPane().add(lblImporte);
		
		JLabel lblFechaDeEntrega = new JLabel("Fecha de entrega:");
		lblFechaDeEntrega.setBounds(257, 133, 106, 14);
		getContentPane().add(lblFechaDeEntrega);
		
		textNombre = new JTextField();
		textNombre.setBounds(104, 11, 259, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textPrecioT = new JTextField();
		textPrecioT.setBounds(32, 158, 86, 20);
		getContentPane().add(textPrecioT);
		textPrecioT.setColumns(10);
		
		textImporte = new JTextField();
		textImporte.setBounds(138, 158, 86, 20);
		getContentPane().add(textImporte);
		textImporte.setColumns(10);
		fecha = new JDateChooser();
		fecha.setBounds(257, 158, 96, 20);
		getContentPane().add(fecha);
		
		 textDescripcion = new JTextArea();
		textDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDescripcion.setBounds(32, 64, 331, 58);
		getContentPane().add(textDescripcion);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
				conexiones.ConsultarBD.consultaTotal("cliente");
				dispose();
			}
		});
		btnActualizar.setBounds(157, 209, 89, 23);
		getContentPane().add(btnActualizar);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(10, 245, 46, 14);
		getContentPane().add(lblId);
		
		textid = new JTextField();
		textid.setBounds(66, 242, 86, 20);
		getContentPane().add(textid);
		textid.setColumns(10);

}
	public static void rellenarcliente(String  IdCliente, String NombreCliente, 
			String DescripcionMaterial,String PrecioTotal, String Importe, 
			String FechaEntrega) {
		
		java.util.Date date = null;
		try {
			date = new SimpleDateFormat("yyy/MM/dd").parse(FechaEntrega);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textid.setText(IdCliente);
		textNombre.setText(NombreCliente);
		textDescripcion.setText(DescripcionMaterial);
		textPrecioT.setText(PrecioTotal);
		textImporte.setText(Importe);
		fecha.setDate(date);
		
	}
	public static void modificar() {
		String fechaAd = null;
		try {
			java.util.Date date = fecha.getDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			fechaAd=sdf.format(date);
		} catch(NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Al menos selecciona una fecha válida!", "Error!", JOptionPane.INFORMATION_MESSAGE);
		}
		ModificarBD.registrarCliente(
				Integer.parseInt(textid.getText())
				,textNombre.getText(),
				textDescripcion.getText() ,
				textPrecioT.getText(),
				textImporte.getText(),
				fechaAd);
	}

		
	}

