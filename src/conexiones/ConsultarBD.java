package conexiones;

import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import javax.swing.table.DefaultTableModel;
import ventanas.*;

public class ConsultarBD {
	public static Connection conexion=null;
	///vincular con la BD
	public static Statement s = null;
	//rs Es el result
	public static ResultSet rs=null; 
	public static Statement conectar(){
		try {
			//drive para hecer la conexion
			Class.forName("com.mysql.jdbc.Driver");
			//conexion ala base de datos el que esta en el comentario
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/imprenta?useSSL=false", Principal.usuario, Principal.contraseña);
			s = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return s;
	}
	public static void RellenarTabla(String nomTabla, String buscar){
		DefaultTableModel tablaModelo= new DefaultTableModel();
		String []titulos;
		String []Datos;
		switch (nomTabla){
		case "proveedor":
			titulos= new String[]{"IdProveedor","NombreP ","no_serie","NombreMat ","CantidadCompra ","Precio","DateCompra "};
			tablaModelo.setColumnIdentifiers(titulos);
			Consultas.tabla.setModel(tablaModelo);
			Datos= new String [7];
			try {
				ResultSet rs= conectar().executeQuery("SELECT * FROM proveedor WHERE IdProveedor LIKE '"+buscar+"'");
				while(rs.next())
				{

					Datos[0]=rs.getString("IdProveedor");//rs result set leer fila por fila dentro de una BD
					Datos[1]=rs.getString("NombreP");
					Datos[2]=rs.getString("no_serie");
					Datos[3]=rs.getString("NombreMat");  
					Datos[4]=rs.getString("CantidadCompra");  
					Datos[5]=rs.getString("Precio"); 
					Datos[6]=rs.getString("DateCompra"); 
				}
			} catch (SQLException ex) {
				showMessageDialog(null, ex);
			}break;	
		case "cliente":
			titulos= new String[]{"idcliente ","NombreCliente ","DescripcionMaterial","PrecioTotal","Importe","FechaEnterega"};
			tablaModelo.setColumnIdentifiers(titulos);
			Consultas.tabla.setModel(tablaModelo);
			Datos= new String [3];
			try {
				ResultSet rs= conectar().executeQuery("SELECT * FROM cliente WHERE idcliente LIKE '"+buscar+"'");
				while(rs.next())
				{
					Datos[0]=rs.getString("idcliente");
					Datos[1]=rs.getString("NombreCliente");
					Datos[2]=rs.getString("DescripcionMaterial");
					Datos[3]=rs.getString("PrecioTotal");
					Datos[4]=rs.getString("Importe");
					Datos[5]=rs.getString("FechaEnterega");

					tablaModelo.addRow(Datos);
				}
			} catch (SQLException ex) {
				showMessageDialog(null, ex);
			}break;
		case "Dineroextra":
			titulos= new String[]{"idcantidad","cantidad","descripcion"};
			tablaModelo.setColumnIdentifiers(titulos);
			Consultas.tabla.setModel(tablaModelo);
			Datos= new String [3];
			try {
				ResultSet rs= conectar().executeQuery("SELECT * FROM Dineroextra");
				while(rs.next())
				{
					Datos[0]=rs.getString("idcantidad");
					Datos[1]=rs.getString("cantidad");//rs result set leer fila por fila dentro de una BD
					Datos[2]=rs.getString("descripcion"); 
					tablaModelo.addRow(Datos);
				}
			} catch (SQLException ex) {
				showMessageDialog(null, ex);

			}break;
		case "retiro":
			titulos= new String[]{"idcantidad","cantidad","descripcion"};
			tablaModelo.setColumnIdentifiers(titulos);
			Consultas.tabla.setModel(tablaModelo);
			Datos= new String [3];
			try {
				ResultSet rs= conectar().executeQuery("SELECT * FROM retiro");
				while(rs.next())
				{
					Datos[0]=rs.getString("idcantidad");
					Datos[1]=rs.getString("cantidad");//rs result set leer fila por fila dentro de una BD
					Datos[2]=rs.getString("descripcion"); 
					tablaModelo.addRow(Datos);
				}
			} catch (SQLException ex) {
				showMessageDialog(null, ex);
			}}
	}






	public static void consultaTotal(String nomTabla){
		DefaultTableModel tablaModelo= new DefaultTableModel();
		String []titulos;
		String []Datos;

		switch (nomTabla){case "proveedor":
			titulos= new String[]{"IdProveedor","NombreP ","no_serie ","NombreMat ","CantidadCompra","Precio","DateCompra"};
			tablaModelo.setColumnIdentifiers(titulos);
			Consultas.tabla.setModel(tablaModelo);
			Datos= new String [7];
			try {
				ResultSet rs= conectar().executeQuery("SELECT * FROM proveedor");
				while(rs.next())
				{
					Datos[0]=rs.getString("IdProveedor");
					Datos[1]=rs.getString("NombreP");
					Datos[2]=rs.getString("no_serie");
					Datos[3]=rs.getString("NombreMat");
					Datos[4]=rs.getString("CantidadCompra");
					Datos[5]=rs.getString("Precio");
					Datos[6]=rs.getString("DateCompra");//rs result set leer fila por fila dentro de una BD

					tablaModelo.addRow(Datos);
				}
			} catch (SQLException ex) {
				showMessageDialog(null, ex);
			}break;	
		case "retiro":
			titulos= new String[]{"id","cantidad","descripcion"};
			tablaModelo.setColumnIdentifiers(titulos);
			Consultas.tabla.setModel(tablaModelo);
			Datos= new String [3];
			try {
				ResultSet rs= conectar().executeQuery("SELECT * FROM retiro");
				while(rs.next())
				{
					Datos[0]=rs.getString("idcantidad");
					Datos[1]=rs.getString("cantidad");//rs result set leer fila por fila dentro de una BD
					Datos[2]=rs.getString("descripcion"); 
					tablaModelo.addRow(Datos);
				}
			} catch (SQLException ex) {
				showMessageDialog(null, ex);
			}break;
		case "Dineroextra":
			titulos= new String[]{"id","cantidad","descripcion"};
			tablaModelo.setColumnIdentifiers(titulos);
			Consultas.tabla.setModel(tablaModelo);
			Datos= new String [3];
			try {
				ResultSet rs= conectar().executeQuery("SELECT * FROM Dineroextra");
				while(rs.next())
				{
					Datos[0]=rs.getString("idcantidad");
					Datos[1]=rs.getString("cantidad");//rs result set leer fila por fila dentro de una BD
					Datos[2]=rs.getString("descripcion"); 
					tablaModelo.addRow(Datos);
				}
			} catch (SQLException ex) {
				showMessageDialog(null, ex);
			}break;

		case "cliente":
			titulos= new String[]{"idcliente ","NombreCliente ","DescripcionMaterial","PrecioTotal","Importe","FechaEnterega"};
			tablaModelo.setColumnIdentifiers(titulos);
			Consultas.tabla.setModel(tablaModelo);
			Datos= new String [6];
			try {
				ResultSet rs= conectar().executeQuery("SELECT * FROM cliente");
				while(rs.next())
				{

					Datos[0]=rs.getString("idcliente");
					Datos[1]=rs.getString("NombreCliente");
					Datos[2]=rs.getString("DescripcionMaterial");
					Datos[3]=rs.getString("PrecioTotal");
					Datos[4]=rs.getString("Importe");
					Datos[5]=rs.getString("FechaEntrega");

					tablaModelo.addRow(Datos);
				}
			} catch (SQLException ex) {
				showMessageDialog(null, ex);
			}
		}

	}
	
}