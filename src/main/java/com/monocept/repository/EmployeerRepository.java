package com.monocept.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.monocept.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeerRepository extends JpaRepository<	Employee, Integer> {
	
//	@Query("select emp from Employee emp")
//	List<Employee> getAllEmployee();
//	
//	@Query("SELECT emp FROM Employee emp WHERE emp.id = :id")
//	Employee getEmployeeById(@Param("id") int id);
//	
//	@Modifying
//	@Transactional
//	@Query(value = "INSERT INTO Employee (employeeid, firstName, lastName, department, salary) VALUES (:employeeid,:firstName, :lastName, :department, :salary)",nativeQuery = true)
//	void addEmployee(@Param("employeeid") int employeeid ,@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("department") String department, @Param("salary") double salary);
//
//	@Modifying
//	@Transactional
//	@Query(value = "DELETE FROM Employee e WHERE e.employeeId = :employeeId",nativeQuery = true)
//	void deleteEmployeeById(@Param("employeeId") int employeeId);


}
	