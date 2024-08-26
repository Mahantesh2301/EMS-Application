package com.spring.app.EMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.app.EMS.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
