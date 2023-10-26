package com.almacen.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almacen.modelo.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {

	
	
}

