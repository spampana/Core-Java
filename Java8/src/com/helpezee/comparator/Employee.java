package com.helpezee.comparator;

public class Employee {

	private int empId;

	private String empName;

	private int Age;

	private double salary;

	private long mobile;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public Employee(int empId, String empName, int age, double salary, long mobile) {
		super();
		this.empId = empId;
		this.empName = empName;
		Age = age;
		this.salary = salary;
		this.mobile = mobile;
	}

}
