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

import com.example.Proyecto.Entity.Cosecha;
import com.example.Proyecto.Repository.CosechaRepository;



@RestController
@RequestMapping("/cosecha")
@CrossOrigin
public class CosechaService {

	
	@Autowired
	CosechaRepository cosechaRepository;
	
	@GetMapping( path = "/buscar")
	public List<Cosecha> getAllCosecha() {
		return cosechaRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Cosecha saveCosecha(@RequestBody Cosecha cosecha ) {
		return cosechaRepository.save(cosecha);
    }
	
	@DeleteMapping( path ="/eliminar/{idcosecha}")
	public void deletCosecha(@PathVariable ("idcosecha") Integer idcosecha) {
		
	
	Optional<Cosecha> cosecha;
	cosecha = cosechaRepository.findById(idcosecha);
	if(cosecha.isPresent()) {
		cosechaRepository.delete(cosecha.get());
	}
	}
}
