package com.gcu;

import java.util.Iterator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.SecurityServiceInterface;
import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	SecurityServiceInterface securityService;

	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
				
	}
	
	/*
	 * This method will echo contents of the login form using the toString method of the login model
	 * 
	 * BindingResult holds the result of a validation and binding and contains errors that may have occured.
	 */
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		//console output showing that the securityService is running
		securityService.test();
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		if(securityService.isAuthenticated(loginModel)) {
			model.addAttribute("model", loginModel);
			return "loginSuccess";
		}
		else {
			return "login";
		}
		
	}
	
}
