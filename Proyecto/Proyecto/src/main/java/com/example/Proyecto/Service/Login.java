package com.example.Proyecto.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

/*	@PostMapping(path = "/loguearse")
	public String login(@RequestBody Usuario usuario) {
		System.out.print(usuario.getCorreoElectronico()+usuario.getPassword());
		
		String respuesta = "Login Exitoso";
		usuario.setPassword(Encriptado.encriptar(usuario.getPassword()));
		List <Usuario> usuarioEncontrado = usuarioRepository.findByCorreoElectronicoAndPassword(usuario.getCorreoElectronico(), usuario.getPassword());
		if (usuarioEncontrado.isEmpty()) {
			respuesta = "Usuario o contraseña son inválidos";
		}

		return respuesta;
	}*/
	/*
	
	
	@PostMapping(path = "/loguearse")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Usuario usuario) {
	    Map<String, Object> respuesta = new HashMap<>();
	    usuario.setPassword(Encriptado.encriptar(usuario.getPassword()));
	    List<Usuario> usuarioEncontrado = usuarioRepository.findByCorreoElectronicoAndPassword(
	        usuario.getCorreoElectronico(), usuario.getPassword()
	    );

	    if (usuarioEncontrado.isEmpty()) {
	        respuesta.put("message", "Usuario o contraseña inválidos");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(respuesta); // 401
	    }

	    respuesta.put("message", "Login exitoso");
	    respuesta.put("usuario", usuarioEncontrado.get(0));
	    return ResponseEntity.ok(respuesta); // 200
	}*/
	
	@PostMapping(path = "/loguearse")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Usuario usuario) {
        Map<String, Object> respuesta = new HashMap<>();

        // Validación básica de datos
        if (usuario.getCorreoElectronico() == null || usuario.getPassword() == null) {
            respuesta.put("message", "Correo y contraseña son obligatorios");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta); // 400
        }

        // Encriptar la contraseña
        usuario.setPassword(Encriptado.encriptar(usuario.getPassword()));

        // Buscar usuario
        List<Usuario> usuarioEncontrado = usuarioRepository.findByCorreoElectronicoAndPassword(
                usuario.getCorreoElectronico(), usuario.getPassword()
        );

        if (usuarioEncontrado.isEmpty()) {
            respuesta.put("message", "Usuario o contraseña inválidos");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(respuesta); // 401
        }

        // usuario sin permisos
      /*  if (!usuarioEncontrado.get(0).getRolIdrol().equals("ADMIN")) {
            respuesta.put("message", "No tienes permisos para acceder");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(respuesta); // 403
        }
*/
        // Login exitoso
        respuesta.put("message", "Login exitoso");
        respuesta.put("usuario", usuarioEncontrado.get(0));
        return ResponseEntity.ok(respuesta); // 200
    }

    // Manejo de errores internos globales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception e) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("message", "Error interno del servidor");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta); // 500
    }
}


