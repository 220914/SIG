package conexiones;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import javax.swing.JOptionPane;

import ventanas.ModificaRetiro;
import ventanas.ModificarCliente;
import ventanas.ModificarDinero;
import ventanas.ModificarProveedores;
//import com.mysql.jdbc.ResultSetMetaData;
import ventanas.Principal;


public class ModificarBD {
	public static Connection conexion=null;
	public static Statement s = null;
	public static boolean bandera=true;
	public static ResultSet tipo=null;
	public static String mensaje="";
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
	
	
	public static void registrarProveedor(int id, String NombreP, String no_serie,
			String NombreMat, String CantidadCompra, String Precio,String DateCompra) {

		try {
			//UPDATE `imprenta`.`proveedor` SET `Precio`='146' WHERE `IdProveedor`='2';
			conectar().executeUpdate("UPDATE proveedor SET "
							+ "IdProveedor="+id+", "
							+ "NombreP='"+NombreP+"',"
							+ "no_serie='"+no_serie+"',"
							+ "NombreMat='"+NombreMat+"',"
							+ "CantidadCompra='"+CantidadCompra+"',"
							+ "precio='"+Precio+"',"
							+ "DateCompra='"+DateCompra+"'"
							+ " where proveedor.IdProveedor="+id);	
		} catch (SQLException e) {
			//bandera=false;
			JOptionPane.showMessageDialog(null, e);
		} finally { 
			try {
				if (conexion != null) {
					conexion.close();
					conexiones.ConsultarBD.consultaTotal("proveedor");
					mensaje = (bandera=true) ? "Datos guardados correctamente":"Algo salio mal";
					JOptionPane.showMessageDialog(null, mensaje);
					
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}


	}

	public static void registrarCliente(int  IdCliente, String NombreCliente, 
			String DescripcionMaterial,String PrecioTotal, String Importe, 
			String FechaEntrega) {
		try {
				conectar().executeUpdate("UPDATE cliente SET "
						+ "IdCliente="+IdCliente+", "
						+ "NombreCliente='"+NombreCliente+"',"
						+ "DescripcionMaterial='"+DescripcionMaterial+"',"
						+ "PrecioTotal='"+PrecioTotal+"',"
						+ "Importe='"+Importe+"',"
						+ "FechaEntrega='"+FechaEntrega+"'"
						+ " where cliente.IdCliente="+IdCliente);	
	} catch (SQLException e) {
		//bandera=false;
		JOptionPane.showMessageDialog(null, e);
	} finally { 
		try {
			if (conexion != null) {
				conexion.close();
				conexiones.ConsultarBD.consultaTotal("cliente");
				mensaje = (bandera=true) ? "Datos guardados correctamente":"Algo salio mal";
				JOptionPane.showMessageDialog(null, mensaje);
				
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	}
	public static void registrarDineroextra(int id,int  cantidad,  String descripcion) {
		try {
				conectar().executeUpdate("UPDATE dineroextra SET "
						+ "idcantidad="+id+", "
						+ "cantidad="+cantidad+", "
						+ "descripcion='"+descripcion+"'"
						+ "where dineroextra.idcantidad="+id);	
	} catch (SQLException e) {
		//bandera=false;
		JOptionPane.showMessageDialog(null, e);
	} finally { 
		try {
			if (conexion != null) {
				conexion.close();
				conexiones.ConsultarBD.consultaTotal("dineroextra");
				mensaje = (bandera=true) ? "Datos guardados correctamente":"Algo salio mal";
				JOptionPane.showMessageDialog(null, mensaje);
				
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	}

	public static void registrarretiro(int id,int  cantidad,  String descripcion) {
		try {
				conectar().executeUpdate("UPDATE retiro SET "
						+ "idcantidad="+id+", "
						+ "cantidad="+cantidad+", "
						+ "descripcion='"+descripcion+"'"
						+ "where retiro.idcantidad="+id);	
	} catch (SQLException e) {
		//bandera=false;
		JOptionPane.showMessageDialog(null, e);
	} finally { 
		try {
			if (conexion != null) {
				conexion.close();
				conexiones.ConsultarBD.consultaTotal("retiro");
				mensaje = (bandera=true) ? "Datos guardados correctamente":"Algo salio mal";
				JOptionPane.showMessageDialog(null, mensaje);
				
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}}

	//=====================================================================================================================


	public static void rellenarcliente(String IdCliente) throws ParseException {
		ResultSet tipo = null;
		try {
			tipo = conectar().executeQuery("SELECT * FROM cliente WHERE IdCliente="+IdCliente);

			while(tipo.next())
			{
				ModificarCliente.rellenarcliente(
						
				tipo.getString("IdCliente"), 
				tipo.getString("NombreCliente"), 
				tipo.getString("DescripcionMaterial"),
				tipo.getString("PrecioTotal"),
				tipo.getString("Importe"),
				tipo.getString("FechaEntrega"));

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void rellenarproveedor(String IdProveedor) throws ParseException {
		ResultSet tipo = null;
		try {
			tipo = conectar().executeQuery("SELECT * FROM proveedor where IdProveedor="+IdProveedor);//procedimiento creado en la base de datos
			while(tipo.next())
			{
				ModificarProveedores.rellenarproveedor(
						tipo.getString("IdProveedor"), 
						tipo.getString("NombreP"), 
						tipo.getString("no_serie"),
						tipo.getString("NombreMat"),
						tipo.getString("CantidadCompra"),
						tipo.getString("precio"),
						tipo.getString("DateCompra"));
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void rellenardineroextra(String id) throws ParseException {
		ResultSet tipo = null;
		try {
			tipo = conectar().executeQuery("SELECT * FROM dineroextra WHERE idcantidad="+id);

			while(tipo.next())
			{
				ModificarDinero.rellenardineroextra(
				tipo.getString("idcantidad"), 	
				tipo.getString("cantidad"), 
				tipo.getString("descripcion"));

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void rellenarretiro(String id) throws ParseException {
		ResultSet tipo = null;
		try {
			tipo = conectar().executeQuery("SELECT * FROM retiro WHERE idcantidad="+id);

			while(tipo.next())
			{
				ModificaRetiro.rellenarretiro(
				tipo.getString("idcantidad"), 	
				tipo.getString("cantidad"), 
				tipo.getString("descripcion"));

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		}