package com.almacen.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.almacen.modelo.Articulo;



public interface ArticuloRepositorio extends JpaRepository<Articulo,Long> {

	
   
	
}

