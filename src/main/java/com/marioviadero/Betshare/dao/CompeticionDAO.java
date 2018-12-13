package com.marioviadero.Betshare.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marioviadero.Betshare.model.Competicion;
import com.marioviadero.Betshare.model.Evento;
import com.marioviadero.Betshare.repository.CompeticionRepository;


@Service
public class CompeticionDAO {

	@Autowired
	CompeticionRepository competicionRepository;
	
	public Competicion crearCompeticion(Competicion comp) {
		return competicionRepository.save(comp);
	}
	
	public Optional<Competicion>buscarCompeticionId(Integer id) {
		return competicionRepository.findById(id);
	}
	
	public void eliminarCompeticion(Competicion comp) {
		competicionRepository.delete(comp);
	}
	
	public Optional<Competicion> buscarCompeticionNombre(String nombre) {
		return competicionRepository.buscarCompeticionNombre(nombre);
	}
	
	public List<Evento> buscarEventosCompeticion(String nombre){
		return competicionRepository.buscarEventosCompeticion(nombre);
	}
}


