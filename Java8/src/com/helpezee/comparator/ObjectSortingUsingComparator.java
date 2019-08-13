package com.helpezee.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class ObjectSortingUsingComparator {

	public static void main(String[] args) {

		List<Employee> emps = Arrays.asList(new Employee(1, "Satya", 36, 30000, 9492492670l),
				new Employee(3, "Narayana", 21, 20000, 9492492671l),
				new Employee(2, "Pampana", 05, 10000, 9492492672l));

		Comparator<Employee> employeeNameComparator = Comparator.comparing(Employee::getEmpName).thenComparing(Employee::getEmpId);
		Comparator<Employee> employeeIdComparator = Comparator.comparing(Employee::getEmpId);
		Comparator<Employee> employeeAgeComparator = Comparator.comparing(Employee::getAge);
		Comparator<Employee> employeeMobileComparator = Comparator.comparing(Employee::getMobile);
		Comparator<Employee> employeeSalaryComparator = Comparator.comparing(Employee::getSalary).thenComparing(Employee::getEmpId);
				
		

		System.out.println("#####  Sorting by Employee Name Using Stream ######");
		emps.stream().sorted(employeeNameComparator).forEach(e -> System.out.println(e.getEmpName()));

		System.out.println("#####  Sorting by  Employee Id Using Stream ######");
		emps.stream().sorted(employeeIdComparator).forEach(e -> System.out.println(e.getEmpId()));

		System.out.println("#####  Sorting by  Employee Age Using Stream ######");
		emps.stream().sorted(employeeAgeComparator).forEach(e -> System.out.println(e.getAge()));

		System.out.println("#####  Sorting by  Employee Mobile No Using Stream ######");
		emps.stream().sorted(employeeMobileComparator).forEach(e -> System.out.println(e.getMobile()));

		System.out.println("#####  Sorting by  Employee Salary Using Stream ######");
		emps.stream().sorted(employeeSalaryComparator).forEach(e -> System.out.println(e.getSalary()));
		
		System.out.println("**********************************************************************");
		
		System.out.println("#####  Sorting by Employee Name Using ParallelStream ######");
		emps.parallelStream().sorted(employeeNameComparator).forEach(e -> System.out.println(e.getEmpName()));

		System.out.println("#####  Sorting by  Employee Id  Using ParallelStream ######");
		emps.parallelStream().sorted(employeeIdComparator).forEach(e -> System.out.println(e.getEmpId()));

		System.out.println("#####  Sorting by  Employee Age  Using ParallelStream ######");
		emps.parallelStream().sorted(employeeAgeComparator).forEach(e -> System.out.println(e.getAge()));

		System.out.println("#####  Sorting by  Employee Mobile No  Using ParallelStream ######");
		emps.parallelStream().sorted(employeeMobileComparator).forEach(e -> System.out.println(e.getMobile()));

		System.out.println("#####  Sorting by  Employee Salary  Using ParallelStream ######");
		emps.parallelStream().sorted(employeeSalaryComparator).forEach(e -> System.out.println(e.getSalary()));
		
		
		System.out.println("**********************************************************************");
		
		System.out.println("#####  Sorting by Employee Id Using Collections.sort() ######");
		Collections.sort(emps,employeeIdComparator);
        emps.forEach(s->System.out.println(s.getEmpId()));
        
        
        System.out.println("##### Sorting by Employee Name with Lambda Expression #######");
        emps.sort((Employee o1,Employee o2)->o1.getEmpName().compareTo(o2.getEmpName()));
        emps.forEach(s->System.out.println(s.getEmpName()));        
	}

}
