package com.helpezee.streams;

import java.util.Optional;
import java.util.stream.Stream;

public class FindFirst {

	public static void main(String[] args) {

		Stream<String> names4 = Stream.of("Pankaj", "Amit", "David", "Lisa");
		Optional<String> firstNameWithD = names4.filter(i -> i.startsWith("D")).findFirst();
		
		if (firstNameWithD.isPresent()) {
			System.out.println("First Name starting with D=" + firstNameWithD.get()); // David
		}

	}

}
