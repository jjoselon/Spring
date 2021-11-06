package com.elempleo.trabajosihay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elempleo.trabajosihay.model.Vacante;
import com.elempleo.trabajosihay.repository.VacanteRepository;

@Controller
@RequestMapping("/vacante")
public class VacanteController {

	//@Autowired
	private VacanteRepository vacanteRepository;
	
	@GetMapping("/new")
	public String formCreateNewVacante(Vacante vacante) {
		System.out.println(vacanteRepository);
		return "vacante/formcreatenew";
	}
	
	@PostMapping("/save")
	public String saveVacante(Vacante vacante, BindingResult bindingResult, Model model) {
		
		/* Print out errors in console testing */
		if (bindingResult.hasErrors()) {
			for (ObjectError error: bindingResult.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "vacante/formcreatenew";
		}
		
		
		model.addAttribute("vacante", vacante);
		return "vacante/listvacantes";
	}
}
