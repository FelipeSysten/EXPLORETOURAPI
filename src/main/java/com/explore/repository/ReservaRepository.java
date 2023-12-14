package com.explore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.explore.models.Reserva;

import jakarta.transaction.Transactional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	@Transactional
	@Modifying
	@Query(nativeQuery= true, value ="INSERT INTO reserva_destino (reserva_id, destino_id) VALUES (reservaId, destinoId)" )
	void addRelationship(@Param("reservaId") Long reservaId, @Param("destinoId") Long destinoId);
}
