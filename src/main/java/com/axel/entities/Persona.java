package com.axel.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3164008341198096446L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false,unique=true)
	private Long id;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String apellido;
	
	@Column(nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
	@Column
	private String trabajo;
	
	@OneToOne(mappedBy = "persona", fetch = FetchType.LAZY) 
	private Usuario usuario;
	
	public Persona(){
		
	}
	
	public Persona(String nombre, String apellido, Date fechaNacimiento, String trabajo, Usuario usuario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.trabajo = trabajo;
	}

	public Persona(Long id, String nombre, String apellido, Date fechaNacimiento, String trabajo, Usuario usuario) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.trabajo = trabajo;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", trabajo=" + trabajo + ", usuario= " + usuario.getId() +"]";
	}
	
}
