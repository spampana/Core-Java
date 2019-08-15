package com.helpezee.streams;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {

	public static void main(String[] args) {


       List<Integer> myList = Stream.generate(()-> new Random().nextInt(200)).limit(100).collect(Collectors.toList());
		Stream<Integer> sequentialStream = myList.stream();

		// filter numbers greater than 90
		Stream<Integer> highNums = sequentialStream.filter(p -> p > 100); 
		
		System.out.print("High Nums greater than 90=");
		
		highNums.forEach(p -> System.out.print(p + " "));
		// prints "High Nums greater than 90=91 92 93 94 95 96 97 98 99 "

	}

}
