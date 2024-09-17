package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Orders;
public interface SalesOrderRepository extends JpaRepository<Orders, Long>
{


	

}
