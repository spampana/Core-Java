package com.helpezee.strings;

public class InnerClassThis {
int x=10;
public void foo() {
System.out.println("Outer class");
}
public class ReallyInner {
public void foo() {
System.out.println("Inner class");
}
public void test() {
this.foo();
InnerClassThis.this.foo();
}
}
public static void main(String... args) {
InnerClassThis.ReallyInner i = new InnerClassThis().new ReallyInner();
i.test();
}
}