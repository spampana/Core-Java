http://www.oracle.com/technetwork/articles/java/juneau-generics-2255374.html
http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html

Generics
-------

There are many different use cases for generics. 

The class signature contains a type parameter section, which is enclosed within angle brackets (< >) after the class name

public class GenericContainer<T> {
...

Type parameters, also known as type variables, are used as placeholders to indicate that a type will be assigned to the class 
at runtime. There may be one or more type parameters, and they can be utilized throughout the class, as needed.
 By convention, type parameters are a single uppercase letter, and the letter that is used indicates the type of parameter 
 being defined. The following list contains the standard type parameters for each use case:

E: Element
K: Key
N: Number
T: Type
V: Value
S, U, V, and so on: Second, third, and fourth types in a multiparameter situation

Note:

It is not possible to use primitive types with generics; 
only reference types can be used. Autoboxing and unboxing make it possible to store and retrieve values to and from primitive types 
when working with generic objects.

According to the Oracle documentation, type inference is the Java compiler's ability to look at each method invocation and 
corresponding declaration to determine the type argument (or arguments) that make the invocation possible

A concept known as target typing allows the compiler to infer the type parameters of a generic invocation. 
The target type is the data type that the compiler expects, depending on the types used to instantiate a generic object, 
where the expression appears, and so forth.


Bounded Types
-------------

Oftentimes there are cases where we need to specify a generic type, but we want to control which types can be specified, rather than 
keeping the gate wide open. Bounded types can be used to restrict the bounds of the generic type by specifying the extends or the super
keyword in the type parameter section to restrict the type by using an upper bound or lower bound, respectively.

 For instance, if you wish to restrict a type to a specific type or to a subtype of that specific type, use the following notation:

<T extends UpperBoundType>

Similarly, if you wish to restrict a type to a specific type or to a supertype of that specific type, use the following notation:

<T super LowerBoundType>

public static <N extends Number> double add(N a, N b){
    double sum = 0;
    sum = a.doubleValue() + b.doubleValue();
    return sum;
} 


Wildcards
---------

In some cases, it is useful to write code that specifies an unknown type. The question mark (?) wildcard character can be used to 
represent an unknown type using generic code. Wildcards can be used with parameters, fields, local variables, and return types. 
However, it is a best practice to not use wildcards in a return type, because it is safer to know exactly what is being returned 
from a method.

Consider the case where we would like to write a method to verify whether a specified object exists within a specified List. 
We would like the method to accept two arguments: a List of unknown type as well as an object of any type. 

public static <T> void checkList(List<?> myList, T obj){
        if(myList.contains(obj)){
            System.out.println("The list contains the element: " + obj);
        } else {
            System.out.println("The list does not contain the element: " + obj);
        }
    }
