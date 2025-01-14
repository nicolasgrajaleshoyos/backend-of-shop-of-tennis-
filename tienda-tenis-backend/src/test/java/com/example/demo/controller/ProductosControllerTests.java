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
import org.springframework.test.context.junit4.SpringRunner;


import com.example.demo.model.Productos;
import com.example.demo.repository.ProductosRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductosControllerTests {

    @Mock
    private ProductosRepository productosRepository;

    @InjectMocks
    private ProductosController productosController;

    @SuppressWarnings("deprecation")
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVerTodosLosProductos() {
        List<Productos> listaProductos = new ArrayList<>();
        // Agregar algunos productos a la lista
        // ...

        when(productosRepository.findAll()).thenReturn(listaProductos);

        List<Productos> productos = productosController.VerTodosLosProductos();

        assertNotNull(productos);
        assertEquals(listaProductos.size(), productos.size());
        // Puedes agregar más aserciones según sea necesario
    }

    @Test
    public void testCrearProducto() {
        Productos producto = new Productos();
        // Configurar el producto según sea necesario

        productosController.CrearProducto(producto);

        // Verificar que el método save del repositorio se llamó una vez con el producto correcto
        verify(productosRepository, times(1)).save(producto);
    }

    @Test
    public void testActualizarProductoExistente() {
        Productos productoExistente = new Productos();
        // Configurar el producto existente según sea necesario

        when(productosRepository.existsById(productoExistente.getId_producto())).thenReturn(true);

        ResponseEntity<String> response = productosController.ActualizarProducto(productoExistente);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Producto actualizado correctamente", response.getBody());
    }

    @Test
    public void testEliminarProducto() {
        Productos producto = new Productos();
        // Configurar el producto según sea necesario

        ResponseEntity<String> response = productosController.EliminarPedido(producto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Producto eliminado correctamente", response.getBody());
    }

    @Test
    public void testBuscarProducto() {
        String nombreProducto = "Nombre de Producto";

        Productos producto = new Productos();
        producto.setNombre(nombreProducto);

        when(productosRepository.findByNombre(nombreProducto)).thenReturn(producto);

        Productos productoEncontrado = productosController.verTodosLosProductos(nombreProducto);

        assertNotNull(productoEncontrado);
        assertEquals(nombreProducto, productoEncontrado.getNombre());
    }
}
