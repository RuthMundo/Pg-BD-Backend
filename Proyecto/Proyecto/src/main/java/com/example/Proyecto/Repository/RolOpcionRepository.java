package com.example.Proyecto.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Entity.RolOpcion;

@Repository("rolOpcionRepository")
public interface RolOpcionRepository extends JpaRepository<RolOpcion, Serializable> {

	public List<RolOpcion> findByIdIdRol(Integer idRol);
}
