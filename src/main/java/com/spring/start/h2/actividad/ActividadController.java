package com.spring.start.h2.actividad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.setViewName("actividades");
		List<Actividad> actividades = (List<Actividad>)actividadDAO.findAll();
		
		model.addObject("actividades", actividades);
		
		return model;
	}
	@GetMapping("/actividad/{id}")
	public ModelAndView getActividad(@PathVariable long id) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("actividad");
		model.addObject("actividad", actividadDAO.findById(id).get());
		
		return model;
	}
	@GetMapping("/actividad/del/{id}")
	public ModelAndView deleteActividad(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("actividades");
		actividadDAO.deleteById(id);
		model.addObject("actividades", actividadDAO.findAll());
		
		return model;
	}
}
