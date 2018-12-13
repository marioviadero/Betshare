package com.marioviadero.Betshare.repository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.marioviadero.Betshare.model.Competicion;
import com.marioviadero.Betshare.model.Evento;


@Repository
public interface CompeticionRepository extends JpaRepository<Competicion, Integer>{

	@Query("SELECT c FROM Competicion c WHERE (c.nombre) = :nombre")
	Optional<Competicion> buscarCompeticionNombre(@Param("nombre") String nombre);
	
	@Query("SELECT e FROM Evento e WHERE (e.competicion) = :nombre")
	List<Evento> buscarEventosCompeticion(@Param("nombre") String nombre);
		
}
