package com.helpezee.designpatterns.creational;

public class TestBuilder {

	public static void main(String[] args) {

		LunchBuilder.Builder builder = new LunchBuilder.Builder();
		builder.addLunchType("Non-veg").addLunchName("Chicken Biryani").addLunchCost("200");
		LunchBuilder lunch = builder.build();
		
		System.out.println(lunch.getLunchCost());
		System.out.println(lunch.getLunchName());
		System.out.println(lunch.getLunchType());
	}

}
