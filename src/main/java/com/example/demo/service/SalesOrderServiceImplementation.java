package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Orders;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.SalesOrderRepository;

@Service
public class SalesOrderServiceImplementation  implements SalesOrderService
{
	@Autowired
	EmployeeRepository emr;
	@Autowired
	SalesOrderRepository sor;
	@Override
	public String registerEmployee(Employee emp) 
	{
		emr.save(emp);

		return "employee registerd successffully";
	}
	
	
	public boolean isvalid(String email, String password)
	{
		if(emr.existsByEmail(email))
		{
			Employee em=emr.getByEmail(email) ;
			String dbPassword=em.getPassword();
			if(password.equals(dbPassword))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	
   //getting employee through email address
	@Override
    public Employee getEmployeeByEmail(String email) 
    {
    	Employee ep=emr.getByEmail(email);
		return ep;
    }
	
	
	//create Orders
	public void create_Orders(Orders od)
	{
		
		sor.save(od);
	  System.out.println("order created successfully");
		
	}
	
	
	//get order object
	
	public Orders getOrderByid(long orderId) 
	{ 
	
		//Orders od=sor.findById(orderId).get();
	
		
		//return od;
		
		 Optional<Orders> optionalOrder = sor.findById(orderId);
		    
		    if (optionalOrder.isPresent())
		    {
		        return optionalOrder.get();
		    }
		  return new Orders();
		
	}
	
	
	@Override
	public void deleteOrder(long id)
	{
		
		sor.deleteById(id);
	System.out.println("order deleted succssess fully");
		
	}
	
	
	//view orders
	@Override
	public List<Orders> getOrders()
	{
	List<Orders> orderslist=sor.findAll();
		
		
		return orderslist;
	}
}