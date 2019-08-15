package com.helpezee.streams;

import java.util.stream.Stream;

public class Count {

	public static void main(String[] args) {

		Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5);

		System.out.println("Number of elements in stream=" + numbers1.count()); // 5

	}

}
