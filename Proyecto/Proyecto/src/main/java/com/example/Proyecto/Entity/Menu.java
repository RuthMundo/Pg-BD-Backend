package com.example.Proyecto.Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7045740324921272097L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idmenu")
	private Integer idMenu;
	
	@Column(name = "nombre_menu")
	private String nombreMenu;
	
	@Column(name = "orden_menu")
	private Integer orden;
	
	@Column(name = "modulo_idmodulo")
	private Integer idModulo;
	
	@OneToMany(mappedBy = "menu")
	private List<Opcion> listOpcion;

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getNombreMenu() {
		return nombreMenu;
	}

	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public List<Opcion> getListOpcion() {
		return listOpcion;
	}

	public void setListOpcion(List<Opcion> listOpcion) {
		this.listOpcion = listOpcion;
	}
	
	

	
}
