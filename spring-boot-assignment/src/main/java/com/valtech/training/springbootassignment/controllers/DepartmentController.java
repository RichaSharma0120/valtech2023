package com.valtech.training.springbootassignment.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.training.springbootassignment.models.DepartmentModel;
import com.valtech.training.springbootassignment.models.EmployeeModel;
import com.valtech.training.springbootassignment.services.DepartmentService;
import com.valtech.training.springbootassignment.services.EmployeeService;

@Controller("/department")
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	EmployeeService employeeService;
	DepartmentModel deptModel;

	@GetMapping("/departmentList")
	public String viewDepartmentList(Model model) {
		deptModel = new DepartmentModel(departmentService.getFirstDepartment());
		model.addAttribute("department", deptModel);
		model.addAttribute("employees", 
				deptModel.getEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "department/departmentList";
	}
	
	@GetMapping("/first")
	public String firstDepartment(Model model) {
		deptModel = new DepartmentModel(departmentService.getFirstDepartment());
		model.addAttribute("department", deptModel);
		model.addAttribute("employees", 
				deptModel.getEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "department/departmentList";
	}
	
	@GetMapping("/last")
	public String lastDepartment(Model model) {
		deptModel = new DepartmentModel(departmentService.getLastDepartment());
		model.addAttribute("department", deptModel);
		model.addAttribute("employees", 
				deptModel.getEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "department/departmentList";
	}
	
//	@GetMapping("/next")
//	public String nextDepartment(Model model) {
//		deptModel = new DepartmentModel(departmentService.getLastDepartment());
//		model.addAttribute("department", deptModel);
//		model.addAttribute("employees", 
//				deptModel.getEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
//		return "department/departmentList";
//	}
	
	@GetMapping("/next")
	public String nextDepartment(@RequestParam("id") int id, Model model) {
		deptModel = new DepartmentModel(departmentService.getLastDepartment());
		if(deptModel.getId() > id) {
			deptModel = new DepartmentModel(departmentService.getDepartment(id + 1));
		}
		model.addAttribute("department", deptModel);
		model.addAttribute("employees", 
				deptModel.getEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "department/departmentList";
	}
	
	@GetMapping("/previous")
	public String previousDepartment(@RequestParam("id") int id, Model model) {
		deptModel = new DepartmentModel(departmentService.getFirstDepartment());
		if(deptModel.getId() < id) {
			deptModel = new DepartmentModel(departmentService.getDepartment(id - 1));
		}
		model.addAttribute("department", deptModel);
		model.addAttribute("employees", 
				deptModel.getEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "department/departmentList";
	}

}
