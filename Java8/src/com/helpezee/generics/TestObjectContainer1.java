package com.helpezee.generics;

import java.util.ArrayList;
import java.util.List;

public class TestObjectContainer1 {

	public static void main(String[] args) {
		ObjectContainer myObj = new ObjectContainer();

		// store a string
		myObj.setObj("Test");
		System.out.println("Value of myObj:" + myObj.getObj());
		// store an int (which is autoboxed to an Integer object)
		myObj.setObj(3);
		System.out.println("Value of myObj:" + myObj.getObj());

		List objectList = new ArrayList();
		objectList.add(myObj);
		// We have to cast and must cast the correct type to avoid
		// ClassCastException!
		String myStr = (String) ((ObjectContainer) objectList.get(0)).getObj();
		System.out.println("myStr: " + myStr);

	}

}
// it would not be the most suitable solution for our purpose, because it has
// the potential to cause exceptions down the road, since it is not type-safe
// and it requires you to use an explicit cast whenever the encapsulated object
// is retrieved.