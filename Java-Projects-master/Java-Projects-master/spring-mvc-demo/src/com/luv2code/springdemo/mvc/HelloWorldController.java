package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller method to show initial form
	
	@RequestMapping("/showForm")
	public String showForm(){
		return "helloWorld-form";
	}
	
	@RequestMapping("/processForm")
	//need a controller method to process a form
	public String processForm() {
		return "helloworld";
	}
	
	//new controller method to read form data
	//and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//read the request parameter from the html form
		String theName = request.getParameter("studentName");
		
		//Convert the data to upper case
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Hello! " +theName;
		
		//add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
	
		//new controller method to read form data
		//and add data to the model
		@RequestMapping("/processFormVersionThree")
		public String processFormVersionThree(
				@RequestParam("studentName") String theName,
				Model model) {
			
			//Convert the data to upper case
			theName = theName.toUpperCase();
			
			//create the message
			String result = "Hello Friend form UMKC! " +theName;
			
			//add message to the model
			model.addAttribute("message", result);
			
			return "helloworld";
		}

	}

