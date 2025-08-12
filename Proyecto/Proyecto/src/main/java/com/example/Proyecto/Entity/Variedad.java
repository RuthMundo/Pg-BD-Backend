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
@Table(name = "variedad")

public class Variedad implements Serializable{
	
	private static final long serialVersionUID = 1L ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idvariedad")
	private Integer idvariedad;
	
	@Column(name = "orden_proceso")
	private Integer ordenProceso;
	
	@Column(name = "foundation")
	private Integer foundation;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "numero_bass")
	private Integer numeroBass;
	
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;
	
	@Column(name = "fecha_parado")
	private LocalDate fechaParado;
	
	@Column(name = "invernadero_idinvernadero")
	private Integer invernaderoIdinvernadero;
	
	@Column(name = "parental")
	private String parental;
	
	@Column(name = "cosecha_idcosecha")
	private Integer cosechaIdcosecha;

	public Integer getIdvariedad() {
		return idvariedad;
	}

	public void setIdvariedad(Integer idvariedad) {
		this.idvariedad = idvariedad;
	}

	public Integer getOrdenProceso() {
		return ordenProceso;
	}

	public void setOrdenProceso(Integer ordenProceso) {
		this.ordenProceso = ordenProceso;
	}

	public Integer getFoundation() {
		return foundation;
	}

	public void setFoundation(Integer foundation) {
		this.foundation = foundation;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getNumeroBass() {
		return numeroBass;
	}

	public void setNumeroBass(Integer numeroBass) {
		this.numeroBass = numeroBass;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaParado() {
		return fechaParado;
	}

	public void setFechaParado(LocalDate fechaParado) {
		this.fechaParado = fechaParado;
	}

	public Integer getInvernaderoIdinvernadero() {
		return invernaderoIdinvernadero;
	}

	public void setInvernaderoIdinvernadero(Integer invernaderoIdinvernadero) {
		this.invernaderoIdinvernadero = invernaderoIdinvernadero;
	}

	public String getParental() {
		return parental;
	}

	public void setParental(String parental) {
		this.parental = parental;
	}

	public Integer getCosechaIdcosecha() {
		return cosechaIdcosecha;
	}

	public void setCosechaIdcosecha(Integer cosechaIdcosecha) {
		this.cosechaIdcosecha = cosechaIdcosecha;
	}

	
}
