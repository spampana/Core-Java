package com.helpezee.inheritance;

//Java program to illustrate the concept of Multilevel inheritance 

class one1 {
	public void print_geek() {
		System.out.println("Geeks");
	}
	
	public static void method1() {
		System.out.println("Static Method from one1");
	}
}

class two1 extends one1 {
	public void print_for() {
		System.out.println("for");
	}
	
	public static void method1() {
		System.out.println("Static Method from two1");
	}

}

class three1 extends two1 {
	public void print_geek() {
		System.out.println("Geeks....");
	}

	public void m1() {
		System.out.println("Geeks....");
	}
	
	public static void method1() {
		System.out.println("Static Method from  three1");
	}


}

//Drived class 
public class MultiLevelInheritance {
	public static void main(String[] args) {

		three1 g = new three1();
		g.print_for();
		g.print_geek();
		g.method1();

		System.out.println("--------------------");

		two1 g2 = new three1();
		g2.print_for();
		g2.print_geek();
		g2.method1();
		// g.m1();

		System.out.println("--------------------");

		one1 g1 = new three1();
		// g1.print_for();
		g1.method1();
		g1.print_geek();
	}
}
