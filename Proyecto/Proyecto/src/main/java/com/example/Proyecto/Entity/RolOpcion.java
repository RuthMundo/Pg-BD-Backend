package com.example.Proyecto.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol_opcion")
public class RolOpcion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -844819868493653468L;

	@EmbeddedId
	private RolOpcionId id;
	
	@Column(name="crear")
	private boolean crear;
	
	@Column(name="consultar")
	private boolean consultar;
	
	@Column(name="eliminar")
	private boolean eliminar;
	
	@Column(name="editar")
	private boolean editar;
	
	@Column(name="imprimir")
	private boolean imnprimir;
	
	@Column(name="exportar")
	private boolean exportar;

	public RolOpcionId getId() {
		return id;
	}

	public void setId(RolOpcionId id) {
		this.id = id;
	}

	public boolean isCrear() {
		return crear;
	}

	public void setCrear(boolean crear) {
		this.crear = crear;
	}

	public boolean isConsultar() {
		return consultar;
	}

	public void setConsultar(boolean consultar) {
		this.consultar = consultar;
	}

	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public boolean isImnprimir() {
		return imnprimir;
	}

	public void setImnprimir(boolean imnprimir) {
		this.imnprimir = imnprimir;
	}

	public boolean isExportar() {
		return exportar;
	}

	public void setExportar(boolean exportar) {
		this.exportar = exportar;
	}

	
	
	
}
