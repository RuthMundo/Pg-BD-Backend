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
	public String saveUsuario(@RequestBody Usuario usuario ) {
		String resultado = "";
		boolean existe = usuarioExiste(usuario.getCorreoElectronico());
		
		if (existe) {
			resultado = "El correo ingresado ya existe en el sistema, intente con otro correo electrónico";
		} else {
			usuario.setPassword(Encriptado.encriptar(usuario.getPassword()));
			usuarioRepository.save(usuario);
			resultado = "El ususario fue creado exitosamente";
		}

		return resultado;
    }
	
	@DeleteMapping( path ="/eliminar/{idusuario}")
	public void deletUsuario(@PathVariable ("idusuario") Integer idusuario) {
		
	Optional<Usuario> usuario;
	usuario = usuarioRepository.findById(idusuario);
	if(usuario.isPresent()) {
		usuarioRepository.delete(usuario.get());
		}
	}
	
	
	public boolean usuarioExiste(String correoElectronico) {
		boolean existe = true;
		List <Usuario> usuarioEncontrado = usuarioRepository.findByCorreoElectronico(correoElectronico);
		if(usuarioEncontrado.isEmpty()) {
			existe = false;
		}
		
		System.out.println(existe);
		return existe;
	}
	
	
	
	
}
