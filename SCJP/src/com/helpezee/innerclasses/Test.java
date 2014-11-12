package com.helpezee.innerclasses;

public class Test {
public static void main(String[] args) {
new OuterClass(); // line 3
}
}
class OuterClass {
private int x = 9; // line 5
public OuterClass() {
InnerClass inner = new InnerClass(); // line 7
inner.innerMethod();
}
class InnerClass {
public void innerMethod() {
System.out.println(x);
}
}
}