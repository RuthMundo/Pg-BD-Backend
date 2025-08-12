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

import com.example.Proyecto.Entity.Rendimientovariedad;
import com.example.Proyecto.Repository.RendimientovariedadRepository;



@RestController
@RequestMapping("/rendimientovariedad")
@CrossOrigin
public class RendimientovariedadService {

	
	@Autowired
	RendimientovariedadRepository rendimientovariedadRepository;
	
	@GetMapping( path = "/buscar")
	public List<Rendimientovariedad> getAllReporte() {
		return rendimientovariedadRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Rendimientovariedad saveRendimientovariedad(@RequestBody Rendimientovariedad rendimientovariedad ) {
		return rendimientovariedadRepository.save(rendimientovariedad);
    }
	
	@DeleteMapping( path ="/eliminar/{idrendimientovariedad}")
	public void deletRendimientovariedad(@PathVariable ("idrendimientovariedad") Integer idrendimientovariedad) {
		
	
	Optional<Rendimientovariedad> rendimientovariedad;
	rendimientovariedad = rendimientovariedadRepository.findById(idrendimientovariedad);
	if(rendimientovariedad.isPresent()) {
		rendimientovariedadRepository.delete(rendimientovariedad.get());
	}
	}
}
