package com.tahmid.spring;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("/welcome/{countryName}/{userName}")
	public ModelAndView helloWorld(@PathVariable Map<String, String> pathVars) {

		String name = pathVars.get("userName");
		String country = pathVars.get("countryName");

		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", "hello " + name + " You are from " + country);

		return model;
	}
	
	@ModelAttribute
	public void addingCommonObjects(Model model){
		model.addAttribute("headerMsg", "Demo App");
	}
	
	@RequestMapping(value="/infoForm.html", method = RequestMethod.GET)
	public ModelAndView getTheForm() {
		ModelAndView model = new ModelAndView("InfoForm");
		return model;
	}
	
	@RequestMapping(value="/submitForm.html", method = RequestMethod.POST)
	public ModelAndView submitTheForm(@ModelAttribute("student")Student student) {
		ModelAndView model = new ModelAndView("SubmitForm");
		return model;
	}
	
}
