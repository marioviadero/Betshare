package com.marioviadero.Betshare.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marioviadero.Betshare.dao.UsuarioDAO;
import com.marioviadero.Betshare.model.Usuario;


/*
 * Accede al DAO o @Service
 */
@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	/*
	 * Registro de Usuario
	 * Recibimos un usuario
	 * Buscamos por usuario, si ya existe el login->response not ok
	 * Buscamos por email, si ya existe, response not ok
	 */
	@PostMapping("/registro")
	public ResponseEntity<Usuario> registroUsuario(@Valid @RequestBody Usuario us) {
		Optional<Usuario> usuario = usuarioDAO.buscarUsuarioLogin(us.getLogin());	
		if(usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}	
		usuario = usuarioDAO.buscarUsuarioEmail(us.getEmail());	
		if(usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}	
		
		usuarioDAO.registro(us);
		return ResponseEntity.ok().build();
	}
	
	
	
	@GetMapping("/lista-usuarios")
	public List<Usuario> listarUsuario(){
		return usuarioDAO.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarUsuarioId(@PathVariable(value="id") Integer id){
		Optional<Usuario> us = usuarioDAO.buscarUsuarioId(id);
		
		if(!us.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(us.get());
	}
	
	/*
	 * Actualizar pasamos ID y Usuario
	 */
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> actualizaDatos(@PathVariable(value="id") Integer id, @Valid @RequestBody Usuario us){
		
		Optional <Usuario> usuario=usuarioDAO.buscarUsuarioId(id);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuario.get().setLogin(us.getLogin());
		usuario.get().setEmail(us.getEmail());
		usuario.get().setPassword(us.getPassword());
		usuario.get().setFechaNac(us.getFechaNac());
		usuario.get().setEsAdmin(us.getEsAdmin());
		
		Usuario usuarioActualizado = usuarioDAO.registro(usuario.get());
		
		return ResponseEntity.ok().body(usuarioActualizado);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> eliminaUsuario(@PathVariable(value="id") Integer id){
		Optional<Usuario> us = usuarioDAO.buscarUsuarioId(id);
		
		if(!us.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuarioDAO.eliminar(us.get());
		return ResponseEntity.ok().build();
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@Valid @RequestBody String email,@Valid @RequestBody String password){
		Optional<Usuario> us = usuarioDAO.buscarUsuarioEmail(email);
		us.get().toString();
		if(!us.isPresent()) {
			return ResponseEntity.notFound().build();	//No hay usuario para ese email
		}
		else {
			if(us.get().getPassword().equals(password)) {
				//si los passwords coinciden
				return ResponseEntity.ok().body(us.get());
			}
				
			
		}
		return ResponseEntity.ok().build();	
	}
}
