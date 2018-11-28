package com.marioviadero.Betshare.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Evento")
public class Evento {
	
	private int idEvento;
	private String local;
	private String visitante;
	private Date fecha;
	private String descripcion;
	private int idCompeticion;
	private String estado;

	
	
	
	
	
	/**
	java.util.Date dt = new java.util.Date();
	java.text.SimpleDateFormat sdf = 
	     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String currentTime = sdf.format(dt);
	*/
}
