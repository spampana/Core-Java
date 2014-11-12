package com.helpezee.strings;

public class Tester {
public static void main(String[] args) {
StringBuffer sb = new StringBuffer("javachamp");
String s = new String("javachamp");
boolean stmt1 = s.equals(sb) ; //false
boolean stmt2 = sb.equals(s) ; //false
boolean stmt3 = sb.toString() == s ; //true
boolean stmt4 = sb.toString().equals(s) ;//true
boolean stmt5 = s.equals(sb.toString()) ; //true
System.out.println("stmt1--"+stmt1);
System.out.println("stmt2--"+stmt2);
System.out.println("stmt3--"+stmt3);
System.out.println("stmt4--"+stmt4);
System.out.println("stmt5--"+stmt5);
}
}
/* equals compare the content
   == compares the  references */