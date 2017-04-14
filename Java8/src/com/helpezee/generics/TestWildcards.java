package com.helpezee.generics;

import java.util.ArrayList;
import java.util.List;

public class TestWildcards {

	public static void main(String[] args) {
		// Create List of type Integer
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(2);
		intList.add(4);
		intList.add(6);

		// Create List of type String
		List<String> strList = new ArrayList<String>();
		strList.add("two");
		strList.add("four");
		strList.add("six");

		// Create List of type Object
		List<Object> objList = new ArrayList<Object>();
		objList.add("two");
		objList.add("four");
		objList.add(strList);

		checkList(intList, 3);
		// Output: The list [2, 4, 6] does not contain the element: 3

		checkList(objList, strList);
		/*
		 * Output: The list [two, four, [two, four, six]] contains the element:
		 * [two, four, six]
		 */

		checkList(strList, objList);
		/*
		 * Output: The list [two, four, six] does not contain the element: [two,
		 * four, [two, four, six]]
		 */
	}

	public static <T> void checkList(List<?> myList, T obj) {
		if (myList.contains(obj)) {
			System.out.println("The list contains the element: " + obj);
		} else {
			System.out.println("The list does not contain the element: " + obj);
		}
	}
}
