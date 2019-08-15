package com.helpezee.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Peek {

	public static void main(String[] args) {
		
		Employee[] arrayOfEmps = {
		        new Employee(1, "Jeff Bezos", 100000.0), 
		        new Employee(2, "Bill Gates", 200000.0), 
		        new Employee(3, "Mark Zuckerberg", 300000.0)
		    };

		    List<Employee> empList = Arrays.asList(arrayOfEmps);
		    
		    empList.stream()
		      .peek(e -> e.salaryIncrement(10.0))
		      .peek(System.out::println)
		      .collect(Collectors.toList());
		    
		    System.out.println("******************************");
		    
		     Stream.of("one", "two", "three", "four")
		    .filter(e -> e.length() > 3)
		    .peek(e -> System.out.println("Filtered value: " + e))
		    .map(String::toUpperCase)
		    .peek(e -> System.out.println("Mapped value: " + e))
		    .collect(Collectors.toList());
		    

	}

}
