package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class NavController
{
	
	@GetMapping("/register")
	public String registration()
	{
		return "registration";
	}
	@GetMapping("/")
	public String index2()
	{
		return "login";
	}

	@GetMapping("/login")
	public String index()
	{
		return "login";
	}
	
	@GetMapping("/sales")
	public String salesTeam()
	{
		return "sales";
	}
	
	@GetMapping("/project")
	public String projectTeam()
	{
		return "project";
	}
	
	@GetMapping("/createorder")
	public String createorder()
	{
		return "createOrder";
	}
	
	@GetMapping("/updateorders")
	public String updateorders()
	{
		return "update";
	}
	
	@GetMapping("/updateOrder")
	public String updateOrder()
	{
		return "updateOrder";
	}
	@GetMapping("/updateOrderAgain")
	public String updateOrderagn()
	{
		return "updateOrderAgain";
	}
	@GetMapping("/deleteorder")
	public String deleteorder()
	{
		return "deleteOrder";
	}
	@GetMapping("/delete")
	public String deleteorders()
	{
		return "delete";
	}
	
	@GetMapping("/invalid")
	public String invalid()
	{
		return "invalid";
	}
	
}

