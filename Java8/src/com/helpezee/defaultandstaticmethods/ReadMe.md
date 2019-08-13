Java 8 allows you to add non-abstract methods in interfaces. 
These methods must be declared default methods. 
Default methods were introduces in java 8 to enable the functionality of lambda expression.

We can use default and static keyword to create interfaces with method implementation.

The static method is available only through and inside of an interface. It can’t be overridden by an implementing class.

Default methods are added so that our code remains backward compatible.

Default method cannot override a method from java.lang.Object?
---------------------------------------------------------------
If any class in the hierarchy has a method with same signature, then default methods become irrelevant. Since any class implementing an interface already has Object as superclass, if we have equals(), hashCode() default methods in interface, it will become irrelevant. Thats why for better clarity, interfaces are not allowed to have Object class default methods.


Java doesn’t provide multiple inheritance in Classes because it leads to Diamond Problem
----------------------------------------------------------------------------------------
We know that Java doesn’t provide multiple inheritance in Classes because it leads to Diamond Problem. 
So how it will be handled with interfaces now, since interfaces are now similar to abstract classes. The solution is that compiler will throw exception in this scenario and we will have to provide implementation logic in the class implementing the interfaces