package com.helpezee.designpatterns.creational;

public class TestSingleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton instance1 = Singleton.getInstance();
		System.out.println(instance1);
		
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance2);

	}

}
