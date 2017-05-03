http://www.oracle.com/technetwork/articles/java/juneau-generics-2255374.html
http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html

Generics
--------

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

    

Using Generics in Java SE 8 Constructs
---------------------------------------
We've seen how to use generics and why they are important. Now let's look at the use case for generics with respect 
to a new construct in Java SE 8, lambda expressions. Lambda expressions represent an anonymous function that implements 
the single abstract method of a functional interface. There are many functional interfaces available for use, and lots of them 
make use of generics. Let's take a look at an example.

Suppose we wanted to traverse over a list of book titles (Strings), and compare the titles so that we could return all titles 
that contained specified search words. We could do this by developing a method that accepts the list of book titles, 
along with the predicate that we wanted to use for performing the comparison. The Predicate functional interface can be used for 
comparison purposes, returning a boolean to indicate if a given object satisfies the requirements of a test. 
The Predicate interface can be used with objects of all types, because it has the following generic signature:

@FunctionalInterface
public interface Predicate<T>{
...
}

If we wished to traverse over each book title and look for those that contained the text "Java EE," we could pass contains("Java EE") as the predicate argument. The method shown in Listing 15 can be used to traverse a given list of book titles and apply such a predicate, printing out those titles that match. In this case, the accepted arguments are using generics to indicate a List of Strings and a predicate that will test each String.

public static void compareStrings(List<String> list, Predicate<String> predicate) {
    list.stream().filter((n) -> (predicate.test(n))).forEach((n) -> {
        System.out.println(n + " ");
    });
}    

The code below could be used to populate a list of book titles, and then print out all the book titles that contain the text "Java EE."

List<String> bookList = new ArrayList<>();
bookList.add("Java 8 Recipes");
bookList.add("Java EE 7 Recipes");
bookList.add("Introducing Java EE 7");
bookList.add("JavaFX 8:  Introduction By Example");
compareStrings(bookList, (n)->n.contains("Java EE"));