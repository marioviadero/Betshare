package com.marioviadero.Betshare.model;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Evento")
public class Evento {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_evento", unique = true, nullable = false)
	private int idEvento;
	@Column(length = 50, name= "local", nullable = false)
	private String local;
	@Column(length = 50, name= "visitante", nullable = false)
	private String visitante;
	@Column (name ="fecha_nac", nullable = false)
	private Date fecha;
	@Column(length = 80, name= "descripcion")
	private String descripcion;
	@Column(name= "id_competicion")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="eventos")
	private Competicion competicion;
	@Column(length = 50, name= "estado")
	private String estado;
	@OneToMany(mappedBy="evento")
	private List<Cuota> cuotas;
	
	
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public int getidEvento() {
		return this.idEvento;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getLocal() {
		return this.local;
	}
	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}
	public String getVisitante() {
		return this.visitante;
	}
	public void setFecha(Date fecha) {
		this.fecha=fecha;
	}
	public Date getFecha() {
		return this.fecha;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void competicion(Competicion competicion) {
		this.competicion=competicion;
	}
	public Competicion getCompeticion() {
		return this.competicion;
	}
	public void setEstado(String estado) {
		this.estado=estado;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas=cuotas;
	}
	public List<Cuota> getCuotas(){
		return this.cuotas;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (local != null ? local.hashCode() : 0);
        hash += (visitante != null ? visitante.hashCode() : 0);
        hash += (competicion != null ? competicion.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Evento)) {
            return false;
        }
        Evento evt = (Evento) obj;
        //Si los nombres, son iguales y el deporte tambien, entonces estamos ante la misma Competicion
        if (this.local.equals(evt.getLocal()) && this.visitante.equals(evt.getVisitante())
        		&& this.competicion.equals(evt.getCompeticion())) {
        	return true;
        }
        			
		return false;	
	}
	
	/**
	java.util.Date dt = new java.util.Date();
	java.text.SimpleDateFormat sdf = 
	     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String currentTime = sdf.format(dt);
	*/
}
