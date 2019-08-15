package com.helpezee.streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream2Collections {

	public static void main(String[] args) {

		System.out.println("Stream to List Conversion ");
		Stream<Integer> intStream = Stream.of(1, 2, 3, 4);
		List<Integer> intList = intStream.collect(Collectors.toList());
		System.out.println(intList); // prints [1, 2, 3, 4]
		
		System.out.println("Stream to Set Conversion ");
		intStream = Stream.of(1, 2, 3, 4);
		Set<Integer> intSet = intStream.collect(Collectors.toSet());
		System.out.println(intSet); // prints [1, 2, 3, 4]

		System.out.println("Stream to Map Conversion ");
		intStream = Stream.of(1, 2, 3, 4); // stream is closed, so we need to create it again
		Map<Integer, Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i + 10));
		System.out.println(intMap); // prints {1=11, 2=12, 3=13, 4=14}
		
		
	}
}
