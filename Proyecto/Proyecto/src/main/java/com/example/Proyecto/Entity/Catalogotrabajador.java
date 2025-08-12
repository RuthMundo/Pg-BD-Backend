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
@Table(name = "catalogo_trabajador")
public class Catalogotrabajador implements Serializable{
	
	private static final long serialVersionUID = 7L ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idcatalogo_trabajador")
	private Integer idcatalogoTrabajador;
	
	@Column(name = "usuario_idusuario")
	private Integer usuarioIdusuario;
	
	@Column(name = "invernadero_idinvernadero")
	private Integer invernaderoIdinvernadero;

	public Integer getIdcatalogoTrabajador() {
		return idcatalogoTrabajador;
	}

	public void setIdcatalogoTrabajador(Integer idcatalogoTrabajador) {
		this.idcatalogoTrabajador = idcatalogoTrabajador;
	}

	public Integer getUsuarioIdusuario() {
		return usuarioIdusuario;
	}

	public void setUsuarioIdusuario(Integer usuarioIdusuario) {
		this.usuarioIdusuario = usuarioIdusuario;
	}

	public Integer getInvernaderoIdinvernadero() {
		return invernaderoIdinvernadero;
	}

	public void setInvernaderoIdinvernadero(Integer invernaderoIdinvernadero) {
		this.invernaderoIdinvernadero = invernaderoIdinvernadero;
	}
	
	
	
	

}
