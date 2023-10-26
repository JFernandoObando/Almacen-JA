package com.almacen.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table (name="orden")
public class Orden {
	@Id
	private String id;
	private Date fecha;
	

	@ManyToOne
	@JoinColumn (name="id_cliente")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn (name="id_articulo")
	private Articulo articulo;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Articulo getArticulo() {
		return articulo;
	}


	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}


	public Orden(String id, Date fecha, Articulo articulo,Cliente cliente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.articulo = articulo;
		this.cliente = cliente;
	}
	
	public Orden() {
	
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}


