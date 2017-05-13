package com.helpezee.designpatterns.creational.singleton;

public class Singleton {
	
	// Lazy Loading , its a private instance
	public static Singleton instance = null; 

	//Disabling the object creation using constructor with private
	private Singleton() {} 

	public static Singleton getInstance() {
		
		if (instance == null) {
			//Thread Safe
			synchronized (Singleton.class) { 
				if (instance == null) {
					instance = new Singleton();
				}

			}

		}
		return instance;
	}

}
