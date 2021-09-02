package com.sf.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sf.company.dao.CustomerDAO;
import com.sf.company.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> thecustomers=customerDAO.getCustomers();
		
		theModel.addAttribute("customers",thecustomers);
		
		return "listcustomers";
	}
	
	
	
}
