package com.kike.classicmodels.controllers;

import java.sql.SQLException;
import java.util.List;

import com.kike.classicmodels.dtos.ClienteDTO;
import com.kike.classicmodels.model.ClientesModelo;

public class ClientesController {
	
	public List<ClienteDTO> recuperaNombreTelefono(String nombre) throws ClassNotFoundException, SQLException{
		ClientesModelo cm = new ClientesModelo();
		return cm.recuperaNombreTelefonoFiltraporNombre(nombre);
	}
	
	public List<ClienteDTO> recuperaNombreTelefono(String nombre, String telefono, String pais) throws ClassNotFoundException, SQLException{
		ClientesModelo cm = new ClientesModelo();
		return cm.recuperaNombreTelefonoFiltraporNombreTfnoPais(nombre, telefono, pais);
	}
	
	
	public Integer insertarCliente(int numerocliente, String nombreCliente, String apellidoContacto, String nombreContacto,
			String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito) throws ClassNotFoundException, SQLException {
		
		ClientesModelo cm = new ClientesModelo();
		return cm.insertarCliente(numerocliente, nombreCliente, apellidoContacto, nombreContacto, telefono, direccion1, direccion2, 
									ciudad, estado, codigoPostal, pais, representante, credito);
	}
	
	public Integer actualizarCliente(int numerocliente, String nombreCliente, String apellidoContacto, String nombreContacto,
			String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito) throws ClassNotFoundException, SQLException {
		
		ClientesModelo cm = new ClientesModelo();
		return cm.actualizarCliente(numerocliente, nombreCliente, apellidoContacto, nombreContacto, telefono, direccion1, direccion2, 
									ciudad, estado, codigoPostal, pais, representante, credito);
	}
	
	public Integer borrarCliente(int numerocliente) throws ClassNotFoundException, SQLException {
		
		ClientesModelo cm = new ClientesModelo();
		return cm.borrarCliente(numerocliente);
	}

}
