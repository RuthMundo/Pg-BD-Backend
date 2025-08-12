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

import com.example.Proyecto.Entity.Dato;
import com.example.Proyecto.Repository.DatoRepository;



@RestController
@RequestMapping("/dato")
@CrossOrigin
public class DatoService {

	
	@Autowired
	DatoRepository datoRepository;
	
	@GetMapping( path = "/buscar")
	public List<Dato> getAllDato() {
		return datoRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Dato saveDato(@RequestBody Dato dato ) {
		return datoRepository.save(dato);
    }
	
	@DeleteMapping( path ="/eliminar/{iddato}")
	public void deletDato(@PathVariable ("iddato") Integer iddato) {
		
	
	Optional<Dato> dato;
	dato = datoRepository.findById(iddato);
	if(dato.isPresent()) {
		datoRepository.delete(dato.get());
	}
	}

}
