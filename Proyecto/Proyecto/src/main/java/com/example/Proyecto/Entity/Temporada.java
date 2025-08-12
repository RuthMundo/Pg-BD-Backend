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
@Table(name = "temporada")
public class Temporada implements Serializable{
	private static final long serialVersionUID = 16L ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idtemporada")
	private Integer idtemporada;
	
	@Column(name = "year")
	private Integer year;
	
	@Column(name = "mes")
	private Integer mes;
	
	@Column(name = "temporada")
	private String temporada;

	public Integer getIdtemporada() {
		return idtemporada;
	}

	public void setIdtemporada(Integer idtemporada) {
		this.idtemporada = idtemporada;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	
	
	

}
