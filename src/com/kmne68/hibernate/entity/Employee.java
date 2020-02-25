package com.kmne68.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;


/**
 * 
 * @author kmne68
 * 
 * This program is intended to reinforce basic hibernate CRUD skills.
 *
 */


@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="company")
	private String company;
	
	
	public Employee() {
		
	}
	
	
	public Employee(String firstName, String lastName, String company) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
	}
	
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getLastName() {
		return this.lastName;
	}
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getFirstName() {
		return this.firstName;
	}
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String company() {
		return this.company;
	}
	
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	@Override
	public String toString() {
		return "Employee: " + lastName + ", " + firstName + "; Company: " + company;
	}
}
