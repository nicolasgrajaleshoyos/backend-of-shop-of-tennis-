package com.example.demo.controller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.when;



import java.util.Optional;

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


import com.example.demo.model.Carrito;

import com.example.demo.repository.CarritoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarritoControllerTests {

    @Mock
    private CarritoRepository carritoRepository;

    @InjectMocks
    private CarritoController carritoController;

    @SuppressWarnings({ "deprecation" })
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllItems() {
        Long itemId = 1L;
        Carrito item = new Carrito();
        item.setId_carrito(itemId);

        when(carritoRepository.findById(itemId)).thenReturn(Optional.of(item));

        Optional<Carrito> result = carritoController.getAllItems(itemId);

        assertNotNull(result);
        assertEquals(itemId, result.get().getId_carrito());
    }

    @Test
    public void testAddItem() {
        Carrito item = new Carrito();
        item.setId_carrito(1L);

        when(carritoRepository.save(item)).thenReturn(item);

        ResponseEntity<Carrito> response = carritoController.addItem(item);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(item.getId_carrito(), response.getBody().getId_carrito());
    }

    // You can write similar tests for updateItem, addProduct, removeProduct, and removeItem methods
}
