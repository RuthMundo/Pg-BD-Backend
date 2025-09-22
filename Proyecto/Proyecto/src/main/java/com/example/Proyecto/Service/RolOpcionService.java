package com.example.Proyecto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Proyecto.Entity.RolOpcion;
import com.example.Proyecto.Repository.RolOpcionRepository;

@RestController
@RequestMapping("/rolOpcion")
@CrossOrigin
public class RolOpcionService {
	
	@Autowired
	RolOpcionRepository rolOpcionRepository;
	
	@GetMapping(path = "/buscar")
	public List<RolOpcion> getAll() {
		return rolOpcionRepository.findAll();
	}

	@PostMapping(path = "/guardar")
	public RolOpcion save(@RequestBody RolOpcion rolOpcion) {
		return rolOpcionRepository.save(rolOpcion);
	}
}
