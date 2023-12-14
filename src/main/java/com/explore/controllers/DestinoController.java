package com.explore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.explore.models.Destino;
import com.explore.services.DestinoService;

@RestController
@RequestMapping("/destino")
public class DestinoController {

	@Autowired
	private DestinoService ds;
	
	@PostMapping("/saveDestino")
	public Destino createDestino(@RequestBody Destino Destino) {
		
		
		return ds.saveDestino(Destino);
	}
	
	@GetMapping("/allDestinos")
	public List<Destino> getAllDestinos(){
		return ds.getAllDestinos();
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Destino> getDestinoById(@PathVariable Long id){
		Destino Destino = ds.getDestinoById(id);
		
		return ResponseEntity.ok(Destino);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Destino> updateDestino(@PathVariable Long id, @RequestBody Destino DestinoUpdated){
	
		Destino Destino = ds.getDestinoById(id);
		
		Destino.setName(DestinoUpdated.getName());
		
		ds.saveDestino(Destino);
		
		return ResponseEntity.ok(Destino);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDestino(@PathVariable Long id) {
	
		ds.deleteById(id);
		
	}
}
