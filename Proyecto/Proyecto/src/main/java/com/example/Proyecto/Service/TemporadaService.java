package com.example.Proyecto.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Proyecto.Entity.Temporada;
import com.example.Proyecto.Repository.TemporadaRepository;



@RestController
@RequestMapping("/temporada")
@CrossOrigin
public class TemporadaService {

	@Autowired
	TemporadaRepository temporadaRepository;
	
	@GetMapping( path = "/buscar")
	public List<Temporada> getAllTemporada() {
		return temporadaRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Temporada saveTemporada(@RequestBody Temporada temporada ) {
		return temporadaRepository.save(temporada);
    }
	
	@DeleteMapping( path ="/eliminar/{idtemporada}")
	public void deletTemporada(@PathVariable ("idtemporada") Integer idtemporada) {
		
	
	Optional<Temporada> temporada;
	temporada = temporadaRepository.findById(idtemporada);
	if(temporada.isPresent()) {
		temporadaRepository.delete(temporada.get());
	}
	}
}
