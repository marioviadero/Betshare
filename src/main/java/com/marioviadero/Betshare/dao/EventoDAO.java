package com.marioviadero.Betshare.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marioviadero.Betshare.model.Cuota;
import com.marioviadero.Betshare.model.Evento;
import com.marioviadero.Betshare.repository.EventoRepository;

@Service
public class EventoDAO {
	
	@Autowired
	EventoRepository eventoRepository;
	
	public Evento crearEvento(Evento ev) {
		return eventoRepository.save(ev);
	}
	
	public Optional<Evento>buscarEventoId(Integer id) {
		return eventoRepository.findById(id);
	}
	
	public void eliminarEvento(Evento ev) {
		eventoRepository.delete(ev);
	}
	
	public List<Cuota> buscarCuotas(Integer id){
		return eventoRepository.buscarCuotas(id);
	}

}
