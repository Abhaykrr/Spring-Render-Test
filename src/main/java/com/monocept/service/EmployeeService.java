package com.monocept.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.monocept.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployee();
	void addAllEmp(List<Employee> employess);
	Employee getEmp(int id);
	void delEmp(int id);
	void updateEmp(Employee employee);
	
	Page<Employee> getStudentPagewise(int pageno, int pagesize, String factor);
	

}
