package com.example.Proyecto.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class UsuarioRolId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2442781841451377243L;
	
	@Column(name = "usuario_idusuario")
	private Integer idUsuario;
	
	@Column(name = "rol_idrol")
	private Integer idRol;



	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	
	

}
