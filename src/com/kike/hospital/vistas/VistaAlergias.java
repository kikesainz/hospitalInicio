package com.kike.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.kike.hospital.controllers.ClientesController;
import com.kike.hospital.dtos.AlergiaDTO;
import com.kike.hospital.utils.MiScanner;

public class VistaAlergias {
	
	public void menuGeneralCliente() throws ClassNotFoundException, SQLException {
	
			Scanner sc = MiScanner.getInstance();
			int n=0;
			do{
				System.out.println("Introduzca la operaci�n que desee realizar: ");
				
			    System.out.println("       MEN� PRINCIPAL PARA LA GESTI�N DE LA TABLA ALERGIAS");
			    System.out.println("===============================================");
			    System.out.println("1. Buscar alergia");
			    System.out.println("2. Insertar alergia");
			    System.out.println("3. Actualizar alergia ");
			    System.out.println("6. Volver al menú principal");
			    System.out.println("===============================================");
			    
			    n = Integer.parseInt(sc.nextLine());
		    
	            if (n == 6){
	                
	                return;
	            }
		    	
	            if (n>6||n<1){
	                System.out.print("Elección inválida, inténtalo otra vez...");
	                continue;
	            }
	            if ( n == 1) {
	            	menuBuscaAlergia();
	            	continue;
	            }
		    	
		    } while(n!=6);
		
	}

	
	public void menuBuscaAlergia() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el id de la alergia: ");
		Integer id = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca por favor el nombre de la alergia: ");
		
		String nombreEmpleado = sc.nextLine();
		
		ClientesController controladorClientes = new ClientesController();
//		List <AlergiaDTO> listaClientes = controladorClientes.recuperaNombreTelefono(nombreEmpleado);
		
//		for (AlergiaDTO cliente : listaClientes) {
//			System.out.println();			System.out.println(cliente.getNombre() + " " + cliente.getTelefono());
//
//		}
		
	}
	

	
	public void menuInsertaAlergia() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el nombre de la alergia: ");
		int  numeroCliente = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca por favor el nombre del cliente: ");
		String nombreCliente = sc.nextLine();		
		System.out.println("Introduzca por favor el apellido del contacto: ");
		String apellidoContacto = sc.nextLine();		
		System.out.println("Introduzca por favor el nombre del contacto: ");
		String nombreContacto = sc.nextLine();		
		System.out.println("Introduzca por favor el tel�fono del cliente: ");
		String telefono = sc.nextLine();		
		System.out.println("Introduzca por favor la direcci�n del cliente: ");
		String direccion1 = sc.nextLine();		
		System.out.println("Introduzca por favor la direcci�n 2 del cliente: ");
		String direccion2 = sc.nextLine();		
		System.out.println("Introduzca por favor la ciudad del cliente: ");
		String ciudad = sc.nextLine();		
		System.out.println("Introduzca por favor el estado del cliente: ");
		String estado = sc.nextLine();		
		System.out.println("Introduzca por favor el c�digo postal del cliente: ");
		String codigoPostal = sc.nextLine();		
		System.out.println("Introduzca por favor el pais: ");
		String pais = sc.nextLine();		
		System.out.println("Introduzca por favor el id del representante: ");
		int representante = 0;
		try {
		    representante = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
		    System.out.println("No se ha introducido n�mero de representante de ventas");
		}
		System.out.println("Introduzca por favor cr�dito (n�mero con decimales): ");
		Double credito = 0.0;
		try {
			credito = Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido cr�dito");
		}

		
		ClientesController controladorClientes = new ClientesController();
		int resultado = controladorClientes.insertarCliente(numeroCliente, 
											nombreCliente, 
											apellidoContacto, 
											nombreContacto, 
											telefono, 
											direccion1, 
											direccion2, 
											ciudad, 
											estado, 
											codigoPostal, 
											pais, 
											representante, 
											credito);
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con �xito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
		
	}
	
	public void menuActualizaCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el n�mero del cliente a actualizar: ");
		int  numeroCliente = Integer.parseInt(sc.nextLine());		
		System.out.println("Introduzca por favor el nombre del cliente: ");
		String nombreCliente = sc.nextLine();		
		System.out.println("Introduzca por favor el apellido del contacto: ");
		String apellidoContacto = sc.nextLine();		
		System.out.println("Introduzca por favor el nombre del contacto: ");
		String nombreContacto = sc.nextLine();		
		System.out.println("Introduzca por favor el tel�fono del cliente: ");
		String telefono = sc.nextLine();		
		System.out.println("Introduzca por favor la direcci�n del cliente: ");
		String direccion1 = sc.nextLine();		
		System.out.println("Introduzca por favor la direcci�n 2 del cliente: ");
		String direccion2 = sc.nextLine();		
		System.out.println("Introduzca por favor la ciudad del cliente: ");
		String ciudad = sc.nextLine();		
		System.out.println("Introduzca por favor el estado del cliente: ");
		String estado = sc.nextLine();		
		System.out.println("Introduzca por favor el c�digo postal del cliente: ");
		String codigoPostal = sc.nextLine();		
		System.out.println("Introduzca por favor el pais: ");
		String pais = sc.nextLine();		
		System.out.println("Introduzca por favor el id del representante: ");
		int representante = 0;
		try {
		    representante = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
		    System.out.println("No se ha introducido n�mero de representante de ventas");
		}
		System.out.println("Introduzca por favor cr�dito (n�mero con decimales): ");
		Double credito = 0.0;
		try {
			credito = Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido cr�dito");
		}
		
		ClientesController controladorClientes = new ClientesController();
		int resultado = controladorClientes.actualizarCliente(numeroCliente, 
											nombreCliente, 
											apellidoContacto, 
											nombreContacto, 
											telefono, 
											direccion1, 
											direccion2, 
											ciudad, 
											estado, 
											codigoPostal, 
											pais, 
											representante, 
											credito);
		if (resultado == 1) {
			System.out.println("Se ha actualizado el cliente con el n�mero: " + numeroCliente +" con �xito");
		} else {
			System.out.println("Se ha producido un error al actualizar el cliente con el n�mero: "+ numeroCliente);
		}
		
	}
	
	public void menuBorraCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el n�mero del cliente a borrar: ");
		int  numeroCliente = Integer.parseInt(sc.nextLine());	
		
		ClientesController controladorClientes = new ClientesController();
		int resultado = controladorClientes.borrarCliente(numeroCliente);
		
		if (resultado == 1) {
			System.out.println("Se ha borrado el cliente con el n�mero: " + numeroCliente +" con �xito");
		} else {
			System.out.println("Se ha producido un error al borrar el cliente con el n�mero: "+ numeroCliente);
		}
	
	}
	
	
}
