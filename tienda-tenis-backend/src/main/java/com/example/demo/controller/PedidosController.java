package com.example.demo.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pedidos;
import com.example.demo.repository.PedidosRepository;


@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins="http://localhost:5173/")
public class PedidosController {

	@Autowired
	 private  PedidosRepository PedidoRepositorio;
	  
	  @GetMapping("/ver_todos")
	  public List<Pedidos> VerTodosLosPedidos(){
		  return PedidoRepositorio.findAll();
	  }
	  
	  @PatchMapping("/crear")
	  public void CrearPedido(@RequestBody Pedidos pedido) { 
	      PedidoRepositorio.save(pedido);
	      
	  }
	  
	  @PostMapping("/actualizar")
	  public ResponseEntity<String> ActualizarPedido(@RequestBody Pedidos pedido) {
	      // Verificar si el pedido existe en la base de datos
	      if (!PedidoRepositorio.existsById(pedido.getId_pedido())) {
	          return ResponseEntity.notFound().build(); // Devolver respuesta 404 si el pedido no existe
	      }
	      
	      // El pedido existe, por lo que procedemos a actualizarlo
	      PedidoRepositorio.save(pedido);
	      
	      return ResponseEntity.ok("Pedido actualizado correctamente");
	  }
	  
	  @PostMapping("/eliminar")
	  public ResponseEntity<String> EliminarPedido(@RequestBody Pedidos pedido) {
	     try {
	    	 
		      PedidoRepositorio.delete(pedido);
		      return ResponseEntity.ok("Pedido eliminado correctamente");
		} catch (Exception e) {
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al Eliminar pedido "+e.getMessage());
		}
	      
	      
	  }

}
