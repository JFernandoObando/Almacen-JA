package com.almacen.init;


import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.almacen.modelo.Cliente;
import com.almacen.repositorio.ClienteRepositorio;

@Component
@Order(2)
public class ClienteInicial  implements CommandLineRunner {


	  private final ClienteRepositorio clienteRepositorio;
	    
	    public ClienteInicial(ClienteRepositorio clienteRepositorio) {
	    	this.clienteRepositorio=clienteRepositorio;


	    }
	    
	    public void run(String... args) throws Exception {
	 
	    	 
	    	   

	            Cliente cliente1 = new Cliente("Juan","Obando");
	            Cliente cliente2 = new Cliente("Erick","Perez");

	            clienteRepositorio.saveAll(List.of(cliente1, cliente2));
	
	    }
	    
	
}
