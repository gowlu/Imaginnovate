package com.imaginnovate.demo.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.demo.model.Employee;
import com.imaginnovate.demo.model.EmployeeResponse;
import com.imaginnovate.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;

	public Employee save(Employee emp) {
		System.out.println(emp.getFirstName());
		return repo.save(emp);

	}

	public EmployeeResponse getTaxDeduction(int id) {
		System.out.println("****" + id);
		Employee emp = repo.getEmployee(id);
		EmployeeResponse res = new EmployeeResponse();
		int yearlySalary = Integer.parseInt(emp.getSalary()) * 12;
		int taxAmount = calculateTax(emp.getSalary());
		int cessAmount = calculateCess(emp.getSalary());
		
		res.setCode(emp.getCode());
		res.setFirstName(emp.getFirstName());
		res.setLastName(emp.getLastName());
		res.setYearlySalary(yearlySalary);
		
		res.setCessAmount(cessAmount);
		res.setTaxAmount(taxAmount);		
		return res;

	}

	private int calculateTax(String salary) {
		JSONArray jsonArray = new JSONArray();
		long taxamount = Integer.parseInt(salary);
		long totaltaxamount = taxamount * 12;
		long tax = 0;
		if(totaltaxamount <=250000) {
			tax=0;
		}else if(totaltaxamount >250000 && totaltaxamount <=500000){
			 tax = totaltaxamount * 100 / totaltaxamount;
			//jsonArray.put(tax);
			
		}else if(totaltaxamount >500000 && totaltaxamount <=1000000){
			 tax = totaltaxamount * 100 / totaltaxamount;
			//jsonArray.put(tax1);
		}else if(totaltaxamount >1000000){
			tax = totaltaxamount * 100 / totaltaxamount;
			//jsonArray.put(tax2);
			
		}
	
		int TaxAmount = (int)tax;
		return TaxAmount;

	}

	private int calculateCess(String salary) {
		long cessamount = Integer.parseInt(salary);
		long totalcessamount = cessamount * 12;
		long additionaltax =0;
		if(totalcessamount>2500000)
		{
			additionaltax = cessamount * 100 / totalcessamount;
		}else {
			additionaltax = 0;
		}
		
		int i = (int)additionaltax;
		return i;

	}
}
