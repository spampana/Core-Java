package com.helpezee.concurrentcollections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyConcurrentHashMap {

	public static void main(String[] args) {

		Map<String, String> months = new HashMap<>();

		months.put("Jan", "31");
		months.put("Feb", "28");
		months.put("Mar", "31");
		months.put("Apr", "30");
		months.put(null, "78");

		System.out.println(months);

		Map<String, String> months1 = new ConcurrentHashMap<>();

		months1.put("Jan", "31");
		months1.put("Feb", "28");
		months1.put("Mar", "31");
		months1.put("Apr", "30");
		months1.put(null, "78");

		System.out.println(months1);

	}

}
