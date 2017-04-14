package com.helpezee.generics;

public class GenericContainer<T> {
	private T obj;

	public GenericContainer() {
	}

	// Pass type in as parameter to constructor
	public GenericContainer(T t) {
		obj = t;
	}

	/**
	 * @return the obj
	 */
	public T getObj() {
		return obj;
	}

	/**
	 * @param obj
	 *            the obj to set
	 */
	public void setObj(T t) {
		obj = t;
	}
}

// Generics could be used to develop a better solution using a container that
// can have a type assigned at instantiation, otherwise referred to as a generic
// type, allowing the creation of an object that can be used to store objects of
// the assigned type. A generic type is a class or interface that is
// parameterized over types, meaning that a type can be assigned by performing
// generic type invocation, which will replace the generic type with the
// assigned concrete type. The assigned type would then be used to restrict
// values being used within the container, which eliminates the requirement for
// casting, as well as provides stronger type-checking at compile time.