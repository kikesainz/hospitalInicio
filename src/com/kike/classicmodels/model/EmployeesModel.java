package com.kike.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kike.classicmodels.utils.DBUtils;



public class EmployeesModel {
	

	public Integer insertarEmployee(int numeroEmpleado, String apellido, String nombre, String extension, String email, String codOfi, int reportaA, String puesto) throws SQLException, ClassNotFoundException {
		
		String sql = "INSERT INTO employees (employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);

		ps.setInt(1, numeroEmpleado);
		ps.setString(2, apellido);
		ps.setString(3, nombre);
		ps.setString(4, extension);
		ps.setString(5, email);
		ps.setString(6, codOfi);
		ps.setInt(6, reportaA);
		ps.setString(6, puesto);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}


}
