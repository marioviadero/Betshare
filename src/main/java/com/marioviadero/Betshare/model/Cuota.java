package com.marioviadero.Betshare.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cuota")
public class Cuota implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cuota", unique = true, nullable = false)
	private int idCuota;
	@Column(length = 20, name= "nombre", nullable = false)
	private String nombre;
	@Column(length = 80, nullable = true)
	private String descripcion;
	@Column(name = "valor", nullable = false)
	private double valor;
	@Column(name = "ganador", nullable = false)
	private boolean ganador;

	public Cuota() {}
	
	public void setIdCuota(int idCuota) {
		this.idCuota = idCuota;
	}
	public int getIdCuota() {
		return this.idCuota;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setValor(double valor) {
		this.valor=valor;
	}
	public void setGanador(boolean ganador) {
		this.ganador=ganador;
	}
	public boolean getGanador() {
		return this.ganador;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);

        return hash;
    }
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Cuota)) {
            return false;
        }
       Cuota ct= (Cuota) obj;
        if (this.nombre.equals(ct.getNombre())) {
        	return true;
        }
        			
		return false;	
	}
}
