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

import com.example.Proyecto.Entity.Variedad;
import com.example.Proyecto.Repository.VariedadRepository;



@RestController
@RequestMapping("/variedad")
@CrossOrigin
public class VariedadService {

	
	@Autowired
	VariedadRepository variedadRepository;
	
	@GetMapping( path = "/buscar")
	public List<Variedad> getAllVariedad() {
		return variedadRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Variedad saveVariedad(@RequestBody Variedad variedad ) {
		return variedadRepository.save(variedad);
    }
	
	@DeleteMapping( path ="/eliminar/{idvariedad}")
	public void deletvariedad(@PathVariable ("idvariedad") Integer idvariedad) {
		
	
	Optional<Variedad> variedad;
	variedad = variedadRepository.findById(idvariedad);
	if(variedad.isPresent()) {
		variedadRepository.delete(variedad.get());
	}
	}
}
