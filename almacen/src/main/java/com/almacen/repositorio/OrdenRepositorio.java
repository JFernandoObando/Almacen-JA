package com.almacen.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.almacen.modelo.Orden;

public interface OrdenRepositorio extends JpaRepository<Orden,Long> {

@Query(nativeQuery = true, value = "SELECT cliente.nombre AS nombre_cliente, cliente.apellido AS apellido_cliente, articulo.nombre AS nombre_articulo, orden.id AS numero_orden " +
		    "FROM orden " +
		    "JOIN cliente ON orden.id_cliente = cliente.id " +
		    "JOIN articulo ON orden.id_articulo = articulo.id")
	List<Object[]> findOrderDetails();
	
}
