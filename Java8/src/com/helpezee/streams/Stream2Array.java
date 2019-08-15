package com.helpezee.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class Stream2Array {

	public static void main(String[] args) {

		System.out.println("Stream to Array Conversion ");
		Stream<Integer> intStream = Stream.of(1, 2, 3, 4);
		Object[] intList = intStream.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intList)); // prints [1, 2, 3, 4]

	}

}
