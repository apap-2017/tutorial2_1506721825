package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController
{
	@RequestMapping("/hello")
	public String index () {
		return "hello";
	}
	
	@RequestMapping("/perkalian")
	public String perkalian(@RequestParam(value="angka1") int a, @RequestParam(value="angka2") int b, Model model) {
		int c = a*b;
		
		model.addAttribute("angka1", a);
		model.addAttribute("angka2", b);
		model.addAttribute("angka3", c);
		
		return "perkalian";
	}
	
	
	
	
	@RequestMapping("/greeting")
	public String greeting (@RequestParam(value="name", required = false, defaultValue="dunia") String name, Model model)
	{
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping(value = {"/greeting", "greeting/{name}"})
	public String greetingPath (@PathVariable Optional<String> name, Model model)
	{
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "dengklek");
		}
		return "greeting";
	}

}