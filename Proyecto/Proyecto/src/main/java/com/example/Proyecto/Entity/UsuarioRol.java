package com.example.Proyecto.Entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_rol")
public class UsuarioRol implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 3626235405288636537L;
	
	@EmbeddedId
    private UsuarioRolId id;

	public UsuarioRolId getId() {
		return id;
	}

	public void setId(UsuarioRolId id) {
		this.id = id;
	}

}
