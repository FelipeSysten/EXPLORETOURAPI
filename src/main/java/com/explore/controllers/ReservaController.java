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

import com.explore.models.Reserva;
import com.explore.services.ReservaService;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

	
	@Autowired
	private ReservaService rs;
	
	@PostMapping("/saveReserva")
	public Reserva createReserva(@RequestBody Reserva reserva) {
		
		
		return rs.saveReserva(reserva);
	}
	
	@GetMapping("/allReservas")
	public List<Reserva> getAllReservas(){
		return rs.getAllReservas();
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Reserva> getReservaById(@PathVariable Long id){
		Reserva reserva = rs.getReservaById(id);
		
		return ResponseEntity.ok(reserva);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Reserva> updateReserva(@PathVariable Long id, @RequestBody Reserva reservaUpdated){
	
		Reserva reserva = rs.getReservaById(id);
		
		reserva.setData(reservaUpdated.getData());
		
		rs.saveReserva(reserva);
		
		return ResponseEntity.ok(reserva);
	}
	
	@DeleteMapping("/{id}")
	public void deleteReserva(@PathVariable Long id) {
	
		rs.deleteById(id);
		
	}
}
