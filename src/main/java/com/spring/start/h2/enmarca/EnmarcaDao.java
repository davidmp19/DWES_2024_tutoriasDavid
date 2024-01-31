package com.spring.start.h2.enmarca;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EnmarcaDao extends CrudRepository<Enmarca, Long>{
	 @Query("SELECT COUNT(en) > 0 FROM Enmarca en WHERE en.plan.nombre = :nombrePlan AND en.actividad.nombre = :nombreActividad")
	    boolean vinculados(@Param("nombrePlan") String nombrePlan,
	                                     @Param("nombreActividad") String nombreActividad);
}
