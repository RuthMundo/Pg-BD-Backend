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
@Table(name = "bolsa_de_semilla")
public class Bolsadesemilla implements Serializable{
	
	private static final long serialVersionUID = 5L ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idbolsa_de_semilla")
	private Integer idbolsaDeSemilla;
	
	@Column(name="cantidad_semilla")
	private String cantidadSemilla;
	
	@Column(name="calidad_semilla")
	private String calidadSemilla;
	
	@Column(name="usuario_idusuario")
	private Integer usuarioIdusuario;
	
	@Column(name="variedad_idvariedad")
	private Integer variedadIdvariedad;
	
	@Column(name="invernadero_idinvernadero")
	private Integer invernaderoIdinvernadero;
	
	@Column(name="fecha_recepcion")
	private String fechaRecepcion;
	

	public Integer getUsuarioIdusuario() {
		return usuarioIdusuario;
	}

	public void setUsuarioIdusuario(Integer usuarioIdusuario) {
		this.usuarioIdusuario = usuarioIdusuario;
	}

	public Integer getVariedadIdvariedad() {
		return variedadIdvariedad;
	}

	public void setVariedadIdvariedad(Integer variedadIdvariedad) {
		this.variedadIdvariedad = variedadIdvariedad;
	}

	public Integer getInvernaderoIdinvernadero() {
		return invernaderoIdinvernadero;
	}

	public void setInvernaderoIdinvernadero(Integer invernaderoIdinvernadero) {
		this.invernaderoIdinvernadero = invernaderoIdinvernadero;
	}

	public Integer getIdbolsaDeSemilla() {
		return idbolsaDeSemilla;
	}

	public void setIdbolsaDeSemilla(Integer idbolsaDeSemilla) {
		this.idbolsaDeSemilla = idbolsaDeSemilla;
	}

	public String getCantidadSemilla() {
		return cantidadSemilla;
	}

	public void setCantidadSemilla(String cantidadSemilla) {
		this.cantidadSemilla = cantidadSemilla;
	}

	public String getCalidadSemilla() {
		return calidadSemilla;
	}

	public void setCalidadSemilla(String calidadSemilla) {
		this.calidadSemilla = calidadSemilla;
	}

	public String getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(String fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	
	


}
