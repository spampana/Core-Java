package com.helpezee.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperations {

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

		// A) forEach()
		memberNames.forEach(System.out::println);
		
		System.out.println("#######################");
		
		
		//  B) collect()
		List<String> memNamesInUppercase = memberNames.stream().sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
		System.out.print(memNamesInUppercase);

		System.out.println("#######################");
		
				
		//  C) match()
		
		//Returns whether any elements of this stream match the provided predicate
		boolean matchedResult = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A"));

		System.out.println(matchedResult);
		
		//Returns whether all elements of this stream match the provided predicate
		matchedResult = memberNames.stream()
		                .allMatch((s) -> s.startsWith("A"));
		
		System.out.println(matchedResult);
		
		//Returns whether no elements of this stream match the provided predicate
		matchedResult = memberNames.stream()
		                .noneMatch((s) -> s.startsWith("A"));
		
		System.out.println(matchedResult);
		
		System.out.println("#######################");
		
		
		// D) count()
		long totalMatched = memberNames.stream()
                .filter((s) -> s.startsWith("A"))
                .count();

		System.out.println(totalMatched);

		System.out.println("#######################");
		
		
		// E) reduce() 
		Optional<String> reduced = memberNames.stream()
                .reduce((s1,s2) -> s1 + "#" + s2);

		reduced.ifPresent(System.out::println);
		
		// F) findFirst()
		
		//It will return first element from stream and then will not process any more element.
		String firstMatchedName = memberNames.stream()
		                .filter((s) -> s.startsWith("L"))
		                .findFirst().get();
		System.out.println(firstMatchedName);
	}

}
