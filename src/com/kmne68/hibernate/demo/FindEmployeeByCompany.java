package com.kmne68.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kmne68.hibernate.entity.Employee;

public class FindEmployeeByCompany {
	
	public void findEmployeeById(String employer) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();
		
		// create session		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			// query employees
			List<Employee> employees = session.createQuery("from Employee").getResultList();
			
			// display the list
			System.out.println("Getting employee by employer");
			displayEmployees(employees);
				
			// query employees where employer = ?
			System.out.println("Get employee by company: ");
			employees = session.createQuery("from Employee e where e.company = '" + employer + "'").getResultList();
			
			// display the new list
			System.out.println("The employees whose employer is " + employer +  " are: ");
			displayEmployees(employees);
			
		} catch(Exception e) {
			System.out.println("Employee could not be saved because: " + e.getMessage());
		}
		finally {
			
			factory.close();
		}		
		
	}
	
	private static void displayEmployees(List<Employee> employees) {
		for(Employee  e : employees) {
			System.out.println(e);
		}
	}
	

}
