package com.spring.start.h2.enmarca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.start.h2.actividad.ActividadDao;

import com.spring.start.h2.plan.PlanDAO;

@Controller
public class EnmarcaController {
	
	@Autowired
	EnmarcaDao enmarcaDAO;
	@Autowired
	ActividadDao actividadDAO;
	@Autowired
	PlanDAO planDAO;
	
	@GetMapping("/enmarca")
	public ModelAndView getEnmarca() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("enmarca");
		List<Enmarca> listaEnmarca = (List<Enmarca>)enmarcaDAO.findAll();
		model.addObject("listaEnmarca", listaEnmarca);
		
		return model;
	}
	
	@GetMapping("/enmarca/add")
	public ModelAndView enmarcar() {
				
		ModelAndView model = new ModelAndView();
		model.setViewName("enmarcaForm");
		model.addObject("enmarca", new Enmarca());
		
		
		model.addObject("planes", planDAO.findAll());
		model.addObject("actividades", actividadDAO.findAll());
		
		
		 
		return model;
	}	
	
	@GetMapping("/enmarca/del/{id}")
	public ModelAndView delPlan(@PathVariable long id) {
				
		
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/enmarca");
		enmarcaDAO.deleteById(id);	
		return model;
	}
		



	@PostMapping("/enmarca/save")
	public ModelAndView savePlan(@ModelAttribute Enmarca enmarca) {

		ModelAndView model = new ModelAndView();

		model.setViewName("redirect:/enmarca");
		enmarcaDAO.save(enmarca);

		return model;
	}
	
}

