package com.example.demo.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios {
	
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id_usuario;


@Email(message = "Por favor, introduce una dirección de correo electrónico válida")
@Column(nullable = false,unique=true)
private String email;
 
 @Column(nullable = false)
 private String password;

 @Column(nullable = false)
 private String tipo_de_usuario;

 @OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name = "id_usuarioInfo", referencedColumnName = "id_usuarioInfo")
 private UsuariosInfo usuariosInfo;
 
 @OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name = "id_carrito", referencedColumnName = "id_carrito")
 private Carrito carrito;


 public Long getId_usuario() {
    
    return id_usuario;
}


public void setId_usuario(Long id_usuario) {
    this.id_usuario = id_usuario;
}


public UsuariosInfo getUsuariosInfo() {
	return usuariosInfo;
}


public void setUsuariosInfo(UsuariosInfo usuariosInfo) {
	this.usuariosInfo = usuariosInfo;
}


public Carrito getCarrito() {
	return carrito;
}


public void setCarrito(Carrito carrito) {
	this.carrito = carrito;
}


public Usuarios() {
    super();
}




public Usuarios(@Email(message = "Por favor, introduce una dirección de correo electrónico válida") String email,
		String password, String tipo_de_usuario,
		UsuariosInfo usuariosInfo, Carrito carrito) {
	super();
	this.email = email;
	this.password = password;
	this.tipo_de_usuario = tipo_de_usuario;

	this.usuariosInfo = usuariosInfo;
	this.carrito = carrito;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}

public String getTipo_de_usuario() {
    return tipo_de_usuario;
}


public void setTipo_de_usuario(String tipo_de_usuario) {
    this.tipo_de_usuario = tipo_de_usuario;
}


}


