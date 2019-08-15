package com.helpezee.streams;

import java.util.Random;
import java.util.stream.Stream;

public class Sum {

	public static void main(String[] args) {

		Stream<Integer> x = Stream.generate(() -> new Random().nextInt(20)).limit(10);
		System.out.println(x.mapToInt(i -> i).sum());
	}
}
