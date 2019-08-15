package com.helpezee.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Joining {

	public static void main(String[] args) {
		
		Employee[] arrayOfEmps = {
		        new Employee(1, "Jeff Bezos", 100000.0), 
		        new Employee(2, "Bill Gates", 200000.0), 
		        new Employee(3, "Mark Zuckerberg", 300000.0)
		    };

		    List<Employee> empList = Arrays.asList(arrayOfEmps);
		    
		
		String empNames = empList.stream()
			      .map(Employee::getName)
			      .collect(Collectors.joining(", "))
			      .toString();
		
		System.out.println(empNames);

	}

}
