
package com.almacen.repositorio;

import com.almacen.modelo.OrdenDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenDetalleRepositorio extends JpaRepository<OrdenDetalle, Long> {
    // Puedes agregar métodos personalizados si necesitas realizar consultas específicas
}
