package com.monocept.controller;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.sym.Name;
import com.monocept.entity.Employee;
import com.monocept.excep.EmployeeError;
import com.monocept.excep.EmployeeListNotFound;
import com.monocept.repository.EmployeerRepository;
import com.monocept.service.EmployeeService;

@RestController
@RequestMapping("/employeeapp")
public class EmployeeRestController {
	
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private EmployeerRepository empRepo;
	
	
	@GetMapping("/getallemp")
	public ResponseEntity< List<Employee>> getAllEmployee(){
		return new ResponseEntity<>(empService.getAllEmployee(),HttpStatus.OK);
	}
	
	@PostMapping("/addallemp")
	public void addAllEmp(@RequestBody List<Employee> employee) {
		empService.addAllEmp(employee);
	}
	
	@PostMapping("/addemp")
	public void addEmployee(@RequestBody Employee employee) {
		empRepo.save(employee);
	}
	
	@GetMapping("/getemp/{id}")
	public ResponseEntity<Employee> getEmp(@PathVariable(name = "id") int id) {
		
		Employee temp  =  empService.getEmp(id);
		
		if(temp==null) {
			throw new EmployeeListNotFound("Employee Not Found");
		}
		return new ResponseEntity<>(empService.getEmp(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteemp/{id}")
	public void delEmp(@PathVariable(name = "id") int id) {
		empService.delEmp(id);
	}
	
	@PutMapping("/updateemp")
	public void updateEmp(@RequestBody Employee employee) {
		empService.updateEmp(employee);
	}
	
	@GetMapping("/emp/{pageno}/{pagesize}/{factor}")
	public ResponseEntity<Page<Employee>> getEmpPagewise(@PathVariable(name = "pageno") int pageno,@PathVariable(name = "pagesize") int pagesize,@PathVariable(name = "factor") String factor){
		return new ResponseEntity<>(empService.getStudentPagewise(pageno, pagesize ,factor),HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeError> handleException(EmployeeListNotFound exception){
		
		EmployeeError error = new EmployeeError(HttpStatus.NOT_FOUND.value(),exception.getMessage(),System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}


}
