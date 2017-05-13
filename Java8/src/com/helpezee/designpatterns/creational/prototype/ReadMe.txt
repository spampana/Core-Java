Prototype Design Pattern
------------------------

Prototype design pattern is used when the Object creation is a costly affair and requires a lot of time and resources 
and you have a similar object already existing.

Suppose we have an Object that loads data from database. Now we need to modify this data in our program multiple times, 
so it’s not a good idea to create the Object using new keyword and load all the data again from database.

Prototype design pattern mandates that the Object which you are copying should provide the copying feature. 
It should not be done by any other class. However whether to use shallow or deep copy of the Object properties 
depends on the requirements and its a design decision.
