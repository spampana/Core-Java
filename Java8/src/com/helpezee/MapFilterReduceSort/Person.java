package com.helpezee.MapFilterReduceSort;

public class Person {
	
	private String personName;
	
	private String location;
	
	private int age;

	public Person(String personName, String location, int age) {
		super();
		this.personName = personName;
		this.location = location;
		this.age = age;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
