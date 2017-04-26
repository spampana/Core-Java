package com.helpezee.MapFilterReduceSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TestStreamSort {

	public static void main(String[] args) {
		
		List<Person> persons =  new ArrayList<>();
		
		Person p1 = new Person("Satya", "hyd", 33);
		Person p2 = new Person("Narayana", "hyd", 32);
		Person p3 = new Person("Vinod", "chennai", 33);
		
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		
		// Sort the List based on name and display only names from PersonsList
		List<String> sortedList = persons.stream().map(p->p.getPersonName()).sorted().collect(Collectors.toList());
		sortedList.forEach(n->System.out.println(n));
		
		// Reverse sort the List based on name and display only names from PersonsList
		List<String> reverseSortedList = persons.stream().map(p->p.getPersonName()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		reverseSortedList.forEach(n->System.out.println(n));
		
		// sort the List based on age and display PersonsList
		List<Person> ageSortedList = persons.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
		ageSortedList.forEach(n->System.out.println(n.getAge()));
		
		// sort the List based on location and display PersonsList
		List<Person> locationSortedList = persons.stream().sorted(Comparator.comparing(Person::getLocation)).collect(Collectors.toList());
		locationSortedList.forEach(n->System.out.println(n.getLocation()));
		
		
		System.out.println("###############################################");
		
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1, "Mahesh", 12));
		list.add(new Student(2, "Suresh", 15));
		list.add(new Student(3, "Nilesh", 10));
		
		System.out.println("---Natural Sorting by Name---");
		List<Student> slist = list.stream().sorted().collect(Collectors.toList());
		slist.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));
		
		System.out.println("---Natural Sorting by Name in reverse order---");
		slist = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		slist.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));		
		
		System.out.println("---Sorting using Comparator by Age---");
		slist = list.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
		slist.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));
		
		System.out.println("---Sorting using Comparator by Age with reverse order---");
		slist = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
		slist.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));
		
		System.out.println("###############################################");
		
		
		Set<Student> set = new HashSet<Student>();
		set.add(new Student(1, "Mahesh", 12));
		set.add(new Student(2, "Suresh", 15));
		set.add(new Student(3, "Nilesh", 10));
		
		System.out.println("---Natural Sorting by Name---");
		set.stream().sorted().forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));
		
		System.out.println("---Natural Sorting by Name in reverse order---");
		set.stream().sorted(Comparator.reverseOrder()).forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));		
		
		System.out.println("---Sorting using Comparator by Age---");
		set.stream().sorted(Comparator.comparing(Student::getAge)).forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));
		
		System.out.println("---Sorting using Comparator by Age in reverse order---");
		set.stream().sorted(Comparator.comparing(Student::getAge).reversed()).forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));

		System.out.println("###############################################");
		
		
		Map<Integer, String> map = new HashMap<>();
		map.put(15, "Mahesh");
		map.put(10, "Suresh");
		map.put(30, "Nilesh");
		
		
		System.out.println("---Sort by Map Value---");
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
          .forEach(e -> System.out.println("Key: "+ e.getKey() +", Value: "+ e.getValue()));

        System.out.println("---Sort by Map Key---");
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
          .forEach(e -> System.out.println("Key: "+ e.getKey() +", Value: "+ e.getValue()));

	}

}
