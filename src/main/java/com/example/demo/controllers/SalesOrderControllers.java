package com.example.demo.controllers;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Orders;
import com.example.demo.service.EmailService;
import com.example.demo.service.SalesOrderService;

@Controller
public class SalesOrderControllers 
{
	@Autowired
	SalesOrderService sos; 
	@Autowired
	private EmailService emailService;

	@PostMapping("/register")	
	public String registerEmp(
			@RequestParam("empid")long empid,
			@RequestParam("name") String name,
			@RequestParam("team") String team,
			@RequestParam("email") String email,
			@RequestParam("password") String password

			)	
	{
		Employee emp = new Employee(empid,name,team,email,password);
		String msg=sos.registerEmployee(emp);
		System.out.println(msg);


		return "/login";

	}

	Employee employee;
	@PostMapping("/validation")
	public String validatingEmployee(
			@RequestParam("email") String email,
			@RequestParam("password") String password,Model m)
	{

		boolean bool=sos.isvalid(email,password);
		if(bool)
		{

			employee= sos.getEmployeeByEmail(email);
			String teams=employee.getEmployeeTeam();
			m.addAttribute("emp", employee);
			System.out.println(teams);
			if(teams.equals("sales"))
			{
				return "/sales";
			}
			else 
			{
				return "/project";	
			}
		}
		else
		{
			System.out.println("invalid credientials please register first and login");

			return "/invalid";
		}
	}
	
//	//creating orders
//	@PostMapping("/create")
//	public String createOrders(@RequestParam("order_Title") String orderTitle,
//			@RequestParam("order_Description") String orderDescription,
//			@RequestParam("sales_ReferenceId") String salesReferenceId,
//			@RequestParam("endCustomer_Name") String endCustomerName,
//			@RequestParam("customer_Name") String customerName,
//			@RequestParam("project_Location") String projectLocation,
//			@RequestParam("scopeOf_workDocument") MultipartFile scopeOfWorkDocument,
//			@RequestParam("projectImplementation_Mode") String projectImplementationMode,
//			@RequestParam("status") String status,
//			@RequestParam("assigned_To") String assignedTo
//			)
//	{
//		Orders od = new Orders();
//		System.out.println("order prepared");
//
//
//		od.setOrder_Title(orderTitle);
//		od.setOrder_Description(orderDescription);
//		od.setSales_ReferenceId(salesReferenceId);
//		od.setEndCustomer_Name(endCustomerName);
//		od.setCustomer_Name(customerName);
//		od.setProject_Location(projectLocation);
//		od.setProjectImplementation_Mode(projectImplementationMode);
//		od.setStatus(status);
//		od.setAssigned_To(assignedTo);
//		//od.setScopeOf_workDocument(scopeOfWorkDocument);
//
//	 // Handle the uploaded file
//	    if (!scopeOfWorkDocument.isEmpty()) {
//	        try {
//	            byte[] bytes = scopeOfWorkDocument.getBytes();
//	            // Save the file to a specific directory on your server
//	         //   String uploadDirectory = "C:/salesOrderSpringboot/orders/";
//	            String uploadDirectory = "C:" + File.separator + "salesOrderSpringboot" + File.separator + "orders" + File.separator;
//
//	            String fileName = scopeOfWorkDocument.getOriginalFilename();
//	            Path path = Paths.get(uploadDirectory + fileName);
//	            Files.write(path, bytes);
//	            // Save the file path or other details to your database if needed
//	            od.setScopeOf_workDocument(path.toString());
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	            return "viewOrders";
//	        }
//	    }
//	    
//		sos.create_Orders(od);
//
//		String to ="prakashgutta186@gmail.com"; //"sivakumar.mcp2008@gmail.com";
//		String subject = "New Order Created";
//		String text = "A new order has been created! orderId: " + od.getOrder_Id() + " orderTitle: " + od.getOrder_Title();
//		emailService.sendEmail(to, subject, text);
//		System.out.println("order creted");
//
//		return "redirect:/sales"; // Redirect to the sales page or the appropriate page
//	}

	
	//create order
	@PostMapping("/create")
	public String createOrders(
			@RequestParam("order_Title") String orderTitle,
	        @RequestParam("order_Description") String orderDescription,
	        @RequestParam("sales_ReferenceId") String salesReferenceId,
	        @RequestParam("endCustomer_Name") String endCustomerName,
	        @RequestParam("customer_Name") String customerName,
	        @RequestParam("project_Location") String projectLocation,
	        @RequestParam("scopeOf_workDocument") MultipartFile scopeOfWorkDocument,
	        @RequestParam("projectImplementation_Mode") String projectImplementationMode,
	        @RequestParam("status") String status,
	        @RequestParam("assigned_To") String assignedTo) {

	    Orders od = new Orders();
	    System.out.println("order prepared");

	    od.setOrder_Title(orderTitle);
	    od.setOrder_Description(orderDescription);
	    od.setSales_ReferenceId(salesReferenceId);
	    od.setEndCustomer_Name(endCustomerName);
	    od.setCustomer_Name(customerName);
	    od.setProject_Location(projectLocation);
	    od.setProjectImplementation_Mode(projectImplementationMode);
	    od.setStatus(status);
	    od.setAssigned_To(assignedTo);

	    if (!scopeOfWorkDocument.isEmpty()) {
	        try {
	            byte[] bytes = scopeOfWorkDocument.getBytes();
	            String uploadDirectory = "C:" + File.separator + "salesOrderSpringboot" + File.separator + "orders" + File.separator;

	            // Ensure the directory exists
	            Path uploadPath = Paths.get(uploadDirectory);
	            if (!Files.exists(uploadPath)) {
	                Files.createDirectories(uploadPath);
	            }

	            String fileName = scopeOfWorkDocument.getOriginalFilename();
	            Path filePath = uploadPath.resolve(fileName);
	            Files.write(filePath, bytes);
	            
	            // Save the file path to the order
	            od.setScopeOf_workDocument(filePath.toString());
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "errorPage";  // Return an error view if something goes wrong
	        }
	    }

	    // Save the order
	    sos.create_Orders(od);

	    // Send email notification
//	    String to = "prakashgutta186@gmail.com";
//	    String subject = "New Order Created";
//	    String text = "A new order has been created! orderId: " + od.getOrder_Id() + " orderTitle: " + od.getOrder_Title();
//	    emailService.sendEmail(to, subject, text);
//	    System.out.println("order created");

	    return "redirect:/sales";  // Redirect to the sales page or the appropriate page
	}

	
	

