package com.kmne68.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kmne68.hibernate.entity.Employee;

public class EmployeeCreateDemo {
	
	public static void main(String[] args) {
		
		CreateEmployee ce = new CreateEmployee();
		ce.createEmployee();
		
		ReadEmployee re = new ReadEmployee();
		re.readEmployee(2);

		FindEmployeeByCompany febc = new FindEmployeeByCompany();
		febc.findEmployeeById("Garden Center");
		
		DeleteEmployeeById debi = new DeleteEmployeeById();
		debi.deleteEmployeeByEd(4);
		
	}
	
}
