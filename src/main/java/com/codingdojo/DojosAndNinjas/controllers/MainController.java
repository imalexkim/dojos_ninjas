package com.codingdojo.DojosAndNinjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.DojosAndNinjas.models.Dojo;
import com.codingdojo.DojosAndNinjas.models.Ninja;
import com.codingdojo.DojosAndNinjas.service.DojoService;
import com.codingdojo.DojosAndNinjas.service.NinjaService;

@Controller
public class MainController {
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	

	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dojos")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos";
		}
		
	}

	@GetMapping("/ninjas")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("ninjas", ninjaService.allNinjas());
		model.addAttribute("dojos", dojoService.allDojos());
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.allDojos());
			model.addAttribute("ninjas", ninjaService.allNinjas());
			return "newNinja.jsp";
		}else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas";
		}
		
	}
	@GetMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Ninja ninja = ninjaService.findNinja(id);
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojos", dojo);
		model.addAttribute("ninjas", ninja);
		return "show.jsp";
	}
	

}
