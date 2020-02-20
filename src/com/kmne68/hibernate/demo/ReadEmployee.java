package com.kmne68.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kmne68.hibernate.entity.Employee;

public class ReadEmployee {
	
	public void readEmployee(int key) {
	
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		// retrieve an object by primary key
		try {
			session.beginTransaction();
			
			// query employees
			List<Employee> employees = session.createQuery("from Employee").getResultList();
			
			// display the list
			displayEmployees(employees);
			
			// query employees id = 1
			employees = session.createQuery("from Employee e where e.id = " + key).getResultList();
			
			// display the new list
			displayEmployees(employees);
			
		} catch (Exception e) {
			
			System.out.println("Saving employee failed because : B" + e.getMessage());
			
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
