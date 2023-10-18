
package com.almacen.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "Orden")
public class Orden {

    @Id
    private String id;

    @Column(name = "fecha", length = 60, nullable = false)
    private Date fecha;


    
 @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id") // La columna "cliente_id" se relaciona con "id" en Cliente
    private Cliente cliente;
 
   public static String generarNumeroOrden() {
        // Aquí puedes implementar la lógica para generar el número de orden
        // Por ejemplo, puedes consultar la base de datos para obtener el último número de orden y calcular el siguiente
        // En este ejemplo, generamos un número de orden ficticio
        String nuevoNumeroOrden = "OC-000001";
        return nuevoNumeroOrden;
    }
       
    public Orden(String id, Date fecha, Cliente cliente) {
        super();
        this.id = id;
        this.fecha = fecha;
        this.cliente=cliente;
    }

    public Orden() {
        super();
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        // Incrementa el número
        int numero = Integer.parseInt(id.substring(3)) + 1;

        // Formatea el nuevo ID
        this.id = String.format("OC-%06d", numero);

    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
/*
      public static String generarNuevoNumeroOrden(String ultimoNumeroOrden) {
        if (ultimoNumeroOrden != null) {
            int numero = Integer.parseInt(ultimoNumeroOrden.substring(3)) + 1;
            return String.format("OC-%06d", numero);
        } else {
            return "OC-000001";
        }
    }
 */

}