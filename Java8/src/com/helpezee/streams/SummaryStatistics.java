package com.helpezee.streams;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class SummaryStatistics {

	public static void main(String[] args) {

		Employee[] arrayOfEmps = { 
				new Employee(1, "Jeff Bezos", 100000.0), 
				new Employee(2, "Bill Gates", 200000.0),
				new Employee(3, "Mark Zuckerberg", 300000.0) 
			};

		
		List<Employee> empList = Arrays.asList(arrayOfEmps);

		DoubleSummaryStatistics dstats = empList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(dstats);

		System.out.println("***************************************");

		DoubleSummaryStatistics dstats1 = empList.stream().mapToDouble(Employee::getSalary).summaryStatistics();
		System.out.println(dstats1);
		
/*		assertEquals(stats.getCount(), 3);
	    assertEquals(stats.getSum(), 600000.0, 0);
	    assertEquals(stats.getMin(), 100000.0, 0);
	    assertEquals(stats.getMax(), 300000.0, 0);
	    assertEquals(stats.getAverage(), 200000.0, 0);*/
	}

}
