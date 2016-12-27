package com.axel.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Publicacion implements Serializable, Comparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8027657552684725480L;

	@Transient
	private final int MAX_CONT = 200;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false,unique=true)
	private Long id;
	
	@Column(nullable = false, length = MAX_CONT)
	private String contenido;
	
	@Column(nullable = false)
	private Date fecha;
	
	/*el fetch de tipo lazy hace q cuando se haga un select de un o varios usuarios no llame a todas las
	publicaciones hasta q las publicaciones sean llamadas explicitamente*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario", nullable = false)
	@JsonIgnore
	private Usuario usuario;
	
	public Publicacion(){
		
	}

	public Publicacion(String contenido, Usuario usuario) {
		this.contenido = contenido;
		this.fecha = new Date();
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Publicacion [id=" + id + ", contenido=" + contenido + ", fecha=" + fecha + ", usuario=" + usuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contenido == null) ? 0 : contenido.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Publicacion other = (Publicacion) obj;
		if (contenido == null) {
			if (other.contenido != null)
				return false;
		} else if (!contenido.equals(other.contenido))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object p) {
		Publicacion pb = (Publicacion) p;
		int e = this.fecha.compareTo(pb.getFecha());
		return e; 
	}	
	
}
