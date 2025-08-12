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

import com.example.Proyecto.Entity.Permiso;
import com.example.Proyecto.Repository.PermisoRepository;



@RestController
@RequestMapping("/permiso")
@CrossOrigin
public class PermisoService {
	
	@Autowired
	PermisoRepository permisoRepository;
	
	@GetMapping( path = "/buscar")
	public List<Permiso> getAllPermiso() {
		return permisoRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Permiso saveReporte(@RequestBody Permiso permiso ) {
		return permisoRepository.save(permiso);
    }
	
	@DeleteMapping( path ="/eliminar/{idpermiso}")
	public void deletPermiso(@PathVariable ("idpermiso") Integer idpermiso) {
		
	
	Optional<Permiso> permiso;
	permiso = permisoRepository.findById(idpermiso);
	if(permiso.isPresent()) {
		permisoRepository.delete(permiso.get());
	}
	}


}
