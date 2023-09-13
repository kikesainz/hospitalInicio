package com.kike.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kike.hospital.dtos.AlergiaDTO;
import com.kike.hospital.utils.DBUtils;

public class AlergiasModelo {
	

	
	public List<AlergiaDTO> buscaAlergia (String nombre) throws ClassNotFoundException, SQLException {
		
		String query = "SELECT * FROM alergias where Descripcion LIKE ? ";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		
		PreparedStatement ps  = conexionBD.prepareStatement(query); //Creamos el PreparedStatement pasándole el String de la query por parametro
		ps.setString(1, "%" + nombre + "%"); 
		
		ResultSet alergiasRS = ps.executeQuery();	//Ejecutamos la query sobre la BBDD	
		List<AlergiaDTO> listaAlergias = new ArrayList<>(); //Creamos el arrayList para almacenar los resultados.

		while (alergiasRS.next()) {
			AlergiaDTO c = new AlergiaDTO(alergiasRS.getInt("ID"), alergiasRS.getString("Descrip"));
			listaAlergias.add(c);
		}
		conexionBD.close();
		
		return listaAlergias;
	}
	
	public List<AlergiaDTO> recuperaNombreTelefonoFiltraporNombreTfnoPais (String nombre, String tfno, String pais) throws ClassNotFoundException, SQLException {
		
		String query = "SELECT * FROM customers where customerName LIKE ? OR phone LIKE ? OR country LIKE ? ";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		
		PreparedStatement ps  = conexionBD.prepareStatement(query);
		
		ps.setString(1, "%" + nombre + "%"); 
		ps.setString(2, "%" + tfno + "%");
		ps.setString(3, "%" + pais + "%");
		
		ResultSet clientes = ps.executeQuery();	//Ejecutamos la query sobre la BBDD	
		List<AlergiaDTO> listaClientes = new ArrayList<>(); //Creamos el arrayList para almacenar los resultados.

//		while (clientes.next()) {
//			AlergiaDTO c = new AlergiaDTO(clientes.getString("customerName"), clientes.getString("phone"));
//			listaClientes.add(c);
//		}
		conexionBD.close();
		
		return listaClientes;
	}
	
	public Integer insertarCliente(int numerocliente, String nombreCliente, String apellidoContacto, String nombreContacto,
			String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito) throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1,"
					+ " addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit ) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1, numerocliente);
		ps.setString(2, nombreCliente);
		ps.setString(3, apellidoContacto);
		ps.setString(4, nombreContacto);
		ps.setString(5, telefono);
		ps.setString(6, direccion1);
		ps.setString(7, direccion2);
		ps.setString(8, ciudad);
		ps.setString(9, estado);
		ps.setString(10, codigoPostal);
		ps.setString(11, pais);
		ps.setInt(12, representante);
		ps.setDouble(13, credito);
		
		resultado = ps.executeUpdate();
		
		connection.close();
		
		return resultado;
		}
	
	public Integer actualizarCliente(int numerocliente, String nombreCliente, String apellidoContacto, String nombreContacto,
			String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito) throws SQLException, ClassNotFoundException {

		String sql = "UPDATE customers SET customerName = CASE WHEN ? = '' THEN customerName ELSE ? END,"
				+ "contactLastName  = CASE WHEN ? = '' THEN contactLastName ELSE ? END,"
				+ "contactFirstName = CASE WHEN ? = '' THEN contactFirstName ELSE ? END, "
				+ "phone = CASE WHEN ? = '' THEN phone ELSE ? END, "
				+ "addressLine1 = CASE WHEN ? = '' THEN addressLine1 ELSE ? END, "
				+ "addressLine2 = CASE WHEN ? = '' THEN addressLine2 ELSE ? END, "
				+ "city = CASE WHEN ? = '' THEN city ELSE ? END, "
				+ "state = CASE WHEN ? = '' THEN state ELSE ? END, "
				+ "postalCode = CASE WHEN ? = '' THEN postalCode ELSE ? END, "
				+ "country = CASE WHEN ? = '' THEN country ELSE ? END, "
				+ "salesRepEmployeeNumber = CASE WHEN ? = '' THEN salesRepEmployeeNumber ELSE ? END, "
				+ "creditLimit = CASE WHEN ? = '' THEN creditLimit ELSE ? END  "
				+ "WHERE customerNumber = ?";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);		

		ps.setString(1, nombreCliente);
		ps.setString(2, nombreCliente);
		
		ps.setString(3, apellidoContacto);
		ps.setString(4, apellidoContacto);
		
		ps.setString(5, nombreContacto);
		ps.setString(6, nombreContacto);
		
		ps.setString(7, telefono);
		ps.setString(8, telefono);
		
		ps.setString(9, direccion1);
		ps.setString(10, direccion1);
		
		ps.setString(11, direccion2);
		ps.setString(12, direccion2);
		
		ps.setString(13, ciudad);
		ps.setString(14, ciudad);
		
		ps.setString(15, estado);
		ps.setString(16, estado);
		
		ps.setString(17, codigoPostal);
		ps.setString(18, codigoPostal);
		
		ps.setString(19, pais);
		ps.setString(20, pais);
		
		ps.setInt(21, representante);
		ps.setInt(22, representante);
		
		ps.setDouble(23, credito);
		ps.setDouble(24, credito);
		
		ps.setInt(25,  numerocliente);
		
		resultado = ps.executeUpdate();
		
		connection.close();
		
		return resultado;
		}
	
	public Integer borrarCliente(int customerNumber) throws ClassNotFoundException, SQLException {
		
		String sql = "DELETE FROM customers where customerNumber = ?";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);		

		ps.setInt(1, customerNumber);
	
		resultado = ps.executeUpdate();
		
		connection.close();
		
		return resultado;
		
		
	}
}
