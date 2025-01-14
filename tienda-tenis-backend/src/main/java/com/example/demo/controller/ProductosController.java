package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Productos;
import com.example.demo.repository.ProductosRepository;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins="http://localhost:5173/")
public class ProductosController {
	
	@Autowired
	 private  ProductosRepository ProductoRepositorio;
	  
	  @GetMapping("/ver_todos")
	  public List<Productos> VerTodosLosProductos(){
		  return ProductoRepositorio.findAll();
	  }
	  
	  @PostMapping("/crear")
	  public void  CrearProducto(@RequestBody Productos producto) {
		  ProductoRepositorio.save(producto);
	  }
	  
	  @PostMapping("/actualizar")
	  public ResponseEntity<String> ActualizarProducto(@RequestBody Productos producto) {
	      // Verificar si el pedido existe en la base de datos
	      if (!ProductoRepositorio.existsById(producto.getId_producto())) {
	          return ResponseEntity.notFound().build(); // Devolver respuesta 404 si el pedido no existe
	      }
	      
	      // El pedido existe, por lo que procedemos a actualizarlo
	      ProductoRepositorio.save(producto);
	      
	      return ResponseEntity.ok("Producto actualizado correctamente");
	  }
	  
	  @PostMapping("/eliminar")
	  public ResponseEntity<String> EliminarPedido(@RequestBody Productos producto) {
	     try {
	    	 
	    	 ProductoRepositorio.delete(producto);
		      return ResponseEntity.ok("Producto eliminado correctamente");
		} catch (Exception e) {
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al Eliminar producto "+e.getMessage());
		}
	      
	      
	  }
	  @PostMapping("/buscar")
	    public  Productos verTodosLosProductos(@RequestBody String nombre) {
	        Productos productoOptional = ProductoRepositorio.findByNombre(nombre);
	       
	            return productoOptional;
	    }
	  

}
