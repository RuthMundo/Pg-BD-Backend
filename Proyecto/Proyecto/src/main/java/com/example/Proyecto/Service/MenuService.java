package com.example.Proyecto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Proyecto.Entity.Menu;
import com.example.Proyecto.Repository.MenuRepository;

@RestController
@RequestMapping("/menu")
@CrossOrigin
public class MenuService {
	
	@Autowired
	MenuRepository menuRepository;
	
	@GetMapping(path = "/buscar")
	public List<Menu> getAll() {
		return menuRepository.findAll();
	}

	@PostMapping(path = "/guardar")
	public Menu save(@RequestBody Menu menu) {
		return menuRepository.save(menu);
	}

}
