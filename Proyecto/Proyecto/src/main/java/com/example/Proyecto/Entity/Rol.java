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
@Table(name = "rol")

public class Rol  implements Serializable{
	private static final long serialVersionUID = 1L ;
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Basic(optional = false)
@Column(name = "idrol")
private Integer idrol;

@Column(name="nombre_rol")
private String nombreRol;

public Integer getIdrol() {
	return idrol;
}

public void setIdrol(Integer idrol) {
	this.idrol = idrol;
}

public String getNombreRol() {
	return nombreRol;
}

public void setNombreRol(String nombreRol) {
	this.nombreRol = nombreRol;
}


}
