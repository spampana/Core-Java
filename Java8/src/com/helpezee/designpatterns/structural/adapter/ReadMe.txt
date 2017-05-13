
Adapter Design Pattern
----------------------

Adapter pattern works as a bridge between two incompatible interfaces.

Adapter patterns is a great pattern for connecting new code with Legacy code without having to change the 
working contract that was produce from legacy code initially.

Adapter design pattern is used so that two unrelated interfaces can work together. 
The object that joins these unrelated interface is called an Adapter.

One of the great real life example of Adapter design pattern is mobile charger. Mobile battery needs 3 volts to charge 
but the normal socket produces either 120V (US) or 240V (India). So the mobile charger works as an adapter between mobile charging socket and the wall socket.


Two Way Adapter Pattern
----------------------

While implementing Adapter pattern, there are two approaches – class adapter and object adapter – 
however both these approaches produce same result.


Class Adapter – This form uses java inheritance and extends the source interface, in our case Socket class.

Object Adapter – This form uses Java Composition and adapter contains the source object.



Adapter Design Pattern Example in JDK
--------------------------------------
Some of the adapter design pattern example I could easily find in JDK classes are;

java.util.Arrays#asList()
java.io.InputStreamReader(InputStream) (returns a Reader)
java.io.OutputStreamWriter(OutputStream) (returns a Writer)
