package com.example.Proyecto.Entity;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario implements Serializable{
	
	private static final long serialVersionUID = 8L ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idcomentario")
	private Integer idcomentario;
	
	@Column(name = "nombre_completo")
	private String nombreCompleto;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "codigo_trabajador")
	private Integer codigoTrabajador;
	
	@Column(name = "usuario_idusuario")
	private Integer usuarioIdusuario;

	public Integer getIdcomentario() {
		return idcomentario;
	}

	public void setIdcomentario(Integer idcomentario) {
		this.idcomentario = idcomentario;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCodigoTrabajador() {
		return codigoTrabajador;
	}

	public void setCodigoTrabajador(Integer codigoTrabajador) {
		this.codigoTrabajador = codigoTrabajador;
	}

	public Integer getUsuarioIdusuario() {
		return usuarioIdusuario;
	}

	public void setUsuarioIdusuario(Integer usuarioIdusuario) {
		this.usuarioIdusuario = usuarioIdusuario;
	}
	
	

}
