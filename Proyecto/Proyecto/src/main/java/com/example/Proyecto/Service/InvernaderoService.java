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

import com.example.Proyecto.Entity.Invernadero;
import com.example.Proyecto.Repository.InvernaderoRepository;



@RestController
@RequestMapping("/invernadero")
@CrossOrigin
public class InvernaderoService {

	
	@Autowired
	InvernaderoRepository invernaderoRepository;
	
	@GetMapping( path = "/buscar")
	public List<Invernadero> getAllInvernadero() {
		return invernaderoRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Invernadero saveInvernadero(@RequestBody Invernadero invernadero ) {
		return invernaderoRepository.save(invernadero);
    }
	
	@DeleteMapping( path ="/eliminar/{idinvernadero}")
	public void deletInvernadero(@PathVariable ("idinvernadero") Integer idinvernadero) {
		
	
	Optional<Invernadero> invernadero;
	invernadero = invernaderoRepository.findById(idinvernadero);
	if(invernadero.isPresent()) {
		invernaderoRepository.delete(invernadero.get());
	}
	}
}
