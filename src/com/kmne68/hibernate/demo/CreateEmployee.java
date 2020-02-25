package com.kmne68.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kmne68.hibernate.entity.Employee;

public class CreateEmployee {
	
	
	public void createEmployee() {
	
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Creating new employee...");
			Employee employee = new Employee("Meriadoc", "Brandybuck", "Swordthains");
			
			session.beginTransaction();
			
			System.out.println("Saving the employee...");
			session.save(employee);
			
			System.out.println("Commiting the transaction.");
			session.getTransaction().commit();
			
			System.out.println("Employee was saved.");
			
		} catch(Exception e) {
			System.out.println("Saving employee failed because A: " + e);
			
		}
		finally {
			
			factory.close();
		}	
	}
}

