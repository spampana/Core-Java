package com.helpezee.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntegerArraySorting {

	public static void main(String[] args) {
		
		Integer integerArray[]={2,3,5,77,8,99,22};
		
		
		System.out.println("*********** Sorting integer array Using Arrays.Sort() in Descending Order*******************");
		Arrays.sort(integerArray, Collections.reverseOrder());
		for(int i=0;i<integerArray.length;i++){
			System.out.println(integerArray[i]);
		}
		
		System.out.println("*********** Sorting integer array Using Arrays.parallelSort() in Descending Order*******************");
		Arrays.parallelSort(integerArray, Collections.reverseOrder());
		for(int i=0;i<integerArray.length;i++){
			System.out.println(integerArray[i]);
		}
				
		System.out.println("*********** Sorting Using Java8 Sorted() in Ascending Order*******************");
		Arrays.stream(integerArray).sorted().forEach(i->System.out.println(i));
		
		System.out.println("*********** Sorting Using Java8 Sorted() in Descending Order*******************");
		Arrays.stream(integerArray).sorted(Collections.reverseOrder()).forEach(i->System.out.println(i));
		
		
		System.out.println("*********** Sort int array using Collection.sort() in Decending Order *******************");
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(integerArray));
	    System.out.println("*********** Descending Order *******************");
	    Collections.sort(list, (i1, i2) -> {return i2 - i1;});
	    list.forEach(s->System.out.println(s));
	    System.out.println("*********** Ascending Order *******************");
	    Collections.sort(list, (i1, i2) -> {return i1 - i2;});
	    list.forEach(s->System.out.println(s));
		

	}

}
