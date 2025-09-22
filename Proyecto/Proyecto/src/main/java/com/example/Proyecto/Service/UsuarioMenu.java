package com.example.Proyecto.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Proyecto.Entity.Menu;
import com.example.Proyecto.Entity.Modulo;
import com.example.Proyecto.Entity.Opcion;
import com.example.Proyecto.Entity.Rol;
import com.example.Proyecto.Entity.RolOpcion;
import com.example.Proyecto.Entity.UsuarioRol;
import com.example.Proyecto.Entity.UsuarioRolId;
import com.example.Proyecto.Repository.MenuRepository;
import com.example.Proyecto.Repository.ModuloRepository;
import com.example.Proyecto.Repository.OpcionRepository;
import com.example.Proyecto.Repository.RolOpcionRepository;
import com.example.Proyecto.Repository.RolRepository;
import com.example.Proyecto.Repository.UsuarioRolRepository;

//@Service
@RestController
@RequestMapping("/usuarioMenu")
@CrossOrigin
public class UsuarioMenu {
	
	String nombreRol = "";
	
	
	@Autowired
	UsuarioRolRepository usuarioRolRepository;
	@Autowired
	RolOpcionRepository rolOpcionRepository;
	@Autowired
	OpcionRepository opcionRepository;
	@Autowired
	MenuRepository menuRepository;
	@Autowired
	ModuloRepository moduloRepository;
	
	
	
	
	
	
	public Map<String, Object> getMensaje(UsuarioRolId usuarioRolId) {
		
		Optional <UsuarioRol> rolesEncontrados = usuarioRolRepository.findById(usuarioRolId);
	    Map<String, Object> response = new HashMap<>();
	
		if (rolesEncontrados.isPresent()) {
		    List<RolOpcion> rol = rolOpcionRepository.findByIdIdRol(rolesEncontrados.get().getId().getIdRol());
		    response.put("Opciones", rol);
		    
		    for (RolOpcion elemento : rol) {
		        System.out.println(elemento.getId().getIdRol() +"-"+ elemento.getId().getIdOpcion()+ "ES UN ROL ");
		    }
		    
		} else {
		    response.put("mensaje", "no se obtuvieron roles!");
		}
	    return response;
	}
	
	
	
	
	

	
	@GetMapping(path ="/usuarioMenu/{idRole}")
	public List<Modulo> buscarIdRole(@PathVariable ("idRole")Integer idRole){

		List<RolOpcion> rolOpcionTodo = rolOpcionRepository.findAll();
		
		
		
		

		List<Opcion> opcion = opcionRepository.findAll();

		List<Menu> menu = menuRepository.findAll();

		List<Modulo> modulo = moduloRepository.findAll();



		List<RolOpcion> roleOpcionNuevos = new ArrayList<>();

		List<Opcion> opcionNuevos = new ArrayList<>();

		List<Menu> menuNuevos = new ArrayList<>();

		List<Modulo> moduloNuevos = new ArrayList<>();

		for(RolOpcion roleOpcion: rolOpcionTodo) {
			if(roleOpcion.getId().getIdRol().equals(idRole)) {
				roleOpcionNuevos.add(roleOpcion);

			}
		}



		for(RolOpcion roleOpcion: roleOpcionNuevos) {

				for (Opcion op: opcion) {
					if (roleOpcion.getId().getIdOpcion()== op.getIdOpcion()) {
						opcionNuevos.add(op);

					}
				}	

		}

		List<Opcion> opcionSinDuplicar = new ArrayList<>();
		for (Opcion elemento : opcionNuevos) {
		    if (!opcionSinDuplicar.contains(elemento)) {
		        opcionSinDuplicar.add(elemento);
		    }
		}




		for (Opcion op : opcionSinDuplicar) {

			for (Menu men : menu) {
				if(op.getIdMenu()==men.getIdMenu()) {
					menuNuevos.add(men);
				}

			}
		}


		List<Menu> menuSinDuplicar = new ArrayList<>();
		for (Menu men : menuNuevos) {
		    if (!menuSinDuplicar.contains(men)) {
		        menuSinDuplicar.add(men);
		    }
		}


		for (Menu men : menuSinDuplicar) {

			for (Modulo mod : modulo) {
				if(men.getIdModulo()==mod.getIdmodulo()) {
					moduloNuevos.add(mod);
				}

			}
		}


		List<Modulo> moduloSinDuplicar = new ArrayList<>();
		for (Modulo men : moduloNuevos) {
		    if (!moduloSinDuplicar.contains(men)) {
		        moduloSinDuplicar.add(men);
		    }
		}




		for (Menu men: menuSinDuplicar) {
			List<Opcion> opc = new ArrayList<>();
			for(Opcion op: opcionSinDuplicar) {
				if(men.getIdMenu()==op.getIdMenu()) {
					opc.add(op);
				}
			}

			men.setListOpcion(opc);
		}


		for (Modulo mod: moduloSinDuplicar) {
			List<Menu> mnu = new ArrayList<>();
			for(Menu men: menuSinDuplicar) {
				if(mod.getIdmodulo()==men.getIdModulo()) {
					mnu.add(men);
				}
			}

		mod.setListMenu(mnu);
		}


		return moduloSinDuplicar;
	}
	
	
	
	@GetMapping("/usuarioMenu2/{idRole}")
	public List<Modulo> buscarIdRole2(@PathVariable Integer idRole) {

	    // Traemos solo lo necesario
	    List<RolOpcion> rolOpciones = rolOpcionRepository.findByIdIdRol(idRole); // Mejor: crea query específica

	    if (rolOpciones.isEmpty()) {
	        return Collections.emptyList();
	    }

	    // Guardamos los IDs de opciones permitidas
	    Set<Integer> opcionIds = rolOpciones.stream()
	            .map(ro -> ro.getId().getIdOpcion())
	            .collect(Collectors.toSet());

	    // Filtramos las opciones que pertenecen al rol
	    List<Opcion> opciones = opcionRepository.findAll().stream()
	            .filter(op -> opcionIds.contains(op.getIdOpcion()))
	            .collect(Collectors.toList());

	    // Guardamos IDs de menús
	    Set<Integer> menuIds = opciones.stream()
	            .map(Opcion::getIdMenu)
	            .collect(Collectors.toSet());

	    // Filtramos menús
	    List<Menu> menus = menuRepository.findAll().stream()
	            .filter(m -> menuIds.contains(m.getIdMenu()))
	            .collect(Collectors.toList());

	    // Guardamos IDs de módulos
	    Set<Integer> moduloIds = menus.stream()
	            .map(Menu::getIdModulo)
	            .collect(Collectors.toSet());

	    // Filtramos módulos
	    List<Modulo> modulos = moduloRepository.findAll().stream()
	            .filter(mod -> moduloIds.contains(mod.getIdmodulo()))
	            .collect(Collectors.toList());

	    // Armamos la jerarquía
	    Map<Integer, Menu> menuMap = menus.stream()
	            .peek(m -> m.setListOpcion(
	                    opciones.stream()
	                            .filter(op -> op.getIdMenu().equals(m.getIdMenu()))
	                            .collect(Collectors.toList())
	            ))
	            .collect(Collectors.toMap(Menu::getIdMenu, m -> m));

	    modulos.forEach(mod -> mod.setListMenu(
	            menus.stream()
	                    .filter(m -> m.getIdModulo().equals(mod.getIdmodulo()))
	                    .collect(Collectors.toList())
	    ));

	    return modulos;
	}

	
	
	
	
	
	
	
	
	
	

}
