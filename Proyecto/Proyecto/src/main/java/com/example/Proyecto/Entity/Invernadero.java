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
@Table(name = "invernadero")
public class Invernadero implements Serializable{
	
	private static final long serialVersionUID = 12L ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idinvernadero")
	private Integer idinvernadero;
	
	@Column(name = "numero_invernadero")
	private Integer numeroInvernadero;
	
	@Column(name = "cultivo")
	private String cultivo;
	
	@Column(name = "cosecha_idcosecha")
	private Integer cosechaIdcosecha;

	public Integer getIdinvernadero() {
		return idinvernadero;
	}

	public void setIdinvernadero(Integer idinvernadero) {
		this.idinvernadero = idinvernadero;
	}

	public Integer getNumeroInvernadero() {
		return numeroInvernadero;
	}

	public void setNumeroInvernadero(Integer numeroInvernadero) {
		this.numeroInvernadero = numeroInvernadero;
	}

	public String getCultivo() {
		return cultivo;
	}

	public void setCultivo(String cultivo) {
		this.cultivo = cultivo;
	}

	public Integer getCosechaIdcosecha() {
		return cosechaIdcosecha;
	}

	public void setCosechaIdcosecha(Integer cosechaIdcosecha) {
		this.cosechaIdcosecha = cosechaIdcosecha;
	}
	
	

}
