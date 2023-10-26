package com.almacen.controlador;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.modelo.Cliente;
import com.almacen.servicios.ClienteServicio;



@RestController
@RequestMapping("/cliente/")
public class ClienteControlador {

	@Autowired
	private ClienteServicio clienteServicio;
	
	@GetMapping
	private ResponseEntity<List<Cliente>> getAllClientes(){
	
		return ResponseEntity.ok(clienteServicio.findAll());
	}
	
	
	@PostMapping
	private ResponseEntity<Cliente> savePersona(@RequestBody Cliente cliente){
		try {
		 Cliente clienteSave=clienteServicio.save(cliente);
		 return ResponseEntity.created(new URI("/personas/" + clienteSave.getId())).body(clienteSave);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@DeleteMapping(value="delete/{id}")
	private ResponseEntity<Boolean> deleteCliente(@PathVariable ("id") Long id){
		clienteServicio.deleteById(id);
		return ResponseEntity.ok(!(clienteServicio.findById(id)!=null));
	}
	
}
