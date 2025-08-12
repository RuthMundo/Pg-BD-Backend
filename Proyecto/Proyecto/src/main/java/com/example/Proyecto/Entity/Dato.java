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
@Table(name = "dato")
public class Dato implements Serializable{
	
	private static final long serialVersionUID = 10L ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "iddato")
	private Integer iddato;
	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "temporada_idtemporada")
	private Integer temporadaIdtemporada;
	
	@Column(name = "variedad_idvariedad")
	private Integer variedadIdvariedad;

	public Integer getIddato() {
		return iddato;
	}

	public void setIddato(Integer iddato) {
		this.iddato = iddato;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getTemporadaIdtemporada() {
		return temporadaIdtemporada;
	}

	public void setTemporadaIdtemporada(Integer temporadaIdtemporada) {
		this.temporadaIdtemporada = temporadaIdtemporada;
	}

	public Integer getVariedadIdvariedad() {
		return variedadIdvariedad;
	}

	public void setVariedadIdvariedad(Integer variedadIdvariedad) {
		this.variedadIdvariedad = variedadIdvariedad;
	}
	
	
	
	

}
