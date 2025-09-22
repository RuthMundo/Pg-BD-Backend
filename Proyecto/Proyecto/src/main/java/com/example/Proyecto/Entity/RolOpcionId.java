package com.example.Proyecto.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class RolOpcionId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -406190130757238967L;

	@Column(name = "rol_idrol")
	private Integer idRol;
	
	@Column(name = "opcion_idopcion")
	private Integer idOpcion;

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public Integer getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(Integer idOpcion) {
		this.idOpcion = idOpcion;
	}


	
}
