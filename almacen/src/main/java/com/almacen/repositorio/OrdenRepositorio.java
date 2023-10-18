
package com.almacen.repositorio;

import com.almacen.modelo.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdenRepositorio extends JpaRepository<Orden, Long> {

    @Query("SELECT o.id FROM Orden o ORDER BY o.id DESC")
    String findMaxNumeroOrden();
}

