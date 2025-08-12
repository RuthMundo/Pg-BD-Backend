package com.example.Proyecto.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reporte")
public class Reporte implements Serializable{
	
	private static final long serialVersionUID = 15L ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idreporte")
	private Integer idreporte;
	
	@Column(name = "fecha_reporte")
	private LocalDate fechaReporte;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	@Column(name = "variedad_idvariedad")
	private Integer variedadIdvariedad;

	public Integer getIdreporte() {
		return idreporte;
	}

	public void setIdreporte(Integer idreporte) {
		this.idreporte = idreporte;
	}

	public LocalDate getFechaReporte() {
		return fechaReporte;
	}

	public void setFechaReporte(LocalDate fechaReporte) {
		this.fechaReporte = fechaReporte;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getVariedadIdvariedad() {
		return variedadIdvariedad;
	}

	public void setVariedadIdvariedad(Integer variedadIdvariedad) {
		this.variedadIdvariedad = variedadIdvariedad;
	}
	
	

}
