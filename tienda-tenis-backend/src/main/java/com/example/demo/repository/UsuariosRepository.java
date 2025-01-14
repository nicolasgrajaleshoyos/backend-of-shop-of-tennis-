package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Usuarios;




@RepositoryRestResource
public interface UsuariosRepository extends JpaRepository<Usuarios,Long>{

	Usuarios findByEmail(String email);

}

