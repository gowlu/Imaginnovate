package com.imaginnovate.demo.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.demo.model.Employee;
import com.imaginnovate.demo.model.EmployeeResponse;
import com.imaginnovate.demo.repository.EmployeeRepository;
import com.imaginnovate.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository repo;

	@Autowired
	EmployeeService service;

	@PostMapping("/employee/save")
	public void savedata(@RequestBody Employee emp) {
		System.out.println(emp.getCode());
		System.out.println("inside getmapping");
		service.save(emp);
	}

	@GetMapping("/employee/get")
	public List<Employee> getALLSign_up(){
		System.out.println("inside getmapping");
		return (List<Employee>)repo.findAll();
	}
	
	@GetMapping("/employee/taxslabs")
	public List<Employee> taxslabs(){
		System.out.println("inside getmapping");
		return (List<Employee>)repo.findAll();
	}
	
	
	@PostMapping("/employee/gettaxdeduction")
 	public String getTaxDeduction(@RequestBody Employee emp)throws Exception
 	{
 		JSONObject obj = new JSONObject();
 		try {
 	    	 System.out.println("&&&&"+emp.getCode());
 			EmployeeResponse empWithTax = service.getTaxDeduction(emp.getCode()); 	    	

 			obj.put("result", empWithTax.toString());
 			
 		}catch(Exception e) {
 			
 			e.printStackTrace();
 			obj.put("result", "error - ***");
 		}
 		return obj.toString();		
 	}

	
	
}
