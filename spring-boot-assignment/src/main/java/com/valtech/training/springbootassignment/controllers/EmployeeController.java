package com.valtech.training.springbootassignment.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.training.springbootassignment.models.EmployeeModel;
import com.valtech.training.springbootassignment.services.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// ------------ SHOW LIST OF Employees
	@GetMapping("/employeeList")
	public String viewEmployeeList(Model model) {
		model.addAttribute("employees", 
				employeeService.getAllEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "employee/employeeList";
	}

	// -------------- NEW employee
	@GetMapping("/new")
	public String newEmployee(Model model) {
		model.addAttribute("employees", new EmployeeModel());
		return "employee/editEmployee";
	}

	@PostMapping(path = "/save")
	public String saveEmployee(Model model, @RequestParam("submit") String submit,
			@ModelAttribute EmployeeModel employeeModel) {
		if (submit.equals("Update")) {
			employeeService.createEmployee(employeeModel.getEmployee());
		}
		model.addAttribute("employees",
				employeeService.getAllEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "employee/employeeList";
	}
	
	// ---------CANCEL
		@PostMapping(path = "/save", params = "cancel")
		public String cancelEditEmployee(Model model) {
			model.addAttribute("employees",
					employeeService.getAllEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
			return "employee/employeeList";
		}

	// -----------delete employee
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id, Model model) {
		employeeService.deleteEmployee(id);
		model.addAttribute("employees",
				employeeService.getAllEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "employee/employeeList";
	}

	// -----------view employee
	@GetMapping("/view")
	public String viewEmployee(@RequestParam("id") int id, Model model) {
		model.addAttribute("employees", new EmployeeModel(employeeService.getEmployee(id)));
		return "employee/viewEmployee";
	}

	// --------edit employee
	@GetMapping("/edit")
	public String editEmployee(@RequestParam("id") int id, Model model) {
		model.addAttribute("employees", new EmployeeModel(employeeService.getEmployee(id)));
		return "employee/editEmployee";
	}

	

}
