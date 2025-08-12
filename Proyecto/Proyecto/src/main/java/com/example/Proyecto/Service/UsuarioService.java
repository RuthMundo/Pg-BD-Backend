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

import com.example.Proyecto.Entity.Usuario;
import com.example.Proyecto.Repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping( path = "/buscar")
	public List<Usuario> getAllUsuario() {
		return usuarioRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Usuario saveUsuario(@RequestBody Usuario usuario ) {
		return usuarioRepository.save(usuario);
    }
	
	@DeleteMapping( path ="/eliminar/{idusuario}")
	public void deletUsuario(@PathVariable ("idusuario") Integer idusuario) {
		
	
	Optional<Usuario> usuario;
	usuario = usuarioRepository.findById(idusuario);
	if(usuario.isPresent()) {
		usuarioRepository.delete(usuario.get());
	}
	}
	
	@GetMapping(path = "/login/{correoElectronico}/{password}")
	public String login(@PathVariable("correoElectronico") String correoElectronico, @PathVariable("password") String password) {
		String login ="ERROR";
		List <Usuario> usuario = usuarioRepository.findByCorreoElectronicoAndPassword(correoElectronico, password);
		
		if(!usuario.isEmpty()) {
			login = "OK";
		}
		
		return login ;
		
	}

}
