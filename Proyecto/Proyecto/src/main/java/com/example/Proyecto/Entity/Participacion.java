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
@Table(name = "participacion")
public class Participacion implements Serializable{
	
	private static final long serialVersionUID = 13L ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "cosecha_idcosecha")
	private Integer cosechaIdcosecha;
	
	@Column(name = "usuario_idusuario")
	private Integer usuarioIdusuario;

	public Integer getCosechaIdcosecha() {
		return cosechaIdcosecha;
	}

	public void setCosechaIdcosecha(Integer cosechaIdcosecha) {
		this.cosechaIdcosecha = cosechaIdcosecha;
	}

	public Integer getUsuarioIdusuario() {
		return usuarioIdusuario;
	}

	public void setUsuarioIdusuario(Integer usuarioIdusuario) {
		this.usuarioIdusuario = usuarioIdusuario;
	}
	
	


}
