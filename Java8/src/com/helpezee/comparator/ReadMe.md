Arrays.sort() vs Collections.sort()
====================================
Arrays.sort works for arrays which can be of primitive data type also. 
Collections.sort() works for objects Collections like ArrayList, LinkedList, etc.


Arrays.sort uses dual-pivot Quicksort on primitives. 
Collections.Sort, it uses a modified mergesort and offers guaranteed n log(n) performance.


Java 8 comes with a new API – parallelSort – with a similar signature to the Arrays.sort() API:

Behind the scenes of parallelSort(), it breaks the array into different sub-arrays (as per granularity in the algorithm of parallelSort).Each sub-array is sorted with Arrays.sort() in different threads so that sort can be executed in parallel fashion and are merged finally as a sorted array.

Java 8 comes with two new APIs useful for sorting – comparing() and thenComparing() in the Comparator interface.
These are quite handy for chaining of multiple conditions of the Comparator.


Note that the ForJoin common pool is used for executing these parallel tasks and then merging the results.


For Integer(Wrapper classes)  use Arrays.stream(arr)
For Int(Primitive Data types) use IntStream.of(arr)


Comparable
----------
Comparable interface enables the natural ordering of the classes it implements. 
It makes the classes comparable to it’s instances.

A class implementing Comparable interface must override compareTo() method in which it can specify the comparison logic between two instances of same class.

Lists (and arrays) of objects that implement this interface can be sorted automatically by Collections.sort() and Arrays.sort(). Objects that implement this interface will be automatically sort when put in a sorted map (as keys) or sorted set (as elements).

It is strongly recommended (though not required) that natural orderings be consistent with equals. 
Virtually all Java core classes that implement Comparable have natural orderings that are consistent with equals.

Comparator
----------

Many times we face situation where we do not seek natural ordering or class file unavialable for edit due to legacy code issue. 
In this case, we can take help of Comparator interface.

Comparator does not require to modify the source code of the class. 
We can create the comparison logic in separate class which implement Comparator interface and override it’s compare() method. 
Then pass this comparator to sort() methods along with list of custom objects.


Group by sorting
----------------
To sort a collection of objects on different fields (group by sort) using multiple comparators in chain. 
This chaining of comparators can be created using Comparator.comparing() and Comparator.thenComparing() methods.

Using Comparator.reversed
--------------------------
When invoked on an existing Comparator, the instance method Comparator.reversed returns a new Comparator that reverses the sort order of the original.

    Comparator<Employee> employeeNameComparator = Comparator.comparing(Employee::getName);
    Comparator<Employee> employeeNameComparatorReversed = employeeNameComparator.reversed();
    Arrays.sort(employees, employeeNameComparatorReversed);

Using Comparator.comparingInt
-----------------------------
There is also a function Comparator.comparingInt which does the same thing as Comparator.comparing, but it takes only int selectors.

	Comparator<Employee> employeeAgeComparator  = Comparator.comparingInt(Employee::getAge);
	  	Arrays.sort(employees, employeeAgeComparator);
	  	
Using Comparator.comparingLong
------------------------------
There is also a function Comparator.comparingLong which does the same thing as Comparator.comparing, but it takes only long selectors.

	Comparator<Employee> employeeMobileComparator = Comparator.comparingLong(Employee::getMobile);
      Arrays.sort(employees, employeeMobileComparator);    

Using Comparator.comparingDouble
--------------------------------
There is also a function Comparator.comparingDouble which does the same thing as Comparator.comparing, but it takes only double selectors.
	
	Comparator<Employee> employeeSalaryComparator = Comparator.comparingDouble(Employee::getSalary);
      Arrays.sort(employees, employeeSalaryComparator);

Considering Natural Order in Comparator
--------------------------------------

	Comparator<Employee> employeeNameComparator  = Comparator.<Employee> naturalOrder();
      Arrays.sort(employees, employeeNameComparator);

Using Reverse Natural Order
--------------------------

	Comparator<Employee> employeeNameComparator = Comparator.<Employee> reverseOrder();
      Arrays.sort(employees, employeeNameComparator);
    
Considering Null Values in Comparator
-------------------------------------
	
	Comparator<Employee> employeeNameComparator = Comparator.comparing(Employee::getName);
    Comparator<Employee> employeeNameComparator_nullFirst 
    	 =	Comparator.nullsFirst(employeeNameComparator);
    Arrays.sort(employeesArrayWithNulls, employeeNameComparator_nullFirst);
    
    
    Comparator<Employee> employeeNameComparator  = Comparator.comparing(Employee::getName);
    Comparator<Employee> employeeNameComparator_nullLast
      = Comparator.nullsLast(employeeNameComparator);
    Arrays.sort(employeesArrayWithNulls, employeeNameComparator_nullLast);
 
 
 Using Comparator.thenComparing
  ------------------------------
 The thenComparing function lets you set up lexicographical ordering of values by provisioning multiple sort keys in a particular sequence.
 
 		
    Comparator<Employee> employee_Age_Name_Comparator = 
 		Comparator.comparing(Employee::getAge).thenComparing(Employee::getName);
    Arrays.sort(someMoreEmployees, employee_Age_Name_Comparator);

    

