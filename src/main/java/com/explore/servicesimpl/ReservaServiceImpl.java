package com.explore.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.explore.models.Destino;
import com.explore.models.Reserva;
import com.explore.repository.DestinoRepository;
import com.explore.repository.ReservaRepository;
import com.explore.services.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService{
	
	@Autowired
	private ReservaRepository rr;
	
	@Autowired
	private DestinoRepository dr;

	@Override
	public List<Reserva> getAllReservas() {
		
		return  rr.findAll();
	}

	@Override
	public Reserva getReservaById(Long id) {
		
		return rr.findById(id).orElseThrow(()-> new RuntimeException("ID" + id + "Not Found"));
	}

	@Override
	public Reserva saveReserva(Reserva reserva) {
		
		return rr.save(reserva);
	}

	@Override
	public Reserva updateReserva(Long id, Reserva reservaUpdated) {
		
		Reserva reservaExiste = rr.findById(id).orElseThrow(()-> new RuntimeException("ID" + id + "Not Found"));
		reservaExiste.setData(reservaUpdated.getData());
		
		return rr.save(reservaExiste);
	}

	@Override
	public void deleteById(Long id) {
		rr.deleteById(id);
	}

	@Override
	public void addRelationship(Long reservaId, Long destinoId) {
		Reserva reserva = rr.findById(reservaId).orElseThrow(()-> new RuntimeException("ID" + reservaId + "Not Found"));
		Destino destino = dr.findById(destinoId).orElseThrow(()-> new RuntimeException("ID" + destinoId + "Not Found"));
	
		if(reserva != null && destino != null) {
			reserva.getDestinos().add(destino);
			destino.getReservas().add(reserva);
			
			rr.save(reserva);
			dr.save(destino);
		}
	
	}

}
