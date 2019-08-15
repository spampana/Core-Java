package com.helpezee.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {
	
/*	groupingBy() offers advanced partitioning – where we can partition the stream into more than just two groups.

	It takes a classification function as its parameter. This classification function is applied to each element of the stream.

	The value returned by the function is used as a key to the map that we get from the groupingBy collector:*/

	public static void main(String[] args) {

		Employee[] arrayOfEmps = { 
				new Employee(1, "Jeff Bezos", 100000.0), 
				new Employee(4, "Jeff Cott", 100000.0), 
				new Employee(2, "Bill Gates", 200000.0),
				new Employee(3, "Mark Zuckerberg", 300000.0)
		};

		List<Employee> empList = Arrays.asList(arrayOfEmps);

		Map<Character, List<Employee>> groupByAlphabet = empList.stream()
				.collect(Collectors.groupingBy(e -> new Character(e.getName().charAt(0))));
		System.out.println(groupByAlphabet);
		
	/*	{
			B=[Employee1 [id=2, name=Bill Gates, salary=200000.0]], 
			J=[Employee1 [id=1, name=Jeff Bezos, salary=100000.0], Employee1 [id=4, name=Jeff Cott, salary=100000.0]], 
			M=[Employee1 [id=3, name=Mark Zuckerberg, salary=300000.0]]
		}*/


	}

}
