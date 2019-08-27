Key Points
========

JAVA is platform-independent language, the JVM is platform-dependent. 

Different JVM is designed for different OS and byte code is able to run on different OS.

// This program will successfully run prior to JDK 7 
public class Test  
{ 
    // static block 
    static
    { 
        System.out.println("Hello User"); 
    } 
} 

The myth about the file name and class name should be same only when the class is declared in public.

By default JVM always access the classpath classes while executing a program. 
JVM always go into the deep of classpath to search for a class or resource.

-d option: 
It is used to store the output to different directory. If we don’t use this option then the class file will be created in the src directory.
Ex: proj1/src>javac -d ../classes A.java

-cp option:
cp stands for classpath
Ex:proj2/src>javac -d ../classes -cp ../../proj1/lib MainClass.java


Is main method compulsory in Java?
==================================
Prior to JDK 7, the main method was not mandatory in a java program.

Can we have a variable name as one of the predefined class name in our program?
===============================================================================
Yes we can have it.you cannot use a keyword as name of a class, name of a variable nor the name of a folder used for package.

Which of the following methods can be invoked by an object of Pattern class?
============================================================================

methods which can be invoked by an object of java.util.regex.Pattern class
(from the available list) are: compile, matches and toString

What are the legal modifiers which the constructor can be declared with? 
========================================================================
public, private and protected are allowed
static, final and abstract are not allowed


JVM Shutdown Hook in Java
==========================
Shutdown Hooks are a special construct that allows developers to plug in a piece of code to be executed when the JVM is shutting down. 
This comes in handy in cases where we need to do special clean up operations in case the VM is shutting down.

All we have to do is simply write a class which extends the java.lang.Thread class, and provide the logic that we want to perform when the VM is 
shutting down, inside the public void run() method. 

Then we register an instance of this class as a shutdown hook to the VM by calling Runtime.getRuntime().addShutdownHook(Thread) method. 

If you need to remove a previously registered shutdown hook, the Runtime class provides the removeShutdownHook(Thread) method as well.

1. Shutdown Hooks may not be executed in some cases!
2. Once started, Shutdown Hooks can be forcibly stopped before completion.
3. We can have more than one Shutdown Hooks, but their execution order is not guaranteed.
4. We cannot register/unregister Shutdown Hooks within Shutdown Hooks
5. Once shutdown sequence starts, it can be stopped by Runtime.halt() only.
6. Using shutdown hooks require security permissions.


Java Identifiers
===============
In Java, an identifier can be a class name, method name, variable name or a label. For example :

public class Test
{
    public static void main(String[] args)
    {
        int a = 20;
    }
}

In the above java code, we have 5 identifiers namely :

Test : class name.
main : method name.
String : predefined class name.
args : variable name.
a :  variable name.
Rules for defining Java Identifiers

There are certain rules for defining a valid java identifier. 

The only allowed characters for identifiers are all alphanumeric characters([A-Z],[a-z],[0-9]), ‘$‘(dollar sign) and ‘_‘ (underscore).
For example “geek@” is not a valid java identifier as it contain ‘@’ special character.

Identifiers should not start with digits([0-9]). For example “123geeks” is a not a valid java identifier.

Java identifiers are case-sensitive.

There is no limit on the length of the identifier but it is advisable to use an optimum length of 4 – 15 letters only.

Reserved Words can’t be used as an identifier. For example “int while = 20;” is an invalid statement as while is a reserved word. 
There are 53 reserved words in Java.


enum in Java
============
Enums are used when we know all possible values at compile time.

The main objective of enum is to define our own data types(Enumerated Data Types).

Enum declaration can be done outside a Class or inside a Class but not inside a Method.


Important points of enum :
-------------------------

enum Color 
    { 
        RED, GREEN, BLUE; 
    } 

Every enum internally implemented by using Class.

/* internally above enum Color is converted to
class Color
{
     public static final Color RED = new Color();
     public static final Color BLUE = new Color();
     public static final Color GREEN = new Color();
}*/

Every enum constant represents an object of type enum.

enum type can be passed as an argument to switch statement.

Every enum constant is always implicitly public static final. 
Since it is static, we can access it by using enum Name. Since it is final, we can’t create child enums.

We can declare main() method inside enum. Hence we can invoke enum directly from the Command Prompt.

Enum and Inheritance :
---------------------

All enums implicitly extend java.lang.Enum class. As a class can only extend one parent in Java, so an enum cannot extend anything else.

toString() method is overridden in java.lang.Enum class,which returns enum constant name.

enum can implement many interfaces.


values(), ordinal() and valueOf() methods :
-------------------------------------------

These methods are present inside java.lang.Enum.

values() method can be used to return all values present inside enum.
Order is important in enums.By using ordinal() method, each enum constant index can be found, just like array index.
valueOf() method returns the enum constant of the specified string value, if exists.



StringBuffer appendCodePoint() Method
=======================================
The java.lang.StringBuffer.appendCodePoint(int cp)is the method which appends the string representation of the codePoint argument to this sequence.

Syntax :     public StringBuffer appendCodePoint(int cp)
Parameters : The method accepts a single parameter cp of integer type and refers to the Unicode code point.
Return Value : The method returns this object after appending the string represented by the codepoint.

// Java praogram to illustrate the java.lang.StringBuffer.appendCodePoint(int cp) 

import java.lang.*; 
  
public class Geeks { 
  
    public static void main(String[] args) 
    { 
  
        StringBuffer sbf = new StringBuffer("Geeksforgeeks"); 
        System.out.println("String buffer = " + sbf); 
  
        // Here it appends the CodePoint as String to the string buffer 
        sbf.appendCodePoint(65); 
        System.out.println("After appending CodePoint is = " + sbf); 
    } 
} 

Output:
s
String buffer = Geeksforgeeks
After appending CodePoint is = GeeksforgeeksA
