package com.kmne68.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kmne68.hibernate.entity.Employee;

public class DeleteEmployeeById {
	
	public void deleteEmployeeByEd(int employeeId) {
		
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
			List<Employee> employees = session.createQuery("FROM Employee").getResultList();
			
			// display the list
			System.out.println("Display employees:");
			displayEmployees(employees);

			System.out.println("Getting employee with id: " + employeeId);
			Employee employee = session.get(Employee.class,  employeeId);
			
			// delete employee by id
			System.out.println("The employee with ID = " + employeeId + " is " +
								employee.getFirstName() + " " + employee.getLastName());
			
			System.out.println("Deleting employee with id: " + employeeId);
			session.createQuery("DELETE FROM Employee where id = " + employeeId);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done.");
		
		} catch(Exception e) {
			System.out.println("Employee could not be deleted because: " + e);
		} finally {
			factory.close();
		}
	}
		
		
	private static void displayEmployees(List<Employee> employees) {
		for(Employee e : employees) {
			System.out.println(e);
		}
	}

}
