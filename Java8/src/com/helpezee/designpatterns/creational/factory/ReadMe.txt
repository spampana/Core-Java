Factory Design Pattern
----------------------

Factory design pattern is used when we have a super class with multiple sub-classes and based on input, we need to return one of the sub-class. 

This pattern take out the responsibility of instantiation of a class from client program to the factory class.

Super class in factory design pattern can be an interface, abstract class or a normal java class.


Factory Design Pattern Advantages
--------------------------------

Factory design pattern provides approach to code for interface rather than implementation.

Factory pattern removes the instantiation of actual implementation classes from client code. 

Factory pattern makes our code more robust, less coupled and easy to extend. 
For example, we can easily change PC class implementation because client program is unaware of this.

Factory pattern provides abstraction between implementation and client classes through inheritance.


Factory Design Pattern Examples in JDK
--------------------------------------

java.util.Calendar, ResourceBundle and NumberFormat getInstance() methods uses Factory pattern.
valueOf() method in wrapper classes like Boolean, Integer etc.