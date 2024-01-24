package com.spring.start.h2.plan;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.start.h2.curso.CursoDAO;
import com.spring.start.h2.tutor.Tutor;
import com.spring.start.h2.tutor.TutorDAO;






@RestController
public class PlanController {
	@Autowired
	PlanDAO planDao;
	
	@Autowired
	CursoDAO cursoDao;
	
	@Autowired
	TutorDAO tutorDao;
	
	
	@GetMapping("/plan")
	public ModelAndView tutorias() {

		ModelAndView model = new ModelAndView();
		model.setViewName("planes");
		
		List<Plan> planes = (List<Plan>) planDao.findAll();
		model.addObject("planes", planes);
		
		return model;
	}
	

	
	
	
	@GetMapping("/plan/{id}")
	public ModelAndView tutoria(@PathVariable long id) {
		
		Plan plan = planDao.findById(id).get();
		
		ModelAndView model = new ModelAndView();
		model.setViewName("plan");
		model.addObject("plan", plan);
		
		return model;
	}	
	
	
	
	
	
	@GetMapping("/plan/add")
	public ModelAndView addPlan() {
				
		ModelAndView model = new ModelAndView();
		
		model.addObject("plan", new Plan());
		model.addObject("cursos", cursoDao.findAll());
		model.addObject("tutores", tutorDao.getTutoresNoEnlazados());
	
		model.setViewName("formPlan");
		
		 
		return model;
	}	

	

	
	@GetMapping("/plan/edit/{id}")
	public ModelAndView editPlan(@PathVariable long id) {
				
		ModelAndView model = new ModelAndView();
		
		Optional<Plan> planazo = planDao.findById(id);
		if(planazo.isPresent()) {
			
			model.addObject("plan", planazo.get());
			model.addObject("cursos", cursoDao.findAll());
			model.addObject("tutores", tutorDao.getTutoresNoEnlazados());
			
			System.out.println(tutorDao.getTutoresNoEnlazados());
			
			model.setViewName("formPlan");
		}
		else model.setViewName("redirect:/plan");	
		
		return model;
	}	
	
	
	
	
	
	@GetMapping("/plan/del/{id}")
	public ModelAndView delPlan(@PathVariable long id) {
				
		planDao.deleteById(id);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/plan");
		
		return model;
	}	
	
	
	
	
	
	@GetMapping("/plan/tutor/del/{idPlan}")
	public ModelAndView eliminarTutoriaTutor(@PathVariable long idPlan) {
		
		Optional<Plan> plan = planDao.findById(idPlan);
		if(plan.isPresent()) {
			
			Plan planazo = plan.get();
			Tutor tutor = planazo.getTutor();
			planazo.setTutor(null);
			tutor.setPlan(null);
			planDao.save(planazo);
		}
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/plan");		
		
		return model;
	}
	
	
	
	
	
	
	
	@PostMapping("/plan/save")
	public ModelAndView formTutoria(@ModelAttribute Plan plan) {
		Tutor tutor=plan.getTutor();
		tutor.setPlan(plan);
		planDao.save(plan);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/plan");	
		
		return model;
	}	
	
}
