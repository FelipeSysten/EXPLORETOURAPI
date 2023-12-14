package com.explore.services;

import java.util.List;

import com.explore.models.Destino;


public interface DestinoService {

	
List<Destino> getAllDestinos();
	
	Destino getDestinoById(Long id);
	
	Destino saveDestino(Destino Destino);
	
	Destino updateDestino(Long id, Destino DestinoUpdated);
	
	void deleteById(Long id);
}
