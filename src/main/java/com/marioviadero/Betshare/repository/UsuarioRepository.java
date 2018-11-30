package com.marioviadero.Betshare.repository;
import java.util.Optional;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marioviadero.Betshare.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query("SELECT u FROM Usuario u WHERE (u.login) = :login")
	Optional<Usuario> buscarUsuarioLogin(@Param("login") String login);
	@Query("SELECT u FROM Usuario u WHERE (u.email) = :email")
	Optional<Usuario> buscarUsuarioEmail(@Param("email") String email);
	//boolean deleteUserByLogin(String login);

	
}
