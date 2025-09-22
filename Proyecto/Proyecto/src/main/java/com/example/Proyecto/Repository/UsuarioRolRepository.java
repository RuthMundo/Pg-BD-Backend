package com.example.Proyecto.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Proyecto.Entity.UsuarioRol;
import com.example.Proyecto.Entity.UsuarioRolId;

@Repository("usuarioTolRepository")
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, UsuarioRolId> {

	public List<UsuarioRol> findByIdIdUsuario(Integer idUsuario);
}
