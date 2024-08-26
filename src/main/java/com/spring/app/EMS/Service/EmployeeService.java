package com.spring.app.EMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.EMS.Model.Employee;
import com.spring.app.EMS.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void saveEmployee(Employee emp) {
		employeeRepository.save(emp);
	}

	public Employee isExist(Employee emp) {
		String logEmail = emp.getEmail();
		String logPassword = emp.getPassword();
		List<Employee> allEmp = employeeRepository.findAll();
		Employee foundEmp = null;
		for (Employee e : allEmp) {
			if (e.getEmail().equals(logEmail) && e.getPassword().equals(logPassword)) {
				foundEmp = e;
				break;
			}
		}
		return foundEmp;
	}

}
