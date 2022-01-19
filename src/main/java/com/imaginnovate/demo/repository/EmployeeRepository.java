package com.imaginnovate.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.imaginnovate.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

String query ="select * from employee where code = 1002";	
	
	@Query(nativeQuery=true, value=query)
    Employee getEmployee(int code);
	
}
