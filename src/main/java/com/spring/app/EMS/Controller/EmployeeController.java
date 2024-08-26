package com.spring.app.EMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.app.EMS.Model.Employee;
import com.spring.app.EMS.Service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	private Employee flag;
	private String name;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/home/signup")
	public String signUp(Model m) {
		Employee e = new Employee();
		m.addAttribute("employee", e);
		return "signup";
	}

	@PostMapping("/home")
	public String saveEmployee(@ModelAttribute Employee emp) {
		employeeService.saveEmployee(emp);
		return "redirect:/home";
	}

	@GetMapping("/home/login")
	public String findEmployee(Model m) {
		Employee fe = new Employee();
		m.addAttribute("findEmployee", fe);
		return "login";
	}

	@PostMapping("/home/profile")
	public String findExist(@ModelAttribute Employee emp, Model m) {
		flag = employeeService.isExist(emp);
		if (flag != null) {
			name = flag.geteName();
			m.addAttribute("ename", name);
			return "afterlog";
		} else {
			return "redirect:/home/login";
		}
	}

	@GetMapping("/home/profile")
	public String backHome(Model m) {
		if (flag != null) {
			name = flag.geteName();
			m.addAttribute("ename", name);
			return "afterlog";
		} else {
			return "redirect:/home/login";
		}
	}

	@GetMapping("/home/afterlog/profile")
	public String profile(Model m) {
		if (flag != null) {
			m.addAttribute("employee", flag);
			return "profile";
		} else {
			return "redirect:/home";
		}

	}

	@GetMapping("/home/profile/edit")
	public String editEmployee(Model m) {
		if (flag != null) {
			m.addAttribute("employee", flag);
			return "edit";
		} else {
			return "redirect:/home";
		}
	}

	@PostMapping("/home/profile/edited")
	public String updateEmployee(@ModelAttribute Employee emp, Model m) {
		if (flag != null) {
			flag.seteName(emp.geteName());
			flag.setDepartment(emp.getDepartment());
			flag.setDesignation(emp.getDepartment());
			flag.setEmail(emp.getEmail());
			flag.setPassword(emp.getPassword());
			flag.seteSalary(emp.geteSalary());
			m.addAttribute("employee", flag);
			return "profile";
		} else {
			return "redirect:/home";
		}
	}

	@GetMapping("/logout")
	public String logout() {
		flag = null;
		name = null;
		return "redirect:/home";
	}
}
