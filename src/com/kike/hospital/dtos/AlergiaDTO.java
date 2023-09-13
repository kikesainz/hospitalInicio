package com.kike.hospital.dtos;

public class AlergiaDTO {

	private Integer id;
	private String descripcion;
	
	//constructor, getters y setters

	public AlergiaDTO(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	

	public AlergiaDTO() {
		super();
	}



	public Integer getNombre() {
		return id;
	}



	public void setNombre(Integer nombre) {
		this.id = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
