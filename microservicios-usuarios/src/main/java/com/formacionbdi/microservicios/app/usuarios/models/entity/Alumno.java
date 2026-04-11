package com.formacionbdi.microservicios.app.usuarios.models.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="alumnos")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nombre;
	private String apellido;
	private String email;
	
	@CollectionTable(name = "create_at")
	/*@Temporal(TemporalType.TIMESTAMP) Antiguamente, en Java se utilizaba la clase java.util.Date o java.util.Calendar. 
	 * Como estas clases no eran muy precisas con los tipos de SQL, necesitábamos @Temporal para decirle a la base de datos si queríamos guardar solo la fecha, solo la hora, o ambas (timestamp).
	 * Desde Java 8, se introdujo el Java Time API (java.time), que es mucho más robusto. Las versiones recientes de Hibernate y JPA ahora prefieren que uses estas nuevas clases, las cuales no necesitan la anotación @Temporal. */
	private LocalDateTime createAt;
	
	@PrePersist
	public void oreOersist() {
		this.createAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	

	
	
}
