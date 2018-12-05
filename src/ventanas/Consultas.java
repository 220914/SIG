package ventanas;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import conexiones.EliminarBD;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.text.ParseException;


import java.awt.Font;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

public class Consultas extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String nomTabla;
	public static String dato, titulo;

public static JTable tabla;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultas frame = new Consultas();
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
	public Consultas() {
		getContentPane().setBackground(Color.WHITE);
		setTitle(titulo);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(10, 10, 476, 292);
		getContentPane().setLayout(new MigLayout("", "[106.00,grow]", "[][grow]"));

		JButton btnActualizar = new JButton("Recargar");
		btnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnActualizar.setBackground(Color.WHITE);
		btnActualizar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnActualizar.setVerticalTextPosition(SwingConstants.BOTTOM);
	//	btnActualizar.setIcon(new ImageIcon(Consultas.class.getResource("/imagenes/recargar.png")));
		btnActualizar.setFont(new Font("Arial", Font.BOLD, 14));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexiones.ConsultarBD.consultaTotal(nomTabla);
			}
		});
		getContentPane().add(btnActualizar, "flowx,cell 0 0,growx");

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setBackground(Color.WHITE);
	//	btnEliminar.setIcon(new ImageIcon(Consultas.class.getResource("/imagenes/boton-eliminar.png")));
		btnEliminar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 14));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila=tabla.getSelectedRow();
				if (Principal.usuario=="Invitado") {
					JOptionPane.showMessageDialog(null, "Lo siento no tienes permisos para realizar esta accion");
				}else {
				
						if (nomTabla=="retio"||nomTabla=="proveedor"  ||  nomTabla=="cliente" ||nomTabla=="Dineroextra" ) {
							dato=(String) tabla.getValueAt(fila, 0);	
							EliminarBD.eliminarDatos(nomTabla, dato);
					

					}
					else {
						JOptionPane.showMessageDialog(null, "No se a detectado ninguan fila seleccionada");
					}
				}
			}
		});
		
		getContentPane().add(btnEliminar, "cell 0 0,growx");

		JButton btnModficar = new JButton("Modficar");
		btnModficar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModficar.setBackground(Color.WHITE);
		//btnModficar.setIcon(new ImageIcon(Consultas.class.getResource("/imagenes/edit_modify_icon-icons.com_49882.png")));
		btnModficar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnModficar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModficar.setFont(new Font("Arial", Font.BOLD, 14));
		btnModficar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int fila=tabla.getSelectedRow();//es paara traer la fila seleccionada el getSelectedRow
				if (Principal.usuario=="Invitado") {//verificar el tipo de usuario Para asignarle permisos
					JOptionPane.showMessageDialog(null, "Lo siento no tienes permisos para realizar esta accion");
				}else {
					switch (nomTabla){
					case "proveedor":
						if (fila>-1) {
							ModificarProveedores pro= new ModificarProveedores();
						    Principal.dpEscritorio.add(pro);
						    pro.show();
							dato=(String) tabla.getValueAt(fila, 0);
							try {
								conexiones.ModificarBD.rellenarproveedor(dato);
							} catch (HeadlessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							//                                  } catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
						}
						else {
							JOptionPane.showMessageDialog(null, "No se a detectado ninguan fila seleccionada");
						}
						break;
					case "cliente":
						if (fila>-1) {
							ModificarCliente Me= new ModificarCliente();
						    Principal.dpEscritorio.add(Me);
						    Me.show();
							dato=(String) tabla.getValueAt(fila, 0);
							try {
								conexiones.ModificarBD.rellenarcliente(dato);
							} catch (HeadlessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else {
							JOptionPane.showMessageDialog(null, "No se a detectado ninguan fila seleccionada");
						}break;case "retiro":
							if (fila>-1) {
								ModificaRetiro pro= new ModificaRetiro();
							    Principal.dpEscritorio.add(pro);
							    pro.show();
								dato=(String) tabla.getValueAt(fila, 0);
								try {
									conexiones.ModificarBD.rellenarretiro(dato);
								} catch (HeadlessException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								//                                  } catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} 
							}
							else {
								JOptionPane.showMessageDialog(null, "No se a detectado ninguan fila seleccionada");
							}break;
					case "Dineroextra":
						if (fila>-1) {
							ModificarDinero pro= new ModificarDinero();
						    Principal.dpEscritorio.add(pro);
						    pro.show();
							dato=(String) tabla.getValueAt(fila, 0);
							try {
								conexiones.ModificarBD.rellenardineroextra(dato);
							} catch (HeadlessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							//                                  } catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
						}
						else {
							JOptionPane.showMessageDialog(null, "No se a detectado ninguan fila seleccionada");
						}
							
					}
				}
			}
		});
		getContentPane().add(btnModficar, "cell 0 0,growx");
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "cell 0 1,grow");
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
	}
}
