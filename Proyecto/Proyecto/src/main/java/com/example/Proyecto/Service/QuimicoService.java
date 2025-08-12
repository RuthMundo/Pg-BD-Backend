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

import com.example.Proyecto.Entity.Quimico;
import com.example.Proyecto.Repository.QuimicoRepository;



@RestController
@RequestMapping("/quimico")
@CrossOrigin
public class QuimicoService {

	

	@Autowired
	QuimicoRepository quimicoRepository;
	
	@GetMapping( path = "/buscar")
	public List<Quimico> getAllQuimico() {
		return quimicoRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Quimico saveQuimico(@RequestBody Quimico quimico ) {
		return quimicoRepository.save(quimico);
    }
	
	@DeleteMapping( path ="/eliminar/{idquimico}")
	public void deletQuimico(@PathVariable ("idquimico") Integer idquimico) {
		
	
	Optional<Quimico> quimico;
	quimico = quimicoRepository.findById(idquimico);
	if(quimico.isPresent()) {
		quimicoRepository.delete(quimico.get());
	}
	}
}
