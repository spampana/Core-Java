Java8 Stream
=============

A stream does not store data and, in that sense, is not a data structure. It also never modifies the underlying data source.

stream operations are divided into intermediate and terminal operations.

A stream pipeline consists of a stream source, followed by zero or more intermediate operations, and a terminal operation.

Computation on the source data is only performed when the terminal operation is initiated, and source elements are consumed only as needed.

All intermediate operations are lazy, so they’re not executed until a result of a processing is actually needed.



java 8 Stream reduce method
===========================
A reduction operation takes a sequence of input elements and combines them into a single summary result by repeated application of a combining operation. 

The Stream.reduce() method comes with three variations.

Stream.reduce() with Accumulator
--------------------------------
It performs a reduction on the elements of the given stream, using given accumulation function.

 Stream.of(10,20,22,12,14).reduce((x,y)->x+y).ifPresent(System.out::println); // output : 78
 
10+20 = 30
30+22 = 52
52+12 = 64
64+14 = 78
 
Stream.reduce() with Identity and Accumulator
---------------------------------------------
It performs a reduction on the elements of the given stream, using given identity value and an accumulation function. Here the identity is a starting value.

Integer arrSum = Stream.of(10,20,22,12,14).reduce(1000, Integer::sum);
System.out.println(arrSum); //1078

1000+10 = 1010
1010+20 = 1030
1030+22 = 1052
1052+12 = 1064
1064+14 = 1078

Stream.reduce() with Identity, Accumulator and Combiner
-------------------------------------------------------
It performs a reduction on the elements of the given stream, using given identity value, an accumulation function and combining functions. 

The identity value must be an identity for the combiner function. 
Combiner is a function which aggregates results of the accumulator. 
Combiner is called only in a parallel mode to reduce results of accumulators from different threads.

When a stream executes in parallel, the Java runtime splits the stream into multiple sub-streams. In such cases, we need to use a function to combine the results of the sub-streams into a single one. This is the role of the combiner

Integer arrSum = Stream.of(10, 20, 22, 12, 14).parallel().reduce(1000, (x, y) -> x + y, (p, q) -> {
			System.out.println("combiner called");
			return p + q;
		});
		
System.out.println(arrSum);


combiner called
combiner called
combiner called
combiner called
5078

		

Java 8 Streams peek()
====================

Intermediate vs. Terminal Operations
-------------------------------------
Recall that streams have three parts: a data source, zero or more intermediate operations, and zero or one terminal operation.

The source provides the elements to the pipeline.

Intermediate operations get elements one-by-one and process them. 
All intermediate operations are lazy, and, as a result, no operations will have any effect until the pipeline starts to work.

Terminal operations mean the end of the stream lifecycle. 
Most importantly for our scenario, they initiate the work in the pipeline.

Javadoc page says: “This method exists mainly to support debugging, where you want to see the elements as they flow past a certain point in a pipeline“.


Stream.of("one", "two", "three", "four")
  .filter(e -> e.length() > 3)
  .peek(e -> System.out.println("Filtered value: " + e))
  .map(String::toUpperCase)
  .peek(e -> System.out.println("Mapped value: " + e))
  .collect(Collectors.toList());
  
  output:
  
 	Filtered value: three
	Mapped value: THREE
	Filtered value: four
	Mapped value: FOUR
  

On top of that, peek() can be useful in another scenario: when we want to alter the inner state of an element. For example, let’s say we want to convert all user’s name to lowercase before printing them:


Stream<User> userStream = Stream.of(new User("Alice"), new User("Bob"), new User("Chuck"));
userStream.peek(u -> u.setName(u.getName().toLowerCase()))
  .forEach(System.out::println);

https://stackify.com/streams-guide-java-8/
