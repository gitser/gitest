package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.form.Client;
import com.form.Client.Frequency;

@Controller
public class FormController {
	
	@ModelAttribute("frequencies")
	public Frequency[] frequencies() {
		return Frequency.values();
	}

	@RequestMapping(value="form", method=RequestMethod.GET)
	public String loadFormPage(Model m) {
		m.addAttribute("client", new Client());
		return "formPage";
	}
	
	@RequestMapping(value="form", method=RequestMethod.POST)
	public String submitForm(@ModelAttribute Client client, Model m) {
		m.addAttribute("message", "Successfully saved person: " + client.toString());
		return "formPage";
	}
}
