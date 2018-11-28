package com.marioviadero.Betshare.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.*;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable{

		@Id 
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id_usuario", unique = true, nullable = false)
		private Integer idUsuario;
		@Column(length = 50, name= "login", unique=true, nullable = false)
		private String login;
		@Column(length = 40, name ="password", nullable = false)
		private String password;
		@Column(length = 128, name = "email", unique=true ,nullable = false)
		private String email;
		@Column (name ="fecha_nac", nullable = false)
		private Date fechaNac;
		@Column (name="es_admin" , nullable = false)
		private boolean esAdmin;
		
		public Usuario() {}
		
		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
		}
		public int getIdUsuario() {
			return this.idUsuario;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getLogin() {
			return this.login;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPassword() {
			return this.password;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getEmail() {
			return this.email;
		}
		public void setFechaNac(Date fechaNac) {
			this.fechaNac = fechaNac;
		}
		public Date getFechaNac() {
			return this.fechaNac;
		}
		
		public void setEsAdmin(boolean esAdmin) {
			this.esAdmin=esAdmin;
		}
		public boolean getEsAdmin() {
			return this.esAdmin;
		}
		
		@Override
	    public int hashCode() {
	        int hash = 0;
	        //hash, suma hash + (si login no es null, añade el hashcode del login, si es null 0)
	        hash += (login != null ? login.hashCode() : 0);
	        hash += (email != null ? email.hashCode() : 0);
	        return hash;
	    }
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Usuario)) {
	            return false;
	        }
	        Usuario us = (Usuario) obj;
	        //Si los login, son iguales, entonces estamos ante el mismo Usuario(login único)
	        if (this.login.equals(us.getLogin())) {
	        	return true;
	        }
	        			
			return false;	
		}
		
}

