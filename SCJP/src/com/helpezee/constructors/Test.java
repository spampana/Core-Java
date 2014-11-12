package com.helpezee.constructors;

class Plant {
Plant() {
System.out.println("Plant created");
}
}
class Tree extends Plant {
Tree() {
super();
System.out.println("Tree created");

}
}
public class Test {
public static void main(String args[]) {
Tree tree = new Tree();
}
}