package com.spring.app.EMS.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String eName;
	private String designation;
	private String email;
	private String password;
	private String eSalary;
	private long phone;
	private String department;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", eName=" + eName + ", designation=" + designation + ", email=" + email
				+ ", password=" + password + ", eSalary=" + eSalary + ", phone=" + phone + ", department=" + department
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String geteSalary() {
		return eSalary;
	}

	public void seteSalary(String eSalary) {
		this.eSalary = eSalary;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Employee() {

	}

	public Employee(String eName, String designation, String email, String password, String eSalary, long phone,
			String department) {
		this.eName = eName;
		this.designation = designation;
		this.email = email;
		this.password = password;
		this.eSalary = eSalary;
		this.phone = phone;
		this.department = department;
	}

}
