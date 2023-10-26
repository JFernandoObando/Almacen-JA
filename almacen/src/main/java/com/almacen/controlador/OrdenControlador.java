package com.almacen.controlador;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.modelo.Cliente;
import com.almacen.modelo.Orden;
import com.almacen.servicios.ClienteServicio;
import com.almacen.servicios.OrdenServicio;


@RestController
@RequestMapping("/orden/")
public class OrdenControlador {

	@Autowired
	private OrdenServicio ordenServicio;
	
	@GetMapping
	private ResponseEntity<List<Orden>> getAllOrden(){
		return ResponseEntity.ok(ordenServicio.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Orden> saveOrden(@RequestBody Orden orden){
		try {
		Orden ordenSave=ordenServicio.save(orden);
		 return ResponseEntity.created(new URI("/orden/" + ordenSave.getId())).body(ordenSave);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	  @GetMapping("/detalles")
	    public List<Object[]> obtenerDetallesDeOrden() {
	        return ordenServicio.findOrderDetails();
	    }
}
