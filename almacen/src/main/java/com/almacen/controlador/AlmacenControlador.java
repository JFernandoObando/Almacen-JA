
package com.almacen.controlador;

//import com.almacen.excepciones.ResourceNotFoundException;
import com.almacen.modelo.Articulo;
import com.almacen.modelo.Cliente;
import com.almacen.modelo.Orden;
import com.almacen.modelo.OrdenDetalle;
import com.almacen.repositorio.ArticuloRepositorio;
import com.almacen.repositorio.ClienteRepositorio;
import com.almacen.repositorio.OrdenDetalleRepositorio;
import com.almacen.repositorio.OrdenRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//@CrossOrigin(origins="http://localhost:4200/cliente", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AlmacenControlador {
      @Autowired
    private  OrdenRepositorio ordenRepositorio;
        @Autowired
    private  ArticuloRepositorio articuloRepositorio;
          @Autowired
    private  OrdenDetalleRepositorio ordenDetalleRepositorio;
            @Autowired
    private  ClienteRepositorio clienteRepositorio;


            

      @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }
    

     @PostMapping("/cliente")
     public Cliente guardarCliente(@RequestBody Cliente cliente){
         
         return clienteRepositorio.save(cliente);
     }

     
   @GetMapping("/clientes/{id}")
public ResponseEntity<Cliente> obtenerCliente(@PathVariable Long id) {
    Optional<Cliente> clienteOptional = clienteRepositorio.findById(id);
    if (clienteOptional.isPresent()) {
        Cliente cliente = clienteOptional.get();
        return ResponseEntity.ok(cliente);
    } else {
        return ResponseEntity.notFound().build();
    }
}
     

      
     
    @GetMapping("/ordenes")
    public List<Orden> listarOrdenes() {
        return ordenRepositorio.findAll();
    }
    
        @PostMapping("/orden")
     public Orden guardarOrden(@RequestBody Orden orden){
         return ordenRepositorio.save(orden);
     }
    
     

    @GetMapping("/articulos")
    public List<Articulo> listarArticulos() {
        return articuloRepositorio.findAll();
    }

    
         @PostMapping("/articulo")
     public Articulo guardarArticulo(@RequestBody Articulo articulo){
         
         return articuloRepositorio.save(articulo);
     }
    
    @GetMapping("/ordenes-detalles")
    public List<OrdenDetalle> listarOrdenesDetalles() {
        return ordenDetalleRepositorio.findAll();
    }
    
    
    @GetMapping("/ap")
    public String holaMundo() {
        return "Hola, mundo";
    }
}
