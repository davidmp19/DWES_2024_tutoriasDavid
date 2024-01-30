package com.spring.start.h2.enmarca;

import com.spring.start.h2.actividad.Actividad;
import com.spring.start.h2.plan.Plan;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Enmarca {
  
	
	 @Id 
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private long id;

	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idactividad") 
	Actividad actividad; 
	@ManyToOne 
	@JoinColumn(name = "idplan") 
	Plan plan;
	
	private String fecha;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
