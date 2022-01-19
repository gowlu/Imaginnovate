package com.imaginnovate.demo.model;

import java.sql.Date;

public class EmployeeResponse {

	private int code;

	private String firstName;

	private String lastName;

	private int yearlySalary;

	private int taxAmount;

	private int cessAmount;

	public int getYearlySalary() {
		return yearlySalary;
	}

	public void setYearlySalary(int yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

	public int getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(int taxAmount) {
		this.taxAmount = taxAmount;
	}

	public int getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(int cessAmount) {
		this.cessAmount = cessAmount;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "Employee [code=" + code + ", firstName=" + firstName + ", lastName=" + lastName + ", yearlySalary="
				+ yearlySalary + ", taxAmount=" + taxAmount + ", cessAmount=" + cessAmount + "]";
	}

}
