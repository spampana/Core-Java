it is important to learn that Java 8 Streams are designed in such a way that most of its stream operations returns Streams only. 
This help us creating chain of various stream operations. This is called as pipelining. 


Streams vs. Collections
-----------------------

All of us have watch online videos on youtube or some other such website. When you start watching video, 
a small portion of file is first loaded into your computer and start playing. You don’t need to download complete video before 
start playing it. This is called streaming. I will try to relate this concept with respect to collections and differentiate with 
Streams.

At the basic level, the difference between Collections and Streams has to do with when things are computed. 

A Collection is an in-memory data structure, which holds all the values that the data structure currently has—every element 
in the Collection has to be computed before it can be added to the Collection. 

A Stream is a conceptually fixed data structure, in which elements are computed on demand. This gives rise to significant 
programming benefits. The idea is that a user will extract only the values they require from a Stream, and these elements are 
only produced—invisibly to the user—as and when required. This is a form of a producer-consumer relationship.

In java, java.util.Stream represents a stream on which one or more operations can be performed. 
Stream operations are either intermediate or terminal. 
While terminal operations return a result of a certain type, 
intermediate operations return the stream itself so you can chain multiple method calls in a row. 
Streams are created on a source, e.g. a java.util.Collection like lists or sets (maps are not supported). 
Stream operations can either be executed sequential or parallel.

Based on above points, if we list down the various characteristics of Stream, they will be as follows:

Not a data structure
Designed for lambdas
Do not support indexed access
Can easily be outputted as arrays or lists
Lazy access supported
Parallelizable


Intermediate operations
----------------------

Intermediate operations return the stream itself so you can chain multiple method calls in a row. Let’s learn important ones.

A) filter()

Filter accepts a predicate to filter all elements of the stream. This operation is intermediate which enables us to call another stream operation (e.g. forEach) on the result.

memberNames.stream().filter((s) -> s.startsWith("A"))
                    .forEach(System.out::println);
                                 
Output: 
 
Amitabh
Aman

B) map()

The intermediate operation map converts each element into another object via the given function. The following example converts each string into an upper-cased string. But you can also use map to transform each object into another type.

memberNames.stream().filter((s) -> s.startsWith("A"))
                     .map(String::toUpperCase)
                     .forEach(System.out::println);
                             
Output: 
 
AMITABH
AMAN

C) sorted()

Sorted is an intermediate operation which returns a sorted view of the stream. The elements are sorted in natural order unless you pass a custom Comparator.

memberNames.stream().sorted()
                    .map(String::toUpperCase)
                    .forEach(System.out::println);
Output:
 
AMAN
AMITABH
LOKESH
RAHUL
SALMAN
SHAHRUKH
SHEKHAR
YANA
Keep in mind that sorted does only create a sorted view of the stream without manipulating the ordering of the backed collection. The ordering of memberNames is untouched.

D) distinct() : Filter Distinct Elements

Collection<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
 
// Get collection without duplicate i.e. distinct only
List<String> distinctElements = list.stream().distinct().collect(Collectors.toList());
 
//Let's verify distinct elements
System.out.println(distinctElements);
Output is:

[A, B, C, D]

Terminal operations
-------------------

Terminal operations return a result of a certain type instead of again a Stream.

A) forEach()

This method helps in iterating over all elements of a stream and perform some operation on each of them. The operation is passed as lambda expression parameter.

memberNames.forEach(System.out::println);
B) collect()

collect() method used to recieve elements from a sream and store them in a collection and metioned in parameter funcion.

List<String> memNamesInUppercase = memberNames.stream().sorted()
                            .map(String::toUpperCase)
                            .collect(Collectors.toList());
         
System.out.print(memNamesInUppercase);
 
Outpout: [AMAN, AMITABH, LOKESH, RAHUL, SALMAN, SHAHRUKH, SHEKHAR, YANA]
C) match()

Various matching operations can be used to check whether a certain predicate matches the stream. All of those operations are terminal and return a boolean result.

boolean matchedResult = memberNames.stream()
                    .anyMatch((s) -> s.startsWith("A"));
 
System.out.println(matchedResult);
 
matchedResult = memberNames.stream()
                    .allMatch((s) -> s.startsWith("A"));
 
System.out.println(matchedResult);
 
matchedResult = memberNames.stream()
                    .noneMatch((s) -> s.startsWith("A"));
 
System.out.println(matchedResult);
 
Output: 
 
true
false
false
D) count()

Count is a terminal operation returning the number of elements in the stream as a long.

long totalMatched = memberNames.stream()
                    .filter((s) -> s.startsWith("A"))
                    .count();
 
System.out.println(totalMatched);
 
Output: 2
E) reduce()

This terminal operation performs a reduction on the elements of the stream with the given function. The result is an Optional holding the reduced value.

Optional<String> reduced = memberNames.stream()
                    .reduce((s1,s2) -> s1 + "#" + s2);
 
reduced.ifPresent(System.out::println);
 
Output: Amitabh#Shekhar#Aman#Rahul#Shahrukh#Salman#Yana#Lokesh


Short-circuit operations
------------------------
Though, stream operations are performed on all elements inside a collection satisfying a predicate, It is often desired to break the operation whenever a matching element is encountered during iteration. In external iteration, you will do with if-else block. In internal iteration, there are certain methods you can use for this purpose. Let’s see example of two such methods:

A) anyMatch()

This will return true once a condition passed as predicate satisfy. It will not process any more elements.

boolean matched = memberNames.stream()
                    .anyMatch((s) -> s.startsWith("A"));
 
System.out.println(matched);
 
Output: true


B) findFirst()

It will return first element from stream and then will not process any more element.

String firstMatchedName = memberNames.stream()
                .filter((s) -> s.startsWith("L"))
                .findFirst().get();
 
System.out.println(firstMatchedName);
 
Output: Lokesh



Parallelism
-----------

With the Fork/Join framework added in Java SE 7, we have efficient machinery for implementing parallel operations in our applications. But implementing this framework is itself a complex task; and if not done right; is a source of complex multi-threading bugs having potential to crash the application. With the introduction of internal iteration, we got the possibility of operations to be done in parallel.

To enable parallelism, all you have to do is to create a parallel stream, instead of sequential stream. And to surprise you, this is really very easy. In any of above listed stream examples, anytime you want to particular job using multiple threads in parallel cores, all you have to call method parallelStream() method instead of stream() method.

public class StreamBuilders {
     public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
         for(int i = 1; i< 10; i++){
             list.add(i);
         }
         //Here creating a parallel stream
         Stream<Integer> stream = list.parallelStream();  
         Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
         System.out.print(evenNumbersArr);
     }
}
A key driver for this work is making parallelism more accessible to developers. While the Java platform provides strong support for concurrency and parallelism already, developers face unnecessary impediments in migrating their code from sequential to parallel as needed. Therefore, it is important to encourage idioms that are both sequential- and parallel-friendly. This is facilitated by shifting the focus towards describing what computation should be performed, rather than how it should be performed. It is also important to strike the balance between making parallelism easier but not going so far as to make it invisible. Making parallelism transparent would introduce non-determinism and the possibility of data races where users might not expect it.
