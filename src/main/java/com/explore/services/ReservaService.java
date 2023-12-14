package com.explore.services;

import java.util.List;

import com.explore.models.Reserva;

public interface ReservaService {
	
	List<Reserva> getAllReservas();
	
	Reserva getReservaById(Long id);
	
	Reserva saveReserva(Reserva reserva);
	
	Reserva updateReserva(Long id, Reserva reservaUpdated);
	
	void deleteById(Long id);
	
	void addRelationship (Long reservaId, Long destinoId);

}
