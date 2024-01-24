package com.spring.start.h2.enmarca;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.start.h2.actividad.Actividad;
import com.spring.start.h2.plan.Plan;


import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Enmarca {
	
	@EmbeddedId EnmarcaKey id; 
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("idActividad") 
	@JoinColumn(name = "idactividad") 
	@JsonManagedReference
	Actividad actividad; 
	@ManyToOne 
	@MapsId("idPlan") 
	@JoinColumn(name = "idplan") 
	@JsonManagedReference
	Plan plan;
	
	private String fecha;
	
	public EnmarcaKey getId() {
		return id;
	}
	public void setId(EnmarcaKey id) {
		this.id = id;
	}
	public Actividad getActividad() {
		return actividad;
	}
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
