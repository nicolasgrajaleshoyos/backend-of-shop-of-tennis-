package com.example.demo.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



public class CarritoTests {

    private Carrito carrito;

    @Before
    public void setUp() {
        carrito = new Carrito();
    }

    @Test
    public void testSetAndGetIdCarrito() {
        Long idCarrito = 1L;
        carrito.setId_carrito(idCarrito);

        assertEquals(idCarrito, carrito.getId_carrito());
    }

    @Test
    public void testSetAndgetCantidadDeProductos() {
        long cantidadProductos = 5;
        carrito.setCantidad_de_productos(cantidadProductos);

        assertEquals(cantidadProductos, carrito.getCantidad_de_productos());
    }

    @Test
    public void testSetAndGetTotal() {
        Long total = 100L;
        carrito.setTotal(total);

        assertEquals(total, carrito.getTotal());
    }

    @Test
    public void testSetAndGetProductos() {
        List<Productos> productos = new ArrayList<>();
        productos.add(new Productos(null, "Producto1", null, null, null, null, 0));
        productos.add(new Productos(null, "Producto2", null, null, null, null, 0));
        carrito.setProductos(productos);

        assertNotNull(carrito.getProductos());
        assertEquals(productos.size(), carrito.getProductos().size());
        assertEquals("Producto1", carrito.getProductos().get(0).getNombre());
        assertEquals("Producto2", carrito.getProductos().get(1).getNombre());
    }

    @Test
    public void testConstructorWithParameters() {
        long cantidadProductos = 3;
        Long total = 150L;
        List<Productos> productos = new ArrayList<>();
        productos.add(new Productos(total, "Producto1", total, null, null, null, total));
        productos.add(new Productos(total, "Producto2", total, null, null, null, total));

        Carrito carritoConParametros = new Carrito(cantidadProductos, total, productos);

        assertEquals(cantidadProductos, carritoConParametros.getCantidad_de_productos());
        assertEquals(total, carritoConParametros.getTotal());
        assertEquals(productos.size(), carritoConParametros.getProductos().size());
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(carrito);
    }
}
