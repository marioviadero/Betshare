package com.marioviadero.Betshare.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marioviadero.Betshare.model.Cuota;
import com.marioviadero.Betshare.model.Evento;
@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>{
		
	@Query("SELECT c FROM Cuota c WHERE (c.evento) = :id")
	List<Cuota> buscarCuotas(@Param("id") Integer id);
}
