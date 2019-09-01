package com.helpezee.inheritance;

//Java program to illustrate the concept of single inheritance 


class one {
	public void print_geek() {
		System.out.println("Geeks");
	}
}

class two extends one {
	public void print_for() {
		System.out.println("for");
	}
	
	public void print_geek() {
		System.out.println("Geeks....");
	}
}

//Driver class 
public class SingleInheritance {
	public static void main(String[] args) {
		
		two g = new two();
		g.print_geek();
		g.print_for();
		
		System.out.println("-------------------------");
		
		one o = new  one();
		o.print_geek();
		//o.print_for();
		
		System.out.println("-------------------------");
		
		one ot = new two();
		ot.print_geek();
		//ot.print_for();
				
		
	}
}
