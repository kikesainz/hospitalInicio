package com.kike.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.kike.hospital.dtos.AlergiaDTO;
import com.kike.hospital.model.AlergiasModelo;

public class AlergiasController {
	

	
	public List<AlergiaDTO> buscarAlergias(String id, String nombre) throws ClassNotFoundException, SQLException{
		AlergiasModelo am = new AlergiasModelo();
		return am.buscaAlergia(id, nombre);
	}
	
	
	public Integer insertarCliente(int numerocliente, String nombreCliente, String apellidoContacto, String nombreContacto,
			String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito) throws ClassNotFoundException, SQLException {
		
		AlergiasModelo cm = new AlergiasModelo();
		return cm.insertarCliente(nombreCliente);
	}
	
	public Integer actualizarCliente(int numerocliente, String nombreCliente, String apellidoContacto, String nombreContacto,
			String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito) throws ClassNotFoundException, SQLException {
		
		AlergiasModelo cm = new AlergiasModelo();
		return cm.actualizarCliente(numerocliente, nombreCliente, apellidoContacto, nombreContacto, telefono, direccion1, direccion2, 
									ciudad, estado, codigoPostal, pais, representante, credito);
	}
	
	public Integer borrarCliente(int numerocliente) throws ClassNotFoundException, SQLException {
		
		AlergiasModelo cm = new AlergiasModelo();
		return cm.borrarCliente(numerocliente);
	}

}
