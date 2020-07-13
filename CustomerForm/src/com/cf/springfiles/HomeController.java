package com.cf.springfiles;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cf.entity.Customer;
import com.cf.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class HomeController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> theCustomer = customerService.getCustomers();
		
		theModel.addAttribute("customers",theCustomer);
		return "customers-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String addCustomer(Model theModel) {
		theModel.addAttribute("customer",new Customer());
		return "customer-form";
	}
	
	@GetMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer")Customer theCustomer, BindingResult tbr) {
		if(tbr.hasErrors()) {
			return "customer-form";
		}
		else {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}}
	
	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId")int theId,Model theModel) {
		
		Customer theCustomer = customerService.getCustomers(theId);
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int theId) {
		
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName")String name, Model theModel) {
		
		List<Customer> customer = customerService.searchCustomers(name);
		theModel.addAttribute("customers",customer);
		return "customers-list";
		
		}
}
