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
@Table(name = "enviomensaje")
public class Enviomensaje implements Serializable{
	
	private static final long serialVersionUID = 11L ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	
	@Column(name = "idenviomensaje")
	private Integer idenviomensaje;
	
	@Column(name = "mensaje")
	private String mensaje;
	
	@Column(name = "usuario_idusuario")
	private Integer usuarioIdusuario;
	
	@Column(name = "invernadero_idinvernadero")
	private Integer invernaderoIdinvernadero;

	public Integer getIdenviomensaje() {
		return idenviomensaje;
	}

	public void setIdenviomensaje(Integer idenviomensaje) {
		this.idenviomensaje = idenviomensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Integer getUsuarioIdusuario() {
		return usuarioIdusuario;
	}

	public void setUsuarioIdusuario(Integer usuarioIdusuario) {
		this.usuarioIdusuario = usuarioIdusuario;
	}

	public Integer getInvernaderoIdinvernadero() {
		return invernaderoIdinvernadero;
	}

	public void setInvernaderoIdinvernadero(Integer invernaderoIdinvernadero) {
		this.invernaderoIdinvernadero = invernaderoIdinvernadero;
	}
	
	

}
