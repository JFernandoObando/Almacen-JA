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

import com.almacen.modelo.Articulo;
import com.almacen.modelo.Cliente;
import com.almacen.servicios.ArticuloServicio;


@RestController
@RequestMapping("/articulo/")
public class ArticuloControlador {

	@Autowired
	private ArticuloServicio articuloServicio;
	
	@GetMapping
	private ResponseEntity<List<Articulo>> getAllArticulo(){
	
		return ResponseEntity.ok(articuloServicio.findAll());
	}
	
	
	
	@PostMapping
	private ResponseEntity<Articulo> savePersona(@RequestBody Articulo articulo){
		try {
		 Articulo articuloSave=articuloServicio.save(articulo);
		 return ResponseEntity.created(new URI("/articulo/" + articuloSave.getId())).body(articuloSave);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
