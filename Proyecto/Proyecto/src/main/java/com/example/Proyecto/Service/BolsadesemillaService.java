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

import com.example.Proyecto.Entity.Bolsadesemilla;
import com.example.Proyecto.Repository.BolsadesemillaRepository;



@RestController
@RequestMapping("/bolsa_de_semilla")
@CrossOrigin
public class BolsadesemillaService {

	
	@Autowired
	BolsadesemillaRepository bolsadesemillaRepository;
	
	@GetMapping( path = "/buscar")
	public List<Bolsadesemilla> getAllBolsadesemilla() {
		return bolsadesemillaRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Bolsadesemilla saveBolsadesemilla(@RequestBody Bolsadesemilla bolsadesemilla ) {
		return bolsadesemillaRepository.save(bolsadesemilla);
    }
	
	@DeleteMapping( path ="/eliminar/{idbolsadesemilla}")
	public void deletBolsadesemilla(@PathVariable ("idbolsadesemilla") Integer idbolsadesemilla) {
		
	
	Optional<Bolsadesemilla> bolsadesemilla;
	bolsadesemilla = bolsadesemillaRepository.findById(idbolsadesemilla);
	if(bolsadesemilla.isPresent()) {
		bolsadesemillaRepository.delete(bolsadesemilla.get());
	}
	}

}
