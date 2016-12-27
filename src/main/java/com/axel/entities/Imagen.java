package com.axel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.jdbc.Blob;

@Entity
public class Imagen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3154537152782395304L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;
	
	@Lob
	@Column(nullable = false)
	private byte[] foto;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario", nullable = false)
	@JsonIgnore
	private Usuario usuario;
	
	public Imagen(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
	
	
}
