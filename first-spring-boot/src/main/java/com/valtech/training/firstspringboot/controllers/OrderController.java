package com.valtech.training.firstspringboot.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.training.firstspringboot.models.OrderModel;
import com.valtech.training.firstspringboot.services.OrderService;

@Controller
@RequestMapping(path="/orders") // url should be small letters
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//------------- CANCEL BUTTON
	@PostMapping(path="/save", params="cancel")
	public String cancelEditOrder(Model model) {
		model.addAttribute("orders",orderService.getAll().stream().map(o -> new OrderModel(o)).collect(Collectors.toList()));
		return "orders/list";
	}
	
	//--------- CREATE BUTTON
	@PostMapping(path="/save",params="submit")
	public String saveOrder(@ModelAttribute OrderModel orderModel, @RequestParam("submit") String submit,Model model) {
		if(submit.equals("Create")) {
			orderService.createOrder(orderModel.getOrder());
		}
		model.addAttribute("orders",orderService.getAll().stream().map(o -> new OrderModel(o)).collect(Collectors.toList()));
		return "orders/list";
	}
	
	 //-------------- NEW ORDER
	@GetMapping("/new")
	public String newOrder(Model model) {
		model.addAttribute("order",new OrderModel());
		return "orders/edit";
	}
	
	//------------ SHOW LIST OF ITEMS
	@GetMapping("/list")
	public String listOrders(Model model) {
//		return "orders/list"; //name of the page = list
		// means there is an orders folder with a page called list
		model.addAttribute("orders",orderService.getAll().stream().map(o -> new OrderModel(o)).collect(Collectors.toList()));
		return "orders/list";
	}
	
	//--------- DELETE 
	@GetMapping("/delete")
	public String deleteOrder(@RequestParam("id") long id, Model model) {
		model.addAttribute("orders",orderService.getAll().stream().map(o -> new OrderModel(o)).collect(Collectors.toList()));
		return "orders/list";
	}
	
	//---------- EDIT
	@GetMapping("/edit")
	public String editOrder(@RequestParam("id") long id, Model model) {
		model.addAttribute("order",new OrderModel(orderService.getOrder(id)));
		return "orders/edit";
	}
	
}
