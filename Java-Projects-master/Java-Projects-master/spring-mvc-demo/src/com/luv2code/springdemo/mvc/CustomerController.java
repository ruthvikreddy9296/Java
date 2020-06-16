package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	//add an initbinder to convert or trim input strings
	//remove leading and tralling whitespace
	//resolve issue for our validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingresult) {
		
		System.out.println("Last name: |" + theCustomer.getLastName());
		
		System.out.println("Binding Result: "+ theBindingresult);
		
		System.out.println("\n\n\n\n");
		
		if(theBindingresult.hasErrors()) {
			//System.out.println("In side the if part");
			return "customer-form";
		}
		else {
			//System.out.println("In side the else part");
			return "customer-confirmation";
		}
		
	}
	

}
