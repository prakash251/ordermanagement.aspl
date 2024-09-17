package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Orders;
public interface SalesOrderService 
{
   //for employee registration
	public String registerEmployee(Employee emp);
	
   //for employee validation
	public boolean isvalid(String email, String password);
	
   //get employee object
	public Employee getEmployeeByEmail(String email);
	
   //create orders
	public void create_Orders(Orders od);
	
   //get order object
	public Orders getOrderByid(long orderId);
	
	//delete order
	public void deleteOrder(long id);
	
	//view orders
	public List<Orders> getOrders();

}
