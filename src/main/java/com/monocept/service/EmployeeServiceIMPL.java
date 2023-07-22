package com.monocept.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.monocept.entity.Employee;
import com.monocept.repository.EmployeerRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceIMPL implements EmployeeService{

	@Autowired
	private EmployeerRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public void addAllEmp(List<Employee> employess) {
		employeeRepository.saveAll(employess);
	}

	@Override
	public Employee getEmp(int id) {
		Optional<Employee> emp =  employeeRepository.findById(id);
		return emp.orElse(null);
	}

	@Override
	@Transactional
	public void delEmp(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void updateEmp(Employee employee) {
		
		Optional<Employee> temp = employeeRepository.findById(employee.getEmployeeId());
		
		Employee existingEmployee = temp.get();
		
		if(existingEmployee!=null) {
			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
			existingEmployee.setDepartment(employee.getDepartment());
			existingEmployee.setSalary(employee.getSalary());
			
			employeeRepository.save(existingEmployee);
		}
	}

	@Override
	public Page<Employee> getStudentPagewise(int pageno, int pagesize ,String factor) {
		
		  Sort.Direction sortDirection = Sort.Direction.ASC;
	        if (factor.equalsIgnoreCase("desc")) {
	            sortDirection = Sort.Direction.DESC;
	        }

	        Sort sort = Sort.by(sortDirection, "employeeId");
		
		Pageable pageable = PageRequest.of(pageno, pagesize , sort);
		return employeeRepository.findAll(pageable);
	}

}
