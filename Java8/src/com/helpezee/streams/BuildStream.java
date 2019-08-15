package com.helpezee.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildStream {

	public static void main(String[] args) {

		//Using Stream.of(val1, val2, val3….)
		Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
		stream.forEach(p -> System.out.println(p));
		
		System.out.println("################################");
		
		//Using Stream.of(arrayOfElements)
		Stream<Integer> stream1 = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );
        stream1.forEach(p -> System.out.println(p));
        
        
        System.out.println("################################");
        
        //Using someList.stream()
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        Stream<Integer> stream3 = list.stream();
        stream3.forEach(p -> System.out.println(p));
        
        System.out.println("################################");
        
        
        //Using Stream.generate() or Stream.iterate() functions
        /*Stream<Date> stream4 = Stream.generate(() -> { return new Date();});
        stream4.forEach(p -> System.out.println(p));*/
        
        System.out.println("################################");
        
        //Using String chars or String tokens
        IntStream stream5 = "12345_abcdefg".chars();
        stream5.forEach(p -> System.out.println(p));
         
        //OR
         
        Stream<String> stream6 = Stream.of("A$B$C".split("\\$"));
        stream6.forEach(p -> System.out.println(p));
        
   	}

}
