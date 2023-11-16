package com.valtech.training.firstspringboot.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.firstspringboot.models.ChangePasswordModel;
import com.valtech.training.firstspringboot.models.RegisterUserModel;
import com.valtech.training.firstspringboot.services.AuthService;

@Controller
public class AuthController {
	
	@GetMapping("/user")  
	@ResponseBody 
	public String userPage() {
		return "User Page";
	}
	
	@GetMapping("/anon")
	@ResponseBody 
	public String anonPage() {
		return "Anonymous Page";
	}
	
	@GetMapping("/admin")
	@ResponseBody 
	public String adminPage() {
		return "Admin Page";
	}

	@GetMapping("/login")
	public String login() {
		return "login";  // goes to login page
	}
	
	@GetMapping("/register")
	public String registerForm() {
		return "register";
	}
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register") // to register a user
	public String handleRegistration(@ModelAttribute RegisterUserModel regUserModel, Model model) {
		if(Objects.equals(regUserModel.getPassword(),regUserModel.getConfirmPassword())) {
			authService.createUser(regUserModel);
			model.addAttribute("message","User resgistration successful. Please login to proceed");
		}else {
			model.addAttribute("message","Password and confirm password don't match");
			return "register";
		}
		return "login";
	} 
	
	@GetMapping("/changePassword")
	public String changePasswordForm() {
		return "changePassword";
	}
	
	@PostMapping("/changePassword")
	public String handleChangePassword(@AuthenticationPrincipal UserDetails userDetails, 
			@ModelAttribute ChangePasswordModel changePasswordModel, Model model) {
		changePasswordModel.setUsername(userDetails.getUsername());
		if(Objects.equals(changePasswordModel.getNewPassword(),changePasswordModel.getConfirmPassword())) {
			if(authService.changePassword(changePasswordModel)) {
				model.addAttribute("message", "Password changed successfully");
			}else {
				model.addAttribute("message", "Old password doesn't match");
				return "changePassword";
			}
		}else {
			model.addAttribute("message", "Password and Confirm password doesn't match");
			return "changePassword";
		}
		return "redirect:logout";
	}
}
