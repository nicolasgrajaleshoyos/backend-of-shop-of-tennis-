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

import com.example.demo.model.Pedidos;
import com.example.demo.repository.PedidosRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidosControllerTests {

    @Mock
    private PedidosRepository pedidoRepository;

    @InjectMocks
    private PedidosController pedidoController;

    @SuppressWarnings("deprecation")
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVerTodosLosPedidos() {
        List<Pedidos> listaPedidos = new ArrayList<>();
        // Agregar algunos pedidos a la lista
        // ...

        when(pedidoRepository.findAll()).thenReturn(listaPedidos);

        List<Pedidos> pedidos = pedidoController.VerTodosLosPedidos();

        assertNotNull(pedidos);
        assertEquals(listaPedidos.size(), pedidos.size());
        // Puedes agregar más aserciones según sea necesario
    }

    @Test
    public void testCrearPedido() {
        Pedidos pedido = new Pedidos();
        // Configurar el pedido según sea necesario

        pedidoController.CrearPedido(pedido);

        // Verificar que el método save del repositorio se llamó una vez con el pedido correcto
        verify(pedidoRepository, times(1)).save(pedido);
    }

    @Test
    public void testActualizarPedidoExistente() {
        Pedidos pedidoExistente = new Pedidos();
        // Configurar el pedido existente según sea necesario

        when(pedidoRepository.existsById(pedidoExistente.getId_pedido())).thenReturn(true);

        ResponseEntity<String> response = pedidoController.ActualizarPedido(pedidoExistente);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Pedido actualizado correctamente", response.getBody());
    }

    @Test
    public void testEliminarPedido() {
        Pedidos pedido = new Pedidos();
        // Configurar el pedido según sea necesario

        ResponseEntity<String> response = pedidoController.EliminarPedido(pedido);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Pedido eliminado correctamente", response.getBody());
    }
}
