package com.explore.servicesimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.explore.models.Destino;
import com.explore.repository.DestinoRepository;
import com.explore.services.DestinoService;

@Service
public class DestinoServiceImpl implements DestinoService {
	
	@Autowired
	private DestinoRepository dr;
	
	
	@Override
	public List<Destino> getAllDestinos() {
		
		return  dr.findAll();
	}

	@Override
	public Destino getDestinoById(Long id) {
		
		return dr.findById(id).orElseThrow(()-> new RuntimeException("Deu Ruim no GetById"));
	}

	@Override
	public Destino saveDestino(Destino Destino) {
		
		return dr.save(Destino);
	}

	@Override
	public Destino updateDestino(Long id, Destino DestinoUpdated) {
		
		Destino DestinoExiste = dr.findById(id).orElseThrow(()-> new RuntimeException("ID" + id + "Not Found"));
		DestinoExiste.setName(DestinoUpdated.getName());  
		
		return dr.save(DestinoExiste);
	}

	@Override
	public void deleteById(Long id) {
		dr.deleteById(id);
	}


	

}
