package org.java.spring.controller;


import java.util.List;

import org.java.spring.Pizza;
import org.java.spring.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/pizzas")
	public String pizzaIndex(Model model) {
		List<Pizza> pizzas = pizzaService.findAll();
		
		model.addAttribute("pizzas", pizzas);
		
		return "pizzas";
	}
}
