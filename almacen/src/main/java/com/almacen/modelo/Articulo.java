
package com.almacen.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "Articulo")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;

    @Column(name = "precio_u", precision = 10, scale = 2, nullable = false)
    private Long precio_u;

    public Articulo(Long id, String nombre, Long precio_u) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.precio_u = precio_u;
    }
    
      public Articulo(String nombre, Long precio_u) {
        super();
        this.nombre = nombre;
        this.precio_u = precio_u;
    }
    
     public Articulo() {
        super();
    }
    
    public Long getID() {
        return id;
    }

    public void setID(Long id) {

      this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getArticulos() {
        return precio_u;
    }

    public void setArticulos(Long precio_U) {
        this.precio_u = precio_U;
    }

}
