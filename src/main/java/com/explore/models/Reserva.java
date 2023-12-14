package com.explore.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="reserva_data", length = 50, nullable = false)
	private String data;
	
	
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "reserva_destino",
	joinColumns = @JoinColumn(name = "reserva_id"),
	inverseJoinColumns = @JoinColumn(name = "destino_id"))
	private Set<Destino> destinos = new HashSet<>();
	

	public Reserva() {
		
	}
	

	public Reserva(Long id, String data, Set<Destino> destinos) {
		super();
		this.id = id;
		this.data = data;
		this.destinos = destinos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Set<Destino> getDestinos() {
		return destinos;
	}

	public void setDestinos(Set<Destino> destinos) {
		this.destinos = destinos;
	}
	
	
}
