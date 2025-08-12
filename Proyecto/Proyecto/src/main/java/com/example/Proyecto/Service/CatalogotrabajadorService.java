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

import com.example.Proyecto.Entity.Catalogotrabajador;
import com.example.Proyecto.Repository.CatalogotrabajadorRepository;



@RestController
@RequestMapping("/catalogo_trabajador")
@CrossOrigin
public class CatalogotrabajadorService {

	
	@Autowired
	CatalogotrabajadorRepository catalogotrabajadorRepository;
	
	@GetMapping( path = "/buscar")
	public List<Catalogotrabajador> getAllCatalogotrabajador() {
		return catalogotrabajadorRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Catalogotrabajador saveCatalogotrabajador(@RequestBody Catalogotrabajador catalogotrabajador ) {
		return catalogotrabajadorRepository.save(catalogotrabajador);
    }
	
	@DeleteMapping( path ="/eliminar/{idcatalogotrabajador}")
	public void deletCatalogotrabajador(@PathVariable ("idcatalogotrabajador") Integer idcatalogotrabajador) {
		
	
	Optional<Catalogotrabajador> catalogotrabajador;
	catalogotrabajador = catalogotrabajadorRepository.findById(idcatalogotrabajador);
	if(catalogotrabajador.isPresent()) {
		catalogotrabajadorRepository.delete(catalogotrabajador.get());
	}
	}

}
