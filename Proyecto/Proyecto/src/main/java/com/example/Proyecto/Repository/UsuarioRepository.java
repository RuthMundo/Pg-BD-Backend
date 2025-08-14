package com.example.Proyecto.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Entity.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {
	
	public List<Usuario> findByCorreoElectronicoAndPassword(String correoElectronico, String password);
	public List<Usuario> findByCorreoElectronico(String correoElectronico);
	

}
