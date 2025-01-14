package com.example.demo.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class ProductosTests {

    private Productos producto;

    @Before
    public void setUp() {
        producto = new Productos();
    }

    @Test
    public void testSetAndGetIdProducto() {
        Long idProducto = 1L;
        producto.setId_producto(idProducto);

        assertEquals(idProducto, producto.getId_producto());
    }

    @Test
    public void testSetAndGetNombre() {
        String nombre = "Camiseta";
        producto.setNombre(nombre);

        assertEquals(nombre, producto.getNombre());
    }

    @Test
    public void testSetAndGetTalla() {
        Long talla = 42L;
        producto.setTalla(talla);

        assertEquals(talla, producto.getTalla());
    }

    @Test
    public void testSetAndGetColor() {
        String color = "Rojo";
        producto.setColor(color);

        assertEquals(color, producto.getColor());
    }

    @Test
    public void testSetAndGetImagen() {
        String imagen = "imagen.jpg";
        producto.setImagen(imagen);

        assertEquals(imagen, producto.getImagen());
    }

    @Test
    public void testSetAndGetDescripcion() {
        String descripcion = "Camiseta de algodón";
        producto.setDescripcion(descripcion);

        assertEquals(descripcion, producto.getDescripcion());
    }

    @Test
    public void testSetAndGetPrecio() {
        double precio = 25.99;
        producto.setPrecio(precio);

        assertEquals(precio, producto.getPrecio(), 0.001);
    }


    @Test
    public void testConstructorWithParameters() {
        Long idProducto = 1L;
        String nombre = "Camiseta";
        Long talla = 42L;
        String color = "Rojo";
        String imagen = "imagen.jpg";
        String descripcion = "Camiseta de algodón";
        double precio = 25.99;
        List<Carrito> carritos = new ArrayList<>();
        Carrito carrito = new Carrito();
        carritos.add(carrito);

        Productos productoConParametros = new Productos(idProducto, nombre, talla, color, imagen, descripcion, precio);

        assertEquals(idProducto, productoConParametros.getId_producto());
        assertEquals(nombre, productoConParametros.getNombre());
        assertEquals(talla, productoConParametros.getTalla());
        assertEquals(color, productoConParametros.getColor());
        assertEquals(imagen, productoConParametros.getImagen());
        assertEquals(descripcion, productoConParametros.getDescripcion());
        assertEquals(precio, productoConParametros.getPrecio(), 0.001);

    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(producto);
    }
}
