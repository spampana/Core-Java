Functional interfaces are new concept introduced in Java 8. 

An interface with exactly one abstract method becomes Functional Interface. 

We don’t need to use @FunctionalInterface annotation to mark an interface as Functional Interface. 

@FunctionalInterface annotation is a facility to avoid accidental addition of abstract methods in the functional interfaces. 

You can think of it like @Override annotation and it’s best practice to use it.

One of the major benefits of functional interface is the possibility to use lambda expressions to instantiate them. 
We can instantiate an interface with anonymous class but the code looks bulky.

If an interface declares an abstract method overriding one of the public methods of java.lang.Object, that also does not count toward the interface’s abstract method count since any implementation of the interface will have an implementation from java.lang.Object or elsewhere.

Example : 

@FunctionalInterface
public interface MyFirstFunctionalInterface
{
    public void firstWork();
 
    @Override
    public String toString(); //Overridden from Object class
 
    @Override
    public boolean equals(Object obj); //Overridden from Object class
}

Comparator is a functional interface even though it declared two abstract methods. Why? Because one of these abstract methods “equals()” which has signature equal to public method in Object class.

Functional interface has exactly one abstract method. Since default methods have an implementation, they are not abstract. Since default methods are not abstract you’re free to add default methods to your functional interface as many as you like.

The java.util.function package in Java 8 contains many built-in functional interfaces.
Some of the useful java 8 functional interfaces are 
a)Consumer
b)Supplier
c)Function 
d)Predicate

Example: 

java.lang.Runnable
java.util.Comparator
java.util.concurrent.Callable

Consumers Interfaces
====================

Consumer accepts a generic argument and returns nothing.

Consumer
--------

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}


void accept(T t)

Parameters: This method takes in one parameter:  t– the input argument
Returns: This method does not return any value.

default Consumer <T> andThen(Consumer<? super T> after)

Parameters: This method accepts a parameter after which is the Consumer to be applied after the current one.
Return Value: This method returns a composed Consumer that first applies the current Consumer first and then the after operation.
Exception: This method throws NullPointerException if the after operation is null.


BiConsumer
----------

void accept(T t, U u)

Parameters: This method takes in two parameters:
t– the first input argument
u– the second input argument
Returns: This method does not return any value.

Syntax  default BiConsumer <T, U> andThen(BiConsumer<? super T, ? super U> after)

Parameters: This method accepts a parameter after which is the BiConsumer to be applied after the current one.
Return Value: This method returns a composed BiConsumer that first applies the current operation first and then the after operation.
Exception: This method throws NullPointerException if the after operation is null.

DoubleConsumer
--------------
Represents an operation that accepts a single double-valued argument and returns no result. 
   void accept(double value)

IntConsumer 
-----------
Represents an operation that accepts a single int-valued argument and returns no result. 
   void accept(int value)

LongConsumer 
------------
Represents an operation that accepts a single long-valued argument and returns no result. 
	void accept(long value)

ObjDoubleConsumer<T> 
--------------------
Represents an operation that accepts an object-valued and a double-valued argument, and returns no result. 
	void accept(T t, double value)

ObjIntConsumer<T>
-----------------
 Represents an operation that accepts an object-valued and a int-valued argument, and returns no result. 
 	void accept(T t, int value)

ObjLongConsumer<T> 
------------------
Represents an operation that accepts an object-valued and a long-valued argument, and returns no result. 
	 void accept(T t, long value)


Supplier Interfaces
===================
It represents a function which does not take in any argument but produces a value of type T.

Supplier
--------

@FunctionalInterface
public interface Supplier<T> {
    T get();
}

T: denotes the type of the result

BooleanSupplier
---------------
Represents a supplier of boolean-valued results. 
	boolean getAsBoolean()

DoubleSupplier
----------------
Represents a supplier of double-valued results. 
	double getAsDouble()

IntSupplier
----------
Represents a supplier of int-valued results. 
	int getAsInt()

LongSupplier
------------
 Represents a supplier of long-valued results. 
 	long getAsLong()

Function Interfaces
====================

it represents a function that accepts input arguments and produces a result.

public interface Function<T,R> {
    public <R> apply(T parameter);
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)
    default <V> Function<V, R> compose(Function<? super V, ? extends T> before)
}


default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)

where V is the type of output of the after function, and of the composed function
Parameters: This method accepts a parameter after which is the function to be applied after the current one.
Return Value: This method returns a composed function that applies the current function first and then the after function
Exception: This method throws NullPointerException if the after function is null.


What is function composition?
It all has to do with creating small reusable functions that you can combine to compose new functions.


default <V> Function<V, R> compose(Function<? super V, ? extends T> before)
 
where V is the type of input of the before function, and of the composed function
Parameters: This method accepts a parameter before which is the function to be applied first and then the current one
Return Value: This method returns a composed function that applies the current function after the parameterized function
Exception: This method throws NullPointerException if the before function is null.

