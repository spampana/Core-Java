Abstract Factory Design Pattern
-------------------------------

Abstract Factory pattern is almost similar to Factory Pattern except the fact that its more like factory of factories.



Abstract Factory Design Pattern Benefits
---------------------------------------
Abstract Factory design pattern provides approach to code for interface rather than implementation.
Abstract Factory pattern is “factory of factories” and can be easily extended to accommodate more products, for example we can add another sub-class Laptop and a factory LaptopFactory.
Abstract Factory pattern is robust and avoid conditional logic of Factory pattern.


Abstract Factory Design Pattern Examples in JDK
-----------------------------------------------
javax.xml.parsers.DocumentBuilderFactory#newInstance()
javax.xml.transform.TransformerFactory#newInstance()
javax.xml.xpath.XPathFactory#newInstance()