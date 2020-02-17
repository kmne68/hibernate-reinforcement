package com.kmne68.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kmne68.hibernate.entity.Employee;

public class EmployeeCreateDemo {
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Creating new employee...");
			Employee employee = new Employee("Frodo", "Baggins", "Mayor");
			
			session.beginTransaction();
			
			System.out.println("Saving the employee...");
			session.save(employee);
			
			System.out.println("Commiting the transaction.");
			session.getTransaction().commit();
			
			System.out.println("Employee was saved.");
			
		} catch(Exception e) {
			System.out.println("Saving employee failed because: " + e);
			
		} finally {
			
			factory.close();
		}
	
	}
	
}
