
package com.almacen.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrdenDetalle {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
     @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;
    
     public OrdenDetalle() {
        // Constructor sin argumentos
    }
     
     public OrdenDetalle(Orden orden, Articulo articulo) {
    this.orden = orden;
    this.articulo = articulo;
    // Inicializa otros atributos si es necesario
}

public OrdenDetalle(Long id, Orden orden, Articulo articulo) {
    this.id = id;
    this.orden = orden;
    this.articulo = articulo;
    // Inicializa otros atributos si es necesario
}
    
       // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
