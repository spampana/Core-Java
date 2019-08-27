package com.helpezee.enums;

//enum declaration outside a class. 
enum Shape {
	SQUARE, TRIANGLE, RECTANGLE;
}

public class EnumTest {

	// enum declaration inside a class. 
	enum Color {
		RED, GREEN, BLUE;
	}

	// Driver method
	public static void main(String[] args) {
		Color c1 = Color.RED;
		System.out.println(c1);

		Shape s1 = Shape.TRIANGLE;
		System.out.println(s1);
	}
}
