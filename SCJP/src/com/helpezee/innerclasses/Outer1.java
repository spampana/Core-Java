package com.helpezee.innerclasses;

class Outer1 {
private int i = 5; // line 1
Outer1(int i ){ // line 2
this.i = i; // line 3
System.out.print(++i); // line 4
}
class Inner1{
Inner1(){
System.out.print(","+ i++); // line 5
}
}
public static void main(String[] args) {
int i = 6;
Outer1.Inner1 in = new Outer1(i).new Inner1(); // line 6
}
}