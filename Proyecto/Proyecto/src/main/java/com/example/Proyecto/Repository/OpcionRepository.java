package com.example.Proyecto.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Entity.Opcion;

@Repository("opcionRepository")
public interface OpcionRepository extends JpaRepository<Opcion, Serializable> {

	public List<Opcion> findByIdOpcion(Integer idOpcion);
}
