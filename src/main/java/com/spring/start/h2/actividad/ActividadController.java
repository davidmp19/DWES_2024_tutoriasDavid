package com.spring.start.h2.actividad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.start.h2.enmarca.EnmarcaDao;

@Controller
public class ActividadController {


	@Autowired
	ActividadDao actividadDAO;
	@Autowired
	EnmarcaDao enmarcaDAO;
	

	@GetMapping("/actividad")
	public ModelAndView getActividades() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("actividad");
		List<Actividad> actividades = (List<Actividad>)actividadDAO.findAll();
		
		model.addObject("actividad", actividades);
		
		return model;
	}

}
