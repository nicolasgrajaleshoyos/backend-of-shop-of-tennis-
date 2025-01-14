package com.example.demo.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;



public class UsuariosTests {

    private Usuarios usuario;

    @Before
    public void setUp() {
        usuario = new Usuarios();
    }

    @Test
    public void testSetAndGetIdUsuario() {
        Long idUsuario = 1L;
        usuario.setId_usuario(idUsuario);

        assertEquals(idUsuario, usuario.getId_usuario());
    }

    @Test
    public void testSetAndGetEmail() {
        String email = "example@example.com";
        usuario.setEmail(email);

        assertEquals(email, usuario.getEmail());
    }

    @Test
    public void testSetAndGetPassword() {
        String password = "password123";
        usuario.setPassword(password);

        assertEquals(password, usuario.getPassword());
    }

    @Test
    public void testSetAndGetTipoDeUsuario() {
        String tipoUsuario = "ADMIN";
        usuario.setTipo_de_usuario(tipoUsuario);

        assertEquals(tipoUsuario, usuario.getTipo_de_usuario());
    }

    @Test
    public void testSetAndGetUsuariosInfo() {
        UsuariosInfo info = new UsuariosInfo();
        usuario.setUsuariosInfo(info);

        assertNotNull(usuario.getUsuariosInfo());
    }

    @Test
    public void testSetAndGetCarrito() {
        Carrito carrito = new Carrito();
        usuario.setCarrito(carrito);

        assertNotNull(usuario.getCarrito());
    }

    @Test
    public void testConstructorWithParameters() {
        String email = "example@example.com";
        String password = "password123";
        String tipoUsuario = "USER";
        UsuariosInfo info = new UsuariosInfo();
        Carrito carrito = new Carrito();

        Usuarios usuarioConParametros = new Usuarios(email, password, tipoUsuario, info, carrito);

        assertEquals(email, usuarioConParametros.getEmail());
        assertEquals(password, usuarioConParametros.getPassword());
        assertEquals(tipoUsuario, usuarioConParametros.getTipo_de_usuario());
        assertNotNull(usuarioConParametros.getUsuariosInfo());
        assertNotNull(usuarioConParametros.getCarrito());
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(usuario);
    }
}
