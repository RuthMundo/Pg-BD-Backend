package com.example.Proyecto.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Entity.Participacion;


@Repository("participacionRepository")
public interface ParticipacionRepository extends JpaRepository<Participacion, Serializable>{

}
