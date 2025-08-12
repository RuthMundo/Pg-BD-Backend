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
@Table(name = "cosecha")
public class Cosecha implements Serializable{
	
	private static final long serialVersionUID = 9L ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idcosecha")
	private Integer idcosecha;
	
	@Column(name = "fecha_de_siembra")
	private Integer fechaDeSiembra;
	
	@Column(name = "cantidad")
	private String cantidad;

	public Integer getIdcosecha() {
		return idcosecha;
	}

	public void setIdcosecha(Integer idcosecha) {
		this.idcosecha = idcosecha;
	}

	public Integer getFechaDeSiembra() {
		return fechaDeSiembra;
	}

	public void setFechaDeSiembra(Integer fechaDeSiembra) {
		this.fechaDeSiembra = fechaDeSiembra;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
