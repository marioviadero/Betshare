package com.marioviadero.Betshare.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marioviadero.Betshare.model.Usuario;
import com.marioviadero.Betshare.repository.UsuarioRepository;

@Service
public class UsuarioDAO {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	/*Registrar usuario
	 * Utiliza el metodo save del repositorio spring
	 * 
	 */
	public Usuario registro(Usuario us) {
		return usuarioRepository.save(us);
	}

	/*
	 * Listar Usuario
	 */	 
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> buscarUsuarioId(Integer id) {
		return usuarioRepository.findById(id);
	}
	
	public void eliminar(Usuario us) {
		usuarioRepository.delete(us);
	}
	
}
