package com.helpezee.mapfilterreducesort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestMap {

	public static void main(String[] args) {

		List<Person> persons =  new ArrayList<>();
		
		Person p1 = new Person("Satya", "hyd", 33);
		Person p2 = new Person("Narayana", "hyd", 32);
		Person p3 = new Person("Vinod", "chennai", 33);
		
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		
		// Display only names from PersonsList
		List<String> namesList = persons.stream().map(p->p.getPersonName()).collect(Collectors.toList());
		namesList.forEach(n->System.out.println(n));
		
		// Sum of the ages of the persons in the list
		int ageSum = persons.stream().map(p->p.getAge()).reduce(0, Integer::sum);
		System.out.println("Sum of Age --"+ageSum);
		
		// max age of the persons in the list
		int ageMax = persons.stream().map(p->p.getAge()).reduce(0, Integer::max);
		System.out.println(" Max Age --"+ageMax);
		
	
		
		
	}

}
