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

import com.example.Proyecto.Entity.Participacion;
import com.example.Proyecto.Repository.ParticipacionRepository;



@RestController
@RequestMapping("/participacion")
@CrossOrigin
public class ParticipacionService {

	
	@Autowired
	ParticipacionRepository participacionRepository;
	
	@GetMapping( path = "/buscar")
	public List<Participacion> getAllParticipacion() {
		return participacionRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Participacion saveParticipacion(@RequestBody Participacion participacion ) {
		return participacionRepository.save(participacion);
    }
	
	@DeleteMapping( path ="/eliminar/{idparticipacion}")
	public void deletParticipacion(@PathVariable ("idparticipacion") Integer idparticipacion) {
		
	
	Optional<Participacion> participacion;
	participacion = participacionRepository.findById(idparticipacion);
	if(participacion.isPresent()) {
		participacionRepository.delete(participacion.get());
	}
	}

}
