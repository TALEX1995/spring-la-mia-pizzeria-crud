package org.java.spring.controller;


import java.util.List;

import org.java.spring.Pizza;
import org.java.spring.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/pizzas")
	public String pizzaIndex(Model model, @RequestParam(required=false) String pizzaName) {
		
		
		List<Pizza> pizzas = pizzaName == null  
				? pizzaService.findAll()
				: pizzaService.findByName(pizzaName);
		
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("pizzaName", pizzaName);
		
		return "pizzas";
	}
	
	@GetMapping("/pizzas/{id}")
	public String pizzaDetail(Model model, @PathVariable int id) {
		
		Pizza pizza = pizzaService.findById(id);
		
		model.addAttribute("pizza", pizza);
		
		return "pizza-detail";
	}
}
