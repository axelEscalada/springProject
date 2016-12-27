package com.axel.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8612178620428064896L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false,unique=true)
	private Long id;
	
	@Column(nullable=false,length=30, unique=true)
	private String nombreUsuario;
	
	@Column(nullable=false, length=30)
	private String password;
		
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name = "idPersona") //Crea una columna en la tabla usuario con el nombre idPersona
	@JsonIgnore
	private Persona persona;
	
	//las relaciones OneToMany y ManyToMany son por defecto de tipo lazy
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval=true)
	@OrderBy("fecha DESC")
	@JsonIgnore //Ignora las publicaciones cuando las soliciten en la api rest
	private List<Publicacion> publicaciones = new ArrayList<>();
		
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnore
	private Imagen imagen;
	
	/*
	private List<Usuario> seguidores; //usuarios que me siguen
	
	private List<Usuario> siguiendo; //usuarios que sigo */

	public Usuario(){
		
	}

	public Usuario(String nombreUsuario, String password) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	
	public void setId(Long idUsuario) {
		this.id = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
	
	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", persona="
				+ persona + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null)
				return false;
		} else if (!nombreUsuario.equals(other.nombreUsuario))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
