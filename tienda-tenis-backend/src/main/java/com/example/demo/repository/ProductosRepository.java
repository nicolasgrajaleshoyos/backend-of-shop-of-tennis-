package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Productos;


@RepositoryRestResource
public interface ProductosRepository extends JpaRepository<Productos, Long> {

    @Query(value = "SELECT * FROM productos WHERE nombre = :nombre", nativeQuery = true)
    Productos findByNombre(@Param("nombre") String nombre);
}
