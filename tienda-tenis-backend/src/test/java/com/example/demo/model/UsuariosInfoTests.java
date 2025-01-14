package com.example.demo.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;


public class UsuariosInfoTests {

    private UsuariosInfo usuariosInfo;

    @Before
    public void setUp() {
        usuariosInfo = new UsuariosInfo();
    }


    @Test
    public void testSetAndGetNombre() {
        String nombre = "Juan";
        usuariosInfo.setNombre(nombre);

        assertEquals(nombre, usuariosInfo.getNombre());
    }

    @Test
    public void testSetAndGetApellidos() {
        String apellidos = "Pérez García";
        usuariosInfo.setApellidos(apellidos);

        assertEquals(apellidos, usuariosInfo.getApellidos());
    }

    @Test
    public void testSetAndGetTelefono() {
        Long telefono = 123456789L;
        usuariosInfo.setTelefono(telefono);

        assertEquals(telefono, usuariosInfo.getTelefono());
    }

    @Test
    public void testSetAndGetEdad() {
        Integer edad = 30;
        usuariosInfo.setEdad(edad);

        assertEquals(edad, usuariosInfo.getEdad());
    }

    @Test
    public void testConstructorWithParameters() {
        String nombre = "María";
        String apellidos = "González López";
        Long telefono = 987654321L;
        Integer edad = 25;

        UsuariosInfo usuariosInfoConParametros = new UsuariosInfo(nombre, apellidos, telefono, edad);

        assertEquals(nombre, usuariosInfoConParametros.getNombre());
        assertEquals(apellidos, usuariosInfoConParametros.getApellidos());
        assertEquals(telefono, usuariosInfoConParametros.getTelefono());
        assertEquals(edad, usuariosInfoConParametros.getEdad());
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(usuariosInfo);
    }
}
