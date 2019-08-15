package com.helpezee.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*Here mapping() maps the stream element Employee into just the employee Name – which is an String – using the getName() mapping function. 
 * 
 * These names are still grouped based on the initial character of employee first name.
 * 
 */
public class Mapping {

	public static void main(String[] args) {
		Employee[] arrayOfEmps = { 
				new Employee(1, "Jeff Bezos", 100000.0), 
				new Employee(4, "Jeff Cott", 100000.0),
				new Employee(2, "Bill Gates", 200000.0), 
				new Employee(3, "Mark Zuckerberg", 300000.0) };

		List<Employee> empList = Arrays.asList(arrayOfEmps);

		Map<Character, List<String>> idGroupedByAlphabet = empList
															.stream()
															.collect(Collectors.groupingBy(
																e -> new Character(e.getName().charAt(0)), 
																Collectors.mapping(Employee::getName, Collectors.toList())));
		
		System.out.println(idGroupedByAlphabet);
		
/*		{
			B=[Bill Gates], 
			J=[Jeff Bezos, Jeff Cott],
			M=[Mark Zuckerberg]
		}*/


	}

}
