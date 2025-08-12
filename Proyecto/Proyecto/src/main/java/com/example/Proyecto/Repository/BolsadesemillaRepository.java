package com.example.Proyecto.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Entity.Bolsadesemilla;


@Repository("bolsadesemillaRepository")
public interface BolsadesemillaRepository extends JpaRepository<Bolsadesemilla, Serializable>{

}
