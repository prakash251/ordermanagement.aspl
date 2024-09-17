package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long order_Id;
	String order_Title;
	String order_Description;
	String sales_ReferenceId;
	String endCustomer_Name;
	String customer_Name;
	String project_Location;
	String scopeOf_workDocument;
	String projectImplementation_Mode;
	String status;
	String assigned_To;
	public Orders() 
	{
		super();
	}
	public Orders(long order_Id, String order_Title, String order_Description, String sales_ReferenceId,
			String endCustomer_Name, String customer_Name, String project_Location, String scopeOf_workDocument,
			String projectImplementation_Mode, String status, String assigned_To) 
	{
		super();
		this.order_Id = order_Id;
		this.order_Title = order_Title;
		this.order_Description = order_Description;
		this.sales_ReferenceId = sales_ReferenceId;
		this.endCustomer_Name = endCustomer_Name;
		this.customer_Name = customer_Name;
		this.project_Location = project_Location;
		this.scopeOf_workDocument = scopeOf_workDocument;
		this.projectImplementation_Mode = projectImplementation_Mode;
		this.status = status;
		this.assigned_To = assigned_To;
	}
	
	public long getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(long order_Id) {
		this.order_Id = order_Id;
	}
	public String getOrder_Title() {
		return order_Title;
	}
	public void setOrder_Title(String order_Title) {
		this.order_Title = order_Title;
	}
	public String getOrder_Description() {
		return order_Description;
	}
	public void setOrder_Description(String order_Description) {
		this.order_Description = order_Description;
	}
	public String getSales_ReferenceId() {
		return sales_ReferenceId;
	}
	public void setSales_ReferenceId(String sales_ReferenceId) {
		this.sales_ReferenceId = sales_ReferenceId;
	}
	public String getEndCustomer_Name() {
		return endCustomer_Name;
	}
	public void setEndCustomer_Name(String endCustomer_Name) {
		this.endCustomer_Name = endCustomer_Name;
	}
	public String getCustomer_Name() {
		return customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}
	public String getProject_Location() {
		return project_Location;
	}
	public void setProject_Location(String project_Location) {
		this.project_Location = project_Location;
	}
	public String getScopeOf_workDocument() {
		return scopeOf_workDocument;
	}
	public void setScopeOf_workDocument(String scopeOf_workDocument) {
		this.scopeOf_workDocument = scopeOf_workDocument;
	}
	public String getProjectImplementation_Mode() {
		return projectImplementation_Mode;
	}
	public void setProjectImplementation_Mode(String projectImplementation_Mode) {
		this.projectImplementation_Mode = projectImplementation_Mode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAssigned_To() {
		return assigned_To;
	}
	public void setAssigned_To(String assigned_To) {
		this.assigned_To = assigned_To;
	}
	@Override
	public String toString()
	{
		return "Orders [order_Id=" + order_Id + ", order_Title=" + order_Title + ", order_Description="
				+ order_Description + ", sales_ReferenceId=" + sales_ReferenceId + ", endCustomer_Name="
				+ endCustomer_Name + ", customer_Name=" + customer_Name + ", project_Location=" + project_Location
				+ ", scopeOf_workDocument=" + scopeOf_workDocument + ", projectImplementation_Mode="
				+ projectImplementation_Mode + ", status=" + status + ", assigned_To=" + assigned_To + "]";
	}
	
	
	

}
