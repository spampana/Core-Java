package com.helpezee.concurrentmodificationexception;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

	public static void main(String[] args) {

		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		map.put("1", "1");
		map.put("22", "22");
		map.put("333", "333");
		
		System.out.println("compute");
		map.compute("1", (key, value) -> value == null ? key : value + 1);

		System.out.println("forEach");
		map.forEach((k, v) ->  System.out.printf("    k: %s, v: %s%n", k, v));
		
		
		System.out.println("forEachKey");
		/*the method will run in parallel when the size of the map reaches the parallelism threshold being 1 */
		map.forEachKey(1,k -> k.length(), System.out::println); 
		
		System.out.println("forEachValue");
		map.forEachValue(1,v -> v.length(), System.out::println); 
		
				
		System.out.println("search");
		/*
		 Uponsuccess, further element processing is suppressed and 
		 the results of any other parallel invocations of the searchfunction are ignored.
		 */
		String x = map.search(1, (k, v) -> { return v.length() > 1 ? k : null;  });
		System.out.println(x);
		
		
		System.out.println("searchByKeys");
		String ke = map.searchKeys(1, key -> key.equals("22") ? key : null);   
		System.out.println(ke);
		

		System.out.println("searchByValues");
		System.out.println(map.searchValues(1, v -> !v.isEmpty() ? v : null));
		
		
		System.out.println("reduce");
		ConcurrentHashMap<String, Integer> reducedMap = new ConcurrentHashMap<>();
		reducedMap.put("One", 1);
		reducedMap.put("Two", 2);
		reducedMap.put("Three", 3);
		
		System.out.println("reduce example => " +reducedMap.reduce(2, (k, v) -> v*2, (total, elem) -> total + elem));
		System.out.println("reduceKeys example => "  +reducedMap.reduceKeys(2, (key1, key2) -> key1.length() > key2.length() ? key1 + "-"+key2 : key2 + "-"+key1)); 
		System.out.println("reduceValues example => " +reducedMap.reduceValues(2, (v) -> v*2 , (value1, value2) -> value1 > value2 ? value1 - value2 : value2 - value1));
		
		
		System.out.println("Merge");
		
		ConcurrentHashMap<Integer, String>  conmap = new ConcurrentHashMap<Integer, String>();  
		conmap.put(1, "A");  
        conmap.put(2, "B");  
        conmap.put(3, "C");  
        conmap.put(5, "E");  
  
        ConcurrentHashMap<Integer, String>  conmap2 = new ConcurrentHashMap<Integer, String>();  
        conmap2.put(1, "F");  
        conmap2.put(2, "G");  
        conmap2.put(3, "H");  
        conmap2.put(5, "I");  
          
        conmap2.forEach((key, value) -> conmap.merge( key, value, (v1, v2) -> v1.equalsIgnoreCase(v2) ? v1 : v1 + "," + v2));  
        System.out.println(conmap);  
		
		

	}

}
