package com.almacen.init;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.almacen.modelo.Articulo;
import com.almacen.modelo.Cliente;
import com.almacen.modelo.Orden;
import com.almacen.repositorio.ArticuloRepositorio;
import com.almacen.repositorio.ClienteRepositorio;
import com.almacen.repositorio.OrdenRepositorio;

@Component
@Order(3)
public class OrdenInicial  implements CommandLineRunner  {

	  private final OrdenRepositorio ordenRepositorio;
	    private final ArticuloRepositorio articuloRepositorio;
	    private final ClienteRepositorio clienteRepositorio;
	    
	    public OrdenInicial(OrdenRepositorio ordenRepositorio,ArticuloRepositorio articuloRepositorio,ClienteRepositorio clienteRepositorio) {
	    	 this.ordenRepositorio = ordenRepositorio;
	         this.articuloRepositorio = articuloRepositorio;
	         this.clienteRepositorio=clienteRepositorio;
	    }

	    
	    public void run(String... args) throws Exception {

	    	   List<Articulo> articulos = articuloRepositorio.findAll();
	    	   Articulo primerId = articulos.get(0);
	    	   Articulo primerId1 = articulos.get(1);
	    	   
	    	   List<Cliente> cliente = clienteRepositorio.findAll();
	    	   Cliente primerCId = cliente.get(0);
	    	   Cliente primerCId1 = cliente.get(1);
	    	   
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	            Date fecha = sdf.parse("2023/10/25");


	            Orden orden1 = new Orden("OC-000001", fecha, primerId,primerCId);
	            Orden orden2 = new Orden("OC-000002", fecha, primerId1,primerCId);
	            Orden orden3 = new Orden("OC-000003", fecha, primerId1,primerCId1);


	            ordenRepositorio.saveAll(List.of(orden1, orden2, orden3));
	
	    }
	    
	    
	
	
}
