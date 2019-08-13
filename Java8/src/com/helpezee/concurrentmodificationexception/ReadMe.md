java.util.ConcurrentModificationException
========================================

Java Collection classes are fail-fast, which means if the Collection will be changed while some thread is traversing over 
it using iterator, the iterator.next() will throw ConcurrentModificationException. 

Concurrent modification exception can come in case of multithreaded as well as a single threaded java programming environment.

Reference 

https://www.journaldev.com/378/java-util-concurrentmodificationexception
http://technicalstack.com/concurrenthashmap/
http://www.codesuggestions.com/java/java-the-concurrenthashmap-class-tutorial/
https://www.baeldung.com/java-fail-safe-vs-fail-fast-iterator