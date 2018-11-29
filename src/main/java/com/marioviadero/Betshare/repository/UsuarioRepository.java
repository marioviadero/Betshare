package com.marioviadero.Betshare.repository;
import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.marioviadero.Betshare.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	//Usuario getUsuarioLogin(String login);
	//Usuario getUsuarioEmail(String email);
	//Collection<Usuario> getUsuarios();
	//boolean deleteUserByLogin(String login);

	
}
