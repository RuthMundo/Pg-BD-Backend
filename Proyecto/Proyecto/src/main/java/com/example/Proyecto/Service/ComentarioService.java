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

import com.example.Proyecto.Entity.Comentario;
import com.example.Proyecto.Repository.ComentarioRepository;



@RestController
@RequestMapping("/comentario")
@CrossOrigin
public class ComentarioService {

	

	@Autowired
	ComentarioRepository comentarioRepository;
	
	@GetMapping( path = "/buscar")
	public List<Comentario> getAllComentario() {
		return comentarioRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Comentario saveComentario(@RequestBody Comentario comentario ) {
		return comentarioRepository.save(comentario);
    }
	
	@DeleteMapping( path ="/eliminar/{idcomentario}")
	public void deletComentario(@PathVariable ("idcomentario") Integer idcomentario) {
		
	
	Optional<Comentario> comentario;
	comentario = comentarioRepository.findById(idcomentario);
	if(comentario.isPresent()) {
		comentarioRepository.delete(comentario.get());
	}
	}

}
