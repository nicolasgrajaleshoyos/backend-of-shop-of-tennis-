package com.example.demo.model;



import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Productos {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id_producto;
 @Column(nullable = false)
 private String nombre;
 @Column(nullable = false)
 private Long talla;
 @Column(nullable = false)
 private String color;
 @Column(nullable = false)
 private String imagen;
@Column(nullable = false, columnDefinition = "TEXT")
 private String descripcion;
 @Column(nullable = false)
 private double precio;

 @ManyToMany(mappedBy = "productos")
 private List<Carrito> carritos;
 
 @ManyToMany(mappedBy = "productos")
 private List<Pedidos> pedidos; 
 
public Long getId_producto() {
	return id_producto;
}
public void setId_producto(Long id_producto) {
	this.id_producto = id_producto;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}


public Long getTalla() {
	return talla;
}
public void setTalla(Long talla) {
	this.talla = talla;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getImagen() {
	return imagen;
}
public void setImagen(String imagen) {
	this.imagen = imagen;
}


public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}


public Productos(Long id_producto, String nombre, Long talla, String color, String imagen, String descripcion,
		double precio) {
	super();
	this.id_producto = id_producto;
	this.nombre = nombre;
	this.talla = talla;
	this.color = color;
	this.imagen = imagen;
	this.descripcion = descripcion;
	this.precio = precio;
}
public Productos() {
	super();
	// TODO Auto-generated constructor stub
}

 

 
}
