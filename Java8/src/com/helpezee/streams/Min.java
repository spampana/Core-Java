package com.helpezee.streams;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Min {

	public static void main(String[] args) {

		Employee[] arrayOfEmps = {
		        new Employee(1, "Jeff Bezos", 100000.0), 
		        new Employee(2, "Bill Gates", 200000.0), 
		        new Employee(3, "Mark Zuckerberg", 300000.0)
		    };

		    List<Employee> empList = Arrays.asList(arrayOfEmps);
		    
		Employee firstEmp = empList.stream()
			      .min((e1, e2) -> e1.getId() - e2.getId())
			      .orElseThrow(NoSuchElementException::new);
		
		System.out.println(firstEmp);

	}

}