	//update orders
	@PostMapping("/updateo")
	public String updateOrders(
			@RequestParam("orderId") long orderId,Model model)
	{

		Orders order =sos.getOrderByid(orderId);
	    if( order.getOrder_Id()!=0)
		{
		
		System.out.println(order);
		model.addAttribute("order", order);

		return "/updateOrder";
		}
		
		return "/updateOrderAgain";

	}
	//modify orders
	@PostMapping("/modifyOrder")
	public String  modifyOrder
	(
			@RequestParam("order_Id" ) long id,
			@RequestParam("order_Title") String orderTitle,
			@RequestParam("order_Description") String orderDescription,
			@RequestParam("sales_ReferenceId") String salesReferenceId,
			@RequestParam("endCustomer_Name") String endCustomerName,
			@RequestParam("customer_Name") String customerName,
			@RequestParam("project_Location") String projectLocation,
			@RequestParam("scopeOf_workDocument") MultipartFile scopeOfworkDocument,
			@RequestParam("projectImplementation_Mode") String projectImplementationMode,
			@RequestParam("status") String status, 
			@RequestParam("assigned_To") String assignedTo,Model m
			)
	{

		Orders order=sos.getOrderByid(id);
		order.setOrder_Title(orderTitle);
		order.setOrder_Description(orderDescription);
		order.setSales_ReferenceId(salesReferenceId);
		order.setEndCustomer_Name(endCustomerName);
		order.setCustomer_Name(customerName);
		order.setProject_Location(projectLocation);
		//order.setScopeOf_workDocument(scopeOfworkDocument);
		order.setProjectImplementation_Mode(projectImplementationMode);
		order.setStatus(status);
		order.setAssigned_To(assignedTo);
		// Handle the uploaded file
	    if (!scopeOfworkDocument.isEmpty()) {
	        try {
	            byte[] bytes = scopeOfworkDocument.getBytes();
	            // Save the file to a specific directory on your server
	         //   String uploadDirectory = "C:/salesOrderSpringboot/orders/";
	            String uploadDirectory = "C:" + File.separator + "salesOrderSpringboot" + File.separator + "orders" + File.separator;

	            String fileName = scopeOfworkDocument.getOriginalFilename();
	            Path path = Paths.get(uploadDirectory + fileName);
	            Files.write(path, bytes);
	            // Save the file path or other details to your database if needed
	            order.setScopeOf_workDocument(path.toString());
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "viewOrders";
	        }
	    }
	    

		sos.create_Orders(order);


		System.out.println("order updated");
		m.addAttribute("emp",employee);
		return "/sales";
	}
	//delete order
	@PostMapping("/deleteo")
	public String  deleteOrder(@RequestParam("orderId") long id,Model m)

	{

		sos.deleteOrder(id);
		m.addAttribute("emp",employee);
		return "/sales";


	}

	//view orders
	@GetMapping("/vieworders")
	public String viewOrders(Model m)
	{
		List<Orders> ordersList=sos.getOrders();
		System.out.println(ordersList);
		m.addAttribute("orders", ordersList);
		m.addAttribute("emp", employee);
		return "viewOrders";

	}
}










