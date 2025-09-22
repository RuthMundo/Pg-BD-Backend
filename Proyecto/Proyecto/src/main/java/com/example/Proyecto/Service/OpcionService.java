package com.example.Proyecto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Proyecto.Entity.Opcion;
import com.example.Proyecto.Repository.OpcionRepository;

@RestController
@RequestMapping("/opcion")
@CrossOrigin
public class OpcionService {

	@Autowired
	OpcionRepository opcionRepository;
	
	@GetMapping(path = "/buscar")
	public List<Opcion> getAll() {
		return opcionRepository.findAll();
	}

	@PostMapping(path = "/guardar")
	public Opcion save(@RequestBody Opcion opcion) {
		return opcionRepository.save(opcion);
	}
}
