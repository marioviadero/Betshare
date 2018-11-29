package com.marioviadero.Betshare.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Competicion")
public class Competicion implements Serializable{

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_competicion", unique = true, nullable = false)
	private int idCompeticion;
	@Column(length = 30, name= "nombre", unique=true, nullable = false)
	private String nombre;
	@Column(length = 45, name= "descripcion")
	private String descripcion;
	@Column(length = 20, name= "deporte", nullable = false)
	private String deporte;
	
	public Competicion() {
	}
	
	public void setIdCompeticion(int idCompeticion) {
		this.idCompeticion = idCompeticion;
	}
	public int getIdCompeticion() {
		return this.idCompeticion;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public String getDeporte() {
		return this.deporte;
	}

	
	
	@Override
    public int hashCode() {
        int hash = 0;
        //hash, suma hash + (si nombre no es null, añade el hashcode del nombre, si es null 0)
        hash += (nombre != null ? nombre.hashCode() : 0);
        hash += (deporte != null ? deporte.hashCode() : 0);
        return hash;
    }
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Competicion)) {
            return false;
        }
        Competicion cmp = (Competicion) obj;
        //Si los nombres, son iguales y el deporte tambien, entonces estamos ante la misma Competicion
        if (this.nombre.equals(cmp.getNombre()) && this.deporte.equals(cmp.getDeporte())) {
        	return true;
        }
        			
		return false;	
	}
}
