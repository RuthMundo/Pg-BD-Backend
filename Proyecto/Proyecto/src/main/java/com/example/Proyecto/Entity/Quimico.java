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
@Table(name = "quimico")
public class Quimico implements Serializable{
	private static final long serialVersionUID = 13L ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idquimico")
	private Integer idquimico;
	
	@Column(name = "nombre_quimico")
	private String nombreQuimico;
	
	@Column(name = "fecha_fumigacion")
	private Integer fechaFumigacion;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "invernadero_idinvernadero")
	private Integer invernaderoIdinvernadero;

	public Integer getIdquimico() {
		return idquimico;
	}

	public void setIdquimico(Integer idquimico) {
		this.idquimico = idquimico;
	}

	public String getNombreQuimico() {
		return nombreQuimico;
	}

	public void setNombreQuimico(String nombreQuimico) {
		this.nombreQuimico = nombreQuimico;
	}

	public Integer getFechaFumigacion() {
		return fechaFumigacion;
	}

	public void setFechaFumigacion(Integer fechaFumigacion) {
		this.fechaFumigacion = fechaFumigacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getInvernaderoIdinvernadero() {
		return invernaderoIdinvernadero;
	}

	public void setInvernaderoIdinvernadero(Integer invernaderoIdinvernadero) {
		this.invernaderoIdinvernadero = invernaderoIdinvernadero;
	}
	
	
	
	
}
