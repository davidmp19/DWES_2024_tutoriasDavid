package com.spring.start.h2.actividad;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.start.h2.enmarca.Enmarca;
import com.spring.start.h2.plan.Plan;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Actividad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private boolean obligatoria;
	private String nombre,descripcion;
	
	@OneToMany(
			targetEntity=Enmarca.class,
			mappedBy="actividad")
	
	@JsonBackReference
	private Set<Plan> planes = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isObligatoria() {
		return obligatoria;
	}

	public void setObligatoria(boolean obligatoria) {
		this.obligatoria = obligatoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Plan> getPlanes() {
		return planes;
	}

	public void setPlanes(Set<Plan> planes) {
		this.planes = planes;
	}

	@Override
	public String toString() {
		return "Actividad [id=" + id + ", obligatoria=" + obligatoria + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", planes=" + planes + "]";
	}
	
	
}
