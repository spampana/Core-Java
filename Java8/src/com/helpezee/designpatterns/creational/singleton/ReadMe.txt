Singleton Design Pattern
------------------------

Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the java virtual machine.

The singleton class must provide a global access point to get the instance of the class. 

Singleton pattern is used for logging, drivers objects, caching and thread pool.


To implement Singleton pattern, we have different approaches but all of them have following common concepts.

1)Private constructor to restrict instantiation of the class from other classes.

2)Private static variable of the same class that is the only instance of the class.

3)Public static method that returns the instance of the class, this is the global access point for outer world to get 
  the instance of the singleton class.