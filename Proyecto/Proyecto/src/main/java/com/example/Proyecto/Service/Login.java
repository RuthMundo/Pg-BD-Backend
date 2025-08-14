package com.example.Proyecto.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Proyecto.Entity.Usuario;
import com.example.Proyecto.Repository.UsuarioRepository;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class Login {
	@Autowired
	UsuarioRepository usuarioRepository;

	@PostMapping(path = "/loguearse")
	public String login(@RequestBody Usuario usuario) {
		String respuesta = "Login Exitoso";
		usuario.setPassword(Encriptado.encriptar(usuario.getPassword()));
		List <Usuario> usuarioEncontrado = usuarioRepository.findByCorreoElectronicoAndPassword(usuario.getCorreoElectronico(), usuario.getPassword());
		if (usuarioEncontrado.isEmpty()) {
			respuesta = "Usuario o contraseña son inválidos";
		}

		return respuesta;
	}
}

