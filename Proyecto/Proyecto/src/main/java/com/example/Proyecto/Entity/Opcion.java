package com.example.Proyecto.Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "opcion")
public class Opcion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5126639498413036311L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idopcion")
	private Integer idOpcion;
	
	@Column(name = "nombre_opcion")
	private String nombreOpcion;
	
	@Column(name = "orden_opcion")
	private Integer orden;
	
	//@Column(name = "menu_idmenu")
	@Column(name = "menu_idmenu", insertable = false, updatable = false)
	private Integer idMenu;
	
	@Column(name = "url")
	private String url;
	
	@OneToMany(mappedBy = "id.idOpcion")
	private List<RolOpcion> listRoleOpcion;
	
	@ManyToOne
	@JoinColumn(name = "menu_idmenu", referencedColumnName = "idmenu")
	private Menu menu;


	public Integer getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(Integer idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getNombreOpcion() {
		return nombreOpcion;
	}

	public void setNombreOpcion(String nombreOpcion) {
		this.nombreOpcion = nombreOpcion;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<RolOpcion> getListRoleOpcion() {
		return listRoleOpcion;
	}

	public void setListRoleOpcion(List<RolOpcion> listRoleOpcion) {
		this.listRoleOpcion = listRoleOpcion;
	}
}
