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

import com.example.Proyecto.Entity.Reporte;
import com.example.Proyecto.Repository.ReporteRepository;



@RestController
@RequestMapping("/reporte")
@CrossOrigin
public class ReporteService {
	
	
	@Autowired
	ReporteRepository reporteRepository;
	
	@GetMapping( path = "/buscar")
	public List<Reporte> getAllReporte() {
		return reporteRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Reporte saveReporte(@RequestBody Reporte reporte ) {
		return reporteRepository.save(reporte);
    }
	
	@DeleteMapping( path ="/eliminar/{idreporte}")
	public void deletReporte(@PathVariable ("idreporte") Integer idreporte) {
		
	
	Optional<Reporte> reporte;
	reporte = reporteRepository.findById(idreporte);
	if(reporte.isPresent()) {
		reporteRepository.delete(reporte.get());
	}
	}

}
