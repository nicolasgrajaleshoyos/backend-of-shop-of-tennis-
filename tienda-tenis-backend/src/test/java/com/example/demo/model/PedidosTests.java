package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PedidosTest {

    private Pedidos pedido;
    private Usuarios usuario;
    private List<Productos> productos;

    @BeforeEach
    void setUp() {
        usuario = new Usuarios();
        productos = new ArrayList<>();
        pedido = new Pedidos(5L, 100.0, productos, usuario);
    }

    @Test
    void testConstructor() {
        assertNotNull(pedido);
        assertEquals(5L, pedido.getCantidad());
        assertEquals(100.0, pedido.getPrecio_total());
        assertEquals(productos, pedido.getProductos());
        assertEquals(usuario, pedido.getUsuario());
    }

    @Test
    void testSetCantidad() {
        pedido.setCantidad(10L);
        assertEquals(10L, pedido.getCantidad());
    }

    @Test
    void testSetPrecio_total() {
        pedido.setPrecio_total(200.0);
        assertEquals(200.0, pedido.getPrecio_total());
    }

    @Test
    void testSetProductos() {
        List<Productos> newProductos = new ArrayList<>();
        pedido.setProductos(newProductos);
        assertEquals(newProductos, pedido.getProductos());
    }

    @Test
    void testSetUsuario() {
        Usuarios newUsuario = new Usuarios();
        pedido.setUsuario(newUsuario);
        assertEquals(newUsuario, pedido.getUsuario());
    }

    @Test
    void testSetId_pedido() {
        pedido.setId_pedido(1L);
        assertEquals(1L, pedido.getId_pedido());
    }
}