The Function returned by compose() will first call the Function passed as parameter to compose(), and then it will call the Function which compose() was called on.


Function<T,R>
------------
Represents a function that accepts one argument and produces a result. 
	R apply(T t)

BiFunction<T,U,R>
-----------------
 Represents a function that accepts two arguments and produces a result. 
 	R apply(T t, U u)

IntFunction<R> 
-------------
Represents a function that accepts an int-valued argument and produces a result. 
	R apply(int value)

DoubleFunction<R> 
----------------
Represents a function that accepts a double-valued argument and produces a result.
	R apply(double value)

LongFunction<R> 
----------------
Represents a function that accepts a long-valued argument and produces a result. 
	R apply(long value)

DoubleToIntFunction 
------------------
Represents a function that accepts a double-valued argument and produces an int-valued result. 
	int applyAsInt(double value)

DoubleToLongFunction
-------------------
 Represents a function that accepts a double-valued argument and produces a long-valued result. 
 	long applyAsLong(double value)

IntToDoubleFunction
------------------
 Represents a function that accepts an int-valued argument and produces a double-valued result. 
 	double applyAsDouble(int value)

IntToLongFunction
----------------
 Represents a function that accepts an int-valued argument and produces a long-valued result. 
 	long applyAsLong(int value)
 	
LongToDoubleFunction
--------------------
 Represents a function that accepts a long-valued argument and produces a double-valued result. 
 	double applyAsDouble(long value)

LongToIntFunction
-----------------
 Represents a function that accepts a long-valued argument and produces an int-valued result. 
 	int applyAsInt(long value)

ToDoubleBiFunction<T,U> 
----------------------
Represents a function that accepts two arguments and produces a double-valued result. 
	double applyAsDouble(T t, U u)

ToDoubleFunction<T> 
--------------------
Represents a function that produces a double-valued result. 
	double applyAsDouble(T value)

ToIntBiFunction<T,U>
-------------------
 Represents a function that accepts two arguments and produces an int-valued result. 
 	int applyAsInt(T t, U u)

ToIntFunction<T> 
----------------
Represents a function that produces an int-valued result. 
	int applyAsInt(T value)

ToLongBiFunction<T,U>
---------------------
 Represents a function that accepts two arguments and produces a long-valued result. 
 	long applyAsLong(T t, U u)

ToLongFunction<T>
------------------
 Represents a function that produces a long-valued result. 
 	long applyAsLong(T value)


Predicate Interfaces
====================

Evaluates this predicate on the given no of arguments.

The Predicate interface (java.util.function.Predicate) contains a few methods that help you compose new Predicate instances from other Predicate instances. I will cover some of these methods in the following sections.

and()
----
The Predicate and() method is a default method. The and() method is used to combine two other Predicate functions
Here is an example of functional composition with the Predicate and() method:

Predicate<String> startsWithA = (text) -> text.startsWith("A");
Predicate<String> endsWithX   = (text) -> text.endsWith("x");

Predicate<String> composed = startsWithA.and(endsWithX);

String input = "A hardworking person must relax";
boolean result = composed.test(input);
System.out.println(result);

The composed Predicate will return true from it's test() method if both of the Predicate instances it was composed from also return true. In other words, if both Predicate one and Predicate two return true.

or()
---
The Predicate or() method is used to combine a Predicate instance with another, to compose a third Predicate instance. The composed Predicate will return true if either of the Predicate instances it is composed from return true, when their test() methods are called with same input parameter as the composed Predicate. Here is a Java Predicate or() functional composition example:

Predicate<String> startsWithA = (text) -> text.startsWith("A");
Predicate<String> endsWithX   = (text) -> text.endsWith("x");

Predicate<String> composed = startsWithA.or(endsWithX);

String input = "A hardworking person must relax sometimes";
boolean result = composed.test(input);
System.out.println(result);

The output of running the above example will be true because the first of the two Predicate instances used in the composed Predicate will return true when called with the String "A hardworking person must relax sometimes".

Predicate<T> 
-------------
Represents a predicate (boolean-valued function) of one argument. 
	boolean test(T t)

BiPredicate<T,U> 
----------------
Represents a predicate (boolean-valued function) of two arguments. 
	boolean test(T t, U u)

DoublePredicate
--------------
Represents a predicate (boolean-valued function) of one double-valued argument. 
	boolean test(double value)

IntPredicate
-----------
 Represents a predicate (boolean-valued function) of one int-valued argument. 
 	boolean test(int value)

LongPredicate
-----------
Represents a predicate (boolean-valued function) of one long-valued argument. 
	boolean test(long value)




Reference :   

http://ocpj8.javastudyguide.com/ch10.html
https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
http://www.java2s.com/Tutorials/Java/java.util.function/BiConsumer/index.htm
