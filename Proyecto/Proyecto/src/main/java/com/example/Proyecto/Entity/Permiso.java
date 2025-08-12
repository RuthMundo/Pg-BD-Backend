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
@Table(name = "permiso")

public class Permiso implements Serializable {
	
	private static final long serialVersionUID = 3L ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idpermiso")
	private Integer idpermiso;
	
	@Column(name="crear")
	private String crear;
	
	@Column(name="consultar")
	private String consultar;
	
	@Column(name="eliminar")
	private String eliminar;
	
	@Column(name="editar")
	private String editar;
	
	@Column(name="modulo_idmodulo")
	private Integer moduloIdmodulo;
	
	@Column(name="rol_idrol")
	private Integer rolIdrol;
	
	

	public Integer getModuloIdmodulo() {
		return moduloIdmodulo;
	}

	public void setModuloIdmodulo(Integer moduloIdmodulo) {
		this.moduloIdmodulo = moduloIdmodulo;
	}

	public Integer getRolIdrol() {
		return rolIdrol;
	}

	public void setRolIdrol(Integer rolIdrol) {
		this.rolIdrol = rolIdrol;
	}

	public Integer getIdpermiso() {
		return idpermiso;
	}

	public void setIdpermiso(Integer idpermiso) {
		this.idpermiso = idpermiso;
	}

	public String getCrear() {
		return crear;
	}

	public void setCrear(String crear) {
		this.crear = crear;
	}

	public String getConsultar() {
		return consultar;
	}

	public void setConsultar(String consultar) {
		this.consultar = consultar;
	}

	public String getEliminar() {
		return eliminar;
	}

	public void setEliminar(String eliminar) {
		this.eliminar = eliminar;
	}

	public String getEditar() {
		return editar;
	}

	public void setEditar(String editar) {
		this.editar = editar;
	}
	

}
