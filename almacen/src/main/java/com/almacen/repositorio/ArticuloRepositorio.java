
package com.almacen.repositorio;

import com.almacen.modelo.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticuloRepositorio extends JpaRepository<Articulo, Long> {

}

