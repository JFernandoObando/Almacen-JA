package com.almacen.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table (name="articulo")
public class Articulo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nombre;
	private Double precio_u;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio_u() {
		return precio_u;
	}
	public void setPrecio_u(Double precio_u) {
		this.precio_u = precio_u;
	}
	public Articulo(String nombre, Double precio_u) {
		super();
		this.nombre = nombre;
		this.precio_u = precio_u;
	}
	
	public Articulo() {
	
	}
	
	
	
	
	
}




