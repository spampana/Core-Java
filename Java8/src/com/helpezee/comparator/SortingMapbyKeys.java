package com.helpezee.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortingMapbyKeys {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<>();
	    map.put(55, "John");
	    map.put(22, "Apple");
	    map.put(66, "Earl");
	    map.put(77, "Pearl");
	    map.put(12, "George");
	    map.put(6, "Rocky");
	    System.out.println("####### Map keys before sorting #########");
	    map.forEach((k,v)-> System.out.println(k));
		 
	    List<Map.Entry<Integer, String>> entries   = new ArrayList<>(map.entrySet());
	    
	/*    Collections.sort(entries, new Comparator<Entry<Integer, String>>() {
	        @Override
	        public int compare(
	          Entry<Integer, String> o1, Entry<Integer, String> o2) {
	            return o1.getKey().compareTo(o2.getKey());
	        }
	    });*/
	    
	    System.out.println("####### Map keys After sorting #########");
	    Collections.sort(entries,(o1,o2)-> o1.getKey().compareTo(o2.getKey()));
	    
	    Map<Integer, String> sortedMap = new LinkedHashMap<>();
	    for (Map.Entry<Integer, String> entry : entries) {
	        sortedMap.put(entry.getKey(), entry.getValue());
	    }
	    
	    map.forEach((k,v)-> System.out.println(k));
	    
	    
	    System.out.println("####### Map keys After sorting using stream #########");
	    
	    HashMap<Integer, String> unSortedMap = new HashMap<>();
        
	    unSortedMap.put(50, "Alex");
	    unSortedMap.put(20, "Charles");
	    unSortedMap.put(60, "Brian");
	    unSortedMap.put(70, "Edwin");
	    unSortedMap.put(120, "George");
	    unSortedMap.put(10, "David");
	    
	    
	    //LinkedHashMap preserve the ordering of elements in which they are inserted
	    LinkedHashMap<Integer, String> sortedMap1 = new LinkedHashMap<>();
	     
	    unSortedMap.entrySet()
	        .stream()
	        .sorted(Map.Entry.comparingByKey())
	        .forEachOrdered(x -> sortedMap1.put(x.getKey(), x.getValue()));
	     
	    System.out.println(sortedMap1);

	}

}
