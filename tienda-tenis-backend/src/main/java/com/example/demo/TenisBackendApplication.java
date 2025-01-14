package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Usuarios;
import com.example.demo.service.ServicioMiDetallesDeUsuario;

@SpringBootApplication
public class TenisBackendApplication implements CommandLineRunner{
	
	@Autowired  ServicioMiDetallesDeUsuario userDetailsService;
	

	
	public static void main(String[] args) {
		SpringApplication.run(TenisBackendApplication.class, args);	
	}

	@Override
	public void run(String... args) throws Exception {
		// Descomentar la linia 25 para crear el adminstrador
		//crearAdministrador();
	}

	public void crearAdministrador() {
		  String username = "camiloghs21@gmail.com";
	      String password = "1234";

	      Usuarios usuario = userDetailsService.crearAdministrador(username, password,"ADMIN");
	      System.out.println("Usuario creado: " + usuario.getEmail());
		
	}



}
