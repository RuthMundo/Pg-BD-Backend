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

import com.example.Proyecto.Entity.Enviomensaje;
import com.example.Proyecto.Repository.EnviomensajeRepository;



@RestController
@RequestMapping("/enviomensaje")
@CrossOrigin
public class EnviomensajeService {

	
	@Autowired
	EnviomensajeRepository enviomensajeRepository;
	
	@GetMapping( path = "/buscar")
	public List<Enviomensaje> getAllEnviomensaje() {
		return enviomensajeRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Enviomensaje saveEnviomensaje(@RequestBody Enviomensaje enviomensaje ) {
		return enviomensajeRepository.save(enviomensaje);
    }
	
	@DeleteMapping( path ="/eliminar/{idenviomensaje}")
	public void deletEnviomensaje(@PathVariable ("idenviomensaje") Integer idenviomensaje) {
		
	
	Optional<Enviomensaje> enviomensaje;
	enviomensaje = enviomensajeRepository.findById(idenviomensaje);
	if(enviomensaje.isPresent()) {
		enviomensajeRepository.delete(enviomensaje.get());
	}
	}
}
