package com.example.Proyecto.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	/*@PostMapping( path = "/guardar")
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
    }*/
	
	@PostMapping(path = "/guardar")
	public ResponseEntity<Map<String, Object>> saveUsuario(@RequestBody Usuario usuario) {
	    Map<String, Object> response = new HashMap<>();
	    
	    System.out.println(usuario.getCorreoElectronico());
	    System.out.println(usuario.getNombreCompleto());
	    System.out.println(usuario.getPassword());
	    System.out.println(usuario.getRolIdrol());

	    boolean existe = usuarioExiste(usuario.getCorreoElectronico());

	    if (existe) {
	        response.put("success", false);
	        response.put("message", "El correo ingresado ya existe en el sistema, intente con otro correo electrónico2");
	        return ResponseEntity.status(HttpStatus.CONFLICT).body(response); // 409
	    } else {
	        usuario.setPassword(Encriptado.encriptar(usuario.getPassword()));
	        usuarioRepository.save(usuario);

	        response.put("success", true);
	        response.put("message", "El usuario fue creado exitosamente");
	        return ResponseEntity.status(HttpStatus.CREATED).body(response); // 201
	    }
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
		System.out.print("llegue aca" + existe);
		return existe;
	}
	
	
	
	
}
