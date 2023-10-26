package com.almacen.init;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.almacen.modelo.Articulo;
import com.almacen.repositorio.ArticuloRepositorio;

@Component
@Order(1)
public class ArticuloInicial  implements CommandLineRunner  {
	  private final ArticuloRepositorio articuloRepositorio;

	    public ArticuloInicial(ArticuloRepositorio articuloRepositorio) {
	        this.articuloRepositorio = articuloRepositorio;
	    }

	    @Override
	    public void run(String... args) throws Exception {
	        Articulo articulo1 = new Articulo("Esfero", 0.50);
	        Articulo articulo2 = new Articulo("Lapiz", 0.40);
	        Articulo articulo3 = new Articulo("Cuaderno", 1.50);

	        articuloRepositorio.saveAll(List.of(articulo1, articulo2, articulo3));
	    }
	    
}
