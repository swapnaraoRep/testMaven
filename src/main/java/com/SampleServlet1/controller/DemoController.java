package com.SampleServlet1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SampleServlet1.model.Department;
import com.SampleServlet1.model.Employee;

@Controller
public class DemoController {

	@RequestMapping("/hello")
	public String HelloWord(Model model)
	{
		model.addAttribute("message", "WelcomeDemoController");
		System.out.println("From HelloWorld");
		return "helloWorld";
		
	}
	
}
