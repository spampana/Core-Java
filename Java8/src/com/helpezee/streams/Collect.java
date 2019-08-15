package com.helpezee.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Collect {

	public static void main(String[] args) {
		
		Employee[] arrayOfEmps = {
		        new Employee(1, "Jeff Bezos", 100000.0), 
		        new Employee(2, "Bill Gates", 200000.0), 
		        new Employee(3, "Mark Zuckerberg", 300000.0)
		    };

	
		List<Employee> empList = Arrays.asList(arrayOfEmps);

		System.out.println("*********** Collectors.toList() ****************");
		
		IntStream stream = IntStream.range(0, 10);
		List<Integer> list = stream
				.boxed()
				.map(i->i)
				.collect(Collectors.toList());
		list.forEach(System.out::println);
		
		System.out.println("*********** Collectors.toSet() ****************");
		
		stream = IntStream.range(0, 10);
		Set<Integer> set = stream
				.boxed()
				.map(i->i)
				.collect(Collectors.toSet());
		set.forEach(System.out::println);
		
		System.out.println("*********** Collectors.joining(\", \") ****************");
		
		String empNames = empList.stream()
			      .map(Employee::getName)
			      .collect(Collectors.joining(", "))
			      .toString();
		System.out.println(empNames);

		System.out.println("*********** Collectors.toCollection(Vector::new) ****************");
		
		Vector<String> empNames1 = empList.stream()
	            .map(Employee::getName)
	            .collect(Collectors.toCollection(Vector::new));
		System.out.println(empNames1);
	}

}
