package com.example.demo.model;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pedidos")
public class Pedidos {

	  @Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private Long id_pedido;

	  @Column(nullable = false)
	  private Long cantidad;
	
	 @Column(nullable = false)
	  private double precio_total;
	 
	 @ManyToMany
	 @JoinTable(
	        name = "pedidos_productos",
	        joinColumns = @JoinColumn(name = "id_pedido"),
	        inverseJoinColumns = @JoinColumn(name = "id_producto")
	    )
	 private List<Productos> productos;
	 
	 @ManyToOne
	 @JoinColumn(name = "usuario_id")
	 private Usuarios usuario;
	

	public Pedidos(Long cantidad, double precio_total, List<Productos> productos, Usuarios usuario) {
		super();
		this.cantidad = cantidad;
		this.precio_total = precio_total;
		this.productos = productos;
		this.usuario = usuario;
	}


	public List<Productos> getProductos() {
		return productos;
	}


	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}



	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}


	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}


	public double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}


	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Pedidos() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	  
	    
}
