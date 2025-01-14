package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carrito;
import com.example.demo.model.Productos;
import com.example.demo.repository.CarritoRepository;



@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:5173/")
public class CarritoController {

    @Autowired
    private CarritoRepository repository;
    
   

    @PostMapping("/items")
    public Optional<Carrito> getAllItems(@RequestBody Long id) {
        return repository.findById(id);
    }
   

    @PostMapping("/add")
    public ResponseEntity<Carrito> addItem(@RequestBody Carrito item) {
        try {
      
        	Carrito savedItem = repository.save(item);
            return ResponseEntity.ok(savedItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateItem(@RequestBody Carrito item) {
        try {
            repository.save(item);
            return ResponseEntity.ok("Item updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating item: " + e.getMessage());
        }
    }

    @PatchMapping("/add_product")
    public ResponseEntity<String> addProduct(@RequestBody Carrito item) {
        try {
            // Recibe el carrito actualizado del cuerpo de la solicitud
            Carrito carritoActualizado = repository.findById(item.getId_carrito()).orElse(null);

            if (carritoActualizado == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrito no encontrado");
            }

            // Verifica si el producto ya está en el carrito
            List<Productos> productosEnCarrito = carritoActualizado.getProductos();
            Productos nuevoProducto = item.getProductos().get(0);
            for (Productos producto : productosEnCarrito) {
                if (producto.getId_producto() == nuevoProducto.getId_producto()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El producto ya está en el carrito");
                }
            }

            // Agrega el nuevo producto al carrito
            carritoActualizado.getProductos().add(nuevoProducto);

            // Guarda el carrito actualizado en el repositorio
            repository.save(carritoActualizado);

            return ResponseEntity.ok("Producto agregado al carrito exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el carrito: " + e.getMessage());
        }
    }

    @PatchMapping("/remove_product")
    public ResponseEntity<String> removeProduct(@RequestParam Long carritoId, @RequestParam Long productoId) {
        try {
            // Recibe el carrito actualizado del cuerpo de la solicitud
            Carrito carritoActualizado = repository.findById(carritoId).orElse(null);

            if (carritoActualizado == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrito no encontrado");
            }

            // Verifica si el producto está en el carrito
            List<Productos> productosEnCarrito = carritoActualizado.getProductos();
            boolean productoEncontrado = false;
            for (Productos producto : productosEnCarrito) {
                if (producto.getId_producto() == productoId) {
                    // Elimina el producto del carrito
                    productosEnCarrito.remove(producto);
                    productoEncontrado = true;
                    break;
                }
            }

            if (!productoEncontrado) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El producto no está en el carrito");
            }

            // Guarda el carrito actualizado en el repositorio
            repository.save(carritoActualizado);

            return ResponseEntity.ok("Producto eliminado del carrito exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el carrito: " + e.getMessage());
        }
    }
    
    @DeleteMapping("/remove")
    public ResponseEntity<String> removeItem(@RequestBody Long itemId) {
        try {
            repository.deleteById(itemId);
            return ResponseEntity.ok("Item removed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error removing item: " + e.getMessage());
        }
    }
}
