package com.example.Proyecto.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Entity.Modulo;


@Repository("moduloRepository")
public interface ModuloRepository extends JpaRepository<Modulo, Serializable> {

	public List<Modulo> findByIdmodulo(Integer idModulo);
}
