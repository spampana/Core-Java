package com.helpezee.strings;

public class Test {
	
public void method(StringBuffer sb) {
System.out.println("StringBuffer method");
}
public void method(String s) {
System.out.println("String method");
}
public static void main(String[] args) {
Test test = new Test();
//test.method(null);
}
}