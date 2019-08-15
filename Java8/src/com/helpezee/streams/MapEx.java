package com.helpezee.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapEx {

	public static void main(String[] args) {

		Stream<String> names = Stream.of("aBc", "d", "ef");
		List<String> list = names.map(s -> { return s.toUpperCase();}).collect(Collectors.toList());
		list.forEach(System.out::println);

	}

}
