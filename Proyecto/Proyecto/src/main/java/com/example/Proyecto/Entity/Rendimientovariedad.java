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
@Table(name = "rendimientoVariedad")
public class Rendimientovariedad implements Serializable{
	private static final long serialVersionUID = 14L ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idrendimiento_variedad")
	private Integer idrendimientoVariedad;
	
	@Column(name = "numero_bancas")
	private Integer numeroBancas;
	
	@Column(name = "rendimiento_total")
	private Integer rendimientoTotal;
	
	@Column(name = "variedad_idvariedad")
	private Integer variedadIdvariedad;


	public Integer getIdrendimientoVariedad() {
		return idrendimientoVariedad;
	}

	public void setIdrendimientoVariedad(Integer idrendimientoVariedad) {
		this.idrendimientoVariedad = idrendimientoVariedad;
	}

	public Integer getVariedadIdvariedad() {
		return variedadIdvariedad;
	}

	public void setVariedadIdvariedad(Integer variedadIdvariedad) {
		this.variedadIdvariedad = variedadIdvariedad;
	}

	public Integer getNumeroBancas() {
		return numeroBancas;
	}

	public void setNumeroBancas(Integer numeroBancas) {
		this.numeroBancas = numeroBancas;
	}

	public Integer getRendimientoTotal() {
		return rendimientoTotal;
	}

	public void setRendimientoTotal(Integer rendimientoTotal) {
		this.rendimientoTotal = rendimientoTotal;
	}


	
	

}
