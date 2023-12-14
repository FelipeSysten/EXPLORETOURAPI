package com.explore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.explore.models.ReservaDestinoDTO;
import com.explore.services.ReservaService;

@RestController
@RequestMapping("/reservareldestino")
public class ReservaDestinoController {

	@Autowired
	private ReservaService rs;
	
	@PostMapping("/addreservadestino")
	public ResponseEntity<String> addRelationship(@RequestBody ReservaDestinoDTO rsDTO){
		rs.addRelationship(rsDTO.getReservaId(), rsDTO.getDestinoId());
		
		return new ResponseEntity<>("Relationship created ", HttpStatus.CREATED);
	}
	
	
}
