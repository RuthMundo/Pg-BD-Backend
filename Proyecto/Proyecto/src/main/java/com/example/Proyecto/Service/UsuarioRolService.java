package com.example.Proyecto.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Proyecto.Entity.UsuarioRol;
import com.example.Proyecto.Repository.UsuarioRolRepository;

@RestController
@RequestMapping("/usuarioRol")
@CrossOrigin
public class UsuarioRolService {

	@Autowired
	UsuarioRolRepository usuarioRolRepository;
	

	@GetMapping(path = "/buscar")
	public List<UsuarioRol> getAll() {
		return usuarioRolRepository.findAll();
	}

	@PostMapping(path = "/guardar")
	public UsuarioRol save(@RequestBody UsuarioRol usuarioRol) {
		return usuarioRolRepository.save(usuarioRol);
	}

	/*@DeleteMapping(path = "/eliminar/{idmodulo}")
	public void deletModulo(@PathVariable("idmodulo") Integer UsuarioRol) {

		Optional<Modulo> modulo;
		modulo = usuarioRolRepository.findById(idmodulo);
		if (modulo.isPresent()) {
			usuarioRolRepository.delete(modulo.get());
		}
	}*/
}
