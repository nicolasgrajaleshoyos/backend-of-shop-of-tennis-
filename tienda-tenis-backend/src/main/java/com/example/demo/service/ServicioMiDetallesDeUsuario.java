package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuariosRepository;

import java.util.Collections; 

@Service
public class ServicioMiDetallesDeUsuario implements UserDetailsService {

    @Autowired
    private UsuariosRepository repositorioAdministrador;

    private final PasswordEncoder passwordEncoder;

    ServicioMiDetallesDeUsuario(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios user = repositorioAdministrador.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())    
                .password(user.getPassword()) 
                .authorities(Collections.emptyList())
                .build();
    }
    
    public Usuarios crearAdministrador(String username, String password,String tipo) {
    	Usuarios usuario = new Usuarios();
        usuario.setEmail(username);
        usuario.setTipo_de_usuario(tipo);

        usuario.setPassword( passwordEncoder.encode(password));
       
   
       return repositorioAdministrador.save(usuario);
    }
    
}