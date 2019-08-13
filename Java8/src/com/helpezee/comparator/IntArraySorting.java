package com.helpezee.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class IntArraySorting {

	public static void main(String[] args) {
		
		int intArray[]={2,3,5,77,8,99,22};
		
		System.out.println("*** Sort int array using Arrays.Sort() in Ascending Order ***");
		Arrays.sort(intArray);
		for(int i=0;i<intArray.length;i++){
			System.out.println(intArray[i]);
		}
		
		
		System.out.println("*** Sort int array using Arrays.parallelSort() in Ascending Order ***");
		Arrays.parallelSort(intArray);
		for(int i=0;i<intArray.length;i++){
			System.out.println(intArray[i]);
		}
		
		
		System.out.println("*** Sort int array using  Java8 sorted() in Ascending Order ***");
		IntStream.of(intArray).sorted().forEach(i->System.out.println(i));
		
		
		System.out.println("*** Sort int array using Java8 Sorted() in Decending Order ***");
		IntStream.of(intArray).boxed().sorted(Collections.reverseOrder()).forEach(i->System.out.println(i));
		
		
		System.out.println("*** Sort int array using  Java8 Arrays.stream in Ascending Order ***");
		int[] arr = Arrays.stream(intArray).sorted().toArray();
		System.out.println(Arrays.toString(arr));	// [1, 2, 3, 4, 5]
		
		
		System.out.println("*** Sort int array using Collection.sort() in Decending Order ***");
		System.out.println("                                  ");
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[]{255, 200, 123, 89, 88, 66, 7, 5, 1}));
	    System.out.println("*** Descending Order ***");
	    Collections.sort(list, (i1, i2) -> {return i2 - i1;});
	    list.forEach(s->System.out.println(s));
	    System.out.println("*** Ascending Order ***");
	    Collections.sort(list, (i1, i2) -> {return i1 - i2;});
	    list.forEach(s->System.out.println(s));
	  		
			 
	}

}
