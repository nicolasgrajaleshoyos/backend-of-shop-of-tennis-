package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuariosRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuariosControllerTests {

    @Mock
    private UsuariosRepository usuariosRepository;

    @InjectMocks
    private UsuariosController usuariosController;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @SuppressWarnings("deprecation")
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVerTodosLosUsuarios() {
        List<Usuarios> listaUsuarios = new ArrayList<>();
        // Agregar algunos usuarios a la lista
        // ...

        when(usuariosRepository.findAll()).thenReturn(listaUsuarios);

        List<Usuarios> usuarios = usuariosController.verTodosLosUsuarrios();

        assertNotNull(usuarios);
        assertEquals(listaUsuarios.size(), usuarios.size());
        // Puedes agregar más aserciones según sea necesario
    }

    @Test
    public void testGuardarUsuarios() {
        Usuarios usuario = new Usuarios();
        usuario.setEmail("example@example.com");
        usuario.setPassword("password");

        String passwordCifrada = "hashedPassword";
        when(passwordEncoder.encode(usuario.getPassword())).thenReturn(passwordCifrada);

        when(usuariosRepository.save(usuario)).thenReturn(usuario);

        ResponseEntity<Usuarios> response = usuariosController.guardarUsuarios(usuario);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(passwordCifrada, response.getBody().getPassword());
    }

    @Test
    public void testBorrarUsuarios() {
        Long cedula = 123456789L;

        ResponseEntity<String> response = usuariosController.borrarUsuarios(cedula);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Usuarios eliminados correctamente", response.getBody());
    }

    @Test
    public void testActualizarUsuarios() {
        Usuarios usuario = new Usuarios();
        usuario.setEmail("example@example.com");
        usuario.setPassword("password");

        ResponseEntity<String> response = usuariosController.actualizarUsuarios(usuario);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Usuarios actualizados correctamente", response.getBody());
    }

    @Test
    public void testBuscarUsuariosPorEmail() {
        String email = "example@example.com";
        Usuarios usuario = new Usuarios();
        usuario.setEmail(email);

        when(usuariosRepository.findByEmail(email)).thenReturn(usuario);

        Usuarios usuarioEncontrado = usuariosController.verUsuarios(email);

        assertNotNull(usuarioEncontrado);
        assertEquals(email, usuarioEncontrado.getEmail());
    }
}
