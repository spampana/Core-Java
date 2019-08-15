package com.helpezee.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperations {

	//Intermediate operations return the stream itself so you can chain multiple method calls in a row
	public static void main(String[] args) {
	
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");
		
	//	A) filter()
	
		memberNames.stream().filter((s) -> s.startsWith("A"))
        .forEach(System.out::println);
	 
		System.out.println("###################################");
		
	//  B) map()
		
		memberNames.stream().filter((s) -> s.startsWith("A"))
        .map(String::toUpperCase)
        .forEach(System.out::println);
		
	//  C) sorted()
		
		memberNames.stream().sorted()
        .map(String::toUpperCase)
        .forEach(System.out::println);
		
	//  D) distinct()
		Collection<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
		List<String> distinctElements = list.stream().distinct().collect(Collectors.toList());
		System.out.println(distinctElements);
		
		
		
	}

}
