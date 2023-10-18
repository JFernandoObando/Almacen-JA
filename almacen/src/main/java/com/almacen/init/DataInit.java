/*package com.almacen.init;

import com.almacen.modelo.Articulo;
import com.almacen.modelo.Cliente;
import com.almacen.modelo.Orden;
import com.almacen.modelo.OrdenDetalle;
import com.almacen.repositorio.ArticuloRepositorio;
import com.almacen.repositorio.ClienteRepositorio;
import com.almacen.repositorio.OrdenDetalleRepositorio;
import com.almacen.repositorio.OrdenRepositorio;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

    private final ClienteRepositorio clienteRepositorio;
    private final OrdenRepositorio ordenRepositorio;
    private final ArticuloRepositorio articuloRepositorio;
    private final OrdenDetalleRepositorio ordenDetalleRepositorio;
 private boolean ejecutado = false; // Variable de control
 
    @Autowired
    public DataInit(ClienteRepositorio clienteRepositorio, OrdenRepositorio ordenRepositorio, ArticuloRepositorio articuloRepositorio, OrdenDetalleRepositorio ordenDetalleRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
        this.ordenRepositorio = ordenRepositorio;
        this.articuloRepositorio = articuloRepositorio;
        this.ordenDetalleRepositorio = ordenDetalleRepositorio;
    }

    @Override
    public void run(ApplicationArguments args)  {
        // Crear instancias de Cliente
         
        Cliente cliente1 = new Cliente("Juan", "Obanndo");
        Cliente cliente2 = new Cliente("Pepito", "Perez");
        clienteRepositorio.save(cliente1);
        clienteRepositorio.save(cliente2);
         String nuevoNumeroOrden1 = Orden.generarNumeroOrden();

        Orden orden1 = new Orden(nuevoNumeroOrden1, new Date(), cliente1);
        ordenRepositorio.save(orden1);

Articulo articulo1 = new Articulo("Linterna", BigDecimal.valueOf(10.99));
       Articulo articulo2 = new Articulo("Plato", BigDecimal.valueOf(15.99));
          articuloRepositorio.save(articulo1);
        articuloRepositorio.save(articulo2);
        
        
        // Inicialización de OrdenDetalle
        OrdenDetalle detalle1 = new OrdenDetalle(orden1, articulo1);
        ordenDetalleRepositorio.save(detalle1);
       
          
    }
}
*/