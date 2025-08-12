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

import com.example.Proyecto.Entity.Modulo;
import com.example.Proyecto.Repository.ModuloRepository;



@RestController
@RequestMapping("/modulo")
@CrossOrigin
public class ModuloService {

	
	@Autowired
	ModuloRepository moduloRepository;
	
	@GetMapping( path = "/buscar")
	public List<Modulo> getAllModulo() {
		return moduloRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Modulo saveModulo(@RequestBody Modulo modulo ) {
		return moduloRepository.save(modulo);
    }
	
	@DeleteMapping( path ="/eliminar/{idmodulo}")
	public void deletModulo(@PathVariable ("idmodulo") Integer idmodulo) {
		
	
	Optional<Modulo> modulo;
	modulo = moduloRepository.findById(idmodulo);
	if(modulo.isPresent()) {
		moduloRepository.delete(modulo.get());
	}
	}
}
