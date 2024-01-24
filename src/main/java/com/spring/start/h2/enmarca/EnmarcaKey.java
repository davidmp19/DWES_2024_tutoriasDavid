package com.spring.start.h2.enmarca;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable 
public class EnmarcaKey implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Column 
	private int idActividad; 
	@Column 
	private int idPlan;
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnmarcaKey other = (EnmarcaKey) obj;
		return Objects.equals(idActividad, other.idActividad) && Objects.equals(idPlan, other.idPlan);
	} 
}
